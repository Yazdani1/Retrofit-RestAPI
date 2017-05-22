package yazdaniscodelab.retrofit_restapi;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yazdani on 5/22/2017.
 */

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.MyHolder> {

    private static final String TAG =FlowerAdapter.class.getSimpleName();
    private List<Flower> mFlowerList;

    public FlowerAdapter(){

        mFlowerList=new ArrayList<>();

    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View myview= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        MyHolder myHolder=new MyHolder(myview);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        Flower flower=mFlowerList.get(position);
        holder.mFlowerName.setText(flower.getName());
        holder.mFlowerPrice.setText(Double.toString(flower.getPrice()));
        Picasso.with(holder.itemView.getContext())
                .load("http://services.hanselandpetal.com/photos/" +flower.getPhoto())
                .into(holder.mFlowerPhoto);
    }

    @Override
    public int getItemCount() {
        return mFlowerList.size();
    }

    public void addFlower(Flower flower){

        Log.d(TAG,flower.getPhoto());
        mFlowerList.add(flower);
        notifyDataSetChanged();

    }

    public static class MyHolder extends RecyclerView.ViewHolder{

        ImageView mFlowerPhoto;
        TextView mFlowerName;
        TextView mFlowerPrice;

        public MyHolder(View view){
            super(view);
            mFlowerPhoto=(ImageView)view.findViewById(R.id.flowerPhoto_xml);
            mFlowerName=(TextView)view.findViewById(R.id.flowerName_xml);
            mFlowerPrice=(TextView)view.findViewById(R.id.flowerPrice_xml);
        }
    }

}
