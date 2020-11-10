package com.example.applilac;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DAOReleve {
    static final int VERSION_BDD =1;
    private static final String NOM_BDD = "Releves.db";
    static final String TABLE_RELEVES = "table_Releves";
    static final String COL_ID = "_id";
    static final int NUM_COL_ID = 0;
    static final String COL_NUMLAC = "numlac";
    static final int NUM_COL_NUMLAC = 1;
    static final String COL_JOUR = "jour";
    static final int NUM_COL_JOUR = 2;
    static final String COL_MOIS = "mois";
    static final int NUM_COL_MOIS = 3;
    static final String COL_HEURE = "heure";
    static final int NUM_COL_HEURE = 4;
    static final String COL_TEMP = "temp";
    static final int NUM_COL_TEMP = 5;
    private CreateBDReleve tableReleve;
    private Context context;
    private SQLiteDatabase db;

    //le constructeur
    public DAOReleve  (Context context){
        this.context = context;
        tableReleve = new CreateBDReleve(context, NOM_BDD, null, VERSION_BDD);
    }

    //si la base n’existe pas, l’objet SQLiteOpenHelper exécute la méthode onCreate
    // si la version de la base a changé, la méthode onUpgrade sera lancée
    // dans les 2 cas l’appel à getWritableDatabase ou getReadableDatabase renverra  la base
    // de données en cache, nouvellement ouverte, nouvellement créée ou mise à jour

    //les méthoJOUR d'instance
    public DAOReleve  open(){
        db = tableReleve.getWritableDatabase();
        return this;
    }
    public DAOReleve close (){
        db.close();
        return null;
    }
    public long insererReleve (Releve unReleve){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_NUMLAC, unReleve.getnumlac());
        values.put(COL_JOUR, unReleve.getjour());
        values.put(COL_MOIS, unReleve.getmois());
        values.put(COL_HEURE, unReleve.getheure());
        values.put(COL_TEMP, unReleve.gettemp());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_RELEVES, null, values);
    }

    private Releve cursorToReleve(Cursor c){ //Cette méthode permet de convertir un cursor en un Releve
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;
        //Sinon
        c.moveToFirst();   //on se place sur le premier élément
        Releve unReleve = new Releve(null,null,null,null, null);  //On créé un Releve
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        unReleve.setnumlac(c.getString(NUM_COL_NUMLAC));
        unReleve.setjour(c.getString(NUM_COL_JOUR));
        unReleve.setmois(c.getString(NUM_COL_MOIS));
        unReleve.setheure(c.getString(NUM_COL_HEURE));
        unReleve.settemp(c.getFloat(NUM_COL_TEMP));
        c.close();     //On ferme le cursor
        return unReleve;  //On retourne l'Releve
    }

    public Releve getReleveWithJour(String jour){
        //Récupère dans un Cursor les valeurs correspondant à un Releve grâce à sa JOURignation)
        Cursor c = db.query(TABLE_RELEVES, new String[] {COL_ID,COL_NUMLAC, COL_JOUR,
                COL_MOIS, COL_HEURE}, COL_JOUR + " LIKE \"" + jour +"\"",
                null, null, null, null);
        return cursorToReleve(c);
    }

    public int updateReleve(String numlac, Releve unReleve){
        //La mise à jour d'un Releve dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simple préciser quel Releve on doit mettre à jour grâce à sa référence
        ContentValues values = new ContentValues();
        values.put(COL_JOUR, unReleve.getjour());
        values.put(COL_MOIS, unReleve.getmois());
        values.put(COL_HEURE, unReleve.getheure());
        values.put(COL_TEMP, unReleve.gettemp());
        return db.update(TABLE_RELEVES, values, COL_NUMLAC + " = \"" +numlac+"\"", null);
    }
    public int removeReleveWithNUMLAC(String numlac){
        //Suppression d'un Releve de la BDD grâce à sa référence
        return db.delete(TABLE_RELEVES, COL_NUMLAC + " = \"" +numlac+"\"", null);
    }

    public Cursor getData(){
        return db.rawQuery("SELECT * FROM TABLE_RELEVES", null);
    }


}



