package gestion_magasin;
public class Refrigerateur extends Electromenager {
    private int volume; // en litres

    public Refrigerateur(String nom, String marque, double prix, Unite unite, int puissance, int garantie, int volume) {
        super(nom, marque, prix, unite, puissance, garantie);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Refrigerateur{" +
                "volume=" + volume +
                "} " + super.toString();
    }
}

