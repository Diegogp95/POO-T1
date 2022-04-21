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

    private int channel;
    private short r,g,b;
    private LampState state;
    private final int id;  // to conform lamp's header
    private static int nextId=0;
}
