package com.example.mrsunnybunny.activity2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    String dataGender="";
    String dataFname="";
    String dataLname="";
    String dataAddress="";

    Button btnSingle;
    Button btnMarried;

    EditText fname;
    EditText lname;
    EditText address;

    RadioButton male;
    RadioButton female;

    public Constants constants = new Constants();
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        btnSingle = (Button)findViewById(R.id.single);
        btnMarried = (Button)findViewById(R.id.married);

        fname = (EditText)findViewById(R.id.fname);
        lname = (EditText)findViewById(R.id.lname);
        address = (EditText)findViewById(R.id.address);

        male = (RadioButton)findViewById(R.id.male);
        female = (RadioButton)findViewById(R.id.female);

        if(male.isChecked())
            dataGender = male.getText().toString();
        else
            dataGender = female.getText().toString();

        btnSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), single.class);
                addData();
                startActivity(intent);
            }
        });
        btnMarried.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), married.class);
                addData();
                startActivity(intent);
            }
        });
    }

    public void addData(){
        intent.putExtra(constants.fname, fname.getText().toString());
        intent.putExtra(constants.lname, lname.getText().toString());
        intent.putExtra(constants.address, address.getText().toString());
        intent.putExtra(constants.gender, dataGender);
        Log.e("gender", dataGender);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data.hasExtra(constants.fname))
            dataFname = data.getExtras().getString(constants.fname);
        if(data.hasExtra(constants.lname))
            dataLname = data.getExtras().getString(constants.lname);
        if(data.hasExtra(constants.address))
            dataAddress = data.getExtras().getString(constants.address);
        if(data.hasExtra(constants.gender))
            dataGender = data.getExtras().getString(constants.gender);

        fname.setText(dataFname);
        lname.setText(dataLname);
        address.setText(dataAddress);
        if(dataGender.equals(constants.gMale)) {
            male.setChecked(true);
            female.setChecked(false);
        }
        else {
            male.setChecked(false);
            female.setChecked(true);
        }
    }
}
