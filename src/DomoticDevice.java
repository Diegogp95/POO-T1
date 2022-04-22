public abstract class DomoticDevice {
    // Metodo constructor para crear objetos DD, tener en cuenta que DD es abstract
    public DomoticDevice(int ch){
        this.channel = ch;
    }
    // Metodo para obtener el canal del DD, transversal para los objetos cortina/lampara
    public int getChannel() {
        return channel;
    }
    // Metodos que se utilizaran dentro de cada clase lampara/cortina pero que varian dependiendo
    // de cada clase por lo que se definen abstract
    public abstract int getId();
    public abstract String getHeader();
    public abstract String toString();

 
    private int channel;
}
