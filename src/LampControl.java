public class LampControl extends DomoticDeviceControl{
    // Metodo contructor utilizado para crear el objeto LampControl, al ser una extencion de DDC, se crea mediante super
    public LampControl(int channel, Cloud c){
        super(channel, c);
    }
    // Metodo para cambiar el estado de poder de una lampara, pasa por cloud antes de llegar a lampara
    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }
    // ||||||||||||||||| Faltarian los metodos para controlar la intensidad de las luces
}