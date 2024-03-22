package PartIV;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private Image img;
    private final String imgTemplate = "Assignment7/die%d.png";
    private int num = 1;
	
	public ImagePanel(String img) {
		this(new ImageIcon(img).getImage());
	}
	
	public ImagePanel(Image img) {
		this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        /*setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);*/
        setLayout(null);
	}

    public void setImage(String img) {
        this.img = new ImageIcon(img).getImage();
        repaint();
    }

    public void setNum(int num) {
        this.num = num;
        setImage(imgTemplate.formatted(num));
    }

    public int getNum() {
        return num;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
