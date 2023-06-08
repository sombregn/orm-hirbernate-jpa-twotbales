package sn.dev.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sn.dev.config.HibernateUtil;
import sn.dev.entities.Classe;
import sn.dev.entities.Etudiant;
import sn.dev.entities.Genre;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EtudiantImpl implements IEtudiant{
    private Session session;
    private Transaction transaction;
    public EtudiantImpl(){
        session = HibernateUtil.getSessionFactory().openSession();
    }
    @Override
    public int create(Etudiant etudiant) {
        int ok = 0 ;
        try {
        transaction = session.beginTransaction();
        session.save(etudiant);
        transaction.commit();
        incrementerEffectif(etudiant.getClasse().getId());
        ok = 1;
        }catch (Exception e){
        e.printStackTrace();
    }
        return ok;
    }

    @Override
    public List<Etudiant> getAll() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Etudiant> criteriaQuery = builder.createQuery(Etudiant.class);
        Root<Etudiant> root = criteriaQuery.from(Etudiant.class);
        criteriaQuery.select(root);
        return session.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Etudiant get(int id) {
        return session.get(Etudiant.class, id);
    }

    @Override
    public int update(Etudiant etudiant) {
        int ok = 0;
        try {
            transaction = session.beginTransaction();
            session.merge(etudiant);
            transaction.commit();
            ok = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public int delete(int id) {
        int ok = 0;
        try {
            transaction = session.beginTransaction();
            Etudiant etudiant = session.get(Etudiant.class, id);
            session.delete(etudiant);
            decrementerEffectif(etudiant.getClasse().getId());
            transaction.commit();
            ok = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }
    private void incrementerEffectif(int classeId) {
        IClasse classeDAO = new ClasseImpl();
        Classe classe = classeDAO.get(classeId);
        classe.setEffectif(classe.getEffectif() + 1);
        classeDAO.update(classe);
    }
    private void decrementerEffectif(int classeId) {
        IClasse classeDAO = new ClasseImpl();
        Classe classe = classeDAO.get(classeId);
        classe.setEffectif(classe.getEffectif() - 1);
        classeDAO.update(classe); 
    }
}
