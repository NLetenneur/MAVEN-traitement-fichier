package entites;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String libelle;
	@OneToMany(mappedBy = "categorie")
	private Set<Produit> produits = new HashSet<>();

	/**
	 * Constructor
	 * 
	 * @param libelle
	 */
	public Categorie(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Constructor jpa
	 * 
	 */
	public Categorie() {
	}
	
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", libelle=" + libelle + "]";
	}
	

	

	/**
	 * Getter pour id
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter pour id
	 * 
	 * @param id id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter pour libelle
	 * 
	 * @return libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Setter pour libelle
	 * 
	 * @param libelle libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
