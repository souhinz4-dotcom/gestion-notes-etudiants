import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner saisie = new Scanner(System.in);

        System.out.print("Entrez le nom du fichier : ");
        String nomFichier = saisie.nextLine();

        Lecture lecture = new Lecture(nomFichier);
        lecture.lireFichier();

        ArrayList<Etudiant> etudiants = lecture.getDonnesEtudiants();

        // Afficher tous les étudiants avec leur moyenne
        for (Etudiant e : etudiants) {
            e.toString();
        }

        saisie.close();
    }
}