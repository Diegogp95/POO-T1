import java.util.ArrayList;

public class Cloud {
    public Cloud() {
        lamps = new ArrayList<Lamp>();
    }
    public void addLamp(Lamp l){
        lamps.add(l);
    }
    /*
    public Lamp getLampAtChannel( int channel){
        //???
    } */
    public void changeLampPowerState(int channel){
        for (Lamp l : lamps)
            if (l.getChannel() == channel) l.changePowerState();
    }
    public void changeLampRGB(int channel, int RGB){
        for (Lamp l : lamps)
            if (l.getChannel() == channel) Operator.changeRGB(RGB);
    }
    private ArrayList<Lamp> lamps; // getting ready for next stages
}
