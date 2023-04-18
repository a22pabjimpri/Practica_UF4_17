/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica17_uf4_pablojimenez;

import java.util.ArrayList;
import java.util.Scanner;
import utils.Utils;

/**
 *
 * @author ausias
 */
public class Practica17_UF4_PabloJimenez {

    public static Scanner scan = new Scanner(System.in);
    private static ArrayList<Espectacle> espectacles = new ArrayList<>();
    private static ArrayList<Recinte> recintes = new ArrayList<>();
    private static ArrayList<Representacio> representacions = new ArrayList<>();

    public static void main(String[] args) {
        boolean sortir = false;
        boolean recinte = false;
        boolean espectacle = false;
        do {

            System.out.println("""
                               1. Donar d'alta recinte
                               2. Donar d'alta espectacle 
                               3. Donar d'alta representacio 
                               4. Fer una reserva 
                               5. Llistar espectacles per data
                               6. Sortir""");
            int opcio = Utils.LlegirInt("Selecciona una opciÃ³: ");

            switch (opcio) {
                case 1 -> {
                    altaRecinte();
                    recinte = true;
                }
                case 2 -> {
                    if (!recinte) {
                        System.out.println("Per crear un espectacle primer has de donar d'alta un recinte");
                    } else {
                        altaEspectacle();
                        espectacle = true;
                    }
                }
                case 3 -> {
                    if (!espectacle) {
                        System.out.println("Per crear una representacio primer has de donar d'alta un espectacle");
                    } else {
                        altaRepresentacio();
                    }
                }
                case 4 -> {
                    //Fer reserva
                }
                case 5 -> {
                    //Llistar espectacles
                }
                case 6 -> {
                    sortir = true;
                }
                default -> {
                    System.out.println("ERROR");
                }

            }

        } while (!sortir);

    }

    public static void altaRecinte() {
        String recinte = "";
        String nom = "";
        int numFiles;
        int numColumnes;
        int llotga;
        Recinte r = null;
        int opcio;
        System.out.print("Nom del recinte: ");
        nom = scan.next();

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

        numFiles = Utils.LlegirInt("Quantes files te aquest recinte: ");
        numColumnes = Utils.LlegirInt("Quantes columnes te aquest recinte: ");
        llotga = Utils.LlegirInt("Quantes llotges te aquest recinte: ");

        r = new Recinte(nom, recinte, numFiles, numColumnes, llotga);
        recintes.add(r);
    }

    public static void altaEspectacle() {
        String espectacle = "";
        boolean llotges = false;
        boolean butaques = false;
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
        } while (!(opcio < 4 && opcio > 0));
        if (opcio == 1) {
            espectacle = "Pelicula";
            butaques = true;
        } else if (opcio == 2) {
            espectacle = "Obra Teatral";
            llotges = true;
            butaques = true;
        } else if (opcio == 3) {
            espectacle = "Opera";
            llotges = true;
            butaques = true;
        } else {
            espectacle = "Prova d'esports";
            llotges = true;
        }
        es = new Espectacle(espectacle, llotges, butaques);
        espectacles.add(es);

    }

    public static void altaRepresentacio() {
        Espectacle es = null;
        Recinte r = null;
        Representacio rep = null;
        boolean encontrado = false;
        
        System.out.print("Nom de la representacio: ");
        String nom = scan.next();
        
        System.out.print("Quin espectacle? ");
        do {
            String espectacle = scan.next();
            for (int i = 0; i < espectacles.size(); i++) {
                if (espectacles.get(i).getTipus().equals(espectacle)) {
                    es = espectacles.get(i);
                    encontrado = true;
                } else if (!encontrado) {
                    System.out.println("No s'ha trobat cap espectacle d'aquest tipus ");
                }
            }
        } while (!encontrado);
        
        encontrado = false;
        
        System.out.print("Quin recinte? ");
        do {
            String recinte = scan.next();
            for (int i = 0; i < recintes.size(); i++) {
                if (recintes.get(i).getNom().equals(recinte)) {
                    r = recintes.get(i);
                    encontrado = true;
                } else if (!encontrado) {
                    System.out.println("No s'ha trobat cap recinte amb aquest nom ");
                }
            }
        } while (!encontrado);
        
        System.out.println("Quin dia? ");
        String dia = scan.next();
        
        rep = new Representacio(nom ,es, r, dia);

    }

}
