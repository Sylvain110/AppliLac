package com.example.applilac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ActivityAfficherReleve extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficherreleve);


        String coord = "";
        String temp = "";
        String heures = "";
        //on va récupérer les trois valeurs provenant de ActivityNewReleve
        Intent intent = getIntent();
        if (intent != null) {
            coord = intent.getStringExtra("EXTRA_COOR");
            temp = intent.getStringExtra("EXTRA_TEMP");
            heures = intent.getStringExtra("EXTRA_HR");
        }

    }

}

