package gestion_magasin;
import java.time.LocalDate;
public class Pain extends Alimentaire {
    private boolean avecSel;

    public Pain(String nom, String marque, double prix, Unite unite, int tva, LocalDate dateExpiration, boolean avecSel) {
        super(nom, marque, prix, unite, tva, dateExpiration);
        this.avecSel = avecSel;
    }

    @Override
    public String toString() {
        return super.toString() + "\n     Avec Sel: " + (avecSel ? "Oui" : "Non");
    }
}
