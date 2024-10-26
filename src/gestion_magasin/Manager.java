package gestion_magasin;
import java.util.Scanner;
import java.time.LocalDate;

public class Manager {
    private String nom;
    private int age;
    private Magasin magasin;

    // Constructeur
    public Manager(String nom, int age, Magasin magasin) {
        this.nom = nom;
        this.age = age;
        this.magasin = magasin;
    }

    // Méthode pour ajouter un nouvel article
    public void ajouterArticle() {
        Scanner scanner = new Scanner(System.in);

        // Demande des informations sur l'article
        System.out.print("Entrez le nom de l'article : ");
        String nom = scanner.nextLine();

        System.out.print("Entrez la marque de l'article : ");
        String marque = scanner.nextLine();

        System.out.print("Entrez le prix de l'article : ");
        double prix = scanner.nextDouble();

        // Ici, vous pouvez ajouter une logique pour demander d'autres informations (comme la catégorie, etc.)
        // Pour cet exemple, ajoutons un article alimentaire (par exemple, un pain)
        Article article = new Pain(nom, marque, prix,null,20, LocalDate.now().plusDays(7),true); // Exemple de Pain
        magasin.ajouterArticle(article);
    }

    // Méthode pour afficher la liste des articles par catégorie
    public void afficherArticlesParCategorie(String categorie) {
        System.out.println("Articles de la catégorie " + categorie + " :");
        for (Article article : magasin.getDepotArticles()) {
            if (article instanceof Alimentaire && categorie.equalsIgnoreCase("Alimentaire")) {
                System.out.println(article);
            } else if (article instanceof Vestimentaire && categorie.equalsIgnoreCase("Vestimentaire")) {
                System.out.println(article);
            } else if (article instanceof Electromenager && categorie.equalsIgnoreCase("Electroménager")) {
                System.out.println(article);
            }
        }
    }

    // Méthode pour afficher tous les articles
    public void afficherTousLesArticles() {
        magasin.afficherTousLesArticles();
    }

    // Méthode pour supprimer un article
    public void supprimerArticle(int index) {
        if (index >= 0 && index < magasin.getDepotArticles().size()) {
            Article article = magasin.getDepotArticles().remove(index);
            System.out.println("Article supprimé : " + article);
        } else {
            System.out.println("Index invalide.");
        }
    }

    // Menu interactif pour le Manager
    public void menuManager() {
        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            System.out.println("\nMenu Manager");
            System.out.println("1 – Ajouter un nouvel article");
            System.out.println("2 – Afficher la liste des articles par catégorie");
            System.out.println("3 – Afficher tous les articles présents dans le dépôt");
            System.out.println("4 – Supprimer un article");
            System.out.println("5 – Quitter le programme");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    // Ajouter un nouvel article
                    ajouterArticle();
                    break;

                case 2:
                    // Afficher les articles par catégorie
                    System.out.print("Entrez la catégorie (Alimentaire, Vestimentaire, Electroménager) : ");
                    String categorie = scanner.next();
                    afficherArticlesParCategorie(categorie);
                    break;

                case 3:
                    // Afficher tous les articles
                    afficherTousLesArticles();
                    break;

                case 4:
                    // Supprimer un article
                    System.out.println("Sélectionnez un article à supprimer (en entrant son numéro) :");
                    afficherTousLesArticles();
                    int indexSuppression = scanner.nextInt() - 1;
                    supprimerArticle(indexSuppression);
                    break;

                case 5:
                    System.out.println("Fermeture du programme.");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        } while (choix != 5);
    }
}
