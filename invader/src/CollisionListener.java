import java.util.ArrayList;

public class CollisionListener {
	ArrayList<GameObject> gos;

	public CollisionListener(ArrayList<GameObject>gos) {
		this.gos = gos;
	}
	public boolean update(){//tureならゲームオーバー
		ArrayList<Teki> tekilist = new ArrayList<Teki>();
		ArrayList<Tama> tamalist = new ArrayList<Tama>();
		Jiki jiki = new Jiki();
		for(int i = 0;i<gos.size();i++) {
			if(gos.get(i) instanceof Teki){
				tekilist.add((Teki)gos.get(i));
			}
			if(gos.get(i) instanceof Jiki){
				jiki = (Jiki)gos.get(i);
			}
			if(gos.get(i) instanceof Tama){
				tamalist.add((Tama)gos.get(i));
			}
		}
		for(int i = 0;i<tekilist.size();i++){
			for(int j =0; j<tamalist.size();i++){
				if (collisionTekiTama(tekilist.get(i),tamalist.get(j))){//当たったら消す
					tekilist.remove(i);
					gos.remove(gos.indexOf(tekilist.get(i)));
				}
				if (collisionTekiJiki(tekilist.get(i),jiki)){
					return true;//ゲームオーバー
				}
			}
		}
		return false;
	}
	private boolean collisionTekiJiki(Teki teki, Jiki jiki) {
		//敵の上||みぎ｜｜左｜｜下｜｜
		if (teki.y+teki.height <jiki.y || teki.x+teki.width < jiki.x || teki.x < jiki.x+jiki.width || teki.y > jiki.y+jiki.height){
			return true;

		}
		return false;
	}
	private boolean collisionTekiTama(Teki teki, Tama tama){
		if (teki.y+teki.height <tama.y || teki.x+teki.width > tama.x || teki.x < tama.x+tama.width || teki.y > tama.y+tama.height){
			return true;

		}
		return false;

	}
}
