package com.clustercode.indalo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class IndaloROBHealthActivity extends AppCompatActivity {

    private ImageButton btForward;
    private TextView txtHeader, txtBody;

    private int slide = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_rob_health);

        // Initialize all the Objects and Views
        initialize();
    }

    public void btForwardClicked(View v) {
        switch (slide) {
            case 0:
                txtHeader.setText(R.string.title_indalo_rob_health_2);
                txtBody.setText(R.string.list_indalo_rob_health_1);
                break;
            case 1:
                txtBody.setText(R.string.list_indalo_rob_health_2);
                btForward.setVisibility(View.INVISIBLE);
                break;
        }
        slide++;
    }

    //Initialize views and objects
    private void initialize() {

        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.title_indalo_rob);
        ImageButton btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IndaloROBActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ImageButton btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IndaloROBDemostrationActivity.class);
                startActivity(intent);
                finish();
            }
        });
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.title_indalo_rob));
        TextView txtNext = findViewById(R.id.txtNext);
        txtNext.setText(getText(R.string.title_demostration));

        btForward = findViewById(R.id.btForward);
        txtHeader = findViewById(R.id.txtHeader);
        txtBody = findViewById(R.id.txtBody);
    }
}
