package com.asantuts.bmicalculater;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

import java.text.DecimalFormat;
import java.util.Random;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
Toolbar toolbar;
    DrawerLayout dLayout;
    Button h_add, w_add, h_sub, w_sub, a_add, a_sub, cal, chart;
    TextView height, heightinch, heightfoot, weight, Age;
    Integer h_f, h_i, w, a;

    //private static final String TAG = "MainActivity";

    // private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        setNavigationDrawer(); // call method


        Random age = new Random();

        a = age.nextInt(50) + 1;

        Random weigh = new Random();

        w = weigh.nextInt(50) + 1;


        Random inch = new Random();

        h_i = weigh.nextInt(12) + 1;


        // mAdView = findViewById(R.id.adView);
        //AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);

        Age = findViewById(R.id.age);
        weight = findViewById(R.id.weight);
        heightfoot = findViewById(R.id.height_foot);
        heightinch = findViewById(R.id.height_inch);

        Age.setText(a.toString());
        weight.setText(w.toString());
        heightinch.setText(h_i.toString());


        h_f = Integer.valueOf(String.valueOf(heightfoot.getText()));
        h_i = Integer.valueOf(String.valueOf(heightinch.getText()));


        h_add = findViewById(R.id.h_add);
        w_add = findViewById(R.id.w_add);
        h_sub = findViewById(R.id.h_sub);
        a_add = findViewById(R.id.a_add);
        a_sub = findViewById(R.id.a_sub);
        w_sub = findViewById(R.id.w_sub);
        cal = findViewById(R.id.cal);
        chart = findViewById(R.id.chart);


        h_add.setOnClickListener(this);
        w_add.setOnClickListener(this);
        h_sub.setOnClickListener(this);
        w_sub.setOnClickListener(this);

        a_add.setOnClickListener(this);
        a_sub.setOnClickListener(this);

        cal.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        if (v == h_add) {
            add();
        }
        if (v == w_add) {
            wadd();
        }
        if (v == h_sub) {
            sub();
        }

        if (v == w_sub) {
            wsub();
        }

        if (v == a_add) {
            ageadd();
        }
        if (v == a_sub) {
            agesub();
        }
        if (v == cal) {

            heightincm();
            calulate();
            Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
        }
    }

    private void calulate() {


        String heightSringcm = heightincm();
        String weightStr = weight.getText().toString();
        if (heightSringcm != null && !"".equals(heightSringcm)
                && weightStr != null && !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightSringcm) / 100;
            float weightValue = Float.parseFloat(weightStr);
            float bmi = weightValue / (heightValue * heightValue);
            displayBMI(bmi);
        }
    }

    private void displayBMI(float bmi) {
        String bmiLabel = "";
        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = getString(R.string.very_severely_underweight);
        } else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0) {
            bmiLabel = getString(R.string.severely_underweight);
        } else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.underweight);
        } else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0) {
            bmiLabel = getString(R.string.normal);
        } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0) {
            bmiLabel = getString(R.string.overweight);
        } else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0) {
            bmiLabel = getString(R.string.obese_class_i);
        } else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0) {
            bmiLabel = getString(R.string.obese_class_ii);
        } else {
            bmiLabel = getString(R.string.obese_class_iii);
        }

        bmiLabel = bmi + "\n\n" + bmiLabel;
        // result.setText(bmiLabel);
        Toast.makeText(this, bmiLabel, Toast.LENGTH_SHORT).show();
    }


    String heightincm() {
        double heihgt_in_cm;
        h_f = Integer.valueOf(String.valueOf(heightfoot.getText()));
        h_i = Integer.valueOf(String.valueOf(heightinch.getText()));

        heihgt_in_cm = ((h_f * 30.48) + (h_i * 2.54));
        // DecimalFormat decimalFormat = new DecimalFormat("#.##");
        //heihgt_in_cm= Integer.parseInt(decimalFormat.format(heihgt_in_cm));
        return String.valueOf(heihgt_in_cm);
    }


    private void sub() {
        h_i--;
        if (h_i == -1) {
            h_i = 12;
            h_f--;
        }
        if (h_f == -1) {
            h_f = 0;
        }

        heightinch.setText(h_i.toString());
        heightfoot.setText(h_f.toString());
    }

    private void agesub() {

        a--;
        if (a == -1) {
            a = 0;
        }
        Age.setText(a.toString());
    }

    private void wsub() {
        w--;
        if (w == -1) {
            w = 0;
        }
        weight.setText(w.toString());
    }

    private void add() {
        h_i++;
        heightinch.setText(h_i.toString());
        if (h_i > 12) {
            h_i = 0;
            h_f++;
            heightinch.setText(h_i.toString());
            heightfoot.setText(h_f.toString());
        }
    }

    private void wadd() {
        w++;
        weight.setText(w.toString());
    }

    private void ageadd() {
        a++;
        Age.setText(a.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.chart:
                Intent intent = new Intent(HomeActivity.this, ChartActivity.class);
                startActivity(intent);
                return true;
                case R.id.age:
                Intent intent1 = new Intent(HomeActivity.this, AgeCalculater.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    private void setNavigationDrawer() {
        dLayout = (DrawerLayout) findViewById(R.id.drawer_layout); // initiate a DrawerLayout
        NavigationView navView = (NavigationView) findViewById(R.id.navigation); // initiate a Navigation View
// implement setNavigationItemSelectedListener event on NavigationView

      // ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,dLayout,,"Open","Close");
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Activity frag = null; // create a Fragment Object
                int itemId = menuItem.getItemId(); // get selected menu item's id
// check selected menu item's id and replace a Fragment Accordingly
                if (itemId == R.id.first) {
                    Intent intent=new Intent(HomeActivity.this,HomeActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.second) {
                    Intent intent=new Intent(HomeActivity.this,AgeCalculater.class);
                    startActivity(intent);
                } else if (itemId == R.id.third) {
                    Intent intent=new Intent(HomeActivity.this,ChartActivity.class);
                    startActivity(intent);
                }

                return false;
            }
        });
    }

}

