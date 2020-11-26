package com.clustercode.indalo;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class Indalo3DemostrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_3_demostration);

        // Initialize all the Objects and Views
        initialize();
    }

    //Initialize views and objects
    private void initialize() {

        //TextViews
        TextView txtSubtitle = findViewById(R.id.txtTitleScreen);
        txtSubtitle.setText(getNameAndName2());

        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.title_indalo_3);
        ImageButton btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Indalo3Activity.class);
                startActivity(intent);
                finish();
            }
        });
        ImageButton btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Indalo3EconomyActivity.class);
                startActivity(intent);
                finish();
            }
        });
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.title_indalo_3));
        TextView txtNext = findViewById(R.id.txtNext);
        txtNext.setText(getText(R.string.title_economy));
    }

    public void bt1 (View v) {
        Intent intent = new Intent(this, Indalo3DemostrationDetailsActivity.class);
        intent.putExtra("view", 1);
        startActivity(intent);
    }

    public void bt2 (View v) {
        Intent intent = new Intent(this, Indalo3DemostrationDetailsActivity.class);
        intent.putExtra("view", 2);
        startActivity(intent);
    }

    public void bt3 (View v) {
        Intent intent = new Intent(this, Indalo3DemostrationDetailsActivity.class);
        intent.putExtra("view", 3);
        startActivity(intent);
    }

    public void bt4 (View v) {
        Intent intent = new Intent(this, Indalo3DemostrationDetailsActivity.class);
        intent.putExtra("view", 4);
        startActivity(intent);
    }


    private String getNameAndName2() {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_preferences), Context.MODE_PRIVATE);
        String name1 = sharedPreferences.getString(getString(R.string.name1), "");
        String name2 = sharedPreferences.getString(getString(R.string.name2), "");

        return name1 + " y " + name2 + getString(R.string.title_indalo_3_demostration);
    }
}
