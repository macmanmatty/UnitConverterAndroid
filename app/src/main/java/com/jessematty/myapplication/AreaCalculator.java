package com.jessematty.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class AreaCalculator extends Activity {


    TextView area;

    Button circleButton;
    Button ellipseButton;
    Button rectangleButton;
    Button triangleButton;


    EditText length;
    EditText width;
    EditText radius;
    EditText radius2;
    double radiusNumber;
    double radius2Number;
    double lengthNumber;
    double widthNumber;


    double circleAreaNumber;
    double  rectangleAreaNumber;
    double traingleAreaNumber;










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mainLayout= new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        circleButton= new Button(this);
        circleButton.setText("Calculate Circle Area");
        circleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                circleArea();
            }
        });
        ellipseButton= new Button(this);
        ellipseButton.setText("Calculate Ellispe Area");



        ellipseButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                ellipseArea();
            }
        });



        rectangleButton= new Button(this);

        rectangleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangleArea();
            }
        });
        rectangleButton.setText("Calculate Rectangle Area");
        triangleButton= new Button(this);

        triangleButton.setText("Calculate Triangle Area");


        triangleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                triangleArea();
            }
        });

        area= new TextView(this);

        length=new EditText(this);
        width=new EditText(this);
        radius=new EditText(this);
        radius2=new EditText(this);
        length.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL );
        width.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL );
        radius.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL );
        radius2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL );



        LinearLayout radiusLayout= new LinearLayout(this);
        radiusLayout.setOrientation(LinearLayout.HORIZONTAL);
        TextView radius= new TextView(this);
        radius.setText("radius ");

        radiusLayout.addView(radius);
        radiusLayout.addView(this.radius);



        LinearLayout radius2Layout= new LinearLayout(this);
        radius2Layout.setOrientation(LinearLayout.HORIZONTAL);
        TextView radius2= new TextView(this);
        radius2.setText("radius2 ");
        radius2Layout.addView(radius2);
        radius2Layout.addView(this.radius2);


        LinearLayout widthLayout= new LinearLayout(this);
        widthLayout.setOrientation(LinearLayout.HORIZONTAL);
        TextView width= new TextView(this);
        width.setText("width ");

        widthLayout.addView(width);
        widthLayout.addView(this.width);


        LinearLayout heightLayout= new LinearLayout(this);
        heightLayout.setOrientation(LinearLayout.HORIZONTAL);
        TextView height= new TextView(this);
        height.setText("height ");

        heightLayout.addView(height);
        heightLayout.addView(this.length);






        LinearLayout circleLayout= new LinearLayout(this);
        circleLayout.setOrientation(LinearLayout.HORIZONTAL);
        circleLayout.addView(circleButton);



        LinearLayout ellipseLayout= new LinearLayout(this);
        ellipseLayout.setOrientation(LinearLayout.HORIZONTAL);
        ellipseLayout.addView(ellipseButton);


        LinearLayout rectangleLayout= new LinearLayout(this);
        rectangleLayout.setOrientation(LinearLayout.HORIZONTAL);
        rectangleLayout.addView(rectangleButton);


        LinearLayout triangleLayout= new LinearLayout(this);
        triangleLayout.setOrientation(LinearLayout.HORIZONTAL);
        triangleLayout.addView(triangleButton);


        LinearLayout areaLayout= new LinearLayout(this);
        TextView areaText= new TextView(this);
        areaText.setText(" Calculated Area");
        areaText.setTextSize(28);
        areaLayout.addView(areaText);
        areaLayout.addView(area);
        areaText.setTextColor(Color.GREEN);
        areaLayout.setOrientation(LinearLayout.VERTICAL);



        mainLayout.addView(radiusLayout);
        mainLayout.addView(radius2Layout);
        mainLayout.addView(widthLayout);
        mainLayout.addView(heightLayout);
        mainLayout.addView(circleLayout);
        mainLayout.addView(ellipseLayout);
        mainLayout.addView(rectangleLayout);
        mainLayout.addView(triangleLayout);
        mainLayout.addView(areaLayout);


        ScrollView mainView= new ScrollView(this);
        mainView.addView(mainLayout);



        setContentView(mainView);

    }

    public void circleArea(){

        String text =String.valueOf(radius.getText());

        if(text!=null && !text.isEmpty()) {
            radiusNumber = Double.valueOf(text);


        }
        else {
            radiusNumber = 1;

        }

        circleAreaNumber=radiusNumber*radiusNumber*Math.PI;
        area.setText("Circle Area: "+circleAreaNumber);





    }

    public void ellipseArea(){

        String text =String.valueOf(radius.getText());

        if(text!=null && !text.isEmpty()) {
            radiusNumber = Double.valueOf(text);


        }
        else {
            radiusNumber = 1;

        }
        String text2 =String.valueOf(radius2.getText());

        if(text2!=null && !text2.isEmpty()) {
            radius2Number = Double.valueOf(text2);


        }
        else {
            radius2Number = 1;

        }

        circleAreaNumber=radiusNumber*radius2Number*Math.PI;

        area.setText("Ellsipe Area: "+circleAreaNumber);

    }


    public void rectangleArea(){
        String text =String.valueOf(length.getText());

        if(text!=null && !text.isEmpty()) {
            lengthNumber = Double.valueOf(text);


        }
        else {
            lengthNumber = 1;

        }
        String text2 =String.valueOf(width.getText());

        if(text2!=null && !text2.isEmpty()) {
            widthNumber = Double.valueOf(text2);


        }
        else {
            widthNumber = 1;

        }

        rectangleAreaNumber=lengthNumber*widthNumber;


        area.setText("Rectangle Area: "+rectangleAreaNumber);


    }

    public void triangleArea(){

        String text =String.valueOf(length.getText());

        if(text!=null && !text.isEmpty()) {
            lengthNumber = Double.valueOf(text);


        }
        else {
            lengthNumber = 1;

        }
        String text2 =String.valueOf(width.getText());

        if(text2!=null && !text2.isEmpty()) {
            widthNumber = Double.valueOf(text2);


        }
        else {
            widthNumber = 1;

        }


        traingleAreaNumber=(lengthNumber*widthNumber)/2;
        area.setText("Traingle Area: "+traingleAreaNumber);



    }

}
