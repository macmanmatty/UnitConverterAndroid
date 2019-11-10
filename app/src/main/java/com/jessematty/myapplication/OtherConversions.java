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

public class OtherConversions extends Activity {
    TextView degreesF;
    TextView degreesC;
    TextView degreesK;
    TextView pascals;
    TextView kilopascals;
    TextView bars;
    TextView  atmospheres;
    TextView torrs;
    TextView joule;
    TextView calorie;



    EditText numberField;

    Spinner valuesList;
    String valueChoice;





    Button convert;







    double degreesFNumber;
    double degreesCNumber;
    double degreesKNumber;
    double pascalsNumber;
    double kilopascalsNumber;
    double barsNumber;
    double  atmospheresNumber;
    double torrsNumber;
    double jouleNumber;
    double calorieNumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        valuesList= new Spinner(this);
        ArrayList<String> values= new ArrayList<>();
        values.add("Pascals");
        values.add("Kilopascals");
        values.add("Atmospheres");
        values.add("Torres");
        values.add("Barrs");
        values.add("Degrees F");
        values.add("Degrees C");
        values.add("Degrees K");
        values.add("Joules");
        values.add("Calories");


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



        LinearLayout mainLayout = new LinearLayout(this);
        // specifying vertical orientation
        mainLayout.setOrientation(LinearLayout.VERTICAL);


        TextView title= new TextView(this);
        title.setText(" Other Conversions");
        title.setTextSize(40);
        title.setTypeface(null, Typeface.BOLD);
        mainLayout.addView(title);
        // creating LinearLayout

        degreesF= new TextView(this);
        
        degreesC= new TextView(this);
        degreesK= new TextView(this);
        pascals= new TextView(this);
        kilopascals= new TextView(this);
        bars= new TextView(this);
         atmospheres= new TextView(this);
        torrs= new TextView(this);
        joule= new TextView(this);
        calorie= new TextView(this);

         convert = new Button(this);
        convert.setText("Convert");



