/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import klase.Sifarnik;

/**
 *
 * @author POPOV
 */
@ManagedBean(name="sifarnici",eager=true)
@SessionScoped
public class Sifarnici implements Serializable{
    private ArrayList<Sifarnik> lista_s=new ArrayList<Sifarnik>();

    public ArrayList<Sifarnik> getLista_s() {
        return lista_s;
    }

    public void setLista_s(ArrayList<Sifarnik> lista_s) {
        this.lista_s = lista_s;
    }
    
    public String ucitaj(){
        lista_s.clear();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM sifarnici");
            while(rs.next()){
                int ID=rs.getInt("ID");
                String naziv=rs.getString("naziv");
                Sifarnik s=new Sifarnik();
                s.setID(ID);
                s.setNaziv(naziv);
                lista_s.add(s);
                   
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        return "sifarnici";
    }      
    
}
