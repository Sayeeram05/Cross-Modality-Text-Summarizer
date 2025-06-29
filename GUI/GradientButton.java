import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;


class GradientButton extends JButton 
{
    public Color startColor;
    public Color endColor;
    public int arc;

    GradientButton( Color startColor, Color endColor,int arc) {
        super();
        setContentAreaFilled(false);
        this.startColor = startColor;
        this.endColor = endColor;
        this.arc = arc;
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        Graphics2D g2 = (Graphics2D) g.create();
        if (getModel().isPressed()) 
        {
            g2.setPaint(new GradientPaint(0, 0, endColor, 0, getHeight(), startColor));
        } 
        else 
        {
            g2.setPaint(new GradientPaint(0, 0, startColor, 0, getHeight(), endColor));
        }

        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arc, arc));
        g2.dispose();

        super.paintComponent(g);
    }

    /*protected void paintBorder(Graphics g) 
    {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
    }*/

    //Shape shape;

    /*public boolean contains(int x, int y) 
    {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        }
        return shape.contains(x, y);
    }*/

}