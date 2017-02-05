/**
 * Created by zrgam_000 on 1/31/2017.
 */
public class CID {
    int typeID;
    int personelID;

    public static CID giveCID(Player player,int concreteTypeID){
        int typeId=concreteTypeID;
        int personelID=0;
        for(int i=0;i< player.getUnits().get(typeId).size();i++){
            if(player.getUnits().get(typeId).get(i)==null){
                personelID=i;

            }
        }
        return new CID(typeId,personelID);
    }
    public CID(int TID, int PID){
        typeID = TID;
        personelID = PID;
    }
}
