import java.io.PrintStream;
import java.util.Scanner;

public class Operator {
    public Operator(LampControl lc, Cloud c){
        this.lampControl = lc;
        this.cloud = c;
    }
    public void executeCommands(Scanner in, PrintStream out){
        out.println("Time \t" + cloud.getHeaders());
        out.println(time + "\t" + cloud.getState());
        while(in.hasNextInt()){
            time=in.nextInt();
            String string=in.next();
            if (!string.equals("L")) {
                out.println("Unexpected device:" + string);
                System.exit(-1);
            }
            int channel = in.nextInt();
            if (channel != 0){
                out.println("Unexpected channel:" + channel);
                System.exit(-1);
            }
            String cmnd = in.next();
            if (!cmnd.equals("P")){
                out.println("Unexpected command:" + cmnd);
                System.exit(-1);
            }
            lampControl.pressPower();
            out.println(time + "\t" + cloud.getState());
        }
    }
    private double time=0;
    private LampControl lampControl;
    private Cloud cloud;
}
