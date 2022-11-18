package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {

        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser("Billie Joe", "Armstrong", (byte) 50);
        userDao.saveUser("Mike", "Dirnt", (byte) 50);
        userDao.saveUser("Tre", "Cool", (byte) 49);
        userDao.saveUser("Jason", "White", (byte) 49);

        userDao.removeUserById(1);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
