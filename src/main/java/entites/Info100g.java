package entites;

import jakarta.persistence.Embeddable;

@Embeddable
public class Info100g {
	protected double energie;
	protected double graisse;
	protected double sucres;
	protected double fibres;
	protected double proteines;
	protected double sel;
	protected double vitA;
	protected double vitD;
	protected double vitE;
	protected double vitK;
	protected double vitC;
	protected double vitB1;
	protected double vitB2;
	protected double vitPP;
	protected double vitB6;
	protected double vitB9;
	protected double vitB12;
	protected double calcium;
	protected double magnesium;
	protected double iron;
	protected double fer;
	protected double betaCarotene;
	/** Constructor
	 * It's empty by design since all the attributes are optional
	 */
	public Info100g() {
	}
	/** Getter pour energie
	 * @return energie
	 */
	public double getEnergie() {
		return energie;
	}
	/**Setter pour energie
	 * @param energie energie 
	 */
	public void setEnergie(double energie) {
		this.energie = energie;
	}
	/** Getter pour graisse
	 * @return graisse
	 */
	public double getGraisse() {
		return graisse;
	}
	/**Setter pour graisse
	 * @param graisse graisse 
	 */
	public void setGraisse(double graisse) {
		this.graisse = graisse;
	}
	/** Getter pour sucres
	 * @return sucres
	 */
	public double getSucres() {
		return sucres;
	}
	/**Setter pour sucres
	 * @param sucres sucres 
	 */
	public void setSucres(double sucres) {
		this.sucres = sucres;
	}
	/** Getter pour fibres
	 * @return fibres
	 */
	public double getFibres() {
		return fibres;
	}
	/**Setter pour fibres
	 * @param fibres fibres 
	 */
	public void setFibres(double fibres) {
		this.fibres = fibres;
	}
	/** Getter pour proteines
	 * @return proteines
	 */
	public double getProteines() {
		return proteines;
	}
	/**Setter pour proteines
	 * @param proteines proteines 
	 */
	public void setProteines(double proteines) {
		this.proteines = proteines;
	}
	/** Getter pour sel
	 * @return sel
	 */
	public double getSel() {
		return sel;
	}
	/**Setter pour sel
	 * @param sel sel 
	 */
	public void setSel(double sel) {
		this.sel = sel;
	}
	/** Getter pour vitA
	 * @return vitA
	 */
	public double getVitA() {
		return vitA;
	}
	/**Setter pour vitA
	 * @param vitA vitA 
	 */
	public void setVitA(double vitA) {
		this.vitA = vitA;
	}
	/** Getter pour vitD
	 * @return vitD
	 */
	public double getVitD() {
		return vitD;
	}
	/**Setter pour vitD
	 * @param vitD vitD 
	 */
	public void setVitD(double vitD) {
		this.vitD = vitD;
	}
	/** Getter pour vitE
	 * @return vitE
	 */
	public double getVitE() {
		return vitE;
	}
	/**Setter pour vitE
	 * @param vitE vitE 
	 */
	public void setVitE(double vitE) {
		this.vitE = vitE;
	}
	/** Getter pour vitK
	 * @return vitK
	 */
	public double getVitK() {
		return vitK;
	}
	/**Setter pour vitK
	 * @param vitK vitK 
	 */
	public void setVitK(double vitK) {
		this.vitK = vitK;
	}
	/** Getter pour vitC
	 * @return vitC
	 */
	public double getVitC() {
		return vitC;
	}
	/**Setter pour vitC
	 * @param vitC vitC 
	 */
	public void setVitC(double vitC) {
		this.vitC = vitC;
	}
	/** Getter pour vitB1
	 * @return vitB1
	 */
	public double getVitB1() {
		return vitB1;
	}
	/**Setter pour vitB1
	 * @param vitB1 vitB1 
	 */
	public void setVitB1(double vitB1) {
		this.vitB1 = vitB1;
	}
	/** Getter pour vitB2
	 * @return vitB2
	 */
	public double getVitB2() {
		return vitB2;
	}
	/**Setter pour vitB2
	 * @param vitB2 vitB2 
	 */
	public void setVitB2(double vitB2) {
		this.vitB2 = vitB2;
	}
	/** Getter pour vitPP
	 * @return vitPP
	 */
	public double getVitPP() {
		return vitPP;
	}
	/**Setter pour vitPP
	 * @param vitPP vitPP 
	 */
	public void setVitPP(double vitPP) {
		this.vitPP = vitPP;
	}
	/** Getter pour vitB6
	 * @return vitB6
	 */
	public double getVitB6() {
		return vitB6;
	}
	/**Setter pour vitB6
	 * @param vitB6 vitB6 
	 */
	public void setVitB6(double vitB6) {
		this.vitB6 = vitB6;
	}
	/** Getter pour vitB9
	 * @return vitB9
	 */
	public double getVitB9() {
		return vitB9;
	}
	/**Setter pour vitB9
	 * @param vitB9 vitB9 
	 */
	public void setVitB9(double vitB9) {
		this.vitB9 = vitB9;
	}
	/** Getter pour vitB12
	 * @return vitB12
	 */
	public double getVitB12() {
		return vitB12;
	}
	/**Setter pour vitB12
	 * @param vitB12 vitB12 
	 */
	public void setVitB12(double vitB12) {
		this.vitB12 = vitB12;
	}
	/** Getter pour calcium
	 * @return calcium
	 */
	public double getCalcium() {
		return calcium;
	}
	/**Setter pour calcium
	 * @param calcium calcium 
	 */
	public void setCalcium(double calcium) {
		this.calcium = calcium;
	}
	/** Getter pour magnesium
	 * @return magnesium
	 */
	public double getMagnesium() {
		return magnesium;
	}
	/**Setter pour magnesium
	 * @param magnesium magnesium 
	 */
	public void setMagnesium(double magnesium) {
		this.magnesium = magnesium;
	}
	/** Getter pour iron
	 * @return iron
	 */
	public double getIron() {
		return iron;
	}
	/**Setter pour iron
	 * @param iron iron 
	 */
	public void setIron(double iron) {
		this.iron = iron;
	}
	/** Getter pour fer
	 * @return fer
	 */
	public double getFer() {
		return fer;
	}
	/**Setter pour fer
	 * @param fer fer 
	 */
	public void setFer(double fer) {
		this.fer = fer;
	}
	/** Getter pour betaCarotene
	 * @return betaCarotene
	 */
	public double getBetaCarotene() {
		return betaCarotene;
	}
	/**Setter pour betaCarotene
	 * @param betaCarotene betaCarotene 
	 */
	public void setBetaCarotene(double betaCarotene) {
		this.betaCarotene = betaCarotene;
	}
	
	



}
