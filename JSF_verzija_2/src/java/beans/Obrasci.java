/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import klase.*;


/**
 *
 * @author POPOV
 */
@ManagedBean(name="obrasci",eager=true)
@SessionScoped
public class Obrasci implements Serializable{
    
    private int period;
    private String PIB;
    private Obrazac_1 obr1=new Obrazac_1();
    private ArrayList<Obrazac_2> lista_obr2=new ArrayList<Obrazac_2>();
    private Obrazac_2 obr2=new Obrazac_2();
    private Obrazac_2 obr2_new=new Obrazac_2();
    
   private ArrayList<Obrazac_3> lista_obr3=new ArrayList<Obrazac_3>();
   private Obrazac_3 obr3=new Obrazac_3();
   private Obrazac_3 obr3_new=new Obrazac_3();
   
   private ArrayList<Obrazac_4> lista_obr4=new ArrayList<Obrazac_4>();
   private Obrazac_4 obr4=new Obrazac_4();
   private Obrazac_4 obr4_new=new Obrazac_4();
   
   private ArrayList<Obrazac_5> lista_obr5=new ArrayList<Obrazac_5>();
   private Obrazac_5 obr5=new Obrazac_5();
   private Obrazac_5 obr5_new=new Obrazac_5();
    
   private ArrayList<Period> lista_perioda=new ArrayList<Period>();

    public ArrayList<Period> getLista_perioda() {
        return lista_perioda;
    }

    public void setLista_perioda(ArrayList<Period> lista_perioda) {
        this.lista_perioda = lista_perioda;
    }
   
   
    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Obrazac_1 getObr1() {
        return obr1;
    }

    public void setObr1(Obrazac_1 obr1) {
        this.obr1 = obr1;
    }

    public ArrayList<Obrazac_2> getLista_obr2() {
        return lista_obr2;
    }

    public void setLista_obr2(ArrayList<Obrazac_2> lista_obr2) {
        this.lista_obr2 = lista_obr2;
    }

    public Obrazac_2 getObr2() {
        return obr2;
    }

    public void setObr2(Obrazac_2 obr2) {
        this.obr2 = obr2;
    }

    public Obrazac_2 getObr2_new() {
        return obr2_new;
    }

    public void setObr2_new(Obrazac_2 obr2_new) {
        this.obr2_new = obr2_new;
    }

    public ArrayList<Obrazac_3> getLista_obr3() {
        return lista_obr3;
    }

    public void setLista_obr3(ArrayList<Obrazac_3> lista_obr3) {
        this.lista_obr3 = lista_obr3;
    }

    public Obrazac_3 getObr3() {
        return obr3;
    }

    public void setObr3(Obrazac_3 obr3) {
        this.obr3 = obr3;
    }

    public Obrazac_3 getObr3_new() {
        return obr3_new;
    }

    public void setObr3_new(Obrazac_3 obr3_new) {
        this.obr3_new = obr3_new;
    }

    public ArrayList<Obrazac_4> getLista_obr4() {
        return lista_obr4;
    }

    public void setLista_obr4(ArrayList<Obrazac_4> lista_obr4) {
        this.lista_obr4 = lista_obr4;
    }

    public Obrazac_4 getObr4() {
        return obr4;
    }

    public void setObr4(Obrazac_4 obr4) {
        this.obr4 = obr4;
    }

    public Obrazac_4 getObr4_new() {
        return obr4_new;
    }

    public void setObr4_new(Obrazac_4 obr4_new) {
        this.obr4_new = obr4_new;
    }

    public ArrayList<Obrazac_5> getLista_obr5() {
        return lista_obr5;
    }

    public void setLista_obr5(ArrayList<Obrazac_5> lista_obr5) {
        this.lista_obr5 = lista_obr5;
    }

    public Obrazac_5 getObr5() {
        return obr5;
    }

    public void setObr5(Obrazac_5 obr5) {
        this.obr5 = obr5;
    }

    public Obrazac_5 getObr5_new() {
        return obr5_new;
    }

    public void setObr5_new(Obrazac_5 obr5_new) {
        this.obr5_new = obr5_new;
    }
    
    public String ucitaj_obrasce(String PIBx,int godina){
        this.PIB=PIBx;
        this.period=godina;
        String desc=ucitaj();
        return desc;
        
    }
    
    
    public String ucitaj(){
        
        //obr1=null;
        Obrazac_1 obr1_prazno=new Obrazac_1();
        obr1=obr1_prazno;
        lista_obr2.clear();
        lista_obr3.clear();
        lista_obr4.clear();
        
        ucitaj_obr_1();
        ucitaj_obr_2();
        ucitaj_obr_3();
        ucitaj_obr_4();
        ucitaj_obr_5();
        
       return "obrasci";
    }
    
