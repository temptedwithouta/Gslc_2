package com.example.gslc_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.GridLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView universityRV;

    private ArrayList<University> universityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createData();

        universityRV = findViewById(R.id.universityRV);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(universityList, this);

        universityRV.setLayoutManager(new GridLayoutManager(this, 2));

        universityRV.setAdapter(adapter);
    }

    public void createData(){
        universityList = new ArrayList<>();

        University university1 = new University("@AlamSutera", "-6.22366", "106.64924");

        University university2 = new University("@Anggrek", "-6.20071", "106.78251");

        University university3 = new University("@Bandung", "-6.91320", "107.59407");

        University university4 = new University("@Bekasi", "-6.21936", "106.99986");

        universityList.add(university1);

        universityList.add(university2);

        universityList.add(university3);

        universityList.add(university4);
    }
}