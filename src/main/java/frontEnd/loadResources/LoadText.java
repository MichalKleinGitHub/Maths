package main.java.frontEnd.loadResources;

import javafx.scene.control.Labeled;

import java.util.ArrayList;
import java.util.List;

public class LoadText {
    private static List<Labeled> FX_LABELED_LIST = new ArrayList<>();

    public static List<Labeled> getNodes(){
        return FX_LABELED_LIST;
    }

    public static void setNodes(Labeled node){
        FX_LABELED_LIST.add(node);
    }

    public static void setNodes(List<Labeled> nodes){
        FX_LABELED_LIST.addAll(nodes);
    }
}
