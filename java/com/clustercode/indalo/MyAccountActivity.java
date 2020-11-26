package com.clustercode.indalo;

import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;


public class MyAccountActivity extends AppCompatActivity {

    private String name, lastName, phone, email, office, team, number;
    private TextInputEditText tietName, tietLastName, tietPhone, tietEmail, tietNumber;
    private Spinner spOffice, spTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        // Initialize all the Objects and Views
        initialize();

    }

    //Initialize views and objects
    private void initialize() {
        ImageButton btToolbarBottomLeft = findViewById(R.id.btBack);
        btToolbarBottomLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        ImageButton btToolbarBottomRight = findViewById(R.id.btNext);
        btToolbarBottomRight.setVisibility(View.INVISIBLE);

        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.title_my_account);
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setVisibility(View.INVISIBLE);
        TextView txtNext = findViewById(R.id.txtNext);
        txtNext.setVisibility(View.INVISIBLE);

        tietName = findViewById(R.id.tietName);
        tietLastName = findViewById(R.id.tietLastName);
        tietPhone = findViewById(R.id.tietPhone);
        tietEmail = findViewById(R.id.tietEmail);
        tietNumber = findViewById(R.id.tietNumber);

        spOffice = findViewById(R.id.spOffice);
        spTeam = findViewById(R.id.spTeam);
    }
}
