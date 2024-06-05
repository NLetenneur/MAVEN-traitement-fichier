package entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "additif")
public class Additif {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String libelle;
	@ManyToMany
	@JoinTable(name="produit_additif", joinColumns = { @JoinColumn(name = "id_produit") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_additif") } )
	private Set<Produit> produits = new HashSet<>();
	
	/** Constructor
	 * @param libelle
	 */
	public Additif(String libelle) {
		this.libelle = libelle;
	}

	/** Constructor jpa
	 * 
	 */
	public Additif() {
	
	}

	@Override
	public String toString() {
		return "Additif [id=" + id + ", libelle=" + libelle + "]";
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
	
	

}
