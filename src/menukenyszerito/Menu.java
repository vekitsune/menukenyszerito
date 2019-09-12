/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menukenyszerito;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Verosffy
 */
public class Menu implements Serializable {

    MenuElem egyElem;
    ArrayList<MenuElem> menuelemek;
    boolean hus;
    boolean gluten;
    boolean cukor;
     String menuNev;
    String datFileNev="src\\datfileok\\"+menuNev;
   

    public void menuelemKivalasztasa(int sorszam) {
        egyElem = menuelemek.get(sorszam);
    }

    public void menuelemModositas(String nev, boolean hus, boolean gluten, boolean cukor) {
        egyElem.setNev(nev);
        egyElem.setHus(hus);
        egyElem.setGluten(gluten);
        egyElem.setCukor(cukor);
    }

    public void menuelemTorles(MenuElem torlendo) {
        if (menuelemek.contains(torlendo)) {
            menuelemek.remove(torlendo);
        }else{
            String valasz="Ilyen menu nincs is.";
        }
    }

    public void listaelemHozzaadas(String nev, boolean hus, boolean gluten, boolean cukor) {
        egyElem = new MenuElem(nev, hus, gluten, cukor);
        menuelemek.add(egyElem);
    }

    public void listafeltoltes() {
        try {
            FileInputStream file = new FileInputStream(datFileNev);
            ObjectInputStream inputObject = new ObjectInputStream(file);
            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    menuelemek.add((MenuElem) inputObject.readObject());

                } catch (EOFException e) {
                    endOfFile = !endOfFile;

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            inputObject.close();

        } catch (IOException e) {

        }
    }

    public void listaElmento() {

        try {
            FileOutputStream file = new FileOutputStream(datFileNev);
            ObjectOutputStream objectOut = new ObjectOutputStream(file);
            for (int i = 0; i < menuelemek.size(); i++) {
                objectOut.writeObject(menuelemek.get(i));
            }
            objectOut.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
