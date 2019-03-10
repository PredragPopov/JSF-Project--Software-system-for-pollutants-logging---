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
public class Period {
    private int ID;
    private int godina;
    private boolean zakljucan;
    
    public Period(){}

    public Period(int ID, int godina, boolean zakljucan) {
        this.ID = ID;
        this.godina = godina;
        this.zakljucan = zakljucan;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public boolean isZakljucan() {
        return zakljucan;
    }

    public void setZakljucan(boolean zakljucan) {
        this.zakljucan = zakljucan;
    }

    @Override
    public String toString() {
        return "Period{" + "ID=" + ID + ", godina=" + godina + ", zakljucan=" + zakljucan + '}';
    }

    
    
    
    
}
