public class RollerShade extends DomoticDevice {
    public RollerShade(int channel, double alpha, double length) {
        // Ojo con esto, no entra bien channel;
        motor = new Motor(alpha);
        this.length= length;
    }
    public RollerShade(int id, int channel){
        super(id,channel);
    }

    public void startUp() {
        motor.turnUp();
    }

    public void startDown() {
        motor.turnDown();
    }

    public void stop() {
        motor.stop();
    }
    public String getState(){
        return motor.GetMotorState();
    }

    public void advanceTime ( double delta){motor.advanceTime(delta);}
    public String getHeader () {
                String s = "RS" + getId();
                return s;
    }
    public String toString () {
                String s = String.valueOf(Math.round(length / MaxShadeLength * 100));
                return s;
    }
    private static class Motor {  //nested class, Motor is only used within RollerShade.
        public Motor(double a) {
            alpha = a;
            state = MotorState.STOPPED;
        }
        public enum MotorState {
            UPWARD,
            STOPPED,
            DOWNWARD
        }
        public String GetMotorState(){
            if (state==MotorState.STOPPED){
                return "0";
            }
            if (state==MotorState.UPWARD){
                return "100";
            }
            else {
                return "-100";
            }
        }
        public void turnUp() {
            state = MotorState.UPWARD;
        }

        public void turnDown() {
            state = MotorState.DOWNWARD;
        }

        public void stop() {
            state = MotorState.STOPPED;
        }

        public void advanceTime(double delta) {
            double increment = alpha * delta * RADIUS;
            switch (state) {
                case STOPPED:
                    break;
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
        private static double RADIUS = 0.04;
    }

    private Motor motor;
    private double length;
    private final double MaxShadeLength = 100; // Por ejemplo
    private static int nextId;
}
