package com.example.roadieinder.androidassignment4spinner;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView name,mobile,email,country,state;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name=(TextView)findViewById(R.id.nameT);
        mobile=(TextView)findViewById(R.id.mobileT);
        email=(TextView)findViewById(R.id.emailT);
        country=(TextView)findViewById(R.id.countryT);
        state=(TextView)findViewById(R.id.stateT);
        b=(Button)findViewById(R.id.button);


        Intent i2= getIntent();
        name.setText(i2.getStringExtra("NAME"));
        mobile.setText(i2.getStringExtra("MOBILE"));
        email.setText(i2.getStringExtra("EMAIL"));
        country.setText(i2.getStringExtra("COUNTRY"));
        state.setText(i2.getStringExtra("STATE"));

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(i3);
            }
        });


    }

}
