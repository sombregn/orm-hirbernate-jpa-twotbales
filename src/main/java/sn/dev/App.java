package sn.dev;

import sn.dev.config.HibernateUtil;
import sn.dev.dao.ClasseImpl;
import sn.dev.dao.EtudiantImpl;
import sn.dev.dao.IClasse;
import sn.dev.dao.IEtudiant;
import sn.dev.entities.Classe;
import sn.dev.entities.Etudiant;
import sn.dev.entities.Genre;

public class App {
    public static void main(String[] args) {
        //Pour generer la BD en instanciant la classe HibernateUtil
        //HibernateUtil.getSessionFactory();
       IClasse classeDao = new ClasseImpl();
       IEtudiant etudiantDao = new EtudiantImpl();

        /*/Add Classe
        Classe classe = new Classe();
        classe.setLibelle("L3IAGE");
        int ok = classeDao.create(classe);
        if (ok == 1)
            System.out.println("OK");
        else
            System.out.println("KO");
        */
        /*/List of classes
        classeDao.getAll().forEach(
                cl -> {
                    System.out.println("************************");
                     System.out.println("ID : " + cl.getId());
                    System.out.println("NOM : " + cl.getLibelle());
                    System.out.println("EFFECTIF : " + cl.getEffectif());
                }
        );
        */
        /*/Upade Classe
        Classe classe = classeDao.get(3);
        classe.setLibelle("RI");
        classe.setEffectif(5);
        int ok = classeDao.update(classe);
        if (ok == 1)
            System.out.println("OK");
        else
            System.out.println("KO");
        */
        /*/Delete Classe
        int ok = classeDao.delete(3);
        if(ok == 1)
            System.out.println("OK");
        else
            System.out.println("KO");
        //Get by Id clase
        */

        //Etudiant CRUD Operation
        /*/Add Etudiant
        Etudiant etudiant = new Etudiant();
        etudiant.setGenre(Genre.FEMININ);
        etudiant.setMatricule("00221ISI6");
        etudiant.setNom("Balde");
        etudiant.setPrenom("Bouba");
        etudiant.setClasse(classeDao.get(2));
        int ok = etudiantDao.create(etudiant);
        if (ok == 1)
            System.out.println("OK");
        else
            System.out.println("KO");
        */
        /*/List of Etudiants
        etudiantDao.getAll().forEach(
                etudiant -> {
                    System.out.println("************************");
                    System.out.println("Matricule:" +etudiant.getMatricule());
                    System.out.println("Nom:" +etudiant.getNom());
                    System.out.println("Prenom:" +etudiant.getPrenom());
                    System.out.println("Genre:" +etudiant.getGenre());
                    System.out.println("Genre:" +etudiant.getClasse().getLibelle());
                }
        );
        */
        /*/ Obtenez un étudiant par son ID
        int etudiantId = 1; // ID de l'étudiant à obtenir
        Etudiant etudiantById = etudiantDao.get(etudiantId);
        if (etudiantById != null)
            System.out.println("Etudiant avec l'ID " + etudiantId + " : " + etudiantById.getNom() + " " + etudiantById.getPrenom());
        else
            System.out.println("Aucun étudiant trouvé avec l'ID " + etudiantId);
        */
        /*/Update Etudiants
        Etudiant etudiant = etudiantDao.get(1);
        etudiant.setMatricule("0221ISI6");
        etudiant.setNom("Diallo");
        etudiant.setPrenom("Fatoumata");
        etudiant.setGenre(Genre.FEMININ);
        etudiant.setClasse(classeDao.get(1));
        int ok = etudiantDao.update(etudiant);
        if (ok == 1)
            System.out.println("OK");
        else
            System.out.println("KO");
        */
        //Delete Etudiants
        int etudiantToDeleteId = 5; // ID de l'étudiant à supprimer
        int ok = etudiantDao.delete(etudiantToDeleteId);
        if (ok == 1)
            System.out.println("Etudiant supprimé avec succès !");
        else
            System.out.println("Erreur lors de la suppression de l'étudiant.");
    }
}
