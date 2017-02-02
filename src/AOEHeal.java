/**
 * Created by zrgam_000 on 2/1/2017.
 */
public class AOEHeal implements AOEInterface {

    @Override
    public void doEffect(Unit unit) {
        unit.healMe(2);
    }
}
