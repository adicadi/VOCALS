package com.example.vocals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnboardingScreen extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private Button mOnboardbtn;
    private int mCurrentPage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_screen);

        mSlideViewPager=(ViewPager) findViewById(R.id.slideViewpager);
        mDotLayout=(LinearLayout) findViewById(R.id.dotslayout);

        mOnboardbtn=(Button) findViewById(R.id.onboard_btn);

        sliderAdapter=new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

        //onClickListener
        mOnboardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Startactivity =new Intent(OnboardingScreen.this,Startactivity.class);
                startActivity(Startactivity);
            }
        });
    }

    public void addDotsIndicator(int position){

        mDots=new TextView[2];
        mDotLayout.removeAllViews();
        for(int i=0;i< mDots.length;i++){

            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(30);
            mDots[i].setTextColor(getResources().getColor(R.color.colorPrimary));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(65, 5, 5, 5);
            mDots[i].setLayoutParams(params);

            mDotLayout.addView(mDots[i]);

        }
        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }

    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage=i;
            if(i==0){
                mOnboardbtn.setEnabled(false);
                mOnboardbtn.setVisibility(View.GONE);
                mOnboardbtn.setText("");


            }else if(i==1){
                mOnboardbtn.setEnabled(true);
                mOnboardbtn.setVisibility(View.VISIBLE);
                mOnboardbtn.setTextSize(20);
                mOnboardbtn.setText("START");

            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
