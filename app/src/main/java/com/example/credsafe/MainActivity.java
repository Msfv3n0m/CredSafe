package com.example.credsafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<LoginModal> loginModalArrayList;
    private DBHandler dbHandler;
    private LoginRVAdapter loginRVAdapter;
    private RecyclerView loginsRV;
    private FloatingActionButton addLoginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing our all variables.
        loginModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(MainActivity.this);

        // getting our login array
        // list from db handler class.
        loginModalArrayList = dbHandler.readLogins();

        // on below line passing our array list to our adapter class.
        loginRVAdapter = new LoginRVAdapter(loginModalArrayList, MainActivity.this);
        loginsRV = findViewById(R.id.idRVLogins);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        loginsRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        loginsRV.setAdapter(loginRVAdapter);
        FloatingActionButton addLoginBtn = findViewById(R.id.floatingActionButton);
        addLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ViewLogin.class);
                startActivity(i);
                // below line is to get data from all edit text fields.

            }
        });
    }

}
