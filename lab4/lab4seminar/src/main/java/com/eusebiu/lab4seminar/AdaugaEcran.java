package com.eusebiu.lab4seminar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugaEcran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_ecran);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void salveazaDatele(View view){
        EditText etProducator = findViewById(R.id.etProducator);
        String producator = etProducator.getText().toString();

        CheckBox cbOled = findViewById(R.id.cbOled);
        boolean esteOled = cbOled.isChecked();

        RadioGroup rgFormat = findViewById(R.id.rgFormat);
        int radioIdSelectat = rgFormat.getCheckedRadioButtonId();
        RadioButton rbSelectat = findViewById(R.id.radioButton);
        String format =(rbSelectat != null) ? rbSelectat.getText().toString() : "Neselectat";
        Spinner spinnerRez = findViewById(R.id.spinnerRezolutie);
        String rezolutie = spinnerRez.getSelectedItem().toString();
        Switch switchSmart = findViewById(R.id.switchSmart);
        boolean esteSmart = switchSmart.isChecked();
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        float rating = ratingBar.getRating();

        Ecran ecranNou = new Ecran(producator,esteOled,format,rezolutie,rating,esteSmart);
        Intent intentReturn = new Intent();
        intentReturn.putExtra("OBIECT_NOU",ecranNou);
        setResult(RESULT_OK,intentReturn);
        finish();
    }
}