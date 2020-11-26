package com.clustercode.indalo;

import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class IndaloROBDemostrationDetailsActivity extends AppCompatActivity {

    private int view;
    private ImageView ivBig;
    private TextView txtSubtitle, txtBody, txtNext;
    private ConstraintLayout clTable;
    private ImageButton btNext;

    public static final int TDS = 1, CLORO = 2, ELECTROPRECIPITATION = 3, ABSORPTION = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_rob_demostration_details);

        //Get int from previous view
        view = getIntent().getIntExtra("view", 1);

        // Initialize all the Objects and Views
        initialize();

        changeView(view);
    }

    //Initialize views and objects
    private void initialize() {
        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.title_indalo_rob);
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.title_products));
        txtNext = findViewById(R.id.txtNext);
        btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view<4) {
                    view++;
                    changeView(view);
                } else {
                    Intent intent = new Intent(getApplicationContext(), IndaloROBEconomyActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        ImageButton btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IndaloROBActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ivBig = findViewById(R.id.ivBig);
        txtSubtitle = findViewById(R.id.txtSubtitle);
        txtBody = findViewById(R.id.txtBody);
        clTable = findViewById(R.id.clTable);
    }

    private void changeView (int view) {
        switch (view) {
            case TDS:
                ivBig.setImageDrawable(getDrawable(R.drawable.product_indalo_rob_tds));
                txtSubtitle.setText(getString(R.string.title_tds));
                txtBody.setText(getString(R.string.body_tds));
                clTable.setVisibility(View.VISIBLE);
                txtNext.setVisibility(View.VISIBLE);
                btNext.setVisibility(View.VISIBLE);
                txtNext.setText(getString(R.string.title_cloro));
                break;
            case CLORO:
                ivBig.setImageDrawable(getDrawable(R.drawable.product_indalo_rob_cloro));
                txtSubtitle.setText(getString(R.string.title_tds_2));
                txtBody.setText(getString(R.string.list_tds));
                clTable.setVisibility(View.GONE);
                txtNext.setVisibility(View.VISIBLE);
                btNext.setVisibility(View.VISIBLE);
                txtNext.setText(getString(R.string.title_electroprecipitation));
                break;
            case ELECTROPRECIPITATION:
                ivBig.setImageDrawable(getDrawable(R.drawable.product_indalo_rob_electroprecipitation));
                txtSubtitle.setText(getString(R.string.title_tds_3));
                txtBody.setText(getString(R.string.body_tds_2));
                clTable.setVisibility(View.GONE);
                txtNext.setVisibility(View.VISIBLE);
                btNext.setVisibility(View.VISIBLE);
                txtNext.setText(getString(R.string.title_absorption));
                break;
            case ABSORPTION:
                ivBig.setImageDrawable(getDrawable(R.drawable.product_indalo_rob_absorption));
                txtSubtitle.setText(getString(R.string.title_tds_4));
                txtBody.setText(getString(R.string.list_tds_2));
                clTable.setVisibility(View.GONE);
                txtNext.setVisibility(View.VISIBLE);
                btNext.setVisibility(View.VISIBLE);
                txtNext.setText(getString(R.string.title_economy));
                break;
        }
    }
}
