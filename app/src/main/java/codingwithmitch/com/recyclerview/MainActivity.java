package codingwithmitch.com.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //Array declaration
    ArrayList<Pokemon> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetCardsInfo getCardsInfo = new GetCardsInfo(MainActivity.this);
        arrayList = getCardsInfo.getList();
        Log.d(TAG, "onCreate: started.");
        initRecyclerView();
    }



    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}






















