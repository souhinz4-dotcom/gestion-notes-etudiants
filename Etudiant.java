/**
 * Classe représentant un étudiant avec ses notes.
 * Auteure: Zainabou
 */
public class Etudiant {
    // =====================
    // LES ATTRIBUTS
    // Chaque étudiant a un nom, un prénom, des notes et une moyenne
    // =====================
    private String nom;
    private String prenom;
    private double[] notes;
    private double moyenne;

    // =====================
    // LE CONSTRUCTEUR
    // Quand on crée un étudiant, on lui donne son nom, prénom et ses notes
    // La moyenne se calcule automatiquement
    // =====================
    public Etudiant(String nom, String prenom, double[] notes) {
        this.nom = nom;
        this.prenom = prenom;
        this.notes = notes;
        this.moyenne = calculerMoyenne(); // appel automatique
    }
    // =====================
    // CALCUL DE LA MOYENNE
    // On additionne toutes les notes et on divise par le nombre de notes
    // Exemple : 80 + 90 + 70 = 240 ÷ 3 = 80.0
    // =====================
    private double calculerMoyenne() {
        if (notes == null || notes.length == 0) {
            return 0.0; // si pas de notes, moyenne = 0
        }
        double somme = 0;
        for (double note : notes) {
            somme += note; // on additionne chaque note
        }
        return somme / notes.length; // on divise par le nombre de notes
    }


    // =====================
    // LES GETTERS ET SETTERS
    // Les GETTERS permettent de LIRE les informations de l'étudiant
    // Les SETTERS permettent de MODIFIER les informations de l'étudiant
    public String getNom()      { return nom; }
    public String getPrenom()   { return prenom; }
    public double[] getNotes()  { return notes; }
    public double getMoyenne()  { return moyenne; }

    // =====================
    // toString() (AFFICHAGE)
    // Quand on affiche un étudiant, on voit son prénom, son nom et sa moyenne
    // Exemple : "Aminata Traoré - Moyenne: 84.33"
    // =====================
    @Override
    public String toString() {
        return prenom + " " + nom + " - Moyenne: " + String.format("%.2f", moyenne);
    }


}
