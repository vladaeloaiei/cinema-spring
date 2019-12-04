package com.ltw.cinema.gui.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Seat extends JPanel {
    private Image image;

    public Seat() {
    }

    public void setImageName(String seatName) {
        try {
            String path = "locuri/" + seatName + ".png";
            BufferedImage bi = ImageIO.read(getClass().getClassLoader().getResourceAsStream(path));
            image = bi.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
            repaint();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (null != image) {
            g.drawImage(image, 0, 0, 25, 25, this); // see javadoc for more info on the parameters
        }
    }
}