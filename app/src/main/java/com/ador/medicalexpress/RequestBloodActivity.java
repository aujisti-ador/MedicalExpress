package com.ador.medicalexpress;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RequestBloodActivity extends AppCompatActivity {

    EditText name,bg,place,phone,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_blood);
        name = (EditText) findViewById(R.id.name);
        bg = (EditText) findViewById(R.id.bg);
        place = (EditText) findViewById(R.id.place);
        phone = (EditText) findViewById(R.id.phone);
        date = (EditText) findViewById(R.id.date);


    }

    public void insert(View view) {
    }

    protected void insertToDatabase(String name, String bg,String place, String phone,String date){

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                return "success";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute(name,bg,place,phone,date);

    }
}
