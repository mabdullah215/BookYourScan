package com.spitel.bookyourscan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.spitel.bookyourscan.adapter.BottomPagerAdapter;
import com.spitel.bookyourscan.adapter.MainMenuAdapter;
import com.spitel.bookyourscan.adapter.MyViewPagerAdapter;

public class MainActivity extends AppCompatActivity
{
    private String[] imgList={"Diagnostics","Home Care","Doctor Appointment","Ambulance","Blood Bank","Pharmacy","Health Insurance","Crowd Funding"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewPager pager=findViewById(R.id.img_header);
        MyViewPagerAdapter pagerAdapter=new MyViewPagerAdapter(this);
        pager.setAdapter(pagerAdapter);

        final ViewPager bottompager=findViewById(R.id.bottom_footer);
        BottomPagerAdapter bottomPagerAdapter=new BottomPagerAdapter(this);
        bottompager.setAdapter(bottomPagerAdapter);


        ImageView imgHome=findViewById(R.id.img_home);

        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });

        MainMenuAdapter adapter=new MainMenuAdapter(this);
        RecyclerView mRecyclerView=findViewById(R.id.data_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MainMenuAdapter.OnItemClickListener()
        {
            @Override
            public void onItemClick(int position)
            {
                if(position==0)
                {
                   startActivity(new Intent(getBaseContext(),DiagnosticDetailsActivity.class));
                }
                else
                {
                    startActivity(new Intent(getBaseContext(),HomeItemDetails.class));
                }
            }
        });


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


        ImageView leftImgBottom=findViewById(R.id.img_bottom_left);
        ImageView rightImgBottom=findViewById(R.id.img_bottom_right);

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



    }



}
