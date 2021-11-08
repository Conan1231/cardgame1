package cardgame;

import javax.swing.*;
import java.util.Random;

public class card {
    int nr;
    ImageIcon pic;
    card(int n){
        java.net.URL url=getClass().getResource("./res/card"+nr+".png");
        pic = new ImageIcon(url, "card" + nr);

    }
}


