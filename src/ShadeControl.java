public class ShadeControl extends DomoticDeviceControl{
    // Metodo contructor utilizado para crear el objeto ShadeControl, al ser una extencion de DDC, se crea mediante super
    public ShadeControl(int channel, Cloud c){
        super(channel, c);
    }
    // Todos los metodos de control de cortina pasan por la nube antes de llegar a su destinatario
    // Metodo para decirle al motor de la cortina que suba la cortina
    public void startUp(){
        cloud.startShadeUp(channel);
    }
    // Metodo para decirle al motor de la cortina que baje la cortina
    public void startDown(){
        cloud.startShadeDown(channel);
    }
    // Metodo para decirle al motor de la cortina que detenga la cortina
    public void stop(){
        cloud.stopShade(channel);
    }
}
