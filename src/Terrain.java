/**
 * Created by Trevor on 1/31/2017.
 */
public abstract class Terrain {
    char tileCharacter;
    boolean isTraversable;
    Terrain(){}

   boolean isTraversableBy(Unit unit){
       /* Some BullShit Code to test if a specific unit can pass*/
        return isTraversable; //Always returns true
   }
   void print(){
       System.out.print(tileCharacter);

   }

}
