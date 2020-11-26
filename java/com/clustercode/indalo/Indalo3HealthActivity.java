package com.clustercode.indalo;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Indalo3HealthActivity extends AppCompatActivity {

    private TextView txtReason1, txtReason2, txtReason3, txtReason4, txtReason5;
    private TextView txtSubtitle;
    private LinearLayout llReason1, llReason2, llReason3, llReason4, llReason5;

    private final int SHOW = 0, HIDE = 1;
    private int currentView = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_3_health);

        // Initialize all the Objects and Views
        initialize();
    }

    public void llReason1Clicked(View v) {
        modifyViews(llReason1, txtReason1, SHOW);
    }

    public void llReason2Clicked(View v) {
        modifyViews(llReason2, txtReason2, SHOW);
    }

    public void llReason3Clicked(View v) {
        modifyViews(llReason3, txtReason3, SHOW);
    }

    public void llReason4Clicked(View v) {
        modifyViews(llReason4, txtReason4, SHOW);
    }

    public void llReason5Clicked(View v) {
        modifyViews(llReason5, txtReason5, SHOW);
    }

    private void modifyViews(LinearLayout linearLayout, TextView textView, int mode) {
        if (mode == 0) {
            textView.setVisibility(View.VISIBLE);
            linearLayout.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
            linearLayout.requestLayout();
        } else if (mode == 1) {
            textView.setVisibility(View.GONE);
            linearLayout.getLayoutParams().width = LinearLayout.LayoutParams.WRAP_CONTENT;
            linearLayout.requestLayout();
        }

    }

    //Initialize views and objects
    private void initialize() {
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
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.title_indalo_3));
        TextView txtNext = findViewById(R.id.txtNext);
        txtNext.setText(getText(R.string.title_demostration));

        //Buttons
        ImageButton btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (currentView) {
                    case 0:
                        currentView++;
                        modifyViews(llReason1, txtReason1, SHOW);
                        break;
                    case 1:
                        currentView++;
                        modifyViews(llReason2, txtReason2, SHOW);
                        break;
                    case 2:
                        currentView++;
                        modifyViews(llReason3, txtReason3, SHOW);
                        break;
                    case 3:
                        currentView++;
                        modifyViews(llReason4, txtReason4, SHOW);
                        break;
                    case 4:
                        currentView++;
                        modifyViews(llReason5, txtReason5, SHOW);
                        break;
                    case 5:
                        Intent intent = new Intent(getApplicationContext(), Indalo3DemostrationActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                }

            }
        });

        //TextViews
        this.txtSubtitle = findViewById(R.id.txtTitleScreen);
        txtSubtitle.setText(getNameAndLastName());

        txtReason1 = findViewById(R.id.txtReason1);
        txtReason2 = findViewById(R.id.txtReason2);
        txtReason3 = findViewById(R.id.txtReason3);
        txtReason4 = findViewById(R.id.txtReason4);
        txtReason5 = findViewById(R.id.txtReason5);

        //LinearLayouts
        llReason1 = findViewById(R.id.llReason1);
        llReason2 = findViewById(R.id.llReason2);
        llReason3 = findViewById(R.id.llReason3);
        llReason4 = findViewById(R.id.llReason4);
        llReason5 = findViewById(R.id.llReason5);
    }

    private String getNameAndLastName() {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_preferences), Context.MODE_PRIVATE);
        String name1 = sharedPreferences.getString(getString(R.string.name1), "");
        String name2 = sharedPreferences.getString(getString(R.string.name2), "");

        return name1 + " y " + name2 + getString(R.string.title_indalo_3_health);
    }
}
