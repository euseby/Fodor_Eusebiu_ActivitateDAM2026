package com.eusebiu.lab4seminar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListaEcrane extends AppCompatActivity {
    private ArrayList<Ecran> listaEcrane;
    private ArrayAdapter<Ecran> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_ecrane);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView listView = findViewById(R.id.lvEcrane);
        Intent intent = getIntent();
        if(intent.hasExtra("ListaEcrane")){
            listaEcrane = (ArrayList<Ecran>) intent.getSerializableExtra("ListaEcrane");
        }
        else {
            listaEcrane = new ArrayList<>();
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaEcrane);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Ecran ecranSelectat = listaEcrane.get(position);
                Toast.makeText(ListaEcrane.this, "Selectat:\n" + ecranSelectat.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                listaEcrane.remove(position);
                adapter.notifyDataSetChanged();
                trimiteListaInapoi();
                Toast.makeText(ListaEcrane.this,"Obiect sters:\n",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
    private void trimiteListaInapoi(){
        Intent resultIntent = new Intent();
        resultIntent.putExtra("LISTA_MODIFICATA",listaEcrane);
        setResult(RESULT_OK,resultIntent);
    }
}