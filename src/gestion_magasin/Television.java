package gestion_magasin;
public class Television extends Electromenager {
    private int taille;

    public Television(String nom, String marque, double prix, Unite unite, int puissance, int garantie, int taille) {
        super(nom, marque, prix, unite, puissance, garantie);
        this.taille = taille;
    }

    @Override
    public double calculerPrixTTC() {
        double prixTTC = super.calculerPrixTTC();
        // Appliquer la taxe audiovisuelle de 3%
        prixTTC += prix * 0.03;
        return prixTTC;
    }

    @Override
    public String toString() {
        return super.toString() + ", Taille: " + taille + " pouces";
    }
}

