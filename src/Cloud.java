import java.util.ArrayList;

public class Cloud {
    public Cloud(int numlamps, int numshades) {
        lamps = new ArrayList<DomoticDevice>();
        rollerShades = new ArrayList<DomoticDevice>();
        numlamps = numlamps;
        numShades = numshades;
    }
    public void addLamp(Lamp l){
        lamps.add(l);
    }
    public void addRollerShade(RollerShade rs){
        rollerShades.add(rs);
    }
    public void advanceTime(double delta){
        for (DomoticDevice dd: rollerShades) {
            RollerShade rs =(RollerShade)dd;
            rs.advanceTime(delta);
        }
    }
    private DomoticDevice getDomoticDeviceAtChannel( ArrayList<DomoticDevice> devices, int channel, int position){
        while (devices.get(position).getChannel() != channel){
            position++;
        }

    }
    public void changeLampPowerState(int channel){
        // ???
    }
    public void startShadeUp(int channel){

    }
    public void startShadeDown(int channel){
        // ???
    }
    public void stopShade(int channel){
        // ???
    }
    public String getHeaders(){
        String header = "";
        for (DomoticDevice  rs: rollerShades)
            header += rs.getHeader()+"\t";
        for (DomoticDevice l: lamps)
            header += l.getHeader()+"\t";
        return header;
    }
    public String getState(){
        // ???
    }
    private ArrayList<DomoticDevice> lamps;
    private ArrayList<DomoticDevice> rollerShades;
    private int numLamps;
    private int numShades;
}
