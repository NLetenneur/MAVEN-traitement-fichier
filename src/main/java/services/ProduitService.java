package services;

import java.util.List;

import entites.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ProduitService {
	public static void enregistrerNouveauProduitDepuisFichier(String[] tab) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		String nom = tab[2];
		List<Produit> produits = ProduitService.extractingProduits(em);
		// vérifier que le produit n'est pas encore dans la base.
		if (!isTheProduitInDataBase(produits, nom)) {
			Produit prod = new Produit(nom);

			// ajouter la catégorie
			CategorieService.ajouterCategorie(tab, prod);

			// ajouter la marque
			MarqueService.ajouterMarque(tab, prod);

			// ajouter le nutriscore
			String nutriGradeFr = tab[3];
			prod.setScoreNutritionnel(nutriGradeFr);

			// ajouter les ingrédients
			IngredientService.ajouterIngredients(tab, prod);

			// Ajouter les info pour 100g
			Info100gService.ajouterInfo100g(tab, prod);

			// ajouter Huile de palme
			String presenceHuilePalme = tab[27];
			if (presenceHuilePalme.equals("0")) {
				prod.setPresenceHuilePalme(false);
			} else {
				prod.setPresenceHuilePalme(true);
			}

			// ajouter allergenes
			AllergeneService.ajouterAllergenes(tab, prod);

			// ajouter additifs
			AdditifService.ajouterAdditifs(tab, prod);

			em.persist(prod);
			transaction.commit();
		} else {

		}
	}

	private static boolean isTheProduitInDataBase(List<Produit> produits, String nom) {
		for (Produit item : produits) {
			if (item.getLibelle() == nom) {
				return true;
			}
		}
		return false;
	}

	public static List<Produit> extractingProduits(EntityManager em) {
		TypedQuery<Produit> queryM = em.createQuery("SELECT p FROM Produit p", Produit.class);
		List<Produit> produits = queryM.getResultList();
		return produits;
	}

}
