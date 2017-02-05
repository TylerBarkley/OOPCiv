/**
 * Created by Trevor on 1/30/2017.
 */
import java.util.Random;
public class Map {
    int mapXSize;
    int mapYSize;
    Tile [][] tileMatrix;

    enum MapDirection {NORTH, SOUTH, EAST, WEST, NORTHEAST, NORTHWEST, SOUTHEAST, SOUTHWEST}

    Map(int mapXsize,int mapYsize,boolean random) {
        if(random) {
            this.mapXSize = mapXsize;
            this.mapYSize = mapYsize;
            Random rn = new Random();
            char[] tileTypes = {'G', 'W', 'M'};
            tileMatrix = new Tile[mapXSize][mapYSize];
            for (int i = 0; i < mapXSize; i++) {
                for (int j = 0; j < mapYSize; j++) {
                    tileMatrix[i][j] = new Tile(new Location(i, j), tileTypes[rn.nextInt(3)]);
                }
            }
        }
        else{
            this.mapXSize = 10;
            this.mapYSize = 10;
            tileMatrix = new Tile [mapXSize][mapYSize];
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 10; j++){
                    tileMatrix[i*9][j] = new Tile (new Location(i*9,j), 'G');
                }
            }
            tileMatrix[1][0] = new Tile (new Location(1,0), 'G');
            tileMatrix[1][1] = new Tile (new Location(1,1), 'G');
            tileMatrix[1][2] = new Tile (new Location(1,2), 'G');
            tileMatrix[1][3] = new Tile (new Location(1,3), 'G');
            tileMatrix[1][4] = new Tile (new Location(1,4), 'G');
            tileMatrix[1][5] = new Tile (new Location(1,5), 'M');
            tileMatrix[1][6] = new Tile (new Location(1,6), 'M');
            tileMatrix[1][7] = new Tile (new Location(1,7), 'G');
            tileMatrix[1][8] = new Tile (new Location(1,8), 'G');
            tileMatrix[1][9] = new Tile (new Location(1,9), 'G');

            tileMatrix[2][0] = new Tile (new Location(2,0), 'W');
            tileMatrix[2][1] = new Tile (new Location(2,1), 'G');
            tileMatrix[2][2] = new Tile (new Location(2,2), 'G');
            tileMatrix[2][3] = new Tile (new Location(2,3), 'G');
            tileMatrix[2][4] = new Tile (new Location(2,4), 'G');
            tileMatrix[2][5] = new Tile (new Location(2,5), 'G');
            tileMatrix[2][6] = new Tile (new Location(2,6), 'M');
            tileMatrix[2][7] = new Tile (new Location(2,7), 'M');
            tileMatrix[2][8] = new Tile (new Location(2,8), 'G');
            tileMatrix[2][9] = new Tile (new Location(2,9), 'W');

            tileMatrix[3][0] = new Tile (new Location(3,0), 'W');
            tileMatrix[3][1] = new Tile (new Location(3,1), 'G');
            tileMatrix[3][2] = new Tile (new Location(3,2), 'G');
            tileMatrix[3][3] = new Tile (new Location(3,3), 'G');
            tileMatrix[3][4] = new Tile (new Location(3,4), 'M');
            tileMatrix[3][5] = new Tile (new Location(3,5), 'M');
            tileMatrix[3][6] = new Tile (new Location(3,6), 'G');
            tileMatrix[3][7] = new Tile (new Location(3,7), 'M');
            tileMatrix[3][8] = new Tile (new Location(3,8), 'G');
            tileMatrix[3][9] = new Tile (new Location(3,9), 'W');

            tileMatrix[4][0] = new Tile (new Location(4,0), 'W');
            tileMatrix[4][1] = new Tile (new Location(4,1), 'G');
            tileMatrix[4][2] = new Tile (new Location(4,2), 'G');
            tileMatrix[4][3] = new Tile (new Location(4,3), 'M');
            tileMatrix[4][4] = new Tile (new Location(4,4), 'M');
            tileMatrix[4][5] = new Tile (new Location(4,5), 'G');
            tileMatrix[4][6] = new Tile (new Location(4,6), 'M');
            tileMatrix[4][7] = new Tile (new Location(4,7), 'G');
            tileMatrix[4][8] = new Tile (new Location(4,8), 'G');
            tileMatrix[4][9] = new Tile (new Location(4,9), 'W');

            tileMatrix[5][0] = new Tile (new Location(5,0), 'W');
            tileMatrix[5][1] = new Tile (new Location(5,1), 'W');
            tileMatrix[5][2] = new Tile (new Location(5,2), 'W');
            tileMatrix[5][3] = new Tile (new Location(5,3), 'W');
            tileMatrix[5][4] = new Tile (new Location(5,4), 'M');
            tileMatrix[5][5] = new Tile (new Location(5,5), 'M');
            tileMatrix[5][6] = new Tile (new Location(5,6), 'G');
            tileMatrix[5][7] = new Tile (new Location(5,7), 'G');
            tileMatrix[5][8] = new Tile (new Location(5,8), 'W');
            tileMatrix[5][9] = new Tile (new Location(5,9), 'W');

            tileMatrix[6][0] = new Tile (new Location(6,0), 'W');
            tileMatrix[6][1] = new Tile (new Location(6,1), 'G');
            tileMatrix[6][2] = new Tile (new Location(6,2), 'G');
            tileMatrix[6][3] = new Tile (new Location(6,3), 'G');
            tileMatrix[6][4] = new Tile (new Location(6,4), 'G');
            tileMatrix[6][5] = new Tile (new Location(6,5), 'G');
            tileMatrix[6][6] = new Tile (new Location(6,6), 'W');
            tileMatrix[6][7] = new Tile (new Location(6,7), 'M');
            tileMatrix[6][8] = new Tile (new Location(6,8), 'G');
            tileMatrix[6][9] = new Tile (new Location(6,9), 'W');

            tileMatrix[7][0] = new Tile (new Location(7,0), 'W');
            tileMatrix[7][1] = new Tile (new Location(7,1), 'G');
            tileMatrix[7][2] = new Tile (new Location(7,2), 'G');
            tileMatrix[7][3] = new Tile (new Location(7,3), 'G');
            tileMatrix[7][4] = new Tile (new Location(7,4), 'G');
            tileMatrix[7][5] = new Tile (new Location(7,5), 'G');
            tileMatrix[7][6] = new Tile (new Location(7,6), 'M');
            tileMatrix[7][7] = new Tile (new Location(7,7), 'G');
            tileMatrix[7][8] = new Tile (new Location(7,8), 'G');
            tileMatrix[7][9] = new Tile (new Location(7,9), 'W');

            tileMatrix[8][0] = new Tile (new Location(8,0), 'G');
            tileMatrix[8][1] = new Tile (new Location(8,1), 'G');
            tileMatrix[8][2] = new Tile (new Location(8,2), 'G');
            tileMatrix[8][3] = new Tile (new Location(8,3), 'G');
            tileMatrix[8][4] = new Tile (new Location(8,4), 'G');
            tileMatrix[8][5] = new Tile (new Location(8,5), 'M');
            tileMatrix[8][6] = new Tile (new Location(8,6), 'G');
            tileMatrix[8][7] = new Tile (new Location(8,7), 'G');
            tileMatrix[8][8] = new Tile (new Location(8,8), 'G');
            tileMatrix[8][9] = new Tile (new Location(8,9), 'G');


        }
    }

    //TEST map for demo


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
