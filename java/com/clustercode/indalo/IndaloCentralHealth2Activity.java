package com.clustercode.indalo;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class IndaloCentralHealth2Activity extends AppCompatActivity {

    private TextView txtBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_central_health_2);

        // Initialize all the Objects and Views
        initialize();
    }



    //Initialize views and objects
    private void initialize() {
        //TextViews
        TextView txtSubtitle = findViewById(R.id.txtHeader);
        txtSubtitle.setText(getNameAndName2());

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
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.title_indalo_central));
        final TextView txtNext = findViewById(R.id.txtNext);
        txtNext.setText(getText(R.string.action_continue));
        ImageButton btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtBody.getVisibility() == View.INVISIBLE) {
                    txtBody.setVisibility(View.VISIBLE);
                    txtNext.setText(getString(R.string.title_demostration));
                } else {
                    Intent intent = new Intent(getApplicationContext(), IndaloCentralDemostrationActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        txtBody = findViewById(R.id.txtBody);

    }

    private String getNameAndName2() {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_preferences), Context.MODE_PRIVATE);
        String name1 = sharedPreferences.getString(getString(R.string.name1), "");
        String name2 = sharedPreferences.getString(getString(R.string.name2), "");

        return name1 + " y " + name2 + getString(R.string.title_health_3);
    }
}
