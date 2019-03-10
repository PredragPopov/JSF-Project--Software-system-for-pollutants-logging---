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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import klase.Sifarnik;
import klase.Sifre;

/**
 *
 * @author POPOV
 */
@ManagedBean(name="ucitajSifre",eager=true)
@SessionScoped
public class UcitajSifre implements Serializable{
    private ArrayList<Sifre> lista=new ArrayList<Sifre>();

    public ArrayList<Sifre> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Sifre> lista) {
        this.lista = lista;
    }
    
    
    
    public String ucitajS(int IDx){
        lista.clear();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM sifre WHERE ID_sifarnika='"+IDx+"'");
            while(rs.next()){
                int ID=rs.getInt("ID");
                String naziv=rs.getString("naziv");
                String sifra=rs.getString("sifra");
                Sifre s=new Sifre();
                s.setID(ID);
                s.setID_sifarnika(IDx);
                s.setNaziv(naziv);
                s.setSifra(sifra);
                lista.add(s);
                   
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        return "sifre";
    }
    
}
