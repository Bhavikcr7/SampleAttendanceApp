package com.example.app.sampleattendanceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class finalDisplay extends AppCompatActivity {

    StringBuffer sb=new StringBuffer(1000);
    StringBuffer defaulter=new StringBuffer(1000);
    TextView  myResultText;
    Button back,email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_display);

        myResultText=(TextView)findViewById(R.id.textView55);
        back=(Button)findViewById(R.id.backButton);
        email=(Button)findViewById(R.id.gmailbutton);
        //def=(Button)findViewById(R.id.defButton);



        Intent divToFinaDisplay = getIntent();
        Bundle extras = getIntent().getExtras();

        HashMap<String, Integer> dataReceived = (HashMap<String, Integer>)divToFinaDisplay.getSerializableExtra("finalData");
        final int noOfDays=divToFinaDisplay.getIntExtra("no of days",0);
        ArrayList<String> ogList =(ArrayList<String>)divToFinaDisplay.getSerializableExtra("original List");
        String totalDays = String.valueOf(noOfDays);

        for(int j=0;j<ogList.size();j++)
        {   Iterator<Map.Entry<String, Integer>> i3 = dataReceived.entrySet().iterator();
            while (i3.hasNext())
            {
                Map.Entry<String, Integer> e3 = i3.next();
                String key3 = e3.getKey();
                Integer value3 = e3.getValue();
                if(ogList.get(j).equals(key3))
                {
                    String valueString = value3.toString();


                    //System.out.println();

                    double percentage;
                    percentage = (value3 * 100.0)/noOfDays;
                    DecimalFormat numberFormat = new DecimalFormat("#.00");

                    String percentageAttendance = String.valueOf(numberFormat.format(percentage));
                    if(percentage <= 50.0)
                    {
                        defaulter.append(key3 + "->" + valueString + "/" + totalDays + " " + "Attendance Percentage-->" + percentageAttendance + "\n" + "\n");
                    }
                    sb.append(key3 + "-> " + valueString + "/" + totalDays + " " + "Attendance Percentage-->" + percentageAttendance + "\n" + "\n");
                }
            }
        }
        myResultText.setText(sb.toString());



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(finalDisplay.this,profilePage.class);
                startActivity(i);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuffer subject=new StringBuffer(19);
                subject.append(" attendance statistics ");

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "");
                intent.putExtra(Intent.EXTRA_SUBJECT, subject.toString());
                intent.putExtra(Intent.EXTRA_TEXT, sb.toString());

                startActivity(Intent.createChooser(intent, "Send Email"));

            }
        });


        //def.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View view) {

             //   StringBuffer subject1=new StringBuffer(19);
               // subject1.append(" defaulter's statistics ");

                //Intent intent = new Intent(Intent.ACTION_SEND);
                //intent.setType("text/html");
                //intent.putExtra(Intent.EXTRA_EMAIL, "");
                //intent.putExtra(Intent.EXTRA_SUBJECT, subject1.toString());
                //intent.putExtra(Intent.EXTRA_TEXT, defaulter.toString());

                //startActivity(Intent.createChooser(intent, "Send Email"));

          //  }
        //});



    }
}
