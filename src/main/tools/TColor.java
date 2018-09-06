package main.tools;

import javafx.scene.paint.Color;

/**
 * Thanks to this class you don't have to create repetitively new color for every kind of background.
 * You just call one of its static methods and method will return the color chosen by you as a return value.
 *
 * @author klein
 * @since 31.8.2018
 */
public class TColor {

    private static Color color;
    private static String[] rgb;

    /**
     * Returns a Color representation of this String value.
     * Parameter example:
     * <p>.chooseRGBColor("100 100 100");</p>
     * or
     * <p>.chooseRGBColor("x y z");</p>
     * where every value(x,y and z) must be in the range 0-255
     *
     * @param colorSpecification
     * @return color
     * @throws IllegalArgumentException if any value is out of range
     */
    public static Color chooseRGBColor(String colorSpecification){
        rgb = colorSpecification.split(" ");

        color = Color.rgb(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
        return color;
    }


    /**
     * Returns a Color representation of this String value.
     * Parameter example:
     * <p>.chooseHexColor("#ff0000");</p>
     *
     * @param colorSpecification
     * @return color
     */
    public static Color chooseHexColor(String colorSpecifiaction){
        color = Color.rgb(
                Integer.valueOf( colorSpecifiaction.substring( 1, 3 ), 16 ),
                Integer.valueOf( colorSpecifiaction.substring( 3, 5 ), 16 ),
                Integer.valueOf( colorSpecifiaction.substring( 5, 7 ), 16 )
        );

        return color;
    }
}
