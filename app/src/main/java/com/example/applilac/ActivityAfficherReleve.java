package com.example.applilac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class ActivityAfficherReleve extends Activity {

    private TextView tvDisplayDate;
    private DatePicker dpResult;
    private Button btnChangeDate;

    private int year;
    private int month;
    private int day;

    static final int DATE__DIALOG__ID = 999;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficherreleve);

        setCurrentDateOnView();
        addListenerOnButton();

        String coord = "";
        String temp = "";
        String heures = "";
        //on va récupérer les trois valeurs provenant de ActivityNewReleve
        Intent intent = getIntent();
        if (intent != null) {
            coord = intent.getStringExtra("EXTRA_COORD");
            temp = intent.getStringExtra("EXTRA_TEMP");
            heures = intent.getStringExtra("EXTRA_HR");
        }

        // données du tableau
        final String [] Coord = {coord};
        final String[] Temp = {temp};
        final String[] Heures = {heures};

        TableLayout table = (TableLayout) findViewById(R.id.TableCoord); // on prend le tableau défini dans le layout
        TableRow row; // création d'un élément : ligne
        TextView tv1,tv2,tv3; // création des cellules

// pour chaque ligne
        for(int i=0;i<Coord.length;i++) {
            row = new TableRow(this); // création d'une nouvelle ligne

            tv1 = new TextView(this); // création cellule
            tv1.setText(Coord[i]); // ajout du texte
            tv1.setGravity(Gravity.CENTER); // centrage dans la cellule
            // adaptation de la largeur de colonne à l'écran :
            tv1.setLayoutParams( new TableRow.LayoutParams( 0, ViewGroup.LayoutParams.WRAP_CONTENT, 1 ) );

            // idem 2ème cellule
            tv2 = new TextView(this);
            tv2.setText(Temp[i]);
            tv2.setGravity(Gravity.CENTER);
            tv2.setLayoutParams( new TableRow.LayoutParams( 0, ViewGroup.LayoutParams.WRAP_CONTENT, 1 ) );

            // idem 3ème cellule
            tv3 = new TextView(this);
            tv3.setText(Heures[i]);
            tv3.setGravity(Gravity.CENTER);
            tv3.setLayoutParams( new TableRow.LayoutParams( 0, ViewGroup.LayoutParams.WRAP_CONTENT, 1 ) );

            // ajout des cellules à la ligne
            row.addView(tv1);
            row.addView(tv2);
            row.addView(tv3);

            // ajout de la ligne au tableau
            table.addView(row);
        }

        //programmation du bouton valider
        Button btnValider = findViewById(R.id.btnValiderNewReleve);
        //on va créer un écouteur
        View.OnClickListener ecouteur1 = new View.OnClickListener() {
            //on implémente la méthode onclick
            @Override
            public void onClick(View v) {

                final String message = "le relevé a bien été enregistré";
                Intent i1 = new Intent();
                i1.putExtra("MESSAGE",message);
                setResult(1,i1);
                //on ferme l'interface
                finish();
            }
        };
        //on affecte l'écouteur au bouton
        btnValider.setOnClickListener(ecouteur1);

    }

    //display current date
    public void setCurrentDateOnView() {

        tvDisplayDate = (TextView) findViewById(R.id.tvDate);
        dpResult = (DatePicker) findViewById(R.id.dpResult);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        //set current date into textview
        tvDisplayDate.setText(new StringBuilder()
                //Month is 0 based, just add 1
                .append(month + 1).append("-").append(day).append("-")
                .append(year).append(" "));

        //set current date into datepicker
        dpResult.init(year, month, day, null);

    }

    public void addListenerOnButton() {

        btnChangeDate = (Button) findViewById(R.id.btnChangeDate);

        btnChangeDate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                showDialog(DATE__DIALOG__ID);

            }

        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE__DIALOG__ID:
                //set date picker as current date
                return new DatePickerDialog(this, datePickerListener,
                        year, month,day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        //when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            //set selected date into textview
            tvDisplayDate.setText(new StringBuilder().append(month + 1)
                    .append("-").append(day).append("-").append(year)
                    .append(" "));

            //set selected date into datepicker also
            dpResult.init(year, month, day, null);

        }
    };

}