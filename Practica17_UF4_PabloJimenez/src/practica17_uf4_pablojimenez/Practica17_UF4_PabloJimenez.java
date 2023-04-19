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
        Espectacle es = null;
        Recinte r = null;
        Representacio rep = null;
        
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
            int opcio = Utils.LlegirInt("Selecciona una opciÃƒÂ³: ");

            switch (opcio) {
                case 1 -> {
                    r.altaRecinte();
                    recinte = true;
                }
                case 2 -> {
                    if (!recinte) {
                        System.out.println("Per crear un espectacle primer has de donar d'alta un recinte");
                    } else {
                        es.altaEspectacle();
                        espectacle = true;
                    }
                }
                case 3 -> {
                    if (!espectacle) {
                        System.out.println("Per crear una representacio primer has de donar d'alta un espectacle");
                    } else {
                        rep.altaRepresentacio();
                    }
                }
                case 4 -> {
                    rep.ferReserva();
                }
                case 5 -> {
                    if (!espectacle) {
                        System.out.println("No hi ha espectacles disponibles");
                    }
                    System.out.println("Quin dia? Format(DD/MM)");
                    String dia = scan.next();
                    rep.llistarRepresentacions(dia);
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

    public static void llistarEspectacles() {
        
    }

}
