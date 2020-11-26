package com.clustercode.indalo;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class IndaloCentralActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_central);

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
                Intent intent = new Intent(getApplicationContext(), ProductsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.title_products));
    }

    public void ibHealthClicked (View v) {
        Intent intent = new Intent(this, IndaloCentralHealth1Activity.class);
        startActivity(intent);
    }

    public void ibDemostrationClicked (View v) {
        Intent intent = new Intent(this, IndaloCentralDemostrationActivity.class);
        startActivity(intent);
    }

    public void ibEconomyClicked (View v) {
        Intent intent = new Intent(this, IndaloCentralEconomy1Activity.class);
        startActivity(intent);
    }

    public void ibTechnologyClicked (View v) {
        Intent intent = new Intent(this, IndaloCentralTechnologyActivity.class);
        startActivity(intent);
    }

    public void ibVideoClicked (View v) {
        Intent intent = new Intent(this, Indalo3YoutubeActivity.class);
        intent.putExtra("url", "Gl_wXB95jAk");
        intent.putExtra("title", getString(R.string.title_indalo_central));
        intent.putExtra("textBack", getString(R.string.title_indalo_central));
        intent.putExtra("textNext", "");
        intent.putExtra("classBack", IndaloCentralActivity.class);
        intent.putExtra("classNext", IndaloCentralActivity.class);
        startActivity(intent);
    }
}
