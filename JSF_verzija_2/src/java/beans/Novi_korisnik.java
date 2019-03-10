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
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author POPOV
 */
@ManagedBean(name="novi_korisnik",eager=true)
@RequestScoped
public class Novi_korisnik implements Serializable{
    private String username;
    private String tip_korisnika;
    private String firma;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTip_korisnika() {
        return tip_korisnika;
    }

    public void setTip_korisnika(String tip_korisnika) {
        this.tip_korisnika = tip_korisnika;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    
    
    
    public String dodaj_ref_firme(String PIB){
        
        String lozinka=napravi_lozinku();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("username: "+username));
            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("INSERT INTO korisnici(username,password,tip_korisnika,firma) VALUES('"+username+"','"+lozinka+"','referent_firme','"+PIB+"')"));
            
            ps.executeUpdate("INSERT INTO korisnici(username,password,tip_korisnika,firma) VALUES('"+username+"','"+lozinka+"','referent_firme','"+PIB+"')");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        password=lozinka;
        //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Slucajno generisana lozinka: "+lozinka));
        return "uspesno";
    }
    
    public String napravi_lozinku(){
        String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";
         Random random = new Random();
      String pw = "";
      for (int i=0; i<15; i++)
      {
          int index = (int)(random.nextDouble()*letters.length());
          pw += letters.substring(index, index+1);
      }
      return pw;
    }
    
    public String podaci_firme(){
        String naziv_firme="";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM firme WHERE PIB='"+firma.trim()+"'");
            while(rs.next()){
                naziv_firme=rs.getString("naziv");
                   
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        return naziv_firme;
    }
    
    public String novi_od_opstine(){
        String lozinka=napravi_lozinku();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("INSERT INTO korisnici(username,password,tip_korisnika,firma) VALUES('"+username+"','"+lozinka+"','"+tip_korisnika+"','"+firma+"')");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Uspesno ste dodali novog korisnika"));
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Slucajno generisana lozinka: "+lozinka));
        return "uspesno";
        
    }
}
