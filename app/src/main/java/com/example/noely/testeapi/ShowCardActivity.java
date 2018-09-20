package com.example.noely.testeapi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class ShowCardActivity extends AppCompatActivity{
    private static final String TAG = "ShowCardActivity";

    @Override
    protected void  onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showcard);
        Log.d(TAG, "onCreate: started.");
    }

    private void getIncomingIntent (){
        Log.d(TAG, "getIncomingIntent: checking for intent");

        if(getIntent().hasExtra("name")){
            Log.d(TAG, "getIncomingIntent: found intent extras");

            String name = getIntent().getStringExtra("name");
        }
    }
    private void setImage(String imageURL){
        Log.d(TAG, "setImage: setting image");

        TextView name = findViewById(R.id.name);

    }
}
