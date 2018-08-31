package main.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * This class use all basic commands for communication with MySQL database. Thanks to this class you don't need to import sql libraries. All methods returns
 * void or List of Strings as result from SQL command.
 * <li>All connections, statements and result sets are closed in each method, so you don't need to close it when method is used.</li>
 * <li>All SQL commands are saved in log in SQL.log file (even connection data etc.)</li>
 * NOTE: At first you have to call setConnection(String, String, String, String, String)
 *
 * @author lpesek6862hc
 * @since 22.08.2018
 */
public class TDatabase {

    /******************************************************************************************************************/
    //=========================================== KONSTANTNI ATRIBUTY TRIDY ============================================
    private static final String LOG_FILE_NAME = "SQL.log";
    //================================================ ATRIBUTY TRIDY ==================================================
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    private static String server;
    private static String port;
    private static String database;
    private static String user;
    private static String password;

    //========================================= KONSTANTNI ATRIBUTY INSTANCE ===========================================
    //============================================== ATRIBUTY INSTANCE =================================================

    /******************************************************************************************************************/
    //============================================ PRISTUPOVE METODY TRIDY =============================================
    //================================================= METODY TRIDY ===================================================

    /**
     * This method try to connect into MySQL database with access parameters. When you are connected successfully, all of access parameters will save into global
     * variables and thanks these variables we don't need to call this method before each of methods.
     *
     * @param server ip address or DNS of server (for example localhost or 127.0.0.1)
     * @param port server port without colon (for example 3306)
     * @param database specific database on server (for example testing_db)
     * @param user user for database (not SSH tunnel)
     * @param password password for database (not SSH tunnel)
     */
    public static void setConnection(String server, String port, String database, String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s", server, port, database), user, password);
            TDatabase.server = server;
            TDatabase.port = port;
            TDatabase.database = database;
            TDatabase.user = user;
            TDatabase.password = password;
            log("CONNECTED! (" + String.format("jdbc:mysql://%s:%s/%s user:%s password:%s", server, port, database, user, password) + ")");
        } catch (ClassNotFoundException exp) {
            log("JDBC driver is missing!");
            exp.printStackTrace();
        } catch (SQLException exp) {
            log("UNABLE TO CONNECT! (" + String.format("jdbc:mysql://%s:%s/%s user:%s password:%s", server, port, database, user, password) + ")");
            exp.printStackTrace();
        }
    }

    /**
     * You can use all standard SQL requests by calling this method without SELECT command. This method returns void so you have no result.
     *
     * @param sqlCommand Full SQL request. You can use conditions too
     */
    public static void executeSql(String sqlCommand) {
        setConnection();
        try {
            statement = connection.createStatement();
            statement.execute(sqlCommand);
            log(sqlCommand);
        } catch (SQLException exp) {
            log("WRONG SQL: " + sqlCommand);
            exp.printStackTrace();
        } finally {
            closeDb();
        }
    }

    /**
     * You can use SELECT request only by calling this method. It returns List of Lists. Each index of first list represents line of the table and each index of
     * second list represents column of the table.
     *
     * For example if you want to use all of data from 3rd line, you can call this method like this:
     * <li>executeSqlSelect("SELECT * FROM table").get(2)</li>
     * And now you have list of all column from this row.
     *
     * NOTE: This method doesn't work with aliases!!!
     *
     * @param sqlCommand SQL SELECT request
     * @return Lines list of table from SQL request result. Each index of this list has another list where are all columns from SQL result.
     */
    public static List<List<String>> executeSqlSelect(String sqlCommand) {
        setConnection();
        final List<List<String>> resultList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlCommand);
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                List<String> lineData = new ArrayList<>();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    lineData.add(resultSet.getString(metaData.getColumnName(i)));
                }
                resultList.add(lineData);
            }
            log(sqlCommand);
            return resultList;
        } catch (SQLException exp) {
            log("WRONG SQL: " + sqlCommand);
            exp.printStackTrace();
            return null;
        } finally {
            closeDb();
        }
    }

    /**
     * This method use SQL SELECT request and save result into file. You will see all result table in the file. Rows are splited by lines and columns by
     * semicolon (;). So you can use CSV file format.
     *
     * @param sqlCommand SQL SELECT request
     * @param fileName Specific file where you will see result of SELECT request.
     */
    public static void sqlSelectIntoFile(String sqlCommand, String fileName) {
        setConnection();
        if (!fileName.equals(LOG_FILE_NAME)) {
            TFile.removeFile(fileName);
            TFile.createNewFile(fileName);
            executeSqlSelect(sqlCommand).stream().forEach(listOfValues -> {
                for (int i = 0; i < listOfValues.size(); i++) {
                    TFile.addTextToEndOfFile(fileName, listOfValues.get(i));
                    if (i < listOfValues.size() - 1) {
                        TFile.addTextToEndOfFile(fileName, ";");
                    }
                }
                TFile.addTextToEndOfFile(fileName, "\n");
            });
        }
    }

    /**
     * Methods return just number represents count of databases on server. It could use method getDatabasesOnServer and ask this method for size of list
     * which this method returns, but this method use SQL command for log to see that it were used.
     *
     * @return Count of databases on actual server
     */
    public static int getDatabasesCount() {
        setConnection();
        final String sqlCommand = "SELECT COUNT(*) FROM information_schema.SCHEMATA";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlCommand);
            int countOfDatabases = 0;
            while (resultSet.next()) {
                countOfDatabases = resultSet.getInt("COUNT(*)");
            }
            log(sqlCommand);
            return countOfDatabases;
        } catch (SQLException exp) {
            exp.printStackTrace();
            return 0;
        } finally {
            closeDb();
        }
    }

    /**
     * Methods returns databases on the server.
     *
     * @return All databases name on actual server
     */
    public static List<String> getDatabasesOnServer() {
        setConnection();
        final String sqlCommand = "SELECT SCHEMA_NAME FROM information_schema.SCHEMATA";
        final List<String> resultList = new ArrayList<>();
        executeSqlSelect(sqlCommand).stream().forEach(value -> resultList.add(value.get(0)));
        log(sqlCommand);
        return resultList;
    }

    /**
     * Methods returns tables on specific database.
     *
     * @param database name of database
     * @return Tables on database
     */
    public static List<String> getTablesOnDatabase(String database) {
        setConnection();
        final List<String> resultList = new ArrayList<>();
        executeSqlSelect("SELECT TABLE_NAME FROM information_schema.TABLES WHERE TABLE_SCHEMA = '" + database + "'").stream()
                .forEach(value -> resultList.add(value.get(0)));
        return resultList;
    }

    //================================================== KONSTRUKTOR ===================================================
    //================================================ TOVARNI METODA ==================================================

    /******************************************************************************************************************/
    //============================================ KONECNE METODY INSTANCE =============================================
    //========================================== PRISTUPOVE METODY INSTANCE ============================================
    //================================================ METODY INSTANCE =================================================

    /******************************************************************************************************************/
    //================================================ SOUKROME METODY =================================================

    /**
     * This method overloads setting connection but reason why there are no parameters is that we can close and open connection every time when we use method of
     * this class. We don'n need to set parameters again. Until we call method setConnection(String, String, String, String, String), this method still remember
     * all needed parameters.
     * Of course this method cannot be called before overloaded method, because we need to know access parameters from user. This is the main reason, why is
     * this method private.
     */
    private static void setConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s", server, port, database), user, password);
        } catch (ClassNotFoundException exp) {
            log("JDBC driver is missing!");
            exp.printStackTrace();
        } catch (SQLException exp) {
            log("UNABLE TO CONNECT! (" + String.format("jdbc:mysql://%s:%s/%s user:%s password:%s", server, port, database, user, password) + ")");
            exp.printStackTrace();
        }
    }

    /**
     *
     *
     * @param sqlCommand
     */
    private static void log(String sqlCommand) {
        LocalDateTime localTime = LocalDateTime.now();
        TFile.createNewFile(LOG_FILE_NAME);
        TFile.addTextToEndOfFile(LOG_FILE_NAME, "[" + localTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "] " + sqlCommand + "\n");
    }

    /**
     * Help method for closing all database tools. It's better to close them because we don't overload server with too many connections. Also it's better when
     * is this method used in finally block. You want to close everything even when the sql exception or another exception appears.
     */
    private static void closeDb() {
        try {
            statement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }

    //================================================== MAIN METODA ===================================================

    /******************************************************************************************************************/
    //=============================================== TESTOVACI METODY =================================================
    //================================================ SOUKROME TRIDY ==================================================
}
