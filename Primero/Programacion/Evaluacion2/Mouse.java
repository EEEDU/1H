import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/* <APPLET CODE="MouseEventsDemo.class" WIDTH="300" HEIGHT="300">
   </APPLET>
*/

public class Mouse extends Applet implements MouseListener, MouseMotionListener {

	String message = "";

	public void init() {

		setBackground(Color.YELLOW);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void paint(Graphics g) {
		g.drawString(message, 50, 50);
	}

	public void mouseEntered(MouseEvent me) {
		setBackground(Color.PINK);
		message = "Mouse Entered: (" + me.getX() + ", " + me.getY() + ")";
		repaint();
	}

	public void mouseExited(MouseEvent me) {
		setBackground(Color.RED);
		message = "Mouse Exited: (" + me.getX() + ", " + me.getY() + ")";
		repaint();
	}

	public void mouseClicked(MouseEvent me) {
		setBackground(Color.CYAN);
		message = "Mouse Clicked: (" + me.getX() + ", " + me.getY() + ")";
		repaint();
	}

	public void mousePressed(MouseEvent me) {
		setBackground(Color.MAGENTA);
		message = "Mouse Pressed: (" + me.getX() + ", " + me.getY() + ")";
		repaint();
	}

	public void mouseReleased(MouseEvent me) {
		setBackground(Color.GREEN);
		message = "Mouse Released: (" + me.getX() + ", " + me.getY() + ")";
		repaint();
	}

	public void mouseMoved(MouseEvent me) {
		setBackground(Color.ORANGE);
		message = "Mouse Moved: (" + me.getX() + ", " + me.getY() + ")";
		repaint();
	}

	public void mouseDragged(MouseEvent me) {
		setBackground(Color.GRAY);
		message = "Mouse Dragged: (" + me.getX() + ", " + me.getY() + ")";
		repaint();
	}
}