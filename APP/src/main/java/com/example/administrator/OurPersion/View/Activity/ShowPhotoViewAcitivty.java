package com.example.administrator.OurPersion.View.Activity;


import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.administrator.OurPersion.Application.AndroidApplication;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.R;

import uk.co.senab.photoview.PhotoView;

public class ShowPhotoViewAcitivty extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplication application = (AndroidApplication) getApplication();
        application.addactivity(ShowPhotoViewAcitivty.this);
        setContentView(R.layout.activity_show_photo_view);
        PhotoView photoView = (PhotoView) findViewById(R.id.photoview_show);
        String image = getIntent().getStringExtra("imagepath");
        Glide.with(ShowPhotoViewAcitivty.this).load(OkHttpURL.ImageURL + image).into(photoView);
        String oldmanimage = getIntent().getStringExtra("oldmanimage");
        Glide.with(ShowPhotoViewAcitivty.this).load(oldmanimage).into(photoView);
        String firstmainoldmanimage = getIntent().getStringExtra("firstmainoldmanimage");
        Glide.with(ShowPhotoViewAcitivty.this).load(oldmanimage).into(photoView);
    }
}