    public void ucitaj_obr_1(){
        //int periodINT=Integer.parseInt(period.trim());
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM obrazac_1 WHERE PIB='"+PIB+"' AND period='"+period+"'");
            while(rs.next()){
                int ID=rs.getInt("ID");
                boolean predato=rs.getBoolean("predato");
                String mesto=rs.getString("mesto");
                String opstina=rs.getString("opstina");
                String ol_ime_prezime=rs.getString("ol_ime_prezime");
                String ol_funk=rs.getString("ol_funk");
                String ol_tel=rs.getString("ol_tel");
                String k_ime_prezime=rs.getString("k_ime_prezime");
                String k_funk=rs.getString("k_funk");
                String k_tel=rs.getString("k_tel");
                String k_email=rs.getString("k_email");
                obr1.setID(ID);
                obr1.setPIB(PIB);
                obr1.setPeriod(period);
                obr1.setPredato(predato);
                obr1.setMesto(mesto);
                obr1.setOpstina(opstina);
                obr1.setOl_ime_prezime(ol_ime_prezime);
                obr1.setOl_funk(ol_funk);
                obr1.setOl_tel(ol_tel);
                obr1.setK_ime_prezime(k_ime_prezime);
                obr1.setK_funk(k_funk);
                obr1.setK_tel(k_tel);
                obr1.setK_email(k_email);
                
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
    }
    
    public String edit_obr1(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("UPDATE obrazac_1 SET mesto='"+obr1.getMesto()+"',opstina='"+obr1.getOpstina()+"',ol_ime_prezime='"+obr1.getOl_ime_prezime()+"',ol_funk='"+obr1.getOl_funk()+"',ol_tel='"+obr1.getOl_tel()+"',k_ime_prezime='"+obr1.getK_ime_prezime()+"',k_funk='"+obr1.getK_funk()+"',k_tel='"+obr1.getK_tel()+"',k_email='"+obr1.getK_email()+"' WHERE ID='"+obr1.getID()+"'");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        return "obrazac_1_view.xhtml";
    }
    
    public void delite_obr1(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("DELETE FROM obrazac_1 WHERE ID='"+obr1.getID()+"'");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        ucitaj();
    }
    
    public String new_obr1(){
        
        //INSERT INTO `obrazac_1`(`ID`, `PIB`, `period`, `predato`, `mesto`, `opstina`, `ol_ime_prezime`, `ol_funk`, `ol_tel`, `k_ime_prezime`, `k_funk`, `k_tel`, `k_email`) VALUES (
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            
            //ps.executeUpdate("INSERT INTO obrazac_1(PIB,period,mesto,opstina,ol_ime_prezime,ol_funk,ol_tel,k_ime_prezime,k_funk,k_tel,k_email) VALUES('"+PIB+"','"+period+"','"+obr1.getMesto()+"','"+obr1.getOpstina()+"','"+obr1.getOl_ime_prezime()+"','"+obr1.getOl_funk()+"','"+obr1.getOl_tel()+"','"+obr1.getK_ime_prezime()+"','"+obr1.getK_funk()+"','"+obr1.getK_tel()+"','"+obr1.getK_email()+"')");
            ps.executeUpdate("INSERT INTO obrazac_1(PIB,period,mesto,opstina,ol_ime_prezime,ol_funk,ol_tel,k_ime_prezime,k_funk,k_tel,k_email) VALUES('"+PIB+"','"+period+"','"+obr1.getMesto()+"','"+obr1.getOpstina()+"','"+obr1.getOl_ime_prezime()+"','"+obr1.getOl_funk()+"','"+obr1.getOl_tel()+"','"+obr1.getK_ime_prezime()+"','"+obr1.getK_funk()+"','"+obr1.getK_tel()+"','"+obr1.getK_email()+"')");
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("INSERT INTO obrazac_1(PIB,period,mesto,opstina,ol_ime_prezime,ol_funk,ol_tel,k_ime_prezime,k_funk,k_tel,k_email) VALUES('"+PIB+"','"+period+"','"+obr1.getMesto()+"','"+obr1.getOpstina()+"','"+obr1.getOl_ime_prezime()+"','"+obr1.getOl_funk()+"','"+obr1.getOl_tel()+"','"+obr1.getK_ime_prezime()+"','"+obr1.getK_funk()+"','"+obr1.getK_tel()+"','"+obr1.getK_email()+"')"));
        
        ucitaj();
        return "obrasci.xhtml";
    }
    
