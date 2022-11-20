package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

public class Main {
    public static void main(String[] args) {

        UserDao userDaoHibernate = new UserDaoHibernateImpl();

        userDaoHibernate.createUsersTable();

        userDaoHibernate.saveUser("Billie Joe", "Armstrong", (byte) 50);
        userDaoHibernate.saveUser("Mike", "Dirnt", (byte) 50);
        userDaoHibernate.saveUser("Tre", "Cool", (byte) 49);
        userDaoHibernate.saveUser("Stephen", "King", (byte) 73);

        userDaoHibernate.removeUserById(1);
        userDaoHibernate.getAllUsers();
        userDaoHibernate.cleanUsersTable();
        userDaoHibernate.dropUsersTable();
    }
}
