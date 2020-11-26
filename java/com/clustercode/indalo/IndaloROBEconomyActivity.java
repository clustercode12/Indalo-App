package com.clustercode.indalo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class IndaloROBEconomyActivity extends AppCompatActivity {

    private TextView txtGastoMensual, txtGastoAnual, txtAnos, txtAhorroTotal, txtBotellasAmbiente;
    private ImageButton ivGastoMensualUp, ivGastoMensualDown, ivAnosUp, ivAnosDown;

    private int gastoMensual, anos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indalo_rob_economy);

        // Initialize all the Objects and Views
        initialize();
    }

    //Initialize views and objects
    private void initialize() {
        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.title_indalo_rob);
        TextView txtBack = findViewById(R.id.txtBack);
        txtBack.setText(getText(R.string.title_indalo_rob));
        TextView txtNext = findViewById(R.id.txtNext);
        txtNext.setText(getText(R.string.prompt_technolgy));
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
                Intent intent = new Intent(getApplicationContext(), IndaloROBTechnologyActivity.class);
                startActivity(intent);
                finish();
            }
        });

        txtGastoMensual = findViewById(R.id.txtGastoMensual);
        gastoMensual = Integer.parseInt(txtGastoMensual.getText().toString());
        txtGastoAnual = findViewById(R.id.txtGastoAnual);
        txtAnos = findViewById(R.id.txtAnos);
        anos = Integer.parseInt(txtAnos.getText().toString());
        txtAhorroTotal = findViewById(R.id.txtAhorroTotal);
        txtBotellasAmbiente = findViewById(R.id.txtBotellasAmbiente);

        ivGastoMensualUp = findViewById(R.id.ivGastoMensualUp);
        ivGastoMensualDown = findViewById(R.id.ivGastoMensualDown);
        ivAnosUp = findViewById(R.id.ivAnosUp);
        ivAnosDown = findViewById(R.id.ivAnosDown);
    }

    private void calcular() {
        txtGastoMensual.setText(gastoMensual + "");
        txtGastoAnual.setText(gastoMensual * 12 + "");
        txtAnos.setText(anos + "");
        txtAhorroTotal.setText((gastoMensual * 12) * anos + "");
        txtBotellasAmbiente.setText( (int)(((gastoMensual * 12) * anos) * 36.5) + "");
    }

    public void ivGastoMensualUpClicked (View v) {
        gastoMensual+=5;
        calcular();
    }

    public void ivGastoMensualDownClicked (View v) {
        if (gastoMensual >= 5) {
            gastoMensual -= 5;
            calcular();
        }
    }

    public void ivAnosUpClicked (View v) {
        anos++;
        calcular();
    }

    public void ivAnosDownClicked (View v) {
        if (anos >= 1) {
            anos--;
            calcular();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), IndaloROBActivity.class);
        startActivity(intent);
        finish();

        super.onBackPressed();
    }
}
