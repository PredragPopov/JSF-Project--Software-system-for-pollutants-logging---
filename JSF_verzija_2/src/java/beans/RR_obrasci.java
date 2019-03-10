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
import java.sql.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import klase.Obrazac_1;
import klase.Obrazac_2;
import klase.Obrazac_3;
import klase.Obrazac_4;
import klase.Obrazac_5;
import klase.Vazduh;
import klase.Voda;
import klase.Zemlja;

/**
 *
 * @author POPOV
 */
@ManagedBean(name="rr_obrasci",eager=true)
@RequestScoped
public class RR_obrasci implements Serializable{
    private Obrazac_1 obr1=new Obrazac_1();
    private Obrazac_2 obr2=new Obrazac_2();
    private Obrazac_3 obr3=new Obrazac_3();
    private Obrazac_4 obr4=new Obrazac_4();
    private Obrazac_5 obr5=new Obrazac_5();

    public Obrazac_1 getObr1() {
        return obr1;
    }

    public void setObr1(Obrazac_1 obr1) {
        this.obr1 = obr1;
    }

    public Obrazac_2 getObr2() {
        return obr2;
    }

    public void setObr2(Obrazac_2 obr2) {
        this.obr2 = obr2;
    }

    public Obrazac_3 getObr3() {
        return obr3;
    }

    public void setObr3(Obrazac_3 obr3) {
        this.obr3 = obr3;
    }

    public Obrazac_4 getObr4() {
        return obr4;
    }

    public void setObr4(Obrazac_4 obr4) {
        this.obr4 = obr4;
    }

    public Obrazac_5 getObr5() {
        return obr5;
    }

    public void setObr5(Obrazac_5 obr5) {
        this.obr5 = obr5;
    }
    
    public String ucitaj_obr_1(int ID){
        //int periodINT=Integer.parseInt(period.trim());
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM obrazac_1 WHERE ID='"+ID+"'");
            while(rs.next()){
                String PIB=rs.getString("PIB");
                int period=rs.getInt("period");
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
        return "RR_obrazac1_view";
    }
    
    public String ucitaj_obr_2(int ID){ 
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM obrazac_2 WHERE ID='"+ID+"'");
            while(rs.next()){
                String PIB=rs.getString("PIB");
                int period=rs.getInt("period");
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
                
                ArrayList<Vazduh> materije_vazduh=new ArrayList<Vazduh>();
                materije_vazduh=ucitaj_vazduh(ID);
                
                obr2.setMaterije_vazduh(materije_vazduh);
                
                
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        return "RR_obrazac2_view";
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
                v.setSGIV(eke);
                v.setEKN(eke);
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
   
    public String ucitaj_obr_3(int ID){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM obrazac_3 WHERE ID='"+ID+"'");
            while(rs.next()){
                String PIB=rs.getString("PIB");
                int period=rs.getInt("period");
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
                
                
                obr3.setID(ID);
                obr3.setPIB(PIB);
                obr3.setPeriod(period);
                obr3.setPredato(predato);
                obr3.setNaziv_ispusta(naziv_ispusta);
                obr3.setBroj_ispusta(broj_ispusta);
                obr3.setRezim_rada(rezim_rada);
                obr3.setKapacitet(kapacitet);
                obr3.setVremenski_period(vremenski_period);
                obr3.setUkupna_kolicina(ukupna_kolicina);
                obr3.setMehanicko(mehanicko);
                obr3.setHemisko(hemisko);
                obr3.setBiolosko(biolosko);
                obr3.setIzmena_toplote(izmena_toplote);
                obr3.setNapomena(napomena);
                
                ArrayList<Voda> materije_voda=new ArrayList<Voda>();
                materije_voda=ucitaj_vode(ID);
                
                obr3.setMaterije_vode(materije_voda);
                
                
                
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        return "RR_obrazac3_view";
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
    
    public String ucitaj_obr_4(int ID){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM obrazac_4 WHERE ID='"+ID+"'");
            while(rs.next()){
                String PIB=rs.getString("PIB");
int period=rs.getInt("period");
                boolean predato=rs.getBoolean("predato");
                String naziv_lokacije=rs.getString("naziv_lokacije");
                String vrsta_otpada=rs.getString("vrsta_otpada");
                double kolicina_godisnje=rs.getDouble("kolicina_godisnje");
                String nacin_odlaganja=rs.getString("nacin_odlaganja");
                String napomena=rs.getString("napomena");
                
                ArrayList<Zemlja> materije_zemlje=new ArrayList<Zemlja>();
                materije_zemlje=ucitaj_zemlju(ID);
                
                
                obr4.setID(ID);
                obr4.setPIB(PIB);
                obr4.setPeriod(period);
                obr4.setPredato(predato);
                obr4.setNaziv_lokacije(naziv_lokacije);
                obr4.setVrsta_otpada(vrsta_otpada);
                obr4.setKolicina_godisnje(kolicina_godisnje);
                obr4.setNacin_odlaganja(nacin_odlaganja);
                obr4.setNapomena(napomena);
                obr4.setMaterije_tlo(materije_zemlje);
                
               
                
                   
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        return "RR_obrazac4_view";
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
    
    public String ucitaj_obr_5(int ID){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM obrazac_5 WHERE ID='"+ID+"'");
            while(rs.next()){
                String PIB=rs.getString("PIB");
                int period=rs.getInt("period");
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
                
                
                obr5.setID(ID);
                obr5.setPIB(PIB);
                obr5.setPeriod(period);
                obr5.setPredato(predato);
                obr5.setMesto_nastanka(mesto_nastanka);
                obr5.setNaziv(naziv);
                obr5.setVrsta(vrsta);
                obr5.setOpis(opis);
                obr5.setKategorija(kategorija);
                obr5.setKarakter(karakter);
                obr5.setIzvestaj_broj(izvestaj_broj);
                obr5.setIzvestaj_datum(izvestaj_datum);
                obr5.setFizicko_stanje(fizicko_stanje);
                obr5.setTransport(transport);
                obr5.setOdrediste(odrediste);
                obr5.setNapomena(napomena);
               
                
                   
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        return "RR_obrazac5_view";
    }
    
}
