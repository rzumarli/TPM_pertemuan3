package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvPahlawan;
    private ArrayList<ModelPahlawan> listPahlawan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPahlawan = findViewById(R.id.rv_pahlawan);
        rvPahlawan.setHasFixedSize(true);
        listPahlawan.addAll(DataPahlawan.getListData());

        recyclerView();
    }

    private void recyclerView() {
        rvPahlawan.setLayoutManager(new LinearLayoutManager(this));
        final AdapterPahlawan adapterPahlawan = new AdapterPahlawan(this);
        adapterPahlawan.setListPahlawan(listPahlawan);
        rvPahlawan.setAdapter(adapterPahlawan);

        adapterPahlawan.setOnItemClickCallback(new AdapterPahlawan.OnItemClickCallback() {
            @Override
            public void onItemClicked(ModelPahlawan pahlawan) {
                Toast.makeText(MainActivity.this, "Memilih "+pahlawan.getHeroName(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_DATA,pahlawan);
                startActivity(intent);
            }
        });
    }
}
