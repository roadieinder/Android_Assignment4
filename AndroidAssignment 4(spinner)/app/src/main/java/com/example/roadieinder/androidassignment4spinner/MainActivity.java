package com.example.roadieinder.androidassignment4spinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{
Spinner s1,s2;
String s3,s4,s5;
String s6,s7;
Button b;
EditText nameET,emailET,mobileET;

public void toast(String msg){
    Toast t= Toast.makeText(this,msg,Toast.LENGTH_SHORT);
    t.show();
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           nameET=(EditText)findViewById(R.id.name);
           mobileET=(EditText)findViewById(R.id.mobile);
           emailET=(EditText)findViewById(R.id.email);
           b=(Button)findViewById(R.id.button);

         s1=(Spinner) findViewById(R.id.countrysp);
         s2=(Spinner)findViewById(R.id.statesp);

         mobileET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
             @Override
             public void onFocusChange(View v, boolean hasFocus) {
                 s3=nameET.getText().toString().trim();
                 if ((!s3.contains(" ")) || s3.length()==0){
                     nameET.setError("Enter Full name");
                 }

             }
         });

         emailET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
             @Override
             public void onFocusChange(View v, boolean hasFocus) {
                 s4=mobileET.getText().toString().trim();
                 if (s4.length()<10 || s4.length()==0){
                     mobileET.setError("Enter Valid Mobile Number");
                 }
             }
         });


        ArrayAdapter<CharSequence> spinnerAdapter=  ArrayAdapter.createFromResource(this,
                R.array.Countries,
                android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(spinnerAdapter);
        s1.setOnItemSelectedListener(this);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s3=nameET.getText().toString().trim();
                s4=mobileET.getText().toString().trim();
                s5=emailET.getText().toString().trim();
                s6=String.valueOf(s1.getSelectedItem());
                s7=String.valueOf(s2.getSelectedItem());
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("NAME",s3);
                i.putExtra("MOBILE",s4);
                i.putExtra("EMAIL",s5);
                i.putExtra("COUNTRY",s6);
                i.putExtra("STATE",s7);
                startActivity(i);

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String sp1 = String.valueOf(s1.getSelectedItem());
        if (sp1.contentEquals("India")){
            Toast.makeText(this,"India Selected",Toast.LENGTH_SHORT).show();

            ArrayAdapter<CharSequence> dataAdapter=  ArrayAdapter.createFromResource(this,
                    R.array.States,
                    android.R.layout.simple_spinner_item);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            s2.setAdapter(dataAdapter);

        }
        String sp2 = String.valueOf(s2.getSelectedItem());
        if (sp1.contentEquals("USA")){
            Toast.makeText(this,"USA Selected",Toast.LENGTH_SHORT).show();

            ArrayAdapter<CharSequence> dataAdapter2=  ArrayAdapter.createFromResource(this,
                    R.array.States1,
                    android.R.layout.simple_spinner_item);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            s2.setAdapter(dataAdapter2);
        }
        if (sp1.contentEquals("Canada")){
            Toast.makeText(this,"Canada Selected",Toast.LENGTH_SHORT).show();

            ArrayAdapter<CharSequence> dataAdapter2=  ArrayAdapter.createFromResource(this,
                    R.array.States2,
                    android.R.layout.simple_spinner_item);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            s2.setAdapter(dataAdapter2);
        }
        if (sp1.contentEquals("Pakistan")){
            Toast.makeText(this,"Pakistan Selected",Toast.LENGTH_SHORT).show();

            ArrayAdapter<CharSequence> dataAdapter2=  ArrayAdapter.createFromResource(this,
                    R.array.States3,
                    android.R.layout.simple_spinner_item);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            s2.setAdapter(dataAdapter2);
        }
        if (sp1.contentEquals("Australia")){
            Toast.makeText(this,"Australia Selected",Toast.LENGTH_SHORT).show();

            ArrayAdapter<CharSequence> dataAdapter2=  ArrayAdapter.createFromResource(this,
                    R.array.States4,
                    android.R.layout.simple_spinner_item);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            s2.setAdapter(dataAdapter2);
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
