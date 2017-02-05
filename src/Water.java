/**
 * Created by Trevor on 1/31/2017.
 */
public class Water extends Terrain {
    Water(AOEInterface aoe){
        tileCharacter='W';
        movePenalty = 2;
        tileAOE = aoe;
    }

    @Override
    boolean isTraversableBy(Unit unit) {
        return true;
    }

    @Override
    void effect(Unit unit) {
        unit.setActionPoints(unit.getActionPoints() - movePenalty);
        tileAOE.doEffect(unit);
    }
}
