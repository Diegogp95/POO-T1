public class LightSensor {
    public LightSensor(int channel, Cloud c) {
        this.channel = channel;
        this.c = c;
    }

    // Llama a comparar las intensidades de las lamparas en un canal
    // Si todas superan el umbral comienza a bajar las cortinas del mismo canal
    public void senseLamps(){
        boolean flag = c.compareIntensity(channel, threshold);
        if(flag){
            c.startShadeDown(channel);
        }
    }

    private int channel;
    private Cloud c;
    private final int threshold = 512;
}
