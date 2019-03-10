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
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import klase.Korisnik;

/**
 *
 * @author POPOV
 */
@ManagedBean(name="a_korisnici",eager=true)
@SessionScoped
public class A_korisnici implements Serializable{
     private ArrayList<Korisnik> lista=new ArrayList<Korisnik>();
     private Korisnik novi_korisnik=new Korisnik();
    public ArrayList<Korisnik> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Korisnik> lista) {
        this.lista = lista;
    }

    public Korisnik getNovi_korisnik() {
        return novi_korisnik;
    }

    public void setNovi_korisnik(Korisnik novi_korisnik) {
        this.novi_korisnik = novi_korisnik;
    }
    
    
    
    public String ucitaj_korisnike(){
        lista.clear();
        //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("usao u funk"));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("SELECT * FROM korisnici"));
            ResultSet rs=ps.executeQuery("SELECT * FROM korisnici");
            while(rs.next()){
                //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("usao u while"));
                String username=rs.getString("username");
                boolean arhiviran=rs.getBoolean("arhiviran");
                String tip_korisnika=rs.getString("tip_korisnika");
                String firma=rs.getString("firma");
                Korisnik k=new Korisnik();
                k.setUsername(username);
                k.setArhiviran(arhiviran);
                k.setTip_korisnika(tip_korisnika);
                k.setFirma(firma);
                if(firma.equals("")){
                    k.setFirmaBool(false);
                }else{
                    k.setFirmaBool(true);
                }
                //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("ucitao korisnik "+k.toString()));
                lista.add(k);
                //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("lista: "+lista.toString()));
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        return "A_korisnici";
    }
    public void obrisi_korisnika(String username){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("DELETE FROM korisnici WHERE username='"+username.trim()+"'");
            
             }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("DELETE FROM korisnici WHERE username='"+username.trim()+"'"));
        ucitaj_korisnike();
    }
    
    public void resetuj_lozniku(String username){
        String nova_lozinka=napravi_lozinku();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("UPDATE korisnici SET password="+nova_lozinka+" WHERE username='"+username.trim()+"'");
            
             }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("DELETE FROM korisnici WHERE username='"+username.trim()+"'"));
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Nova lozinka: "+nova_lozinka));
        
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
            ResultSet rs=ps.executeQuery("SELECT * FROM firme WHERE PIB='"+novi_korisnik.getFirma().trim()+"'");
            while(rs.next()){
                naziv_firme=rs.getString("naziv");
                   
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        return naziv_firme;
    }
    
    public String napravi_novog(){
        String lozinka=napravi_lozinku();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("INSERT INTO korisnici(username,password,tip_korisnika,firma) VALUES('"+novi_korisnik.getUsername()+"','"+lozinka+"','"+novi_korisnik.getTip_korisnika()+"','"+novi_korisnik.getFirma()+"')");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Uspesno ste dodali novog korisnika"));
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Slucajno generisana lozinka: "+lozinka));
        return "uspesno";
        
    }
    private String username;
    private String tip;
    private String firma;
    private ArrayList<Korisnik> lista_P=new ArrayList<Korisnik>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public ArrayList<Korisnik> getLista_P() {
        return lista_P;
    }

    public void setLista_P(ArrayList<Korisnik> lista_P) {
        this.lista_P = lista_P;
    }
    
    
    
    public String pretraga(int izbor){
        lista_P.clear();
        for(int i=0;i<lista.size();i++){
            if(izbor==1){
                if(lista.get(i).getUsername().equals(username.trim())){
                    lista_P.add(lista.get(i));
                }
            }else if(izbor==2){
                if(lista.get(i).getTip_korisnika().equals(tip.trim())){
                    lista_P.add(lista.get(i));
                }
                
            }else if(izbor==3){
                if(lista.get(i).getFirma().equals(firma.trim())){
                    lista_P.add(lista.get(i));
                }
            }
            
        }
        
        return "A_rez_pretrage.xhtml";
    }
}
