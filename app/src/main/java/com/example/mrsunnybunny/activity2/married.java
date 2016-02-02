package com.example.mrsunnybunny.activity2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class married extends AppCompatActivity {
    String dataSpouseName = "";
    String dataAddress = "";
    String fname = "";
    String lname = "";
    String firstAddress = "";
    String gender = "";

    Button btnBack;
    Button btnNext;

    EditText spouseName;
    EditText address;

    public Constants constants = new Constants();

    private Intent intent;
    private Intent intention;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_married);
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

        spouseName = (EditText)findViewById(R.id.spouseName);
        address = (EditText)findViewById(R.id.spouseAddress);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), education.class);
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

        intent.putExtra(constants.spouseName, spouseName.getText().toString());
        intent.putExtra(constants.spouseAddress, address.getText().toString());
        intent.putExtra(constants.fname, fname);
        intent.putExtra(constants.lname, lname);
        intent.putExtra(constants.address, firstAddress);
        intent.putExtra(constants.gender, gender);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data.hasExtra(constants.spouseName))
            dataSpouseName = data.getExtras().getString(constants.spouseName);
        if(data.hasExtra(constants.spouseAddress))
            dataAddress = data.getExtras().getString(constants.spouseAddress);

        spouseName.setText(dataSpouseName);
        address.setText(dataAddress);
    }
}
