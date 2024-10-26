package gestion_magasin;


import java.awt.Color;
public class Vestimentaire extends Article {
    private int taille;
    private Color couleur;
    private Categorie cible;

    public Vestimentaire(String nom, String marque, double prix, Unite unite, int taille, Color couleur, Categorie cible) {
        super(nom, marque, prix, unite, 10);
        this.taille = taille;
        this.couleur = couleur;
        this.cible = cible;
    }

    @Override
    public double calculerPrixTTC() {
        double prixTTC = super.calculerPrixTTC();
        if (prix > 500) {
            // Appliquer la taxe solidarité de 5% si le prix est supérieur à 500 DH
            prixTTC += prix * 0.05;
        }
        return prixTTC;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Taille: %d, Couleur: %s, Cible: %s", 
                                                taille, couleur.toString(), cible);
    }
}
