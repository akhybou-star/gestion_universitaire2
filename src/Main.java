//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
public ArrayList<Enseignant> enseignats = new ArrayList<>();
public ArrayList<Etudiant> etudiants = new ArrayList<>();
Scanner sc = new Scanner(System.in);

void main() {
    int choix;
    do {
        affichageMenu();
        switch (choix = Integer.parseInt(sc.nextLine())) {
            case 1:
                saisieEnseignant();
                break;
            case 2:
                saisieEtudiant();
                break;
            case 3:
                affichageEnseignant();
                break;
            case 4:
                affichageEtudiant();
                break;
            case 5:
                rechercherEtudiant();
                break;
            case 6:
                ajouterNotes();
                break;
            case 7:
                generBulltain();
                break;
            case 8:
                rechercherEnseignant();
                break;
            case 9:
                modifierEnseignat();
            case 10:
                modifierEtudiant();
            default:
                System.out.println("merci d'avoir choisir notre application");
        }
    } while (choix != 7);
}
public void affichageMenu(){
    System.out.println("----------------- Menu Application-----------------");
    System.out.println("veiller choisir l'operqtion aue tu veux fqire");
    System.out.println("1. Saisi Enseignant");
    System.out.println("2. Saisi Etudiant");
    System.out.println("3. affichage Enseignant");
    System.out.println("4. affichage Etudiant");
    System.out.println("5. Rechercher Etudiant");
    System.out.println("6.ajoute Notes");
    System.out.println("7. gener Bulltain");
    System.out.println("8.Rechercher Enseignat");
    System.out.println("9.Modifier Enseignat");
    System.out.println("10.Modifier Etudiant");
    System.out.println("11. Quitter");
}
public void saisieEtudiant(){
    Scanner sc = new Scanner(System.in);
    String matricul, nom, prenom;
    int coninuer = 0;
    System.out.println("-----------saisie Etudiant-------------");
    do {
        System.out.print(" matricul : ");
        nom = sc.nextLine();
        System.out.print("nom: ");
        prenom = sc.nextLine();
        System.out.print(" prenom : ");
        matricul = sc.nextLine();
        Etudiant etd1 = new Etudiant(nom, prenom, matricul);
        etudiants.add(etd1);
        System.out.println("1 pour continuer 0 pour Quitter");
        coninuer = Integer.parseInt(sc.nextLine());
    } while (coninuer == 1);
}
public void saisieEnseignant(){
    Scanner sc = new Scanner(System.in);
    String  nom, prenom, matiere;
    int coninuer = 0;
    System.out.println("----------saisi Enseignant--------------");
    do {
        System.out.print(" nom : ");
        nom = sc.nextLine();
        System.out.print("prenom : ");
        prenom = sc.nextLine();
        System.out.print(" matiere : ");
        matiere = sc.nextLine();
        Enseignant ens1 = new Enseignant(nom, prenom, matiere);
        enseignats.add(ens1);
        System.out.println("1 pour continuer 0 pour Quitter");
        coninuer = Integer.parseInt(sc.nextLine());
    } while (coninuer == 1);
}
public void affichageEtudiant(){
    System.out.println("affichage Etudiant");
    for (Etudiant e : etudiants) {
        System.out.println("---------------------------");
        System.out.println(e);
    }
}
public void affichageEnseignant(){
    System.out.println("affichage Enseignant");
    for (Enseignant e : enseignats) {
        System.out.println("---------------------------");
        System.out.println(e);
    }
}
public Etudiant rechercherparMatricul(){
    Scanner sc =new Scanner(System.in);
    System.out.println("Donnez le matricul que vous chercher");
    String matricul  = sc.nextLine();
    boolean trouve = false;
    for (Etudiant etudiant:etudiants){

        if (etudiant.getMatricul().equals(matricul)){
            return etudiant;

        }
    }
    return null;
}
public void rechercherEtudiant(){
    Etudiant e = rechercherparMatricul();
    if (e == null){
        System.out.println("l'etudiant n'exist pas");
    }
    else{
        System.out.println(e);
    }
}
public void ajouterNotes(){
    Scanner sc = new Scanner(System.in);
    String matiers;
    double valeur;
    int continuer= 0;
    Etudiant e = rechercherparMatricul();
    if (e == null){
        System.out.println("Etudiant introuvable");
    }
    else {
        do {
            System.out.println("matier");
            matiers = sc.nextLine();
            System.out.println("valeur");
            valeur = Double.parseDouble(sc.nextLine());
            Note n = new Note(matiers,valeur);
            e.ajoudeNotes(n);
            System.out.println("1 pour continuer 0 pour Quiter");
            continuer = Integer.parseInt(sc.nextLine());
        }while (continuer == 1);
        System.out.println("----------Fin SAISE NOTE---------");
    }
}
public void generBulltain(){
    String matricul;
    System.out.print("Matricul : ");
    matricul = sc.nextLine();
    Etudiant e = rechercherparMatricul();
    if (e == null){
        System.out.println("imposable de gener le bulltin : "+matricul+"inexistante");
    }
    else {

    }

}
public Enseignant rechercherparnom(){
    Scanner sc =new Scanner(System.in);
    System.out.println("Donnez le nom que vous chercher");
    String nom  = sc.nextLine();
    boolean trouve = false;
    for (Enseignant enseignant:enseignats){

        if (enseignant.getNom().equals(nom)){
            return enseignant;

        }
    }
    return null;
}
public void rechercherEnseignant(){
    Enseignant e = rechercherparnom();
    if (e == null){
        System.out.println("l'enseignant n'exist pas");
    }
    else{
        System.out.println(e);
    }
}
public void modifierEnseignat(){
    int continuer = 0;
    String nouveauPrenom,nouveauNom,nouveauMatiere;
    System.out.println("Nom a rechercher : ");
    String nom = sc.nextLine();
    Enseignant enseignant = rechercherparnom();
    if (enseignant == null){
        System.out.println(nom + "est inexistant");
    }else {
        do {
            System.out.println("donnez le nouveau nom : ");
            nouveauNom = sc.nextLine();
            System.out.println("donnez le nouveau prenom : ");
            nouveauPrenom = sc.nextLine();
            System.out.println("donnez le nouveau matier : ");
            nouveauMatiere = sc.nextLine();
            enseignant.setNom(nouveauPrenom);
            enseignant.setPrenom(nouveauNom);
            enseignant.setMatiere(nouveauMatiere);
            System.out.println("Enseignant modifier avec succes !!!!! ");
            System.out.println(enseignant);
            System.out.println("Cliquer 1 pour continuer 0 pour Quitter");
            continuer = Integer.parseInt(sc.nextLine());
        }while (continuer == 1);
    }
}

public void modifierEtudiant(){
    int continuer = 0;
    String nouveauPrenom,nouveauNom;
    double nouveauMatricule;
    System.out.println("Matricule a rechercher : ");
    String matricul = sc.nextLine();
    Etudiant etudiant = rechercherparMatricul();
    if (etudiant == null) {
        System.out.println(matricul + "est inexistant");
    }else {
        do {
            System.out.println("donnez le nouveau prenom : ");
            nouveauPrenom = sc.nextLine();
            System.out.println("donnez le nouveau nom : ");
            nouveauNom = sc.nextLine();
            etudiant.setPrenom(nouveauNom);
            etudiant.setNom(nouveauPrenom);
            System.out.println("Etudiant modifier avec succes !!!!! ");
            System.out.println(etudiant);
            System.out.println("Cliquer 1 pour continuer 0 pour Quitter");
            continuer = Integer.parseInt(sc.nextLine());
        }while (continuer == 1);
    }
}
