/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.klase;

/**
 *
 * @author POPOV
 */
public class Firma_klasa {
    private String PIB;
    private String maticni_broj;
    private String naziv;
    private String delatnost;
    private String mesto;
    private String sifra_mesta;
    private String postanski_broj;
    private String ulica_broj;
    private String telefon;
    private String email;
    private String opstina;
    private String sifra_opstine;
    private String sifra_delatnosti;
    private boolean arhiviran;
    
    public Firma_klasa(){}

    public Firma_klasa(String PIB, String maticni_broj, String naziv, String delatnost, String mesto, String sifra_mesta, String postanski_broj, String ulica_broj, String telefon, String email, String opstina, String sifra_opstine, String sifra_delatnosti, boolean arhiviran) {
        this.PIB = PIB;
        this.maticni_broj = maticni_broj;
        this.naziv = naziv;
        this.delatnost = delatnost;
        this.mesto = mesto;
        this.sifra_mesta = sifra_mesta;
        this.postanski_broj = postanski_broj;
        this.ulica_broj = ulica_broj;
        this.telefon = telefon;
        this.email = email;
        this.opstina = opstina;
        this.sifra_opstine = sifra_opstine;
        this.sifra_delatnosti = sifra_delatnosti;
        this.arhiviran = arhiviran;
    }

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public String getMaticni_broj() {
        return maticni_broj;
    }

    public void setMaticni_broj(String maticni_broj) {
        this.maticni_broj = maticni_broj;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getDelatnost() {
        return delatnost;
    }

    public void setDelatnost(String delatnost) {
        this.delatnost = delatnost;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getSifra_mesta() {
        return sifra_mesta;
    }

    public void setSifra_mesta(String sifra_mesta) {
        this.sifra_mesta = sifra_mesta;
    }

    public String getPostanski_broj() {
        return postanski_broj;
    }

    public void setPostanski_broj(String postanski_broj) {
        this.postanski_broj = postanski_broj;
    }

    public String getUlica_broj() {
        return ulica_broj;
    }

    public void setUlica_broj(String ulica_broj) {
        this.ulica_broj = ulica_broj;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpstina() {
        return opstina;
    }

    public void setOpstina(String opstina) {
        this.opstina = opstina;
    }

    public String getSifra_opstine() {
        return sifra_opstine;
    }

    public void setSifra_opstine(String sifra_opstine) {
        this.sifra_opstine = sifra_opstine;
    }

    public String getSifra_delatnosti() {
        return sifra_delatnosti;
    }

    public void setSifra_delatnosti(String sifra_delatnosti) {
        this.sifra_delatnosti = sifra_delatnosti;
    }

    public boolean isArhiviran() {
        return arhiviran;
    }

    public void setArhiviran(boolean arhiviran) {
        this.arhiviran = arhiviran;
    }

    @Override
    public String toString() {
        return "Firma{" + "PIB=" + PIB + ", maticni_broj=" + maticni_broj + ", naziv=" + naziv + ", delatnost=" + delatnost + ", mesto=" + mesto + ", sifra_mesta=" + sifra_mesta + ", postanski_broj=" + postanski_broj + ", ulica_broj=" + ulica_broj + ", telefon=" + telefon + ", email=" + email + ", opstina=" + opstina + ", sifra_opstine=" + sifra_opstine + ", sifra_delatnosti=" + sifra_delatnosti + ", arhiviran=" + arhiviran + '}';
    }
    
    
}
