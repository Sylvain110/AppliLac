package com.example.applilac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityNewReleve extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newreleve);

        //on déclare des objets java pour chaque widget et obligatoirement en constante
        // car passées à l'autre interface
        final Spinner coordonnees = findViewById(R.id.spinnerCoordGPS);
        final EditText temperature = findViewById(R.id.editTextTemp);
        final String[] heures = {""};

        Button btnEnregistrer = (Button) findViewById(R.id.buttonEnregistrer);
        Button btnAnnuler = (Button) findViewById(R.id.buttonAnnuler);
        //on va créer un écouteur pour un groupe de boutons
        View.OnClickListener ecouteur = new View.OnClickListener() {
            //on implémente la méthode onclick
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonEnregistrer:
                        //on passer les infos dans l'autre interface
                        Intent i = new Intent (ActivityNewReleve.this, ActivityAfficherReleve.class);

                        i.putExtra("EXTRA_TEMP",temperature.getText().toString());
                        i.putExtra("EXTRA_HR",heures[0]);
                        startActivityForResult(i,0);
                        break;
                    case R.id.buttonAnnuler:
                        finish();
                        break;
                }
            }
        };
        btnEnregistrer.setOnClickListener(ecouteur);
        btnAnnuler.setOnClickListener(ecouteur);


        //programmation des boutons radios
        RadioGroup radioGroupHeures = findViewById(R.id.radioGroupHeures);
        radioGroupHeures.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged (RadioGroup radioGroupHeures, int i){
                switch (i) {
                    case R.id.radioButton6H:
                        heures[0] ="6h";
                        Toast.makeText(getApplicationContext(), " 6h", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radioButton12H:
                        heures[0] ="12h";
                        Toast.makeText(getApplicationContext(), " 12h", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radioButton18H:
                        heures[0] ="18h";
                        Toast.makeText(getApplicationContext(), " 18h", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radioButton24H:
                        heures[0] ="24h";
                        Toast.makeText(getApplicationContext(), " 24H", Toast.LENGTH_LONG).show();
                        break;
                }

            }
        });
        //gestion de la liste déroulante des numéros de compteur
        final Spinner spinnerNumCpt = (Spinner) findViewById(R.id.spinnerCoordGPS);
        String[] lescompteurs={"123","456","789","147","258", "369"};
        ArrayAdapter<String> dataAdapterR = new ArrayAdapter <String>( this , android.R.layout.simple_spinner_item ,lescompteurs );
        dataAdapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNumCpt.setAdapter(dataAdapterR);
        spinnerNumCpt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String monCompteur = String.valueOf(spinnerNumCpt.getSelectedItem());
                Toast.makeText(ActivityNewReleve.this, "Vous avez choisie : " + "\nle compteur numéro : " + monCompteur, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
