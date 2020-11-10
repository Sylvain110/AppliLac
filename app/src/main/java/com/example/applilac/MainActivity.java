package com.example.applilac;

import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //remplirTableClient();
        //on associe à un object java de type Button, un widget repéré physiquement par son id
        Button btnMoyenneReleves = findViewById(R.id.btnAfficherMoyenneReleves);
        Button btnAfficherReleves = findViewById(R.id.btnAfficherReleves);
        Button btnNewReleves = findViewById(R.id.btnNewReleve);
        //on place un écouteur dessus
        View.OnClickListener ecouteur = new View.OnClickListener() {
            //on implémente la méthode onclick
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnAfficherMoyenneReleves:
                        Intent intent1 = new Intent(MainActivity.this,
                                ActivityMoyenneReleve.class);
                        startActivity(intent1);
                        break;

                    case R.id.btnAfficherReleves:
                        Intent intent2 = new Intent(MainActivity.this,
                                ActivityAfficherReleve.class);
                        startActivity(intent2);
                        break;

                    case R.id.btnNewReleve:
                        Intent intent3 = new Intent(MainActivity.this,
                                ActivityNewReleve.class);
                        startActivity(intent3);
                        break;
                }
            }
        };
        //on affecte au bouton l'écouteur
        btnMoyenneReleves.setOnClickListener(ecouteur);
        btnAfficherReleves.setOnClickListener(ecouteur);
        btnNewReleves.setOnClickListener(ecouteur);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_MoyenneReleve:
                Toast.makeText(getApplicationContext(),"ouverture fenêtre Saisir " +
                        "relevé !", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, ActivityMoyenneReleve.class);
                startActivity(intent);
                return true;

            case R.id.menu_AfficherReleve:
                Toast.makeText(getApplicationContext(), "ouverture fenêtre liste des " +
                        "clients !", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(MainActivity.this, ActivityAfficherReleve.class);
                startActivity(intent2);
                return true;

            case R.id.menu_NewReleve:
                Toast.makeText(getApplicationContext(), "ouverture fenêtre liste des " +
                        "relevés !", Toast.LENGTH_LONG).show();
                Intent intent3 = new Intent(MainActivity.this, ActivityNewReleve.class);
                startActivity(intent3);
                return true;
        }
        return false;
    }

    public void remplirTableReleve() {
        DAOReleve clientBdd = new DAOReleve(this);
        Releve releve1 = new Releve("123", "03", "12", "12");
        Releve releve2 = new Releve(456, 04,03, 08);
        //on ouvre la base de données
        clientBdd.open();
        //on insère client1 puis client2
        clientBdd.insererReleve(releve1);
        clientBdd.insererReleve(releve2);
        //le curseur pour afficher le nombre de clients dans la base
        Cursor c = clientBdd.getData();
        Toast.makeText(getApplicationContext(), " il y a " +
                String.valueOf(c.getCount()) + " clients ", Toast.LENGTH_LONG).show();
    }
}
