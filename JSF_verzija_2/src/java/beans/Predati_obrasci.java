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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import klase.Firma_Obrasci;
import klase.Firma_klasa;
import klase.Obrazac_1;
import klase.Obrazac_2;
import klase.Obrazac_3;
import klase.Obrazac_4;
import klase.Obrazac_5;
import klase.Period;
import klase.Vazduh;
import klase.Voda;
import klase.Zemlja;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 *
 * @author POPOV
 */
@ManagedBean(name="predati_obrasci",eager=true)
@SessionScoped
public class Predati_obrasci implements Serializable{
    private int period;
    private ArrayList<Firma_Obrasci> lista=new ArrayList<Firma_Obrasci>();
    private Firma_Obrasci firmaZ=new Firma_Obrasci();
    
    private Obrazac_2 obr2=new Obrazac_2();
    private Obrazac_3 obr3=new Obrazac_3();
    private Obrazac_4 obr4=new Obrazac_4();
    private Obrazac_5 obr5=new Obrazac_5();
    

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public ArrayList<Firma_Obrasci> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Firma_Obrasci> lista) {
        this.lista = lista;
    }

    public Firma_Obrasci getFirmaZ() {
        return firmaZ;
    }

    public void setFirmaZ(Firma_Obrasci firmaZ) {
        this.firmaZ = firmaZ;
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

    
    
    
    
    
    public String ucitaj(int periodX){
        period=periodX;
        lista.clear();
        
         try{
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
                
                Firma_Obrasci X=new Firma_Obrasci();
                X.setFirma(firma);
                
                X.setObr_1(ucitaj_obr_1(PIB));
                
                X.setLista_obr_2(ucitaj_obr_2(PIB));
                X.setLista_obr_3(ucitaj_obr_3(PIB));
                X.setLista_obr_4(ucitaj_obr_4(PIB));
                X.setLista_obr_5(ucitaj_obr_5(PIB));
                        
                
                if(X.getObr_1().getID()!=0){
                    if(X.getLista_obr_2().isEmpty()==false || X.getLista_obr_3().isEmpty()==false || X.getLista_obr_4().isEmpty()==false || X.getLista_obr_5().isEmpty()==false){
                        lista.add(X);
                    }
                    
                }
                
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(lista.toString()));
        return "RR_firme_za_period";
        
    }
    
    
    
    public Obrazac_1 ucitaj_obr_1(String PIB){
        Obrazac_1 obr1=new Obrazac_1();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM obrazac_1 WHERE PIB='"+PIB.trim()+"' AND period='"+period+"' AND predato=1");
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
        return obr1;
    }
    
    public ArrayList<Obrazac_2> ucitaj_obr_2(String PIB){
        ArrayList<Obrazac_2> lista=new ArrayList<Obrazac_2>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM obrazac_2 WHERE PIB='"+PIB.trim()+"' AND period='"+period+"' AND predato=1");
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
                
                ArrayList<Vazduh> materije_vazduh=new ArrayList<Vazduh>();
                materije_vazduh=ucitaj_vazduh(ID);
                
                obr2.setMaterije_vazduh(materije_vazduh);
                
                lista.add(obr2);
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        
        return lista;
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
    
    public ArrayList<Obrazac_3> ucitaj_obr_3(String PIB){
        ArrayList<Obrazac_3> lista=new ArrayList<Obrazac_3>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM obrazac_3 WHERE PIB='"+PIB.trim()+"' AND period='"+period+"' AND predato=1");
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
                
                lista.add(o);
                
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        
        
        return lista;
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
    
    public ArrayList<Obrazac_4> ucitaj_obr_4(String PIB){
        ArrayList<Obrazac_4> lista=new ArrayList<Obrazac_4>();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM obrazac_4 WHERE PIB='"+PIB.trim()+"' AND period='"+period+"' AND predato=1");
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
                lista.add(c);
                
                   
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        return lista;
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
    
    public ArrayList<Obrazac_5> ucitaj_obr_5(String PIB){
        ArrayList<Obrazac_5> lista=new ArrayList<Obrazac_5>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM obrazac_5 WHERE PIB='"+PIB.trim()+"' AND period='"+period+"' AND predato=1");
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
               
                
                
                lista.add(c);
                
                 //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("lista5: "+lista_obr5.toString()));  
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        return lista;
    }
    
    public String odabrana_firma(String PIB,int izbor){
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getFirma().getPIB()==PIB){
                firmaZ=lista.get(i);
            }
        }
        if(izbor==1){
            return "RR_firmaX_za_period";
        }else if(izbor==2){
            return "RR_obrasci";
        }
        return "";
        
    }
    public String obr_2_view(int ID){
        for(int i=0;i<firmaZ.getLista_obr_2().size();i++){
            if(firmaZ.getLista_obr_2().get(i).getID()==ID){
                obr2=firmaZ.getLista_obr_2().get(i);
            }
        }
        
        return "RR_obrazac2_view";
    }
    
    public String obr_5_view(int ID){
        for(int i=0;i<firmaZ.getLista_obr_5().size();i++){
            if(firmaZ.getLista_obr_5().get(i).getID()==ID){
                obr5=firmaZ.getLista_obr_5().get(i);
            }
        }
        
        return "RR_obrazac5_view";
    }
    
    public String obr_3_view(int ID){
        for(int i=0;i<firmaZ.getLista_obr_3().size();i++){
            if(firmaZ.getLista_obr_3().get(i).getID()==ID){
                obr3=firmaZ.getLista_obr_3().get(i);
            }
        }
        
        return "RR_obrazac3_view";
    }
    
    public String obr_4_view(int ID){
        for(int i=0;i<firmaZ.getLista_obr_4().size();i++){
            if(firmaZ.getLista_obr_4().get(i).getID()==ID){
                obr4=firmaZ.getLista_obr_4().get(i);
            }
        }
        
        return "RR_obrazac4_view";
    }
    
    public void stampaj_obr1(){
        Document document = new Document();
      try
      {
         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\POPOV\\Desktop\\obrazac1_PIB_"+firmaZ.getObr_1().getPIB()+".pdf"));
         document.open();
         Obrazac_1 o1=new Obrazac_1();
         o1=firmaZ.getObr_1();
         document.add(new Paragraph("OBRAZAC 1 firme: "+firmaZ.getFirma().getNaziv()));
         document.add(new Paragraph("PIB firme: "+o1.getPIB()));
         document.add(new Paragraph("Period: "+o1.getPeriod()));
         document.add(new Paragraph("Mesto: "+o1.getMesto()));
         document.add(new Paragraph("Opština: "+o1.getOpstina()));
         document.add(new Paragraph("Odgovorno lice:"));
         document.add(new Paragraph(o1.getOl_funk()+" "+o1.getOl_ime_prezime()+" ("+o1.getOl_tel()+")"));
         document.add(new Paragraph("Kontakt lice"));
         document.add(new Paragraph(o1.getK_funk()+" "+o1.getK_ime_prezime()+" ("+o1.getK_tel()+" ,"+o1.getK_email()+")"));
         document.close();
         writer.close();
      } catch (DocumentException e)
      {
         e.printStackTrace();
      } catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
    }
    public void stampaj_obr2(){
        Document document = new Document();
      try
      {
         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\POPOV\\Desktop\\obrazac2_PIB_"+firmaZ.getObr_1().getPIB()+".pdf"));
         document.open();
         
         document.add(new Paragraph("OBRAZAC 2 firme: "+firmaZ.getFirma().getNaziv()));
         document.add(new Paragraph("PIB firme: "+obr2.getPIB()));
         document.add(new Paragraph("Period: "+obr2.getPeriod()));
         document.add(new Paragraph("Naziv izvora: "+obr2.getNaziv_izvora()));
         document.add(new Paragraph("Broj izvora: "+obr2.getBroj_izvora()));
         document.add(new Paragraph("Vrsta izvora: "+obr2.getVrsta_ivora()));
         document.add(new Paragraph("Nadmorska visina: "+obr2.getNaziv_izvora()));
         document.add(new Paragraph("Visina izvora: "+obr2.getVisina_izvora()));
         document.add(new Paragraph("Unutrašnji precnik ispusta: "+obr2.getPrecnik()));
         document.add(new Paragraph("Godišnja iskorišćenost kapaciteta: "+obr2.getIskoriscenost()));
         document.add(new Paragraph("Instalisana toplotna snaga na izlazu: "+obr2.getToplotna_snaga()));
         document.add(new Paragraph("Srednja godišnja temperatura materije: "+obr2.getSrednja_god_temp()));
         document.add(new Paragraph("Brzina ispusta: "+obr2.getBrzina()));
         document.add(new Paragraph("Protok: "+obr2.getProtok()));
         document.add(new Paragraph("Režim rada: "+obr2.getRezim_rada()));
         document.add(new Paragraph("Broj radnih dana godišnje: "+obr2.getDana_godisnje()));
         document.add(new Paragraph("Broj radnih sati dnevno: "+obr2.getSati_dnevno()));
         document.add(new Paragraph("Napomena: "+obr2.getNapomena()));
         document.add(new Paragraph("Materije zagađivači:"));
         for(int i=0;i<obr2.getMaterije_vazduh().size();i++){
             document.add(new Paragraph(obr2.getMaterije_vazduh().get(i).toString()));
         }
         
         
         document.close();
         writer.close();
      } catch (DocumentException e)
      {
         e.printStackTrace();
      } catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
    }
    public void stampaj_obr3(){
        Document document = new Document();
      try
      {
         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\POPOV\\Desktop\\obrazac3_PIB_"+firmaZ.getObr_1().getPIB()+".pdf"));
         document.open();
         
         document.add(new Paragraph("OBRAZAC 1 firme: "+firmaZ.getFirma().getNaziv()));
         document.add(new Paragraph("PIB firme: "+obr3.getPIB()));
         document.add(new Paragraph("Period: "+obr3.getPeriod()));
         document.add(new Paragraph("Naziv ispusta: "+obr3.getNaziv_ispusta()));
         document.add(new Paragraph("Broj ispusta: "+obr3.getBroj_ispusta()));
         document.add(new Paragraph("Režim rada ispusta: "+obr3.getRezim_rada()));
         document.add(new Paragraph("Projektovani kapacitet ispusta: "+obr3.getKapacitet()));
         document.add(new Paragraph("Vremenski period ispuštanja: "+obr3.getVremenski_period()));
         document.add(new Paragraph("Ukupna količina otpadne vode godišnje: "+obr3.getUkupna_kolicina()));
         document.add(new Paragraph("Mehaničko prečišćavanje:"+obr3.getMehanicko()));
         document.add(new Paragraph("Hemisko prečišćavanje:"+obr3.getHemisko()));
         document.add(new Paragraph("Biloško prečišćavanje:"+obr3.getBiolosko()));
         document.add(new Paragraph("Uređaj za izmenu toplote: "+obr3.getIzmena_toplote()));
         document.add(new Paragraph("Napomena: "+obr3.getNapomena()));
         document.add(new Paragraph("Materije zagađivači:"));
         for(int i=0;i<obr3.getMaterije_vode().size();i++){
             document.add(new Paragraph(obr3.getMaterije_vode().get(i).toString()));
         }
         
         
         document.close();
         writer.close();
      } catch (DocumentException e)
      {
         e.printStackTrace();
      } catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
    }
    public void stampaj_obr4(){
        Document document = new Document();
      try
      {
         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\POPOV\\Desktop\\obrazac4_PIB_"+firmaZ.getObr_1().getPIB()+".pdf"));
         document.open();
         
         document.add(new Paragraph("OBRAZAC 1 firme: "+firmaZ.getFirma().getNaziv()));
         document.add(new Paragraph("PIB firme: "+obr4.getPIB()));
         document.add(new Paragraph("Period:"+obr4.getPeriod()));
         document.add(new Paragraph("Naziv lokacije: "+obr4.getNaziv_lokacije()));
         document.add(new Paragraph("Vrsta otpada: "+obr4.getVrsta_otpada()));
         document.add(new Paragraph("Ispuštena količina godišnje: "+obr4.getKolicina_godisnje()));
         document.add(new Paragraph("Način odlaganja: "+obr4.getNacin_odlaganja()));
         document.add(new Paragraph("Napomena: "+obr4.getNapomena()));
         for(int i=0;i<obr4.getMaterije_tlo().size();i++){
             document.add(new Paragraph(obr4.getMaterije_tlo().get(i).toString()));
         }
         
         
         document.close();
         writer.close();
      } catch (DocumentException e)
      {
         e.printStackTrace();
      } catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
    }
    public void stampaj_obr5(){
        Document document = new Document();
      try
      {
         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\POPOV\\Desktop\\obrazac5_PIB_"+firmaZ.getObr_1().getPIB()+".pdf"));
         document.open();
         Obrazac_1 o1=new Obrazac_1();
         o1=firmaZ.getObr_1();
         document.add(new Paragraph("OBRAZAC 1 firme: "+firmaZ.getFirma().getNaziv()));
         document.add(new Paragraph("PIB firme: "+obr5.getPIB()));
         document.add(new Paragraph("Period: "+obr5.getPeriod()));
         document.add(new Paragraph("Mesto nastanka otpada: "+obr5.getMesto_nastanka()));
         document.add(new Paragraph("Naziv otpada: "+obr5.getNaziv()));
         document.add(new Paragraph("Vrsta otpada: "+obr5.getVrsta()));
         document.add(new Paragraph("Opis:"+obr5.getOpis()));
         document.add(new Paragraph("Kategorija otpada: "+obr5.getKategorija()));
         document.add(new Paragraph("Karakter otpada: "+obr5.getKarakter()));
         document.add(new Paragraph("Broj izveštaja o ispitivanju: "+obr5.getIzvestaj_broj()));
         document.add(new Paragraph("Datum izveštaja o ispitivanju: "+obr5.getIzvestaj_datum()));
         document.add(new Paragraph("Fizičko stanje otpada: "+obr5.getFizicko_stanje()));
         document.add(new Paragraph("Način transporta: "+obr5.getTransport()));
         document.add(new Paragraph("Odredište: "+obr5.getOdrediste()));
         document.add(new Paragraph("Napomena: "+obr5.getNapomena()));
         
         
         
         document.close();
         writer.close();
      } catch (DocumentException e)
      {
         e.printStackTrace();
      } catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
    }
    
}
