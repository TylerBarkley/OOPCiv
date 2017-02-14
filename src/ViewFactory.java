import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ViewFactory {
	private static ViewFactory factory;
	
	private BufferedImage explorer;
	private BufferedImage colonist;
	private BufferedImage ranged;
	private BufferedImage melee;
	private BufferedImage explorerEnemy;
	private BufferedImage colonistEnemy;
	private BufferedImage rangedEnemy;
	private BufferedImage meleeEnemy;
	private BufferedImage water;
	private BufferedImage ground;
	private BufferedImage mountain;
	private BufferedImage base;
	private BufferedImage baseEnemy;

	private BufferedImage redCross;

	private BufferedImage skullCrossBones;

	private BufferedImage rallyPoint;
	
	private ViewFactory(){
		try {
			explorer=ImageIO.read(getClass().getResource("/Explorer.jpg"));
			colonist=ImageIO.read(getClass().getResource("/Colonist.jpg"));
			ranged=ImageIO.read(getClass().getResource("/Ranged.jpg"));
			melee=ImageIO.read(getClass().getResource("/Melee.jpg"));
			explorerEnemy=ImageIO.read(getClass().getResource("/EnemyExplorer.jpg"));
			colonistEnemy=ImageIO.read(getClass().getResource("/EnemyColonist.jpg"));
			rangedEnemy=ImageIO.read(getClass().getResource("/EnemyRanged.jpg"));
			meleeEnemy=ImageIO.read(getClass().getResource("/EnemyMelee.jpg"));
			water=ImageIO.read(getClass().getResource("/Water.png"));
			ground=ImageIO.read(getClass().getResource("/Ground.png"));
			mountain=ImageIO.read(getClass().getResource("/Mountain.png"));
			base=ImageIO.read(getClass().getResource("/Base.jpg"));
			baseEnemy=ImageIO.read(getClass().getResource("/EnemyBase.jpg"));
			redCross=ImageIO.read(getClass().getResource("/RedCross.jpg"));
			skullCrossBones=ImageIO.read(getClass().getResource("/SkullCrossBones.jpg"));
			rallyPoint=ImageIO.read(getClass().getResource("/Rallypoint.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public View getView(Viewable viewable, boolean opponent){
		if(opponent){
			if(viewable.getTypeID() == GameInfo.EXPLORER){
				return new View(explorerEnemy);
			}
			if(viewable.getTypeID() == GameInfo.COLONIST){
				return new View(colonistEnemy);
			}
			if(viewable.getTypeID() == GameInfo.RANGEDUNIT){
				return new View(rangedEnemy);
			}
			if(viewable.getTypeID() == GameInfo.MELEEUNIT){
				return new View(meleeEnemy);
			}
			if(viewable.getTypeID() == GameInfo.BASE_VIEW_ID){
				return new View(baseEnemy);
			}
		}
		
		return getView(viewable);
	}


	public View getView(Viewable viewable) {
		if(viewable.getTypeID() == GameInfo.EXPLORER){
			return new View(explorer);
		}
		if(viewable.getTypeID() == GameInfo.COLONIST){
			return new View(colonist);
		}
		if(viewable.getTypeID() == GameInfo.RANGEDUNIT){
			return new View(ranged);
		}
		if(viewable.getTypeID() == GameInfo.MELEEUNIT){
			return new View(melee);
		}
		if(viewable.getTypeID() == GameInfo.BASE_VIEW_ID){
			return new View(base);
		}
		if(viewable.getTypeID() == GameInfo.WATER){
			return new View(water);
		}
		if(viewable.getTypeID() == GameInfo.GROUND){
			return new View(ground);
		}
		if(viewable.getTypeID() == GameInfo.MOUNTAIN){
			return new View(mountain);
		}
		if(viewable.getTypeID() == GameInfo.SKULLCROSSBONES){
			return new View(skullCrossBones);
		}
		if(viewable.getTypeID() == GameInfo.REDCROSS){
			return new View(redCross);
		}
		if(viewable.getTypeID() == GameInfo.RALLYPOINT){
			return new View(rallyPoint);
		}
		return null;
	}


	public static ViewFactory getFactory() {
		if(factory ==null){
			factory=new ViewFactory();
		}
		
		return factory;
	}
}
