package cardgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
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
    private JButton shuffleDeckButton;
    private JRadioButton higherRadioButton;
    private JRadioButton lowerRadioButton;
    private JRadioButton insideRadioButton;
    private JRadioButton outsideRadioButton;
    private JRadioButton diamondsRadioButton;
    private JRadioButton clubsRadioButton;
    private JRadioButton spadesRadioButton;
    private JRadioButton heartsRadioButton;

    static int game_part = 0;
    static int first_nr = 0;
    static int second_nr = 0;

    card Cardgame[] = new card[52];
    int pos = 0;

    public mainForm(){
        for(int i = 0; i<52; i++)
            Cardgame[i]=new card(i);
        shuffle_deck();
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
                //JOptionPane.showMessageDialog(null, "not implemented yet, exit now");
                //System.exit(0);
                newCardButton.setEnabled(true);
                newCardButton.setBackground(Color.white);
                shuffle_deck();
                pos1.setIcon(new ImageIcon(getClass().getResource("./res/pos1.png")));
                pos2.setIcon(new ImageIcon(getClass().getResource("./res/pos2.png")));
                pos3.setIcon(new ImageIcon(getClass().getResource("./res/pos3.png")));
                pos4.setIcon(new ImageIcon(getClass().getResource("./res/pos4.png")));
                game_part = 0;
                for(int i = 0; i<52; i++)
                    Cardgame[i]=new card(i);
                shuffle_deck();
            }
        });
        shuffleDeckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shuffle_deck();
            }
        });
    }

    public void shuffle_deck(){
        card tmp;
        for(int i = 0; i<52; i++){
            Random r = new Random();
            int nr = r.nextInt(52);
            tmp = Cardgame[i];
            Cardgame[i] = Cardgame[nr];
            Cardgame[nr] = tmp;
        }
        newCardButton.setEnabled(true);
        newCardButton.setBackground(Color.white);
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

        // Abfangen wenn keine Auswahl getroffen
        /*boolean test = true;
        while(test)
        if (!redRadioButton.isSelected() && !blackRadioButton.isSelected()){
            JOptionPane.showMessageDialog (null, "Please select something!" );
        }
        else{
            test = false;
        }*/

        switch(game_part){
            case 0:
                pos1.setIcon(card);
                if ((redRadioButton.isSelected() && nr< 26) || (blackRadioButton.isSelected() && nr >= 26))
                {
                    JOptionPane.showMessageDialog(null, "nice, your are absolutely right");
                    game_part++;
                    first_nr = nr%13;
                    break;
                }
                else {
                    JOptionPane.showMessageDialog(null, "wrong. game over!");
                    newCardButton.setEnabled(false);
                    newCardButton.setBackground(Color.red);
                    break;
                }
            case 1:
                pos2.setIcon(card);
                if ((higherRadioButton.isSelected() && (nr%13)>= first_nr ) || (lowerRadioButton.isSelected() && (nr%13)<= first_nr )){
                    JOptionPane.showMessageDialog(null, "nice, your are absolutely right");
                    game_part++;
                    second_nr = nr%13;
                    break;
                }
                else{
                    JOptionPane.showMessageDialog(null, "wrong. game over!");
                    newCardButton.setEnabled(false);
                    newCardButton.setBackground(Color.red);
                    break;
                }
            case 2:
                pos3.setIcon(card);
                /*int tmp;
                if (first_nr > second_nr){
                    tmp = first_nr;
                    first_nr = second_nr;
                    second_nr = tmp;
                } */
                //if((insideRadioButton.isSelected() && ((nr%13)<=second_nr) && ((nr%13)>=first_nr)) || (outsideRadioButton.isSelected() && ((nr%13)>second_nr) && ((nr%13)<first_nr))){
                if((insideRadioButton.isSelected() && ( ( (nr%13)>=first_nr && (nr%13)<=second_nr ) || ( (nr%13)<=first_nr && (nr%13)>=second_nr ) ) ) || (outsideRadioButton.isSelected() && ( ( (nr%13)<= first_nr && (nr%13)<=second_nr ) || ( (nr%13)>first_nr && (nr%13)>second_nr ) ) ) ){
                    JOptionPane.showMessageDialog(null, "nice, your are absolutely right");
                    game_part++;
                    break;
                }
                else {
                    JOptionPane.showMessageDialog(null, "wrong. game over!!!!!");
                    newCardButton.setEnabled(false);
                    newCardButton.setBackground(Color.red);
                    break;
                }
            case 3:
                pos4.setIcon(card);
                if (((diamondsRadioButton.isSelected() && (nr <= 12))) || (heartsRadioButton.isSelected() && (nr<=25) && (nr>12)) || (spadesRadioButton.isSelected() && (nr<=38) && (nr>25)) || (clubsRadioButton.isSelected() && (nr >38))) {
                    JOptionPane.showMessageDialog(null, "Winner Winner Chicken Dinner!");
                    break;
                }
                else {
                    JOptionPane.showMessageDialog(null, "wrong. game over!");
                    newCardButton.setEnabled(false);
                    newCardButton.setBackground(Color.red);
                    break;
                }
            }
        }
    }
