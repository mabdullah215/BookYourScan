package com.spitel.bookyourscan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.spitel.bookyourscan.adapter.BottomPagerAdapter;
import com.spitel.bookyourscan.adapter.MyViewPagerAdapter;

public class HomeItemDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_item_details);


        final ViewPager bottompager=findViewById(R.id.bottom_footer);
        BottomPagerAdapter bottomPagerAdapter=new BottomPagerAdapter(this);
        bottompager.setAdapter(bottomPagerAdapter);

        final ViewPager pager=findViewById(R.id.img_header);
        MyViewPagerAdapter pagerAdapter=new MyViewPagerAdapter(this);
        pager.setAdapter(pagerAdapter);
        ImageView imgHome=findViewById(R.id.img_home);

        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finish();
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


    }
}