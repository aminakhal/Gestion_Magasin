package gestion_magasin;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class Magasin {
    private String nom;
    private String adresse;
    private List<Article> depotArticles;

    // Constructeur
    public Magasin(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.depotArticles = new ArrayList<>();
    }

    // Méthode pour ajouter un article
    public void ajouterArticle(Article article) {
        depotArticles.add(article);
        System.out.println("Article ajouté :\n" + article);
    }

    // Méthode pour afficher les articles par catégorie
    public void afficherArticlesParCategorie(Class<?> categorie) {
        System.out.println("Articles dans la catégorie : " + categorie.getSimpleName());
        for (Article article : depotArticles) {
            if (categorie.isInstance(article)) {
                System.out.println("\n"+ article);
            }
        }
    }

    // Méthode pour afficher tous les articles
    public void afficherTousLesArticles() {
        System.out.println("   Liste des articles dans le dépôt :");
        for (Article article : depotArticles) {
            System.out.println(article);
        }
    }

    // Méthode pour supprimer un article
    public void supprimerArticle(Article article) {
        if (depotArticles.remove(article)) {
            System.out.println("Article supprimé : " + article);
        } else {
            System.out.println("Article non trouvé.");
        }
    }
   // Getter pour obtenir la liste des articles
    public List<Article> getDepotArticles() {
        return depotArticles;
    }
}
