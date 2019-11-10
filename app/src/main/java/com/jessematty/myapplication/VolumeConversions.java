package com.jessematty.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class VolumeConversions extends Activity {
    TextView cubicFeet;
    TextView cubicMiles;
    TextView cubicMeters;
    TextView cubicKilometers;
    TextView cubicInches;
    TextView cubicMillimeters;
    TextView cubicCentimeters;

    EditText numberField;
    
    Spinner valuesList;
    String valueChoice;
    








    Button convert;
   


    double cubicFeetNumber;
    double cubicMilesNumber;
    double cubicMetersNumber;
    double cubicKilometersNumber;

    double cubicInchesNumber;
    double cubicMillimetersNumber;
    double cubicCentimetersNumber;


    public VolumeConversions() {
        
        
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createLayout();



    }


    public void createLayout(){
        cubicFeet=new TextView(this);
        cubicMiles=new TextView(this);
        cubicMeters=new TextView(this);
        cubicKilometers=new TextView(this);

        valuesList= new Spinner(this);
        ArrayList<String> values= new ArrayList<>();
        values.add("Cubic Inches");
        values.add("Cubic Feet");
        values.add("Cubic Miles");
        values.add("Cubic Millimeters");
        values.add("Cubic Centimeters");
        values.add("Cubic Meters");
        values.add("Cubic Kilomaters");






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
        

        cubicInches= new TextView(this);
        cubicMillimeters= new TextView(this);
        cubicCentimeters= new TextView(this);


        numberField= new EditText(this);
       

        numberField.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_CLASS_NUMBER);
      
        cubicFeet.setText("Cubic Feet: "+ String.valueOf(cubicFeetNumber));
        cubicMillimeters.setText("Cubic Millimeters: "+String.valueOf(cubicMillimetersNumber));
        cubicCentimeters.setText("Cubic Centimeters: "+String.valueOf(cubicCentimetersNumber));
        cubicMeters.setText("Cubic Meters: "+ String.valueOf(cubicMetersNumber));
        cubicInches.setText("Cubic Inches: "+String.valueOf(cubicInchesNumber));



        cubicMiles.setText("CubicMiles: "+String.valueOf(cubicMilesNumber));
        cubicKilometers.setText(" cubic Kilometers: "+String.valueOf(cubicKilometersNumber));



        convert= new Button(this);
        convert.setText("Convert");
        convert.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valueChoice.equals("Cubic Inches")){

                    setTextViewInches();
                }
               else  if (valueChoice.equals("Cubic Feet")){
                    setTextViewFeet();
                }
              else   if (valueChoice.equals("Cubic Miles")){
                    setTextViewMiles();
                }
              else   if (valueChoice.equals("Cubic Millimeters")){
                    setTextViewMillimeters();
                }
              else   if (valueChoice.equals("Cubic Centimeters")){
                    setTextViewCentimeters();
                }
              else   if (valueChoice.equals("Cubic Meters")){
                    setTextViewMeters();
                }
             else   if (valueChoice.equals("Cubic Kilomaters")){
                    setTextViewKilometers();
                }



                createLayout();




            }
        });




        TextView title= new TextView(this);
        title.setText(" Area Measurement Conversions");
        title.setTextSize(40);

        LinearLayout mainLayout = new LinearLayout(this);
        // specifying vertical orientation
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        mainLayout.addView(title);

        LinearLayout enterText= new LinearLayout(this);
        enterText.setOrientation(LinearLayout.HORIZONTAL);
        enterText.addView(numberField);
        enterText.addView(valuesList);
        enterText.addView(convert);
        mainLayout.addView(enterText);












        mainLayout.setOrientation(LinearLayout.VERTICAL);









        TextView english= new TextView(this);
        english.setText("English Measurements");
        english.setTextSize(30);
        english.setTextColor(Color.RED);

        mainLayout.addView(english);
        mainLayout.addView(cubicInches);
        mainLayout.addView(cubicFeet);
        mainLayout.addView(cubicMiles);
        TextView metric= new TextView(this);
        metric.setText("Metric Measurements");
        metric.setTextSize(30);
        metric.setTextColor(Color.GREEN);


        mainLayout.addView(metric);
        
        mainLayout.addView(cubicMillimeters);
        mainLayout.addView(cubicCentimeters);
            mainLayout.addView(cubicMeters);
            mainLayout.addView(cubicKilometers);








        ScrollView mainView= new ScrollView(this);
        mainView.addView(mainLayout);



        setContentView(mainView);
    }







    public void  setTextViewKilometers(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            cubicKilometersNumber = Double.valueOf(text);


        }
        else {
            cubicKilometersNumber = 1;

        }

        cubicFeetNumber=cubicKilometersNumber*3.531e+10;


        cubicMilesNumber=cubicKilometersNumber*0.239913;

        cubicMetersNumber=cubicKilometersNumber*1e+9;



        cubicMeters.setText( "Meters: "+ String.valueOf(cubicMetersNumber));
        cubicFeet.setText("Cubic Feet: "+ String.valueOf(cubicFeetNumber));
        cubicMiles.setText("CubicMiles: "+String.valueOf(cubicMilesNumber));
        cubicKilometers.setText(" cubic Kilometers: "+String.valueOf(cubicKilometersNumber));

        cubicCentimeters.setText("n/a");
        cubicInches.setText("n/a");
        cubicMillimeters.setText("n/a");







    }



    public void  setTextViewMiles(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            cubicMilesNumber = Double.valueOf(text);


        }
        else {
            cubicMilesNumber = 1;

        }
        cubicKilometersNumber=cubicMilesNumber*4.16818;

        cubicFeetNumber=cubicMilesNumber*1.472e+11;


        cubicMetersNumber=cubicMilesNumber*4.168e+9;



        cubicMeters.setText( "Meters: "+ String.valueOf(cubicMetersNumber));
        cubicKilometers.setText(" cubic Kilometers: "+String.valueOf(cubicKilometersNumber));
        cubicFeet.setText("Cubic Feet: "+ String.valueOf(cubicFeetNumber));
        cubicMiles.setText("Cubic Miles: "+String.valueOf(cubicMilesNumber));
        cubicCentimeters.setText("n/a");
        cubicInches.setText("n/a");
        cubicMillimeters.setText("n/a");






    }

    public void  setTextViewFeet(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            cubicFeetNumber = Double.valueOf(text);


        }
        else {
            cubicFeetNumber = 1;

        }
        cubicKilometersNumber=cubicFeetNumber*2.83168e-11;
        cubicMilesNumber=cubicFeetNumber*6.79357e-12;

        cubicInchesNumber=cubicFeetNumber*1728;
        cubicCentimetersNumber=cubicFeetNumber*28316.8;
        cubicMillimetersNumber=cubicFeetNumber*2.832e+7;



        cubicMetersNumber=cubicFeetNumber*0.0283168;


        cubicMeters.setText( "Meters: "+ String.valueOf(cubicMetersNumber));
        cubicKilometers.setText(" cubic Kilometers: "+String.valueOf(cubicKilometersNumber));
        cubicFeet.setText("Cubic Feet: "+ String.valueOf(cubicFeetNumber));
        cubicMiles.setText("CubicMiles: "+String.valueOf(cubicMilesNumber));
        cubicInches.setText("Cubic Inches: "+String.valueOf(cubicInchesNumber));
        cubicMillimeters.setText("Cubic Millimeters: "+String.valueOf(cubicMillimetersNumber));
        cubicCentimeters.setText("Cubic Centimeters: "+String.valueOf(cubicCentimetersNumber));






    }


    public void  setTextViewMeters(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            cubicMetersNumber = Double.valueOf(text);


        }
        else {
            cubicMetersNumber = 1;

        }
        cubicKilometersNumber=cubicMetersNumber*1e-9;

        cubicFeetNumber=cubicMetersNumber*35.3147;


        cubicInchesNumber=cubicMetersNumber*61023.7;
        cubicCentimetersNumber=cubicMetersNumber*1000000;
        cubicMillimetersNumber=cubicMetersNumber*1e+9;





        cubicMilesNumber=cubicMetersNumber*2.39913e-10;


        cubicMeters.setText( "Meters: "+ String.valueOf(cubicMetersNumber));
        cubicKilometers.setText(" cubic Kilometers: "+String.valueOf(cubicKilometersNumber));
        cubicFeet.setText("Cubic Feet: "+ String.valueOf(cubicFeetNumber));
        cubicMiles.setText("CubicMiles: "+String.valueOf(cubicMilesNumber));
        cubicInches.setText("Cubic Inches: "+String.valueOf(cubicInchesNumber));
        cubicMillimeters.setText("Cubic Millimeters: "+String.valueOf(cubicMillimetersNumber));
        cubicCentimeters.setText("Cubic Centimeters: "+String.valueOf(cubicCentimetersNumber));





    }


    public void setTextViewInches(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            cubicInchesNumber = Double.valueOf(text);


        }
        else {
            cubicInchesNumber = 1;

        }
        cubicFeetNumber=cubicInchesNumber*0.000578704;
        cubicMillimetersNumber=cubicInchesNumber*16387.1;
        cubicCentimetersNumber=cubicInchesNumber*16.3871;
        cubicMetersNumber=cubicInchesNumber*1.63871e-5;

        cubicFeet.setText("Cubic Feet: "+ String.valueOf(cubicFeetNumber));

        cubicMeters.setText("Cubic Meters: "+ String.valueOf(cubicMetersNumber));
        cubicInches.setText("Cubic Inches: "+String.valueOf(cubicInchesNumber));
        cubicMillimeters.setText("Cubic Millimeters: "+String.valueOf(cubicMillimetersNumber));
        cubicCentimeters.setText("Cubic Centimeters: "+String.valueOf(cubicCentimetersNumber));
        cubicMiles.setText("n/a");
        cubicKilometers.setText("n/a");



    }


    public void setTextViewMillimeters(){

        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            cubicMillimetersNumber = Double.valueOf(text);


        }
        else {
            cubicMillimetersNumber = 1;

        }
        cubicFeetNumber=cubicMillimetersNumber*3.53147e-8;
        cubicCentimetersNumber=cubicMillimetersNumber*0.001;
        cubicInchesNumber=cubicMillimetersNumber*6.10237e-5;

        cubicMetersNumber=cubicMillimetersNumber*1e-9;

        cubicFeet.setText("Cubic Feet: "+ String.valueOf(cubicFeetNumber));
        cubicMillimeters.setText("Cubic Millimeters: "+String.valueOf(cubicMillimetersNumber));
        cubicCentimeters.setText("Cubic Centimeters: "+String.valueOf(cubicCentimetersNumber));
        cubicMeters.setText("Cubic Meters: "+ String.valueOf(cubicMetersNumber));
        cubicInches.setText("Cubic Inches: "+String.valueOf(cubicInchesNumber));
        cubicMiles.setText("n/a");
        cubicKilometers.setText("n/a");







    }

    public void setTextViewCentimeters(){


        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            cubicCentimetersNumber = Double.valueOf(text);


        }
        else {
            cubicCentimetersNumber = 1;

        }
        cubicFeetNumber=cubicCentimetersNumber*3.53147e-5;
        cubicMillimetersNumber=cubicCentimetersNumber*1000;
        cubicInchesNumber=cubicCentimetersNumber*0.0610237;
        cubicMetersNumber=cubicCentimetersNumber*1e-6;


        cubicFeet.setText("Cubic Feet: "+ String.valueOf(cubicFeetNumber));
        cubicMillimeters.setText("Cubic Millimeters: "+String.valueOf(cubicMillimetersNumber));
        cubicCentimeters.setText("Cubic Centimeters: "+String.valueOf(cubicCentimetersNumber));
        cubicMeters.setText("Cubic Meters: "+ String.valueOf(cubicMetersNumber));
        cubicInches.setText("Cubic Inches: "+String.valueOf(cubicInchesNumber));
        cubicMiles.setText("n/a");
        cubicKilometers.setText("n/a");





    }



}
