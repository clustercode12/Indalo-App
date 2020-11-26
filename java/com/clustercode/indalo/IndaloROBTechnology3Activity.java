package com.clustercode.indalo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class IndaloROBTechnology3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_rob_technology_3);

        // Initialize all the Objects and Views
        initialize();
    }

    //Initialize views and objects
    private void initialize() {

        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.title_indalo_rob);
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.prompt_technolgy));
        final TextView txtNext = findViewById(R.id.txtNext);
        txtNext.setText(getText(R.string.action_continue));
        ImageButton btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IndaloROBTechnologyActivity.class);
                startActivity(intent);
                finish();
            }
        });

        final ImageButton btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.include4).setVisibility(View.GONE);
                findViewById(R.id.include5).setVisibility(View.VISIBLE);
                btNext.setVisibility(View.INVISIBLE);
                txtNext.setVisibility(View.INVISIBLE);
            }
        });


    }
}
