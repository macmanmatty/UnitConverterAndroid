package com.jessematty.myapplication;

import android.app.Activity;
import android.graphics.Color;
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


public class WeightConversions extends Activity {

    TextView kilograms;
    TextView grams;
    TextView  pounds;
    TextView ounces;
    TextView tons;
    TextView metricTons;

    EditText numberField;

    Spinner valuesList;
    String valueChoice;


    Button convert;



    double kilogramsNumber;
    double gramsNumber;
    double  poundsNumber;
    double ouncesNumber;
    double tonsNumber;
    double metricTonsNumber;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createLayout();
    }

    public void createLayout(){
        LinearLayout mainLayout= new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
         kilograms= new TextView(this);
         grams= new TextView(this);
          pounds= new TextView(this);
         ounces= new TextView(this);
         tons= new TextView(this);
         metricTons= new TextView(this);


        valuesList= new Spinner(this);
        ArrayList<String> values= new ArrayList<>();
        values.add("Ounces");
        values.add("Pounds");
        values.add("Tons");
        values.add("Grams");
        values.add("Kilograms");
        values.add("Metric Tons");






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
                if (valueChoice.equals("Ounces")){

                    setTextViewOunces();

                }
                else  if (valueChoice.equals("Pounds")){
                    setTextViewPounds();
                }
                else   if (valueChoice.equals("Tons")){
                    setTextViewTons();

                }
                else   if (valueChoice.equals("Grams")){
                    setTextViewGrams();
                }
                else   if (valueChoice.equals("Kilograms")){
                    setTextViewKilograms();
                }
                else   if (valueChoice.equals("Metric Tons")){
                    setTextViewMetricTons();
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
        english.setTextColor(Color.RED);
        english.setLayoutParams(params);
        english.setGravity(Gravity.CENTER);

        mainLayout.addView(english);
      


        mainLayout.addView(ounces);
        ounces.setLayoutParams(params);
        ounces.setGravity(Gravity.CENTER);

        mainLayout.addView(pounds);
        pounds.setLayoutParams(params);
        pounds.setGravity(Gravity.CENTER);

        mainLayout.addView(tons);
        tons.setLayoutParams(params);
        tons.setGravity(Gravity.CENTER);

        TextView metric= new TextView(this);
        metric.setText("Metric Measurements");
        metric.setTextSize(30);
        metric.setTextColor(Color.GREEN);
        metric.setLayoutParams(params);
        metric.setGravity(Gravity.CENTER);



        mainLayout.addView(metric);

        mainLayout.addView(grams);
        grams.setLayoutParams(params);
        grams.setGravity(Gravity.CENTER);

        mainLayout.addView(kilograms);
        kilograms.setLayoutParams(params);
        kilograms.setGravity(Gravity.CENTER);

        mainLayout.addView(metricTons);
        metricTons.setLayoutParams(params);
        metricTons.setGravity(Gravity.CENTER);




        ScrollView mainView= new ScrollView(this);
        mainView.addView(mainLayout);



        setContentView(mainView);





    }

    public void  convertMetric(double kilogramsNumber){
        poundsNumber=kilogramsNumber*2.20462;
        ouncesNumber=kilogramsNumber*35.274;
        tonsNumber=kilogramsNumber*0.00110231;
        metricTonsNumber=kilogramsNumber*0.001;
        gramsNumber=kilogramsNumber*1000;



    }


    public void  convertEnglish(double poundsNumber){
        kilogramsNumber=poundsNumber*0.453592;
        ouncesNumber=poundsNumber*16;
        tonsNumber=poundsNumber*0.0005;

        metricTonsNumber=poundsNumber*0.000453592;
        gramsNumber=poundsNumber*453.592;




    }



    public void setTextViewKilograms(){

        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            kilogramsNumber = Double.valueOf(text);


        }
        else {
            kilogramsNumber = 1;

        }





        convertMetric(kilogramsNumber);


        ounces.setText("Ounces: "+ouncesNumber);
        pounds.setText("Pounds: "+poundsNumber);
        metricTons.setText("Metric Tons: "+metricTonsNumber);
        kilograms.setText("Kilograms: "+kilogramsNumber);
        grams.setText("Grams: "+gramsNumber);
        tons.setText("Tons: "+tonsNumber);











    }





    public void setTextViewPounds(){

        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            poundsNumber = Double.valueOf(text);


        }
        else {
            poundsNumber = 1;

        }



        convertEnglish(poundsNumber);
        this.poundsNumber=poundsNumber;

        ounces.setText("Ounces: "+ouncesNumber);
        pounds.setText("Pounds: "+poundsNumber);
        metricTons.setText("Metric Tons: "+metricTonsNumber);
        kilograms.setText("Kilograms: "+kilogramsNumber);
        grams.setText("Grams: "+gramsNumber);
        tons.setText("Tons: "+tonsNumber);



    }


    public void setTextViewOunces(){


        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
           ouncesNumber = Double.valueOf(text);


        }
        else {
           ouncesNumber = 1;

        }
        poundsNumber=ouncesNumber/16;


        convertEnglish(poundsNumber);

        ounces.setText("Ounces: "+ouncesNumber);
        pounds.setText("Pounds: "+poundsNumber);
        metricTons.setText("Metric Tons: "+metricTonsNumber);
        kilograms.setText("Kilograms: "+kilogramsNumber);
        grams.setText("Grams: "+gramsNumber);
        tons.setText("Tons: "+tonsNumber);



    }



    public void setTextViewGrams(){


        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
           gramsNumber = Double.valueOf(text);


        }
        else {
            gramsNumber = 1;

        }


        kilogramsNumber=gramsNumber*0.001;

        convertMetric(kilogramsNumber);

        this.gramsNumber=gramsNumber;
        ounces.setText("Ounces: "+ouncesNumber);
        pounds.setText("Pounds: "+poundsNumber);
        metricTons.setText("Metric Tons: "+metricTonsNumber);
        kilograms.setText("Kilograms: "+kilogramsNumber);
        grams.setText("Grams: "+gramsNumber);
        tons.setText("Tons: "+tonsNumber);



    }



    public void setTextViewTons(){

        String text =String.valueOf(numberField.getText());

        if(text!=null && !text.isEmpty()) {
            tonsNumber = Double.valueOf(text);


        }
        else {
           tonsNumber = 1;

        }


        poundsNumber=tonsNumber*2000;
        convertEnglish(poundsNumber);

        ounces.setText("Ounces: "+ouncesNumber);
        pounds.setText("Pounds: "+poundsNumber);
        metricTons.setText("Metric Tons: "+metricTonsNumber);
        kilograms.setText("Kilograms: "+kilogramsNumber);
        grams.setText("Grams: "+gramsNumber);
        tons.setText("Tons: "+tonsNumber);



    }



    public void setTextViewMetricTons(){


        String text =String.valueOf(numberField.getText());
        
        if(text!=null && !text.isEmpty()) {
            metricTonsNumber = Double.valueOf(text);


        }
        else {
            metricTonsNumber = 1;

        }
        

        kilogramsNumber=metricTonsNumber*1000;
        convertMetric(kilogramsNumber);


        ounces.setText("Ounces: "+ouncesNumber);
        pounds.setText("Pounds: "+poundsNumber);
        metricTons.setText("Metric Tons: "+metricTonsNumber);
        kilograms.setText("Kilograms: "+kilogramsNumber);
        grams.setText("Grams: "+gramsNumber);
        tons.setText("Tons: "+tonsNumber);




    }
}
