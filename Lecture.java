import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class Lecture {
    private Scanner scanner;
    private boolean fichierValide =false;
    private ArrayList<String> donnes_etudiants;

    public Lecture(String nomFichier) {
        try {
            File fichier = new File(nomFichier);
            scanner = new Scanner(fichier);
            fichierValide = true;

        } catch (FileNotFoundException e){
            System.out.println("Fichier introuvable : " + nomFichier);
        }
    }

    public void lireFichier(){
        if (!fichierValide) {
            System.out.println("Aucun fichier à lire.");
            return;
        }

        while (scanner.hasNextLine()){
            String ligne = scanner.nextLine();
            donnes_etudiants.add(ligne);
//            System.out.println(ligne);
        }
        scanner.close();
    }

    public ArrayList<String> getDonnes_etudiants() {
        return donnes_etudiants;
    }
}
