/**
 * Created by Trevor on 1/31/2017.
 */
public class Ground extends Terrain {
    Ground(AOEInterface aoe){
        tileCharacter='G';
        movePenalty = 1;
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
    
    @Override
	public int getTypeID() {
		return GameInfo.GROUND;
	}
}
