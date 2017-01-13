/**
 * @author Drew Roberts
 * @version 1.0
 */
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Rectangle implements Shape {
	private int ID;
	private int length;
	private int width;
	private double area;
	private String color;
	private ImageIcon imgIcon;
	
	/**
	 * Creates a rectangle
	 * @param ID	ID of the rectangle
	 * @param length	Length of the rectangle
	 * @param width		Width of the rectangle
	 * @param color		Color of the rectangle
	 */
	public Rectangle(int ID, int length, int width, String color){
		this.ID = ID;
		this.length = length;
		this.width = width;
		this.area = length * width;
		this.color = color;
		setImageIcon();
	}
	
	/**
	 * Gets the kind of shape (rectangle) and its ID
	 * @return Rectangle and its ID
	 */
	public String toString(){
		return getKind() + "(ID# " + getID() + ")";
	}
	
	/**
	 * Gets the kind of shape(rectangle)
	 * @return Rectangle
	 */
	public String getKind(){
		return "Rectangle";
	}
	
	/**
	 * Gets rectangle's kind, ID, length, width, area, and color
	 * @return Details about the rectangle
	 */
	public String getDetailString(){
		String details = "<html>Rectangle (ID# " + getID() + ")";
		details += "<br>Length: " + length + "<br>Width: " + width;
		details += "<br>Area: " + area;
		details += "<br>Color: " + color + "</html>";
		
		return details;
	}
	
	/**
	 * Gets the rectangle's ID
	 * @return ID of the rectangle
	 */
	public int getID()
	{
		return ID;
	}
	
	/**
	 * Sets the image icon to an image of a rectangle
	 */
	public void setImageIcon(){
		try{
			Image img = Toolkit.getDefaultToolkit().getImage("resources\\rectangle.png");
			img = img.getScaledInstance(200,
				200, Image.SCALE_SMOOTH);
			imgIcon = new ImageIcon(img);
		}
		catch (Exception ex){;}
	}
	
	/**
	 * Gets the image icon of a rectangle
	 * @return image icon of rectangle
	 */
	public ImageIcon getImageIcon(){
		return imgIcon;
	}
}
