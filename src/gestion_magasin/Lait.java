package gestion_magasin;
import java.time.LocalDate;
public class Lait extends Alimentaire {
    private String matiereGrasse;

    public Lait(String nom, String marque, double prix, Unite unite, int tva, LocalDate dateExpiration, String matiereGrasse) {
        super(nom, marque, prix, unite, tva, dateExpiration);
        this.matiereGrasse = matiereGrasse;
    }

    @Override
    public String toString() {
        return super.toString() + "\n     Matière Grasse: " + matiereGrasse;
    }
}

