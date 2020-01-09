package com.asantuts.bmicalculater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AgeCalculater extends AppCompatActivity {

    EditText e1;
    EditText e2;
    EditText e3;
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculater);e1 = (EditText) findViewById(R.id.editText1);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        txt =  findViewById(R.id.text);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(e1.getText().toString().equals(""))
                {
                    e1.setError("Please enter date");
                } else if(e2.getText().toString().equals(""))
                {
                    e2.setError("Please enter month");
                }
                else if(e3.getText().toString().equals(""))
                {
                    e3.setError("Please enter year");
                }
                else
                {
                    String day = e1.getText().toString();
                    String month = e2.getText().toString();
                    String year = e3.getText().toString();

                    Calendar cal = Calendar.getInstance();
                    int currentday = cal.get(Calendar.DAY_OF_MONTH);
                    int currentmonth = cal.get(Calendar.MONTH);
                    int currentyear = cal.get(Calendar.YEAR);

                    int age = currentday-(Integer.valueOf(day));
                    int age1 = (currentmonth+12+1)-(Integer.valueOf(month));
                    int age2 = (currentyear-1)-(Integer.valueOf(year));

                    Toast.makeText(AgeCalculater.this,"You are "+age+"days "+age1+"months "+age2+"years old",Toast.LENGTH_SHORT).show();
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    txt.setText("You are "+age2+"years "+age+"days  and"+age1+"months old ");
                }}
        });
    }
}