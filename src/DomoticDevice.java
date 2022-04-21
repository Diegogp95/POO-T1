public abstract class DomoticDevice {
    public DomoticDevice(int id, int channel){
        this.channel = channel;
        this.id     = id;
    }
    public DomoticDevice(){
        this.channel=channel;
    }

    public int getChannel() {
        return channel;
    }
    public int getId() {
        return id;
    }
    public abstract String getHeader();
    protected int id;
    protected int channel;

}
