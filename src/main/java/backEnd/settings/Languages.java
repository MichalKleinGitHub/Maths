package main.java.backEnd.settings;

import java.io.File;
import java.io.IOException;
import java.util.List;

import main.java.frontend.FXLabeledList;
import main.tools.TFile;

/**
 * @author pesek
 * @since 22.08.2018
 */
public class Languages {

    /******************************************************************************************************************/
    //=========================================== KONSTANTNI ATRIBUTY TRIDY ============================================
    //================================================ ATRIBUTY TRIDY ==================================================
    //========================================= KONSTANTNI ATRIBUTY INSTANCE ===========================================
    //============================================== ATRIBUTY INSTANCE =================================================
    private String currentLocalization = "";
    private List<String> currentList;

    /******************************************************************************************************************/
    //============================================ PRISTUPOVE METODY TRIDY =============================================
    //================================================= METODY TRIDY ===================================================
    //================================================== KONSTRUKTOR ===================================================
    //================================================ TOVARNI METODA ==================================================

    /******************************************************************************************************************/
    //============================================ KONECNE METODY INSTANCE =============================================
    //========================================== PRISTUPOVE METODY INSTANCE ============================================
    //================================================ METODY INSTANCE =================================================

    /**
     * Method
     * @param localization
     */
    public void setLanguageFromConfigFile(String localization) {
        if (!currentLocalization.equals(localization)) {
            currentLocalization = localization;
            switch (localization) {
                case "CZ":
                    currentList = TFile.readFromFile("src\\main\\resources\\languages\\cz-config.config");
                    break;
                case "SK":
                    currentList = TFile.readFromFile("src\\main\\resources\\languages\\sk-config.config");
                    break;
                case "EN":
                    currentList = TFile.readFromFile("src\\main\\resources\\languages\\en-config.config");
            }
            FXLabeledList.getFxLabeledList().stream().forEach(node -> {
                for (String line : currentList) {
                    if (line.split("=")[0].equals(node.getId())) {
                        node.setText(line.split("=")[1]);
                        break;
                    }
                }
            });
        }
    }

    /******************************************************************************************************************/
    //================================================ SOUKROME METODY =================================================
    //================================================== MAIN METODA ===================================================

    /******************************************************************************************************************/
    //=============================================== TESTOVACI METODY =================================================
    //================================================ SOUKROME TRIDY ==================================================
}
