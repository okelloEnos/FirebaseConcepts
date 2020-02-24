package com.okellosoftwarez.firebaseauth;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Base extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        TextView note = findViewById(R.id.textNote);

        String backMessage = getIntent().getStringExtra("autoMail");
        String logInMessage = getIntent().getStringExtra("logMail");
        String newMessage = getIntent().getStringExtra("newMail");

            if (getIntent().hasExtra("autoMail") && !backMessage.isEmpty()) {
                note.setText("Automatically : Welcome Back : " + backMessage);
            }
            if (getIntent().hasExtra("logMail") && !logInMessage.isEmpty()) {
                note.setText("Successful Log In : " + logInMessage);
            }
            if (getIntent().hasExtra("newMail") && !newMessage.isEmpty()) {
                note.setText("Account creation Completed :" + newMessage);
            }
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        MainActivity.signOut();
        builder.setMessage("Do you want to leave? ");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(Base.this, MainActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.show();
    }
    }
