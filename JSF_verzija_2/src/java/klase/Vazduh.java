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
public class Vazduh {
    private int ID;
    private int ID_obrazac_2;
    private String naziv;
    private double SGIV;
    private double EKN;
    private double EKE;
    private String nacin_odredjivanja;
    private String metod_odredjivanja;
    
    public Vazduh(){}

    public Vazduh(int ID, int ID_obrazac_2, String naziv, double SGIV, double EKN, double EKE, String naci_odredjivanja, String metod_odredjivanja) {
        this.ID = ID;
        this.ID_obrazac_2 = ID_obrazac_2;
        this.naziv = naziv;
        this.SGIV = SGIV;
        this.EKN = EKN;
        this.EKE = EKE;
        this.nacin_odredjivanja = naci_odredjivanja;
        this.metod_odredjivanja = metod_odredjivanja;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_obrazac_2() {
        return ID_obrazac_2;
    }

    public void setID_obrazac_2(int ID_obrazac_2) {
        this.ID_obrazac_2 = ID_obrazac_2;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getSGIV() {
        return SGIV;
    }

    public void setSGIV(double SGIV) {
        this.SGIV = SGIV;
    }

    public double getEKN() {
        return EKN;
    }

    public void setEKN(double EKN) {
        this.EKN = EKN;
    }

    public double getEKE() {
        return EKE;
    }

    public void setEKE(double EKE) {
        this.EKE = EKE;
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
        return  "ID=" + ID + ", ID_obrazac_2=" + ID_obrazac_2 + ", naziv=" + naziv + ", SGIV=" + SGIV + ", EKN=" + EKN + ", EKE=" + EKE + ", naci_odredjivanja=" + nacin_odredjivanja + ", metod_odredjivanja=" + metod_odredjivanja ;
    }
    
}
