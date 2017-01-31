/**
 * Created by Trevor on 1/30/2017.
 */
public class Map {
    int mapXSize;
    int mapYSize;
    Terrain terrainType;
    Tile [][] map;

    Map(int mapXsize,int mapYsize){
        this.mapXSize=mapXsize;
        this.mapYSize=mapYsize;
        map= new Tile [mapXSize][mapYSize];
        for(int i=0;i<mapXSize;i++){
            for(int j=0;j<mapYSize;j++) {
               map[i][j]=new Tile(i,j);
            }
        }
    }

    void print(){
        for(int i=0;i<mapXSize;i++){
            for(int j=0;j<mapYSize;j++){
                System.out.print("  ");
                map[i][j].print();
                System.out.print("  ");
            }
            System.out.println();
        }
    }

public static void main(String argsp[]){
    Map map=new Map(10,10);
    Unit u=new MeleeFighter("MeleeFighter",map.map[0][1],map);
    u.move('W');
    u.printStats();
    map.print();
    u.move('S');
    map.print();
    return;
    }
}
