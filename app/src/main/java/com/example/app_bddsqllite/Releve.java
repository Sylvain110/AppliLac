package com.example.app_bddsqllite;

public class Releve {
    protected String numlac;
    protected String jour;
    protected String heure;
    protected String qte;

    //constructeur paramétré
    public  Releve (String numlac, String jour, String mois, int heure, float temp){
        super();
        this.numlac=unnumlac;
        this.jour=unjour;
        this.mois=unmois;
        this.heure=uneheure;
		this.temp=unetemp;
    }

    //les accesseurs
    public String getnumlac(){
        return numlac;
    }
    public void setnumlac(String numlac){
        this.numlac=numlac;
    }
    public String getjour(){
        return jour;
    }
    public void setjour(String jour) {
        this.jour = jour;
    }
    public String getheure(){
        return heure;
    }
	
	public float gettemp(){
        return temp;
    }

    //les mutateurs
    public void setheure(int heure){
        this.heure=heure;
    }
    public String getmois(){
        return mois;
    }
    public void setmois(String mois){
        this.mois=mois;
    }
	public void settemp(float temp){
        this.temp=temp;
    }
}
