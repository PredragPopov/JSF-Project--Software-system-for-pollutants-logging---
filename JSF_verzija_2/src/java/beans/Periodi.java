/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import klase.Period;


/**
 *
 * @author POPOV
 */
@ManagedBean(name="periodi",eager=true)
@SessionScoped
public class Periodi implements Serializable{
    private Period period=new Period();
    private ArrayList<Period> lista= new ArrayList<Period>();
    private Period new_period=new Period();
    private boolean zakljucan;
    
    private int izbor;
    
    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public ArrayList<Period> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Period> lista) {
        this.lista = lista;
    }

    public Period getNew_period() {
        return new_period;
    }

    public void setNew_period(Period new_period) {
        this.new_period = new_period;
    }

    

    public int getIzbor() {
        return izbor;
    }

    public void setIzbor(int izbor) {
        this.izbor = izbor;
    }

    public boolean isZakljucan() {
        return zakljucan;
    }

    public void setZakljucan(boolean zakljucan) {
        this.zakljucan = zakljucan;
    }
    
    
    
    public String ucitaj(){
        lista.clear();
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            ResultSet rs=ps.executeQuery("SELECT * FROM period");
            while(rs.next()){
                int ID=rs.getInt("ID");
                int godina=rs.getInt("godina");
                boolean zakljucan=rs.getBoolean("zakljucan");
                Period p=new Period();
                p.setID(ID);
                p.setGodina(godina);
                p.setZakljucan(zakljucan);
                lista.add(p);
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        
        return "RR_periodi";
    }
    
    public void dodaj_novi() throws IOException{
        //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("NEW PERIOD goidna= "+new_period.getGodina()+" zakljucan= "+new_period.isZakljucan()));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();
            int x=0;
            if(zakljucan==true){x=1;}
            if(zakljucan==false){x=0;}
            ps.executeUpdate("INSERT INTO period (godina,zakljucan) VALUES ('"+new_period.getGodina()+"','"+x+"')");
            ucitaj();
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("INSERT INTO period(godina,zakljucan) VALUES('"+new_period.getGodina()+"','"+new_period.isZakljucan()+"')"));
        ucitaj();
    }
    
    public void promena(int ID,int izbor){
        String SQL="";
        if(izbor==1){
            SQL="UPDATE period SET zakljucan=0 WHERE ID='"+ID+"'";
        }else if(izbor==2){
            SQL="UPDATE period SET zakljucan=1 WHERE ID='"+ID+"'";
        }
        try{
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
    
    public void obrisi(int ID) throws IOException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfprvadb","root","");
            Statement ps=con.createStatement();

            ps.executeUpdate("DELETE from period WHERE ID='"+ID+"'");
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Greska: "+e);
        }
        ucitaj();
    }
}
