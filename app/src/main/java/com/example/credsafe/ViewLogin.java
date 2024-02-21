package com.example.credsafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ViewLogin extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText siteNameEdt, usernameEdt, passwordEdt;
    private Button addLoginBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_login);

        // initializing all our variables.
        siteNameEdt = findViewById(R.id.idEdtSiteName);
        usernameEdt = findViewById(R.id.idEdtUsername);
        passwordEdt = findViewById(R.id.idEdtPassword);
        addLoginBtn = findViewById(R.id.idBtnAddLogin);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(ViewLogin.this);

        addLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // below line is to get data from all edit text fields.
                String siteName = siteNameEdt.getText().toString();
                String username = usernameEdt.getText().toString();
                String password = passwordEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (siteName.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(ViewLogin.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // login to sqlite data and pass all our values to it.
                dbHandler.addNewLogin(siteName, username, password );

                // after adding the data we are displaying a toast message.
                Toast.makeText(ViewLogin.this, "Login has been added.", Toast.LENGTH_SHORT).show();
                siteNameEdt.setText("");
                usernameEdt.setText("");
                passwordEdt.setText("");
                // opening a new activity via a intent.
                Intent i = new Intent(ViewLogin.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
