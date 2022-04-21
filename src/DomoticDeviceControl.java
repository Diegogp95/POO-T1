public class DomoticDeviceControl {
    public DomoticDeviceControl(int ch, Cloud c){
        this.cloud = c;
        this.channel = ch;
    }
    public int getChannel() {
        return channel;
    }
    protected Cloud cloud;
    protected int channel;
}
