package com.example.simplegreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder>{
    private int[] dataSet;

    public static  class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView textView;

        public ViewHolder(View view){
            super(view);
            textView = (TextView) view.findViewById(R.id.textView);
        }
        public TextView getTextView(){
            return textView;
        }
    }

    public myAdapter(int[] data){
        dataSet = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view, viewGroup, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position){
        viewHolder.getTextView().setText(Integer.toString(dataSet[position]));
    }

    @Override
    public int getItemCount(){
        return dataSet.length;
    }
}
