import java.awt.Graphics;

public class Tama extends GameObject{
	public Tama(Jiki j) {
		this.width = 10;
		this.height = 10;
		this.x = j.x+j.width/2-this.width/2;
		this.y = j.y;
	}
	@Override
	void loadimage() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	void update(GameKeyListener kl,GameObjectlist gos) {
		y-=10;
		if(y<-50) {
			gos.delTama(this);
		}
	}

	@Override
	void paint(Graphics g) {
		g.fillRect(x, y, 10, 10);
	}

}
