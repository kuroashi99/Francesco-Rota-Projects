package board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Board extends JPanel implements MouseMotionListener, MouseListener {
	//This can be ignored for the moment
	private static final long serialVersionUID = 5700171535857723408L;
	
	private Image background;
	private Color color;
	private ArrayList<Point> points;
	
	public Board() {
		points = new ArrayList<Point>();
		color = Color.BLUE;
		background = null;
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	public void setBackground(Image img) {
		if(img != null) {
			background = img;
			background = background.getScaledInstance(
					getSize().width, getSize().height, Image.SCALE_SMOOTH);
			repaint();
		}
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void clean() {
		points.clear();
		background = null;
		repaint();
	}
	
	public void drawBackground(Graphics g) {
		if(background == null)
			setBackground(Color.WHITE);
		else {			
			g.drawImage(background, 0, 0, null);
		}
	}
	
	//NO paintComponents
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBackground(g);
		for(Point p : points) {
			g.setColor(p.c);
			g.fillOval(p.x, p.y, p.dimension, p.dimension);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = new Point(e.getX(), e.getY(), color);
		points.add(p);
		this.repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Point p = new Point(e.getX(), e.getY(), color);
		points.add(p);
		this.repaint();
	}
	
	public void componentResized() {
		if(background != null) {
			background = background.getScaledInstance(
					getSize().width, getSize().height, Image.SCALE_SMOOTH);
			//Repaint should be automatic when there is a resize of the windo:
			//just in case you can call repaint here! 
			//repaint();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {}
	
	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
