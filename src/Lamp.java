public class Lamp {
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
    public int getR(){
        return r;
    }

    public int getB(){
        return b;
    }

    public int getG(){
        return g;
    }
    public void changeR(int RGB){
        this.r = RGB;
    }

    public void changeB(int RGB){
        this.b = RGB;
    }

    public void changeG(int RGB){
        this.g = RGB;
    }

    public void changePowerState(){
       if (this.state == LampState.OFF) this.state = LampState.ON;
       else this.state = LampState.OFF;
    }

    /* public String getHeader(){
       //??
    } */
    public String toString(){
        if (state==LampState.ON)
            return ""+r+"\t"+g+"\t"+b;
        else
            return "0\t0\t0";
    }

    public int getId() { return id; }
    
    private int channel;
    public int r,g,b;
    private LampState state;
    private final int id;  // to conform lamp's header
    private static int nextId=0;
}
