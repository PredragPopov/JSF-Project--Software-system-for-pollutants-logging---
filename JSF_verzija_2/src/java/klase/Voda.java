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
public class Voda {
    private int ID;
    private int ID_obrazac_3;
    private String naziv;
    private String CAS;
    private double SGIV;
    private double redovne_kol;
    private double extremne_kol;
    private String nacin_odredjivanja;
    private String metod_odredjivanja;
    
    public Voda(){};

    public Voda(int ID, int ID_obrazac_3, String naziv, String CAS, double SGIV, double redovne_kol, double extremne_kol, String nacin_odredjivanja, String metod_odredjivanja) {
        this.ID = ID;
        this.ID_obrazac_3 = ID_obrazac_3;
        this.naziv = naziv;
        this.CAS = CAS;
        this.SGIV = SGIV;
        this.redovne_kol = redovne_kol;
        this.extremne_kol = extremne_kol;
        this.nacin_odredjivanja = nacin_odredjivanja;
        this.metod_odredjivanja = metod_odredjivanja;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_obrazac_3() {
        return ID_obrazac_3;
    }

    public void setID_obrazac_3(int ID_obrazac_3) {
        this.ID_obrazac_3 = ID_obrazac_3;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getCAS() {
        return CAS;
    }

    public void setCAS(String CAS) {
        this.CAS = CAS;
    }

    public double getSGIV() {
        return SGIV;
    }

    public void setSGIV(double SGIV) {
        this.SGIV = SGIV;
    }

    public double getRedovne_kol() {
        return redovne_kol;
    }

    public void setRedovne_kol(double redovne_kol) {
        this.redovne_kol = redovne_kol;
    }

    public double getExtremne_kol() {
        return extremne_kol;
    }

    public void setExtremne_kol(double extremne_kol) {
        this.extremne_kol = extremne_kol;
    }

    public String getNacin_odredjivanja() {
        return nacin_odredjivanja;
    }

    public void setNacin_odredjivanja(String nacin_odredjivanja) {
        this.nacin_odredjivanja = nacin_odredjivanja;
    }

    public String getMetod_odredjivanja() {
        return metod_odredjivanja;
    }

    public void setMetod_odredjivanja(String metod_odredjivanja) {
        this.metod_odredjivanja = metod_odredjivanja;
    }

    @Override
    public String toString() {
        return "ID=" + ID + ", ID_obrazac_3=" + ID_obrazac_3 + ", naziv=" + naziv + ", CAS=" + CAS + ", SGIV=" + SGIV + ", redovne_kol=" + redovne_kol + ", extremne_kol=" + extremne_kol + ", nacin_odredjivanja=" + nacin_odredjivanja + ", metod_odredjivanja=" + metod_odredjivanja ;
    }
    
    
}
