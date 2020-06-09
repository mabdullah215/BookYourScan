package com.spitel.bookyourscan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.spitel.bookyourscan.R;


public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.ViewHolder>
{

    private String[] imgList={"2D ECHO","Ambulance","Blood Bank","BMD","Cardiology","Crowd Funding",
            "CT Digital","Diagnostics","Doctor Appointment","ECG","Health Insurance","Home Care","Mammogram","MRI SCAN"
            ,"Neurology","PFT","Pharmacy","TMT","Ultrasound","urology"};
    private OnItemClickListener onItemClickListener;
    private Context mContext;

    public interface OnItemClickListener
    {
        void onItemClick(int position);
    }


    public MainMenuAdapter(Context context)
    {
        this.mContext=context;
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener)
    {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_main_menu, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public int getItemCount()
    {
        return imgList == null? 0: imgList.length;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position)
    {
        holder.setDetails(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private ImageView sourceImage;
        private TextView tvTitle;


        public ViewHolder(View itemView)
        {
            super(itemView);
            sourceImage = itemView.findViewById(R.id.img_src);
            tvTitle=itemView.findViewById(R.id.tv_title);
            itemView.setOnClickListener(this);
        }

        public void setDetails(int position)
        {
            String src="file:///android_asset/main/"+imgList[position]+".png";
            Glide.with(mContext).load(src).into(sourceImage);
            tvTitle.setText(imgList[position]);
        }

        @Override
        public void onClick(View v)
        {
            if (onItemClickListener != null)
                onItemClickListener.onItemClick(getAdapterPosition());
        }
    }


}


