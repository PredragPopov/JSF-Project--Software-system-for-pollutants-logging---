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
public class Obrazac_2 {
    private int ID;
    private String PIB;
    private int period;
    private boolean predato;
    private String naziv_izvora;
    private int broj_izvora;
    private String vrsta_ivora;
    private double nadmorska_visina;
    private double visina_izvora;
    private double precnik;
    private double iskoriscenost;
    private double toplotna_snaga;
    private double srednja_god_temp;
    private double brzina;
    private double protok;
    private String rezim_rada;
    private int dana_godisnje;
    private double sati_dnevno;
    private String napomena;
    private ArrayList<Vazduh> materije_vazduh;
    
    public Obrazac_2(){}

    public Obrazac_2(int ID, String PIB, int period, boolean predato, String naziv_izvora, int broj_izvora, String vrsta_ivora, double nadmorska_visina, double visina_izvora, double precnik, double iskoriscenost, double toplotna_snaga, double srednja_god_temp, double brzina, double protok, String rezim_rada, int dana_godisnje, double sati_dnevno, String napomena, ArrayList<Vazduh> materije_vazduh) {
        this.ID = ID;
        this.PIB = PIB;
        this.period = period;
        this.predato = predato;
        this.naziv_izvora = naziv_izvora;
        this.broj_izvora = broj_izvora;
        this.vrsta_ivora = vrsta_ivora;
        this.nadmorska_visina = nadmorska_visina;
        this.visina_izvora = visina_izvora;
        this.precnik = precnik;
        this.iskoriscenost = iskoriscenost;
        this.toplotna_snaga = toplotna_snaga;
        this.srednja_god_temp = srednja_god_temp;
        this.brzina = brzina;
        this.protok = protok;
        this.rezim_rada = rezim_rada;
        this.dana_godisnje = dana_godisnje;
        this.sati_dnevno = sati_dnevno;
        this.napomena = napomena;
        this.materije_vazduh = materije_vazduh;
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

    public String getNaziv_izvora() {
        return naziv_izvora;
    }

    public void setNaziv_izvora(String naziv_izvora) {
        this.naziv_izvora = naziv_izvora;
    }

    public int getBroj_izvora() {
        return broj_izvora;
    }

    public void setBroj_izvora(int broj_izvora) {
        this.broj_izvora = broj_izvora;
    }

    public String getVrsta_ivora() {
        return vrsta_ivora;
    }

    public void setVrsta_ivora(String vrsta_ivora) {
        this.vrsta_ivora = vrsta_ivora;
    }

    public double getNadmorska_visina() {
        return nadmorska_visina;
    }

    public void setNadmorska_visina(double nadmorska_visina) {
        this.nadmorska_visina = nadmorska_visina;
    }

    public double getVisina_izvora() {
        return visina_izvora;
    }

    public void setVisina_izvora(double visina_izvora) {
        this.visina_izvora = visina_izvora;
    }

    public double getPrecnik() {
        return precnik;
    }

    public void setPrecnik(double precnik) {
        this.precnik = precnik;
    }

    public double getIskoriscenost() {
        return iskoriscenost;
    }

    public void setIskoriscenost(double iskoriscenost) {
        this.iskoriscenost = iskoriscenost;
    }

    public double getToplotna_snaga() {
        return toplotna_snaga;
    }

    public void setToplotna_snaga(double toplotna_snaga) {
        this.toplotna_snaga = toplotna_snaga;
    }

    public double getSrednja_god_temp() {
        return srednja_god_temp;
    }

    public void setSrednja_god_temp(double srednja_god_temp) {
        this.srednja_god_temp = srednja_god_temp;
    }

    public double getBrzina() {
        return brzina;
    }

    public void setBrzina(double brzina) {
        this.brzina = brzina;
    }

    public double getProtok() {
        return protok;
    }

    public void setProtok(double protok) {
        this.protok = protok;
    }

    public String getRezim_rada() {
        return rezim_rada;
    }

    public void setRezim_rada(String rezim_rada) {
        this.rezim_rada = rezim_rada;
    }

    public int getDana_godisnje() {
        return dana_godisnje;
    }

    public void setDana_godisnje(int dana_godisnje) {
        this.dana_godisnje = dana_godisnje;
    }

    public double getSati_dnevno() {
        return sati_dnevno;
    }

    public void setSati_dnevno(double sati_dnevno) {
        this.sati_dnevno = sati_dnevno;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public ArrayList<Vazduh> getMaterije_vazduh() {
        return materije_vazduh;
    }

    public void setMaterije_vazduh(ArrayList<Vazduh> materije_vazduh) {
        this.materije_vazduh = materije_vazduh;
    }

    @Override
    public String toString() {
        return "Obrazac_2{" + "ID=" + ID + ", PIB=" + PIB + ", period=" + period + ", predato=" + predato + ", naziv_izvora=" + naziv_izvora + ", broj_izvora=" + broj_izvora + ", vrsta_ivora=" + vrsta_ivora + ", nadmorska_visina=" + nadmorska_visina + ", visina_izvora=" + visina_izvora + ", precnik=" + precnik + ", iskoriscenost=" + iskoriscenost + ", toplotna_snaga=" + toplotna_snaga + ", srednja_god_temp=" + srednja_god_temp + ", brzina=" + brzina + ", protok=" + protok + ", rezim_rada=" + rezim_rada + ", dana_godisnje=" + dana_godisnje + ", sati_dnevno=" + sati_dnevno + ", napomena=" + napomena + ", materije_vazduh=" + materije_vazduh + '}';
    }
    
}
