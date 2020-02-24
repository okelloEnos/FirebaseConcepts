package com.okellosoftwarez.firebaseauth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class  MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private static FirebaseAuth mAuth;
//    private FirebaseAuth mAuth;
    EditText etEmail, etPassword;
    Button signIn, signUp;
    TextView welcomeTxt;

    public static void signOut() {
        mAuth.signOut();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        welcomeTxt = findViewById(R.id.tvWel);
        signIn = findViewById(R.id.signInBtn);
        signUp = findViewById(R.id.signUpBtn);

        signIn.setOnClickListener(this);
        signUp.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null){
            updateUI(currentUser, "autoMail");
        }

    }

    private void updateUI(FirebaseUser currentUser, String message) {
        Intent autoIntent = new Intent(this, Base.class);
        autoIntent.putExtra(message, currentUser.getEmail());
        startActivity(autoIntent);
    }

    @Override
    public void onClick(View v) {

        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if(email.isEmpty() && password.isEmpty()){
            etEmail.setError("Missing Mail");
            etPassword.setError("Missing PassWord");
        }
        else if (email.isEmpty()){
            etEmail.setError("Missing Mail");
        }
        else if (password.isEmpty()){
            etPassword.setError("Missing PassWord");
        }
        else {
            switch (v.getId()) {
                case R.id.signInBtn:
                    logInUser(email, password);

                case R.id.signUpBtn:
                    registerUser(email, password);


            }
        }
    }

    private void registerUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null){
                                updateUI(user, "newMail");
                            }

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed. Check Your Details",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    private void logInUser(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null){
                                updateUI(user, "logMail");
                            }

                        }
                        else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed. Wrong Credentials Combination",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}
