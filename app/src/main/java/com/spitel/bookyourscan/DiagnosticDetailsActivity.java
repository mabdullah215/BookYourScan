package com.spitel.bookyourscan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.spitel.bookyourscan.adapter.BottomPagerAdapter;
import com.spitel.bookyourscan.adapter.DiagnosticsAdapter;
import com.spitel.bookyourscan.adapter.MainMenuAdapter;
import com.spitel.bookyourscan.adapter.MyViewPagerAdapter;

public class DiagnosticDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostic_details);

        TextView tvFirst=findViewById(R.id.tv_first);
        TextView tvSecond=findViewById(R.id.tv_second);
        TextView tvThird=findViewById(R.id.tv_third);



        tvFirst.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showAlert();
            }
        });

        tvSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                showAlert();
            }
        });

        tvThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                showAlert();
            }
        });

        final ViewPager pager=findViewById(R.id.img_header);
        MyViewPagerAdapter pagerAdapter=new MyViewPagerAdapter(this);
        pager.setAdapter(pagerAdapter);

        final ViewPager bottompager=findViewById(R.id.bottom_footer);
        BottomPagerAdapter bottomPagerAdapter=new BottomPagerAdapter(this);
        bottompager.setAdapter(bottomPagerAdapter);

        ImageView leftImgBottom=findViewById(R.id.img_bottom_left);
        ImageView rightImgBottom=findViewById(R.id.img_bottom_right);

        ImageView leftImg=findViewById(R.id.img_left);
        ImageView rightImg=findViewById(R.id.img_right);

        leftImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                pager.setCurrentItem(pager.getCurrentItem()-1);
            }
        });

        rightImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                pager.setCurrentItem(pager.getCurrentItem()+1);
            }
        });



        leftImgBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                bottompager.setCurrentItem(bottompager.getCurrentItem()-1);
            }
        });

        rightImgBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                bottompager.setCurrentItem(bottompager.getCurrentItem()+1);
            }
        });


        ImageView imgHome=findViewById(R.id.img_home);

        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finish();

            }
        });



    }

    private void showAlert()
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose scan");

        String[] animals = {"Dummy Content 1", "Dummy Content 2", "Dummy Content 3", "Dummy Content 4", "Dummy Content 5"};
        builder.setItems(animals, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which)
                {
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }

}
