package main.java.backEnd.db;

import main.tools.TDatabase;

/**
 * Class for working with users on background.
 *
 * @author pesek
 * @since 24.08.2018
 */
public class Login {

    /******************************************************************************************************************/
    //=========================================== KONSTANTNI ATRIBUTY TRIDY ============================================
    //================================================ ATRIBUTY TRIDY ==================================================
    private static String result;
    //========================================= KONSTANTNI ATRIBUTY INSTANCE ===========================================
    //============================================== ATRIBUTY INSTANCE =================================================

    /******************************************************************************************************************/
    //============================================ PRISTUPOVE METODY TRIDY =============================================

    /**
     * Find specific user in database. Users are in table users. We have to join users table with passwords table. Both these tables are in db_maths database.
     * This method returns result if it find some user with access password.
     *
     * @param userName
     * @param password
     * @return ACCESS if user is in our database and password is correct. Denied if there is no user with this name or password is incorrect.
     */
    public static String checkUser(String userName, String password) {
        result = EnumResultFromDB.DANIED.name();
        TDatabase.setConnection("localhost", "3306", "db_maths", "root", "tukan");
        String sql = "SELECT name, password\n"
                + "FROM users\n"
                + "LEFT JOIN passwords\n"
                + "ON users.id_password = passwords.id";
        for (int i = 0; i < TDatabase.executeSqlSelect(sql).size(); i++) {
            if (TDatabase.executeSqlSelect(sql).get(i).get(0).toLowerCase().equals(userName.toLowerCase()) &&
                    TDatabase.executeSqlSelect(sql).get(i).get(1).equals(password)) {
                result = EnumResultFromDB.ACCESS.name();
                System.out.println("access");
                break;
            }
        }
        return result;
    }
    //================================================= METODY TRIDY ===================================================
    //================================================== KONSTRUKTOR ===================================================
    //================================================ TOVARNI METODA ==================================================

    /******************************************************************************************************************/
    //============================================ KONECNE METODY INSTANCE =============================================
    //========================================== PRISTUPOVE METODY INSTANCE ============================================
    //================================================ METODY INSTANCE =================================================

    /******************************************************************************************************************/
    //================================================ SOUKROME METODY =================================================
    //================================================== MAIN METODA ===================================================
    public static void main(String[] args) {
        System.out.println(checkUser("michal", "test"));
    }

    /******************************************************************************************************************/
    //=============================================== TESTOVACI METODY =================================================
    //================================================ SOUKROME TRIDY ==================================================
}
