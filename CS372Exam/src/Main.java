/**
 * @author Drew Roberts
 * @version 1.0
 */
import java.io.*;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Main extends JComponent {
	//	ArrayList to hold all shapes created from text file
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	JFrame frame = new JFrame();
	
	// Reads from the file and creates the window
	private void initialize(){
		try (FileInputStream is = new FileInputStream("resources\\shapes.txt")){ 
			InputStreamReader ir = new InputStreamReader(is);
			BufferedReader rdr = new BufferedReader(ir);
			
			String line = rdr.readLine();
			//Reads the entire file until it ends
			while(line != null){
				// Separates each part based on when a space character is hit
				String[] parts = line.split(" ");
				String shape = parts[0].substring(0, parts[0].length()-1);
				
				if(shape.equals("circle")){
					shapes.add(new Circle(Integer.parseInt(parts[1]), 
							Integer.parseInt(parts[2]), parts[3]));
				}
				else if(shape.equals("square")){
					shapes.add(new Square(Integer.parseInt(parts[1]),
							Integer.parseInt(parts[2]), parts[3]));
				}
				else if(shape.equals("rectangle")){
					shapes.add(new Rectangle(Integer.parseInt(parts[1]),
							Integer.parseInt(parts[2]), Integer.parseInt(parts[3]),
							parts[4]));
				}
				else{
					shapes.add(new Triangle(Integer.parseInt(parts[1]),
							Integer.parseInt(parts[2]), Integer.parseInt(parts[3]),
							Integer.parseInt(parts[4]), parts[5]));
				}
				line = rdr.readLine();
			}
		}
		catch(Exception ex) { System.out.println("Failed to open shapes.txt");}
		
		frame.setBounds(0, 0, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Container c = frame.getContentPane();
		c.setBackground(Color.GRAY);
		
		// Creates scroll pane for list of shapes
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 136, 439);
		frame.getContentPane().add(scrollPane);
		
		// Adding shapes to list
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for(Shape s: shapes)
			listModel.addElement(s.toString());
		
		JList<String> list = new JList<String>(listModel);
		list.setFont(new Font("Tahoma", Font.PLAIN, 11));
		list.ensureIndexIsVisible(shapes.size()-1);
		list.setBounds(10, 11, 217, 439);
		scrollPane.add(list);
		scrollPane.setViewportView(list);
		
		JLabel infoLabel = new JLabel("");
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setForeground(Color.WHITE);
		infoLabel.setBounds(156, 13, 568, 209);
		frame.getContentPane().add(infoLabel);
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setBounds(243, 233, 407, 181);
		frame.getContentPane().add(imageLabel);
		
		// Outputs the shape's details and images according to the index of the selected list element.
		// The shapes in the ArrayList shapes have the same indexes as their corresponding
		// list elements.
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int correspondingIndex = list.getSelectedIndex();
				infoLabel.setText(shapes.get(correspondingIndex).getDetailString());
				imageLabel.setIcon(shapes.get(correspondingIndex).getImageIcon());
			}
		});
	}
	
	// Outputs the window and content
	public Main() {
		initialize();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Main m = new Main();
	}
}
