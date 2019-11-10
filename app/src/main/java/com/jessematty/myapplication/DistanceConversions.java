package com.jessematty.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.InputType;
import android.text.Layout.Alignment;
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

public class DistanceConversions extends Activity {

    TextView miles;
    TextView feet;
    TextView inches;
    TextView kilometers;
    TextView meters;
    TextView centimeters;
    TextView millimeters;
    TextView leagues;
    TextView yards;
    TextView fathams;
    Spinner valuesList;
    String valueChoice;
    Button convert;
    TextView numberField;



    

    

    double milesNumber;
    double feetNumber;
    double inchesNumber;
    double kilometersNumber;
    double metersNumber;
    double centimetersNumber;
    double millimetersNumber;
    double leaguesNumber;
    double yardsNumber;
    double fathamsNumber;

    






    



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        LinearLayout mainLayout = new LinearLayout(this);
        // specifying vertical orientation
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setVerticalGravity(Gravity.CENTER);
        TextView distance = new TextView(this);
                distance.setText("Distance Mesurment Conversions");
                distance.setTextSize(40);
                mainLayout.addView(distance);

         miles=new TextView(this);
         feet=new TextView(this);
         inches=new TextView(this);
         kilometers=new TextView(this);
         meters=new TextView(this);
         centimeters=new TextView(this);
         leagues= new TextView(this);
         millimeters= new TextView(this);
         yards=  new TextView(this);
         fathams= new TextView(this);


        valuesList= new Spinner(this);
        ArrayList<String> values= new ArrayList<>();
        values.add("Inches");
        values.add("Feet");
        values.add("Yards");
        values.add("Miles");
        values.add("Millimeters");
        values.add("Centimeters");
        values.add("Meters");
        values.add("Kilometers");
        values.add("Leagues");
        values.add("Fathams");









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
                if (valueChoice.equals("Kilometers")){

                  setTextViewKilometers();
                }
                else  if (valueChoice.equals("Meters")){
                    setTextViewMeters();
                }
                else   if (valueChoice.equals("Centimeters")){
                    setTextViewCentimeters();

                }
                else   if (valueChoice.equals("Millimeters")){
                    setTextViewMillimeters();
                }
                else   if (valueChoice.equals("Miles")){
                    setTextViewMiles();
                }
                else   if (valueChoice.equals("Feet")){
                    setTextViewFeet();
                }
                else   if (valueChoice.equals("Leagues")){
                    setTextViewLeagues();
                }
                else   if (valueChoice.equals("Fathams")){
                    setTextViewFathams();
                }
                else   if (valueChoice.equals("Inches")){
                    setTextViewInches();
                }
                else   if (valueChoice.equals("Yards")){
                    setTextViewYards();
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


        







        TextView english= new TextView(this);
        english.setText("English Measurements");
        english.setTextSize(30);
        english.setTextColor(Color.RED);


        mainLayout.addView(english);
        mainLayout.addView(this.inches);
        mainLayout.addView(this.feet);
        mainLayout.addView(this.yards);
        mainLayout.addView(this.miles);

        TextView metric= new TextView(this);
        metric.setText("Metric Measurments");
        metric.setTextSize(30);
        metric.setTextColor(Color.GREEN);


        mainLayout.addView(metric);
        mainLayout.addView(this.millimeters);
        mainLayout.addView(this.centimeters);
        mainLayout.addView(this.meters);
        mainLayout.addView(this.kilometers);
        TextView nautical= new TextView(this);
        nautical.setText("Nautical Measurments");
        nautical.setTextSize(30);
        nautical.setTextColor(Color.BLUE);

        mainLayout.addView(nautical);
        mainLayout.addView(this.fathams);
        mainLayout.addView(this.leagues);




        ScrollView mainView= new ScrollView(this);
        mainView.addView(mainLayout);



        setContentView(mainView);

    }





    public void  setTextViewKilometers(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            kilometersNumber = Double.valueOf(text);


        }
        else {
            kilometersNumber = 1;

        }
        feetNumber=kilometersNumber*3280.84;
        millimetersNumber=kilometersNumber*1000000;
        centimetersNumber=kilometersNumber*100000;
        metersNumber=kilometersNumber*1000;
        inchesNumber=kilometersNumber*39370.1;
        leaguesNumber=kilometersNumber*0.179986;
        yardsNumber=kilometersNumber*1093.61;
        milesNumber=kilometersNumber*1093.61;
        fathamsNumber=kilometersNumber*546.807;







