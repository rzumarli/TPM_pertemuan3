package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_DATA = "extra_data";
    private ImageView ivPhoto;
    private TextView tvName, tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivPhoto = findViewById(R.id.iv_photo_detail);
        tvName = findViewById(R.id.tv_name_detail);
        tvDescription = findViewById(R.id.tv_description_detail);


        ModelPahlawan pahlawan = getIntent().getParcelableExtra(EXTRA_DATA);
        int image = pahlawan.getHeroesImages();
        String name = pahlawan.getHeroName();
        String description = pahlawan.getHeroDetails();

        if (pahlawan!=null){
            Glide.with(this).load(image).into(ivPhoto);
            tvName.setText(name);
            tvDescription.setText(description);
        }

    }
}
