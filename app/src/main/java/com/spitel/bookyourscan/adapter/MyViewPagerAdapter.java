package com.spitel.bookyourscan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.spitel.bookyourscan.R;

public class MyViewPagerAdapter extends PagerAdapter
    {
        private LayoutInflater layoutInflater;
        Context mContext;

        public MyViewPagerAdapter(Context context)
        {
            mContext=context;
        }

        public int [] slide_images=
        {
                R.drawable.banner_first,
                R.drawable.banner_second,
                R.drawable.banner_third,
        };

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.item_header, container, false);
            ImageView image=view.findViewById(R.id.img_src);
            image.setImageResource(slide_images[position]);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return slide_images.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
