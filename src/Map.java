/**
 * Created by Trevor on 1/30/2017.
 */
import java.util.Random;
public class Map {
    int mapXSize;
    int mapYSize;
    Tile [][] tileMatrix;

    enum MapDirection {NORTH, SOUTH, EAST, WEST, NORTHEAST, NORTHWEST, SOUTHEAST, SOUTHWEST}

    Map(int mapXsize,int mapYsize,boolean random){
        this.mapXSize=mapXsize;
        this.mapYSize=mapYsize;
        Random rn= new Random();
        char [] tileTypes={'G','W','M'};
        tileMatrix = new Tile [mapXSize][mapYSize];
        for(int i=0;i<mapXSize;i++){
            for(int j=0;j<mapYSize;j++) {
                tileMatrix[i][j] = new Tile(new Location(i,j),tileTypes[rn.nextInt(3)]);
            }
        }
    }
    Map(int mapXsize,int mapYsize){
        this.mapXSize=mapXsize;
        this.mapYSize=mapYsize;
        Random rn= new Random();
        tileMatrix = new Tile [mapXSize][mapYSize];
        for(int i=0;i<mapXSize;i++){
            for(int j=0;j<mapYSize;j++) {
                tileMatrix[i][j]=  new Tile(new Location(i,j),'G');
            }
        }
    }

    Tile getTile(Location loc){
        return tileMatrix[loc.x][loc.y];
    }

    void print(){
        for(int i=0;i<mapXSize;i++){
            for(int j=0;j<mapYSize;j++){

            }
            System.out.println();
        }
    }

public static void main(String argsp[]){
    //Map map=new Map(10,10,true);
    //Unit u=new MeleeFighter("MeleeFighter",map.tileMatrix[0][1],map);
    //u.move('W');
    //u.printStats();
    //map.print();
    //u.move('S');
    //map.print();
    //return;
    }
}
