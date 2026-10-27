package com.eusebiu.lab4seminar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final int COD_CERERE_ADAUGA = 100;
    public static final int COD_CERERE_LISTA = 200;
    private ArrayList<Ecran> listaEcrane = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void openActivityAdauga(View view ){
        Intent intent = new Intent(getApplicationContext(), AdaugaEcran.class);
        startActivityForResult(intent,COD_CERERE_ADAUGA);
    }
    public void openActivityLista(View view){
        Intent intent = new Intent(getApplicationContext(), ListaEcrane.class);
        intent.putExtra("ListaEcrane",listaEcrane);
        startActivityForResult(intent,COD_CERERE_LISTA);
    }
    @Override
    protected void onActivityResult(int reqCode, int resCode, @Nullable Intent data){
        super.onActivityResult(reqCode, resCode, data);
        if(reqCode == COD_CERERE_ADAUGA && resCode == RESULT_OK){
            if(data!=null){
                Ecran ecranPrimit = (Ecran) data.getSerializableExtra("OBIECT_NOU");
                listaEcrane.add(ecranPrimit);
                Toast.makeText(this,"Salvat:\n"+ecranPrimit.toString(),Toast.LENGTH_LONG).show();
            }
        }
        if(reqCode == COD_CERERE_LISTA && resCode == RESULT_OK ){
            if(data!=null){
                listaEcrane = (ArrayList<Ecran>) data.getSerializableExtra("LISTA_MODIFICATA");
            }
        }
    }

}