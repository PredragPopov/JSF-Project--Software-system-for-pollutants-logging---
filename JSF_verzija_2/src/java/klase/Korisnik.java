/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klase;

/**
 *
 * @author POPOV
 */
public class Korisnik {
    private String username;
    private String password;
    private boolean arhiviran;
    private String tip_korisnika;
    private String firma;
    private boolean firmaBool;
    
    public Korisnik(){}

    public Korisnik(String username, String password, boolean arhiviran, String tip_korisnika, String firma, boolean firmaBool) {
        this.username = username;
        this.password = password;
        this.arhiviran = arhiviran;
        this.tip_korisnika = tip_korisnika;
        this.firma = firma;
        this.firmaBool = firmaBool;
    }

    public boolean isFirmaBool() {
        return firmaBool;
    }

    public void setFirmaBool(boolean firmaBool) {
        this.firmaBool = firmaBool;
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

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    @Override
    public String toString() {
        return "Korisnik{" + "username=" + username + ", password=" + password + ", arhiviran=" + arhiviran + ", tip_korisnika=" + tip_korisnika + ", firma=" + firma + '}';
    }
    
    
           
}

