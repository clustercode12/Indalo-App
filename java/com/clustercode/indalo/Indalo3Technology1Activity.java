package com.clustercode.indalo;


import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class Indalo3Technology1Activity extends AppCompatActivity {

    private int view = 0;
    private TextView txtNext, txt1, txt2;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_3_technology_1);

        // Initialize all the Objects and Views
        initialize();
    }

    //Initialize views and objects
    private void initialize() {

        constraintLayout = findViewById(R.id.constraintLayout2);
        constraintLayout.setVisibility(View.GONE);
        txt1 = findViewById(R.id.textView67);
        txt1.setVisibility(View.GONE);
        txt2 = findViewById(R.id.textView13);
        txt2.setText(getText(R.string.body_indalo_3_technology_1));

        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.title_indalo_3);
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.prompt_technolgy ));
        txtNext = findViewById(R.id.txtNext);
        txtNext.setText(getText(R.string.action_continue));
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
                view++;
                changeView();

            }
        });
    }

    private void initialize2() {
        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.title_indalo_3);
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.prompt_technolgy ));
        txtNext = findViewById(R.id.txtNext);
        txtNext.setText(getText(R.string.action_continue));
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
                view++;
                changeView();

            }
        });
    }

    private void changeView() {
        switch (view) {
            case 1:
                constraintLayout.setVisibility(View.VISIBLE);
                break;
            case 2:
                txt1.setVisibility(View.VISIBLE);
                txt2.setText(getText(R.string.body_indalo_3_technology_1_2));
                break;
            case 3:
                setContentView(R.layout.activity_indalo_3_technology_1_2);
                initialize2();
                break;
            case 4:
                setContentView(R.layout.activity_indalo_3_technology_1_3);
                initialize2();
                break;
            case 5:
                Intent intent = new Intent(getApplicationContext(), Indalo3Technology2Activity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
