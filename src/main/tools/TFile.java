package main.tools;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author pesek
 * @since 22.08.2018
 */
public class TFile {

    /******************************************************************************************************************/
    //=========================================== KONSTANTNI ATRIBUTY TRIDY ============================================
    //================================================ ATRIBUTY TRIDY ==================================================
    private static File file;
    //========================================= KONSTANTNI ATRIBUTY INSTANCE ===========================================
    //============================================== ATRIBUTY INSTANCE =================================================

    /******************************************************************************************************************/
    //============================================ PRISTUPOVE METODY TRIDY =============================================

    /**
     * Write string into file. You have to prepare formating etc. and input String text into file only.
     *
     * @param fileName Specific file name. If you don't set path before file, it will find file with inserted name in current file.
     * @param text Text which you have to prepare for insert into file. It means this method will not format this text for file.
     * @return If file doesn't exist or another exception appears, it returns error (with specific message what happens).
     * If everything is all right, it returns success
     */
    public static String writeFullTextIntoFile(String fileName, String text) {
        file = new File(fileName);
        if (!file.exists()) {
            return "Error, file doesn't exists!!";
        } else {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write("");
                bw.close();
                return addTextToEndOfFile(fileName, text);
            } catch (IOException exp) {
                exp.printStackTrace();
                return "Error " + exp.getMessage() + "\n" + exp.getStackTrace();
            }
        }
    }

    /**
     * Add the text to the end of file.
     *
     * @param fileName Specific file name. If you don't set path before file, it will find file with inserted name in current file.
     * @param text Text which you have to prepare for insert in the end of file. It means this method will not format this text for file.
     * @return If file doesn't exist or another exception appears, it returns error (with specific message what happens).
     * If everything is all right, it returns success
     */
    public static String addTextToEndOfFile(String fileName, String text) {
        file = new File(fileName);
        if (!file.exists()) {
            return "Error, file doesn't exists!!";
        } else {
            try {
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
                pw.print(text);
                pw.close();
                return "SUCCESS";
            } catch (IOException exp) {
                exp.printStackTrace();
                return "Error " + exp.getMessage() + "\n" + exp.getStackTrace();
            }
        }
    }

    /**
     * Reads all lines from line and return them as list of Strings. Each index represents one line.
     *
     * @param fileName Specific file name. If you don't set path before file, it will find file with inserted name in current file.
     * @return list of Strings where one index represents one line in file. If file is empty, it retuns just one empty index.
     */
    public static List<String> readFromFile(String fileName) {
        file = new File(fileName);
        List<String> result = new ArrayList<>();
        if (!file.exists()) {
            System.err.println("Error, file doesn't exists!!");
            return null;
        } else {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    result.add(line);
                }
                br.close();
                return result;
            } catch (FileNotFoundException exp) {
                exp.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    //================================================= METODY TRIDY ===================================================

    /**
     * Creates new file with specific name and path. If you set path with empty string, it creates file in current directory
     * NOTE: DON'T USE SPLASHES IN THE END OF PATH!!
     * <li>CORRECT: dir1\\dir2</li>
     * <li>WRONG: dir1\\dir2\\</li>
     *
     * @param fileName Name of file and it's better when it contains surfix (for example .txt or .html etc)
     * @param path from current path type directory name without splashes. If you want to nest into directories, use double slashes (directory1\\directory2 etc)
     */
    public static void createNewFile(String fileName, String path) {
        String splash = path.equals("") ? "" : "\\";
        file = new File(path + splash + fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }
    }

    /**
     * Creates new file in current directory
     * @param fileName Name of file and it's better when it contains surfix (for example .txt or .html etc)
     */
    public static void createNewFile(String fileName) {
        createNewFile(fileName, "");
    }

    public static void removeFile(String fileName) {
        file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * Creates new directory in current directory. If you want to create 2 or more directories nested, use double splashes (dir1\\dir2 etc)
     * NOTE: DON'T USE SPLASHES IN THE END OF PATH!!
     * <li>CORRECT: dir1\\dir2</li>
     * <li>WRONG: dir1\\dir2\\</li>
     *
     * @param directory new directory or string of directories separated by splashes (\\)
     */
    public static void createNewDirectory(String directory) {
        File dir = new File(directory);
        dir.mkdir();
    }

    /**
     * Remove specific directory.
     * Be deadly!! If directory contains some files or another directories, everything will be completly removed and you can't return it back!
     *
     * @param directory specific directory
     */
    public static void removeDirectory(String directory) {
        File dir = new File(directory);
        if (!dir.isDirectory()) {
            System.err.println("Adresář" + directory + " neexistuje!");
        } else if (!dir.exists()) {
            System.err.println(directory + " není adresář!");
        } else {
            for (File file : dir.listFiles()) {
                if (file.isDirectory()) {
                    removeDirectory(file.getAbsolutePath());
                } else {
                    file.delete();
                }
            }
            dir.delete();
        }
    }

    //================================================== KONSTRUKTOR ===================================================
    //================================================ TOVARNI METODA ==================================================

    /******************************************************************************************************************/
    //============================================ KONECNE METODY INSTANCE =============================================
    //========================================== PRISTUPOVE METODY INSTANCE ============================================
    //================================================ METODY INSTANCE =================================================

    /******************************************************************************************************************/
    //================================================ SOUKROME METODY =================================================
    //================================================== MAIN METODA ===================================================

    /******************************************************************************************************************/
    //=============================================== TESTOVACI METODY =================================================
    private final String testFileName = "TestingFile.txt";
    private File testFile;

    @Before
    public void setUp() {
        testFile = new File(testFileName);
    }

    @After
    public void tearDown() {
        if (testFile.exists()) {
            testFile.delete();
        }
        testFile = null;
    }

    @Test
    public void testRemoveDirectory() {
        createNewDirectory("test");
        createNewFile("test.txt", "test");
        createNewDirectory("test\\test2");
        assertTrue(new File("test").isDirectory());

        removeDirectory("test");
        assertFalse(new File("test").isDirectory());
    }

    @Test
    public void testCreateNewFile() {
        testFile.delete();
        assertFalse(testFile.exists());

        createNewFile(testFileName);
        assertTrue(testFile.exists());

        testFile.delete();
        assertFalse(testFile.exists());

        createNewDirectory("test");
        createNewFile(testFileName, "test\\");
        assertTrue(new File("test\\" + testFile.getName()).exists());

        removeDirectory("test");
    }

    @Test
    public void testWriteFullTextIntoFile() {
        createNewFile(testFileName);
        assertTrue(writeFullTextIntoFile(testFileName, "testing text for test").toLowerCase().equals("success"));
        assertTrue(writeFullTextIntoFile("", "testing text for test").toLowerCase().contains("error"));
    }

    @Test
    public void testAddTextToEndOfFileAndReadFromFile() {
        createNewFile(testFileName);
        writeFullTextIntoFile(testFileName, "testing text");
        assertTrue(addTextToEndOfFile(testFileName, "testing text for test").toLowerCase().equals("success"));
        assertTrue(addTextToEndOfFile("", "testing text for test").toLowerCase().contains("error"));
        assertTrue(readFromFile(testFileName).get(0).equals("testing text"));
        assertTrue(readFromFile(testFileName).get(1).equals("testing text for test"));
    }
    //================================================ SOUKROME TRIDY ==================================================
}
