
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import entites.Additif;
import entites.Allergene;
import entites.Categorie;
import entites.Info100g;
import entites.Ingredient;
import entites.Marque;
import entites.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class IntegrationOpenFoodFacts {

	public static void main(String[] args) throws IOException {
		Path home = Paths.get("C:\\Users\\nlete\\Documents\\Diginamic\\20. Accès base de données avec JPA\\TP\\");
		Path fichierOFF = home.resolve("./open-food-factsMini.csv");
		boolean exists = Files.exists(fichierOFF);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		if (exists) {
//			try {
			List<String> lines = Files.readAllLines(fichierOFF, StandardCharsets.UTF_8);
			Iterator<String> iterator = lines.iterator();
			while (iterator.hasNext()) {
				String ligneCourante = iterator.next();
				String[] tab = ligneCourante.split("\\|", -1);

				// tester que la ligne fait la bonne taille
				if (tab.length == 31) {
					transaction.begin();
					String nom = tab[2];
					List<Produit> produits = extractingProduits(em);

					// vérifier que le produit n'est pas encore dans la base.
					if (!isTheProduitInDataBase(produits, nom)) {
						Produit prod = new Produit(nom);

						// ajouter la catégorie
						String categorie = tab[0];
						int idCategorie = 0;
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

						// ajouter la marque
						String marque = tab[1];
						List<Marque> marques = extractingMarques(em);
						if (isTheMarqueInDataBase(marques, marque) == false) {
							Marque mar = new Marque(marque);
							em.persist(mar);
							prod.setMarque(mar);
						} else {
							TypedQuery<Marque> queryM = em
									.createQuery("SELECT m FROM Marque c WHERE m.libelle=" + marque, Marque.class);
							int idMarque = queryM.getSingleResult().getId();
							prod.setMarque(findOneMarque(idMarque));
						}

						// ajouter le nutriscore
						String nutriGradeFr = tab[3];
						prod.setScoreNutritionnel(nutriGradeFr);

						// ajouter les ingrédients
						String ingredients = tab[4];
						String[] tabIng = ingredients.split(",", -1);
						HashSet<Ingredient> setIngredients = new HashSet<Ingredient>();
						for (int i = 0; i < tabIng.length; i++) {
							if (tabIng[i].length() <=50) {
								List<Ingredient> listeIng = extractingingredients(em);
								if (isTheIngredientInDataBase(listeIng, tabIng[i]) == false) {
									Ingredient ing = new Ingredient(tabIng[i]);
									em.persist(ing);
									setIngredients.add(ing);
								} else {
									TypedQuery<Ingredient> queryI = em.createQuery(
											"SELECT i FROM Ingredient i WHERE i.libelle=" + tabIng[i],
											Ingredient.class);
									int idIng = queryI.getSingleResult().getId();
									setIngredients.add(findOneIngredient(idIng));
								}
							}
						}
						prod.setIngredients(setIngredients);

						// Ajouter les info pour 100g
						Info100g info100g = new Info100g();
						String energie = tab[5];
						if (!energie.isEmpty()) {
							info100g.setEnergie(Double.parseDouble(energie));
						}
						String graisse = tab[6];
						if (!graisse.isEmpty()) {
							info100g.setGraisse(Double.parseDouble(graisse));
						}
						String sucres = tab[7];
						if (!sucres.isEmpty()) {
							info100g.setSucres(Double.parseDouble(sucres));
						}
						String fibres = tab[8];
						if (!fibres.isEmpty()) {
							info100g.setFibres(Double.parseDouble(fibres));
						}
						String proteines = tab[9];
						if (!proteines.isEmpty()) {
							info100g.setProteines(Double.parseDouble(proteines));
						}
						String sel = tab[10];
						info100g.setSel(Double.parseDouble(sel));
						String vitA = tab[11];
						if (!vitA.isEmpty()) {
							info100g.setVitA(Double.parseDouble(vitA));
						}
						String vitD = tab[12];
						if (!vitD.isEmpty()) {
							info100g.setVitD(Double.parseDouble(vitD));
						}
						String vitE = tab[13];
						if (!vitE.isEmpty()) {
							info100g.setVitE(Double.parseDouble(vitE));
						}
						String vitK = tab[14];
						if (!vitK.isEmpty()) {
							info100g.setVitK(Double.parseDouble(vitK));
						}
						String vitC = tab[15];
						if (!vitC.isEmpty()) {
							info100g.setVitC(Double.parseDouble(vitC));
						}
						String vitB1 = tab[16];
						if (!vitB1.isEmpty()) {
							info100g.setVitB1(Double.parseDouble(vitB1));
						}
						String vitB2 = tab[17];
						if (!vitB2.isEmpty()) {
							info100g.setVitB2(Double.parseDouble(vitB2));
						}
						String vitPP = tab[18];
						if (!vitB2.isEmpty()) {
							info100g.setVitPP(Double.parseDouble(vitPP));
						}
						String vitB6 = tab[19];
						if (!vitB6.isEmpty()) {
							info100g.setVitB6(Double.parseDouble(vitB6));
						}
						String vitB9 = tab[20];
						if (!vitB9.isEmpty()) {
							info100g.setVitB9(Double.parseDouble(vitB9));
						}
						String vitB12 = tab[21];
						if (!vitB12.isEmpty()) {
							info100g.setVitB12(Double.parseDouble(vitB12));
						}
						String calcium = tab[22];
						if (!calcium.isEmpty()) {
							info100g.setCalcium(Double.parseDouble(calcium));
						}
						String magnesium = tab[23];
						if (!magnesium.isEmpty()) {
							info100g.setMagnesium(Double.parseDouble(magnesium));
						}
						String iron = tab[24];
						if (!iron.isEmpty()) {
							info100g.setIron(Double.parseDouble(iron));
						}
						String fer = tab[25];
						if (!fer.isEmpty()) {
							info100g.setFer(Double.parseDouble(fer));
						}
						String betaCarotene = tab[26];
						if (!betaCarotene.isEmpty()) {
							info100g.setBetaCarotene(Double.parseDouble(betaCarotene));
						}
						prod.setInfo100g(info100g);

						// ajouter Huile de palme
						String presenceHuilePalme = tab[27];
						if (presenceHuilePalme.equals("0")) {
							prod.setPresenceHuilePalme(false);
						} else {
							prod.setPresenceHuilePalme(true);
						}

						// ajouter allergenes
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
									TypedQuery<Allergene> query = em.createQuery(
											"SELECT al FROM Allergene al WHERE al.libelle=" + tabAll[i],
											Allergene.class);
									int idAll = query.getSingleResult().getId();
									allergenes.add(findOneAllergene(idAll));
								}
							}

						}
						prod.setAllergenes(allergenes);

						// ajouter additifs
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
									TypedQuery<Additif> query = em.createQuery(
											"SELECT ad FROM Additif ad WHERE ad.libelle=" + tabAd[i], Additif.class);
									idAd = query.getSingleResult().getId();
									setAdditifs.add(findOneAdditif(idAd));
								}
							}
						}
						prod.setAdditifs(setAdditifs);
						em.persist(prod);
						transaction.commit();
					} else {

					}
				}
			}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}

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

	private static Marque findOneMarque(int idMarque) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Marque> queryC = em.createQuery("SELECT m FROM Marque m WHERE m.id=" + idMarque, Marque.class);
		Marque marque = queryC.getSingleResult();
		return marque;
	}

	private static Categorie findOneCategorie(int idCategorie) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Categorie> queryC = em.createQuery("SELECT c FROM Categorie c WHERE c.id=" + idCategorie,
				Categorie.class);
		Categorie categorie = queryC.getSingleResult();
		return categorie;
	}

	private static boolean isTheProduitInDataBase(List<Produit> produits, String nom) {
		for (Produit item : produits) {
			if (item.getLibelle() == nom) {
				return true;
			}
		}
		return false;

	}

	private static List<Produit> extractingProduits(EntityManager em) {
		TypedQuery<Produit> queryM = em.createQuery("SELECT p FROM Produit p", Produit.class);
		List<Produit> produits = queryM.getResultList();
		return produits;
	}

	private static List<Marque> extractingMarques(EntityManager em) {
		TypedQuery<Marque> queryM = em.createQuery("SELECT m FROM Marque m", Marque.class);
		List<Marque> marques = queryM.getResultList();
		return marques;
	}

	private static List<Categorie> extractingCategories(EntityManager em) {
		TypedQuery<Categorie> queryC = em.createQuery("SELECT c FROM Categorie c", Categorie.class);
		List<Categorie> categories = queryC.getResultList();
		return categories;
	}

	private static boolean isTheMarqueInDataBase(List<Marque> marques, String marque) {
		for (Marque item : marques) {
			if (item.getLibelle() == marque) {
				return true;
			}
		}
		return false;
	}

	private static boolean isTheCategorieInDataBase(List<Categorie> categories, String categorie) {
		for (Categorie item : categories) {
			if (item.getLibelle() == categorie) {
				return true;
			}
		}
		return false;
	}

}
