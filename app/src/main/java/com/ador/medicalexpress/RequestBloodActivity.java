package com.ador.medicalexpress;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.ador.medicalexpress.R.id.add;

public class RequestBloodActivity extends AppCompatActivity {

    EditText ETname,ETbg,ETplace,ETphone,ETdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_blood);

        ETname = (EditText) findViewById(R.id.name);
        ETbg = (EditText) findViewById(R.id.bg);
        ETplace = (EditText) findViewById(R.id.place);
        ETphone = (EditText) findViewById(R.id.phone);
        ETdate = (EditText) findViewById(R.id.date);

    }
}
