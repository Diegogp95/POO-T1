import java.util.ArrayList;

public class Cloud {
    public Cloud(int numlamps, int numshades) {
        lamps = new ArrayList<DomoticDevice>();
        rollerShades = new ArrayList<DomoticDevice>();
        numLamps = numlamps;
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
    private DomoticDevice getDomoticDeviceAtChannel( ArrayList<DomoticDevice> devices, int channel, char ddType){
        int numDD;
        if (ddType == 'L') numDD = numLamps;
        else numDD = numShades;
        while (devices.get(pos).getChannel() != channel && pos < numDD){
            pos++;
        }
        DomoticDevice dd = devices.get(pos);
        return dd;
    }
    public void changeLampPowerState(int channel){
        while (pos < numLamps){
            Lamp L = (Lamp) this.getDomoticDeviceAtChannel(lamps, channel, 'L');
            L.changePowerState();
            pos++;
        }
        pos = 0;
    }
    public void startShadeUp(int channel){
        while (pos < numShades){
            RollerShade RS = (RollerShade) this.getDomoticDeviceAtChannel(rollerShades, channel, 'R');
            RS.startUp();
            pos++;
        }
        pos = 0;
    }
    public void startShadeDown(int channel){
        while (pos < numShades){
            RollerShade RS = (RollerShade) this.getDomoticDeviceAtChannel(rollerShades, channel, 'R');
            RS.startDown();
            pos++;
        }
        pos = 0;
    }
    public void stopShade(int channel){
        while (pos < numShades){
            RollerShade RS = (RollerShade) this.getDomoticDeviceAtChannel(rollerShades, channel, 'R');
            RS.stop();
            pos++;
        }
        pos = 0;
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
        String state = "";
        for (DomoticDevice RS : rollerShades){
            state += RS.toString() + "\t";
        }
        return state;
    }
    private ArrayList<DomoticDevice> lamps;
    private ArrayList<DomoticDevice> rollerShades;
    private int numLamps;
    private int numShades;
    private static int pos = 0;
}
