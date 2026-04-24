import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner saisie = new Scanner(System.in);

        // Lecture du fichier
        Lecture lecture = null;
        do {
            System.out.print("Entrez le nom du fichier CSV : ");
            String nomFichier = saisie.nextLine().trim();
            lecture = new Lecture(nomFichier);
            lecture.lireFichier();
        } while (!lecture.isFichierValide()); // redemande si fichier invalide

        ArrayList<Etudiant> etudiants = lecture.getDonnesEtudiants();
        Gestion gestion = new Gestion(etudiants);

        boolean quitter = false;

        while (!quitter) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Afficher les noms");
            System.out.println("2. Afficher noms et notes");
            System.out.println("3. Afficher les moyennes");
            System.out.println("4. Trier");
            System.out.println("5. Rechercher un étudiant");
            System.out.println("6. Sauvegarder les résultats");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            String choix = saisie.nextLine().trim();

            switch (choix) {
                case "1":
                    gestion.afficherNoms();
                    break;

                case "2":
                    gestion.afficherNotesEtudiants();
                    break;

                case "3":
                    gestion.afficherMoyennes();
                    break;

                case "4":
                    System.out.println("\n-- Trier par --");
                    System.out.println("1. Nom (alphabétique)");
                    System.out.println("2. Note");
                    System.out.println("3. Moyenne");
                    System.out.print("Votre choix : ");
                    String choixTri = saisie.nextLine().trim();

                    switch (choixTri) {
                        case "1": gestion.trierParNom();     break;
                        case "2": gestion.trierParNote();    break;
                        case "3": gestion.trierParMoyenne(); break;
                        default:  System.out.println("Choix invalide.");
                    }
                    break;

                case "5":
                    System.out.print("Entrez le nom ou prénom : ");
                    String recherche = saisie.nextLine().trim();
                    if (recherche.isEmpty()) {
                        System.out.println("Saisie vide.");
                    } else {
                        gestion.rechercherEtudiant(recherche);
                    }
                    break;

                case "6":
                    System.out.print("Entrez le nom du fichier de sauvegarde (ex: resultats.csv) : ");
                    String nomSauvegarde = saisie.nextLine().trim();
                    if (nomSauvegarde.isEmpty()) {
                        System.out.println("Nom de fichier vide.");
                    } else {
                        gestion.sauvegarderResultats(nomSauvegarde);
                    }
                    break;

                case "0":
                    quitter = true;
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide, entrez un nombre entre 0 et 5.");
            }
        }

        saisie.close();
    }
}