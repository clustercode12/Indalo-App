package com.clustercode.indalo;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class LoginActivity extends AppCompatActivity {

    private FirebaseDatabase database;

    private TextInputEditText tietUser, tietPassword;
    private Button btSignIn;

    private static String password;
    private static final String USER = "user";
    private static final String ADMIN = "admin", ADMIN_PASSWORD = "76639254b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize all the Objects and Views
        initialize();

        getPassword();

        // Get and make password from Firebase Database
    }

    //Get the key from Firebase Database and make password
    private void getPassword() {
        DatabaseReference myRef = database.getReference("password");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                password = makePassword(dataSnapshot.getValue(Long.class));

                //Only for testing
                tietUser.setText("user");
                tietPassword.setText(password);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(LoginActivity.this, error + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Make the password
    private String makePassword (long key) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);

        return ((int) ((key * month) / Math.sqrt(year)) + year) + "";
    }

    //Attempt to sign in into the app
    public void signIn(View v) {
        //Check if the EditTexts are empty
//        if (!tietUser.getText().toString().isEmpty() && !tietUser.getText().toString().isEmpty()) {
//            if (tietUser.getText().toString().equals(USER) && tietPassword.getText().toString().equals(password)) {
                Intent intent = new Intent(this, ClientDetailsActivity.class);
                startActivity(intent);
//                return;
//            } else if (tietUser.getText().toString().equals(ADMIN) && tietPassword.getText().toString().equals(ADMIN_PASSWORD)) {
//                Toast.makeText(this, "admin", Toast.LENGTH_SHORT).show();
//                return;
//            }
//        }

//        Toast.makeText(this, getString(R.string.prompt_sign_in_error), Toast.LENGTH_SHORT).show();
    }

    //Initialize views and objects
    private void initialize() {
        //Firebase Database
        FirebaseApp.initializeApp(getApplicationContext());
        database = FirebaseDatabase.getInstance();

        //Views
        tietUser = findViewById(R.id.tietUser);
        tietPassword = findViewById(R.id.tietPassword);
        btSignIn = findViewById(R.id.btSignIn);
    }

    @Override
    public void onBackPressed() {

    }
}
