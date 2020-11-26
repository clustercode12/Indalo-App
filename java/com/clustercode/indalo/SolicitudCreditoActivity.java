package com.clustercode.indalo;

import android.os.Bundle;
import android.os.Environment;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

//import com.itextpdf.forms.PdfAcroForm;
//import com.itextpdf.io.font.PdfEncodings;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfReader;
//import com.itextpdf.kernel.pdf.PdfWriter;


import java.io.File;
import java.io.IOException;

public class SolicitudCreditoActivity extends AppCompatActivity {

    private TextInputEditText tietEquipo, tietName, tietSecondName, tietLastName, tietID, tietIDDate, tietExpireDate, tietState, tietBornDate, tietEnsurance, tietPhone, tietCellular, tietHour, tietEmail, tietAddress, tietCity, tietState2, tietZipCode, tietHouseWorth, tietRentPayment, tietYears, tietMonths, tietEmpleador, tietPosicion, tietYearsEmpleo, tietMonthsEmpleo, tietTelefonoEmpleador, tietIngresoMensual, tietRetiro, tietRenta, tietInversiones, tietOtro;
    private ToggleButton toggleButton, toggleButton2, toggleButton3;

    private String equipo, name, secondName, lastName, id, idDate, expireDate, state, bornDate, ensurance, phone, cellular, hour, email, address, city, state2, zipCode, houseWorth, rentPayment, years, months, empleador, posicion, yearsEmpleo, monthsEmpleo, telefonoEmpleador, ingresoMensual, retiro, renta, inversiones, otro;
    private int tipoResidencia, contratoEspanol, empleoPropio;

    public static final String DEST = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
    public static final String FONT = "./src/test/resources/font/FreeSans.ttf";
    public static final String SRC = "./android_asset/credit_aplication.pdf";
    public static final String VALUE = "\u011b\u0161\u010d\u0159\u017e\u00fd\u00e1\u00ed\u00e9";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_credito);

        // Initialize all the Objects and Views
        initialize();
    }

    public void signatureClicked(View v) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        manipulatePdf(SRC, DEST);
    }

    //Initialize views and objects
    private void initialize() {

        //Initialize other Activities
        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.solicitud_credito);
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

        //
        tietEquipo = findViewById(R.id.tietEquipo);
        tietName = findViewById(R.id.tietName);
        tietSecondName = findViewById(R.id.tietSecondName);
        tietLastName = findViewById(R.id.tietLastName);
        tietID = findViewById(R.id.tietID);
        tietIDDate = findViewById(R.id.tietIDDate);
        tietExpireDate = findViewById(R.id.tietExpireDate);
        tietState = findViewById(R.id.tietState);
        tietBornDate = findViewById(R.id.tietBornDate);
        tietEnsurance = findViewById(R.id.tietEnsurance);
        tietPhone = findViewById(R.id.tietPhone);
        tietCellular= findViewById(R.id.tietCellular);
        tietHour = findViewById(R.id.tietHour);
        tietEmail = findViewById(R.id.tietEmail);
        tietAddress = findViewById(R.id.tietAddress);
        tietCity = findViewById(R.id.tietCity);
        tietState2 = findViewById(R.id.tietState2);
        tietZipCode = findViewById(R.id.tietZipCode);
        tietHouseWorth = findViewById(R.id.tietHouseWorth);
        tietRentPayment = findViewById(R.id.tietRentPayment);
        tietYears = findViewById(R.id.tietYears);
        tietMonths = findViewById(R.id.tietMonths);
        tietEmpleador = findViewById(R.id.tietEmpleador);
        tietPosicion = findViewById(R.id.tietPosicion);
        tietYearsEmpleo = findViewById(R.id.tietYearsEmpleo);
        tietMonthsEmpleo = findViewById(R.id.tietMonthsEmpleo);
        tietTelefonoEmpleador = findViewById(R.id.tietTelefonoEmpleador);
        tietIngresoMensual = findViewById(R.id.tietIngresoMensual);
        tietRetiro = findViewById(R.id.tietRetiro);
        tietRenta = findViewById(R.id.tietRenta);
        tietInversiones = findViewById(R.id.tietInversiones);
        tietOtro = findViewById(R.id.tietOtro);

        toggleButton = findViewById(R.id.toggleButton);
        toggleButton2 = findViewById(R.id.toggleButton2);
        toggleButton3 = findViewById(R.id.toggleButton3);

    }

    private void getData() {
        equipo = tietEquipo.getText().toString();
        name = tietName.getText().toString();
        lastName = tietLastName.getText().toString();
        secondName = tietSecondName.getText().toString();
        id = tietID.getText().toString();
        idDate = tietIDDate.getText().toString();
        expireDate = tietExpireDate.getText().toString();
        state = tietState.getText().toString();
        bornDate = tietBornDate.getText().toString();
        ensurance = tietEnsurance.getText().toString();
        phone = tietPhone.getText().toString();
        cellular = tietCellular.getText().toString();
        hour = tietHour.getText().toString();
        email = tietEmail.getText().toString();
        address = tietAddress.getText().toString();
        city = tietCity.getText().toString();
        state2 = tietState2.getText().toString();
        zipCode = tietZipCode.getText().toString();
        houseWorth = tietHouseWorth.getText().toString();
        rentPayment = tietRentPayment.getText().toString();
        years = tietYears.getText().toString();
        months = tietMonths.getText().toString();
        empleador = tietEmpleador.getText().toString();
        posicion = tietPosicion.getText().toString();
        yearsEmpleo = tietYearsEmpleo.getText().toString();
        monthsEmpleo = tietMonthsEmpleo.getText().toString();
        telefonoEmpleador = tietTelefonoEmpleador.getText().toString();
        ingresoMensual = tietIngresoMensual.getText().toString();
        retiro = tietRetiro.getText().toString();
        renta = tietRenta.getText().toString();
        inversiones = tietInversiones.getText().toString();
        otro = tietOtro.getText().toString();
        if (toggleButton.isSelected()) {
            tipoResidencia = 1;
        } else {
            tipoResidencia = 0;
        }
        if (toggleButton2.isSelected()) {
            contratoEspanol = 1;
        } else {
            contratoEspanol = 0;
        }
        if (toggleButton3.isSelected()) {
            empleoPropio = 1;
        } else {
            empleoPropio = 0;
        }
    }

    public void manipulatePdf(String src, String dest) throws IOException {
        getData();

//        PdfDocument pdfDoc = new PdfDocument(new PdfReader(SRC), new PdfWriter(DEST));
//
//        PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
//        form.setGenerateAppearance(true);
//
//        PdfFont font = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H);
//
//        form.getField("Equipo").setValue("r");
//
//        pdfDoc.close();
    }
}
