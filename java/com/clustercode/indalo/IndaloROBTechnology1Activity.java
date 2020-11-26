package com.clustercode.indalo;

import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class IndaloROBTechnology1Activity extends AppCompatActivity {

    private ConstraintLayout cl1, cl2, cl3;
    private ImageButton btRight, btLeft;
    private TextView txtOptimization, txtNext;

    private int steps = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_rob_technology_1);

        // Initialize all the Objects and Views
        initialize();
    }

    //Initialize views and objects
    private void initialize() {

        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.title_indalo_rob);
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.prompt_technolgy ));
        txtNext = findViewById(R.id.txtNext);
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
        ImageButton btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (steps) {
                    case 0:
                        cl1.setVisibility(View.VISIBLE);
                        btRight.setVisibility(View.VISIBLE);
                        steps++;
                        break;
                    case 1:
                        cl2.setVisibility(View.VISIBLE);
                        btLeft.setVisibility(View.VISIBLE);
                        txtOptimization.setVisibility(View.VISIBLE);
                        steps++;
                        break;
                    case 2:
                        cl3.setVisibility(View.VISIBLE);
                        txtNext.setText(getString(R.string.title_microprocessor));
                        steps++;
                        break;
                    case 3:
                        Intent intent = new Intent(getApplicationContext(), IndaloROBTechnology2Activity.class);
                        startActivity(intent);
                        finish();
                        break;
                }
            }
        });


        txtOptimization = findViewById(R.id.txtOptimization);
        btRight = findViewById(R.id.btRight);
        btLeft = findViewById(R.id.btLeft);
        cl1 = findViewById(R.id.cl1);
        cl2 = findViewById(R.id.cl2);
        cl3 = findViewById(R.id.cl3);
    }

    public void txtPurificationClicked(View v) {
        if (steps == 0) {
            cl1.setVisibility(View.VISIBLE);
            btRight.setVisibility(View.VISIBLE);
            steps++;
        }
    }

    public void btRightClicked(View v) {
        if (steps == 1) {
            cl2.setVisibility(View.VISIBLE);
            btLeft.setVisibility(View.VISIBLE);
            txtOptimization.setVisibility(View.VISIBLE);
            steps++;
        }
    }

    public void btLeftClicked(View v) {
        if (steps == 2) {
            cl3.setVisibility(View.VISIBLE);
            txtNext.setText(getString(R.string.title_microprocessor));
            steps++;
        }
    }
}
