package gestion_magasin;
import java.awt.Color;
public class Chemise extends Vestimentaire {
    private boolean mancheLongue;

    public Chemise(String nom, String marque, double prix, Unite unite, int taille, Color couleur, Categorie cible, boolean mancheLongue) {
        super(nom, marque, prix, unite, taille, couleur, cible);
        this.mancheLongue = mancheLongue;
    }

    @Override
    public String toString() {
        return super.toString() + ", Manche Longue: " + (mancheLongue ? "Oui" : "Non");
    }
}


