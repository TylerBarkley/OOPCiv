/**
 * Created by Trevor on 1/31/2017.
 */
public abstract class Terrain {
    char tileCharacter;
    boolean isTraversable;
    int movePenalty;
    AOEInterface tileAOE;

   abstract boolean isTraversableBy(Unit unit);

   abstract void effect(Unit unit);

   void print(){
       System.out.print(tileCharacter);
   }

}
