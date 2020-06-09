package com.spitel.bookyourscan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.spitel.bookyourscan.adapter.MainMenuAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainMenuAdapter adapter=new MainMenuAdapter(this);
        RecyclerView mRecyclerView=findViewById(R.id.data_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,4));
        mRecyclerView.setAdapter(adapter);
    }
}
