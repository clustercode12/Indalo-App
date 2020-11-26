package com.clustercode.indalo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class IndaloROBTechnologyActivity extends AppCompatActivity {

    private TextView txtReason1, txtReason2, txtReason3, txtReason4;
    private LinearLayout llReason1, llReason2, llReason3, llReason4;

    private static final int HIDE = 1, SHOW = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_rob_technology);

        // Initialize all the Objects and Views
        initialize();
    }

    //Initialize views and objects
    private void initialize() {

        //TextViews
        txtReason1 = findViewById(R.id.txtReason1);
        txtReason2 = findViewById(R.id.txtReason2);
        txtReason3 = findViewById(R.id.txtReason3);

        //LinearLayouts
        llReason1 = findViewById(R.id.llReason1);
        llReason2 = findViewById(R.id.llReason2);
        llReason3 = findViewById(R.id.llReason3);


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

            }
        });
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.title_indalo_rob));
        TextView txtNext = findViewById(R.id.txtNext);
        txtNext.setText(getText(R.string.title_video));
    }

    public void ll1Clicked(View v) {
        if (txtReason1.getVisibility() == View.VISIBLE) {
            Intent intent = new Intent(this, IndaloROBTechnology1Activity.class);
            startActivity(intent);
        } else {
            modifyViews(llReason1, txtReason1, SHOW);
            modifyViews(llReason2, txtReason2, HIDE);
            modifyViews(llReason3, txtReason3, HIDE);
        }
    }

    public void ll2Clicked(View v) {
        if (txtReason2.getVisibility() == View.VISIBLE) {
            Intent intent = new Intent(this, IndaloROBTechnology2Activity.class);
            startActivity(intent);
        } else {
            modifyViews(llReason1, txtReason1, HIDE);
            modifyViews(llReason2, txtReason2, SHOW);
            modifyViews(llReason3, txtReason3, HIDE);
        }
    }

    public void ll3Clicked(View v) {
        if (txtReason3.getVisibility() == View.VISIBLE) {
            Intent intent = new Intent(this, IndaloROBTechnology3Activity.class);
            startActivity(intent);
        } else {
            modifyViews(llReason1, txtReason1, HIDE);
            modifyViews(llReason2, txtReason2, HIDE);
            modifyViews(llReason3, txtReason3, SHOW);
        }
    }

    private void modifyViews(LinearLayout linearLayout, TextView textView, int mode) {
        switch (mode) {
            case HIDE:
                textView.setVisibility(View.GONE);
                linearLayout.getLayoutParams().width = LinearLayout.LayoutParams.WRAP_CONTENT;
                linearLayout.requestLayout();
                break;
            case SHOW:
                textView.setVisibility(View.VISIBLE);
                linearLayout.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
                linearLayout.requestLayout();
                break;
        }
    }
}
