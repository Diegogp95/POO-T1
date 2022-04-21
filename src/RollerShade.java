public class RollerShade extends DomoticDevice {
    public RollerShade (int id, int channel, double alpha, double MaxLength) {
        super(id, channel);
        motor = new Motor(alpha);
        MaxShadeLength = MaxLength;
        length = 0;
    }
    public void startUp(){
        motor.turnUp();
    }
    public void startDown(){
        motor.turnDown();
    }
    public void stop(){
        motor.stop();
    }
    public void advanceTime(double delta){
        motor.advanceTime(delta);
    }
    public String getHeader(){
        String s = "RS" + getId();
        return s;
    }
    public String toString(){
        String s = "";
        switch (motor.state){
            case STOPPED: s += "0"; break;
            case UPWARD: s+= "100"; break;
            case DOWNWARD: s+= "-100"; break;

        }
        return s;
    }
    private class Motor {  //nested class, Motor is only used within RollerShade.
        public Motor (double a){
            alpha = a;
            state = MotorState.STOPPED;
        }

        public void turnUp(){
            state = MotorState.UPWARD;
        }
        public void turnDown(){
            state = MotorState.DOWNWARD;
        }
        public void stop(){
            state = MotorState.STOPPED;
        }
        public void advanceTime(double delta){  // delta: delta tiempo; alpha: velocidad motor
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
}
