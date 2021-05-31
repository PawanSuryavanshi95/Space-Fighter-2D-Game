from flask import Flask, render_template, request, redirect, jsonify
from flask_sqlalchemy import SQLAlchemy
from datetime import datetime
import json

app = Flask(__name__)

app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///test.db'

db = SQLAlchemy(app)

class Score(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(25), nullable=False)
    score = db.Column(db.Integer, default=0)
    kills = db.Column(db.Integer, default=0)
    date = db.Column(db.DateTime, default=datetime.utcnow)

    def __repr__(self):
        return '<Task %r>' % self.id

@app.route('/')
def index():
    scores = Score.query.order_by(Score.score.desc()).all()
    return render_template('index.html', scores=scores)

@app.route('/upload', methods= ['POST'])
def upload():
    data = json.loads(request.data)
    id = db.session.query(Score.id).filter_by(name=data["name"]).first()
    print(id)
    if id is not None:
        score = Score.query.get(id[0])
        score.score = data["score"]
        score.kills = data["kills"]
        score.date = datetime.utcnow()
        
        try:
            db.session.commit()
            return "done"
        except:
            return "not done"
    else:
        newScore = Score(kills=data["kills"], score=data["score"], name=data["name"])
        try:
            db.session.add(newScore)
            db.session.commit()
            return "done"
        except:
            return "not done"

@app.route('/highscores')
def highscores():
    scores = Score.query.order_by(Score.score.desc()).limit(10).all()
    print('yo')
    out = ""
    for score in scores:
        out = out + str(str(score.score)+";"+str(score.kills)+";"+str(score.name)+";"+str(score.id)) + "#"
    #out = out + best
    return out

if __name__ == '__main__':
    app.run(debug=True)