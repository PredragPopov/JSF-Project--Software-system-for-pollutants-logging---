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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import klase.Firma_klasa;

/**
 *
 * @author POPOV
 */
@ManagedBean(name="rr_firma",eager=true)
@RequestScoped
public class RR_firma implements Serializable{
    private Firma_klasa firma=new Firma_klasa();

    public Firma_klasa getFirma() {
        return firma;
    }

    public void setFirma(Firma_klasa firma) {
        this.firma = firma;
    }
    public String ucitaj(String PIB){
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM firme WHERE PIB='"+PIB+"'");
            while(rs.next()){
                
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
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        return "RR_firma_2";
    }
}
