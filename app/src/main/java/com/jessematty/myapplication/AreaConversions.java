package com.jessematty.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AreaConversions extends Activity {
    TextView squareFeet;
    TextView squareMiles;
    TextView squareMeters;
    TextView squareKilometers;
    TextView acres;
    TextView hectare;
    TextView squareInches;
    TextView squareMillimeters;
    TextView squareCentimeters;

    EditText numberField;
    Spinner valuesList;
    String valueChoice;



    


    
    


    Button convert;

    
    double squareFeetNumber;
    double squareMilesNumber;
    double squareMetersNumber;
    double squareKilometersNumber;
    double acresNumber;
    double hectacreNumber;

    double squareInchesNumber;
    double squareMillimetersNumber;
    double squareCentimetersNumber;


    public AreaConversions() {
        
        
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createLayout();



    }


    public void createLayout(){
        squareFeet=new TextView(this);
        squareMiles=new TextView(this);
        squareMeters=new TextView(this);
        squareKilometers=new TextView(this);
        acres=new TextView(this);
        hectare= new TextView(this);
        squareInches= new TextView(this);
        squareMillimeters= new TextView(this);
        squareCentimeters= new TextView(this);

        LinearLayout mainLayout= new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);


        valuesList= new Spinner(this);
        ArrayList<String> values= new ArrayList<>();
        values.add("Square Inches");
        values.add("Square Feet");
        values.add("Square Miles");
        values.add("Square Millimeters");
        values.add("Square Centimeters");
        values.add("Square Meters");
        values.add("Square Kilometers" );
        values.add("Acres");
        values.add("Hectacres");









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
                if (valueChoice.equals("Square Kilometers")){

                    setTextViewKilometers();
                }
                else  if (valueChoice.equals("Square Meters")){
                    setTextViewMeters();
                }
                else   if (valueChoice.equals("Square Centimeters")){
                    setTextViewCentimeters();

                }
                else   if (valueChoice.equals("Square Millimeters")){
                    setTextViewMillimeters();
                }
                else   if (valueChoice.equals("Square Miles")){
                    setTextViewMiles();
                }
                else   if (valueChoice.equals("Square Feet")){
                    setTextViewFeet();
                }
                else   if (valueChoice.equals("Acres")){
                    setTextViewAcres();
                }
                else   if (valueChoice.equals("Hectacres")){
                    setTextViewHectacres();
                }
                else   if (valueChoice.equals("Square Inches")){
                    setTextViewInches();
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
        english.setLayoutParams(params);
        english.setGravity(Gravity.CENTER);

        mainLayout.addView(english);
        squareInches.setLayoutParams(params);
        squareInches.setGravity(Gravity.CENTER);


        mainLayout.addView(squareInches);
        squareFeet.setLayoutParams(params);
        squareFeet.setGravity(Gravity.CENTER);

        mainLayout.addView(squareFeet);
        squareMiles.setLayoutParams(params);
        squareMiles.setGravity(Gravity.CENTER);

        mainLayout.addView(squareMiles);
        acres.setLayoutParams(params);
        acres.setGravity(Gravity.CENTER);

        mainLayout.addView(acres);
        TextView metric= new TextView(this);
        metric.setText("Metric Measurements");
        metric.setTextSize(30);
        metric.setTextColor(Color.GREEN);
        metric.setLayoutParams(params);
        metric.setGravity(Gravity.CENTER);

        mainLayout.addView(metric);


        squareMillimeters.setLayoutParams(params);
        squareMillimeters.setGravity(Gravity.CENTER);

        mainLayout.addView(squareMillimeters);
        squareCentimeters.setLayoutParams(params);
        squareCentimeters.setGravity(Gravity.CENTER);
        
        mainLayout.addView(squareCentimeters);

        squareMeters.setLayoutParams(params);
        squareMeters.setGravity(Gravity.CENTER);
            mainLayout.addView(squareMeters);
        squareKilometers.setLayoutParams(params);
        squareKilometers.setGravity(Gravity.CENTER);
            mainLayout.addView(squareKilometers);
        hectare.setLayoutParams(params);
        hectare.setGravity(Gravity.CENTER);
            mainLayout.addView(hectare);








        ScrollView mainView= new ScrollView(this);
        mainView.addView(mainLayout);



        setContentView(mainView);
    }




    public void  setTextViewAcres(){

        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            acresNumber = Double.valueOf(text);


        }
        else {
            acresNumber = 1;

        }

        squareKilometersNumber=acresNumber*.00404686;
        squareFeetNumber=acresNumber*43560;

        squareMilesNumber=acresNumber*0.0015625;

        squareMetersNumber=acresNumber*4046.86;
        hectacreNumber=acresNumber*0.404686;

        squareMeters.setText( "Meters: "+ String.valueOf(squareMetersNumber));
        squareFeet.setText("Square Feet: "+ String.valueOf(squareFeetNumber));
        squareMiles.setText("Square Miles: "+String.valueOf(squareMilesNumber));
        hectare.setText("Hectacres: "+String.valueOf(hectacreNumber));
        acres.setText("Acres: "+String.valueOf(acresNumber));
        squareKilometers.setText(" Square Kilometers: "+String.valueOf(squareKilometersNumber));
        squareCentimeters.setText("n/a");
        squareInches.setText("n/a");
        squareMillimeters.setText("n/a");






    }



    public void  setTextViewKilometers(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            squareKilometersNumber = Double.valueOf(text);


        }
        else {
            squareKilometersNumber = 1;

        }
        acresNumber=squareKilometersNumber*247.105;

        squareFeetNumber=squareKilometersNumber*1.076e+7;


        squareMilesNumber=squareKilometersNumber*0.386102;

        squareMetersNumber=squareKilometersNumber*1000000;
        hectacreNumber=squareKilometersNumber*100;



        squareMeters.setText( "Meters: "+ String.valueOf(squareMetersNumber));
        squareFeet.setText("Square Feet: "+ String.valueOf(squareFeetNumber));
        squareMiles.setText("SquareMiles: "+String.valueOf(squareMilesNumber));
        hectare.setText("Hectacres: "+String.valueOf(hectacreNumber));
        acres.setText("Acres: "+String.valueOf(acresNumber));
        squareKilometers.setText(" Square Kilometers: "+String.valueOf(squareKilometersNumber));

        squareCentimeters.setText("n/a");
        squareInches.setText("n/a");
        squareMillimeters.setText("n/a");







    }



    public void  setTextViewMiles(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            squareMilesNumber = Double.valueOf(text);


        }
        else {
            squareMilesNumber = 1;

        }
        squareKilometersNumber=squareMilesNumber*2.58999;

        squareFeetNumber=squareMilesNumber*2.788e+7;


        acresNumber=squareMilesNumber*640;
        squareMetersNumber=squareMilesNumber*2.59e+6;


        hectacreNumber=squareMilesNumber*258.999;

        squareMeters.setText( "Meters: "+ String.valueOf(squareMetersNumber));
        squareKilometers.setText(" Square Kilometers: "+String.valueOf(squareKilometersNumber));
        squareFeet.setText("Square Feet: "+ String.valueOf(squareFeetNumber));
        squareMiles.setText("SquareMiles: "+String.valueOf(squareMilesNumber));
        hectare.setText("Hectacres: "+String.valueOf(hectacreNumber));
        acres.setText("Acres: "+String.valueOf(acresNumber));
        squareCentimeters.setText("n/a");
        squareInches.setText("n/a");
        squareMillimeters.setText("n/a");






    }

    public void  setTextViewFeet(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            squareFeetNumber = Double.valueOf(text);


        }
        else {
            squareFeetNumber = 1;

        }
        squareKilometersNumber=squareFeetNumber*9.2903e-8;
        squareMilesNumber=squareFeetNumber*3.58701e-8;

        acresNumber=squareFeetNumber*2.29568e-5;

        squareMetersNumber=squareFeetNumber*0.092903;

        hectacreNumber=squareFeetNumber*9.2903e-6;

        squareMeters.setText( "Meters: "+ String.valueOf(squareMetersNumber));
        squareKilometers.setText(" Square Kilometers: "+String.valueOf(squareKilometersNumber));
        squareFeet.setText("Square Feet: "+ String.valueOf(squareFeetNumber));
        squareMiles.setText("SquareMiles: "+String.valueOf(squareMilesNumber));
        hectare.setText("Hectacres: "+String.valueOf(hectacreNumber));
        acres.setText("Acres: "+String.valueOf(acresNumber));






    }


    public void  setTextViewMeters(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            squareMetersNumber = Double.valueOf(text);


        }
        else {
            squareMetersNumber = 1;

        }
        squareKilometersNumber=squareMetersNumber*1e-6;

        squareFeetNumber=squareMetersNumber*10.7639;

        acresNumber=squareMetersNumber*0.000247105;

        squareMilesNumber=squareMetersNumber*3.86102e-7;

        hectacreNumber=squareMetersNumber*0.0001;

        squareMeters.setText( "Meters: "+ String.valueOf(squareMetersNumber));
        squareKilometers.setText(" Square Kilometers: "+String.valueOf(squareKilometersNumber));
        squareFeet.setText("Square Feet: "+ String.valueOf(squareFeetNumber));
        squareMiles.setText("SquareMiles: "+String.valueOf(squareMilesNumber));
        hectare.setText("Hectacres: "+String.valueOf(hectacreNumber));
        acres.setText("Acres: "+String.valueOf(acresNumber));




    }

    public void  setTextViewHectacres(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            hectacreNumber = Double.valueOf(text);


        }
        else {
            hectacreNumber = 1;

        }
        squareKilometersNumber=hectacreNumber*0.01;

        squareFeetNumber=hectacreNumber*107639;
        squareMetersNumber=hectacreNumber*10000;
        

        acresNumber=hectacreNumber*2.47105;
        

        squareMilesNumber=hectacreNumber*0.00386102;

        squareMeters.setText( "Meters: "+ String.valueOf(squareMetersNumber));
        squareKilometers.setText(" Square Kilometers: "+String.valueOf(squareKilometersNumber));
        squareFeet.setText("Square Feet: "+ String.valueOf(squareFeetNumber));
        squareMiles.setText("SquareMiles: "+String.valueOf(squareMilesNumber));
        hectare.setText("Hectacres: "+String.valueOf(hectacreNumber));
        acres.setText("Acres: "+String.valueOf(acresNumber));
        squareCentimeters.setText("n/a");
        squareInches.setText("n/a");
        squareMillimeters.setText("n/a");





    }

    public void setTextViewInches(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            squareInchesNumber = Double.valueOf(text);


        }
        else {
            squareInchesNumber = 1;

        }
        squareFeetNumber=squareInchesNumber*0.00694444;
        squareMillimetersNumber=squareInchesNumber*645.16;
        squareCentimetersNumber=squareInchesNumber*6.4516;
        squareMetersNumber=squareInchesNumber*0.00064516;

        squareFeet.setText("Square Feet: "+ String.valueOf(squareFeetNumber));
        squareMillimeters.setText("Square Millimeters: "+String.valueOf(squareMillimetersNumber));
        squareCentimeters.setText("Square Centimeters: "+String.valueOf(squareCentimetersNumber));
        squareMeters.setText("Square Meters: "+ String.valueOf(squareMetersNumber));
        squareInches.setText("Square Inches: "+String.valueOf(squareInchesNumber));
        squareMiles.setText("n/a");
       acres.setText("n/a");
       hectare.setText("n/a");
       squareKilometers.setText("n/a");



    }


    public void setTextViewMillimeters(){

        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            squareMillimetersNumber = Double.valueOf(text);


        }
        else {
            squareMillimetersNumber = 1;

        }
        squareFeetNumber=squareMillimetersNumber*1.07639e-5;
        squareCentimetersNumber=squareMillimetersNumber*0.01;
        squareInchesNumber=squareMillimetersNumber*0.00155;
        squareMetersNumber=squareMillimetersNumber*1e-6;

        squareFeet.setText("Square Feet: "+ String.valueOf(squareFeetNumber));
        squareMillimeters.setText("Square Millimeters: "+String.valueOf(squareMillimetersNumber));
        squareCentimeters.setText("Square Centimeters: "+String.valueOf(squareCentimetersNumber));
        squareMeters.setText("Square Meters: "+ String.valueOf(squareMetersNumber));
        squareInches.setText("Square Inches: "+String.valueOf(squareInchesNumber));
        squareMiles.setText("n/a");
        acres.setText("n/a");
        hectare.setText("n/a");
        squareKilometers.setText("n/a");







    }

    public void setTextViewCentimeters(){


        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            squareCentimetersNumber = Double.valueOf(text);


        }
        else {
            squareCentimetersNumber = 1;

        }
        squareFeetNumber=squareCentimetersNumber*0.00107639;
        squareMillimetersNumber=squareCentimetersNumber*100;
        squareInchesNumber=squareCentimetersNumber*0.155;
        squareMetersNumber=squareCentimetersNumber*0.0001;


        squareFeet.setText("Square Feet: "+ String.valueOf(squareFeetNumber));
        squareMillimeters.setText("Square Millimeters: "+String.valueOf(squareMillimetersNumber));
        squareCentimeters.setText("Square Centimeters: "+String.valueOf(squareCentimetersNumber));
        squareMeters.setText("Square Meters: "+ String.valueOf(squareMetersNumber));
        squareInches.setText("Square Inches: "+String.valueOf(squareInchesNumber));
        squareMiles.setText("n/a");
        acres.setText("n/a");
        hectare.setText("n/a");
        squareKilometers.setText("n/a");





    }




}
