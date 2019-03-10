/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klase;

import java.util.ArrayList;

/**
 *
 * @author POPOV
 */
public class Obrazac_4 {
    private int ID;
    private String PIB;
    private int period;
    private boolean predato;
    private String naziv_lokacije;
    private String vrsta_otpada;
    private double kolicina_godisnje;
    private String nacin_odlaganja;
    private String napomena;
    private ArrayList<Zemlja> materije_tlo=new ArrayList<Zemlja>();
    
    public Obrazac_4(){}

    public Obrazac_4(int ID, String PIB, int period, boolean predato, String naziv_lokacije, String vrsta_otpada, double kolicina_godisnje, String nacin_odlaganja, String napomena) {
        this.ID = ID;
        this.PIB = PIB;
        this.period = period;
        this.predato = predato;
        this.naziv_lokacije = naziv_lokacije;
        this.vrsta_otpada = vrsta_otpada;
        this.kolicina_godisnje = kolicina_godisnje;
        this.nacin_odlaganja = nacin_odlaganja;
        this.napomena = napomena;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public boolean isPredato() {
        return predato;
    }

    public void setPredato(boolean predato) {
        this.predato = predato;
    }

    public String getNaziv_lokacije() {
        return naziv_lokacije;
    }

    public void setNaziv_lokacije(String naziv_lokacije) {
        this.naziv_lokacije = naziv_lokacije;
    }

    public String getVrsta_otpada() {
        return vrsta_otpada;
    }

    public void setVrsta_otpada(String vrsta_otpada) {
        this.vrsta_otpada = vrsta_otpada;
    }

    public double getKolicina_godisnje() {
        return kolicina_godisnje;
    }

    public void setKolicina_godisnje(double kolicina_godisnje) {
        this.kolicina_godisnje = kolicina_godisnje;
    }

    public String getNacin_odlaganja() {
        return nacin_odlaganja;
    }

    public void setNacin_odlaganja(String nacin_odlaganja) {
        this.nacin_odlaganja = nacin_odlaganja;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public ArrayList<Zemlja> getMaterije_tlo() {
        return materije_tlo;
    }

    public void setMaterije_tlo(ArrayList<Zemlja> materije_tlo) {
        this.materije_tlo = materije_tlo;
    }

    @Override
    public String toString() {
        return "Obrazac_4{" + "ID=" + ID + ", PIB=" + PIB + ", period=" + period + ", predato=" + predato + ", naziv_lokacije=" + naziv_lokacije + ", vrsta_otpada=" + vrsta_otpada + ", kolicina_godisnje=" + kolicina_godisnje + ", nacin_odlaganja=" + nacin_odlaganja + ", napomena=" + napomena + ", materije_tlo=" + materije_tlo + '}';
    }
    
    
}
