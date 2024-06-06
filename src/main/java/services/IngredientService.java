package services;

import java.util.HashSet;
import java.util.List;

import entites.Ingredient;
import entites.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class IngredientService {

	public static void ajouterIngredients(String[] tab, Produit prod) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
		EntityManager em = emf.createEntityManager();
		
		String ingredients = tab[4];
		String[] tabIng = ingredients.split(",", -1);
		HashSet<Ingredient> setIngredients = new HashSet<Ingredient>();
		for (int i = 0; i < tabIng.length; i++) {
			if (tabIng[i].length() <= 50) {
				List<Ingredient> listeIng = extractingingredients(em);
				if (isTheIngredientInDataBase(listeIng, tabIng[i]) == false) {
					Ingredient ing = new Ingredient(tabIng[i]);
					em.persist(ing);
					setIngredients.add(ing);
				} else {
					TypedQuery<Ingredient> queryI = em
							.createQuery("SELECT i FROM Ingredient i WHERE i.libelle=" + tabIng[i], Ingredient.class);
					int idIng = queryI.getSingleResult().getId();
					setIngredients.add(findOneIngredient(idIng));
				}
			}
		}
		prod.setIngredients(setIngredients);

	}

	private static Ingredient findOneIngredient(int idIng) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Ingredient> queryC = em.createQuery("SELECT i FROM Ingredient i WHERE i.id=" + idIng,
				Ingredient.class);
		Ingredient ingredient = queryC.getSingleResult();
		return ingredient;
	}

	private static boolean isTheIngredientInDataBase(List<Ingredient> listeIng, String string) {
		for (Ingredient item : listeIng) {
			if (item.getLibelle() == string) {
				return true;
			}
		}
		return false;
	}

	private static List<Ingredient> extractingingredients(EntityManager em) {
		TypedQuery<Ingredient> queryI = em.createQuery("SELECT i FROM Ingredient i", Ingredient.class);
		List<Ingredient> ingredients = queryI.getResultList();
		return ingredients;
	}

}
