/**
 * @author Drew Roberts
 * @version 1.0
 */
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Circle implements Shape {
	private int ID;
	private int radius;
	private double area;
	private String color;
	private ImageIcon imgIcon;
	
	/**
	 * Creates a circle
	 * @param ID	ID of the circle
	 * @param radius	Radius of the circle
	 * @param color		Color of the circle
	 */
	public Circle(int ID, int radius, String color){
		this.ID = ID;
		this.radius = radius;
		this.area = 3.14*(radius * radius);
		this.color = color;
		setImageIcon();
	}
	
	/**
	 * Gets the kind of shape(circle) and ID
	 * @return Circle and its ID
	 */
	public String toString(){
		return getKind() + "(ID# " + getID() + ")";
	}
	
	/**
	 * Gets the kind of shape (circle)
	 * @return Circle
	 */
	public String getKind(){
		return "Circle";
	}
	
	/**
	 * Gets the circle's kind, ID, radius, area, and color
	 * @return Shape's details
	 */
	public String getDetailString(){
		String details = "<html>Circle (ID# " + getID() + ")";
		details += "<br>Radius: " + radius + "<br>Area: " + area;
		details += "<br>Color: " + color + "</html>";
		
		return details;
	}
	
	/**
	 * Returns the shape's ID
	 * @return Shape's ID
	 */
	public int getID()
	{
		return ID;
	}
	
	/**
	 * Sets the image icon as an image of a circle
	 */
	public void setImageIcon(){
		try{
			Image img = Toolkit.getDefaultToolkit().getImage("resources\\circle.png");
			img = img.getScaledInstance(200,
				200, Image.SCALE_SMOOTH);
			imgIcon = new ImageIcon(img);
		}
		catch (Exception ex){;}
	}
	
	/**
	 * Gets the image icon of the circle
	 * @return The circle's image icon
	 */
	public ImageIcon getImageIcon(){
		return imgIcon;
	}
}
