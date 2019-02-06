package com.example.ayo.roomsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import Entity.Word;

public class wordAdapter extends RecyclerView.Adapter<wordAdapter.wordViewHolder> {

    private LayoutInflater mInflater;
    private List<Word> mWords;

    public wordAdapter(Context context){
        //we initialised the layout inflater in the constructor
        mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public wordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = mInflater.inflate(R.layout.recycler_item_list, viewGroup, false);
        return new wordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull wordAdapter.wordViewHolder wordViewHolder, int position) {
    if(mWords != null){
      Word current = mWords.get(position);
      wordViewHolder.wordText.setText(current.getWorld());
    }else{  wordViewHolder.wordText.setText("NO word");  }
    }


    public void setResult(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mWords != null){
            return mWords.size();
        }else{  return 0; }

    }

    class wordViewHolder extends RecyclerView.ViewHolder{

        TextView wordText;

        public wordViewHolder(@NonNull View itemView) {
            super(itemView);

            wordText = itemView.findViewById(R.id.textView);
        }
    }
}
