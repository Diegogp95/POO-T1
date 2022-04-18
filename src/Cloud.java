import java.util.ArrayList;

public class Cloud {
    public Cloud() {
        lamps = new ArrayList<Lamp>();
    }
    public void addLamp(Lamp l){
        lamps.add(l);
    }
    public void changeLampPowerState(int channel){
        for (Lamp l : lamps)
            if (l.getChannel() == channel) l.changePowerState();
    }
    public void changeLampRGB(int channel, int RGB){
        for (Lamp l : lamps)
            if (l.getChannel() == channel) l.changeRGB(RGB);
    }
    public String getHeaders(){
        String header = "";
        for (Lamp l: lamps)
            header += l.getHeader();
        return header;
    }
    public String getState(){
        return "hola";
    }

    private ArrayList<Lamp> lamps; // getting ready for next stages
}
