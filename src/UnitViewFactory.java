import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class UnitViewFactory {
	private BufferedImage explorer;
	private BufferedImage colonist;
	private BufferedImage ranged;
	private BufferedImage melee;
	private BufferedImage explorerEnemy;
	private BufferedImage colonistEnemy;
	private BufferedImage rangedEnemy;
	private BufferedImage meleeEnemy;
	
	public UnitViewFactory(){
		try {
			explorer=ImageIO.read(new File("Explorer.jpg"));
			colonist=ImageIO.read(new File("Colonist.jpg"));
			ranged=ImageIO.read(new File("Ranged.jpg"));
			melee=ImageIO.read(new File("Melee.jpg"));
			explorerEnemy=ImageIO.read(new File("EnemyExplorer.jpg"));
			colonistEnemy=ImageIO.read(new File("EnemyColonist.jpg"));
			rangedEnemy=ImageIO.read(new File("EnemyRanged.jpg"));
			meleeEnemy=ImageIO.read(new File("EnemyMelee.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public UnitView getUnitView(Unit unit, boolean opponent){
		if(opponent){
			if(unit instanceof Explorer){
				return new UnitView(explorerEnemy);
			}
			if(unit instanceof Colonist){
				return new UnitView(colonistEnemy);
			}
			if(unit instanceof RangedFighter){
				return new UnitView(rangedEnemy);
			}
			if(unit instanceof MeleeFighter){
				return new UnitView(meleeEnemy);
			}
		}
		
		if(unit instanceof Explorer){
			return new UnitView(explorer);
		}
		if(unit instanceof Colonist){
			return new UnitView(colonist);
		}
		if(unit instanceof RangedFighter){
			return new UnitView(ranged);
		}
		if(unit instanceof MeleeFighter){
			return new UnitView(melee);
		}
		return null;
	}
}
