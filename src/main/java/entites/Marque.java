package entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "marque")
public class Marque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String libelle;
	@OneToMany(mappedBy = "marque")
	private Set<Produit> produits = new HashSet<>();

	/**
	 * Constructor
	 * 
	 * @param libelle
	 */
	public Marque(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Constructor jpa
	 * 
	 */
	public Marque() {
	}
	
	@Override
	public String toString() {
		return "Marque [id=" + id + ", libelle=" + libelle + "]";
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
