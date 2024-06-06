
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import services.ProduitService;

public class IntegrationOpenFoodFacts {

	public static void main(String[] args) {
		Path home = Paths.get("C:\\Users\\nlete\\Documents\\Diginamic\\20. Accès base de données avec JPA\\TP\\");
		Path fichierOFF = home.resolve("./open-food-factsMini.csv");
		boolean exists = Files.exists(fichierOFF);

		if (exists) {
			try {
				List<String> lines = Files.readAllLines(fichierOFF, StandardCharsets.UTF_8);
				Iterator<String> iterator = lines.iterator();
				while (iterator.hasNext()) {
					String ligneCourante = iterator.next();
					String[] tab = ligneCourante.split("\\|", -1);

					// tester que la ligne fait la bonne taille
					if (tab.length == 31) {
						ProduitService.enregistrerNouveauProduitDepuisFichier(tab);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
