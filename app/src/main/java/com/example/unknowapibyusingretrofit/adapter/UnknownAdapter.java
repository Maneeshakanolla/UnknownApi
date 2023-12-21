package com.example.unknowapibyusingretrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unknowapibyusingretrofit.R;
import com.example.unknowapibyusingretrofit.model.Datum;

import java.util.ArrayList;

public class UnknownAdapter extends RecyclerView.Adapter<UnknownAdapter.UnknownViewHolder> {
    private ArrayList<Datum> datumArrayList;
    Context context;

    public UnknownAdapter(ArrayList<Datum> datumArrayList, Context context) {
        this.datumArrayList = datumArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public UnknownAdapter.UnknownViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list,parent,false);
        return new UnknownViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UnknownAdapter.UnknownViewHolder holder, int position) {
        holder.textView.setText(datumArrayList.get(position).getId().toString());
        holder.textView1.setText(datumArrayList.get(position).getName());
        holder.textView2.setText(datumArrayList.get(position).getYear().toString());
        holder.textView3.setText(datumArrayList.get(position).getColor());
        holder.textView4.setText(datumArrayList.get(position).getPantoneValue());




    }

    @Override
    public int getItemCount() {
        return datumArrayList.size();
    }

    public class UnknownViewHolder extends RecyclerView.ViewHolder {
        TextView textView,textView1,textView2,textView3,textView4;
        CardView cardView;
        public UnknownViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.id);
            textView1=itemView.findViewById(R.id.name);
            textView2=itemView.findViewById(R.id.color);
            textView3=itemView.findViewById(R.id.value);
            textView4=itemView.findViewById(R.id.year);
        }
    }
}