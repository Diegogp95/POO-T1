public class DomoticDeviceControl {
    // Metodo constructor de la clase DDC
    public DomoticDeviceControl(int ch, Cloud c){
        this.cloud = c;
        this.channel = ch;
    }
    // Metodo para saber el canal del control, independiente si es de lampara o cortina
    public int getChannel() {
        return channel;
    }
    protected Cloud cloud;
    protected int channel;
}
