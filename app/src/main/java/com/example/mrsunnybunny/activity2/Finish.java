package com.example.mrsunnybunny.activity2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Finish extends AppCompatActivity {

    TextView fname;
    TextView lname;
    TextView gender;
    TextView address;
    TextView sgName;
    TextView sgAddress;
    TextView elem;
    TextView hschool;
    TextView college;
    TextView lang1;
    TextView lang2;
    TextView lang3;

    String name;
    String lastName;
    String gen;
    String add;
    String nameSG;
    String addressSG;
    String ele;
    String highsc;
    String coll;
    String l1;
    String l2;
    String l3;

    public Constants constants = new Constants();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fname = (TextView)findViewById(R.id.finalFname);
        lname = (TextView)findViewById(R.id.finalLname);
        gender = (TextView)findViewById(R.id.finalGender);
        address = (TextView)findViewById(R.id.finalAddress);
        sgName = (TextView)findViewById(R.id.sgName);
        sgAddress = (TextView)findViewById(R.id.sgAddress);
        elem = (TextView)findViewById(R.id.FinalElementary);
        hschool = (TextView)findViewById(R.id.FinalHighSchool);
        college = (TextView)findViewById(R.id.FinalCollege);
        lang1 = (TextView)findViewById(R.id.FinalLanguage1);
        lang2 = (TextView)findViewById(R.id.FinalLanguage2);
        lang3 = (TextView)findViewById(R.id.FinalLanguage3);

        //getting the values from intents
        Intent intent = getIntent();
        name = intent.getStringExtra(constants.fname);
        lastName = intent.getStringExtra(constants.lname);
        gen = intent.getStringExtra(constants.gender);
        add = intent.getStringExtra(constants.address);

        //for the spouse or guardian name
        if(intent.getStringExtra(constants.spouseName) == null){
            nameSG = intent.getStringExtra(constants.guardianName);
        }else{
            nameSG = intent.getStringExtra(constants.spouseName);
        }

        //for the spouse or guardian address
        if(intent.getStringExtra(constants.guardianAddress) == null){
            addressSG = intent.getStringExtra(constants.spouseAddress);
        }else{
            addressSG = intent.getStringExtra(constants.guardianAddress);
        }
        ele = intent.getStringExtra(constants.elementary);
        highsc = intent.getStringExtra(constants.highSchool);
        coll = intent.getStringExtra(constants.college);
        l1 = intent.getStringExtra(constants.lang1);
        l2 = intent.getStringExtra(constants.lang2);
        l3 = intent.getStringExtra(constants.lang3);

        //setting the values for display
        fname.setText(name);
        lname.setText(lastName);
        gender.setText(gen);
        address.setText(add);
        sgName.setText(nameSG);
        sgAddress.setText(addressSG);
        elem.setText(ele);
        hschool.setText(highsc);
        college.setText(coll);
        lang1.setText(l1);
        lang2.setText(l2);
        lang3.setText(l3);
    }
}
