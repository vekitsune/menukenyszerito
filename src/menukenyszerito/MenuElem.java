/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menukenyszerito;

import java.io.Serializable;

/**
 *
 * @author Verosffy
 */
public class MenuElem implements Serializable{
    
    private String nev;
    private int szorzo;
    private boolean hus;
    private boolean gluten;
    private boolean cukor;

    public MenuElem(String nev, boolean hus, boolean gluten, boolean cukor) {
        this.nev = nev;
        this.hus = hus;
        this.gluten = gluten;
        this.cukor = cukor;
    }

    public boolean isCukor() {
        return cukor;
    }

    public void setCukor(boolean cukor) {
        this.cukor = cukor;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getSzorzo() {
        return szorzo;
    }

    public void setSzorzo(int szorzo) {
        this.szorzo = szorzo;
    }

    public boolean isHus() {
        return hus;
    }

    public void setHus(boolean hus) {
        this.hus = hus;
    }

    public boolean isGluten() {
        return gluten;
    }

    public void setGluten(boolean gluten) {
        this.gluten = gluten;
    }
    
    
    
}
