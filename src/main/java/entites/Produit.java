package entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produit")
public class Produit {
	protected int id;
	protected String libelle;
	protected boolean presenceHuilePalme;
	@ManyToOne
	@JoinColumn(name="ID_Categorie")
	private Categorie categorie;
	@ManyToOne
	@JoinColumn(name="ID_Marque")
	private Marque marque;
	protected String scoreNutritionnel;
	@ManyToMany
	@JoinTable(name="produit_ingredient", joinColumns = { @JoinColumn(name = "id_ingredient") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_produit") } )
	private Set<Ingredient> ingredients = new HashSet<>();
	@ManyToMany
	@JoinTable(name="produit_additifs", joinColumns = { @JoinColumn(name = "id_additif") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_produit") } )
	private Set<Additif> additifs = new HashSet<>();
	@ManyToMany
	@JoinTable(name="produit_allergene", joinColumns = { @JoinColumn(name = "id_allergene") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_produit") } )
	private Set<Allergene> allergenes = new HashSet<>();

	/** Constructor
	 * @param libelle
	 */
	public Produit(String libelle) {
		this.libelle = libelle;
	}

	/** Constructor jpa
	 * 
	 */
	public Produit() {
	}
	
	
	

}
