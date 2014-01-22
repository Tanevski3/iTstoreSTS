package com.itstore.services;

import com.itstore.models.User;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class UserService {

    private Session session;
    private Transaction transaction;
    private SessionFactory sessionFactory;
    
    public UserService(){ }
    //check against null to see if user was found!
    public User getUserById(Integer id) {
        
        User user = null;

        this.transaction = null;
        String sqlSelect = "FROM User as user WHERE user.id='" + id+"'";

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query = this.session.createQuery(sqlSelect);
            user = (User) query.uniqueResult();
            this.transaction.commit();
            
        } catch (HibernateException e) {
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }

        return user;
    }
    // returns a list of users - check against null
  public List<User> getAllUsers() {  
        List<User> users = new ArrayList<>();

        this.transaction = null;
        String sqlSelect1 = "from User as user";
        
        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query1 = this.session.createQuery(sqlSelect1);          
            users = query1.list();            
            this.transaction.commit();
        } catch (HibernateException e) {
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
        return users;
    }
   // returns a list of users - check against null
  public List<User> getAllActiveUsers() {  
        List<User> users = new ArrayList<User>();

        this.transaction = null;
        String sqlSelect1 = "from User as user where user.isActive=true";
        
        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query1 = this.session.createQuery(sqlSelect1);          
            users = query1.list();            
            this.transaction.commit();
        } catch (HibernateException e) {
            //TODO
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
        return users;
    }
  //returns false on update failed
  public Boolean updateUser(User user) {
      
      Boolean updated=false;
      if(user==null)
      {
          return updated;
      }
        this.transaction = null;

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            this.session.update(user);
            this.transaction.commit();
            if(this.transaction.wasCommitted())
            {
            updated=true;
            }
            else
            {
            updated=false;
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
  //true returned on success, false returned if user is null or transaction wasn't committed
 public Boolean deleteUser(User user){
     
     Boolean deleted=false;
      if(user==null)
      {
          return deleted;
      }
        this.transaction = null;
        
        
        try{
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            this.session.delete(user);
            this.transaction.commit();
            if(this.transaction.wasCommitted())
            {
            deleted=true;
            }
            else
            {
            deleted=false;
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
        return deleted;
    }
 //true returned on success, false returned if user is null or transaction wasn't committed
 public Boolean deleteUserByUsername(String username){
     
     Boolean deleted=false;
     if(username.isEmpty() || username==null)
     {
         return deleted;
     }
        this.transaction = null;
        User user=null;
        String sqlSelect1 = "delete from User as user where user.username='"+username+"'";
        try{
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
             Query query1 = this.session.createQuery(sqlSelect1);  
             int q=query1.executeUpdate();
            this.transaction.commit();
             if (q!=0) {
                deleted=true;
            }
             else
             {
                 deleted=false;
             }
        }catch (RuntimeException e1){
        }finally{
            this.session.close();
            this.sessionFactory.close();
        }
        return deleted;
    }
 //true returned on success, false returned if user is null or transaction wasn't committed
   public Boolean addUser(User user){
       
       Boolean added=false;
       if(user==null)
      {
          return added;
      }
        this.transaction = null;
 
        try{
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            this.session.save(user);
            this.transaction.commit();
            
            if (this.transaction.wasCommitted()) {
                added=true;
            }
            else
            {
                added=false;
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
    //check against null
    public User findUser(String username,String password) {
        
        User _user = null;

        this.transaction = null;
       // 
        String sqlSelect = "FROM User user WHERE user.username='" + username + "' AND user.password='"+password+"' AND user.isActive=1";

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query = this.session.createQuery(sqlSelect);
            _user = (User) query.uniqueResult();
            this.transaction.commit();
            
        } catch (HibernateException e) {
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
       
                return _user;
    }
    //check against null
    public User findUserByUsername(String username) {
        
        User _user = null;

        this.transaction = null;
       
        
        String sqlSelect = "FROM User as user WHERE user.username='" +username+"'";

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query = this.session.createQuery(sqlSelect);
            _user = (User) query.uniqueResult();
            this.transaction.commit();
            
        } catch (HibernateException e) {
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
       
                return _user;
    }
     //true returned on success, false returned if user is null or transaction wasn't committed
     public Boolean deleteUserById(Integer id){
     
         Boolean deleted=false;
        if(id==null || id==0)
        {
         return deleted;
        }
        this.transaction = null;
        User user=null;
        String sqlSelect1 = "delete from User as user where user.id='"+id+"'";
        try{
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
             Query query1 = this.session.createQuery(sqlSelect1);  
             int q=query1.executeUpdate();
             if (q!=0) {
                deleted=true;
            }
             else
             {
                 deleted=false;
             }
            this.transaction.commit();
        }catch (RuntimeException e1){
        }finally{
            this.session.close();
            this.sessionFactory.close();
        }
        return deleted;
    }
     // check against null
      public String getMD5(final String data) {
    try {
      MessageDigest m = MessageDigest.getInstance("MD5");
      m.reset();
      m.update(data.getBytes());
      BigInteger bigInt = new BigInteger(1, m.digest());
      String hashtext = bigInt.toString(16);
      while(hashtext.length() < 32 ){
          hashtext = "0" + hashtext;
      }
      return hashtext;
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return e.getMessage();
    }
  }
      
}