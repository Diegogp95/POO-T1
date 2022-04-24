public class LampControl extends DomoticDeviceControl{
    // Metodo contructor utilizado para crear el objeto LampControl, al ser una extencion de DDC, se crea mediante super
    public LampControl(int channel, Cloud c){
        super(channel, c);
    }
    // Metodo para cambiar el estado de poder de una lampara, pasa por cloud antes de llegar a lampara
    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }


    public void pressRD(){cloud.changeLampRD(channel);}
    public void pressRU(){cloud.changeLampRU(channel);}

    public void pressGD(){cloud.changeLampGD(channel);}
    public void pressGU(){cloud.changeLampGU(channel);}

    public void pressBD(){cloud.changeLampBD(channel);}
    public void pressBU(){cloud.changeLampBU(channel);}


    // ||||||||||||||||| Faltarian los metodos para controlar la intensidad de las luces
}