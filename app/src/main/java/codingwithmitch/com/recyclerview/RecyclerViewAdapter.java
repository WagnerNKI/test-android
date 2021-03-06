package codingwithmitch.com.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


/**
 * Created by User on 1/1/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> rName = new ArrayList<>();
    private ArrayList<String> rImageUrl = new ArrayList<>();
    private static ArrayList<Integer> rNationalPokedexNumber = new ArrayList<>();
    private static ArrayList<String> rHp = new ArrayList<>();
    private Context mContext;
    private static int passPosition;


    public RecyclerViewAdapter(Context context, ArrayList<String> name, ArrayList<String> imageUrl, ArrayList<Integer> nationalPokedexNumber, ArrayList<String> hp) {
    rName = name;
    rImageUrl = imageUrl;
    rNationalPokedexNumber = nationalPokedexNumber;
    rHp = hp;
    mContext = context;
    }

    //methods for getting the HP and Pokedex number of clicked Pokemon
    public static String getHp() {
        return rHp.get(passPosition);
    }

    public static int getNationalPokedexNumber(){
        return rNationalPokedexNumber.get(passPosition);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: Created");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    // binding the list of itens in the screen
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.pkname.setText(rName.get(position));

        //trigger event when Pokemon name is clicked
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + rName.get(position));

                Toast.makeText(mContext, rName.get(position), Toast.LENGTH_SHORT).show();

                //assigning the position that was clicked so HP and Pokedx number can be transfered to the Gallery Activity
                passPosition = position;

                //sending name and image URL of clicked Pokemon to Gallery Activity
                Intent intent = new Intent(mContext, GalleryActivity.class);
                intent.putExtra("image_url", rImageUrl.get(position));
                intent.putExtra("image_name", rName.get(position));

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rName.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView pkname;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            pkname = itemView.findViewById(R.id.pkname);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
