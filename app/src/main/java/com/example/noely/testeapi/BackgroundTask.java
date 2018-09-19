package com.example.noely.testeapi;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BackgroundTask {

    Context context;
    ArrayList<Pokemon> arrayList = new ArrayList<>();
    String json_url = "https://api.pokemontcg.io/v1/cards?count=20";
    public BackgroundTask (Context context){
        this.context = context;
    }

    public ArrayList<Pokemon> getArrayList() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, json_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                int count = 0;

                while (count < response.length()){
                    try {
                        JSONObject jsonObject = response.getJSONObject(count);
                        Pokemon pokemon = new Pokemon(jsonObject.getString("Name"));
                        arrayList.add(pokemon);
                        count++;

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"Error",Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        }
        );

        MySingleton.getmInstance(context).addToRequestQueue(jsonArrayRequest);

        return arrayList;
    }
}
