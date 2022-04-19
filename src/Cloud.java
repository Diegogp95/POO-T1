import java.util.ArrayList;

public class Cloud {
    public Cloud() {
        lamps = new ArrayList<Lamp>();
    }
    public void addLamp(Lamp l){
        lamps.add(l);
    }
    public Lamp getLampAtChannel( int channel){
        int id = 0;
        Lamp L = lamps.get(id);
        while ( L.getChannel() != channel){
            id++;
            L = lamps.get(id);
        }
        return L;
    }
    public void changeLampPowerState(int channel){
        Lamp l = getLampAtChannel(channel);
        l.changePowerState();
    }
    public String getHeaders(){
        String header = "";
        for (Lamp l: lamps)
            header += l.getHeader();
        return header;
    }
    public String getState(){
        String state = "";
        for (Lamp l : lamps){
            state += l.toString();
        }
        return  state;
    }
    private ArrayList<Lamp> lamps; // getting ready for next stages
}
