package com.clustercode.indalo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all the Objects and Views
        initialize();
    }

    //Initialize views and objects
    private void initialize() {

        //Initialize other Activities
        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.title_welcome);
        ImageButton btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ImageButton btNext = findViewById(R.id.btNext);
        btNext.setVisibility(View.INVISIBLE);
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setVisibility(View.INVISIBLE);
        TextView txtNext = findViewById(R.id.txtNext);
        txtNext.setVisibility(View.INVISIBLE);
    }

    public void cvWhoAreWeClicked(View v) {
        Intent intent = new Intent(this, WhoAreWeActivity.class);
        startActivity(intent);
    }

    public void cvWhereAreWeClicked(View v) {
        Intent intent = new Intent(this, WhereAreWeActivity.class);
        startActivity(intent);
    }

    public void cvSocialResponsabilityClicked(View v) {

    }

    public void cvProductsClicked(View v) {
        Intent intent = new Intent(this, ProductsActivity.class);
        startActivity(intent);
    }
}
