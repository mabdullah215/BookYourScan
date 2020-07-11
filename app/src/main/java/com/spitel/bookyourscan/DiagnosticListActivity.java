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
import com.spitel.bookyourscan.adapter.DiagnosticsAdapter;
import com.spitel.bookyourscan.adapter.MyViewPagerAdapter;

public class DiagnosticListActivity extends AppCompatActivity
{
    private String[] titleList={"MRI SCAN","CT Digital X-Ray","Digital Mammogram","Ultrasound","ECG","2D ECHO","TMT","PFT","BMD"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostic_list);

        final ViewPager pager=findViewById(R.id.img_header);
        MyViewPagerAdapter pagerAdapter=new MyViewPagerAdapter(this);
        pager.setAdapter(pagerAdapter);
        ImageView imgHome=findViewById(R.id.img_home);


        final ViewPager bottompager=findViewById(R.id.bottom_footer);
        BottomPagerAdapter bottomPagerAdapter=new BottomPagerAdapter(this);
        bottompager.setAdapter(bottomPagerAdapter);

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




        DiagnosticsAdapter adapter=new DiagnosticsAdapter(this);
        RecyclerView mRecyclerView=findViewById(R.id.data_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new DiagnosticsAdapter.OnItemClickListener()
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

                }
            }
        });


    }
}