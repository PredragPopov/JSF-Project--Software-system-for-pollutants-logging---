/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import klase.Period;

/**
 *
 * @author POPOV
 */
@ManagedBean(name="ucitaj_periode",eager=true)
@SessionScoped
public class Ucitaj_periode implements Serializable{
    private ArrayList<Period> lista_perioda=new ArrayList<Period>();
    
    public String ucitaj(){
        lista_perioda.clear();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM period");
            while(rs.next()){
                
                int godina=rs.getInt("godina");
                boolean zakljucan=rs.getBoolean("zakljucan");
                Period p=new Period();
                p.setGodina(godina);
                p.setZakljucan(zakljucan);
                lista_perioda.add(p);
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        return "periodi";
    }

    public ArrayList<Period> getLista_perioda() {
        return lista_perioda;
    }

    public void setLista_perioda(ArrayList<Period> lista_perioda) {
        this.lista_perioda = lista_perioda;
    }
    
   
}
