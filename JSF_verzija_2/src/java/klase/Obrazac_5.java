/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klase;

import java.sql.Date;

/**
 *
 * @author POPOV
 */

public class Obrazac_5 {
    private int ID;
    private String PIB;
    private int period;
    private boolean predato;
    private String mesto_nastanka;
    private String naziv;
    private String vrsta;
    private String opis;
    private String kategorija;
    private String karakter;
    private int izvestaj_broj;
    private String izvestaj_datum;
    private String fizicko_stanje;
    private String transport;
    private String odrediste;
    private String napomena;
    
    public Obrazac_5(){}

    public Obrazac_5(int ID, String PIB, int period, boolean predato, String mesto_nastanka, String naziv, String vrsta, String opis, String kategorija, String karakter, int izvestaj_broj, String izvestaj_datum, String fizicko_stanje, String transport, String odrediste, String napomena) {
        this.ID = ID;
        this.PIB = PIB;
        this.period = period;
        this.predato = predato;
        this.mesto_nastanka = mesto_nastanka;
        this.naziv = naziv;
        this.vrsta = vrsta;
        this.opis = opis;
        this.kategorija = kategorija;
        this.karakter = karakter;
        this.izvestaj_broj = izvestaj_broj;
        this.izvestaj_datum = izvestaj_datum;
        this.fizicko_stanje = fizicko_stanje;
        this.transport = transport;
        this.odrediste = odrediste;
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

    public String getMesto_nastanka() {
        return mesto_nastanka;
    }

    public void setMesto_nastanka(String mesto_nastanka) {
        this.mesto_nastanka = mesto_nastanka;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getKarakter() {
        return karakter;
    }

    public void setKarakter(String karakter) {
        this.karakter = karakter;
    }

    public int getIzvestaj_broj() {
        return izvestaj_broj;
    }

    public void setIzvestaj_broj(int izvestaj_broj) {
        this.izvestaj_broj = izvestaj_broj;
    }

    public String getIzvestaj_datum() {
        return izvestaj_datum;
    }

    public void setIzvestaj_datum(String izvestaj_datum) {
        this.izvestaj_datum = izvestaj_datum;
    }

   

    public String getFizicko_stanje() {
        return fizicko_stanje;
    }

    public void setFizicko_stanje(String fizicko_stanje) {
        this.fizicko_stanje = fizicko_stanje;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getOdrediste() {
        return odrediste;
    }

    public void setOdrediste(String odrediste) {
        this.odrediste = odrediste;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    @Override
    public String toString() {
        return "Obrazac_5{" + "ID=" + ID + ", PIB=" + PIB + ", period=" + period + ", predato=" + predato + ", mesto_nastanka=" + mesto_nastanka + ", naziv=" + naziv + ", vrsta=" + vrsta + ", opis=" + opis + ", kategorija=" + kategorija + ", karakter=" + karakter + ", izvestaj_broj=" + izvestaj_broj + ", izvestaj_datum=" + izvestaj_datum + ", fizicko_stanje=" + fizicko_stanje + ", transport=" + transport + ", odrediste=" + odrediste + ", napomena=" + napomena + '}';
    }
    
    
}
