package com.clustercode.indalo;


import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class Indalo3DemostrationDetailsActivity extends AppCompatActivity {

    private int view;
    private TextView txtNext;
    private ConstraintLayout constraintLayout;
    private ImageButton btNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_3_demostration_details);

        //Get int from previous view
        view = getIntent().getIntExtra("view", 1);

        // Initialize all the Objects and Views
        initialize();

        changeView(view);
    }

    //Initialize views and objects
    private void initialize() {
        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.title_indalo_central);
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.title_products));
        txtNext = findViewById(R.id.txtNext);
        txtNext.setText(getText(R.string.action_continue));
        btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view<4) {
                    view++;
                    changeView(view);
                } else {
                    Intent intent = new Intent(getApplicationContext(), Indalo3EconomyActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        ImageButton btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IndaloCentralActivity.class);
                startActivity(intent);
                finish();
            }
        });

        constraintLayout = findViewById(R.id.clBackground);

    }

    private void changeView (int view) {
        switch (view) {
            case 1:

                break;
            case 2:
                constraintLayout.setBackground(getDrawable(R.drawable.background_indalo_3_demostration_details_2));
                break;
            case 3:
                constraintLayout.setBackground(getDrawable(R.drawable.background_indalo_3_demostration_details_3));
                break;
            case 4:
                constraintLayout.setBackground(getDrawable(R.drawable.background_indalo_3_demostration_details_4));
                txtNext.setText(getText(R.string.title_economy));
                break;

        }
    }
}
