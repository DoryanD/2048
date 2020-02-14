package ihm;

import bo.GameGrid;
import bo.GameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Panel extends JPanel
{
    private int                        fontSize = 40;
    private int colorNumber = 10;
    private Font                       font;
    private Map<TextAttribute, Object> attributes;
    private Color colorBase = new Color(0.9f,0.85f,0.8f);
    private ArrayList<Color> colorList;
    private GameManager gm;

    public Panel(GameManager gm)
    {
        super();
        this.setPreferredSize(new Dimension(800,800));
        this.gm = gm;

        attributes = new HashMap<>();

        attributes.put(TextAttribute.FAMILY, TextAttribute.FAMILY);
        attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_SEMIBOLD);
        attributes.put(TextAttribute.SIZE, fontSize);
        font = Font.getFont(attributes);

        colorList = new ArrayList<>();
        colorList.add(colorBase);
        for(int i=1;i<=colorNumber;i++){

            int R = colorBase.getRed()-(((i-colorNumber/2)<0?0:(i-colorNumber/2))*colorBase.getRed()/colorNumber);
            int G = colorBase.getGreen()-(i*colorBase.getGreen()/colorNumber);
            int B = colorBase.getBlue()-(i*colorBase.getBlue()/colorNumber);

            Color color = new Color(R,G,B);
            colorList.add(color);
        }
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.LIGHT_GRAY);
        g2D.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        for (int y = 0; y < 4; y++)
        {
            for (int x = 0; x < 4; x++)
            {
                String value = gm.getGameGrid().getATile(y,x).toString();
                if(!value.equals("")){
                    int quotient = 0;
                    int reste = Integer.parseInt(value);
                    while(reste > 2){
                        reste /= 2;
                        quotient++;
                    }
                    g2D.setColor(colorList.get(quotient));
                    g2D.fillRect(x * 200+5, y * 200+5, 190, 190);
                    g2D.setColor(Color.black);

                    g2D.setFont(font);
                    FontMetrics metrics = g.getFontMetrics(font);
                    g2D.drawString(value, x * 200 + 100 - metrics.stringWidth(value) / 2, (y * 200 + 100 - metrics.getHeight() / 2) + metrics.getAscent());
                }else{
                    g2D.setColor(Color.LIGHT_GRAY);
                    g2D.fillRect(x * 200+5, y * 200+5, 190, 190);
                }

            }
        }
    }
}
