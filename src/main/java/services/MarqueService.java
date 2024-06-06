package services;

import java.util.List;

import entites.Marque;
import entites.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class MarqueService {

	public static void ajouterMarque(String[] tab, Produit prod) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
		EntityManager em = emf.createEntityManager();

		String marque = tab[1];
		List<Marque> marques = extractingMarques(em);
		if (isTheMarqueInDataBase(marques, marque) == false) {
			Marque mar = new Marque(marque);
			em.persist(mar);
			prod.setMarque(mar);
		} else {
			TypedQuery<Marque> queryM = em.createQuery("SELECT m FROM Marque c WHERE m.libelle=" + marque,
					Marque.class);
			int idMarque = queryM.getSingleResult().getId();
			prod.setMarque(findOneMarque(idMarque));
		}

	}

	private static List<Marque> extractingMarques(EntityManager em) {
		TypedQuery<Marque> queryM = em.createQuery("SELECT m FROM Marque m", Marque.class);
		List<Marque> marques = queryM.getResultList();
		return marques;
	}

	private static boolean isTheMarqueInDataBase(List<Marque> marques, String marque) {
		for (Marque item : marques) {
			if (item.getLibelle() == marque) {
				return true;
			}
		}
		return false;
	}

	private static Marque findOneMarque(int idMarque) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Marque> queryC = em.createQuery("SELECT m FROM Marque m WHERE m.id=" + idMarque, Marque.class);
		Marque marque = queryC.getSingleResult();
		return marque;
	}

}
