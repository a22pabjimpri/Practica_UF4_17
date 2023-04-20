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
                    if (!espectacle) {
                        System.out.println("No hi ha espectacles disponibles");
                    }
                    llistarEspectacles();
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
        int llotja;
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
        llotja = Utils.LlegirInt("Quantes llotges te aquest recinte: ");

        r = new Recinte(nom, recinte, numFiles, numColumnes, llotja);
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

        rep = new Representacio(nom, es, r, dia);

    }

    public static void ferReserva() {
        Representacio rep = null;
        boolean encontrado = false;
        int opcio;
        int numFila;
        int numSeient;

        System.out.print("Quina representacio? ");
        do {
            String nom = scan.next();
            for (int i = 0; i < representacions.size(); i++) {
                if (representacions.get(i).getNom().equals(nom)) {
                    rep = representacions.get(i);
                    encontrado = true;
                } else if (!encontrado) {
                    System.out.println("No s'ha trobat cap espectacle amb aquest nom ");
                }
            }
        } while (!encontrado);

        if (rep != null) {
            int llotjesDisponibles = rep.getRecinte().getLlotja();
            boolean[][] butaquesDisponibles = rep.getRecinte().localitats;

            // Resto la cantidad de llotjes o localitats reservadas
            if (!rep.getEspectacle().isButaques()) {
                int llotja = Utils.LlegirInt("Quantes llotges vols reservar: ");
                llotjesDisponibles -= llotja;
            } else if (!rep.getEspectacle().isLlotges()) {
                numFila = Utils.LlegirInt("Quina fila vols: ");
                numSeient = Utils.LlegirInt("Quina seient vols: ");
                for (int i = 0; i < butaquesDisponibles.length; i++) {
                    if (butaquesDisponibles[numFila][numSeient]) {
                        System.out.println("Aquest seient ja està reservat");
                    } else {
                        butaquesDisponibles[numFila][numSeient] = true;
                        System.out.println("Seients reservats");
                    }
                }
            } else {
                do {
                    opcio = Utils.LlegirInt("Que vols reservar: 1. Llotja 2. Localitats");
                    if (opcio == 1) {
                        int llotja = Utils.LlegirInt("Quantes llotges vols reservar: ");
                        llotjesDisponibles -= llotja;
                    } else if (opcio == 2) {
                        numFila = Utils.LlegirInt("Quina fila vols: ");
                        numSeient = Utils.LlegirInt("Quina seient vols: ");
                        for (int i = 0; i < butaquesDisponibles.length; i++) {
                            if (butaquesDisponibles[numFila][numSeient]) {
                                System.out.println("Aquest seient ja està reservat");
                            } else {
                                butaquesDisponibles[numFila][numSeient] = true;
                                System.out.println("Seients reservats");
                            }
                        }

                    }
                } while (opcio != 1 || opcio != 2);

            }

            // Actualizar la información en la representación
            rep.getRecinte().setLlotja(llotjesDisponibles);
            rep.getRecinte().localitats = butaquesDisponibles;

            // Actualizar la representación en el ArrayList
            int index = representacions.indexOf(rep);
            representacions.set(index, rep);

            System.out.println("S'ha actualitzat la representació exitosament.");
        } else {
            System.out.println("No s'ha trobat cap representació amb aquest nom.");
        }
    }

    public static void llistarEspectacles() {
        boolean encontrado = false;
        Representacio rep = null;

         System.out.print("Quin dia? Format[DD/MM] ");
        do {
            String dia = scan.next();
            for (int i = 0; i < representacions.size(); i++) {
                if (representacions.get(i).getNom().equals(dia)) {
                    rep = representacions.get(i);
                    encontrado = true;
                } else if (!encontrado) {
                    System.out.println("No s'ha trobat cap recinte amb aquest nom ");
                }
            }
        } while (!encontrado);
        System.out.println(rep.toString());
    }

}
