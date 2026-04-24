public class Etudiant implements Affichable {
    private String nom;
    private String prenom;
    private double[] notes;

    public Etudiant(String nom, String prenom, double[] notes) {
        this.nom = nom;
        this.prenom = prenom;
        this.notes = notes;
    }

    public double calculerMoyenne() {
        double somme = 0;
        for (double note : notes) somme += note;
        return somme / notes.length;
    }

    @Override
    public void afficher() {
        System.out.print(nom + " " + prenom + " | Notes: ");
        for (int i = 0; i < notes.length; i++) {
            System.out.print(notes[i]);
            if (i < notes.length - 1) System.out.print(", ");
        }
        System.out.printf(" | Moyenne: %.2f%n", calculerMoyenne());
    }

    public void afficherNom() {
        System.out.println(nom + " " + prenom);
    }

    public void afficherMoyenne() {
        System.out.printf("%s %s | Moyenne: %.2f%n", nom, prenom, calculerMoyenne());
    }

    public String getNom()     { return nom; }
    public String getPrenom()  { return prenom; }
    public double[] getNotes() { return notes; }
}