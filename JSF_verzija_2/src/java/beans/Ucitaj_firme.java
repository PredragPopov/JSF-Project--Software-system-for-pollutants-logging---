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
import klase.Firma_klasa;
/**
 *
 * @author POPOV
 */
@ManagedBean(name="ucitaj_firme",eager=true)
@SessionScoped
public class Ucitaj_firme implements Serializable{
    private ArrayList<Firma_klasa> lista=new ArrayList<Firma_klasa>();
    private Firma_klasa firmaX=new Firma_klasa();

    public ArrayList<Firma_klasa> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Firma_klasa> lista) {
        this.lista = lista;
    }

    public Firma_klasa getFirmaX() {
        return firmaX;
    }

    public void setFirmaX(Firma_klasa firmaX) {
        this.firmaX = firmaX;
    }
    
    
    
    public String ucitaj(){
        try{
            lista.clear();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM firme ");
            while(rs.next()){
                Firma_klasa firma=new Firma_klasa();
                //firma.setPIB(rs.getString("PIB").trim());
                String PIB=rs.getString("PIB").trim();
                firma.setPIB(PIB);
                
                firma.setMaticni_broj(rs.getString("maticni_broj").trim());
                firma.setNaziv(rs.getString("naziv").trim());
                firma.setDelatnost(rs.getString("delatnost").trim());
                firma.setMesto(rs.getString("mesto").trim());
                firma.setSifra_mesta(rs.getString("sifra_mesta").trim());
                firma.setPostanski_broj(rs.getString("postanski_broj").trim());
                firma.setUlica_broj(rs.getString("ulica_broj").trim());
                firma.setTelefon(rs.getString("telefon").trim());
                firma.setEmail(rs.getString("email").trim());
                firma.setOpstina(rs.getString("opstina").trim());
                firma.setSifra_opstine(rs.getString("sifra_opstine").trim());
                firma.setSifra_delatnosti(rs.getString("sifra_delatnosti").trim());
                firma.setArhiviran(rs.getBoolean("arhiviran"));
                
                lista.add(firma);
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        
        return "RR_firme";
    }
    /*
    public String ucitaj_firmu(String PIBx){
        
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getPIB()==PIBx){
                firmaX=lista.get(i);   
            }
        }
        
        return "RR_firma";
    }
    */
    public void aktivacija(String PIB,int izbor){
        String SQL="";
        if(izbor==1){ //da se aktivira
            SQL="UPDATE firme SET arhiviran=0 WHERE PIB='"+PIB.trim()+"'";
        }else if(izbor==2){ // da se arhivira
            SQL="UPDATE firme SET arhiviran=1 WHERE PIB='"+PIB.trim()+"'";
        }
        try{
            lista.clear();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate(SQL);
             }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        
        ucitaj();
    }
    private String pib;
    private String naziv;
    private String mesto;
    private ArrayList<Firma_klasa> lista_P=new ArrayList<Firma_klasa>();

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public ArrayList<Firma_klasa> getLista_P() {
        return lista_P;
    }

    public void setLista_P(ArrayList<Firma_klasa> lista_P) {
        this.lista_P = lista_P;
    }
    
    public String pretraga(int izbor){
        lista_P.clear();
        for(int i=0;i<lista.size();i++){
            if(izbor==1){
                if(lista.get(i).getPIB().equals(pib.trim())){
                    lista_P.add(lista.get(i));
                }
            }else if(izbor==2){
                if(lista.get(i).getNaziv().equals(naziv.trim())){
                    lista_P.add(lista.get(i));
                }
                
            }else if(izbor==3){
                if(lista.get(i).getMesto().equals(mesto.trim())){
                    lista_P.add(lista.get(i));
                }
            }
            
        }
        
        return "RR_rez_pretrage_firme.xhtml";
    }
    
    
}
