import java.awt.Graphics;
import java.awt.Image;

public abstract class GameObject {
	int x,y;
	int width,height;
	int anime;
	Image image[];
	public GameObject() {
		loadimage();
	}
	abstract void loadimage();

	abstract void update(GameKeyListener kl);

	abstract void paint(Graphics g);
}
