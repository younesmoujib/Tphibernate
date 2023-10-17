/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.entites.Produit;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hp
 */
public class ProduitService implements IDao<Produit> {

    @Override
    public boolean create(Produit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean delete(Produit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean update(Produit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Produit> findAll(Produit o) {
        List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = session.createQuery("from Produit").list();
            tx.commit();
            return produits;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return produits;
        } finally {
            if(session != null)
                session.close();
        }
    }

    @Override
    public Produit findById(int id) {
        Produit produit = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produit = (Produit) session.get(Produit.class, id);
            session.persist(produit);
            tx.commit();
            return produit;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return produit;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public List<Produit> findProduct(String dateS,String dateF) throws ParseException{
        List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        try{
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         Date startDate = dateFormat.parse(dateS);
         Date endDate = dateFormat.parse(dateF);
        Query query = session.createQuery("FROM Produit p WHERE p.date_Achat BETWEEN :startDate AND :endDate");

        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        produits =query.list();
        tx.commit();
        return produits;
        }catch(HibernateException ex){
            if(tx != null){
                tx.rollback();
            }
            ex.printStackTrace(); 
            return produits;
        }finally{
            if(session !=null){
                session.close();
            }
        }
        
        
    }
    /* public List<Produit> findProduct(String dateS, String dateF) {
        List<Produit> produits = null;
        EntityManager entityManager = null;
        try {
            entityManager = Persistence.createEntityManagerFactory("votreUniteDePersistance").createEntityManager();
            

            TypedQuery<Produit> query = entityManager.createQuery(
                "SELECT p FROM Produit p WHERE p.date_Achat BETWEEN :dateS AND :dateF", Produit.class);
            query.setParameter("dateS", dateS);
            query.setParameter("dateF", dateF);
            
            produits = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return produits;
    }
*/
      public List<Produit> finddProduct() {
        List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        try{
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
  
        Query query = session.createQuery("FROM Produit p WHERE p.prix>100");
      
        produits =query.list();
        tx.commit();
        return produits;
        }catch(HibernateException ex){
            if(tx != null){
                tx.rollback();
            }
            ex.printStackTrace(); 
            return produits;
        }finally{
            if(session !=null){
                session.close();
            }
        }
    

}
}


