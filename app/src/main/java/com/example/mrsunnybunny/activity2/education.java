package com.example.mrsunnybunny.activity2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class education extends AppCompatActivity {

    String dataElementary = "";
    String dataHighSchool = "";
    String dataCollege = "";
    String fname = "";
    String lname = "";
    String firstAddress = "";
    String gender = "";
    String spouseName = "";
    String spouseAddress = "";
    String relation = "";
    String guardianName = "";
    String guardianAddress = "";

    Button btnNext;
    Button btnBack;

    EditText elementary;
    EditText highSchool;
    EditText college;

    public Constants constants = new Constants();
    private Intent intent;
    private Intent intention;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
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
        btnBack = (Button)findViewById(R.id.back);
        btnNext = (Button)findViewById(R.id.next);

        elementary = (EditText)findViewById(R.id.elementary);
        highSchool = (EditText)findViewById(R.id.highSchool);
        college = (EditText)findViewById(R.id.college);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), languages.class);
                addData();
                startActivity(intent);
            }
        });
    }

    public void addData(){
        intention = getIntent();

        fname = intention.getStringExtra(constants.fname);
        lname = intention.getStringExtra(constants.lname);
        firstAddress = intention.getStringExtra(constants.address);
        gender = intention.getStringExtra(constants.gender);
        spouseName = intention.getStringExtra(constants.spouseName);
        spouseAddress = intention.getStringExtra(constants.spouseAddress);
        relation = intention.getStringExtra(constants.relation);
        guardianName = intention.getStringExtra(constants.guardianName);
        guardianAddress = intention.getStringExtra(constants.guardianAddress);

        intent.putExtra(constants.elementary, elementary.getText().toString());
        intent.putExtra(constants.highSchool, highSchool.getText().toString());
        intent.putExtra(constants.college, college.getText().toString());
        intent.putExtra(constants.spouseName, spouseName);
        intent.putExtra(constants.spouseAddress, spouseAddress);
        intent.putExtra(constants.fname, fname);
        intent.putExtra(constants.lname, lname);
        intent.putExtra(constants.address, firstAddress);
        intent.putExtra(constants.gender, gender);
        intent.putExtra(constants.relation, relation);
        intent.putExtra(constants.guardianName, guardianName);
        intent.putExtra(constants.guardianAddress, guardianAddress);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data.hasExtra(constants.elementary))
            dataElementary = data.getExtras().getString(constants.elementary);
        if(data.hasExtra(constants.highSchool))
            dataHighSchool = data.getExtras().getString(constants.highSchool);
        if(data.hasExtra(constants.college))
            dataCollege = data.getExtras().getString(constants.college);

        elementary.setText(dataElementary);
        highSchool.setText(dataHighSchool);
        college.setText(dataCollege);
    }
}
