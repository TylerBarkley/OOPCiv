/**
 * Created by Trevor on 1/31/2017.
 */
public class Mountain extends Terrain {
    Mountain(AOEInterface aoe){
        tileCharacter='M';
        movePenalty = 2;
        tileAOE = aoe;
    }

    @Override
    boolean isTraversableBy(Unit unit) {
        return false;
    }

    @Override
    void effect(Unit unit) {
        unit.actionPoints -= movePenalty;
        tileAOE.doEffect(unit);
    }
}
