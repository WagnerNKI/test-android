package com.example.noely.testeapi;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class main (String[] args) {
    String resposta = HttpConnections.get("https://api.pokemontcg.io/v1/cards?count=20");
    JSONObject obj = new JSONObject(resposta);
}}

public class HttpConnections {
    public static String get(String urlString){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resposta = null;

        try{
            URL url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            StringBuffer buffer = new StringBuffer();

            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }
            resposta= buffer.toString();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (urlConnection != null){
                urlConnection.disconnect();
            }
            try{
                reader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }return resposta;
    }
}

