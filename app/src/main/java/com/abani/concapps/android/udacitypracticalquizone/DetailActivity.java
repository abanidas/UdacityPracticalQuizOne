package com.abani.concapps.android.udacitypracticalquizone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView username, mail, about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        username = (TextView) findViewById(R.id.userName);
        mail = (TextView) findViewById(R.id.email);
        about = (TextView) findViewById(R.id.aboutYou);

       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences sharedPreferences = getSharedPreferences("profilePreference", MODE_PRIVATE);
        if (sharedPreferences != null){
            username.setText(sharedPreferences.getString("username", ""));
            mail.setText(sharedPreferences.getString("mail", ""));
            about.setText(sharedPreferences.getString("about", ""));
        }

        if (savedInstanceState != null){
            username.setText(savedInstanceState.getString("username"));
            mail.setText(savedInstanceState.getString("mail"));
            about.setText(savedInstanceState.getString("about"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("username", String.valueOf(username.getText()));
        outState.putString("mail", String.valueOf(mail.getText()));
        outState.putString("about", String.valueOf(about.getText()));
    }
}
