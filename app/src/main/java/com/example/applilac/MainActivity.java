package com.example.applilac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //on associe à un objet java de type Button, un widget repéré physiquementpar son id
        Button btnAfficherLac = findViewById(R.id.btnAfficherMoyenneReleves);
        //on place un écouteur dessus
        View.OnClickListener ecouteur1 = new View.OnClickListener() {
            //on implémente la méthode onclick
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityMoyenneReleve.class);
                startActivity(intent);

            }
        };
        btnAfficherLac.setOnClickListener(ecouteur1);

        Button btnAfficherReleve = findViewById(R.id.btnAfficherReleves);
        View.OnClickListener ecouteur2 = new View.OnClickListener() {
            //on implémente la méthode onclick
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityAfficherReleve.class);
                startActivity(intent);
            }
        };
        btnAfficherReleve.setOnClickListener(ecouteur2);

        Button btnNewReleve = findViewById(R.id.btnNewReleve);
        View.OnClickListener ecouteur3 = new View.OnClickListener() {
            //on implémente la méthode onclick
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityNewReleve.class);
                startActivity(intent);
            }
        };
        btnNewReleve.setOnClickListener(ecouteur3);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_AfficherLac:
                Toast.makeText(getApplicationContext(), "ouverture fenêtre Moyenne relevé !", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, ActivityMoyenneReleve.class);
                startActivity(intent);
                return true;
            case R.id.menu_AfficherReleve:
                Toast.makeText(getApplicationContext(), "ouverture fenêtre Afficher relevé !",
                        Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(MainActivity.this, ActivityAfficherReleve.class);
                startActivity(intent1);
                return true;
            case R.id.menu_NewReleve:
                Toast.makeText(getApplicationContext(), "ouverture fenêtre Nouveau relevé !",
                        Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(MainActivity.this, ActivityNewReleve.class);
                startActivity(intent2);
                return true;
        }
        return false;
    }
}
