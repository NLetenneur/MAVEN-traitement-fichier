package services;

import entites.Info100g;
import entites.Produit;

public class Info100gService {

	public static void ajouterInfo100g(String[] tab, Produit prod) {
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

		
	}

}
