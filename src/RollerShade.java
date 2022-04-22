public class RollerShade extends DomoticDevice {
    // Metodo constructor de la cortina RollerShade
    public RollerShade (int channel, double alpha, double MaxLength) {
        super(channel);
        motor = new Motor(alpha);
        MaxShadeLength = MaxLength;
        length = 0;
    }
    // Metodo para dar la señal al motor de que debe girar en sentido UP
    public void startUp(){
        motor.turnUp();
    }
    // Metodo para dar la señal al motor de que debe girar en sentido DOWN
    public void startDown(){
        motor.turnDown();
    }
    // Metodo para dar la señal al motor de que debe dejar de girar
    public void stop(){
        motor.stop();
    }
    // Metodo encargado de avanzar el tiempo un delta en el motor
    public void advanceTime(double delta){
        motor.advanceTime(delta);
    }
    // Se ejecuta cada vez que se crea el objeto otorgando un id a este
    {
        id=nextId++;
    }
    // Metodo para obtener el id del objeto
    // ||||||| no se utiliza (podria llegar a usarse si es que se necesita)
    public int getId(){
        return id;
    }
    // Metodo encargado de dar el encabezado de las cortinas usando su id
    public String getHeader(){
        String s = "RS" + id;
        return s;
    }
    // Metodo encargado de dar el estado actual de la cortina
    // ||||||||||||||| AL NO ESTAR LA TELA DE LA CORTINA MODELADA AUN ESTE METODO DEBE SER CAMBIADO MAS ADELANTE
    // CUANDO SE BUSQUE LA FUNCIONALIDAD COMPLETA DEL PROGRAMA
    public String toString(){
        String s = "";
        switch (motor.state){
            case STOPPED: s += "0"; break;
            case UPWARD: s+= "100"; break;
            case DOWNWARD: s+= "-100"; break;

        }
        return s;
    }
    // Clase anidada motor, solo se usa en RollerShade
    private class Motor { 
        // Metodo constructor de motor
        public Motor (double a){
            alpha = a;
            state = MotorState.STOPPED;
        }
        // Metodo encargado de girar el motor en sentido de que la cortina suba
        public void turnUp(){
            state = MotorState.UPWARD;
        }
        // Metodo encargado de girar el motor en sentido de que la cortina baje
        public void turnDown(){
            state = MotorState.DOWNWARD;
        }
        // Metodo encargado de detener el motor
        public void stop(){
            state = MotorState.STOPPED;
        }
        // Metodo de avance del tiempo en donde delta: delta tiempo; alpha: velocidad motor
        // |||||||| FALTARIA COMPLETAR LO QUE OCURRIRA CON LA CORTINA AL AUMENTAR O DISMINUIR 
        // LENGHT A TRAVES DE INCREMENT
        public void advanceTime(double delta){  
            double increment = alpha*delta*RADIUS;
            switch (state) {
                case STOPPED: break;
                case DOWNWARD:
                    //??
                    break;
                case UPWARD:
                    // ??
                    break;
            }
        }
        private double alpha;
        private MotorState state;
        private final double RADIUS=0.04;
    }
    public enum MotorState {
        UPWARD,
        STOPPED,
        DOWNWARD
    }
    private Motor motor;
    private double length;
    private final double MaxShadeLength;
    private static int nextId;
    private final int id;
}
