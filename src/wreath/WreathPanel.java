package wreath;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class WreathPanel extends JPanel {

    private BufferedImage wreathImage, lightsImage, ornamentsImage, pineconesImage, textImage;
    //using arrayLists to easily delete and add images to something:
    private ArrayList<BufferedImage> lightsArray = new ArrayList<>(); 
    private ArrayList<BufferedImage> pineconeArray = new ArrayList<>();
    private ArrayList<BufferedImage> ornamentArray = new ArrayList<>();
    private ArrayList<BufferedImage> textArray = new ArrayList<>();

    public WreathPanel() {
        try {
            wreathImage = ImageIO.read(getClass().getResource("images/wreath.png"));
            lightsImage = ImageIO.read(getClass().getResource("images/lights.png"));
            ornamentsImage = ImageIO.read(getClass().getResource("images/ornaments.png"));
            pineconesImage = ImageIO.read(getClass().getResource("images/pinecones.png"));
            textImage = ImageIO.read(getClass().getResource("images/text.png"));
        } catch (Exception e) {
            System.out.println("Problem with an image!");
            System.out.println(e);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //only paints if something is in the array, called with the methods below:
        g.drawImage(wreathImage, 0, 0, null);
        for (BufferedImage image : ornamentArray) {
            g.drawImage(image, 0, 0, null);
        }
        for (BufferedImage image : pineconeArray) {
            g.drawImage(image, 0, 0, null);
        }
        for (BufferedImage image : lightsArray) {
            g.drawImage(image, 0, 0, null);
        }
        for (BufferedImage image : textArray) {
            g.drawImage(image, 0, 0, null);
        }
    }

    public void addOrnaments() {
        ornamentArray.add(ornamentsImage);
        repaint();
    }

    public void deleteOrnaments() {
        if (ornamentArray.size() > 0) {
            ornamentArray.clear();
            repaint();
        }
    }

    public void addPinecones() {
        pineconeArray.add(pineconesImage);
        repaint();
    }

    public void deletePinecones() {
        if (pineconeArray.size() > 0) {
            pineconeArray.clear();
            repaint();
        }
    }

    public void addLights() {
        lightsArray.add(lightsImage);
        repaint();
    }

    public void deleteLights() {
        if (lightsArray.size() > 0) {
            lightsArray.clear();
            repaint();
        }
    }

    public void addText() {
        textArray.add(textImage);
        repaint();
    }

}
