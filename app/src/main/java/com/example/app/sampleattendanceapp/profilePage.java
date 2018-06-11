package com.example.app.sampleattendanceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class profilePage extends AppCompatActivity {


    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    TextView profilePage_name,profilePage_email;//profilePage_division;

    Button profilePage_takeAttendance,profilePage_logout,profilePage_createClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        firebaseAuth=FirebaseAuth.getInstance();

        FirebaseUser user=firebaseAuth.getCurrentUser();

        databaseReference= FirebaseDatabase.getInstance().getReference();

        profilePage_name=(TextView)findViewById(R.id.profilePage_name);
        profilePage_email=(TextView)findViewById(R.id.profilePage_email);
        //profilePage_division=(TextView)findViewById(R.id.profilePage_division);

        profilePage_takeAttendance=(Button)findViewById(R.id.profilePage_takeAttendance);
        profilePage_logout=(Button)findViewById(R.id.profilePage_logOut);
        profilePage_createClass=(Button)findViewById(R.id.createClass);


        databaseReference.child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                TeacherInfo t=dataSnapshot.getValue(TeacherInfo.class);
                profilePage_name.setText(t.tname);
                profilePage_email.setText(t.temail);
                //profilePage_division.setText(t.tdivision);
                //div.append(t.tdivision);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });




        Intent i = getIntent();
        Bundle extras = getIntent().getExtras();


        final ArrayList<String> classListFinal =(ArrayList<String>)i.getSerializableExtra("classList");

        profilePage_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                firebaseAuth.signOut();

                Intent i= new Intent(profilePage.this,LoginPage.class);
                startActivity(i);

            }
        });


        profilePage_createClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3=new Intent(profilePage.this,createClass.class);
                startActivity(i3);
            }
        });



        profilePage_takeAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //final ArrayList<String> finalLst= new ArrayList<String>();
                FirebaseUser user = firebaseAuth.getCurrentUser();

                databaseReference.child(user.getUid()).child("ListOfStudents").addValueEventListener(new ValueEventListener() {

                    ArrayList<String> finalLst= new ArrayList<String>();

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                       // int count = 0;
                        //StringBuffer sb =new StringBuffer(1000);
                        //ArrayList<String> finalLst= new ArrayList<String>();
                        //HashMap<String, Integer> dataToSend = new  HashMap<String, Integer>();
                        for (DataSnapshot child : dataSnapshot.getChildren())
                        {

                            String s1=child.getKey();
                            //Toast.makeText(A_Division.this,s1, Toast.LENGTH_LONG).show();
                            finalLst.add(s1);



                        }
                        //String natu=String.valueOf(finalLst.size());
                        //Toast.makeText(A_Division.this,natu, Toast.LENGTH_LONG).show();


                        Intent i4 =new Intent(profilePage.this,commonClass.class);
                        i4.putExtra("takeAttendance",finalLst);
                        startActivity(i4);






                    }




                    @Override
                    public void onCancelled(DatabaseError databaseError) {


                    }

                });
                  //  Intent i4 =new Intent(profilePage.this,commonClass.class);
                //i4.putExtra("takeAttendance",finalLst);
                //startActivity(i4);


            }
        });


    }
}
