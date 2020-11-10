package com.example.applilac;

public class Releve {
    protected String numlac;
    protected String jour;
    protected String mois;
    protected String heure;
    protected float temp;

    //constructeur paramétré
    public  Releve (String numlac, String jour, String mois, String heure, Float temp){
        super();
        this.numlac=numlac;
        this.jour=jour;
        this.mois=mois;
        this.heure=heure;
		this.temp=temp;
    }




    //Les accesseurs et les mutateurs
    public String getnumlac(){ return numlac; }
    public void setnumlac(String numlac){
        this.numlac=numlac;
    }

    public String getjour() {
        return jour;
    }
    public void setjour(String jour) {
        this.jour = jour;
    }

    public String getmois(){
        return mois;
    }
    public void setmois(String mois){
        this.mois=mois;
    }

    public String getheure(){
        return heure;
    }
    public void setheure(String heure){
        this.heure=heure;
    }

	public float gettemp(){
        return temp;
    }
    public void settemp(float temp){
        this.temp=temp;
    }






}
