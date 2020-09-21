package com.example.wallpaperapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    WallpaperAdapter wallpaperAdapter;
    List<WallpaperModel> wallpaperModelList;
    int PageNumber=1;
    boolean isScrolling= false;
    int currentItem, totalItem, scrollingOutItem;
    String uri="https://api.pexels.com/v1/curated/?page="+PageNumber+"&per_page=80";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);
        wallpaperModelList=new ArrayList<>();
        wallpaperAdapter=new WallpaperAdapter(this,wallpaperModelList);

        recyclerView.setAdapter(wallpaperAdapter);

        final GridLayoutManager gridLayoutManager= new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView,int newState) {
                super.onScrollStateChanged(recyclerView,newState);

                if(newState== AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isScrolling=true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView,int dx,int dy) {
                super.onScrolled(recyclerView,dx,dy);
                currentItem=gridLayoutManager.getChildCount();
                totalItem=gridLayoutManager.getItemCount();
                scrollingOutItem=gridLayoutManager.findFirstVisibleItemPosition();

                if(isScrolling &&(totalItem==currentItem+scrollingOutItem))
                {
                    isScrolling=false;
                    FetchWallpaper();
                }

            }
        });
        FetchWallpaper();
    }

    public void FetchWallpaper()
    {

        StringRequest request= new StringRequest(Request.Method.GET,uri,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject= new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("photos");

                            int length = jsonArray.length();

                            for(int i=0;i<length;i++)
                            {
                                JSONObject object= jsonArray.getJSONObject(i);

                                int id=object.getInt("id");

                                JSONObject objectImage=object.getJSONObject("src");

                                String ordinalUrl=objectImage.getString("original");
                                String mediumURL=objectImage.getString("medium");

                                WallpaperModel wallpaperModel=new WallpaperModel(id,ordinalUrl,mediumURL);
                                wallpaperModelList.add(wallpaperModel);
                            }
                            wallpaperAdapter.notifyDataSetChanged();
                            PageNumber++;
                        }
                        catch (JSONException ignored)
                        {

                        }

                    }
                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("Authorization","563492ad6f91700001000001914986c0951d407c817f8156adcd2538");
                return params;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.nav_search)
        {
            AlertDialog.Builder alert= new AlertDialog.Builder(this);
            final EditText editText= new EditText(this);
            editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER );

            alert.setTitle("Search Wallpaper");
            alert.setMessage("Search Wallpaper e.g. Nature");

            alert.setView(editText);

            alert.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface,int i) {

                    String query= editText.getText().toString().toLowerCase();

                    uri="https://api.pexels.com/v1/search/?page="+PageNumber+"&per_page=80&query="+query;

                    wallpaperModelList.clear();
                    FetchWallpaper();

                }
            });

            alert.setNegativeButton("No",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface,int i) {

                }
            });

            alert.show();
        }
        return super.onOptionsItemSelected(item);

    }
}
