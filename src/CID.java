/**
 * Created by zrgam_000 on 1/31/2017.
 */
public class CID {
    int modeID;  //Whether the Controllable is Unit, Structure, or Army/RallyPoint
    int typeID;  //Type, as defined by GameInfo constants
    int personelID;  //index in the relevant array where this object will be stored

    //CID is combination of type (GameInfo.EXPLORER, for example) and
    // personelID == the place in the Type array where this controllable is going to go

    public CID(){
        modeID = 0;
        typeID = 0;
        personelID = 0;
    }

    public static CID giveCID(Player player,int controllableTypeID){
        int typeId=controllableTypeID;
        int personelID=0;
        if(controllableTypeID < GameInfo.UNIT_TYPES){
            for(int i=0;i< player.getUnits().get(typeId).size();i++){
                if(player.getUnits().get(typeId).get(i)==null){
                    personelID=i;

                }
            }
        }
        else if(controllableTypeID == GameInfo.BASE){
            for(int i=0;i< player.getStructures().get(0).size();i++){ //looks at Base array
                if(player.getStructures().get(0).get(i)==null){
                    personelID=i;
                }
            }
        }
        else if(controllableTypeID == GameInfo.ARMY){
            for(int i=0;i< player.getArmies().size();i++){ //looks at Army array
                if(player.getArmies().get(i)==null){
                    personelID=i;
                }
            }
        }
        else if(controllableTypeID == GameInfo.RALLYPOINT){
            for(int i=0;i< player.getRallyPoints().size();i++){ //looks at Rally Point array
                if(player.getRallyPoints().get(i)==null){
                    personelID=i;
                }
            }
        }

        return new CID(typeId,personelID);
    }

    public CID(int TID, int PID){
        typeID = TID;
        personelID = PID;
    }

    public int getTypeID(){
        return typeID;
    }
    public int getPersonelID(){
        return personelID;
    }
}
