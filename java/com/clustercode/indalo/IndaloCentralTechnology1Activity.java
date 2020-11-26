package com.clustercode.indalo;

import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class IndaloCentralTechnology1Activity extends AppCompatActivity {

    private ConstraintLayout cl1, cl2, cl3, cl4;
    private ImageButton bt1, bt2, bt3, bt4;
    private TextView txtNext;

    private int steps = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_central_technology_1);

        // Initialize all the Objects and Views
        initialize();
    }

    public void bt1Clicked(View v) {
        changeView(0);
    }


    public void bt2Clicked(View v) {
        changeView(1);
    }


    public void bt3Clicked(View v) {
        changeView(2);
    }


    public void bt4Clicked(View v) {
        changeView(3);
    }


    //Initialize views and objects
    private void initialize() {

        cl1 = findViewById(R.id.linearLayout);
        cl2 = findViewById(R.id.linearLayout2);
        cl3 = findViewById(R.id.linearLayout3);
        cl4 = findViewById(R.id.linearLayout4);

        cl1.setVisibility(View.INVISIBLE);
        cl2.setVisibility(View.INVISIBLE);
        cl3.setVisibility(View.INVISIBLE);
        cl4.setVisibility(View.INVISIBLE);

        bt1 = findViewById(R.id.imageButton10);
        bt2 = findViewById(R.id.imageButton11);
        bt3 = findViewById(R.id.imageButton12);
        bt4 = findViewById(R.id.imageButton13);

        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.title_indalo_central);
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.prompt_technolgy ));
        txtNext = findViewById(R.id.txtNext);
        txtNext.setText(getText(R.string.action_continue));
        ImageButton btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IndaloCentralTechnologyActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ImageButton btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeView(steps);
            }
        });



    }

    private void changeView (int steps) {
        switch (steps) {
            case 0:
                cl1.setVisibility(View.VISIBLE);
                bt1.setVisibility(View.GONE);

                break;
            case 1:
                cl2.setVisibility(View.VISIBLE);
                bt2.setVisibility(View.GONE);

                break;
            case 2:
                cl3.setVisibility(View.VISIBLE);
                bt3.setVisibility(View.GONE);

                break;
            case 3:
                cl4.setVisibility(View.VISIBLE);
                bt4.setVisibility(View.GONE);

                break;
            case 4:
                Intent intent = new Intent(getApplicationContext(), IndaloCentralTechnology2Activity.class);
                startActivity(intent);
                finish();
                break;
        }

        this.steps++;
    }
}
