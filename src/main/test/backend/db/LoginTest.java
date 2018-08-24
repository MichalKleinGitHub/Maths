package main.test.backend.db;

import static main.java.backEnd.db.Login.checkUser;
import static org.junit.Assert.assertTrue;

import main.java.backEnd.db.EnumResultFromDB;
import org.junit.Test;

/**
 * @author pesek
 * @since 24.08.2018
 */
public class LoginTest {

    @Test
    public void testCheckUser() {
        //Integration
        assertTrue(checkUser("lubor", "test").equals(EnumResultFromDB.ACCESS.name()));
        assertTrue(checkUser("lubor", "michal").equals(EnumResultFromDB.ACCESS.name()));
        assertTrue(checkUser("michal", "test").equals(EnumResultFromDB.ACCESS.name()));
        //validation
        assertTrue(checkUser("lubor", "").equals(EnumResultFromDB.DANIED.name()));
        assertTrue(checkUser("michal", "michal").equals(EnumResultFromDB.DANIED.name()));
        assertTrue(checkUser("michal", "").equals(EnumResultFromDB.DANIED.name()));
        assertTrue(checkUser("hugo", "hugo").equals(EnumResultFromDB.DANIED.name()));
    }
}
