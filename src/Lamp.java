public class Lamp extends DomoticDevice{
    public Lamp (int channel){      // constructor que setea canal, inicializa rgb random y estado apagado
        this.channel = channel;
        this.r = 255;
        this.b = 255;
        this.g = 255;
        this.state = LampState.OFF;
    }
    {
        id=nextId++;
    }
    public int getChannel(){
        return channel;
    }
    public void changePowerState(){
        if (this.state == LampState.OFF) this.state = LampState.ON;
        else this.state = LampState.OFF;
    }

    public String getHeader(){      // crea cabeza de salida, solo lámparas
        String header = "";
        header += "L" + id + "R\t" + "L" + id + "G\t" + "L" + id + "B\t";
        return header;
    }
    public String toString(){       // crea estado de lámpara para
        if (state==LampState.ON)
            return ""+r+"\t"+g+"\t"+b;
        else
            return "0\t0\t0";
    }

    public int getId() { return id; }

    private enum LampState {
        ON,
        OFF
    }

    public  void changeRGB(String RGB){
        if (RGB == "RU") {
            if (this.r > 245) {
                this.r = 256 ;
            } else {
                this.r = (short) (this.r + 10);
            }
        }
        if (RGB == "") {
            if (this.r < 10) {
                this.r = (0);
            } else {
                this.r = (this.r - 10);
            }
        }
        if (RGB == 3) {
            if (this.b > 245) {
                this.b = 256 ;
            } else {
                this.b = (this.b + 10);
            }
        }
        if (RGB == 4) {
            if (this.b < 10) {
                this.b = (0);
            } else {
                this.b = (this.b - 10);
            }
        }
        if (RGB == 5) {
            if (this.g > 245) {
                this.g = 256 ;
            } else {
                this.g = (this.g + 10);
            }
        }
        if (RGB == 6) {
            if (this.g < 10) {
                this.g = 0;
            } else {
                this.g = (this.g - 10);
            }
        }
    }

    private int channel;
    private short r,g,b;
    private LampState state;
    private final int id;  // to conform lamp's header
    private static int nextId=0;
}
