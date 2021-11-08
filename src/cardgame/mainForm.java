package cardgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class mainForm {
    private JPanel mainPanel;
    private JLabel program_header;
    private JButton newCardButton;
    private JLabel pos1;
    private JLabel pos2;
    private JLabel pos3;
    private JButton exitButton;
    private JPanel Colour;
    private JRadioButton redRadioButton;
    private JRadioButton blackRadioButton;
    private JLabel pos4;
    private JPanel symbol;
    private JButton restartButton;

    card Cardgame[] = new card[52];
    int pos = 0;

    public mainForm(){
        for(int i = 0; i<52; i++)
            Cardgame[i]=new card(i);
        newCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            placeCard();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "not implemented yet, exit now");
                System.exit(0);
            }
        });
    }

    public void mix_card(){

    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Cardgame by conan");
        frame.setContentPane(new mainForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void placeCard(){
        /*Random r = new Random();
        int nr = r.nextInt(52);
        java.net.URL url=getClass().getResource("./res/card"+nr+".png");*/
        ImageIcon card = Cardgame[pos].pic;
        int nr = Cardgame[pos].nr;
        pos++;

        // pos1.setIcon(new ImageIcon(url, "Blaa"));
        pos1.setIcon(card);
        // Abfangen wenn keine Auswahl getroffen
        /*boolean test = true;
        while(test)
        if (!redRadioButton.isSelected() && !blackRadioButton.isSelected()){
            JOptionPane.showMessageDialog (null, "Please select something!" );
        }
        else{
            test = false;
        }*/
        if ((redRadioButton.isSelected() && nr< 26) || (blackRadioButton.isSelected() && nr >= 26))
        {
            JOptionPane.showMessageDialog(null, "nice, your are absolutely right");
        }
        else{
            JOptionPane.showMessageDialog(null, "wrong. game over!");
            newCardButton.setEnabled(false);
            newCardButton.setBackground(Color.red);
        }

    }


}
