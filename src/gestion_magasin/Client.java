package gestion_magasin;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private String nom;
    private int age;
    private List<Article> panier;

    // Constructeur
    public Client(String nom, int age) {
        this.nom = nom;
        this.age = age;
        this.panier = new ArrayList<>();
    }
    public String getNom() {
    	return this.nom;
    }

    // Méthode pour ajouter un article au panier
    public void ajouterAuPanier(Article article) {
        panier.add(article);
        System.out.println("Article ajouté au panier : " + article);
    }

    // Méthode pour supprimer un article du panier
    public void supprimerDuPanier(int index) {
        if (index >= 0 && index < panier.size()) {
            Article article = panier.remove(index);
            System.out.println("Article supprimé du panier : " + article);
        } else {
            System.out.println("Index invalide.");
        }
    }

    // Méthode pour afficher les articles du panier
    public void afficherPanier() {
        if (panier.isEmpty()) {
            System.out.println("Le panier est vide.");
        } else {
            System.out.println("Contenu du panier : ");
            for (int i = 0; i < panier.size(); i++) {
                System.out.println((i + 1) + ". " + panier.get(i));
            }
        }
    }

    // Menu interactif pour le client
    public void menuClient(Magasin magasin) {
        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            System.out.println("\nMenu Client");
            System.out.println("1 – Afficher les articles disponibles");
            System.out.println("2 – Ajouter un article au panier");
            System.out.println("3 – Supprimer un article du panier");
            System.out.println("4 – Vider le panier");
            System.out.println("5 – Calculer le montant total");
            System.out.println("6 – Quitter le programme");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    // Affichage des articles disponibles
                    magasin.afficherTousLesArticles();
                    break;

                case 2:
                    // Logique d'ajout d'un article au panier
                    System.out.println("Sélectionnez un article à ajouter (en entrant son numéro) :");
                    magasin.afficherTousLesArticles();
                    int indexAjout = scanner.nextInt() - 1;

                    if (indexAjout >= 0 && indexAjout < magasin.getDepotArticles().size()) {
                        Article articleAjoute = magasin.getDepotArticles().get(indexAjout);
                        ajouterAuPanier(articleAjoute);
                    } else {
                        System.out.println("Numéro d'article invalide.");
                    }
                    break;

                case 3:
                    // Logique de suppression d'un article du panier
                    System.out.println("Sélectionnez un article à supprimer du panier (en entrant son numéro) :");
                    afficherPanier();
                    int indexSuppression = scanner.nextInt() - 1;

                    supprimerDuPanier(indexSuppression);
                    break;

                case 4:
                    // Vider le panier
                    panier.clear();
                    System.out.println("Panier vidé.");
                    break;

                case 5:
                    // Calculer le montant total
                    System.out.println("Montant total : " + calculerMontantTotal() + " DH");
                    break;

                case 6:
                    System.out.println("Fermeture du programme.");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        } while (choix != 6);
    }

    // Méthode pour calculer le montant total des articles dans le panier
    public double calculerMontantTotal() {
        double total = 0;
        for (Article article : panier) {
            total += article.calculerPrixTTC();
        }
        return total;
    }
}
