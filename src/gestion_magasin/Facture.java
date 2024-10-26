package gestion_magasin;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Facture {
    private static int numeroSerieCounter = 1; // Compteur statique pour le numéro de série
    private int numeroSerie; // Numéro de série unique
    private Client client; // Client pour lequel la facture est créée
    private List<Article> articles; // Liste des articles dans la facture
    private LocalDate date; // Date de la facture

    // Constructeur
    public Facture(Client client, List<Article> articles) {
        this.numeroSerie = numeroSerieCounter++;
        this.client = client;
        this.articles = articles;
        this.date = LocalDate.now();
    }

    // Méthode pour calculer le montant total de la facture
    public double calculerMontantTotal() {
        double montantTotal = 0.0;

        for (Article article : articles) {
            double prixTTC = article.calculerPrixTTC();
            montantTotal += prixTTC;
        }

        return montantTotal;
    }

    // Méthode pour éditer la facture dans un fichier
    public void editerFacture() {
        String nomFichier = "facture_" + numeroSerie + "_" + client.getNom() + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier))) {
            writer.write("Facture N°: " + numeroSerie + "\n");
            writer.write("Nom du client: " + client.getNom() + "\n");
            writer.write("Date: " + date + "\n\n");
            writer.write("Articles:\n");

            for (Article article : articles) {
                writer.write("- " + article + " | Prix TTC: " + article.calculerPrixTTC() + "\n");
            }

            writer.write("\nMontant total: " + calculerMontantTotal() + "\n");
            System.out.println("Facture éditée avec succès dans le fichier: " + nomFichier);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'édition de la facture: " + e.getMessage());
        }
    }

    // Getters
    public int getNumeroSerie() {
        return numeroSerie;
    }

    public Client getClient() {
        return client;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
