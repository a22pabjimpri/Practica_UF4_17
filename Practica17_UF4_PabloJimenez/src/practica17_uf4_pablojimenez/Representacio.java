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
public class Representacio {

    String nom;
    Espectacle espectacle;
    Recinte recinte;
    String data;
    public static Scanner scan = new Scanner(System.in);
    private static ArrayList<Representacio> representacions = new ArrayList<>();
    private static ArrayList<Recinte> recintes;
    private static ArrayList<Espectacle> espectacles;

    public Representacio(String nom, Espectacle espectacle, Recinte recinte, String data) {
        this.nom = nom;
        this.espectacle = espectacle;
        this.recinte = recinte;
        this.data = data;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Espectacle getEspectacle() {
        return espectacle;
    }

    public void setEspectacle(Espectacle espectacle) {
        this.espectacle = espectacle;
    }

    public Recinte getRecinte() {
        return recinte;
    }

    public void setRecinte(Recinte recinte) {
        this.recinte = recinte;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public void altaRepresentacio() {
        Espectacle es = null;
        Recinte r = null;
        Representacio rep = null;
        boolean encontrado = false;

        System.out.print("Nom de la representacio: ");
        String nomRepresentacio = scan.next();

        System.out.print("Quin espectacle? ");
        do {
            String espectacleTipus = scan.next();
            for (int i = 0; i < espectacles.size(); i++) {
                if (espectacles.get(i).getTipus().equals(espectacleTipus)) {
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
            String recinteRepresentacio = scan.next();
            for (int i = 0; i < recintes.size(); i++) {
                if (recintes.get(i).getNom().equals(recinteRepresentacio)) {
                    r = recintes.get(i);
                    encontrado = true;
                } else if (!encontrado) {
                    System.out.println("No s'ha trobat cap recinte amb aquest nom ");
                }
            }
        } while (!encontrado);

        System.out.println("Quin dia? Format(DD/MM) ");
        String dia = scan.next();

        rep = new Representacio(nomRepresentacio, es, r, dia);
        
    }
    
    public void ferReserva() {
        Representacio rep = null;
        boolean encontrado = false;
        int opcio;

        System.out.print("Quina representacio? ");
        do {
            String nomRepresentacio = scan.next();
            for (int i = 0; i < representacions.size(); i++) {
                if (representacions.get(i).getNom().equals(nomRepresentacio)) {
                    rep = representacions.get(i);
                    encontrado = true;
                } else if (!encontrado) {
                    System.out.println("No s'ha trobat cap representacio amb aquest nom ");
                }
            }
        } while (!encontrado);

        if (rep != null) {
            int llotjesDisponibles = rep.getRecinte().getLlotja();
            int butaquesDisponibles = rep.getRecinte().getLocalitats();

            // Resto la cantidad de llotjes o localitats reservadas
            if (!rep.getEspectacle().isButaques()) {
                int llotja = Utils.LlegirInt("Quantes llotges vols reservar: ");
                llotjesDisponibles -= llotja;
            } else if (!rep.getEspectacle().isLlotges()) {
                int localitats = Utils.LlegirInt("Quantes localitats vols reservar: ");
                butaquesDisponibles -= localitats;
            } else {
                do {
                    opcio = Utils.LlegirInt("Que vols reservar: 1. Llotja 2. Localitats");
                    if (opcio == 1) {
                        int llotja = Utils.LlegirInt("Quantes llotges vols reservar: ");
                        llotjesDisponibles -= llotja;
                    } else if (opcio == 2) {
                        int localitats = Utils.LlegirInt("Quantes localitats vols reservar: ");
                        butaquesDisponibles -= localitats;
                    }
                } while (opcio != 1 || opcio != 2);

            }

            rep.getRecinte().setLlotja(llotjesDisponibles);
            rep.getRecinte().setLocalitats(butaquesDisponibles);

            int index = representacions.indexOf(rep);
            representacions.set(index, rep);

            System.out.println("S'ha reservat correctament.");
        } else {
            System.out.println("No s'ha trobat cap representacio amb aquest nom.");
        }
    }
    
    public void llistarRepresentacions(String dia) {
        System.out.println("Representaciones del día " + dia + ":");
        boolean found = false;
        for (Representacio representacio : representacions) {
            if (representacio.getData().equals(dia)) {
                System.out.println(representacio.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No se encontraron representaciones para el día " + dia);
        }
    }

}
