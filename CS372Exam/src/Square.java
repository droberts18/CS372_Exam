/**
 * @author Drew Roberts
 * @version 1.0
 */
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Square implements Shape {
	private int ID;
	private int sideLength;
	private double area;
	private String color;
	private ImageIcon imgIcon;
	
	/**
	 * Creates a square
	 * @param ID	ID of the square
	 * @param sideLength	Side length of the square
	 * @param color		Color of the square
	 */
	public Square(int ID, int sideLength, String color){
		this.ID = ID;
		this.sideLength = sideLength;
		this.area = sideLength * sideLength;
		this.color = color;
		setImageIcon();
	}
	
	/**
	 * Gets the kind of shape (square) and ID for the shape
	 * @return Square and its ID
	 */
	public String toString(){
		return getKind() + "(ID# " + getID() + ")";
	}
	
	/**
	 * Gets the kind of shape(square)
	 * @return Square
	 */
	public String getKind(){
		return "Square";
	}
	
	/**
	 * Gets square's kind, ID, side length, area, and color
	 * @return Details about the square
	 */
	public String getDetailString(){
		String details = "<html>Square (ID# " + getID() + ")";
		details += "<br>Side Length: " + sideLength+ "<br>Area: " + area;
		details += "<br>Color: " + color + "</html>";
		
		return details;
	}
	
	/**
	 * Gets the square's ID
	 * @return Square's ID
	 */
	public int getID()
	{
		return ID;
	}

	/**
	 * Sets the image icon to an image of a square
	 */
	public void setImageIcon(){
		try{
			Image img = Toolkit.getDefaultToolkit().getImage("resources\\square.png");
			img = img.getScaledInstance(200,
				200, Image.SCALE_SMOOTH);
			imgIcon = new ImageIcon(img);
		}
		catch (Exception ex){;}
	}
	
	/**
	 * Returns the image icon of a square
	 * @return image icon
	 */
	public ImageIcon getImageIcon(){
		return imgIcon;
	}
}
