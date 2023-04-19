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
        return "Dia: " + data + ", Recinte: " + recinte.getNom() + ", Espectacle: " + espectacle.getTipus();
    }

}
