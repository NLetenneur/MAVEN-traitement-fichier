package services;

import java.util.List;

import entites.Categorie;
import entites.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class CategorieService {

	public static void ajouterCategorie(String[] tab, Produit prod) {
		String categorie = tab[0];
		int idCategorie = 0;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
		EntityManager em = emf.createEntityManager();
		List<Categorie> categories = extractingCategories(em);
		if (!isTheCategorieInDataBase(categories, categorie)) {
			Categorie cat = new Categorie(categorie);
			em.persist(cat);
			prod.setCategorie(cat);
		} else {
			TypedQuery<Categorie> queryC = em.createQuery(
					"SELECT c FROM Categorie c WHERE c.libelle=" + categorie, Categorie.class);
			idCategorie = queryC.getSingleResult().getId();
			prod.setCategorie(findOneCategorie(idCategorie));
		}
		
	}
	private static boolean isTheCategorieInDataBase(List<Categorie> categories, String categorie) {
		for (Categorie item : categories) {
			if (item.getLibelle() == categorie) {
				return true;
			}
		}
		return false;
	}
	
	private static List<Categorie> extractingCategories(EntityManager em) {
		TypedQuery<Categorie> queryC = em.createQuery("SELECT c FROM Categorie c", Categorie.class);
		List<Categorie> categories = queryC.getResultList();
		return categories;
	}

	private static Categorie findOneCategorie(int idCategorie) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Categorie> queryC = em.createQuery("SELECT c FROM Categorie c WHERE c.id=" + idCategorie,
				Categorie.class);
		Categorie categorie = queryC.getSingleResult();
		return categorie;
	}

}
