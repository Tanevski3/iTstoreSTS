package com.itstore.services;

import com.itstore.models.Category;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

/**
 *
 * @author Tanevski
 */
public class CategoryService {
    
    private Session session;
    private Transaction transaction;
    private SessionFactory sessionFactory;

    
    //gets all categories
  public List<Category> getAllCategories() {  
      
        List<Category> categories = new ArrayList<>();

        this.transaction = null;
        String sqlSelect1 = "from Category as category";
        
        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query1 = this.session.createQuery(sqlSelect1);          
            categories = query1.list();            
            this.transaction.commit();
        } catch (HibernateException e) {
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
        return categories;
    }
  
   //adds a category 
   public Boolean addCategory(Category category){
       
        Boolean added = false;
        if (category == null) {
            return added;
        }
        this.transaction = null;
 
        try{
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            this.session.save(category);
            this.transaction.commit();
             if (this.transaction.wasCommitted()) {
                added = true;
            } else {
                added = false;
            }
        }catch (RuntimeException e1){
          
            if ((null != this.transaction) && this.transaction.isActive()){
                try{
                    this.transaction.rollback();
                }catch(HibernateException e2){
                    
                }
            }
        }finally{
            this.session.close();
            this.sessionFactory.close();
        }
        
        return added;
    }
   //returns a category object
    public Category findCategoryByName(Integer _name) {
        
        Category _category = null;

        this.transaction = null;
        
        String sqlSelect = "FROM Category as category WHERE category.name='" +_name+"'";

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query = this.session.createQuery(sqlSelect);
            _category = (Category) query.uniqueResult();
            this.transaction.commit();
            
        } catch (HibernateException e) {
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
       
                return _category;
    }
   //returns a category object
    public Category findCategoryById(Integer _id) {
        
        Category _category = null;

        this.transaction = null;
        
        String sqlSelect = "FROM Category as category WHERE category.id='" +_id+"'";

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query = this.session.createQuery(sqlSelect);
            _category = (Category) query.uniqueResult();
            this.transaction.commit();
            
        } catch (HibernateException e) {
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
       
                return _category;
    }
    //removes a category from database by id
    public void deleteCategoryByName(Integer _name){
     
        this.transaction = null;
        Category category=null;
        String sqlSelect1 = "delete from Category as category where category.name='"+_name+"'";
        try{
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
             Query query1 = this.session.createQuery(sqlSelect1);  
             int q=query1.executeUpdate();
             System.out.println(q);
            this.transaction.commit();
        }catch (RuntimeException e1){
        }finally{
            this.session.close();
            this.sessionFactory.close();
        }       
}
    //removes a category from database by id
    public Boolean deleteCategoryById(Integer id){
     
        Boolean deleted = false;
        if (id == null || id==0) {
            return deleted;
        }
        this.transaction = null;
        Category category=null;
        String sqlSelect1 = "delete from Category as category where category.id='"+id+"'";
        try{
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
             Query query1 = this.session.createQuery(sqlSelect1);  
             int q=query1.executeUpdate();
             if (q != 0) {
                deleted = true;
            } else {
                deleted = false;
            }
             System.out.println(q);
            this.transaction.commit();
        }catch (RuntimeException e1){
        }finally{
            this.session.close();
            this.sessionFactory.close();
        }       
        return deleted;
}
    // updates the category
    public Boolean updateCategory(Category category) {
         Boolean updated = false;
        if (category == null) {
            return updated;
        }
        this.transaction = null;

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            this.session.update(category);
            this.transaction.commit();
            if (this.transaction.wasCommitted()) {
                updated = true;
            } else {
                updated = false;
            }
        } catch (RuntimeException e1) {

            if ((null != this.transaction) && this.transaction.isActive()) {
                try {
                    this.transaction.rollback();
                } catch (HibernateException e2) {
                }
            }
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
        return updated;
    }
}
