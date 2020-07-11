package com.spitel.bookyourscan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.spitel.bookyourscan.R;

import androidx.viewpager.widget.PagerAdapter;

public class BottomPagerAdapter extends PagerAdapter
    {
        private LayoutInflater layoutInflater;
        Context mContext;

        public BottomPagerAdapter(Context context)
        {
            mContext=context;
        }

        public int [] slide_images=
        {
                R.drawable.happydoctor,
                R.drawable.doc2,
                R.drawable.doc3,
        };

        public String [] slide_Text=
                {
                        "Dr Arun Reddy\nMBBS, DNB (Neurosurgeon)\nConsultant Neurosurgeon",
                        "Dr Shehla Qureshi\nMBBS, DNB (Neurosurgeon)\nConsultant Neurosurgeon",
                        "Dr Akila Roy\nMBBS, DNB (Neurosurgeon)\nConsultant Neurosurgeon"
                };


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.footer_layout, container, false);
            ImageView image=view.findViewById(R.id.img_doc);
            TextView tvFooter=view.findViewById(R.id.txt_footer);
            image.setImageResource(slide_images[position]);
            tvFooter.setText(slide_Text[position]);
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
