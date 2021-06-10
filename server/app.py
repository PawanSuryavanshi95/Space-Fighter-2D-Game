from flask import Flask, render_template, request, redirect, jsonify
from flask_sqlalchemy import SQLAlchemy
from datetime import datetime
import json
import hashlib
import os


def hash(password, salt = os.urandom(32)):
    key = hashlib.pbkdf2_hmac(
        'sha256', # The hash digest algorithm for HMAC
        password.encode('utf-8'), # Convert the password to bytes
        salt, # Provide the salt
        100000 # It is recommended to use at least 100,000 iterations of SHA-256 
    )
    hashed = key+salt
    return hashed

app = Flask(__name__)

app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///test.db'

db = SQLAlchemy(app)

class Player(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(25), nullable=False, unique=True)
    password = db.Column(db.String(50),nullable=False)
    score = db.Column(db.Integer, default=0)
    kills = db.Column(db.Integer, default=0)
    date = db.Column(db.DateTime, default=datetime.utcnow)

    def __repr__(self):
        return '<Task %r>' % self.id

@app.route('/')
def index():
    players = Player.query.order_by(Player.score.desc()).all()
    return render_template('index.html', players=players)

@app.route('/register', methods= ['POST'])
def register():
    data = json.loads(request.data)
    print(data)
    x = Player.query.filter_by(username=data["username"]).first()
    if x is not None:
        return "username already exists"
    newPlayer = Player(password=hash(data["password"]), username=data["username"])
    try:
        db.session.add(newPlayer)
        db.session.commit()
        print("registered")
        return "done"
    except:
        return "not done"

@app.route('/login', methods= ['POST'])
def login():
    data = json.loads(request.data)
    player = Player.query.filter_by(username=data["username"]).first()
    if player is None:
        return "user don't exist"
    password = player.password
    salt = password[32:]
    hashed = hash(data['password'], salt)
    if hashed==password:
        out = "1;" + data["username"]
        return out
    else:
        return "0;notoken"

@app.route('/upload', methods= ['POST'])
def upload():
    data = json.loads(request.data)
    print(data["token"])
    id = db.session.query(Player.id).filter_by(username=data["token"]).first()
    print(id)
    if id is not None:
        player = Player.query.get(id[0])
        player.score = data["score"]
        player.kills = data["kills"]
        player.date = datetime.utcnow()

        try:
            db.session.commit()
            return "uploaded"
        except:
            return "not uploaded"
        
    else:
        return "player not found"

@app.route('/highscores', methods= ['POST'])
def highscores():
    data = json.loads(request.data)
    players = Player.query.order_by(Player.score.desc()).limit(10).all()
    print(data)
    player = Player.query.filter_by(username=data["token"]).first()
    best = str(player.score) + ";" + str(player.kills)
    out = ""
    for player in players:
        out = out + str(str(player.score)+";"+str(player.kills)+";"+str(player.username)+";"+str(player.id)) + "#"
    out = out + str(best)
    return out

if __name__ == '__main__':
    app.run(debug=True)