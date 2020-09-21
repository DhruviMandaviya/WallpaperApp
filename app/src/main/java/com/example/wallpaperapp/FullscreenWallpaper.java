package com.example.wallpaperapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import java.io.IOException;

public class FullscreenWallpaper extends AppCompatActivity {

    String  ordinalUrl="";
    PhotoView photoView;
    Button Set_Wallpaper_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_wallpaper);

        Set_Wallpaper_btn=findViewById(R.id.Set_walllpaper_btn);
        Intent intent= getIntent();
        ordinalUrl=intent.getStringExtra("originalURL");

        photoView= findViewById(R.id.photoView);
        Glide.with(this).load(ordinalUrl).into(photoView);
    }

    public void SetWallpaperEvent(View view) {
        WallpaperManager wallpaperManager= WallpaperManager.getInstance(this);
        Bitmap bitmap=((BitmapDrawable)photoView.getDrawable()).getBitmap();
        try {
            wallpaperManager.setBitmap(bitmap);

        }catch (IOException e)
        {
            e.printStackTrace();
        }
        Toast.makeText(this,"Wallpaper set...",Toast.LENGTH_SHORT).show();
    }

    public void DownloadWallpaperEvent(View view) {

        DownloadManager downloadManager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri=Uri.parse(ordinalUrl);
        DownloadManager.Request request= new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        downloadManager.enqueue(request);
        Toast.makeText(this,"Downloading....",Toast.LENGTH_SHORT).show();


    }
}
