package gestion_magasin;
import java.time.LocalDate;
import java.util.Scanner;
import java.awt.Color;

public class TestApplication {

    public static void main(String[] args) {
        // Création d'un magasin
        Magasin magasin = new Magasin("SuperMarché", "123 Rue des Fleurs");

        // Ajout d'articles pour le test
        ajouterArticlesPourTest(magasin);

        // Création d'un scanner pour le manager
        Scanner scanner = new Scanner(System.in);
        
        // Création d'un Manager
        Manager manager = new Manager("Alice", 30, magasin);
        
        // Exécution du menu du Manager pour tester ses fonctionnalités
        System.out.println("----- Test des fonctionnalités du Manager -----");
        manager.menuManager();

        // Création d'un Client
        Client client = new Client("Bob", 25);

        // Exécution du menu du Client pour tester ses fonctionnalités
        System.out.println("----- Test des fonctionnalités du Client -----");
        client.menuClient(magasin);
        
        scanner.close();
    }

    private static void ajouterArticlesPourTest(Magasin magasin) {
        // Ajout d'articles pour les tests
        Article article1 = new Pain("Baguette", "Marque A", 5.0, null, 20, LocalDate.now().plusDays(7), true);
        Article article2 =new Pantalon("Jean Slim", "Levi's",75.0, Unite.PIECE,32,Color.BLUE,Categorie.HOMME,34 );
        Article article3 = new Pain("Pain de Mie", "Marque C", 3.0, null, 20, LocalDate.now().plusDays(5), true);
        
        magasin.ajouterArticle(article1);
        magasin.ajouterArticle(article2);
        magasin.ajouterArticle(article3);

        System.out.println("Articles ajoutés pour les tests :");
        magasin.afficherTousLesArticles();
    }
}
