package com.ador.medicalexpress;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by ADOR'S Lappy on 11-May-17.
 */

public class BackgroundTask extends AsyncTask<Void,BloodRequest,Void> {

    Context ctx;
    Activity activity;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<BloodRequest> arrayList = new ArrayList<>();

    public BackgroundTask(Context ctx)
    {
        this.ctx=ctx;
        activity = (Activity)ctx;
    }

    String json_string = "http://192.168.56.1/bloodrequest/dbconnect.php";


    @Override
    protected void onPreExecute() {
        recyclerView = (RecyclerView)activity.findViewById(R.id.recyclarView);
        layoutManager = new LinearLayoutManager(ctx);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecylcarAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(BloodRequest... values) {

        arrayList.add(values[0]);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected Void doInBackground(Void... params) {

        try {
            URL url = new URL(json_string);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line=bufferedReader.readLine())!=null)
            {
                stringBuilder.append(line+"\n");

            }

            /*while ((json_string=bufferedReader.readLine())!=null)
            {
                stringBuilder.append(json_string+"\n");

            }*/

            bufferedReader.close();
            inputStream.close();

            httpURLConnection.disconnect();
            String json_string = stringBuilder.toString().trim();
            Log.d("JSON",json_string);
            JSONObject jsonObject = new JSONObject(json_string);
            JSONArray jsonArray = jsonObject.getJSONArray("server_response");

            int count = 0;
            while (count<jsonArray.length())
            {
                JSONObject JO = jsonArray.getJSONObject(count);
                count++;

                BloodRequest bloodRequest = new BloodRequest(JO.getString("name"),JO.getString("blood_group"),JO.getString("place"),JO.getString("contact"),JO.getString("date"));

                publishProgress(bloodRequest);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
