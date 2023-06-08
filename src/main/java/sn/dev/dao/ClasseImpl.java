package sn.dev.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sn.dev.config.HibernateUtil;
import sn.dev.entities.Classe;

import java.util.List;

public class ClasseImpl implements IClasse{
    private Session session;
    private Transaction transaction;
    public ClasseImpl(){
        session = HibernateUtil.getSessionFactory().openSession();
    }
    @Override
    public int create(Classe classe) {
        int ok = 0;
        try {
            transaction = session.beginTransaction();
            session.save(classe);
            transaction.commit();
            ok = 1 ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<Classe> getAll() {
        return session.createCriteria(Classe.class).list();
    }

    @Override
    public Classe get(int id) {
        return session.get(Classe.class,id);
    }

    @Override
    public int update(Classe classe) {
        int ok = 0;
        try {
            transaction = session.beginTransaction();
            session.merge(classe);
            transaction.commit();
            ok = 1 ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public int delete(int id) {
        int ok = 0;
        try {
            transaction = session.beginTransaction();
            session.delete(get(id));
           // session.delete(session.get(Classe.class,id));
            transaction.commit();
            ok = 1 ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }
}
