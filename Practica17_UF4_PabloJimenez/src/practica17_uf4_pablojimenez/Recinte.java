/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica17_uf4_pablojimenez;

import java.util.ArrayList;
import java.util.Scanner;
import static practica17_uf4_pablojimenez.Practica17_UF4_PabloJimenez.scan;
import utils.Utils;
/**
 *
 * @author ausias
 */
public class Recinte {
    
    String nom;
    String tipus;
    int localitats;
    int llotja;
    public static Scanner scan = new Scanner(System.in);
    private static ArrayList<Recinte> recintes = new ArrayList<>();
    
        

    public Recinte(String nom, String tipus, int localitats, int llotja) {
        this.nom = nom;
        this.tipus = tipus;
        this.localitats = localitats;
        this.llotja = llotja;
    }

    public int getLocalitats() {
        return localitats;
    }

    public void setLocalitats(int numFiles) {
        this.localitats = numFiles;
    }

    public int getLlotja() {
        return llotja;
    }

    public void setLlotja(int llotja) {
        this.llotja = llotja;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
    public void altaRecinte() {
        String recinte = "";
        String nomRecinte = "";
        int localitatsRecinte;
        int llotjaRecinte;
        Recinte r = null;
        int opcio;
        System.out.print("Nom del recinte: ");
        nomRecinte = scan.next();

        System.out.println("Tipus del recinte: ");
        do {
            opcio = Utils.LlegirInt("""
                               1. Liceu
                               2. Teatre 
                               3. Palau d'esports 
                               """);
        } while (!(opcio < 3 || opcio > 0));
        if (opcio == 1) {
            recinte = "Liceu";
        } else if (opcio == 2) {
            recinte = "Teatre";
        } else {
            recinte = "Palau d'esports";
        }

        localitatsRecinte = Utils.LlegirInt("Quantes files te aquest recinte: ");
        llotjaRecinte = Utils.LlegirInt("Quantes llotges te aquest recinte: ");

        r = new Recinte(nomRecinte, recinte, localitatsRecinte, llotjaRecinte);
        recintes.add(r);
    }

    
    

}