        convert.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (valueChoice.equals("Calories")){

                    convertCalories();
                }
                else  if (valueChoice.equals("Joules")){
                    convertJoules();
                }
                else   if (valueChoice.equals("Barrs")){
                    convertBarrs();
                }
                else   if (valueChoice.equals("Torres")){
                    convertTorres();
                }
                else   if (valueChoice.equals("Atmospheres")){
                    convertAtmospheres();
                }
                else   if (valueChoice.equals("Pascals")){
                   convertPascals();
                }
                else   if (valueChoice.equals("Kilopascals")){
                    convertKiloPascals();
                }
                else   if (valueChoice.equals("Degrees C")){
                    convertDegreesC();
                }
                else   if (valueChoice.equals("Degrees F")){
                    convertDegreesF();
                }
                else   if (valueChoice.equals("Degrees K")){
                    convertDegreesK();
                }




            }
        });




        numberField= new EditText(this);


        numberField.setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);






        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,100);







        LinearLayout enterText= new LinearLayout(this);
        enterText.setOrientation(LinearLayout.HORIZONTAL);
        enterText.addView(numberField);
        enterText.addView(valuesList);
        enterText.addView(convert);
        mainLayout.addView(enterText);







        



        params= new LayoutParams(LayoutParams.FILL_PARENT, 80);
        TextView temp= new TextView(this);
        temp.setText("Temperature Measurments");
        temp.setTextColor(Color.GREEN);
        temp.setTextSize(25);
        mainLayout.addView(temp);


        degreesC.setLayoutParams(params);
        degreesC.setGravity(Gravity.CENTER);
        mainLayout.addView(degreesC);


        degreesF.setLayoutParams(params);
        degreesF.setGravity(Gravity.CENTER);
        mainLayout.addView(degreesF);



        degreesK.setLayoutParams(params);
        degreesK.setGravity(Gravity.CENTER);
        mainLayout.addView(degreesK);
        
        
        TextView english= new TextView(this);
        english.setText("Pressure Measurements");
        english.setTextColor(Color.RED);
        english.setTextSize(25);

        temp.setLayoutParams(params);
        temp.setGravity(Gravity.CENTER);

        english.setLayoutParams(params);
        english.setGravity(Gravity.CENTER);
        mainLayout.addView(english);




        bars.setLayoutParams(params);
        bars.setGravity(Gravity.CENTER);
        mainLayout.addView(bars);




        atmospheres.setLayoutParams(params);
        atmospheres.setGravity(Gravity.CENTER);
        mainLayout.addView(atmospheres);


        kilopascals.setLayoutParams(params);
        kilopascals.setGravity(Gravity.CENTER);
        mainLayout.addView(kilopascals);




        pascals.setLayoutParams(params);
        pascals.setGravity(Gravity.CENTER);
        mainLayout.addView(pascals);


        torrs.setLayoutParams(params);
        torrs.setGravity(Gravity.CENTER);
        mainLayout.addView(torrs);




        TextView energy2= new TextView(this);
        energy2.setText("Energy Measurements");
        energy2.setTextColor(Color.RED);
        energy2.setTextSize(25);

        
        energy2.setLayoutParams(params);
        energy2.setGravity(Gravity.CENTER);
        mainLayout.addView(energy2);




        joule.setLayoutParams(params);
        joule.setGravity(Gravity.CENTER);
        mainLayout.addView(joule);




        calorie.setLayoutParams(params);
        calorie.setGravity(Gravity.CENTER);
        mainLayout.addView(calorie);






        ScrollView  mainView= new ScrollView(this);
        mainView.addView(mainLayout);



        setContentView(mainView);


    }


    public void  convertDegreesF(){

        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            degreesFNumber = Double.valueOf(text);


        }
        else {
            degreesFNumber = 1;

        }
        degreesCNumber=(degreesFNumber-32.0)*(5.0/9.0);
        degreesKNumber=degreesCNumber+273.15;
        degreesF.setText("Degrees F "+degreesFNumber);
        degreesC.setText("Degrees C "+degreesCNumber);
        degreesK.setText("Degrees K "+degreesKNumber);






    }


    public void  convertDegreesC(){

        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            degreesCNumber = Double.valueOf(text);


        }
        else {
            degreesCNumber = 1;

        }

        System.out.println("degrees c" + degreesCNumber);

        degreesFNumber=(degreesCNumber*(9.0/5.0))+32.0;
        System.out.println("degrees f " + degreesFNumber);
        degreesKNumber=degreesCNumber+273.15;
        degreesF.setText("Degrees F "+degreesFNumber);
        degreesC.setText("Degrees C "+degreesCNumber);
        degreesK.setText("Degrees K "+degreesKNumber);


    }

    public void  convertDegreesK(){

        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            degreesKNumber = Double.valueOf(text);


        }
        else {
            degreesKNumber = 1;

        }        degreesCNumber=degreesKNumber-273.15;

        degreesFNumber=(degreesCNumber*(9/5))+32;
        degreesF.setText("Degrees F "+degreesFNumber);
        degreesC.setText("Degrees C "+degreesCNumber);
        degreesK.setText("Degrees K "+degreesKNumber);


    }
    public void  convertPascals(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            pascalsNumber = Double.valueOf(text);


        }
        else {
            pascalsNumber = 1;

        }     
        
        kilopascalsNumber=pascalsNumber*.001;
       atmospheresNumber=pascalsNumber/101325;
       barsNumber=pascalsNumber/100000;
       torrsNumber=pascalsNumber/133.322;
        pascals.setText("Pascals "+pascalsNumber);

        kilopascals.setText("Kilopascals "+kilopascalsNumber);

        bars.setText("Barrs "+barsNumber);
        atmospheres.setText("Atmospheres "+atmospheresNumber);


        torrs.setText("Torrs "+torrsNumber);






    }

    public void  convertKiloPascals(){

        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            kilopascalsNumber = Double.valueOf(text);


        }
        else {
            kilopascalsNumber = 1;

        }
        pascalsNumber=kilopascalsNumber/.001;
        atmospheresNumber=pascalsNumber/101325;
        barsNumber=pascalsNumber/100000;
        torrsNumber=pascalsNumber/133.322;
        pascals.setText("Pascals "+pascalsNumber);

        kilopascals.setText("Kilopascals "+kilopascalsNumber);

        bars.setText("Barrs "+barsNumber);
        atmospheres.setText("Atmospheres "+atmospheresNumber);


        torrs.setText("Torrs "+torrsNumber);



    }

    public void  convertBarrs(){

        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            barsNumber = Double.valueOf(text);


        }
        else {
            barsNumber = 1;

        }        
        
        
        pascalsNumber=barsNumber*100000;
        kilopascalsNumber=pascalsNumber*.001;
        atmospheresNumber=pascalsNumber/101325;
        torrsNumber=pascalsNumber/133.322;
        pascals.setText("Pascals "+pascalsNumber);

        kilopascals.setText("Kilopascals "+kilopascalsNumber);

        bars.setText("Barrs "+barsNumber);
        atmospheres.setText("Atmospheres "+atmospheresNumber);


        torrs.setText("Torrs "+torrsNumber);



    }

    public void  convertAtmospheres(){

        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            atmospheresNumber = Double.valueOf(text);


        }
        else {
            atmospheresNumber = 1;

        }
        
        
        pascalsNumber=atmospheresNumber*101325;
        kilopascalsNumber=pascalsNumber*.001;
        torrsNumber=pascalsNumber/133.322;
        barsNumber=pascalsNumber/100000;

        pascals.setText("Pascals "+pascalsNumber);

        kilopascals.setText("Kilopascals "+kilopascalsNumber);

        bars.setText("Barrs "+barsNumber);
        atmospheres.setText("Atmospheres "+atmospheresNumber);


        torrs.setText("Torrs "+torrsNumber);

    }


    public void  convertTorres(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            torrsNumber = Double.valueOf(text);


        }
        else {
            torrsNumber = 1;

        }        
        
        
        
        pascalsNumber=torrsNumber*133.322;
        kilopascalsNumber=pascalsNumber*.001;
        barsNumber=pascalsNumber/100000;

        pascals.setText("Pascals "+pascalsNumber);

        kilopascals.setText("Kilopascals "+kilopascalsNumber);

        bars.setText("Barrs "+barsNumber);
        atmospheres.setText("Atmospheres "+atmospheresNumber);


        torrs.setText("Torrs "+torrsNumber);


    }

     public void  convertJoules(){
         String text =String.valueOf(numberField.getText());

         if(text!=null && !text.isEmpty()) {
             jouleNumber = Double.valueOf(text);


         }
         else {
             jouleNumber = 1;

         }

          calorieNumber=jouleNumber/4184;
         joule.setText("Joules "+jouleNumber);


         calorie.setText("Calories "+calorieNumber);



     }

    public void  convertCalories(){
        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            calorieNumber = Double.valueOf(text);


        }
        else {
            calorieNumber = 1;

        }

        jouleNumber=calorieNumber*4184;
        joule.setText("Joules "+jouleNumber);


        calorie.setText("Calories "+calorieNumber);



    }




}
