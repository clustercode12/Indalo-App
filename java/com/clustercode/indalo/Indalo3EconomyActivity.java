package com.clustercode.indalo;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Indalo3EconomyActivity extends AppCompatActivity {

    private TextView txtGastoMensual, txtGastoAnual, txtAnos, txtAhorroTotal, txtAhorroIndalo;

    private int gastoMensual, anos, view = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_3_economy);

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
        TextView txtBack = findViewById(R.id.txtBack);
        if (view == 0) {
            txtBack.setText(getText(R.string.title_indalo_3));
        } else {
            txtBack.setText(getText(R.string.title_economy));
        }
        TextView txtNext = findViewById(R.id.txtNext);
        if (view == 0) {
            txtNext.setText(getText(R.string.title_economy));
        } else {
            txtNext.setText(getText(R.string.prompt_technolgy));
        }
        ImageButton btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view == 0) {
                    Intent intent = new Intent(getApplicationContext(), Indalo3Activity.class);
                    startActivity(intent);
                    finish();
                } else {
                    view = 0;
                    setContentView(R.layout.activity_indalo_3_economy);
                    initialize();
                }
            }
        });
        ImageButton btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view == 0) {
                    view = 1;
                    setContentView(R.layout.activity_indalo_3_economy_2);
                    initialize();
                } else {
                    Intent intent = new Intent(getApplicationContext(), Indalo3TechnologyActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

        txtGastoMensual = findViewById(R.id.txtGastoMensual);
        gastoMensual = Integer.parseInt(txtGastoMensual.getText().toString());
        txtGastoAnual = findViewById(R.id.txtGastoAnual);
        txtAnos = findViewById(R.id.txtAnos);
        anos = Integer.parseInt(txtAnos.getText().toString());
        txtAhorroTotal = findViewById(R.id.txtAhorroTotal);
        txtAhorroIndalo = findViewById(R.id.txtBotellasAmbiente);

    }

    private void calcular() {
        txtGastoMensual.setText(gastoMensual + "");
        txtGastoAnual.setText(gastoMensual * 12 + "");
        txtAnos.setText(anos + "");
        txtAhorroTotal.setText((gastoMensual * 12) * anos + "");
        if (view == 1) {
            txtAhorroIndalo.setText((int) (0.1 * Integer.parseInt(txtAhorroTotal.getText().toString())) + "");

        }
    }

    public void ivGastoMensualUpClicked (View v) {
        if (view == 0) {
            if (gastoMensual <= 450) {
                gastoMensual += 50;
                calcular();
            }
        } else {
            if (gastoMensual < 600) {
                gastoMensual += 50;
                calcular();
            }
        }
    }

    public void ivGastoMensualDownClicked (View v) {
        if (view == 0) {
            if (gastoMensual >= 150) {
                gastoMensual -= 50;
                calcular();
            }
        } else {
            if (gastoMensual > 50) {
                gastoMensual -= 50;
                calcular();
            }
        }
    }

    public void ivAnosUpClicked (View v) {
        if (anos <= 9) {
            anos++;
            calcular();
        }
    }

    public void ivAnosDownClicked (View v) {
        if (anos >= 3) {
            anos--;
            anos--;
            calcular();
        }
    }

    private String getNameAndName2() {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_preferences), Context.MODE_PRIVATE);
        String name1 = sharedPreferences.getString(getString(R.string.name1), "");
        String name2 = sharedPreferences.getString(getString(R.string.name2), "");

        if (view == 0) {
            return name1 + " y " + name2 + getString(R.string.title_indalo_3_economy);
        } else {
            return name1 + " y " + name2 + getString(R.string.title_indalo_3_economy_2);
        }
    }
}
