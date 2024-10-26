package gestion_magasin;
import java.time.LocalDate;

public class Alimentaire extends Article {
    private LocalDate dateExpiration;

    public Alimentaire(String nom, String marque, double prix, Unite unite, int tva, LocalDate dateExpiration) {
        super(nom, marque, prix, unite, tva);
        this.dateExpiration = dateExpiration;
    }

    @Override
    public String toString() {
        return super.toString() + "\n     Date d'Expiration: " + dateExpiration;
    }
}


