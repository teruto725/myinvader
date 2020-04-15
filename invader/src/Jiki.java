import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Jiki extends GameObject {
	int speed = 3;
	int interval = 0;
	public Jiki() {
		x = 250;
		y = 400;
		width = 48;
		height = 48;
	}
	@Override
	void loadimage() {
		try {
			BufferedImage bi = ImageIO.read(new File("Spaceship.png"));
			this.image = new Image[12];
			for(int i=0;i<3;i++) {
				for(int j=0;j<4;j++) {
					image[i*4+j]=bi.getSubimage(j*48, i*48,48,48);
				}
			}

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	@Override
	void paint(Graphics g) {
		g.drawImage(image[anime], x, y, null);
		anime = (anime+1)%4;

	}

	@Override
	void update(GameKeyListener kl,GameObjectlist gos) {
		//System.out.println(x+":"+y);
		interval= interval==0?0:interval-1;
		if (kl.left) {
			x -= speed;
		}
		if (kl.right) {
			x += speed;
		}
		if (kl.up) {
			y -= speed;
		}
		if (kl.down) {
			y += speed;
		}
		if (kl.space) {
			if(interval==0) {
				gos.addTama(new Tama(this));
				interval = 10;
			}
		}
	}

}
