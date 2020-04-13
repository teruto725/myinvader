import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	ArrayList<GameObject> gos;

	public GamePanel(ArrayList<GameObject>gos) {
		this.gos = gos;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(GameObject go:gos) {
			go.paint(g);
		}
	}
}
