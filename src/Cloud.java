import java.util.ArrayList;

public class Cloud {

    // Metodo constructor para crear objetos cloud, recibe el numero de lamparas y cortinas
    public Cloud(int numlamps, int numshades) {
        lamps = new ArrayList<DomoticDevice>();
        rollerShades = new ArrayList<DomoticDevice>();
    }
    // Metodo para agregar la lampara l al arreglo lamps
    public void addLamp(DomoticDevice l){
        lamps.add(l);
    }
    // Metodo para agregar la cortina rs al arreglo rollerShades
    public void addRollerShade(DomoticDevice rs){
        rollerShades.add(rs);
    }
    // Metodo aplicado a todos los elementos del arreglo rollerShades, se encarga de avanzar el tiempo en los motores
    // por ende se encarga de darle valores al motor con los cuales subir o bajar de a intervalos la cortina
    public void advanceTime(double delta){
        for (DomoticDevice dd: rollerShades) {
            RollerShade rs =(RollerShade)dd;    // Se esta forzando el cambio de la referencia de clase dd a roller para aplicar el metodo siguiente
            rs.advanceTime(delta);              // Se aplica un metodo solo presente en clase roller
        }
    }
    // Metodo utilizado para cambiar el estado de los objetos lamparas dentro del arreglo de DD de lamparas
    public void changeLampPowerState(int channel){
        for (DomoticDevice l: lamps){
            if (l.getChannel() == channel){
            Lamp LP = (Lamp)l;
            LP.changePowerState();
            }
        }
    }
    // Metodo utilizado para cambiar el estado de los objetos motor dentro de cortinas, a su vez dentro del arreglo de DD de cortinas,
    // sube la cortina a travez de la clase anidada motor
    public void startShadeUp(int channel){
        for (DomoticDevice rs: rollerShades){
            if (rs.getChannel() == channel){
            RollerShade RS = (RollerShade)rs;
            RS.startUp();
            }
        }
    }
    // Metodo utilizado para cambiar el estado de los objetos motor dentro de cortinas, a su vez dentro del arreglo de DD de cortinas,
    // baja la cortina a travez de la clase anidada motor
    public void startShadeDown(int channel){
        for (DomoticDevice rs: rollerShades){
            if (rs.getChannel() == channel){
            RollerShade RS = (RollerShade)rs;
            RS.startDown();
            }
        }
    }
    // Metodo utilizado para cambiar el estado de los objetos motor dentro de cortinas, a su vez dentro del arreglo de DD de cortinas,
    // detiene la cortina a travez de la clase anidada motor
    public void stopShade(int channel){
        for (DomoticDevice rs: rollerShades){
            if (rs.getChannel() == channel){
            RollerShade RS = (RollerShade)rs;
            RS.stop();
            }
        }
    }
    // Metodo para obtener la cabecera de la salida del documento pedido, no es necesario cambiar el puntero de DD a lampara/cortina 
    // segun corresponda, ya que, getHeader es abstracta en la clase DD y se ejecuta en la clase lampara/cortina
    public String getHeaders(){
        String header = "";
        for (DomoticDevice  rs: rollerShades){
            header += rs.getHeader()+"\t";
        }
        for (DomoticDevice l: lamps){
            header += l.getHeader()+"\t";
        }
        return header;
    }
    // Metodo para obtener la informacion de la salida del documento pedido, no es necesario cambiar el puntero de DD a lampara/cortina 
    // segun corresponda, ya que, getState es abstracta en la clase DD y se ejecuta en la clase lampara/cortina
    public String getState(){
        String state = "";
        for (DomoticDevice RS : rollerShades){
            state += RS.toString() + "\t";
        }
        for (DomoticDevice l: lamps){
            state += l.toString()+"\t";
        }
        return state;
    }
    // Metodo creado solo para dar los valores iniciales de las lamparas en donde
    // estas estan apagadas pero con todos sus valores en 255
    public String getStateInitial(){
        String content = "";
        for (int i=0 ; i < rollerShades.size(); i++){
            content += "0\t";
        }
        for (int i=0 ; i < lamps.size(); i++){
            content += "255\t255\t255\t";
        }
        return content;
    }
    private ArrayList<DomoticDevice> lamps;
    private ArrayList<DomoticDevice> rollerShades;
}
