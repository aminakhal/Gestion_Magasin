package gestion_magasin;
import java.awt.Color;
public class Pantalon extends Vestimentaire {
    private int longueur;

    public Pantalon(String nom, String marque, double prix, Unite unite,int taille, Color couleur, Categorie cible, int longueur) {
        super(nom, marque, prix, unite, taille, couleur, cible);
        this.longueur = longueur;
    }

    @Override
    public String toString() {
        return super.toString() + ", Longueur: " + longueur;
    }
}
