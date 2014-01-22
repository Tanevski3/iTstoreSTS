package com.itstore.services;

import com.itstore.models.Item;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/*
 * @author Tanevski
 */
public class ItemService {

    private Session session;
    private Transaction transaction;
    private SessionFactory sessionFactory;

    //check against null
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<Item>();

        this.transaction = null;
        String sqlSelect1 = "from Item as item order by postDate desc";

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query1 = this.session.createQuery(sqlSelect1);
            items = query1.list();
            this.transaction.commit();
        } catch (HibernateException e) {
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
        return items;
    }

    //check against null
    public List<Item> getRecommendedItems() {
        List<Item> items = new ArrayList<Item>();

        this.transaction = null;
        String sqlSelect1 = "from Item as item where item.price<100";

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query1 = this.session.createQuery(sqlSelect1);
            query1.setMaxResults(3);
            items = query1.list();
            this.transaction.commit();
        } catch (HibernateException e) {
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
        return items;
    }
    //check against null

    public List<Item> getAllItemsOrderedByPrice(String ascDesc) {
        if (!ascDesc.equals("asc") || !ascDesc.equals("desc")) {
            return null;
        }
        List<Item> items = new ArrayList<Item>();

        this.transaction = null;
        String sqlSelect1 = "from Item as item orderby item.price " + ascDesc;

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query1 = this.session.createQuery(sqlSelect1);
            items = query1.list();
            this.transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
        return items;
    }

    //check against null
    public List<Item> getAllItemsOrderedByTitle(String ascDesc) {
        if (!ascDesc.equals("asc") || !ascDesc.equals("desc")) {
            return null;
        }
        List<Item> items = new ArrayList<Item>();

        this.transaction = null;
        String sqlSelect1 = "from Item as item orderby item.title " + ascDesc;

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query1 = this.session.createQuery(sqlSelect1);
            items = query1.list();
            this.transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
        return items;
    }

    //check against null
    public List<Item> getAllItemsForCategoryOrderedBySearchTitle(String categoryName, String ascDesc, String searchTitle) {
        if (!ascDesc.equals("asc") || !ascDesc.equals("desc")
                || categoryName.isEmpty() || categoryName == null
                || searchTitle.isEmpty() || searchTitle == null) {
            return null;
        }
        List<Item> items = new ArrayList<Item>();

        this.transaction = null;
        String sqlSelect1 = "from Item as item where item.category.name='" + categoryName + "' and item.title like '%" + searchTitle + "%' orderby item.category.name " + ascDesc;

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query1 = this.session.createQuery(sqlSelect1);
            items = query1.list();
            this.transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
        return items;
    }

    //check against null
    public List<Item> getAllItemsOrderedBySearchTitle(String ascDesc, String searchTitle) {
        /* if (!ascDesc.equals("asc") || !ascDesc.equals("desc")
         || searchTitle == null) {
         return null;
         }*/
        List<Item> items = new ArrayList<Item>();

        this.transaction = null;
        String sqlSelect1 = "from Item as item where (item.title like '%" + searchTitle + "%' or item.specification like '%" + searchTitle + "%') or item.description like '%" + searchTitle + "%' order by item.category.name " + ascDesc;

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query1 = this.session.createQuery(sqlSelect1);
            items = query1.list();
            this.transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
        return items;
    }

    //check against null
    public List<Item> getAllQueriedItems(String categoryName, String stock, String part, String orderBy, String ascDesc) {

        /*if (!ascDesc.equals("asc") || !ascDesc.equals("desc")
         || orderBy==null ||orderBy.isEmpty()
         || part==null ||part.isEmpty()
         ||  categoryName == null|| categoryName.isEmpty()
         ||  stock == null|| stock.isEmpty()) {
         return null;
         }*/

        List<Item> items = new ArrayList<Item>();

        this.transaction = null;
        //select * from item as i where i.category_id=6 and ((i.title="SBAI0022" or i.description="SBAI0022") and i.stock>0) order by i.title asc;
        String sqlSelect1 = "from Item as item where item.category.name='" + categoryName + "' "
                + "and (((item.title like '%" + part + "%' or item.description like '%" + part + "%') "
                + "or item.specification like '%" + part + "%') and item.stock>'" + stock + "')"
                + " order by item." + orderBy + " " + ascDesc;

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query1 = this.session.createQuery(sqlSelect1);
            items = query1.list();
            this.transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
        return items;
    }

    //check against null
    public List<Item> getAllItemsForCategory(String categoryName, String ascDesc) {

        if (!ascDesc.equals("asc") || !ascDesc.equals("desc")
                || categoryName.isEmpty() || categoryName == null) {
            return null;
        }
        List<Item> items = new ArrayList<Item>();

        this.transaction = null;
        String sqlSelect1 = "from Item as item where item.category.name='" + categoryName + "' order by item.category.name " + ascDesc;

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query1 = this.session.createQuery(sqlSelect1);
            items = query1.list();
            this.transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
        return items;
    }

    //check against null
    public List<Item> getAllItemsForCategoryOrderedByPrice(String categoryName, String ascDesc) {

        if (!ascDesc.equals("asc") || !ascDesc.equals("desc")
                || categoryName.isEmpty() || categoryName == null) {
            return null;
        }
        List<Item> items = new ArrayList<Item>();

        this.transaction = null;
        String sqlSelect1 = "from Item as item where item.category.name='" + categoryName + "' orderby item.price " + ascDesc;

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query1 = this.session.createQuery(sqlSelect1);
            items = query1.list();
            this.transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
        return items;
    }
    //check against null

    public List<Item> getAllItemsForCategoryOrderedByTitle(String categoryName, String ascDesc) {

        if (!ascDesc.equals("asc") || !ascDesc.equals("desc")
                || categoryName.isEmpty() || categoryName == null) {
            return null;
        }
        List<Item> items = new ArrayList<Item>();

        this.transaction = null;
        String sqlSelect1 = "from Item as item where item.category.name='" + categoryName + "' orderby item.title " + ascDesc;

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query1 = this.session.createQuery(sqlSelect1);
            items = query1.list();
            this.transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
        return items;
    }
    //check against null

    public List<Item> getAllItemsForCategory(Integer categoryId) {

        String sqlSelect1=null;
        
        if (categoryId == 0 || categoryId == null) {
            sqlSelect1 = "from Item as item order by postDate desc";
        }
        else
        {
         sqlSelect1 = "from Item as item where item.category.id='" + categoryId + "'";
        }
        List<Item> items = new ArrayList<Item>();

        this.transaction = null;

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query1 = this.session.createQuery(sqlSelect1);
            items = query1.list();
            this.transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
        return items;
    }
    //check against null to see if item was found!

    public Item getItemById(Integer id) {

        if (id == 0 || id == null) {
            return null;
        }

        Item item = null;

        this.transaction = null;
        String sqlSelect = "from Item as item where item.id='" + id + "'";

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query = this.session.createQuery(sqlSelect);
            item = (Item) query.uniqueResult();
            this.transaction.commit();

        } catch (HibernateException e) {
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }

        return item;
    }

    //check against null to see if item was found!
    public Item getNewestItem() {

        Item item = null;

        this.transaction = null;
        String sqlSelect = "from Item as item order by postDate desc";

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query = this.session.createQuery(sqlSelect);
            query.setMaxResults(1);
            item = (Item) query.uniqueResult();
            this.transaction.commit();

        } catch (HibernateException e) {
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }

        return item;
    }

    //check against null to see if item was found!
    public Item getSpecialItem() {

        Item item = null;

        this.transaction = null;
        String sqlSelect = "from Item as item order by price desc";

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query = this.session.createQuery(sqlSelect);
            query.setMaxResults(1);
            item = (Item) query.uniqueResult();
            this.transaction.commit();

        } catch (HibernateException e) {
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }

        return item;
    }
    
    //check against null to see if item was found!
    public Item getHeaderItem() {

        Item item = null;

        this.transaction = null;
        String sqlSelect = "from Item as item order by stock desc";

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query = this.session.createQuery(sqlSelect);
            query.setMaxResults(1);
            item = (Item) query.uniqueResult();
            this.transaction.commit();

        } catch (HibernateException e) {
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }

        return item;
    }
    //true returned on success, false returned if item is null or transaction wasn't committed

    public Boolean addItem(Item item) {

        Boolean added = false;
        if (item == null) {
            return added;
        }
        this.transaction = null;

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            this.session.save(item);
            this.transaction.commit();
            if (this.transaction.wasCommitted()) {
                added = true;
            } else {
                added = false;
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
        return added;
    }

    //returns false on update failed
    public Boolean updateItem(Item item) {

        Boolean updated = false;
        if (item == null) {
            return updated;
        }
        this.transaction = null;

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            this.session.update(item);
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

    //true returned on success, false returned if item is null or transaction wasn't committed
    public Boolean deleteItem(Item item) {

        Boolean deleted = false;
        if (item == null) {
            return deleted;
        }
        this.transaction = null;


        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            this.session.delete(item);
            this.transaction.commit();
            if (this.transaction.wasCommitted()) {
                deleted = true;
            } else {
                deleted = false;
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
        return deleted;
    }
//true returned on success, false returned if item is null or transaction wasn't committed

    public Boolean deleteItemById(Integer id) {

        Boolean deleted = false;
        if (id == null || id == 0) {
            return deleted;
        }
        this.transaction = null;
        Item item = null;
        String sqlSelect1 = "delete from Item as item where item.id='" + id + "'";
        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query1 = this.session.createQuery(sqlSelect1);
            int q = query1.executeUpdate();
            if (q != 0) {
                deleted = true;
            } else {
                deleted = false;
            }
            this.transaction.commit();
        } catch (RuntimeException e1) {
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }
        return deleted;
    }

    public Item findItembyId(Integer id) {

        if (id == 0 || id == null) {
            return null;
        }
        Item item = null;

        this.transaction = null;

        String sqlSelect = "from Item as item where item.id=" + id;

        try {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            Query query = this.session.createQuery(sqlSelect);
            item = (Item) query.uniqueResult();
            this.transaction.commit();

        } catch (HibernateException e) {
        } finally {
            this.session.close();
            this.sessionFactory.close();
        }

        return item;
    }
}
