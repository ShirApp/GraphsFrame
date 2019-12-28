/*
 * The class represents the GUI of all frame
 */

package graphs;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class GUI implements MouseListener{
	private JPanel bottumPanel = new JPanel(); //the panel for buttons
	private JButton clear = new JButton("clear");
	private JButton setX = new JButton("setXAxis");
	private JButton setY = new JButton("setYAxis");
	private JPanel graph = new JPanel(); //the panel that includes the axis and the drawing canvas 
	private ArrayList<Point> points = new ArrayList<Point>(); //an array of points in current graph
	private Canvas drawGraphPan = new Canvas(points); //the drawing area
	private int start = 0, end = 100, space = 10;
	private Axis xAxisPan = new Axis(start, end, space, true);
	private Axis yAxisPan = new Axis(start, end, space, false);
	private JFrame frame;
		
	public GUI (){
		frame = new JFrame("GRAPHS");
		frame.setSize(500,500);
		setX.addMouseListener(this);		
		setY.addMouseListener(this);
		clear.addMouseListener(this);
		graph.setLayout(new BorderLayout());
		graph.add(drawGraphPan, BorderLayout.CENTER);
		graph.add(xAxisPan, BorderLayout.SOUTH);
		graph.add(yAxisPan, BorderLayout.WEST);
		bottumPanel.add(clear);
		bottumPanel.add(setX);
		bottumPanel.add(setY);
		frame.getContentPane().add(graph);
		frame.getContentPane().add(bottumPanel,"South");
	    frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == clear){ //clearing the canvas
	    	points.clear();
			drawGraphPan.clear();

		}else { //for setting x or y axis
			String startInput = JOptionPane.showInputDialog("Enter start of X axis");
		    start = Integer.parseInt(startInput);
			String endInput = JOptionPane.showInputDialog("Enter end of X axis");
			end = Integer.parseInt(endInput);
			String spaceInput = JOptionPane.showInputDialog("Enter space in X axis");
		    space = Integer.parseInt(spaceInput);
		    frame.getContentPane().invalidate();
			if (e.getSource() == setX) {
			    xAxisPan.removeAll();
			    xAxisPan.update(start, end, space, true);
			}else if (e.getSource() == setY) {
			    yAxisPan.removeAll();
			    yAxisPan.update(start, end, space, false);
			}
		    frame.getContentPane().validate();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
