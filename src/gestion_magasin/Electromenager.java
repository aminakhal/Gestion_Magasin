package gestion_magasin;
public class Electromenager extends Article {
    private int puissance;
    private int garantie;

    public Electromenager(String nom, String marque, double prix, Unite unite, int puissance, int garantie) {
        super(nom, marque, prix, unite, 15);
        this.puissance = puissance;
        this.garantie = garantie;
    }

    @Override
    public double calculerPrixTTC() {
        double prixTTC = super.calculerPrixTTC();
        if (prix > 5000) {
            // Appliquer la taxe carbone de 7% si le prix dépasse 5000 DH
            prixTTC += prix * 0.07;
        }
        return prixTTC;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Puissance: %dW, Garantie: %d ans", puissance, garantie);
    }
}
