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
public class Obrazac_3 {
    private int ID;
    private String PIB;
    private int period;
    private boolean predato;
    private String naziv_ispusta;
    private int broj_ispusta;
    private String rezim_rada;
    private double kapacitet;
    private String vremenski_period;
    private double ukupna_kolicina;
    private String mehanicko;
    private String hemisko;
    private String biolosko;
    private String izmena_toplote;
    private String napomena;
    private ArrayList<Voda> materije_vode=new ArrayList<Voda>();
    
    public Obrazac_3(){}

    public Obrazac_3(int ID, String PIB, int period, boolean predato, String naziv_ispusta, int broj_ispusta, String rezim_rada, double kapacitet, String vremenski_period, double ukupna_kolicina, String mehanicko, String hemisko, String biolosko, String izmena_toplote, String napomena) {
        this.ID = ID;
        this.PIB = PIB;
        this.period = period;
        this.predato = predato;
        this.naziv_ispusta = naziv_ispusta;
        this.broj_ispusta = broj_ispusta;
        this.rezim_rada = rezim_rada;
        this.kapacitet = kapacitet;
        this.vremenski_period = vremenski_period;
        this.ukupna_kolicina = ukupna_kolicina;
        this.mehanicko = mehanicko;
        this.hemisko = hemisko;
        this.biolosko = biolosko;
        this.izmena_toplote = izmena_toplote;
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

    public String getNaziv_ispusta() {
        return naziv_ispusta;
    }

    public void setNaziv_ispusta(String naziv_ispusta) {
        this.naziv_ispusta = naziv_ispusta;
    }

    public int getBroj_ispusta() {
        return broj_ispusta;
    }

    public void setBroj_ispusta(int broj_ispusta) {
        this.broj_ispusta = broj_ispusta;
    }

    public String getRezim_rada() {
        return rezim_rada;
    }

    public void setRezim_rada(String rezim_rada) {
        this.rezim_rada = rezim_rada;
    }

    public double getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(double kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getVremenski_period() {
        return vremenski_period;
    }

    public void setVremenski_period(String vremenski_period) {
        this.vremenski_period = vremenski_period;
    }

    public double getUkupna_kolicina() {
        return ukupna_kolicina;
    }

    public void setUkupna_kolicina(double ukupna_kolicina) {
        this.ukupna_kolicina = ukupna_kolicina;
    }

    public String getMehanicko() {
        return mehanicko;
    }

    public void setMehanicko(String mehanicko) {
        this.mehanicko = mehanicko;
    }

    public String getHemisko() {
        return hemisko;
    }

    public void setHemisko(String hemisko) {
        this.hemisko = hemisko;
    }

    public String getBiolosko() {
        return biolosko;
    }

    public void setBiolosko(String biolosko) {
        this.biolosko = biolosko;
    }

    public String getIzmena_toplote() {
        return izmena_toplote;
    }

    public void setIzmena_toplote(String izmena_toplote) {
        this.izmena_toplote = izmena_toplote;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public ArrayList<Voda> getMaterije_vode() {
        return materije_vode;
    }

    public void setMaterije_vode(ArrayList<Voda> materije_vode) {
        this.materije_vode = materije_vode;
    }

    @Override
    public String toString() {
        return "Obrazac_3{" + "ID=" + ID + ", PIB=" + PIB + ", period=" + period + ", predato=" + predato + ", naziv_ispusta=" + naziv_ispusta + ", broj_ispusta=" + broj_ispusta + ", rezim_rada=" + rezim_rada + ", kapacitet=" + kapacitet + ", vremenski_period=" + vremenski_period + ", ukupna_kolicina=" + ukupna_kolicina + ", mehanicko=" + mehanicko + ", hemisko=" + hemisko + ", biolosko=" + biolosko + ", izmena_toplote=" + izmena_toplote + ", napomena=" + napomena + ", materije_vode=" + materije_vode + '}';
    }
    
    
}
