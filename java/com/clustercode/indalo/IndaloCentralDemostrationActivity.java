package com.clustercode.indalo;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class IndaloCentralDemostrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_central_demostration);

        // Initialize all the Objects and Views
        initialize();
    }

    //Initialize views and objects
    private void initialize() {

        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.title_indalo_central);
        ImageButton btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IndaloCentralActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ImageButton btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IndaloCentralEconomy1Activity.class);
                startActivity(intent);
                finish();
            }
        });
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.title_indalo_central));
        TextView txtNext = findViewById(R.id.txtNext);
        txtNext.setText(getText(R.string.title_economy));
    }

    public void btMiniUnidadClicked (View v) {
        Intent intent = new Intent(this, IndaloCentralDemostrationDetailsActivity.class);
        intent.putExtra("view", IndaloCentralDemostrationDetailsActivity.MINIUNIDAD);
        startActivity(intent);
    }

    public void btJabonClicked (View v) {
        Intent intent = new Intent(this, IndaloCentralDemostrationDetailsActivity.class);
        intent.putExtra("view", IndaloCentralDemostrationDetailsActivity.JABON);
        startActivity(intent);
    }

    public void btLavadoManosClicked (View v) {
        Intent intent = new Intent(this, IndaloCentralDemostrationDetailsActivity.class);
        intent.putExtra("view", IndaloCentralDemostrationDetailsActivity.LAVADOMANOS);
        startActivity(intent);
    }

    public void btTdsClicked (View v) {
        Intent intent = new Intent(this, IndaloCentralDemostrationDetailsActivity.class);
        intent.putExtra("view", IndaloCentralDemostrationDetailsActivity.TDS);
        startActivity(intent);
    }

    public void btRopaBebeClicked (View v) {
        Intent intent = new Intent(this, IndaloCentralDemostrationDetailsActivity.class);
        intent.putExtra("view", IndaloCentralDemostrationDetailsActivity.ROPABEBE);
        startActivity(intent);
    }
}
