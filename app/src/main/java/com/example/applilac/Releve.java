package com.example.app_bddsqllite;

public class Releve {
    protected String numlac;
    protected String jour;
    protected String mois;
    protected String heure;
    protected float temp;

    //constructeur paramétré
    public  Releve (String numlac, String jour, String mois, String heure, float temp){
        super();
        this.numlac=numlac;
        this.jour=jour;
        this.mois=mois;
        this.heure=heure;
		this.temp=temp;
    }


    //les accesseurs
    public String getnumlac(){

        return numlac;
    }
    public String getjour() {
        return jour;
    }
    public String getmois(){
        return mois;
    }
    public String getheure(){
        return heure;
    }
	public float gettemp(){
        return temp;
    }


    //les mutateurs
    public void setnumlac(String numlac){
        this.numlac=numlac;
    }
    public void setjour(String jour) {
        this.jour = jour;
    }
    public void setmois(String mois){
        this.mois=mois;
    }
    public void setheure(String heure){
        this.heure=heure;
    }
	public void settemp(float temp){
        this.temp=temp;
    }
}
