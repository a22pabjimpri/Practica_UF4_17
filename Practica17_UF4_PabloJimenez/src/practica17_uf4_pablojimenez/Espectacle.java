/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica17_uf4_pablojimenez;

/**
 *
 * @author ausias
 */
public class Espectacle {

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
    


    
    
}
