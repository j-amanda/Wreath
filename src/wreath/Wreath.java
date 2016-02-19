package wreath;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/*******************************************************************************
 * 
 * Jordan Davidson
 * 
 * CSIS 1410
 * Final Project
 * December 7, 2015
 * 
 * CREDITS *
 * 
 * Sound files from https://www.freesound.org
 * 
 * Christmas Font from http://www.dafont.com/stackyard
 * 
 * Christmas Wreath from http://achristmaswreathsb.hol.es/christmas-wreath-clipart/
 * 
 * Christmas Lights from http://imgarcade.com/1/clip-art-christmas-lights-on-house/
 * 
 * Ornaments from http://cliparts.co/clip-art-collections
 * 
 * Pinecones from http://gallery.yopriceville.com/Free-Clipart-Pictures
 * 
 * Stack Overflow: http://stackoverflow.com/questions/22430970/how-to-play-wav-file-with-jbutton
 ******************************************************************************/


public class Wreath extends JFrame {

    public Wreath() {
        add(new ControlPanel());
    }

    public static void main(String[] args) {
        Wreath frame = new Wreath();
        frame.setTitle("Decorate the Wreath!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(760, 775);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        
        JOptionPane.showMessageDialog(null, "Click the buttons to decorate the wreath. \nIf you want to remove something, \njust click the button again!");
    }

}
