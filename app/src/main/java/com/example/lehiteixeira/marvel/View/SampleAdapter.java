package com.example.lehiteixeira.marvel.View;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lehiteixeira.marvel.Data.model.CharacterMarvel;
import com.example.lehiteixeira.marvel.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.ViewHolder> {

    private List<CharacterMarvel> myList;

    public SampleAdapter(List<CharacterMarvel> myList) {
        this.myList = myList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(myList.get(position).getName());
        Picasso.with(holder.itemView.getContext()).load(myList.get(position).getImageUrl()).fit().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView mImageView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.character_name);
            mImageView = (ImageView) itemView.findViewById(R.id.character_image);
        }
    }

    public void addItems(List<CharacterMarvel> itemsList) {
        myList.addAll(itemsList);
        notifyItemRangeInserted(getItemCount(), myList.size() - 1);
    }
}
