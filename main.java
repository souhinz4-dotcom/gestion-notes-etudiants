import java.util.Scanner;

public class main {
    static void main() {
        Scanner saisie = new Scanner(System.in);
        System.out.println("Entrez le nom du fichier : ");

        String nomFichier = saisie.nextLine();

        Lecture lecture = new Lecture(nomFichier);
        lecture.lireFichier();

        saisie.close();

    }
}
