package com.ama.tourism_svg.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.PixelCopy;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ama.tourism_svg.Objects.PictureText;
import com.ama.tourism_svg.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class PictureTextAdapter extends RecyclerView.Adapter<PictureTextAdapter.MyViewHolder> {

    private Context context;
    private List<PictureText> pictureTextList;

    public PictureTextAdapter(Context context, List<PictureText> pictureTextList) {
        this.context = context;
        this.pictureTextList = pictureTextList;
    }

    @NonNull
    @Override
    public PictureTextAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_picturetext_tall, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PictureTextAdapter.MyViewHolder holder, int position) {
        PictureText card = pictureTextList.get(position);

        holder.title.setText(card.getTitle());
        Glide.with(context).load(card.getBackground()).into(holder.background);
    }

    @Override
    public int getItemCount() {
        return pictureTextList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView background;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.card_title);
            background = (ImageView) itemView.findViewById(R.id.card_background);
        }
    }

}
