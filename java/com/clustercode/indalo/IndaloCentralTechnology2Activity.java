package com.clustercode.indalo;

import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class IndaloCentralTechnology2Activity extends AppCompatActivity {

    private ImageButton button;
    private ImageView image;
    private TextView txt, txtSubtitle;

    private ConstraintLayout constraintLayout, clTxt;

    private int step = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_central_technology_2);

        // Initialize all the Objects and Views
        initialize();
    }

    //Initialize views and objects
    private void initialize() {

        image = findViewById(R.id.imageView41);
        button = findViewById(R.id.imageButton14);
        txt = findViewById(R.id.textView13);
        txtSubtitle = findViewById(R.id.txtInstalation);
        constraintLayout = findViewById(R.id.clTechnology2);
        clTxt = findViewById(R.id.constraintLayout2);

        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.title_indalo_central);
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
                changeView(null);
            }
        });
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.prompt_technolgy));
        TextView txtNext = findViewById(R.id.txtNext);
        txtNext.setText(getText(R.string.action_continue));
    }

    void changeView(View v) {
        switch (step) {
            case 0:
                image.setVisibility(View.GONE);
                txt.setText(getText(R.string.body_indalo_central_technology_2_2));
                break;
            case 1:
                clTxt.setVisibility(View.GONE);
                txtSubtitle.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
                constraintLayout.setBackground(getDrawable(R.drawable.background_indalo_central_instalation));
                break;
            case 2:
                Intent intent = new Intent(getApplicationContext(), IndaloCentralTechnology3Activity.class);
                startActivity(intent);
                finish();
                break;
        }
        step++;
    }
}
