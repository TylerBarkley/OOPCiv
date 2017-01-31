/**
 * Created by Zac on 1/31/2017.
 */
public class Player {
    int numUnits = 0;
    Unit[][] units;
    Structure[][] structures;
    Army[] armies;
    RallyPoint[] rallyPoints;

    public Player(){
        units = new Unit[GameInfo.UNIT_TYPES][GameInfo.MAX_PER_TYPE];

        structures = new Structure[GameInfo.STRUCTURE_TYPES][GameInfo.MAX_PER_TYPE];

        armies = new Army[GameInfo.MAX_ARMIES];

        rallyPoints = new RallyPoint[GameInfo.MAX_ARMIES];
    }
}
