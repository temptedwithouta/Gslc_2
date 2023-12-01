package com.example.gslc_2;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private ArrayList<University> universityList;

    private Context context;

    public RecyclerViewAdapter(ArrayList<University> universityList, Context context){
        this.universityList = universityList;

        this.context = context;
    }

    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int position){
        University university = universityList.get(position);

        viewHolder.nameTV.setText(university.getName());

        viewHolder.locationTV.setText(university.getLocation());

        if(university.getLocation().toLowerCase().contains("alamsutera")){
            viewHolder.itemView.setBackgroundResource(R.drawable.alam_sutera);
        }
        else if(university.getLocation().toLowerCase().contains("anggrek")){
            viewHolder.itemView.setBackgroundResource(R.drawable.anggrek);
        }
        else if(university.getLocation().toLowerCase().contains("bandung")){
            viewHolder.itemView.setBackgroundResource(R.drawable.bandung);
        }
        else if(university.getLocation().toLowerCase().contains("bekasi")){
            viewHolder.itemView.setBackgroundResource(R.drawable.bekasi);
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(context, MapActivity.class);

                intent.putExtra("title", university.getName() + " " + university.getLocation());

                intent.putExtra("latitude", university.getLatitude());

                intent.putExtra("longitude", university.getLongitude());

                context.startActivity(intent);
            }
        });
    }

    public int getItemCount(){
        int universityListSize = universityList.size();

        return universityListSize;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameTV;

        TextView locationTV;

        public ViewHolder(View itemView){
            super(itemView);

            nameTV = itemView.findViewById(R.id.nameTV);

            locationTV = itemView.findViewById(R.id.locationTV);
        }
    }
}
