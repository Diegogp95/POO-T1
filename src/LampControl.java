public class LampControl {
    public LampControl(int channel, Cloud c){
        this.channel = channel;
        this.cloud = c;
    }
    public void pressRedUp(){
        cloud.changeLampRGB(int channel, RedUp);
    }
    public void pressRedDown(){
        cloud.changeLampPowerState(RedDown);
    }
    public void pressGreenUp(){
        cloud.changeLampPowerState(GreenUp);
    }
    public void pressGreenDown(){
        cloud.changeLampPowerState(GreenDown);
    }
    public void pressBlueUp(){
        cloud.changeLampPowerState(BlueUp);
    }
    public void pressBlueDown(){
        cloud.changeLampPowerState(BlueDown);
    }



    public int getChannel(){return channel;}
    private int channel;
    private Cloud cloud;
    private int RedUp = 1;
    private int RedDown= 2;
    private int BlueUp = 3;
    private int BlueDown = 4;
    private int GreenUp = 5;
    private int GreenDown = 6;
}
