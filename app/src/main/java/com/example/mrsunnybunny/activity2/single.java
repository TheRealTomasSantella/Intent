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

public class single extends AppCompatActivity {

    String dataRelation = "";
    String dataGuardianName = "";
    String dataAddress = "";
    String lname = "";
    String fname = "";
    String firstAddress = "";
    String gender = "";

    Button btnNext;
    Button btnBack;

    EditText relation;
    EditText guardianName;
    EditText address;

    public Constants constants = new Constants();
    private Intent intent;
    private Intent intention;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
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

        btnNext = (Button)findViewById(R.id.next);
        btnBack = (Button)findViewById(R.id.back);

        relation = (EditText)findViewById(R.id.relation);
        guardianName = (EditText)findViewById(R.id.guardianName);
        address = (EditText)findViewById(R.id.guardianAddress);

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

        intent.putExtra(constants.guardianName, guardianName.getText().toString());
        intent.putExtra(constants.relation, relation.getText().toString());
        intent.putExtra(constants.guardianAddress, address.getText().toString());
        intent.putExtra(constants.fname, fname);
        intent.putExtra(constants.lname, lname);
        intent.putExtra(constants.address, firstAddress);
        intent.putExtra(constants.gender, gender);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data.hasExtra(constants.guardianName))
            dataGuardianName = data.getExtras().getString(constants.guardianName);
        if(data.hasExtra(constants.relation))
            dataRelation = data.getExtras().getString(constants.relation);
        if(data.hasExtra(constants.guardianAddress))
            dataAddress = data.getExtras().getString(constants.guardianAddress);

        guardianName.setText(dataGuardianName);
        relation.setText(dataRelation);
        address.setText(dataAddress);
    }
}
