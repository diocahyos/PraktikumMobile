package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHero = findViewById(R.id.activitymain_rv);
        rvHero.setHasFixedSize(true);

        rvHero.setLayoutManager(new LinearLayoutManager(this)); // Memilih tipe Layout
        HeroesAdapter heroesAdapter = new HeroesAdapter(getApplicationContext()); // Memnaggil Class Adapter

        heroesAdapter.setHeroesList(HeroesData.getHeroList()); // Mengambil data yang ada pada adapter

        rvHero.setAdapter(heroesAdapter);
    }
}
