package com.clustercode.indalo;

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
import android.widget.TextView;
import android.widget.Toast;


public class WhereAreWeActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where_are_we);

        // Initialize all the Objects and Views
        initialize();
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
                switch(id)
                {
                    case R.id.nav_account:
                        Toast.makeText(WhereAreWeActivity.this, "My Account",Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_credit:
                        Toast.makeText(WhereAreWeActivity.this, "Settings",Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_opportunity:
                        Toast.makeText(WhereAreWeActivity.this, "My Cart", Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_exit:
                        Toast.makeText(WhereAreWeActivity.this, "Exit", Toast.LENGTH_SHORT).show();break;
                    default:
                        return true;
                }


                return true;

            }
        });

        //Initialize
        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.title_where_are_we);
        ImageButton btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        ImageButton btNext = findViewById(R.id.btNext);
        btNext.setVisibility(View.INVISIBLE);
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setVisibility(View.INVISIBLE);
        TextView txtNext = findViewById(R.id.txtNext);
        txtNext.setVisibility(View.INVISIBLE);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
