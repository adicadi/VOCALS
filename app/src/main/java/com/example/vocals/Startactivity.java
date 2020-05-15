package com.example.vocals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Startactivity extends AppCompatActivity {

    private Button mRegBtn;
    private Button mloginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startactivity);

        mloginBtn=(Button) findViewById(R.id.start_login_btn);
        mloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login_intent =new Intent(Startactivity.this,LoginActivity.class);
                startActivity(login_intent);
            }
        });
        mRegBtn = (Button) findViewById(R.id.start_reg_btn);
        mRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reg_intent =new Intent(Startactivity.this,Registeractivity.class);
                startActivity(reg_intent);



            }
        });

    }
}
