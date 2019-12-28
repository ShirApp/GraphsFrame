/*
 * The class represents an axis, that can be modified
 */

package graphs;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Axis extends JPanel{
	private static final long serialVersionUID = 1L;
	private int start = 0, end = 100, space = 10; //parameters for axis
	private int []array; //the calculated array on axis
	private int length = 11; //length of axis
	
	public Axis(int start, int end, int space, boolean x_Or_y) { //true for x axis, false for y axis
		super();
		this.start = start;
		this.end = end;
		this.space = space;
		paint(x_Or_y);
	}

	//the method includes the GUI of the axis (x or y)
	public void paint(boolean x_Or_y) {
		length = (end-start)/space + 1;
	    array = createArray(start, end, space);
		if (x_Or_y == true) { //x axis
			setBorder(BorderFactory.createMatteBorder(
	                3, 0, 0, 0, Color.black));
			setLayout(new GridLayout(1, length));
		    for(int j=0; j<length; j++) {
		    	JLabel l = new JLabel();
		    	l.setText(Integer.toString(array[j]));
		    	add(l);			
		    }	
		}else { //y axis
			setBorder(BorderFactory.createMatteBorder(
	                0, 0, 0, 3, Color.black));
			setLayout(new GridLayout(length, 1));
		    for(int j=length-1; j>=0; j--) {
		    	JLabel l = new JLabel();
		    	l.setText(Integer.toString(array[j]));
		    	add(l);			
		    }
		}
	}
	
	//the method creates the exact array according to the 
	public int[] createArray(int start, int end, int space) {
		int [] array = new int[length];
		array[0] = start;
		array[1] = start + space;
		for(int i=2; i<length; i++) {
			array[i] = array[i-1] + space;
		}
		return array;
	}
	
	//method for updating the axis array according to a new input
    public void update(int start, int end, int space, boolean x_Or_y) {
		this.start = start;
		this.end = end;
		this.space = space;
    	paint(x_Or_y);
    }

}
