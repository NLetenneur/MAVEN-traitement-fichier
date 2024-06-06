package services;

import java.util.HashSet;
import java.util.List;

import entites.Allergene;
import entites.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AllergeneService {

	public static void ajouterAllergenes(String[] tab, Produit prod) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
		EntityManager em = emf.createEntityManager();
		
		String allergene = tab[28];
		String[] tabAll = allergene.split(",", -1);
		HashSet<Allergene> allergenes = new HashSet<Allergene>();
		for (int i = 0; i < tabAll.length; i++) {
			if (!tabAll[i].isEmpty()) {
				List<Allergene> listeAll = extractingAllergenes(em);
				if (!isTheAllergeneInDataBase(listeAll, tabAll[i])) {
					Allergene all = new Allergene(tabAll[i]);
					em.persist(all);
					allergenes.add(all);
				} else {
					TypedQuery<Allergene> query = em
							.createQuery("SELECT al FROM Allergene al WHERE al.libelle=" + tabAll[i], Allergene.class);
					int idAll = query.getSingleResult().getId();
					allergenes.add(findOneAllergene(idAll));
				}
			}

		}
		prod.setAllergenes(allergenes);

	}

	private static Allergene findOneAllergene(int idAll) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Allergene> query = em.createQuery("SELECT al FROM Allergene al WHERE al.id=" + idAll,
				Allergene.class);
		Allergene allergene = query.getSingleResult();
		return allergene;
	}

	private static boolean isTheAllergeneInDataBase(List<Allergene> listeAll, String string) {
		for (Allergene item : listeAll) {
			if (item.getLibelle() == string) {
				return true;
			}
		}
		return false;
	}

	private static List<Allergene> extractingAllergenes(EntityManager em) {
		TypedQuery<Allergene> query = em.createQuery("SELECT al FROM Allergene al", Allergene.class);
		List<Allergene> allergenes = query.getResultList();
		return allergenes;
	}

}
