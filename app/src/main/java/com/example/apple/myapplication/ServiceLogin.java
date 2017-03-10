package com.example.apple.myapplication;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by apple on 3/3/17.
 */

public class ServiceLogin extends AsyncTask<String, Void, String> {

    ProgressDialog mProgressDialog;
    private String res;

    /*@Override
    protected void onPreExecute() {
        mProgressDialog = ProgressDialog.show(LoginActivity.this,
                "", "Please wait...");
    }*/

    @Override
    protected String doInBackground(String... params) {
        res = null;
        PutUtility put = new PutUtility();

        put.setParam("UserId", params[0].toString());
        put.setParam("Latitude", params[1].toString());
        put.setParam("Longitude", params[2].toString());
        put.setParam("DateTime", params[3].toString());

        try {
            res = put.postData("INSERT URL of API HERE");
            Log.v("res", res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;

    }

    protected void onPostExecute(String res) {
        //"Here you get response from server in res"

    }
}
