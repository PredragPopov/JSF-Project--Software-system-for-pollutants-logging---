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
public class Sifre {
    private int ID;
    private int ID_sifarnika;
    private String sifra;
    private String naziv;
    
    public Sifre(){}

    public Sifre(int ID, int ID_sifarnika, String sifra, String naziv) {
        this.ID = ID;
        this.ID_sifarnika = ID_sifarnika;
        this.sifra = sifra;
        this.naziv = naziv;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_sifarnika() {
        return ID_sifarnika;
    }

    public void setID_sifarnika(int ID_sifarnika) {
        this.ID_sifarnika = ID_sifarnika;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Sifre{" + "ID=" + ID + ", ID_sifarnika=" + ID_sifarnika + ", sifra=" + sifra + ", naziv=" + naziv + '}';
    }
    
    
}
