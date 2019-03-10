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
public class Firma_Obrasci {
    private Firma_klasa firma;
    private Obrazac_1 obr_1;
    private ArrayList<Obrazac_2> lista_obr_2;
    private ArrayList<Obrazac_3> lista_obr_3;
    private ArrayList<Obrazac_4> lista_obr_4;
    private ArrayList<Obrazac_5> lista_obr_5;
    
    public Firma_Obrasci(){}

    public Firma_Obrasci(Firma_klasa firma, Obrazac_1 obr_1, ArrayList<Obrazac_2> lista_obr_2, ArrayList<Obrazac_3> lista_obr_3, ArrayList<Obrazac_4> lista_obr_4, ArrayList<Obrazac_5> lista_obr_5) {
        this.firma = firma;
        this.obr_1 = obr_1;
        this.lista_obr_2 = lista_obr_2;
        this.lista_obr_3 = lista_obr_3;
        this.lista_obr_4 = lista_obr_4;
        this.lista_obr_5 = lista_obr_5;
    }

    

    public Firma_klasa getFirma() {
        return firma;
    }

    public void setFirma(Firma_klasa firma) {
        this.firma = firma;
    }

    public Obrazac_1 getObr_1() {
        return obr_1;
    }

    public void setObr_1(Obrazac_1 obr_1) {
        this.obr_1 = obr_1;
    }

    

    public ArrayList<Obrazac_2> getLista_obr_2() {
        return lista_obr_2;
    }

    public void setLista_obr_2(ArrayList<Obrazac_2> lista_obr_2) {
        this.lista_obr_2 = lista_obr_2;
    }

    public ArrayList<Obrazac_3> getLista_obr_3() {
        return lista_obr_3;
    }

    public void setLista_obr_3(ArrayList<Obrazac_3> lista_obr_3) {
        this.lista_obr_3 = lista_obr_3;
    }

    public ArrayList<Obrazac_4> getLista_obr_4() {
        return lista_obr_4;
    }

    public void setLista_obr_4(ArrayList<Obrazac_4> lista_obr_4) {
        this.lista_obr_4 = lista_obr_4;
    }

    public ArrayList<Obrazac_5> getLista_obr_5() {
        return lista_obr_5;
    }

    public void setLista_obr_5(ArrayList<Obrazac_5> lista_obr_5) {
        this.lista_obr_5 = lista_obr_5;
    }

    @Override
    public String toString() {
        return "Firma_Obrasci{" + "firma=" + firma + ", obr_1=" + obr_1 + "\n, lista_obr_2=" + lista_obr_2 + ", lista_obr_3=" + lista_obr_3 + ", lista_obr_4=" + lista_obr_4 + ", lista_obr_5=" + lista_obr_5 + "}\n";
    }

    
    
    
    
}
