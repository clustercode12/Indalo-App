package com.clustercode.indalo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class IndaloROBDemostrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_rob_demostration);

        // Initialize all the Objects and Views
        initialize();
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
                Intent intent = new Intent(getApplicationContext(), IndaloROBEconomyActivity.class);
                startActivity(intent);
                finish();
            }
        });
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.title_indalo_rob));
        TextView txtNext = findViewById(R.id.txtNext);
        txtNext.setText(getText(R.string.title_economy));
    }

    public void btTdsClicked (View v) {
        Intent intent = new Intent(this, IndaloROBDemostrationDetailsActivity.class);
        intent.putExtra("view", IndaloROBDemostrationDetailsActivity.TDS);
        startActivity(intent);
    }

    public void btCloroClicked (View v) {
        Intent intent = new Intent(this, IndaloROBDemostrationDetailsActivity.class);
        intent.putExtra("view", IndaloROBDemostrationDetailsActivity.CLORO);
        startActivity(intent);
    }

    public void btElectroprecipitationClicked (View v) {
        Intent intent = new Intent(this, IndaloROBDemostrationDetailsActivity.class);
        intent.putExtra("view", IndaloROBDemostrationDetailsActivity.ELECTROPRECIPITATION);
        startActivity(intent);
    }

    public void btAbsorptionClicked (View v) {
        Intent intent = new Intent(this, IndaloROBDemostrationDetailsActivity.class);
        intent.putExtra("view", IndaloROBDemostrationDetailsActivity.ABSORPTION);
        startActivity(intent);
    }
}
