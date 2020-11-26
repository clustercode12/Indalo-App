package com.clustercode.indalo;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ClientDetailsActivity extends AppCompatActivity {

    private String name1, lastName1, name2, lastName2, phone, email, city, zipCode, state;
    private boolean isMale1, isMale2;

    private TextInputEditText tietName1, tietLastName1, tietName2, tietLastName2, tietPhone, tietEmail, tietCity, tietZipCode;
    private Spinner spGender1, spGender2, spState;

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_details);

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
                        Toast.makeText(ClientDetailsActivity.this, "My Account",Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_credit:
                        Toast.makeText(ClientDetailsActivity.this, "Settings",Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_opportunity:
                        Toast.makeText(ClientDetailsActivity.this, "My Cart", Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_exit:
                        Toast.makeText(ClientDetailsActivity.this, "Exit", Toast.LENGTH_SHORT).show();break;
                    default:
                        return true;
                }


                return true;

            }
        });

        ImageButton btToolbarBottomLeft = findViewById(R.id.btBack);
        btToolbarBottomLeft.setVisibility(View.INVISIBLE);
        ImageButton btToolbarBottomRight = findViewById(R.id.btNext);
        btToolbarBottomRight.setVisibility(View.INVISIBLE);

        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.title_client_details);
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setVisibility(View.INVISIBLE);
        TextView txtNext = findViewById(R.id.txtNext);
        txtNext.setVisibility(View.INVISIBLE);

        tietName1 = findViewById(R.id.tietName);
        tietName2 = findViewById(R.id.tietName2);
        tietLastName1 = findViewById(R.id.tietLastName);
        tietLastName2 = findViewById(R.id.tietLastName2);
        tietPhone = findViewById(R.id.tietPhone);
        tietEmail = findViewById(R.id.tietEmail);
        tietCity = findViewById(R.id.tietCity);
        tietZipCode = findViewById(R.id.tietZipCode);

        spGender1 = findViewById(R.id.spMrMrs);
        spGender2 = findViewById(R.id.spMrMrs2);
        spState = findViewById(R.id.spState);
    }

    private boolean isFormFilled() {
        if (tietName1.getText().toString().isEmpty() || tietName2.getText().toString().isEmpty() || tietLastName1.getText().toString().isEmpty() || tietLastName2.getText().toString().isEmpty() || tietPhone.getText().toString().isEmpty() || tietEmail.getText().toString().isEmpty() || tietCity.getText().toString().isEmpty() || tietZipCode.getText().toString().isEmpty() || spState.getSelectedItem().toString().equals("State")) {
            return false;
        }

        return true;
    }

    private boolean getGenderFromSpinner(Spinner spinner) {
        if (spinner.getSelectedItem().toString() == "Sr.") {
            return true;
        }

        return false;
    }

    private void saveEntries() {
        name1 = tietName1.getText().toString();
        lastName1 = tietLastName1.getText().toString();
        name2 = tietName2.getText().toString();
        lastName2 = tietLastName2.getText().toString();
        phone = tietPhone.getText().toString();
        email = tietEmail.getText().toString();
        city = tietCity.getText().toString();
        zipCode = tietZipCode.getText().toString();
        state = spState.getSelectedItem().toString();

        isMale1 = getGenderFromSpinner(spGender1);
        isMale2 = getGenderFromSpinner(spGender2);

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(getString(R.string.name1), name1);
        editor.putString(getString(R.string.name2), name2);
        editor.putString(getString(R.string.lastName1), lastName1);
        editor.putString(getString(R.string.lastName2), lastName2);
        editor.putString(getString(R.string.phone), phone);
        editor.putString(getString(R.string.email), email);
        editor.putString(getString(R.string.city), city);
        editor.putString(getString(R.string.zipCode), zipCode);
        editor.putString(getString(R.string.state), state);
        editor.putBoolean(getString(R.string.gender1), isMale1);
        editor.putBoolean(getString(R.string.gender2), isMale2);

        editor.apply();

    }

    public void send(View v) {
        //Delete this
        saveEntries();
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);


//        if (isFormFilled()) {
//            saveEntries();
//            Intent intent = new Intent(this, WelcomeActivity.class);
//            startActivity(intent);
//        } else {
//            Toast.makeText(this, getString(R.string.action_form_not_filled), Toast.LENGTH_SHORT).show();
//        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
