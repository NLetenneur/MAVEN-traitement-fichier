package entites;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produit")
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String libelle;
	protected boolean presenceHuilePalme;
	@ManyToOne
	@JoinColumn(name = "ID_Categorie")
	private Categorie categorie;
	@ManyToOne
	@JoinColumn(name = "ID_Marque")
	private Marque marque;
	protected String scoreNutritionnel;
	@ManyToMany
	@JoinTable(name = "produit_ingredient", joinColumns = {
			@JoinColumn(name = "id_ingredient") }, inverseJoinColumns = { @JoinColumn(name = "id_produit") })
	private Set<Ingredient> ingredients = new HashSet<>();
	@ManyToMany
	@JoinTable(name = "produit_additifs", joinColumns = { @JoinColumn(name = "id_additif") }, inverseJoinColumns = {
			@JoinColumn(name = "id_produit") })
	private Set<Additif> additifs = new HashSet<>();
	@ManyToMany
	@JoinTable(name = "produit_allergene", joinColumns = { @JoinColumn(name = "id_allergene") }, inverseJoinColumns = {
			@JoinColumn(name = "id_produit") })
	private Set<Allergene> allergenes = new HashSet<>();
	@Embedded
	protected Info100g info100g;

	/**
	 * Constructor
	 * 
	 * @param libelle
	 */
	public Produit(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Constructor jpa
	 * 
	 */
	public Produit() {
	}

	@Override
	public String toString() {
		String produit = "id=" + id + ", libelle=" + libelle + ", presenceHuilePalme=" + presenceHuilePalme;
		if (categorie != null) {
			produit += ", categorie=" + categorie;
		}
		if (marque != null) {
			produit += ", marque=" + marque;
		}
		if (scoreNutritionnel != null) {
			produit += ", scoreNutritionnel=" + scoreNutritionnel;
		}
		if (ingredients != null) {
			produit += ", ingredients=" + ingredients;
		}
		if (additifs != null) {
			produit += ", additifs=" + additifs;
		}
		if (allergenes != null) {
			produit += ", allergenes=" + allergenes;
		}
		if (info100g != null) {
			produit += ", info100g=" + info100g;
		}
		return produit;
	}

	/** Getter pour id
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**Setter pour id
	 * @param id id 
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter pour libelle
	 * @return libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**Setter pour libelle
	 * @param libelle libelle 
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/** Getter pour presenceHuilePalme
	 * @return presenceHuilePalme
	 */
	public boolean isPresenceHuilePalme() {
		return presenceHuilePalme;
	}

	/**Setter pour presenceHuilePalme
	 * @param presenceHuilePalme presenceHuilePalme 
	 */
	public void setPresenceHuilePalme(boolean presenceHuilePalme) {
		this.presenceHuilePalme = presenceHuilePalme;
	}

	/** Getter pour categorie
	 * @return categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**Setter pour categorie
	 * @param categorie categorie 
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/** Getter pour marque
	 * @return marque
	 */
	public Marque getMarque() {
		return marque;
	}

	/**Setter pour marque
	 * @param marque marque 
	 */
	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	/** Getter pour scoreNutritionnel
	 * @return scoreNutritionnel
	 */
	public String getScoreNutritionnel() {
		return scoreNutritionnel;
	}

	/**Setter pour scoreNutritionnel
	 * @param scoreNutritionnel scoreNutritionnel 
	 */
	public void setScoreNutritionnel(String scoreNutritionnel) {
		this.scoreNutritionnel = scoreNutritionnel;
	}

	/** Getter pour ingredients
	 * @return ingredients
	 */
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	/**Setter pour ingredients
	 * @param ingredients ingredients 
	 */
	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	/** Getter pour additifs
	 * @return additifs
	 */
	public Set<Additif> getAdditifs() {
		return additifs;
	}

	/**Setter pour additifs
	 * @param additifs additifs 
	 */
	public void setAdditifs(Set<Additif> additifs) {
		this.additifs = additifs;
	}

	/** Getter pour allergenes
	 * @return allergenes
	 */
	public Set<Allergene> getAllergenes() {
		return allergenes;
	}

	/**Setter pour allergenes
	 * @param allergenes allergenes 
	 */
	public void setAllergenes(Set<Allergene> allergenes) {
		this.allergenes = allergenes;
	}

	/** Getter pour info100g
	 * @return info100g
	 */
	public Info100g getInfo100g() {
		return info100g;
	}

	/**Setter pour info100g
	 * @param info100g info100g 
	 */
	public void setInfo100g(Info100g info100g) {
		this.info100g = info100g;
	}
	
	

}
