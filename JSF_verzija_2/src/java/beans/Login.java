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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import klase.Korisnik;

/**
 *
 * @author POPOV
 */


@ManagedBean(name="logIN",eager=true)
@SessionScoped
public class Login implements Serializable{
    
    private String username;
    private String password;
    private boolean arhiviran;
    private String tip_korisnika;
    private String firmaPIB;
    private boolean firmaArh;
    
    private String lozinka_stara;
    private String lozinka_nova;
    
    private Korisnik korisnik=new Korisnik();
    
    private Firma firma=new Firma();
    
    private boolean r_firme=false;
    private boolean admin=false;
    
    public String uloguj(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM korisnici WHERE username='"+username+"' AND password='"+password+"' AND arhiviran=0");
            while(rs.next()){
                
                String tip=rs.getString("tip_korisnika");
                tip_korisnika=tip.trim();
                
                korisnik.setUsername(username);
                korisnik.setTip_korisnika(tip_korisnika);
                korisnik.setFirma(rs.getString("firma"));
                if(tip_korisnika.equals("administrator")){
                    admin=true;
                }
                session.setAttribute("user", korisnik);
                if(tip_korisnika.equals("referent_firme")){
                    r_firme=true;
                    firmaPIB=rs.getString("firma").trim();
                    
                    firmaArh=proveraFirme(firmaPIB);
                    if(firmaArh==true){
                        return tip_korisnika;
                    }else{
                        return "zabranjeno";
                    }
                }else{
                    r_firme=false;
                    return tip_korisnika;
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        return "greska";
    }

    public boolean proveraFirme(String firmaX){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM firme WHERE PIB='"+firmaX+"' AND arhiviran=0");
            while(rs.next()){
                
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
                
                
                return true;
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        return false;
    }
    
    public String promena_lozinke(){
        
        if(lozinka_stara.equals(lozinka_nova)){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("UPDATE korisnici SET password='"+lozinka_nova+"' WHERE username='"+username+"'");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        return "index";
        }else{
            return "greska";
        }
    }
    
    public String odjavi_se(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        return "index";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isArhiviran() {
        return arhiviran;
    }

    public void setArhiviran(boolean arhiviran) {
        this.arhiviran = arhiviran;
    }

    public String getTip_korisnika() {
        return tip_korisnika;
    }

    public void setTip_korisnika(String tip_korisnika) {
        this.tip_korisnika = tip_korisnika;
    }

    public String getFirmaPIB() {
        return firmaPIB;
    }

    public void setFirmaPIB(String firmaPIB) {
        this.firmaPIB = firmaPIB;
    }

    public boolean isFirmaArh() {
        return firmaArh;
    }

    public void setFirmaArh(boolean firmaArh) {
        this.firmaArh = firmaArh;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public String getLozinka_stara() {
        return lozinka_stara;
    }

    public void setLozinka_stara(String lozinka_stara) {
        this.lozinka_stara = lozinka_stara;
    }

    public String getLozinka_nova() {
        return lozinka_nova;
    }

    public void setLozinka_nova(String lozinka_nova) {
        this.lozinka_nova = lozinka_nova;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public boolean isR_firme() {
        return r_firme;
    }

    public void setR_firme(boolean r_firme) {
        this.r_firme = r_firme;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    
    
    
    
}