        feet.setText("Feet: "+ String.valueOf(feetNumber));
        millimeters.setText("Millimeters: "+String.valueOf(millimetersNumber));
        centimeters.setText("Centimeters: "+String.valueOf(centimetersNumber));
        meters.setText("Meters: "+ String.valueOf(metersNumber));
        inches.setText("Inches: "+String.valueOf(inchesNumber));
        kilometers.setText("Kilometers: "+String.valueOf(kilometersNumber));
        leagues.setText("Nautical Leagues: "+ String.valueOf(leaguesNumber));
        miles.setText("Miles: "+String.valueOf(milesNumber));
        yards.setText("Yards " +yardsNumber);
        fathams.setText("Fathams: "+fathamsNumber);




    }



    public void  setTextViewMiles(){

        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            milesNumber = Double.valueOf(text);


        }
        else {
            milesNumber = 1;

        }
        feetNumber=milesNumber*5280;
        millimetersNumber=milesNumber*1.609e+6;
        centimetersNumber=milesNumber*160934;
        inchesNumber=milesNumber*160934;
        metersNumber=milesNumber*1609.34;
        kilometersNumber=milesNumber*1.60934;
        leaguesNumber=milesNumber*0.289659;
        yardsNumber=milesNumber*1760;
      fathamsNumber=milesNumber*880;







        feet.setText("Feet: "+ String.valueOf(feetNumber));
        millimeters.setText("Millimeters: "+String.valueOf(millimetersNumber));
        centimeters.setText("Centimeters: "+String.valueOf(centimetersNumber));
        meters.setText("Meters: "+ String.valueOf(metersNumber));
        inches.setText("Inches: "+String.valueOf(inchesNumber));
        kilometers.setText("Kilometers: "+String.valueOf(kilometersNumber));
        leagues.setText("Nautical Leagues: "+ String.valueOf(leaguesNumber));
        miles.setText("Miles: "+String.valueOf(milesNumber));
        yards.setText("Yards " +yardsNumber);
        fathams.setText("Fathams: "+fathamsNumber);



    }

    public void  setTextViewFeet(){

        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            feetNumber = Double.valueOf(text);


        }
        else {
            feetNumber = 1;

        }

        yardsNumber=feetNumber/3;
        inchesNumber=feetNumber*12;
        milesNumber=feetNumber*0.000189394;
        metersNumber=feetNumber*0.3048;
        centimetersNumber=feetNumber*30.48;
        millimetersNumber=feetNumber*304.8;
        leaguesNumber=feetNumber*5.48596e-5;
        kilometersNumber=feetNumber*0.0003048;
        fathamsNumber=feetNumber/6;







        feet.setText("Feet: "+ String.valueOf(feetNumber));
        millimeters.setText("Millimeters: "+String.valueOf(millimetersNumber));
        centimeters.setText("Centimeters: "+String.valueOf(centimetersNumber));
        meters.setText("Meters: "+ String.valueOf(metersNumber));
        inches.setText("Inches: "+String.valueOf(inchesNumber));
        kilometers.setText("Kilometers: "+String.valueOf(kilometersNumber));
        leagues.setText("Nautical Leagues: "+ String.valueOf(leaguesNumber));
        miles.setText("Miles: "+String.valueOf(milesNumber));
        yards.setText("Yards " +yardsNumber);
        fathams.setText("Fathams: "+fathamsNumber);





    }


    public void  setTextViewMeters(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            metersNumber = Double.valueOf(text);


        }
        else {
            metersNumber = 1;

        } 
       kilometersNumber= metersNumber*0.001;
       centimetersNumber=metersNumber*100;
       millimetersNumber=metersNumber*1000;
       inchesNumber=metersNumber*39.3701;
       feetNumber=metersNumber*3.28084;
       leaguesNumber=metersNumber*0.000179986;
       milesNumber=metersNumber*0.000621371;
       yardsNumber=metersNumber*1.09361;
       fathamsNumber=metersNumber*0.546807;










        feet.setText("Feet: "+ String.valueOf(feetNumber));
        millimeters.setText("Millimeters: "+String.valueOf(millimetersNumber));
        centimeters.setText("Centimeters: "+String.valueOf(centimetersNumber));
        meters.setText("Meters: "+ String.valueOf(metersNumber));
        inches.setText("Inches: "+String.valueOf(inchesNumber));
        kilometers.setText("Kilometers: "+String.valueOf(kilometersNumber));
        leagues.setText("Nautical Leagues: "+ String.valueOf(leaguesNumber));
        miles.setText("Miles: "+String.valueOf(milesNumber));
        yards.setText("Yards " +yardsNumber);
        fathams.setText("Fathams: "+fathamsNumber);

    }



    public void setTextViewInches(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            inchesNumber = Double.valueOf(text);


        }
        else {
            inchesNumber = 1;

        }
        yardsNumber=inchesNumber/36;
        feetNumber=inchesNumber/12;
        milesNumber=inchesNumber*1.57828e-5;
        kilometersNumber=inchesNumber*2.54e-5;
        metersNumber=inchesNumber*0.0254;
        centimetersNumber=inchesNumber*2.54;
        millimetersNumber=inchesNumber*25.4;
        leaguesNumber=inchesNumber*4.57163e-6;
        fathamsNumber=inchesNumber*0.0138889;











        feet.setText("Feet: "+ String.valueOf(feetNumber));
        millimeters.setText("Millimeters: "+String.valueOf(millimetersNumber));
        centimeters.setText("Centimeters: "+String.valueOf(centimetersNumber));
        meters.setText("Meters: "+ String.valueOf(metersNumber));
        inches.setText("Inches: "+String.valueOf(inchesNumber));
        kilometers.setText("Kilometers: "+String.valueOf(kilometersNumber));
        leagues.setText("Nautical Leagues: "+ String.valueOf(leaguesNumber));
        miles.setText("Miles: "+String.valueOf(milesNumber));
        yards.setText("Yards " +yardsNumber);
        fathams.setText("Fathams: "+fathamsNumber);




    }


    public void setTextViewMillimeters(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            millimetersNumber = Double.valueOf(text);


        }
        else {
            millimetersNumber = 1;

        }
        milesNumber=millimetersNumber*6.21371e-7;
        yardsNumber=millimetersNumber*0.00109361;
        inchesNumber=millimetersNumber*0.0393701;
        feetNumber=millimetersNumber*0.00328084;
        kilometersNumber=millimetersNumber*1e-6;
        metersNumber=millimetersNumber*0.001;
        centimetersNumber=millimetersNumber*.1;
        leaguesNumber=centimetersNumber*1.79986e-7;
        fathamsNumber=centimetersNumber*0.000546807;












        feet.setText("Feet: "+ String.valueOf(feetNumber));
        millimeters.setText("Millimeters: "+String.valueOf(millimetersNumber));
        centimeters.setText("Centimeters: "+String.valueOf(centimetersNumber));
        meters.setText("Meters: "+ String.valueOf(metersNumber));
        inches.setText("Inches: "+String.valueOf(inchesNumber));
        kilometers.setText("Kilometers: "+String.valueOf(kilometersNumber));
        leagues.setText("Nautical Leagues: "+ String.valueOf(leaguesNumber));
        miles.setText("Miles: "+String.valueOf(milesNumber));
        yards.setText("Yards " +yardsNumber);


        fathams.setText("Fathams: "+fathamsNumber);

      






    }

    public void setTextViewCentimeters(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            centimetersNumber = Double.valueOf(text);


        }
        else {
            centimetersNumber = 1;

        }
        yardsNumber=centimetersNumber*0.0109361;
        feetNumber=centimetersNumber*0.0328084;
        inchesNumber=centimetersNumber*0.393701;
        metersNumber=centimetersNumber*0.01;
        kilometersNumber=centimetersNumber*1e-5;
        leaguesNumber=centimetersNumber*1.79986e-6;
        millimetersNumber=centimetersNumber*10;
        milesNumber=centimetersNumber*6.21371e-6;
        fathamsNumber=centimetersNumber*0.00546807;








        feet.setText("Feet: "+ String.valueOf(feetNumber));
        millimeters.setText("Millimeters: "+String.valueOf(millimetersNumber));
        centimeters.setText("Centimeters: "+String.valueOf(centimetersNumber));
        meters.setText("Meters: "+ String.valueOf(metersNumber));
        inches.setText("Inches: "+String.valueOf(inchesNumber));
        kilometers.setText("Kilometers: "+String.valueOf(kilometersNumber));
        leagues.setText("Nautical Leagues: "+ String.valueOf(leaguesNumber));
        miles.setText("Miles: "+String.valueOf(milesNumber));
        yards.setText("Yards " +yardsNumber);

        fathams.setText("Fathams: "+fathamsNumber);






    }


    public void setTextViewYards(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            yardsNumber = Double.valueOf(text);


        }
        else {
            yardsNumber = 1;

        }
        feetNumber=yardsNumber*3;
        inchesNumber=yardsNumber*36;
        centimetersNumber=yardsNumber*91.44;
        millimetersNumber=yardsNumber*914.4;
        metersNumber=yardsNumber*0.9144;
        milesNumber=yardsNumber*0.000568182;
        kilometersNumber=yardsNumber*0.0009144;
        leaguesNumber=yardsNumber*0.000164579;
        fathamsNumber=yardsNumber/2;










        feet.setText("Feet: "+ String.valueOf(feetNumber));
        millimeters.setText("Millimeters: "+String.valueOf(millimetersNumber));
        centimeters.setText("Centimeters: "+String.valueOf(centimetersNumber));
        meters.setText("Meters: "+ String.valueOf(metersNumber));
        inches.setText("Inches: "+String.valueOf(inchesNumber));
        kilometers.setText("Kilometers: "+String.valueOf(kilometersNumber));
        leagues.setText("Nautical Leagues: "+ String.valueOf(leaguesNumber));
        miles.setText("Miles: "+String.valueOf(milesNumber));
        yards.setText("Yards " +yardsNumber);

        fathams.setText(" Fathams: "+fathamsNumber);




    }



    public void setTextViewFathams(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            fathamsNumber = Double.valueOf(text);


        }
        else {
            fathamsNumber = 1;

        }
        feetNumber=fathamsNumber*3*2;
        inchesNumber=fathamsNumber*36*2;
        centimetersNumber=fathamsNumber*91.44*2;
        millimetersNumber=fathamsNumber*914.4*2;
        metersNumber=fathamsNumber*0.9144*2;
        milesNumber=fathamsNumber*0.000568182*2;
        kilometersNumber=fathamsNumber*0.0009144*2;
        leaguesNumber=fathamsNumber*0.000164579*2;
        yardsNumber=fathamsNumber*2;










        feet.setText("Feet: "+ String.valueOf(feetNumber));
        millimeters.setText("Millimeters: "+String.valueOf(millimetersNumber));
        centimeters.setText("Centimeters: "+String.valueOf(centimetersNumber));
        meters.setText("Meters: "+ String.valueOf(metersNumber));
        inches.setText("Inches: "+String.valueOf(inchesNumber));
        kilometers.setText("Kilometers: "+String.valueOf(kilometersNumber));
        leagues.setText("Nautical Leagues: "+ String.valueOf(leaguesNumber));
        miles.setText("Miles: "+String.valueOf(milesNumber));
        yards.setText("Yards " +yardsNumber);

        fathams.setText("Fathams: "+fathamsNumber);





    }

    public void setTextViewLeagues(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            leaguesNumber = Double.valueOf(text);


        }
        else {
            leaguesNumber = 1;

        }
        milesNumber=leaguesNumber*3.45234;
        kilometersNumber=leaguesNumber*5.556;
        metersNumber=leaguesNumber*5556;
        centimetersNumber=leaguesNumber*555600;
        millimetersNumber=leaguesNumber*5556000;
        feetNumber=leaguesNumber*18228.3;
        yardsNumber=leaguesNumber*6076.12;
        inchesNumber=leaguesNumber*218740;
        fathamsNumber=leaguesNumber*3038.06;
        







        feet.setText("Feet: "+ String.valueOf(feetNumber));
        millimeters.setText("Millimeters: "+String.valueOf(millimetersNumber));
        centimeters.setText("Centimeters: "+String.valueOf(centimetersNumber));
        meters.setText("Meters: "+ String.valueOf(metersNumber));
        inches.setText("Inches: "+String.valueOf(inchesNumber));
        kilometers.setText("Kilometers: "+String.valueOf(kilometersNumber));
        leagues.setText("Nautical Leagues: "+ String.valueOf(leaguesNumber));
        miles.setText("Miles: "+String.valueOf(milesNumber));
        yards.setText("Yards " +yardsNumber);




    }





}