    public void ucitaj_obr_2(){ // **** ima vise obrazaca 2, a svaki od nih ima vise materija vazduha
        //int periodINT=Integer.parseInt(period.trim());
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM obrazac_2 WHERE PIB='"+PIB+"' AND period='"+period+"'");
            while(rs.next()){
                int ID=rs.getInt("ID");
                boolean predato=rs.getBoolean("predato");
                String naziv_izvora=rs.getString("naziv_izvora");
                int broj_izvora=rs.getInt("broj_izvora");
                String vrsta_ivora=rs.getString("vrsta_izvora");
                double nadmorska_visina=rs.getDouble("nadmorska_visina");
                double visina_izvora=rs.getDouble("visina_izvora");
                double precnik=rs.getDouble("precnik");
                double iskoriscenost=rs.getDouble("iskoriscenost");
                double toplotna_snaga=rs.getDouble("toplotna_snaga");
                double srednja_god_temp=rs.getDouble("srednja_god_temp");
                double brzina=rs.getDouble("brzina");
                double protok=rs.getDouble("protok");
                String rezim_rada=rs.getString("rezim_rada");
                int dana_godisnje=rs.getInt("dana_godisnje");
                double sati_dnevno=rs.getDouble("sati_dnevno");
                String napomena=rs.getString("napomena");
                
                Obrazac_2 obr2=new Obrazac_2();
                obr2.setID(ID);
                obr2.setPIB(PIB);
                obr2.setPeriod(period);
                
                obr2.setPredato(predato);
                obr2.setNaziv_izvora(naziv_izvora);
                obr2.setBroj_izvora(broj_izvora);
                obr2.setVrsta_ivora(vrsta_ivora);
                obr2.setNadmorska_visina(nadmorska_visina);
                obr2.setVisina_izvora(visina_izvora);
                obr2.setPrecnik(precnik);
                obr2.setIskoriscenost(iskoriscenost);
                obr2.setToplotna_snaga(toplotna_snaga);
                obr2.setSrednja_god_temp(srednja_god_temp);
                obr2.setBrzina(brzina);
                obr2.setProtok(protok);
                obr2.setRezim_rada(rezim_rada);
                obr2.setDana_godisnje(dana_godisnje);
                obr2.setSati_dnevno(sati_dnevno);
                obr2.setNapomena(napomena);
                //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("ID "+ID+" predato "+predato+"\n"));
                ArrayList<Vazduh> materije_vazduh=new ArrayList<Vazduh>();
                materije_vazduh=ucitaj_vazduh(ID);
                
                obr2.setMaterije_vazduh(materije_vazduh);
                
                lista_obr2.add(obr2);
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
    }
    
    public ArrayList<Vazduh> ucitaj_vazduh(int IDobr2){
        
        ArrayList<Vazduh> lista=new ArrayList<Vazduh>();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM materije_vazduh WHERE ID_obrazac_2='"+IDobr2+"'");
            while(rs.next()){
                int ID=rs.getInt("ID");
                int ID_obrazac_2=rs.getInt("ID_obrazac_2");
                String naziv=rs.getString("naziv");
                double sgiv=rs.getDouble("SGIV");
                double ekn=rs.getDouble("EKN");
                double eke=rs.getDouble("EKE");
                String metod_odredjivanja=rs.getString("metod_odredjivanja");
                String nacin_odredjivanja=rs.getString("nacin_odredjivanja");
                
                Vazduh v=new Vazduh();
                v.setID(ID);
                v.setID_obrazac_2(ID_obrazac_2);
                v.setNaziv(naziv);
                v.setSGIV(sgiv);
                v.setEKN(ekn);
                v.setEKE(eke);
                v.setMetod_odredjivanja(metod_odredjivanja);
                v.setNacin_odredjivanja(nacin_odredjivanja);
                
                lista.add(v);
                   
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        return lista;
    }
    
    private int obr2ID;

    public int getObr2ID() {
        return obr2ID;
    }

    public void setObr2ID(int obr2ID) {
        this.obr2ID = obr2ID;
    }
    
    
    public String prikazi_obr_2(int ID){
        obr2ID=ID;
        for(int i=0;i<lista_obr2.size();i++){
            if(lista_obr2.get(i).getID()==ID){
                obr2=lista_obr2.get(i);
            }
        }
        
        return "obrazac_2_view";
    }
    
    public void edit_obr2(int IDx){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("UPDATE obrazac_2 SET naziv_izvora='"+obr2.getNaziv_izvora()+"', broj_izvora='"+obr2.getBroj_izvora()+"', vrsta_izvora='"+obr2.getVrsta_ivora()+"', nadmorska_visina='"+obr2.getNadmorska_visina()+"', visina_izvora='"+obr2.getVisina_izvora()+"', precnik='"+obr2.getPrecnik()+"', iskoriscenost='"+obr2.getIskoriscenost()+"', toplotna_snaga='"+obr2.getToplotna_snaga()+"', srednja_god_temp='"+obr2.getSrednja_god_temp()+"', brzina='"+obr2.getBrzina()+"', protok='"+obr2.getProtok()+"', rezime_rada='"+obr2.getRezim_rada()+"', dana_godisnje='"+obr2.getDana_godisnje()+"', sati_dnevno='"+obr2.getSati_dnevno()+"', napomena='"+obr2.getNapomena()+"' WHERE ID='"+IDx+"'");
           
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("UPDATE obrazac_2 SET naziv_izvora='"+obr2.getNaziv_izvora()+"', broj_izvora='"+obr2.getBroj_izvora()+"', vrsta_izvora='"+obr2.getVrsta_ivora()+"', nadmorska_visina='"+obr2.getNadmorska_visina()+"', visina_izvora='"+obr2.getVisina_izvora()+"', precnik='"+obr2.getPrecnik()+"', iskoriscenost='"+obr2.getIskoriscenost()+"', toplotna_snaga='"+obr2.getToplotna_snaga()+"', srednja_god_temp='"+obr2.getSrednja_god_temp()+"', brzina='"+obr2.getBrzina()+"', protok='"+obr2.getProtok()+"', rezim_rada='"+obr2.getRezim_rada()+"', dana_godisnje='"+obr2.getDana_godisnje()+"', sati_dnevno='"+obr2.getSati_dnevno()+"', napomena='"+obr2.getNapomena()+"' WHERE ID='"+IDx+"'"));
        prikazi_obr_2(obr2ID);
    }
    
    public void delite_obr2(int IDx){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("DELETE FROM obrazac_2 WHERE ID='"+IDx+"'");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        ucitaj();
    }
    
    public String new_obr2(){
        
        //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("funk"));
         //       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("INSERT INTO obrazac_2(PIB,period,naziv_izvora,broj_izvora,vrsta_izvora,nadmorska_visina,visina_izvora,precnik,iskoriscenost,toplotna_snaga,srednja_god_temp,brzina,protok,rezim_rada,dana_godisnje,sati_dnevno,napomena) VALUES('"+PIB+"','"+period+"',"+obr2.getNaziv_izvora()+"','"+obr2.getBroj_izvora()+"','"+obr2.getVrsta_ivora()+"','"+obr2.getNadmorska_visina()+"','"+obr2.getVisina_izvora()+"','"+obr2.getPrecnik()+"','"+obr2.getIskoriscenost()+"','"+obr2.getToplotna_snaga()+"','"+obr2.getSrednja_god_temp()+"','"+obr2.getBrzina()+"','"+obr2.getProtok()+"','"+obr2.getRezim_rada()+"','"+obr2.getDana_godisnje()+"','"+obr2.getSati_dnevno()+"','"+obr2.getNapomena()+"')"));

        try{
            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("try"));

            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("konekcija"));

            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("INSERT INTO obrazac_2(PIB,period,naziv_izvora,broj_izvora,vrsta_izvora,nadmorska_visina,visina_izvora,precnik,iskoriscenost,toplotna_snaga,srednja_god_temp,brzina,protok,rezim_rada,dana_godisnje,sati_dnevno,napomena) VALUES('"+PIB+"','"+period+"',"+obr2.getNaziv_izvora()+"','"+obr2.getBroj_izvora()+"','"+obr2.getVrsta_ivora()+"','"+obr2.getNadmorska_visina()+"','"+obr2.getVisina_izvora()+"','"+obr2.getPrecnik()+"','"+obr2.getIskoriscenost()+"','"+obr2.getToplotna_snaga()+"','"+obr2.getSrednja_god_temp()+"','"+obr2.getBrzina()+"','"+obr2.getProtok()+"','"+obr2.getRezim_rada()+"','"+obr2.getDana_godisnje()+"','"+obr2.getSati_dnevno()+"','"+obr2.getNapomena()+"')"));

