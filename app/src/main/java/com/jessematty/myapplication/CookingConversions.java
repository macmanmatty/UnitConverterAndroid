package com.jessematty.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class CookingConversions extends Activity {
    
    TextView cups;
    TextView gallons;
    TextView fluidOunces;
    TextView tablespoons;
    TextView teaspoons;
    TextView liters;
    TextView milliliters;
    TextView quarts;
    TextView pints;

    
    


    EditText numberField;


    double  cupsNumber;
    double  gallonsNumber;
    double  fluidOuncesNumber;
    double  tablespoonsNumber;
    double  teaspoonsNumber;
    double litersNumber;
    double millilitersNumber;
    double quartsNumber;
    double pintsNumber;
    


    Button convert;
    Spinner valuesList;
    String valueChoice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mainLayout = new LinearLayout(this);
        // specifying vertical orientation
        mainLayout.setOrientation(LinearLayout.VERTICAL);


        TextView title= new TextView(this);
        title.setText(" Cooking Measurement Conversions");
        title.setTypeface(null, Typeface.BOLD);
        mainLayout.addView(title);



        cups=new TextView(this);
         gallons=new TextView(this);
         fluidOunces=new TextView(this);
         tablespoons=new TextView(this);
         teaspoons=new TextView(this);
         liters=  new TextView( this);
         milliliters= new TextView(this);
         quarts= new TextView(this);
         pints= new TextView(this);



        valuesList= new Spinner(this);
        ArrayList<String> values= new ArrayList<>();
        values.add("Fluid Ounces");
        values.add("Teaspoons");
        values.add("Tablespoons");
        values.add("Cups");
        values.add("Pints");
        values.add("Quarts");
        values.add("Gallons");
        values.add("Milliliters");
        values.add("Liters");









        ArrayAdapter<String> adapter= new ArrayAdapter(this, R.layout.textview);
        adapter.addAll(values);
        valuesList.setAdapter(adapter);

        valuesList.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                valueChoice= (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        convert= new Button(this);
        convert.setText("Convert");
        convert.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valueChoice.equals("Cups")){

                    setTextViewCups();
                }
                else  if (valueChoice.equals("Fluid Ounces")){
                    setTextViewFluidOunces();
                }
                else   if (valueChoice.equals("Gallons")){
                    setTextViewGallons();

                }
                else   if (valueChoice.equals("Liters")){
                    setTextViewLiters();
                }
                else   if (valueChoice.equals("Milliliters")){
                    setTextViewMilliliters();
                }
                else   if (valueChoice.equals("Pints")){
                    setTextViewPints();
                }
                else   if (valueChoice.equals("Quarts")){
                    setTextViewQuarts();
                }
                else   if (valueChoice.equals("Tablespoons")){
                    setTextViewTablespoons();
                }
                else   if (valueChoice.equals("Teaspoons")){
                    setTextViewTeaspoons();
                }










            }
        });



        numberField= new EditText(this);


        numberField.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_CLASS_NUMBER);


        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,100);




        LinearLayout enterText= new LinearLayout(this);
        enterText.setOrientation(LinearLayout.HORIZONTAL);
        enterText.addView(numberField);
        enterText.addView(valuesList);
        enterText.addView(convert);
        mainLayout.addView(enterText);







        params= new LayoutParams(LayoutParams.FILL_PARENT, 60);
            TextView metric= new TextView(this);
            metric.setText("Metric Measurements");
            metric.setTextColor(Color.GREEN);
            mainLayout.addView(metric);


        milliliters.setLayoutParams(params);
        milliliters.setGravity(Gravity.CENTER);
        mainLayout.addView(milliliters);


        liters.setLayoutParams(params);
        liters.setGravity(Gravity.CENTER);
        mainLayout.addView(liters);

        TextView english= new TextView(this);
        english.setText("English Measurements");
        english.setTextColor(Color.RED);

        metric.setLayoutParams(params);
        metric.setGravity(Gravity.CENTER);

        english.setLayoutParams(params);
        english.setGravity(Gravity.CENTER);
        mainLayout.addView(english);





        teaspoons.setLayoutParams(params);
        teaspoons.setGravity(Gravity.CENTER);
        mainLayout.addView(teaspoons);

        tablespoons.setLayoutParams(params);
        tablespoons.setGravity(Gravity.CENTER);
        mainLayout.addView(tablespoons);

        fluidOunces.setLayoutParams(params);
        fluidOunces.setGravity(Gravity.CENTER);
        mainLayout.addView(fluidOunces);

        cups.setLayoutParams(params);
        cups.setGravity(Gravity.CENTER);
        mainLayout.addView(cups);

        pints.setLayoutParams(params);
        pints.setGravity(Gravity.CENTER);
        mainLayout.addView(pints);


        quarts.setLayoutParams(params);
        quarts.setGravity(Gravity.CENTER);
        mainLayout.addView(quarts );



        gallons.setLayoutParams(params);
        gallons.setGravity(Gravity.CENTER);
        mainLayout.addView(gallons);




        ScrollView mainView= new ScrollView(this);
        mainView.addView(mainLayout);



        setContentView(mainView);


    }



    public void setTextViewLiters(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            litersNumber = Double.valueOf(text);


        }
        else {
            litersNumber = 1;

        }


        cupsNumber=litersNumber*4.22675;
        millilitersNumber=litersNumber*1000;
        tablespoonsNumber=litersNumber*67.628;
        teaspoonsNumber=litersNumber*202.884;
        gallonsNumber=litersNumber*0.264172;
        fluidOuncesNumber=litersNumber*33.814;
        cups.setText(String.valueOf(cupsNumber));
        milliliters.setText(String.valueOf(millilitersNumber));
        tablespoons.setText(String.valueOf(tablespoonsNumber));
        liters.setText(String.valueOf(litersNumber));
       teaspoons.setText(String.valueOf(teaspoonsNumber));
        fluidOunces.setText(String.valueOf(fluidOuncesNumber));
        gallons.setText(String.valueOf(gallonsNumber));














    }

    public void setTextViewGallons(){


        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            gallonsNumber = Double.valueOf(text);


        }
        else {
            gallonsNumber = 1;

        }
        cupsNumber=gallonsNumber*16;
        tablespoonsNumber=gallonsNumber*256;
        teaspoonsNumber=gallonsNumber*768;
        millilitersNumber=gallonsNumber*3785.41;
        litersNumber=gallonsNumber*3.78541;

        quartsNumber=gallonsNumber*4;
        pintsNumber=gallonsNumber*8;

        cups.setText(String.valueOf("Cups: "+ cupsNumber));
        milliliters.setText("Milliliters: "+ String.valueOf(millilitersNumber));
        tablespoons.setText("Tablespoons; "+String.valueOf(tablespoonsNumber));
        liters.setText("Liters: "+String.valueOf(litersNumber));
        teaspoons.setText("Teaspoons: "+String.valueOf(teaspoonsNumber));
        fluidOunces.setText("Fluid Ounces: "+String.valueOf(fluidOuncesNumber));
        gallons.setText("Gallons: "+String.valueOf(gallonsNumber));
        pints.setText("Pints: "+String.valueOf(pintsNumber));

        quarts.setText("Qurts: "+String.valueOf(quartsNumber));











    }


    public void setTextViewCups(){


        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            cupsNumber = Double.valueOf(text);


        }
        else {
            cupsNumber = 1;

        }
        millilitersNumber=cupsNumber*236.588;
        litersNumber=cupsNumber*0.236588;
        gallonsNumber=cupsNumber*0.0625;
        fluidOuncesNumber=cupsNumber*8;
        teaspoonsNumber=cupsNumber*48;
        tablespoonsNumber=cupsNumber*16;
        pintsNumber=cupsNumber*.5;
        quartsNumber=cupsNumber*.25;

        cups.setText(String.valueOf("Cups: "+ cupsNumber));
        milliliters.setText("Milliliters: "+ String.valueOf(millilitersNumber));
        tablespoons.setText("Tablespoons; "+String.valueOf(tablespoonsNumber));
        liters.setText("Liters: "+String.valueOf(litersNumber));
        teaspoons.setText("Teaspoons: "+String.valueOf(teaspoonsNumber));
        fluidOunces.setText("Fluid Ounces: "+String.valueOf(fluidOuncesNumber));
        gallons.setText("Gallons: "+String.valueOf(gallonsNumber));
        pints.setText("Pints: "+String.valueOf(pintsNumber));

        quarts.setText("Qurts: "+String.valueOf(quartsNumber));





    }


    public void setTextViewTeaspoons(){

        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            teaspoonsNumber = Double.valueOf(text);


        }
        else {
            teaspoonsNumber = 1;

        }
        millilitersNumber=teaspoonsNumber*4.92892;
        litersNumber=teaspoonsNumber*0.00492892;
        cupsNumber=teaspoonsNumber*0.0208333;
        gallonsNumber=tablespoonsNumber*0.00130208;
        tablespoonsNumber=teaspoonsNumber/3;
        fluidOuncesNumber=teaspoonsNumber*0.166667;
        quartsNumber=teaspoonsNumber*0.00520833;
        pintsNumber=teaspoonsNumber*0.0104167;

        cups.setText(String.valueOf("Cups: "+ cupsNumber));
        milliliters.setText("Milliliters: "+ String.valueOf(millilitersNumber));
        tablespoons.setText("Tablespoons; "+String.valueOf(tablespoonsNumber));
        liters.setText("Liters: "+String.valueOf(litersNumber));
        teaspoons.setText("Teaspoons: "+String.valueOf(teaspoonsNumber));
        fluidOunces.setText("Fluid Ounces: "+String.valueOf(fluidOuncesNumber));
        gallons.setText("Gallons: "+String.valueOf(gallonsNumber));
        pints.setText("Pints: "+String.valueOf(pintsNumber));

        quarts.setText("Qurts: "+String.valueOf(quartsNumber));

     





    }




    public void setTextViewTablespoons(){


        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            tablespoonsNumber = Double.valueOf(text);


        }
        else {
            tablespoonsNumber = 1;

        }
        fluidOuncesNumber=teaspoonsNumber*.5;
        teaspoonsNumber=tablespoonsNumber*3;
        millilitersNumber=tablespoonsNumber*14.7868;
        litersNumber=tablespoonsNumber*0.0147868;
        cupsNumber=tablespoonsNumber*0.0625;
        gallonsNumber=tablespoonsNumber*0.00390625;

        pintsNumber=tablespoonsNumber*0.03125;
        quartsNumber=tablespoonsNumber*0.015625;



        cups.setText(String.valueOf("Cups: "+ cupsNumber));
        milliliters.setText("Milliliters: "+ String.valueOf(millilitersNumber));
        tablespoons.setText("Tablespoons; "+String.valueOf(tablespoonsNumber));
        liters.setText("Liters: "+String.valueOf(litersNumber));
        teaspoons.setText("Teaspoons: "+String.valueOf(teaspoonsNumber));
        fluidOunces.setText("Fluid Ounces: "+String.valueOf(fluidOuncesNumber));
        gallons.setText("Gallons: "+String.valueOf(gallonsNumber));
        pints.setText("Pints: "+String.valueOf(pintsNumber));

        quarts.setText("Qurts: "+String.valueOf(quartsNumber));



     


    }


    public void setTextViewMilliliters(){

        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            millilitersNumber = Double.valueOf(text);


        }
        else {
            millilitersNumber = 1;

        }
        gallonsNumber=millilitersNumber*0.000264172;
        fluidOuncesNumber=millilitersNumber*0.033814;
        cupsNumber=millilitersNumber*0.00422675;
        teaspoonsNumber=millilitersNumber*0.202884;
        tablespoonsNumber=millilitersNumber*0.067628;
        litersNumber=millilitersNumber*.001;
        quartsNumber=millilitersNumber*0.00105669;
        pintsNumber=millilitersNumber*0.00211338;




        cups.setText(String.valueOf("Cups: "+ cupsNumber));
        milliliters.setText("Milliliters: "+ String.valueOf(millilitersNumber));
        tablespoons.setText("Tablespoons; "+String.valueOf(tablespoonsNumber));
        liters.setText("Liters: "+String.valueOf(litersNumber));
        teaspoons.setText("Teaspoons: "+String.valueOf(teaspoonsNumber));
        fluidOunces.setText("Fluid Ounces: "+String.valueOf(fluidOuncesNumber));
        gallons.setText("Gallons: "+String.valueOf(gallonsNumber));
        pints.setText("Pints: "+String.valueOf(pintsNumber));

        quarts.setText("Qurts: "+String.valueOf(quartsNumber));



    }

    public void setTextViewFluidOunces(){

        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            fluidOuncesNumber = Double.valueOf(text);


        }
        else {
            fluidOuncesNumber = 1;

        }

        litersNumber=fluidOuncesNumber*0.0295735;
        gallonsNumber=fluidOuncesNumber*0.0078125;
        teaspoonsNumber=fluidOuncesNumber*6;
        tablespoonsNumber=fluidOuncesNumber*2;
        millilitersNumber=fluidOuncesNumber*29.5735;
        cupsNumber=fluidOuncesNumber*0.125;
        pintsNumber=fluidOuncesNumber*0.0625;
        quartsNumber=fluidOuncesNumber*0.03125;




        cups.setText(String.valueOf("Cups: "+ cupsNumber));
        milliliters.setText("Milliliters: "+ String.valueOf(millilitersNumber));
        tablespoons.setText("Tablespoons; "+String.valueOf(tablespoonsNumber));
        liters.setText("Liters: "+String.valueOf(litersNumber));
        teaspoons.setText("Teaspoons: "+String.valueOf(teaspoonsNumber));
        fluidOunces.setText("Fluid Ounces: "+String.valueOf(fluidOuncesNumber));
        gallons.setText("Gallons: "+String.valueOf(gallonsNumber));
        pints.setText("Pints: "+String.valueOf(pintsNumber));

        quarts.setText("Qurts: "+String.valueOf(quartsNumber));



    }


    public void setTextViewQuarts(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            quartsNumber = Double.valueOf(text);


        }
        else {
            quartsNumber = 1;

        }
        
        
        cupsNumber=quartsNumber*4;
        gallonsNumber=quartsNumber*.25;
        fluidOuncesNumber=quartsNumber*32;
        litersNumber=quartsNumber*0.946353;
        millilitersNumber=quartsNumber*946.353;
        pintsNumber=quartsNumber*2;
        tablespoonsNumber=quartsNumber*64;
        teaspoonsNumber=quartsNumber*192;




        cups.setText(String.valueOf("Cups: "+ cupsNumber));
        milliliters.setText("Milliliters: "+ String.valueOf(millilitersNumber));
        tablespoons.setText("Tablespoons; "+String.valueOf(tablespoonsNumber));
        liters.setText("Liters: "+String.valueOf(litersNumber));
        teaspoons.setText("Teaspoons: "+String.valueOf(teaspoonsNumber));
        fluidOunces.setText("Fluid Ounces: "+String.valueOf(fluidOuncesNumber));
        gallons.setText("Gallons: "+String.valueOf(gallonsNumber));
        pints.setText("Pints: "+String.valueOf(pintsNumber));

        quarts.setText("Qurts: "+String.valueOf(quartsNumber));







    }


    public void setTextViewPints(){

        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            pintsNumber = Double.valueOf(text);


        }
        else {
            pintsNumber = 1;

        }

        teaspoonsNumber=pintsNumber*96;
        tablespoonsNumber=pintsNumber*32;
        quartsNumber=pintsNumber*.5;
        gallonsNumber=pintsNumber*0.125;
        millilitersNumber=pintsNumber*473.176;
        fluidOuncesNumber=pintsNumber*16;
        litersNumber=pintsNumber*0.473176;






        cups.setText(String.valueOf("Cups: "+ cupsNumber));
        milliliters.setText("Milliliters: "+ String.valueOf(millilitersNumber));
        tablespoons.setText("Tablespoons; "+String.valueOf(tablespoonsNumber));
        liters.setText("Liters: "+String.valueOf(litersNumber));
        teaspoons.setText("Teaspoons: "+String.valueOf(teaspoonsNumber));
        fluidOunces.setText("Fluid Ounces: "+String.valueOf(fluidOuncesNumber));
        gallons.setText("Gallons: "+String.valueOf(gallonsNumber));
        pints.setText("Pints: "+String.valueOf(pintsNumber));

        quarts.setText("Qurts: "+String.valueOf(quartsNumber));




    }




}
