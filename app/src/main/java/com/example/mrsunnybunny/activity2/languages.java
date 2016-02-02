package com.example.mrsunnybunny.activity2;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class languages extends AppCompatActivity {

    int position;
    int position2;
    int position3;

    String lang1 = "";
    String lang2 = "";
    String lang3 = "";
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
    String elementary = "";
    String highSchool = "";
    String college = "";

    Spinner sp1;
    Spinner sp2;
    Spinner sp3;

    String[] arr = {"English","Tagalog","Nihongo","Bisaya"};
    String[] arr2 = {"English","Tagalog","Nihongo","Bisaya"};
    String[] arr3 = {"English","Tagalog","Nihongo","Bisaya"};

    Button btnBack;
    Button btnNext;

    public Constants constants = new Constants();
    private Intent intent;
    private Intent intention;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //initializeSpinner();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);
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
        sp1 = (Spinner)findViewById(R.id.spinner1);
        sp2 = (Spinner)findViewById(R.id.spinner2);
        sp3 = (Spinner)findViewById(R.id.spinner3);

        btnNext = (Button)findViewById(R.id.next);
        btnBack = (Button)findViewById(R.id.back);

        initializeSpinner();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), Finish.class);
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
        elementary = intention.getStringExtra(constants.elementary);
        highSchool = intention.getStringExtra(constants.highSchool);
        college = intention.getStringExtra(constants.college);

        intent.putExtra(constants.lang1, sp1.getSelectedItem().toString());
        intent.putExtra(constants.lang2, sp2.getSelectedItem().toString());
        intent.putExtra(constants.lang3, sp3.getSelectedItem().toString());
        intent.putExtra(constants.elementary, elementary);
        intent.putExtra(constants.highSchool, highSchool);
        intent.putExtra(constants.college, college);
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
        if(data.hasExtra(constants.lang1))
            lang1 = data.getExtras().getString(constants.lang1);
        if(data.hasExtra(constants.lang2))
            lang2 = data.getExtras().getString(constants.lang2);
        if(data.hasExtra(constants.lang3))
            lang3 = data.getExtras().getString(constants.lang3);

        position = settingPosition(lang1);
        position2 = settingPosition(lang2);
        position3 = settingPosition(lang3);

        sp1.setSelection(position);
        sp2.setSelection(position2);
        sp3.setSelection(position3);
    }

    public void initializeSpinner(){
        ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> ab = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr2);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> ac = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr3);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp1.setAdapter(a);
        sp2.setAdapter(ab);
        sp3.setAdapter(ac);
    }
    public int settingPosition(String lang1){
        int pos = 0;

        switch (lang1){
            case "English": pos = 0;
                            break;
            case "Tagalog": pos = 1;
                            break;
            case "Nihongo": pos = 2;
                            break;
            case "Bisaya":  pos = 3;
                            break;
        }
        return pos;
    }

}
