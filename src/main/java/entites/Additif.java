package entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "additif")
public class Additif {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String libelle;
	
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
