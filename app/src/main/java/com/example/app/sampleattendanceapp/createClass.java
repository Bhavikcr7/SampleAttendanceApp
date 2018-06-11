package com.example.app.sampleattendanceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class createClass extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;



    TextView mainText;
    EditText r1,n1,r2,n2,r3,n3,r4,n4,r5,n5,r6,n6,r7,n7,r8,n8,r9,n9,r10,n10,r11,n11,r12,n12;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,submit;
    StringBuffer sb=new StringBuffer(50);
    ArrayList<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_class);


        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference = FirebaseDatabase.getInstance().getReference();





        //StringBuffer sb=new StringBuffer(50);

        r1=(EditText)findViewById(R.id.roll1);
        r2=(EditText)findViewById(R.id.roll2);
        r3=(EditText)findViewById(R.id.roll3);
        r4=(EditText)findViewById(R.id.roll4);
        r5=(EditText)findViewById(R.id.roll5);
        r6=(EditText)findViewById(R.id.roll6);
        r7=(EditText)findViewById(R.id.roll7);
        r8=(EditText)findViewById(R.id.roll8);
        r9=(EditText)findViewById(R.id.roll9);
        r10=(EditText)findViewById(R.id.roll10);
        r11=(EditText)findViewById(R.id.roll11);
        r12=(EditText)findViewById(R.id.roll12);


        n1=(EditText)findViewById(R.id.name1);
        n2=(EditText)findViewById(R.id.name2);
        n3=(EditText)findViewById(R.id.name3);
        n4=(EditText)findViewById(R.id.name4);
        n5=(EditText)findViewById(R.id.name5);
        n6=(EditText)findViewById(R.id.name6);
        n7=(EditText)findViewById(R.id.name7);
        n8=(EditText)findViewById(R.id.name8);
        n9=(EditText)findViewById(R.id.name9);
        n10=(EditText)findViewById(R.id.name10);
        n11=(EditText)findViewById(R.id.name11);
        n12=(EditText)findViewById(R.id.name12);


        b1=(Button)findViewById(R.id.add1);
        b2=(Button)findViewById(R.id.add2);
        b3=(Button)findViewById(R.id.add3);
        b4=(Button)findViewById(R.id.add4);
        b5=(Button)findViewById(R.id.add5);
        b6=(Button)findViewById(R.id.add6);
        b7=(Button)findViewById(R.id.add7);
        b8=(Button)findViewById(R.id.add8);
        b9=(Button)findViewById(R.id.add9);
        b10=(Button)findViewById(R.id.add10);
        b11=(Button)findViewById(R.id.add11);
        b12=(Button)findViewById(R.id.add12);


        submit=(Button)findViewById(R.id.submit);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(r1.getText().toString()+ " " + n1.getText().toString());
                list.add(sb.toString());

                sb.delete(0, sb.length());
            }}
            );

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(r2.getText().toString()+ " " + n2.getText().toString());



                list.add(sb.toString());

                sb.delete(0, sb.length());
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(r3.getText().toString()+ " " + n3.getText().toString());


                list.add(sb.toString());

                sb.delete(0, sb.length());
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(r4.getText().toString()+ " " + n4.getText().toString());



                list.add(sb.toString());

                sb.delete(0, sb.length());
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(r5.getText().toString()+ " " + n5.getText().toString());



                list.add(sb.toString());

                sb.delete(0, sb.length());
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(r6.getText().toString()+ " " + n6.getText().toString());


                list.add(sb.toString());

                sb.delete(0, sb.length());
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(r7.getText().toString()+ " " + n7.getText().toString());



                list.add(sb.toString());

                sb.delete(0, sb.length());
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(r8.getText().toString()+ " " + n8.getText().toString());



                list.add(sb.toString());

                sb.delete(0, sb.length());
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(r9.getText().toString()+ " " + n9.getText().toString());

                list.add(sb.toString());

                sb.delete(0, sb.length());
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(r10.getText().toString()+ " " + n10.getText().toString());



                list.add(sb.toString());

                sb.delete(0, sb.length());
            }
        });

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(r11.getText().toString()+ " " + n11.getText().toString());



                list.add(sb.toString());

                sb.delete(0, sb.length());
            }
        });

        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(r12.getText().toString()+ " " + n12.getText().toString());


                list.add(sb.toString());

                sb.delete(0, sb.length());
            }
        });

    submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Intent i=new Intent(createClass.this,profilePage.class);

            HashMap<String, Integer> dataToStore = new  HashMap<String, Integer>();


            for(int i=0;i<list.size();i++)
            {

             dataToStore.put(list.get(i),new Integer(i));

            }

            FirebaseUser user = firebaseAuth.getCurrentUser();


            databaseReference.child(user.getUid()).child("ListOfStudents").setValue(dataToStore);


            Toast.makeText(createClass.this, "Successfully Created", Toast.LENGTH_LONG).show();

            Intent i=new Intent(createClass.this,profilePage.class);

            startActivity(i);




            //i.putExtra("classList",list);
            //startActivity(i);
        }
    });




    }
}
