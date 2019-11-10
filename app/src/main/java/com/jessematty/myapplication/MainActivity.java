package com.jessematty.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import java.time.format.TextStyle;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linLayout = new LinearLayout(this);
        // specifying vertical orientation
        linLayout.setOrientation(LinearLayout.VERTICAL);


        LinearLayout.LayoutParams leftMarginParams = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftMarginParams.leftMargin = 50;

        Button cooking = new Button(this);
        cooking.setText("Cooking Conversions");
        cooking.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(CookingConversions.class);



            }
        });
        Button distance = new Button(this);

        distance.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                changeActivity(DistanceConversions.class);


            }
        });

        distance.setText("Distance Conversions");

        Button area = new Button(this);

        area.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                changeActivity(AreaConversions.class);


            }
        });
        area.setText("Area Conversions");




        Button other = new Button(this);
       other.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                changeActivity(OtherConversions.class);


            }
        });
        other.setText("Other Conversions" );




        Button areaCalculator= new Button(this);
        areaCalculator.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                changeActivity(AreaCalculator.class);


            }
        });
       areaCalculator.setText("Area Calculator " );

        Button volumeCalculator= new Button(this);
        volumeCalculator.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                changeActivity(AreaCalculator.class);


            }
        });
       volumeCalculator.setText("Volume Calculator " );

        Button volumeConverter= new Button(this);
        volumeConverter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                changeActivity(VolumeConversions.class);


            }
        });
        volumeConverter.setText("Volume Conversions " );



        Button weightConverter= new Button(this);
        weightConverter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                changeActivity(WeightConversions.class);


            }
        });
       weightConverter.setText("Weight Conversions " );


        TextView title= new TextView(this);
        title.setText("Unit Converter");
        title.setTextSize(40);
        linLayout.addView(title);


        linLayout.addView(cooking, leftMarginParams);
        linLayout.addView(distance, leftMarginParams);
        linLayout.addView(area, leftMarginParams);
        linLayout.addView(other, leftMarginParams);
        linLayout.addView(areaCalculator, leftMarginParams);
        linLayout.addView(volumeCalculator, leftMarginParams);
        linLayout.addView(volumeConverter, leftMarginParams);
        linLayout.addView(weightConverter, leftMarginParams);











        LayoutParams linLayoutParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        // set LinearLayout as a root element of the screen
        setContentView(linLayout, linLayoutParam);

        LayoutParams lpView = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);






        LinearLayout.LayoutParams rightGravityParams = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightGravityParams.gravity = Gravity.RIGHT;


        setContentView(linLayout);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    public void changeActivity( Class activityClass){

        Intent intent= new Intent(this, activityClass);
       this.startActivity(intent);


    }

}
