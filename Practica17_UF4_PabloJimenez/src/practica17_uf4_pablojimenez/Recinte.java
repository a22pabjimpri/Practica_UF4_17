/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica17_uf4_pablojimenez;

/**
 *
 * @author ausias
 */
public class Recinte {
    
    String nom;
    String tipus;
    int numFiles;
    int numColumnes;
    int llotja;
    boolean localitats[][];

    public Recinte(String nom, String tipus, int numFiles, int numColumnes, int llotja) {
        this.nom = nom;
        this.tipus = tipus;
        this.numFiles = numFiles;
        this.numColumnes = numColumnes;
        this.llotja = llotja;      
        localitats = new boolean[numFiles][numColumnes];
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

    public int getNumFiles() {
        return numFiles;
    }

    public void setNumFiles(int numFiles) {
        this.numFiles = numFiles;
    }

    public int getNumColumnes() {
        return numColumnes;
    }

    public void setNumColumnes(int numColumnes) {
        this.numColumnes = numColumnes;
    }

    public int getLlotja() {
        return llotja;
    }

    public void setLlotja(int llotja) {
        this.llotja = llotja;
    }
    
        

    
    
    

}