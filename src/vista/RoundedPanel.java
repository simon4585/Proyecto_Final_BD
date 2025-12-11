package vista;

import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {

    private int radius;
    private Color backgroundColor;
    private Color borderColor;
    private int borderSize;

    public RoundedPanel(int radius, Color bgColor, Color borderColor, int borderSize) {
        this.radius = radius;
        this.backgroundColor = bgColor;
        this.borderColor = borderColor;
        this.borderSize = borderSize;
        setOpaque(false); // importantísimo
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        // Antialiasing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // Fondo redondeado
        g2.setColor(backgroundColor);
        g2.fillRoundRect(borderSize, borderSize,
                w - borderSize * 2,
                h - borderSize * 2,
                radius, radius);

        // Borde redondeado
        g2.setStroke(new BasicStroke(borderSize));
        g2.setColor(borderColor);
        g2.drawRoundRect(borderSize / 2, borderSize / 2,
                w - borderSize,
                h - borderSize,
                radius, radius);

        g2.dispose();

    }
}
