public class DomoticDeviceControl {
    public DomoticDeviceControl(int channel, Cloud c){
        this.channel = channel;
        this.cloud   = c;
    }
    public int getChannel() {
        return channel;
    }
    protected Cloud cloud;
    protected int channel;
}
