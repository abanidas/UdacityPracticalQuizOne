package com.abani.concapps.android.udacitypracticalquizone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, mail, about;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.userName);
        mail = (EditText) findViewById(R.id.email);
        about = (EditText) findViewById(R.id.aboutYou);
        nextButton = (Button) findViewById(R.id.button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = String.valueOf(username.getText());
                String email = String.valueOf(mail.getText());
                String bio = String.valueOf(about.getText());

                if (!name.equals("") && !email.equals("") && !bio.equals("")) {
                    SharedPreferences sharedPreferences = getSharedPreferences("profilePreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", name);
                    editor.putString("mail", email);
                    editor.putString("about", bio);
                    editor.apply();

                    username.setText("");
                    mail.setText("");
                    about.setText("");
                    startActivity(new Intent(MainActivity.this, DetailActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, "Please complete details", Toast.LENGTH_SHORT).show();
                }

            };
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_profile){
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
}
