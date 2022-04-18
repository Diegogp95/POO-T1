public class LampControl {
    public LampControl(int channel, Cloud c){
        this.channel = channel;
        this.cloud = c;
    }
    public void pressRedUp(){
        cloud.changeLampRGB(channel, RedUp);
    }/*
    public void pressRedDown(){
        cloud.changeLampRGB(RedDown);
    }
    public void pressGreenUp(){
        cloud.changeLampRGB(GreenUp);
    }
    public void pressGreenDown(){
        cloud.changeLampRGB(GreenDown);
    }
    public void pressBlueUp(){
        cloud.changeLampRGB(BlueUp);
    }
    public void pressBlueDown(){
        cloud.changeLampRGB(BlueDown);
    } */



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
