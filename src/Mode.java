/**
 * Created by hankerins on 1/31/17.
 */

//TODO: add constructors to modes

public abstract class Mode {

    Player player;

    int currentType = 0;
    int currentInstance = 0;

    abstract int cycleTypeL();
    abstract int cycleTypeR();

    abstract int cycleInstanceL();
    abstract int cycleInstanceR();

}
