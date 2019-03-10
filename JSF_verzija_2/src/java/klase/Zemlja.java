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
public class Zemlja {
    private int ID;
    private int ID_obrazac_4;
    private String naziv;
    private int CAS;
    private double koncetracija;
    private String nacin_odredjivanja;
    private String metod_odredjivanja;
    
    public Zemlja (){}

    public Zemlja(int ID, int ID_obrazac_4, String naziv, int CAS, double koncetracija, String nacin_odredjivanja, String metod_odredjivanja) {
        this.ID = ID;
        this.ID_obrazac_4 = ID_obrazac_4;
        this.naziv = naziv;
        this.CAS = CAS;
        this.koncetracija = koncetracija;
        this.nacin_odredjivanja = nacin_odredjivanja;
        this.metod_odredjivanja = metod_odredjivanja;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_obrazac_4() {
        return ID_obrazac_4;
    }

    public void setID_obrazac_4(int ID_obrazac_4) {
        this.ID_obrazac_4 = ID_obrazac_4;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getCAS() {
        return CAS;
    }

    public void setCAS(int CAS) {
        this.CAS = CAS;
    }

    public double getKoncetracija() {
        return koncetracija;
    }

    public void setKoncetracija(double koncetracija) {
        this.koncetracija = koncetracija;
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
        return  "ID=" + ID + ", ID_obrazac_4=" + ID_obrazac_4 + ", naziv=" + naziv + ", CAS=" + CAS + ", koncetracija=" + koncetracija + ", nacin_odredjivanja=" + nacin_odredjivanja + ", metod_odredjivanja=" + metod_odredjivanja ;
    }
    
    
}
