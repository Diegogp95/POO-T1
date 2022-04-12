import java.util.Random;

public class Lamp {
    public Lamp (int channel){      // constructor que setea canal, inicializa rgb random y estado apagado
        this.channel = channel;
        this.r = (short) rand.nextInt(256);
        this.b = (short) rand.nextInt(256);
        this.g = (short) rand.nextInt(256);
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

    public String getHeader(){
       //??
    }
    public String toString(){
        if (state==LampState.ON)
            return ""+r+"\t"+g+"\t"+b;
        else
            return "0\t0\t0";
    }

    private Random rand = new Random();
    private int channel;
    private short r,g,b;
    private LampState state;
    private final int id;  // to conform lamp's header
    private static int nextId=0;
}
