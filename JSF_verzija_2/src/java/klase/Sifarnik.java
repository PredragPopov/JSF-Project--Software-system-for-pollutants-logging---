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
public class Sifarnik {
    private int ID;
    private String naziv;
    
    public Sifarnik(){}

    public Sifarnik(int ID, String naziv) {
        this.ID = ID;
        this.naziv = naziv;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Sifarnik{" + "ID=" + ID + ", naziv=" + naziv + '}';
    }
    
    
}
