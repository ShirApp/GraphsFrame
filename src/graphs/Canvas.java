/*
 * The class represents the canvas area for drawing the graphs
 */

package graphs;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;

public class Canvas extends JPanel {
  	private static Graphics g2d;
  	private static BufferedImage img;
  	private ArrayList<Point> points = new ArrayList<Point>(); //an array for saving the points of current graph
  	private Point p1, p2; //temporary points for drawing a line 
  	private static int NUM_OF_POINTS = 0; //static parameter for counting the number of points in current graph 

	public Canvas(ArrayList<Point> points){     
	 	img = new BufferedImage(500,500, BufferedImage.TYPE_INT_ARGB);
	 	g2d = img.createGraphics();
     	g2d.setColor(Color.BLACK); //drawing color
 	 	MyMouseListener m = new MyMouseListener();
 	 	addMouseListener(m);
 	 	this.points = points;
	}

	//the paint method for graphics object
	public void paint(Graphics g) {
		g.clearRect(0, 0, 1000, 1000);
        g.setColor(Color.WHITE);
		g.drawImage(img,0,0,null);
	}

	//method for restarting the count and the canvas
    public void clear() {
    	points.clear();
    	NUM_OF_POINTS = 0;
    	new Canvas(points);
    	this.repaint();
    }
    
    //mouse listener class for the actual drawing of lines 
	class MyMouseListener extends MouseAdapter{
	int x1=-1,x2=-1,y1=-1,y2=-1;
	
			public  void mousePressed(MouseEvent e){
				points.add(e.getPoint());		
				NUM_OF_POINTS++;
			}
			
			public  void mouseReleased(MouseEvent e)
			{
				if(NUM_OF_POINTS > 1) {
					p1 = points.get(NUM_OF_POINTS-2);
					p2 = points.get(NUM_OF_POINTS-1);
					g2d.drawLine((int)p1.getX(), (int)p1.getY() ,(int)p2.getX(),(int)p2.getY());
					repaint();		 
				}
			}
	   }
	
}

