/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica17_uf4_pablojimenez;

import java.util.ArrayList;
import java.util.Scanner;
import utils.Utils;
/**
 *
 * @author ausias
 */


public class Espectacle {

    public static Scanner scan = new Scanner(System.in);
    private static ArrayList<Espectacle> espectacles = new ArrayList<>();
    String tipus;
    boolean llotges;
    boolean butaques;

    public Espectacle(String tipus, boolean llotges, boolean butaques) {
        this.tipus = tipus;
        this.llotges = llotges;
        this.butaques = butaques;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public boolean isLlotges() {
        return llotges;
    }

    public void setLlotges(boolean llotges) {
        this.llotges = llotges;
    }

    public boolean isButaques() {
        return butaques;
    }

    public void setButaques(boolean butaques) {
        this.butaques = butaques;
    }
    public static ArrayList<Espectacle> getEspectacles() {
        return espectacles;
    }

    
    public static void setEspectacles(ArrayList<Espectacle> espectacles) {
        Espectacle.espectacles = espectacles;
    }
    
    public void altaEspectacle() {
        String espectacle = "";
        boolean llotgesEspectacle = false;
        boolean butaquesEspectacle = false;
        Espectacle es = null;
        int opcio;

        System.out.println("Tipus d' espectacle ");
        do {
            opcio = Utils.LlegirInt("""
                               1. Pelicula
                               2. Obra Teatral
                               3. Opera 
                               4. Prova d'esports 
                               """);
        } while ((opcio < 5 && opcio > 0));
        if (opcio == 1) {
            espectacle = "Pelicula";
            butaquesEspectacle = true;
        } else if (opcio == 2) {
            espectacle = "Obra Teatral";
            llotgesEspectacle = true;
            butaquesEspectacle = true;
        } else if (opcio == 3) {
            espectacle = "Opera";
            llotgesEspectacle = true;
            butaquesEspectacle = true;
        } else {
            espectacle = "Prova d'esports";
            llotgesEspectacle = true;
        }
        es = new Espectacle(espectacle, llotgesEspectacle, butaquesEspectacle);
        espectacles.add(es);

    }
    


    
    
}
