/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klase;

/**
 *
 * @author POPOV
 */
public class Obrazac_1 {
    private int ID;
    private String PIB;
    private int period;
    private boolean predato;
    private String mesto;
    private String opstina;
    private String ol_ime_prezime;
    private String ol_funk;
    private String ol_tel;
    private String k_ime_prezime;
    private String k_funk;
    private String k_tel;
    private String k_email;
    
    public Obrazac_1(){}

    public Obrazac_1(int ID, String PIB, int period, boolean predato, String mesto, String opstina, String ol_ime_prezime, String ol_funk, String ol_tel, String k_ime_prezime, String k_funk, String k_tel, String k_email) {
        this.ID = ID;
        this.PIB = PIB;
        this.period = period;
        this.predato = predato;
        this.mesto = mesto;
        this.opstina = opstina;
        this.ol_ime_prezime = ol_ime_prezime;
        this.ol_funk = ol_funk;
        this.ol_tel = ol_tel;
        this.k_ime_prezime = k_ime_prezime;
        this.k_funk = k_funk;
        this.k_tel = k_tel;
        this.k_email = k_email;
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

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getOpstina() {
        return opstina;
    }

    public void setOpstina(String opstina) {
        this.opstina = opstina;
    }

    public String getOl_ime_prezime() {
        return ol_ime_prezime;
    }

    public void setOl_ime_prezime(String ol_ime_prezime) {
        this.ol_ime_prezime = ol_ime_prezime;
    }

    public String getOl_funk() {
        return ol_funk;
    }

    public void setOl_funk(String ol_funk) {
        this.ol_funk = ol_funk;
    }

    public String getOl_tel() {
        return ol_tel;
    }

    public void setOl_tel(String ol_tel) {
        this.ol_tel = ol_tel;
    }

    public String getK_ime_prezime() {
        return k_ime_prezime;
    }

    public void setK_ime_prezime(String k_ime_prezime) {
        this.k_ime_prezime = k_ime_prezime;
    }

    public String getK_funk() {
        return k_funk;
    }

    public void setK_funk(String k_funk) {
        this.k_funk = k_funk;
    }

    public String getK_tel() {
        return k_tel;
    }

    public void setK_tel(String k_tel) {
        this.k_tel = k_tel;
    }

    public String getK_email() {
        return k_email;
    }

    public void setK_email(String k_email) {
        this.k_email = k_email;
    }

    @Override
    public String toString() {
        return "Obrazac_1{" + "ID=" + ID + ", PIB=" + PIB + ", period=" + period + ", predato=" + predato + ", mesto=" + mesto + ", opstina=" + opstina + ", ol_ime_prezime=" + ol_ime_prezime + ", ol_funk=" + ol_funk + ", ol_tel=" + ol_tel + ", k_ime_prezime=" + k_ime_prezime + ", k_funk=" + k_funk + ", k_tel=" + k_tel + ", k_email=" + k_email + '}';
    }
    
    
}
