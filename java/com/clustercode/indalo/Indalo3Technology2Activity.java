package com.clustercode.indalo;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class Indalo3Technology2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_3_technology_2);

        // Initialize all the Objects and Views
        initialize();
    }

    //Initialize views and objects
    private void initialize() {


        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.title_indalo_3);
        ImageButton btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Indalo3TechnologyActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ImageButton btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.prompt_technolgy));
        TextView txtNext = findViewById(R.id.txtNext);
        txtNext.setText(getText(R.string.action_continue));
    }

}
