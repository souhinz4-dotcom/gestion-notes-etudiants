import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lecture {
    private Scanner scanner;
    private boolean fichierValide = false;
    private ArrayList<Etudiant> donnes_etudiants = new ArrayList<>();

    public Lecture(String nomFichier) {
        try {
            File fichier = new File(nomFichier);
            scanner = new Scanner(fichier);
            fichierValide = true;

        } catch (FileNotFoundException e) {
            System.out.println("Fichier introuvable : " + nomFichier);
        }
    }

    public void lireFichier() {
        if (!fichierValide) {
            System.out.println("Aucun fichier à lire.");
            return;
        }

        boolean premiereLigne = true; // pour sauter l'entête CSV

        while (scanner.hasNextLine()) {
            String ligne = scanner.nextLine();

            // Sauter la ligne d'entête
            if (premiereLigne) {
                premiereLigne = false;
                continue;
            }

            // Séparer les colonnes par la virgule
            String[] colonnes = ligne.split(",");

            String nom    = colonnes[0];
            String prenom = colonnes[1];

            // Récupérer toutes les notes dynamiquement
            double[] notes = new double[colonnes.length - 2];
            for (int i = 2; i < colonnes.length; i++) {
                notes[i - 2] = Double.parseDouble(colonnes[i]);
            }

            Etudiant e = new Etudiant(nom, prenom, notes);
            donnes_etudiants.add(e);
        }
        scanner.close();
    }

    public ArrayList<Etudiant> getDonnesEtudiants() {
        return donnes_etudiants;
    }
}