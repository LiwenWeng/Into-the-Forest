import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuPanel extends JPanel implements ActionListener, MouseListener {
    Button startButton;
    Frame enclosingFrame;
    public MenuPanel(JFrame frame) {
        enclosingFrame = frame;
        startButton = new Button(100,200);
        addMouseListener(this);
        setFocusable(true); // this line of code + one below makes this panel active for keylistener events
        requestFocusInWindow(); // see comment above
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(startButton.getImage(), startButton.getxCoord(), startButton.getyCoord(), null);
    }

    public void actionPerformed(ActionEvent e) { }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (startButton.buttonRect().contains(e.getPoint())) {
                MainFrame f = new MainFrame();
                enclosingFrame.setVisible(false);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
