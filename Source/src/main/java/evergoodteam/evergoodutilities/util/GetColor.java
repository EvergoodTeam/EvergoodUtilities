package evergoodteam.evergoodutilities.util;


import java.awt.*;


public class GetColor {

    public static int getDecimal(Color input){

        Color col = Color.decode("0x"+input);

        int b = col.getBlue();
        int g = col.getGreen();
        int r = col.getRed();

        String hex = String.format("%02x%02x%02x", r, g, b);

        return Integer.parseInt(hex, 16);
    }
}
