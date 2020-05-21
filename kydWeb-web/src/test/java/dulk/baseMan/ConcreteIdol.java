package dulk.baseMan;

import java.util.ArrayList;
import java.util.List;

public class ConcreteIdol implements Idol {
   public List<Fan> fanArrayList=new ArrayList<Fan>();
    @Override
    public void addFan(Fan fan) {
        fanArrayList.add(fan);
    }

    @Override
    public void removeFan(Fan fan) {
        fanArrayList.remove(fan);
    }

    @Override
    public void notify(String message) {
        for(Fan fan:fanArrayList){
            fan.updata(message);
        }
    }
}
