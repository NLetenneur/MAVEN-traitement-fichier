package entites;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "allergene")
public class Allergene {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String libelle;
	@ManyToMany
	@JoinTable(name="produit_allergene", joinColumns = { @JoinColumn(name = "id_produit") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_allergene") } )
	private Set<Produit> produits = new HashSet<>();

	/**
	 * Constructor
	 * 
	 * @param libelle
	 */
	public Allergene(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Constructor jpa
	 * 
	 */
	public Allergene() {
	}

	@Override
	public String toString() {
		return "Allergene [id=" + id + ", libelle=" + libelle + "]";
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
