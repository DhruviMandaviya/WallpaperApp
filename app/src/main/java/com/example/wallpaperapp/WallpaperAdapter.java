package com.example.wallpaperapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class WallpaperAdapter extends  RecyclerView.Adapter<WallpaperViewHolder>{


    private Context context;
    private List<WallpaperModel> wallpaperModelList;

    public WallpaperAdapter(Context context,List<WallpaperModel> wallpaperModelList) {
        this.context = context;
        this.wallpaperModelList = wallpaperModelList;
    }

    @NonNull
    @Override
    public WallpaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.image_view,parent,false);
        return new WallpaperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperViewHolder holder,final int position) {
        Glide.with(context).load(wallpaperModelList.get(position).getMediumURL()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,FullscreenWallpaper.class).
                        putExtra("originalURL",wallpaperModelList.get(position).getOriginalURL()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return wallpaperModelList.size();
    }
}
class WallpaperViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;

    public WallpaperViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.image_viewHolder);
    }
}
