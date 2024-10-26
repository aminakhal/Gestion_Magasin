package gestion_magasin;
public class Article {
    protected String nom;
    protected String marque;
    protected double prix; // prix hors taxe
    protected Unite unite;
    protected int tva; // TVA standard (en pourcentage)

    public Article(String nom, String marque, double prix, Unite unite, int tva) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.unite = unite;
        this.tva = tva;
    }

    // Méthode de base pour calculer le prix TTC
    public double calculerPrixTTC() {
        return prix * (1 + tva / 100.0);
    }

    @Override
    public String toString() {
        return String.format("     Nom: %s\n     Marque: %s\n     Prix HT: %.2f\n     Unité: %s\n     Prix TTC: %.2f", 
                             nom, marque, prix, unite, calculerPrixTTC());
    }
}


