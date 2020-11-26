package com.clustercode.indalo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;

import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class WelcomeActivity extends AppCompatActivity {

    private TextView txtReason1, txtReason2, txtReason3, txtReason4, txtNext;
    private LinearLayout llReason1, llReason2, llReason3, llReason4;

    private static final int HIDE = 1, SHOW = 2;
    private int currentView = 1;

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Initialize all the Objects and Views
        initialize();
    }

    public void llReason1Clicked(View v) {
        modifyViews(llReason1, txtReason1, SHOW);
        modifyViews(llReason2, txtReason2, HIDE);
        modifyViews(llReason3, txtReason3, HIDE);
        modifyViews(llReason4, txtReason4, HIDE);
        txtNext.setVisibility(View.INVISIBLE);
        currentView = 1;
    }

    public void llReason2Clicked(View v) {
        modifyViews(llReason1, txtReason1, HIDE);
        modifyViews(llReason2, txtReason2, SHOW);
        modifyViews(llReason3, txtReason3, HIDE);
        modifyViews(llReason4, txtReason4, HIDE);
        txtNext.setVisibility(View.INVISIBLE);

        currentView = 2;
    }

    public void llReason3Clicked(View v) {
        modifyViews(llReason1, txtReason1, HIDE);
        modifyViews(llReason2, txtReason2, HIDE);
        modifyViews(llReason3, txtReason3, SHOW);
        modifyViews(llReason4, txtReason4, HIDE);
        txtNext.setVisibility(View.INVISIBLE);

        currentView = 3;
    }

    public void llReason4Clicked(View v) {
        modifyViews(llReason1, txtReason1, HIDE);
        modifyViews(llReason2, txtReason2, HIDE);
        modifyViews(llReason3, txtReason3, HIDE);
        modifyViews(llReason4, txtReason4, SHOW);
        txtNext.setText(getText(R.string.action_continue));
        txtNext.setVisibility(View.VISIBLE);

        currentView = 4;
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

    //Initialize views and objects
    private void initialize() {
        //Drawer Activity
        dl = findViewById(R.id.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar_top);
        t = new ActionBarDrawerToggle(this, dl, toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        dl.setDrawerListener(t);
        t.syncState();

        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id) {
                    case R.id.nav_account:
                        startActivity(new Intent(getApplicationContext(), MyAccountActivity.class));break;
                    case R.id.nav_credit:
                        startActivity(new Intent(getApplicationContext(), SolicitudCreditoActivity.class));break;
                    case R.id.nav_opportunity:
                        Toast.makeText(WelcomeActivity.this, "Oportunity", Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_exit:
                        Toast.makeText(WelcomeActivity.this, "Exit", Toast.LENGTH_SHORT).show();break;
                    default:
                        return true;
                }


                return true;

            }
        });


        //TextViews
        txtReason1 = findViewById(R.id.txtReason1);
        txtReason2 = findViewById(R.id.txtReason2);
        txtReason3 = findViewById(R.id.txtReason3);
        txtReason4 = findViewById(R.id.txtReason4);

        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.title_welcome);
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setVisibility(View.INVISIBLE);
        txtNext = findViewById(R.id.txtNext);
        txtNext.setVisibility(View.INVISIBLE);

        TextView txtSubtitle = findViewById(R.id.txtDialog);
        txtSubtitle.setText(getNameAndLastname() + getString(R.string.prompt_catherinne));

        //LinearLayouts
        llReason1 = findViewById(R.id.llReason1);
        llReason2 = findViewById(R.id.llReason2);
        llReason3 = findViewById(R.id.llReason3);
        llReason4 = findViewById(R.id.llReason4);

        //Buttons
        ImageButton btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (currentView) {
                    case 0:
                        llReason1Clicked(null);
                        break;
                    case 1:
                        llReason2Clicked(null);
                        break;
                    case 2:
                        llReason3Clicked(null);
                        break;
                    case 3:
                        llReason4Clicked(null);
                        break;
                    case 4:
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
        ImageButton btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ClientDetailsActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    private String getNameAndLastname() {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_preferences), Context.MODE_PRIVATE);
        String name1 = sharedPreferences.getString(getString(R.string.name1), "");
        String name2 = sharedPreferences.getString(getString(R.string.name2), "");

        return name1 + " y " + name2 + getString(R.string.title_health_1);
    }
}
