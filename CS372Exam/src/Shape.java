/**
 * @author Drew Roberts
 * @version 1.0
 */
import javax.swing.ImageIcon;

public interface Shape {
	String toString();
	String getKind();
	String getDetailString();
	int getID();
	void setImageIcon();
	ImageIcon getImageIcon();
}
