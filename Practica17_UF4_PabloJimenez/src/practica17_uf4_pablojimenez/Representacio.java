/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica17_uf4_pablojimenez;

/**
 *
 * @author ausias
 */
public class Representacio {

    String nom;
    Espectacle espectacle;
    Recinte recinte;
    String data;

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

    @Override
    public String toString() {
        String info = "";
        String missatge = "";
        if (recinte.localitats == 0 && recinte.llotja == 0) {
            info = "No queden llotges ni localitats disponibles per aquesta representacio";
        } else if (!espectacle.butaques) {
            missatge = "Representacio " + nom + " dia: " + data + " llotges disponibles " + recinte.llotja;
            info = "Per aquesta representacio només es poden reservar llotjes";
        } else if (!espectacle.llotges) {
            missatge = "Representacio " + nom + " dia: " + data + " butaques disponibles " + recinte.localitats;
            info = "Per aquesta representacio només es poden reservar butaques";
        } else {
            info = "Per aquesta representacio es poden reservar llotges i butaques";
            missatge = "Representacio " + nom + " dia: " + data + " butaques disponibles " + recinte.localitats + " llotges disponibles " + recinte.llotja;
        }
        return missatge + " " + info;
    }

}
