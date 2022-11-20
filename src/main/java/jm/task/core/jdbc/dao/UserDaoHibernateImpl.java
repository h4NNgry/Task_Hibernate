package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.management.Query;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    SessionFactory factory = Util.getSessionFactory();
    Session session;

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users_task1.user" +
                            "(id INT NOT NULL AUTO_INCREMENT," +
                            "name VARCHAR(45)," +
                            "lastname VARCHAR(45)," +
                            "age INT," +
                            "PRIMARY KEY (id))")
                    .executeUpdate();

            session.getTransaction().commit();
            System.out.println("Table created! (Hibernate)");
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            session.createSQLQuery("DROP TABLE IF EXISTS users_task1.user;")
                    .executeUpdate();

            session.getTransaction().commit();
            System.out.println("Table dropped! (Hibernate)");
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User userSave = new User(name, lastName, age);
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.save(userSave);
            session.getTransaction().commit();
            System.out.println("User " + name + " " + lastName + " added to table ! (Hibernate)");
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            session.createQuery("delete User where id = " + id)
                    .executeUpdate();

            session.getTransaction().commit();
            System.out.println("User removed! (Hibernate)");
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            List<User> userList = session.createQuery("from User")
                    .getResultList();

            session.getTransaction().commit();
            return userList;
        } finally {
            session.close();
        }
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            session.createQuery("delete User")
                    .executeUpdate();

            session.getTransaction().commit();
            System.out.println("Table cleared! (Hibernate)");
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
