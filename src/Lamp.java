public class Lamp extends DomoticDevice{
    // Metodo constructor que setea canal, inicializa rgb a 255 y estado apagado
    public Lamp (int channel){      
        super(channel);
        this.r = 255;
        this.b = 255;
        this.g = 255;
        this.state = LampState.OFF;
    }
    // Metodo de la lampara para cambiar su estado
    public void changePowerState(){
        if (this.state == LampState.OFF) this.state = LampState.ON;
        else this.state = LampState.OFF;
    }
    // Metodo para crear el string del encabezado de esta lampara en particular, se concatena en cloud los multiples headers
    public String getHeader(){      
        String header = "";
        header += "L" + id + "R\t" + "L" + id + "G\t" + "L" + id + "B";
        return header;
    }
    // Metodo para crear el string que estara en el contenido de cada lampara en particular
    public String toString(){       
        if (state==LampState.ON)
            return ""+r+"\t"+g+"\t"+b;
        else
            return "0\t0\t0";
    }
    // Se ejecuta cada vez que se crea el objeto otorgando un id a este
    {
        id=nextId++;
    }
    // Metodo para obtener el id del objeto
    // ||||||| no se utiliza (¿podria llegar a usarse si es que se necesita?)
    public int getId() { return id; }

    private enum LampState {
        ON,
        OFF
    }
    public  void changeRU(){
        if (this.r > 245) {
            this.r = 255;
        } else {
            this.r = (short) (this.r + 10);
        }
    }

    public  void changeRD(){
        if (this.r < 10) {
            this.r = (0);
        } else {
            this.r = (short) (this.r - 10);
        }
    }

    public  void changeGU(){
        if (this.g > 245) {
            this.g = 255;
        } else {
            this.g = (short) (this.g + 10);
        }
    }



    public  void changeGD(){
        if (this.g < 10) {
            this.g = (0);
        } else {
            this.g = (short) (this.g - 10);
        }
    }



    public  void changeBU(){
        if (this.b > 245) {
            this.b = 255;
        } else {
            this.b = (short) (this.b + 10);
        }
    }
    public  void changeBD(){
        if (this.b < 10) {
            this.b = (0);
        } else {
            this.b = (short) (this.b - 10);
        }
    }
    public int getIntensity(){
        int I = r+g+b;
        return I;
    }


    private short r,g,b;
    private LampState state;
    private final int id;
    private static int nextId=0;

}
