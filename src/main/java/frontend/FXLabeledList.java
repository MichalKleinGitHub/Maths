package main.java.frontend;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Labeled;

/**
 * This class contains all of Nodes (components) of this application. For now they are all in one List.
 * <li>We need this class now for setting language only.</li>
 *
 * @author pesek
 * @since 22.08.2018
 */
public class FXLabeledList {

    /******************************************************************************************************************/
    //=========================================== KONSTANTNI ATRIBUTY TRIDY ============================================
    private static final List<Labeled> FX_LABELED_LIST = new ArrayList<>();
    //================================================ ATRIBUTY TRIDY ==================================================
    //========================================= KONSTANTNI ATRIBUTY INSTANCE ===========================================
    //============================================== ATRIBUTY INSTANCE =================================================

    /******************************************************************************************************************/
    //============================================ PRISTUPOVE METODY TRIDY =============================================

    /**
     * Access method to get and work with list of all nodes.
     *
     * @return List of all nodes in this application
     */
    public static List<Labeled> getFxLabeledList() {
        return FX_LABELED_LIST;
    }

    //================================================= METODY TRIDY ===================================================

    /**
     * This method add each JavaFX node into list of this class. We check in this method if the node is allready in list. This save memory and time when we work
     * with this list.
     * RULE: This method must be call everywhere we add new node to application!!
     *
     * @param labeleds Labeled is one of super classes of all nodes. This super class able all nodes to set they're text on application. We need this for
     * setting language
     */
    public static void addFXNodes(Labeled... labeleds) {
        for (Labeled node : labeleds) {
            if (!FX_LABELED_LIST.contains(node)) {
                FX_LABELED_LIST.add(node);
            }
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
    //================================================ SOUKROME TRIDY ==================================================
}
