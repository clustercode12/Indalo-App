package com.clustercode.indalo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class IndaloROBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_rob);

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
                Intent intent = new Intent(getApplicationContext(), ProductsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ImageButton btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IndaloCentralActivity.class);
                startActivity(intent);
                finish();
            }
        });
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.title_products));
        TextView txtNext = findViewById(R.id.txtNext);
        txtNext.setText(getText(R.string.title_indalo_3));
    }

    public void ibHealthClicked (View v) {
        Intent intent = new Intent(this, IndaloROBHealthActivity.class);
        startActivity(intent);
    }

    public void ibDemostrationClicked (View v) {
        Intent intent = new Intent(this, IndaloROBDemostrationActivity.class);
        startActivity(intent);
    }

    public void ibEconomyClicked (View v) {
        Intent intent = new Intent(this, IndaloROBEconomyActivity.class);
        startActivity(intent);
    }

    public void ibTechnologyClicked (View v) {
        Intent intent = new Intent(this, IndaloROBTechnologyActivity.class);
        startActivity(intent);
    }

    public void ibVideoClicked (View v) {
        Intent intent = new Intent(this, IndaloROBYoutubeActivity.class);
        intent.putExtra("url", "tfdYuVc_Iuc");
        intent.putExtra("url2", "5J8lWrwtw9Y");
        intent.putExtra("title", getString(R.string.title_indalo_rob));
        intent.putExtra("textBack", getString(R.string.title_indalo_rob));
        intent.putExtra("textNext", getString(R.string.title_indalo_3));
        intent.putExtra("classBack", IndaloROBActivity.class);
        intent.putExtra("classNext", IndaloCentralActivity.class);
        startActivity(intent);
    }
}
