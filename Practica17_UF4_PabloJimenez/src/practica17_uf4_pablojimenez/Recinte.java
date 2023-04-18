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
    protected static int numFiles;
    protected static int numColumnes;
    protected static int llotga;
    
        

    public Recinte(String nom, String tipus, int numFiles, int numColumnes, int llotga) {
        this.nom = nom;
        this.tipus = tipus;
        this.numFiles = numFiles;
        this.numColumnes = numColumnes;
        this.llotga = llotga;
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

    public int getLlotga() {
        return llotga;
    }

    public void setLlotga(int llotga) {
        this.llotga = llotga;
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

    
    

}
