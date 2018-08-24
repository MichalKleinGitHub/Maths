package main.java.frontEnd.windowComponents.mainWindowComponents.mainMenuComponents;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LoginSystemBar {
    //Body of LoginSystemBar
    private Rectangle loginSystemBarRectangle = new Rectangle(160, 90,  Color.rgb(84, 80, 79));

    public LoginSystemBar(double x, double y){
        loginSystemBarRectangle.setLayoutX(x/50);
        loginSystemBarRectangle.setLayoutY(y/6);
    }

    public Rectangle getLoginSystemBarRectangle() {
        return loginSystemBarRectangle;
    }
}
