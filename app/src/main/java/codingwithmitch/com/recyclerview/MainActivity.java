package codingwithmitch.com.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //Array declaration
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> imageUrl = new ArrayList<>();
    ArrayList<Integer> nationalPokedexNumber = new ArrayList<>();
    ArrayList<String> hp = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        initGetCardsInfo();
    }

    private void initGetCardsInfo(){

        //getting the Json object form API
        String json_url = "https://api.pokemontcg.io/v1/cards?count=20";


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, json_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray cards = response.getJSONArray("cards");
                    for (int i = 0; i < cards.length(); i++){
                        //acessing each object inside the Json array and adding the values of each property to its respective array
                        JSONObject cardsinfo = cards.getJSONObject(i);
                        name.add(cardsinfo.getString("name"));
                        imageUrl.add(cardsinfo.optString("imageUrl"));
                        nationalPokedexNumber.add(cardsinfo.optInt("nationalPokedexNumber"));
                        hp.add(cardsinfo.optString("hp"));
                        Log.d(TAG, "onResponse: caught "+ name.size());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            // initializing the recyclerViuew after the Json object is fully parsed
            initRecyclerView();
            }

            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });
        MySingleton.getmInstance(MainActivity.this).addToRequestQueue(jsonObjectRequest);

    }


    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, name, imageUrl, nationalPokedexNumber,hp);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
