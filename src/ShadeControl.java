public class ShadeControl extends DomoticDeviceControl{
    public ShadeControl(int channel, Cloud c){
        // ??
    }
    public void startUp(){
        cloud.startShadeUp(channel);
    }
    public void startDown(){cloud.startShadeDown(channel);}
    public void stop(){cloud.starShadeStop(channel);}
}
