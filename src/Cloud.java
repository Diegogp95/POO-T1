import java.util.ArrayList;

public class Cloud {
    public Cloud() {
        lamps = new ArrayList<DomoticDevice>();
        rollerShades = new ArrayList<DomoticDevice>();
    }
    /*
    public void addLamp(Lamp l){
        lamps.add(l);
    } */
    public void addRollerShade(RollerShade rs){
        rollerShades.add(rs);
    }
    public void advanceTime(double delta){
        for (DomoticDevice dd: rollerShades) {
            RollerShade rs =(RollerShade)dd;
            rs.advanceTime(delta);
        }
    }
    private DomoticDevice getDomoticDeviceAtChannel( ArrayList<DomoticDevice> devices, int channel){
        int id = 0;
        DomoticDevice R = devices.get(id);
        while ( R.getChannel() != channel){
            id++;
            R = rollerShades.get(id);
        }
        return R;   // Dudoso
    }
    /*
    public void changeLampPowerState(int channel){
        // ???
    } */
    public void startShadeUp(int channel){
        DomoticDevice d = getDomoticDeviceAtChannel(rollerShades,channel);
        RollerShade r = (RollerShade) d;
        r.startUp();
    }
    public void startShadeDown(int channel){
        DomoticDevice d = getDomoticDeviceAtChannel(rollerShades,channel);
        RollerShade r = (RollerShade) d;
        r.startDown();
    }
    public void stopShade(int channel){
        DomoticDevice d = getDomoticDeviceAtChannel(rollerShades,channel);
        RollerShade r = (RollerShade) d;
        r.stop();
    }
    public String getHeaders(){
        String header = "";
        for (DomoticDevice  rs: rollerShades)
            header += rs.getHeader()+"\t";
        for (DomoticDevice l: lamps)
            header += l.getHeader()+"\t";
        return header;
    }
    public String getState() {  // Revisar entrada del State
        String Estados = "";
        for (DomoticDevice d:rollerShades) {
            RollerShade r = (RollerShade) d;
            Estados += r.getState();
        }
        return Estados;
    }
    private ArrayList<DomoticDevice> lamps;
    private ArrayList<DomoticDevice> rollerShades;
}
