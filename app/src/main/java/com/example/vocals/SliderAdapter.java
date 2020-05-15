package com.example.vocals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    public SliderAdapter(Context context){
        this.context=context;

    }

    //Arrays
    public int[] slide_image={
            R.drawable.icon,
            R.drawable.onboarding_mic
    };

    public String[] start_text={
            "Vocals is one tap chat for incredibly simple,super fast voice messaging",
            "Record and send voice messages fast and easy with just a tap of button"
    };

    @Override
    public int getCount() {
        return start_text.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout)object;
    }
    @Override
    public Object instantiateItem(ViewGroup container,int position){
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView slideImageView=(ImageView) view.findViewById(R.id.slide_image);
        TextView slideText=(TextView) view.findViewById(R.id.start_text);

        slideImageView.setImageResource(slide_image[position]);
        slideText.setText(start_text[position]);

        container.addView(view);

        return view;

    };

    @Override
    public void destroyItem(ViewGroup container,int position,Object object){
        container.removeView((RelativeLayout)object);
    }
}
