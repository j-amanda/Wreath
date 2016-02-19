package wreath;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.sound.sampled.*;

public class ControlPanel extends JPanel {

    private final WreathPanel wreathPanel = new WreathPanel();
    private final JPanel buttonPanel = new JPanel();
    private JButton lightsButton = new JButton("lights");
    private JButton pineconesButton = new JButton("pinecones");
    private JButton ornamentsButton = new JButton("ornaments");
    private JButton finalizeButton = new JButton("finalize");
    private Boolean pinecones = false, lights = false, ornaments = false;

    public ControlPanel() {

        setLayout(new BorderLayout());
        wreathPanel.setBackground(Color.WHITE);
        buttonPanel.setBackground(Color.WHITE);
        
        lightsButton.setBackground(Color.RED);
        lightsButton.setForeground(Color.WHITE);
        ornamentsButton.setBackground(new Color(0, 91, 56));
        ornamentsButton.setForeground(Color.WHITE);
        pineconesButton.setBackground(Color.RED);
        pineconesButton.setForeground(Color.WHITE);
        finalizeButton.setBackground(Color.WHITE);
        finalizeButton.setForeground(Color.BLACK);

        buttonPanel.add(lightsButton);
        buttonPanel.add(ornamentsButton);
        buttonPanel.add(pineconesButton);
        buttonPanel.add(finalizeButton);

        add(buttonPanel, BorderLayout.SOUTH);
        add(wreathPanel, BorderLayout.CENTER);

        lightsButton.addActionListener(new Listener());
        ornamentsButton.addActionListener(new Listener());
        pineconesButton.addActionListener(new Listener());
        finalizeButton.addActionListener(new Listener());

    }

    class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) { //methods are in WreathPanel class
            if (event.getSource() == lightsButton) {
                if (lights == false) {
                    wreathPanel.addLights();
                    lights = true;
                } else {
                    wreathPanel.deleteLights();
                    lights = false;
                }
                playSound("lightbuzzingon.wav");
            } //end lightsButton
            else if (event.getSource() == pineconesButton) {
                if (pinecones == false) {
                    wreathPanel.addPinecones();
                    pinecones = true;
                } else {
                    wreathPanel.deletePinecones();
                    pinecones = false;
                }
                playSound("twigsnap.wav");
            } //end pineconesButton
            else if (event.getSource() == ornamentsButton) {
                if (ornaments == false) {
                    wreathPanel.addOrnaments();
                    ornaments = true;
                } else {
                    wreathPanel.deleteOrnaments();
                    ornaments = false;
                }
                playSound("glasstap.wav");
            } //end ornamentsButton
            else if (event.getSource() == finalizeButton) { //disable all other buttons, loop ChristmasSong
                ornamentsButton.setEnabled(false);
                lightsButton.setEnabled(false);
                pineconesButton.setEnabled(false);
                finalizeButton.setEnabled(false);
                wreathPanel.addText();
                loopSound("christmassong.wav");
            } //end finalizeButton
        }
    }

    public void playSound(String soundName) { //plays a sound once
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("sounds/" + soundName));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
    
    public void loopSound(String soundName) { //loops a sound continuously
                try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("sounds/" + soundName));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            System.out.println("Error with looping sound.");
            ex.printStackTrace();
        }
    }

}
