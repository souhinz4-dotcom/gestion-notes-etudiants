import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Gestion {
    private ArrayList<Etudiant> etudiants;

    public Gestion(ArrayList<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public void afficherNoms() {
        System.out.println("\n--- Liste des étudiants ---");
        for (Etudiant e : etudiants) e.afficherNom();
    }

    public void afficherNotesEtudiants() {
        System.out.println("\n--- Noms et notes ---");
        for (Etudiant e : etudiants) e.afficher();
    }

    public void afficherMoyennes() {
        System.out.println("\n--- Moyennes ---");
        for (Etudiant e : etudiants) e.afficherMoyenne();
    }

    public void trierParNom() {
        // Tri à bulles sur le nom
        for (int i = 0; i < etudiants.size() - 1; i++) {
            for (int j = 0; j < etudiants.size() - i - 1; j++) {
                if (etudiants.get(j).getNom().compareToIgnoreCase(etudiants.get(j + 1).getNom()) > 0) {
                    Etudiant temp = etudiants.get(j);
                    etudiants.set(j, etudiants.get(j + 1));
                    etudiants.set(j + 1, temp);
                }
            }
        }
        System.out.println("\n--- Triés par nom ---");
        for (Etudiant e : etudiants) e.afficherNom();
    }

    public void trierParNote() {
        // Tri sur la première note
        for (int i = 0; i < etudiants.size() - 1; i++) {
            for (int j = 0; j < etudiants.size() - i - 1; j++) {
                if (etudiants.get(j).getNotes()[0] > etudiants.get(j + 1).getNotes()[0]) {
                    Etudiant temp = etudiants.get(j);
                    etudiants.set(j, etudiants.get(j + 1));
                    etudiants.set(j + 1, temp);
                }
            }
        }
        System.out.println("\n--- Triés par première note (croissant) ---");
        for (Etudiant e : etudiants) e.afficher();
    }

    public void trierParMoyenne() {
        // Tri à bulles sur la moyenne
        for (int i = 0; i < etudiants.size() - 1; i++) {
            for (int j = 0; j < etudiants.size() - i - 1; j++) {
                if (etudiants.get(j).calculerMoyenne() > etudiants.get(j + 1).calculerMoyenne()) {
                    Etudiant temp = etudiants.get(j);
                    etudiants.set(j, etudiants.get(j + 1));
                    etudiants.set(j + 1, temp);
                }
            }
        }
        System.out.println("\n--- Triés par moyenne (croissant) ---");
        for (Etudiant e : etudiants) e.afficherMoyenne();
    }

    public void rechercherEtudiant(String recherche) {
        System.out.println("\n--- Résultat de recherche : " + recherche + " ---");
        boolean trouve = false;
        for (Etudiant e : etudiants) {
            if (e.getNom().equalsIgnoreCase(recherche) || e.getPrenom().equalsIgnoreCase(recherche)) {
                e.afficher();
                trouve = true;
            }
        }
        if (!trouve) System.out.println("Aucun étudiant trouvé pour : " + recherche);
    }

    public void sauvegarderResultats(String nomFichier) {
        try {
            FileWriter writer = new FileWriter(nomFichier);

            writer.write("Nom,Prenom,Moyenne\n");

            for (Etudiant e : etudiants) {
                writer.write(e.getNom() + "," + e.getPrenom() + "," +
                        String.format("%.2f", e.calculerMoyenne()) + "\n");
            }

            writer.close();
            System.out.println("Résultats sauvegardés dans : " + nomFichier);

        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }
}