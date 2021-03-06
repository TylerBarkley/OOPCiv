/**
 * Created by zrgam_000 on 1/31/2017.
 */
public class GameInfo {
    public static final int MAX_UNITS = 25, MAX_PER_TYPE = 10, MAX_ARMIES = 10;

    //Number of Types of different Units and Structures
    public static final int UNIT_TYPES = 4, STRUCTURE_TYPES = 1, TERRAIN_TYPES = 3;

    public final static int EXPLORER     	= 0;
    public final static int COLONIST    	= 1;
    public final static int MELEEUNIT    	= 2;
    public final static int RANGEDUNIT    	= 3;

    public final static int BASE            = 0;
    
    public final static int BASE_VIEW_ID    = 4;
    public final static int ARMY            = 5;

    public final static int RALLYPOINT      = 6;

    public final static int WATER			=101;
    public final static int GROUND			=102;
    public final static int MOUNTAIN		=103;
    
    public final static int SKULLCROSSBONES	=201;
    public final static int REDCROSS		=202;
    
    public final static int ENTIREARMY     	= 0;
    public final static int BATTLEGROUP    	= 1;
    public final static int REINFORCEMENTS 	= 2;

    public final static int MAP_SIZE        = 10;

    public final static int TILE_SIZE		=100;
    public final static int DECAL_SIZE		=20;
    public final static int UNIT_SIZE		=40;
    public final static int ARMY_SIZE		=40;
    public final static int STRUCTURE_SIZE	=80;
    public final static int RALLYPOINT_SIZE =20;

    public final static int RALLYPOINTMODE  = 0;
    public final static int ARMYMODE       	= 1;
    public final static int UNITMODE       	= 2;
    public final static int STRUCTUREMODE   = 3;
    
    //Names of all units and Strucutres types to be displayed on the Structure and Unit viewports 
    public final static String[] UNIT_TYPES_NAMES = {"EXPLORER","COLONIST","MELEE","RANGE","ARMY"}; //Always keep the "Army" as the very last position in array for Jtable
    public final static String[] STRUCTURE_TYPES_NAMES = {"BASE"}; 
}
