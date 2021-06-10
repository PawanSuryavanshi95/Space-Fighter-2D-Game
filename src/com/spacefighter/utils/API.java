/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spacefighter.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pawan
 */
public class API {
    private String ENDPOINT;
    
    public API(String ENDPOINT){
        this.ENDPOINT = ENDPOINT;
    }
    
    public String postRequest(String route, String data){
        try{
            URL url = new URL(this.ENDPOINT + route);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            byte[] out = data.toString().getBytes(StandardCharsets.UTF_8);
            System.out.println(data);
            int length = out.length;
            con.setFixedLengthStreamingMode(length);
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.connect();
            try(OutputStream os = con.getOutputStream()) {
                os.write(out);
            }
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                }
                in.close();
                String data_in = response.toString();
                return data_in;
            }
            else{
                System.out.println("POST request not worked");
                return "problem in connection";
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return "error";
        }
        
    }
}