            ps.executeUpdate("INSERT INTO obrazac_2(PIB,period,naziv_izvora,broj_izvora,vrsta_izvora,nadmorska_visina,visina_izvora,precnik,iskoriscenost,toplotna_snaga,srednja_god_temp,brzina,protok,rezim_rada,dana_godisnje,sati_dnevno,napomena) VALUES('"+PIB+"','"+period+"','"+obr2_new.getNaziv_izvora()+"','"+obr2_new.getBroj_izvora()+"','"+obr2_new.getVrsta_ivora()+"','"+obr2_new.getNadmorska_visina()+"','"+obr2_new.getVisina_izvora()+"','"+obr2_new.getPrecnik()+"','"+obr2_new.getIskoriscenost()+"','"+obr2_new.getToplotna_snaga()+"','"+obr2_new.getSrednja_god_temp()+"','"+obr2_new.getBrzina()+"','"+obr2_new.getProtok()+"','"+obr2_new.getRezim_rada()+"','"+obr2_new.getDana_godisnje()+"','"+obr2_new.getSati_dnevno()+"','"+obr2_new.getNapomena()+"')");
              //      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("dodao"));

            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        ucitaj();
        return "obrasci.xhtml";
    }
    
   
    
    public void ucitaj_obr_3(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM obrazac_3 WHERE PIB='"+PIB+"' AND period='"+period+"'");
            while(rs.next()){
                int ID=rs.getInt("ID");
                boolean predato=rs.getBoolean("predato");
                String naziv_ispusta=rs.getString("naziv_ispusta");
                int broj_ispusta=rs.getInt("broj_ispusta");
                String rezim_rada=rs.getString("rezim_rada");
                double kapacitet=rs.getDouble("kapacitet");
                String vremenski_period=rs.getString("vremenski_period");
                double ukupna_kolicina=rs.getDouble("ukupna_kolicina");
                String mehanicko=rs.getString("mehanicko");
                String hemisko=rs.getString("hemisko");
                String biolosko=rs.getString("biolosko");
                String izmena_toplote=rs.getString("izmena_toplote");
                String napomena=rs.getString("napomena");
                
                Obrazac_3 o=new Obrazac_3();
                o.setID(ID);
                o.setPIB(PIB);
                o.setPeriod(period);
                o.setPredato(predato);
                o.setNaziv_ispusta(naziv_ispusta);
                o.setBroj_ispusta(broj_ispusta);
                o.setRezim_rada(rezim_rada);
                o.setKapacitet(kapacitet);
                o.setVremenski_period(vremenski_period);
                o.setUkupna_kolicina(ukupna_kolicina);
                o.setMehanicko(mehanicko);
                o.setHemisko(hemisko);
                o.setBiolosko(biolosko);
                o.setIzmena_toplote(izmena_toplote);
                o.setNapomena(napomena);
                
                ArrayList<Voda> materije_voda=new ArrayList<Voda>();
                materije_voda=ucitaj_vode(ID);
                
                o.setMaterije_vode(materije_voda);
                
                lista_obr3.add(o);
                
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
    }
    
    public ArrayList<Voda> ucitaj_vode(int IDx){
        ArrayList<Voda> materije_voda=new ArrayList<Voda>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM materije_vode WHERE ID_obrazac_3='"+IDx+"'");
            while(rs.next()){
                int ID=rs.getInt("ID");
                String naziv=rs.getString("naziv");
                String CAS=rs.getString("CAS");
                double SGIV=rs.getDouble("SGIV");
                double redovne_kol=rs.getDouble("redovne_kol");
                double extremne_kol=rs.getDouble("extremne_kol");
                String nacin_odredjivanja=rs.getString("nacin_odredjivanja");
                String metod_odredjivanja=rs.getString("metod_odredjivanja");
                Voda v=new Voda();
                v.setID(ID);
                v.setID_obrazac_3(IDx);
                v.setNaziv(naziv);
                v.setCAS(CAS);
                v.setSGIV(SGIV);
                v.setRedovne_kol(redovne_kol);
                v.setExtremne_kol(extremne_kol);
                v.setNacin_odredjivanja(nacin_odredjivanja);
                v.setMetod_odredjivanja(metod_odredjivanja);
                materije_voda.add(v);
                   
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        return materije_voda;
    }
    
    public String prikazi_obr_3(int ID){
        
        for(int i=0;i<lista_obr3.size();i++){
            if(lista_obr3.get(i).getID()==ID){
                obr3=lista_obr3.get(i);
            }
        }
        
        return "obrazac_3_view";
    }
    
    
    public void delete_obr_3(int IDx){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("ID "+IDx));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("DELETE FROM obrazac_3 WHERE ID='"+IDx+"'"));
            ps.executeUpdate("DELETE FROM obrazac_3 WHERE ID='"+IDx+"'");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        ucitaj();
    }
    
    public String new_obr3(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("INSERT INTO obrazac_3(PIB,period,naziv_ispusta,broj_ispusta,rezim_rada,kapacitet,vremenski_period,ukupna_kolicina,mehanicko,hemisko,biolosko,izmena_toplote,napomena) VALUES('"+PIB+"','"+period+"','"+obr3_new.getNaziv_ispusta()+"','"+obr3_new.getBroj_ispusta()+"','"+obr3_new.getRezim_rada()+"','"+obr3_new.getKapacitet()+"','"+obr3_new.getVremenski_period()+"','"+obr3_new.getUkupna_kolicina()+"','"+obr3_new.getMehanicko()+"','"+obr3_new.getHemisko()+"','"+obr3_new.getBiolosko()+"','"+obr3_new.getIzmena_toplote()+"','"+obr3_new.getNapomena()+"')"));
            ps.executeUpdate("INSERT INTO obrazac_3(PIB,period,naziv_ispusta,broj_ispusta,rezim_rada,kapacitet,vremenski_period,ukupna_kolicina,mehanicko,hemisko,biolosko,izmena_toplote,napomena) VALUES('"+PIB+"','"+period+"','"+obr3_new.getNaziv_ispusta()+"','"+obr3_new.getBroj_ispusta()+"','"+obr3_new.getRezim_rada()+"','"+obr3_new.getKapacitet()+"','"+obr3_new.getVremenski_period()+"','"+obr3_new.getUkupna_kolicina()+"','"+obr3_new.getMehanicko()+"','"+obr3_new.getHemisko()+"','"+obr3_new.getBiolosko()+"','"+obr3_new.getIzmena_toplote()+"','"+obr3_new.getNapomena()+"')");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        ucitaj();
        return "obrasci.xhtml";
    }
    
    public void edit_obr3(int IDx){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("UPDATE obrazac_3 SET naziv_ispusta='"+obr3_new.getNaziv_ispusta()+"',broj_ispusta='"+obr3_new.getBroj_ispusta()+"',rezim_rada='"+obr3_new.getRezim_rada()+"',kapacitet='"+obr3_new.getKapacitet()+"',vremenski_period='"+obr3_new.getVremenski_period()+"',ukupna_kolicina='"+obr3_new.getUkupna_kolicina()+"',mehanicko='"+obr3_new.getMehanicko()+"',hemisko='"+obr3_new.getHemisko()+"',biolosko='"+obr3_new.getBiolosko()+"',izmena_toplote='"+obr3_new.getIzmena_toplote()+"',napomena='"+obr3_new.getNapomena()+"' WHERE ID='"+IDx+"'"));
            ps.executeUpdate("UPDATE obrazac_3 SET naziv_ispusta='"+obr3.getNaziv_ispusta()+"',broj_ispusta='"+obr3.getBroj_ispusta()+"',rezim_rada='"+obr3.getRezim_rada()+"',kapacitet='"+obr3.getKapacitet()+"',vremenski_period='"+obr3.getVremenski_period()+"',ukupna_kolicina='"+obr3.getUkupna_kolicina()+"',mehanicko='"+obr3.getMehanicko()+"',hemisko='"+obr3.getHemisko()+"',biolosko='"+obr3.getBiolosko()+"',izmena_toplote='"+obr3.getIzmena_toplote()+"',napomena='"+obr3.getNapomena()+"' WHERE ID='"+IDx+"'");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        
        ucitaj();
    }
    
    public void ucitaj_obr_4(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM obrazac_4 WHERE PIB='"+PIB+"' AND period='"+period+"'");
            while(rs.next()){
                int ID=rs.getInt("ID");
                boolean predato=rs.getBoolean("predato");
                String naziv_lokacije=rs.getString("naziv_lokacije");
                String vrsta_otpada=rs.getString("vrsta_otpada");
                double kolicina_godisnje=rs.getDouble("kolicina_godisnje");
                String nacin_odlaganja=rs.getString("nacin_odlaganja");
                String napomena=rs.getString("napomena");
                
                ArrayList<Zemlja> materije_zemlje=new ArrayList<Zemlja>();
                materije_zemlje=ucitaj_zemlju(ID);
                
                Obrazac_4 c=new Obrazac_4();
                c.setID(ID);
                c.setPIB(PIB);
                c.setPeriod(period);
                c.setPredato(predato);
                c.setNaziv_lokacije(naziv_lokacije);
                c.setVrsta_otpada(vrsta_otpada);
                c.setKolicina_godisnje(kolicina_godisnje);
                c.setNacin_odlaganja(nacin_odlaganja);
                c.setNapomena(napomena);
                c.setMaterije_tlo(materije_zemlje);
                lista_obr4.add(c);
                
                   
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
    }
    
    public ArrayList<Zemlja> ucitaj_zemlju(int IDx){
        ArrayList<Zemlja> lista=new ArrayList<Zemlja>();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM materije_tlo WHERE ID_obrazac_4='"+IDx+"'");
            while(rs.next()){
                int ID=rs.getInt("ID");
                String naziv=rs.getString("naziv");
                int CAS=rs.getInt("CAS");
                double koncetracija=rs.getDouble("koncetracija");
                String nacin_odredjivanja=rs.getString("nacin_odredjivanja");
                String metod_odredjivanja=rs.getString("metod_odredjivanja");
                
                Zemlja z=new Zemlja();
                z.setID(ID);
                z.setID_obrazac_4(IDx);
                z.setNaziv(naziv);
                z.setCAS(CAS);
                z.setKoncetracija(koncetracija);
                z.setNacin_odredjivanja(nacin_odredjivanja);
                z.setMetod_odredjivanja(metod_odredjivanja);
                lista.add(z);
                   
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        
        return lista;
    }
    
    public String prikazi_obr_4(int IDx){
        
        for(int i=0;i<lista_obr4.size();i++){
            if(lista_obr4.get(i).getID()==IDx){
                obr4=lista_obr4.get(i);
            }
        }
        
        return "obrazac_4_view";
    }
    
    public void delete_obr_4(int IDx){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("DELETE FROM obrazac_4 WHERE ID='"+IDx+"'");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        ucitaj();
    }
    
    public void edit_obr4(int IDx){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("UPDATE obrazac_4 SET naziv_lokacije='"+obr4.getNaziv_lokacije()+"',vrsta_otpada='"+obr4.getVrsta_otpada()+"',kolicina_godisnje='"+obr4.getKolicina_godisnje()+"',nacin_odlaganja='"+obr4.getNacin_odlaganja()+"',napomena='"+obr4.getNapomena()+"' WHERE ID='"+IDx+"'");
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        ucitaj();
    }
    
    public void new_obr4(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("INSERT INTO obrazac_4(PIB,period,naziv_lokacije,vrsta_otpada,kolicina_godisnje,nacin_odlaganja,napomena) VALUES('"+PIB+"','"+period+"','"+obr4_new.getNaziv_lokacije()+"','"+obr4_new.getVrsta_otpada()+"','"+obr4_new.getKolicina_godisnje()+"','"+obr4_new.getNacin_odlaganja()+"','"+obr4_new.getNapomena()+"')");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        ucitaj();
    }
            
    public void ucitaj_obr_5(){
        lista_obr5.clear();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM obrazac_5 WHERE PIB='"+PIB+"' AND period='"+period+"'");
            while(rs.next()){
                int ID=rs.getInt("ID");
                boolean predato=rs.getBoolean("predato");
                String mesto_nastanka=rs.getString("mesto_nastanka");
                String naziv=rs.getString("naziv");
                String vrsta=rs.getString("vrsta");
                String opis=rs.getString("opis");
                String kategorija=rs.getString("kategorija");
                String karakter=rs.getString("karakter");
                int izvestaj_broj=rs.getInt("izvestaj_broj");
                String izvestaj_datum=rs.getString("izvestaj_datum");
                String fizicko_stanje=rs.getString("fizicko_stanje");
                String transport=rs.getString("transport");
                String odrediste=rs.getString("odrediste");
                String napomena=rs.getString("napomena");
                
                
                        
                Obrazac_5 c=new Obrazac_5();
                c.setID(ID);
                c.setPIB(PIB);
                c.setPeriod(period);
                c.setPredato(predato);
                c.setMesto_nastanka(mesto_nastanka);
                c.setNaziv(naziv);
                c.setVrsta(vrsta);
                c.setOpis(opis);
                c.setKategorija(kategorija);
                c.setKarakter(karakter);
                c.setIzvestaj_broj(izvestaj_broj);
                c.setIzvestaj_datum(izvestaj_datum);
                c.setFizicko_stanje(fizicko_stanje);
                c.setTransport(transport);
                c.setOdrediste(odrediste);
                c.setNapomena(napomena);
               
                
                
                lista_obr5.add(c);
                
                 //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("lista5: "+lista_obr5.toString()));  
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
    }
    
    public String prikazi_obr_5(int IDx){
        
        for(int i=0;i<lista_obr5.size();i++){
            if(lista_obr5.get(i).getID()==IDx){
                obr5=lista_obr5.get(i);
            }
        }
        
        return "obrazac_5_view";
    }  
    
    public void delete_obr_5(int IDx){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("DELETE FROM obrazac_5 WHERE ID='"+IDx+"'");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        ucitaj();
    }
    
    public void edit_obr5(int IDx){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("UPDATE obrazac_5 SET mesto_nastanka='"+obr5.getMesto_nastanka()+"',naziv='"+obr5.getNaziv()+"',vrsta='"+obr5.getVrsta()+"',opis='"+obr5.getOpis()+"',kategorija='"+obr5.getKategorija()+"',karakter='"+obr5.getKarakter()+"',izvestaj_broj='"+obr5.getIzvestaj_broj()+"',izvestaj_datum='"+obr5.getIzvestaj_datum()+"',fizicko_stanje='"+obr5.getFizicko_stanje()+"',transport='"+obr5.getTransport()+"',odrediste='"+obr5.getOdrediste()+"',napomena='"+obr5.getNapomena()+"' WHERE ID='"+IDx+"'");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        ucitaj();
    }
    
    public void new_obr5(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("INSERT INTO obrazac_5(PIB,period,mesto_nastanka,naziv,vrsta,opis,kategorija,karakter,izvestaj_broj,izvestaj_datum,fizicko_stanje,transport,odrediste,napomena) VALUES('"+PIB+"','"+period+"','"+obr5_new.getMesto_nastanka()+"','"+obr5_new.getNaziv()+"','"+obr5_new.getVrsta()+"','"+obr5_new.getOpis()+"','"+obr5_new.getKategorija()+"','"+obr5_new.getKarakter()+"','"+obr5_new.getIzvestaj_broj()+"','"+obr5_new.getIzvestaj_datum()+"','"+obr5_new.getFizicko_stanje()+"','"+obr5_new.getTransport()+"','"+obr5_new.getOdrediste()+"','"+obr5_new.getNapomena()+"')");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        ucitaj();
    }
    
    public String predaj_periode_start(String PIBx, int godina){
        lista_obr2.clear();
        lista_obr3.clear();
        lista_obr4.clear();
        lista_obr5.clear();
        lista_perioda.clear();
        //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("PIB: "+PIBx+" godina= "+godina));
        this.PIB=PIBx;
        
        //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("period: "+period+" PIB: "+PIB));
        ucitaj_obr_1();
        ucitaj_obr_2();
        ucitaj_obr_3();
        ucitaj_obr_4();
        ucitaj_obr_5();
        ucitaj_periode();
        
        return "predaj_periode";
    }
    public void ucitaj_periode(){
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
    }
    
    public void predaj_obr1(int ID){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("UPDATE obrazac_1 SET predato=1 WHERE ID='"+ID+"'");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        ucitaj();
    }
    public String predaj_obr2(int ID){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("UPDATE obrazac_2 SET predato=1 WHERE ID='"+ID+"'");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        obr2.setPredato(true);
        //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("UPDATE obrazac_2 SET predato=1 WHERE ID='"+ID+"'"));
        return "obrazac_2_view";
    }
    public String predaj_obr3(int ID){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("UPDATE obrazac_3 SET predato=1 WHERE ID='"+ID+"'");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        obr3.setPredato(true);
        return "obrazac_3_view";
    }
    public String predaj_obr4(int ID){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("UPDATE obrazac_4 SET predato=1 WHERE ID='"+ID+"'");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        obr4.setPredato(true);
        return "obrazac_4_view";
    }
    public String predaj_obr5(int ID){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("UPDATE obrazac_5 SET predato=1 WHERE ID='"+ID+"'");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
       obr5.setPredato(true);
        return "obrazac_5_view";
    }
    
    Vazduh v=new Vazduh();

    public Vazduh getV() {
        return v;
    }

    public void setV(Vazduh v) {
        this.v = v;
    }
    
    public String obrisi_materiju_vazduh(String naziv,int IDx ){
        //String s=""+IDx;
        //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(s));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("DELETE FROM materije_vazduh WHERE ID='"+s.trim()+"'"));
            ps.executeUpdate("DELETE FROM materije_vazduh WHERE naziv='"+naziv.trim()+"'");
            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("obrisano!"));
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        ArrayList<Vazduh> listaV= ucitaj_vazduh(IDx);
        for(int i=0;i<lista_obr2.size();i++){
            if(lista_obr2.get(i).getID()==IDx){
                obr2=lista_obr2.get(i);
                obr2.setMaterije_vazduh(listaV);
            }
        }
        
        return "obrazac_2_view";
    }
    
    public String nova_materija_vazduh(int IDx){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("INSERT INTO materije_vazduh(ID_obrazac_2,naziv,SGIV,EKN,EKE,nacin_odredjivanja,metod_odredjivanja) VALUES('"+IDx+"','"+v.getNaziv()+"','"+v.getSGIV()+"','"+v.getEKN()+"','"+v.getEKE()+"','"+v.getNacin_odredjivanja()+"','"+v.getMetod_odredjivanja()+"')");
            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("INSERT INTO materije_vazduh(ID_obrazac_2,naziv,SGIV,EKN,EKE,nacin_odredjivanja,metod_odredjivanja) VALUES('"+IDx+"','"+v.getNaziv()+"','"+v.getSGIV()+"','"+v.getEKN()+"','"+v.getEKE()+"','"+v.getNacin_odredjivanja()+"','"+v.getMetod_odredjivanja()+"')"));
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        ArrayList<Vazduh> listaV= ucitaj_vazduh(IDx);
        for(int i=0;i<lista_obr2.size();i++){
            if(lista_obr2.get(i).getID()==IDx){
                obr2=lista_obr2.get(i);
                obr2.setMaterije_vazduh(listaV);
            }
        }
        
        return "obrazac_2_view";
        
    }
    
    Voda voda=new Voda();

    public Voda getVoda() {
        return voda;
    }

    public void setVoda(Voda voda) {
        this.voda = voda;
    }
    
    public String obrisi_materiju_voda(int IDx, int IDy){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("DELETE FROM materije_vazduh WHERE ID='"+s.trim()+"'"));
            ps.executeUpdate("DELETE FROM materije_vode WHERE ID='"+IDx+"'");
            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("obrisano!"));
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        ArrayList<Voda> listaV= ucitaj_vode(IDy);
        for(int i=0;i<lista_obr3.size();i++){
            if(lista_obr3.get(i).getID()==IDy){
                obr3=lista_obr3.get(i);
                obr3.setMaterije_vode(listaV);
            }
        }
        
        return "obrazac_3_view";
    }
    
    public String nova_materija_voda(int IDx){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("INSERT INTO materije_vode(ID_obrazac_3,naziv,CAS,SGIV,redovne_kol,extremne_kol,nacin_odredjivanja,metod_odredjivanja) VALUES('"+IDx+"','"+v.getNaziv()+"','"+v.getCAS()+"','"+v.getSGIV()+"','"+v.getRedovne_kol()+"','"+v.getExtremne_kol()+"','"+v.getNacin_odredjivanja()+"','"+v.getMetod_odredjivanja()+"')"));
            ps.executeUpdate("INSERT INTO materije_vode(ID_obrazac_3,naziv,CAS,SGIV,redovne_kol,extremne_kol,nacin_odredjivanja,metod_odredjivanja) VALUES('"+IDx+"','"+voda.getNaziv()+"','"+voda.getCAS()+"','"+voda.getSGIV()+"','"+voda.getRedovne_kol()+"','"+voda.getExtremne_kol()+"','"+voda.getNacin_odredjivanja()+"','"+voda.getMetod_odredjivanja()+"')");
            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("obrisano!"));
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        ArrayList<Voda> listaV= ucitaj_vode(IDx);
        for(int i=0;i<lista_obr3.size();i++){
            if(lista_obr3.get(i).getID()==IDx){
                obr3=lista_obr3.get(i);
                obr3.setMaterije_vode(listaV);
            }
        }
        
        return "obrazac_3_view";
    }
    
    Zemlja zemlja=new Zemlja();

    public Zemlja getZemlja() {
        return zemlja;
    }

    public void setZemlja(Zemlja zemlja) {
        this.zemlja = zemlja;
    }
    
    public String obrisi_materiju_zemlja(int IDx,int IDy){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeQuery("DELETE FROM materije_tlo WHERE ID='"+IDx+"'");
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("DELETE FROM materije_tlo WHERE ID='"+IDx+"'"));
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        ArrayList<Zemlja> listaV= ucitaj_zemlju(IDy);
        for(int i=0;i<lista_obr4.size();i++){
            if(lista_obr4.get(i).getID()==IDy){
                obr4=lista_obr4.get(i);
                obr4.setMaterije_tlo(listaV);
            }
        }
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("DELETE FROM materije_tlo WHERE ID='"+IDx+"'"));
        return "obrazac_4_view";
    }
    
    public String new_materije_tlo(int IDy){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ps.executeUpdate("INSERT INTO materije_tlo(ID_obrazac_4,naziv,CAS,koncetracija,nacin_odredjivanja,metod_odredjivanja) VALUES('"+IDy+"','"+zemlja.getNaziv()+"','"+zemlja.getCAS()+"','"+zemlja.getKoncetracija()+"','"+zemlja.getNacin_odredjivanja()+"','"+zemlja.getMetod_odredjivanja()+"')");
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        ArrayList<Zemlja> listaV= ucitaj_zemlju(IDy);
        for(int i=0;i<lista_obr4.size();i++){
            if(lista_obr4.get(i).getID()==IDy){
                obr4=lista_obr4.get(i);
                obr4.setMaterije_tlo(listaV);
            }
        }
        
        return "obrazac_4_view";
    }
    public boolean postoji_obr1(){
        if(obr1.getID()!=0){ return true;}
        else{return false;}
    }
}


