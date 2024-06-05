
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entites.Categorie;
import entites.Marque;


public class IntegrationOpenFoodFacts {

	public static void main(String[] args) {
		Path home = Paths.get("\"C:\\Users\\nlete\\Documents\\Diginamic\\20. Accès base de données avec JPA\\TP");
		Path fichierOFF = home.resolve("./open-food-facts.csv");
		boolean exists = Files.exists(fichierOFF);
		List<String> listProduits = new ArrayList<>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("movie_db");
		EntityManager em = emf.createEntityManager();
		
		
		if (exists) {
			try {
				List<String> lines = Files.readAllLines(fichierOFF, StandardCharsets.UTF_8);
				Iterator<String> iterator = lines.iterator();
				while (iterator.hasNext()) {
					String ligneCourante = iterator.next();
					String[] tab = ligneCourante.split("|", -1);
					int idCategorie = 0;
					if (tab.length==30) {
						String categorie = tab[0];
						TypedQuery<Categorie> queryC = em.createQuery("SELECT c FROM Categorie c", Categorie.class);
						List<Categorie> categories = queryC.getResultList();
						if(isTheCategorieInDataBase(categories, categorie)==false) {
							Categorie cat = new Categorie(categorie);
							em.persist(cat);
							idCategorie = cat.getId();
						}else {
							queryC = em.createQuery("SELECT c FROM Categorie c WHERE c.libelle="+categorie, Categorie.class);
							idCategorie = queryC.getSingleResult().getId();
						}
						
						String marque = tab[1];
						TypedQuery<Marque> queryM = em.createQuery("SELECT m FROM Marque c", Marque.class);
						List<Marque> marques = queryM.getResultList();
						int idMarque=0;
						if(isTheMarqueInDataBase(marques, marque)==false) {
							Categorie mar = new Categorie(marque);
							em.persist(mar);
							idMarque = mar.getId();
						}else {
							queryM = em.createQuery("SELECT m FROM Marque c WHERE m.libelle="+marque, Marque.class);
							idMarque = queryM.getSingleResult().getId();
						}
						
						String nom = tab[2];
						String nutriGradeFr = tab[3];
						String ingredient = tab[4];
						String energie = tab[5];
						String graisse = tab[6];
						String sucres = tab[7];
						String fibres = tab[8];
						String proteines = tab[9];
						String sel = tab[10];
						String vitA = tab[11];
						String vitD = tab[12];
						String vitE = tab[13];
						String vitK = tab[14];
						String vitC = tab[15];
						String vitB1 = tab[16];
						String vitB2 = tab[17];
						String vitPP = tab[18];
						String vitB6 = tab[19];
						String vitB9 = tab[20];
						String vitB12 = tab[21];
						String calcium = tab[22];
						String magnesium = tab[23];
						String iron = tab[24];
						String fer = tab[25];
						String betaCarotene = tab[26];
						String presenceHuilePalme =tab[27];
						String allergene = tab[28];
						String additifs = tab [29];
											
						
						
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}

	private static boolean isTheMarqueInDataBase(List<Marque> marques, String marque) {
		for (Marque item: marques) {
			if (item.getLibelle()==marque) {
				return true;
			}
			}		return false;
	}

	private static boolean isTheCategorieInDataBase(List<Categorie> categories, String categorie) {
		for (Categorie item: categories) {
			if (item.getLibelle()==categorie) {
				return true;
			}
			}		return false;
	}


}
