package services;

import java.util.HashSet;
import java.util.List;

import entites.Additif;
import entites.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AdditifService {

	public static void ajouterAdditifs(String[] tab, Produit prod) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
		EntityManager em = emf.createEntityManager();
		String additifs = tab[29];
		String[] tabAd = additifs.split(",", -1);
		HashSet<Additif> setAdditifs = new HashSet<Additif>();
		for (int i = 0; i < tabAd.length; i++) {
			if (!tabAd[i].isEmpty()) {
				List<Additif> listeAd = extractingAdditifs(em);
				int idAd = 0;
				if (!isTheAdditifInDataBase(listeAd, tabAd[i])) {
					Additif ad = new Additif(tabAd[i]);
					em.persist(ad);
					setAdditifs.add(ad);
				} else {
					TypedQuery<Additif> query = em.createQuery("SELECT ad FROM Additif ad WHERE ad.libelle=" + tabAd[i],
							Additif.class);
					idAd = query.getSingleResult().getId();
					setAdditifs.add(findOneAdditif(idAd));
				}
			}
		}
		prod.setAdditifs(setAdditifs);

	}

	private static Additif findOneAdditif(int idAll) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Additif> query = em.createQuery("SELECT ad FROM Additif ad WHERE ad.id=" + idAll, Additif.class);
		Additif additif = query.getSingleResult();
		return additif;
	}

	private static boolean isTheAdditifInDataBase(List<Additif> listeAd, String string) {
		for (Additif item : listeAd) {
			if (item.getLibelle() == string) {
				return true;
			}
		}
		return false;
	}

	private static List<Additif> extractingAdditifs(EntityManager em) {
		TypedQuery<Additif> query = em.createQuery("SELECT ad FROM Additif ad", Additif.class);
		List<Additif> additifs = query.getResultList();
		return additifs;
	}

}
