/**
 * @author Drew Roberts
 * @version 1.0
 */
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Triangle implements Shape {
	private int ID;
	private int side1;
	private int side2;
	private int side3;
	private double area;
	private String color;
	private ImageIcon imgIcon;
	
	/**
	 * Creates a triangle
	 * @param ID	ID of the triangle
	 * @param sideLength1	First side's length
	 * @param sideLength2	Second side's length
	 * @param sideLength3	Third side's length
	 * @param color		Color of the triangle
	 */
	public Triangle(int ID, int sideLength1, int sideLength2, int sideLength3, String color){
		this.ID = ID;
		this.side1 = sideLength1;
		this.side2 = sideLength2;
		this.side3 = sideLength3;
		//Using Heron's formula to calculate area
		double s = (side1+side2+side3)*0.5;
		s = (s*(s-side1)*(s-side2)*(s-side3));
		this.area = Math.sqrt(s);
		
		this.color = color;
		setImageIcon();
	}
	
	/**
	 * Gets the kind of shape (triangle) and its ID
	 * @return Triangle and its ID
	 */
	public String toString(){
		return getKind() + "(ID# " + getID() + ")";
	}
	
	/**
	 * Gets the kind of shape (triangle)
	 * @return Triangle
	 */
	public String getKind(){
		return "Triangle";
	}
	
	/**
	 * Gets the triangle's kind, ID, side lengths, area, and color
	 * @return Triangle's details
	 */
	public String getDetailString(){
		String details = "<html>Triangle (ID# " + getID() + ")<br>";
		details += "Side Length 1: " + side1 + "<br>Side Length 2: " + side2;
		details += "<br>Side Length 3: " + side3 + "<br>Area: " + area;
		details += "<br>Color: " + color + "</html>";
		
		return details;
	}
	
	/**
	 * Gets the triangle's ID
	 * @return triangle's ID
	 */
	public int getID()
	{
		return ID;
	}
	
	/**
	 * Sets the image icon to an image of a triangle
	 */
	public void setImageIcon(){
		try{
			Image img = Toolkit.getDefaultToolkit().getImage("resources\\triangle.png");
			img = img.getScaledInstance(200,
				200, Image.SCALE_SMOOTH);
			imgIcon = new ImageIcon(img);
		}
		catch (Exception ex){;}
	}
	
	/**
	 * Gets the image icon of the triangle
	 * @return Triangle's image icon
	 */
	public ImageIcon getImageIcon(){
		return imgIcon;
	}
}
