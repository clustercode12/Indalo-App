package com.clustercode.indalo;


import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class IndaloCentralDemostrationDetailsActivity extends AppCompatActivity {

    private int view;
    private ImageView ivBig;
    private TextView txtSubtitle, txtBody, txtNext;
    private ConstraintLayout clTable;
    private ImageButton btNext;

    public static final int MINIUNIDAD = 1, JABON = 2, LAVADOMANOS = 3, TDS = 4, ROPABEBE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_central_demostration_details);

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
        btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view<5) {
                    view++;
                    changeView(view);
                } else {
                    Intent intent = new Intent(getApplicationContext(), IndaloCentralEconomy1Activity.class);
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

        ivBig = findViewById(R.id.ivBig);
        txtSubtitle = findViewById(R.id.txtSubtitle);
        txtBody = findViewById(R.id.txtBody);
        clTable = findViewById(R.id.clTable);
    }

    private void changeView (int view) {
        switch (view) {
            case MINIUNIDAD:
                ivBig.setImageDrawable(getDrawable(R.drawable.product_indalo_central_miniunidad));
                txtSubtitle.setText(getString(R.string.title_health_mini_unidad));
                txtBody.setText(getString(R.string.body_health_mini_unidad));
                clTable.setVisibility(View.GONE);
                txtNext.setVisibility(View.VISIBLE);
                btNext.setVisibility(View.VISIBLE);
                txtNext.setText(getString(R.string.title_health_prueba_jabon));
                break;
            case JABON:
                ivBig.setImageDrawable(getDrawable(R.drawable.product_indalo_central_jabon));
                txtSubtitle.setText(getString(R.string.title_health_prueba_jabon));
                txtBody.setText(getString(R.string.body_health_prueba_jabon));
                clTable.setVisibility(View.GONE);
                txtNext.setVisibility(View.VISIBLE);
                btNext.setVisibility(View.VISIBLE);
                txtNext.setText(getString(R.string.title_health_lavado_manos));
                break;
            case LAVADOMANOS:
                ivBig.setImageDrawable(getDrawable(R.drawable.product_indalo_central_lavado_manos));
                txtSubtitle.setText(getString(R.string.title_health_lavado_manos));
                txtBody.setText(getString(R.string.body_health_lavado_manos));
                clTable.setVisibility(View.GONE);
                txtNext.setVisibility(View.VISIBLE);
                btNext.setVisibility(View.VISIBLE);
                txtNext.setText(getString(R.string.title_tds));
                break;
            case TDS:
                ivBig.setImageDrawable(getDrawable(R.drawable.product_indalo_central_tds_1));
                txtSubtitle.setText(getString(R.string.title_tds));
                txtBody.setText(getString(R.string.body_tds));
                clTable.setVisibility(View.VISIBLE);
                txtNext.setVisibility(View.VISIBLE);
                btNext.setVisibility(View.VISIBLE);
                txtNext.setText(getString(R.string.title_health_ropa_bebe));
                break;
            case ROPABEBE:
                ivBig.setImageDrawable(getDrawable(R.drawable.product_indalo_central_tds_2));
                txtSubtitle.setText(getString(R.string.title_health_ropa_bebe));
                txtBody.setText(getString(R.string.body_health_ropa_bebe));
                clTable.setVisibility(View.GONE);
                txtNext.setVisibility(View.VISIBLE);
                btNext.setVisibility(View.VISIBLE);
                txtNext.setText(getString(R.string.title_economy));
                break;
        }
    }
}
