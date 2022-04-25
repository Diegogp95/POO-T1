import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Operator {
    // Metodo constructor de operador
    public Operator(Cloud c){
        arregloControles = new ArrayList<DomoticDeviceControl>();       // Arreglo importante ya que contendra todos los controles, similar a lo que hace cloud
        this.cloud = c;                                                 // cuando guarda las cortinas/lamparas
    }
    // Metodo para agregar controles al arreglo de controles general de aparatos DDC
    public void addControls(DomoticDeviceControl controls){
        arregloControles.add(controls);
    }
    // Metodo principal de operador, este se encarga de leer el txt y dar el inicio de la cadena
    // de metodos que resultaran en la impresion del .csv
    public void executeCommands(Scanner in, PrintStream out){
        // Imprime el encabezado y el contenido de las lamparas/cortinas ya creadas en stage 2 dependiendo de sus estados
        out.println("Time\t" + cloud.getHeaders());

        // Siempre y cuando el siguiente token pueda ser interpretado como int estara en el while
        while(in.hasNextInt()){
            int commandTime=in.nextInt();                   // El commandtime es el primer numero de la linea de comando
            while (time < commandTime) {                    // Este while se encarga de darle pequeños intervalos al motor para que suba o baje de a poco
                out.println(time+"\t"+cloud.getState());
                cloud.advanceTime(delta);
                time+=delta;
            }
            String device=in.next();                        // Lee el string de si es cortina o lampara                   
            if (!(device.equals("C") || device.equals("L"))){    // Si no reconoce el aparato detiene el programa                     
                out.println("Unexpected device:" + device);           
                System.exit(-1);
            }
            int channel = in.nextInt();                     // Lee el canal que ejecutara la orden
            String command=in.next();                       // Lee el comando presente en la linea
            for(int i=0; i<arregloControles.size();i++){
                if (channel == arregloControles.get(i).getChannel()){  // Este if compara el channel leido en comando con el channel del DDC en la posicion i del arreglo DDC      
                    switch (command.charAt(0)){           // .chartAt(0) devuelve la letra guardada en command(0) y la usa en el switch, switch para operar
                        // Casos para la cortina
                        case 'D':
                        if (arregloControles.get(i) instanceof ShadeControl){                  // Se pregunta si es control de cortina, de no ser no deberia ejecutar D(posible error externo)
                            ShadeControl castControl = (ShadeControl) arregloControles.get(i);  // Se castea a clase ShadeControl para usar metodos
                            castControl.startDown();
                        }
                        break;
                        case 'U':
                        if (arregloControles.get(i) instanceof ShadeControl){                   // Se pregunta si es control de cortina, de no ser no deberia ejecutar D(posible error externo)
                            ShadeControl castControl = (ShadeControl) arregloControles.get(i);  // Se castea a clase ShadeControl para usar metodos
                            castControl.startUp();
                        }
                        break;
                        case 'S':
                        if (arregloControles.get(i) instanceof ShadeControl){                   // Se pregunta si es control de cortina, de no ser no deberia ejecutar D(posible error externo)
                            ShadeControl castControl = (ShadeControl) arregloControles.get(i);  // Se castea a clase ShadeControl para usar metodos
                            castControl.stop();
                        }
                        break;
                        // Casos para la lampara
                        case 'P':                       // Caso de encender o apagar la lampara
                            if (arregloControles.get(i) instanceof LampControl){                   // Se pregunta si es control de lamp, de no ser no deberia ejecutar D(posible error externo)
                                LampControl castControl = (LampControl) arregloControles.get(i);  // Se castea a clase Lampcontrol para usar metodos
                                castControl.pressPower();
                            }
                        break;
                        case 'R':                       // Caso en donde se le manda un mensaje a la lampara, al color R
                            if (arregloControles.get(i) instanceof LampControl){
                                String comandoR = in.next();
                                switch (comandoR.charAt(0)){
                                    case 'U':
                                        // Se deberia ejecutar el metodo para subir la luz roja
                                    break;
                                    case 'D':
                                        // Se deberia ejecutar el metodo para subir la luz roja
                                    break;
                                    default:
                                    out.println("Unexpected command Lamp: " + comandoR);           
                                    System.exit(-1);
                                    break;
                                }
                            }
                        break;
                        case 'G':                       // Caso en donde se le manda un mensaje a la lampara, al color G
                            if (arregloControles.get(i) instanceof LampControl){
                                String comandoG = in.next();
                                switch (comandoG.charAt(0)){
                                    case 'U':
                                        // Se deberia ejecutar el metodo para subir la luz verde
                                    break;
                                    case 'D':
                                        // Se deberia ejecutar el metodo para bajar la luz verde
                                    break;
                                    default:
                                    out.println("Unexpected command Lamp:" + comandoG);           
                                    System.exit(-1);
                                }
                            }
                        break;
                        case 'B':                       // Caso en donde se le manda un mensaje a la lampara, al color B
                            if (arregloControles.get(i) instanceof LampControl){
                                String comandoB = in.next();
                                switch (comandoB.charAt(0)){
                                    case 'U':
                                        // Se deberia ejecutar el metodo para subir la luz azul
                                    break;
                                    case 'D':
                                        // Se deberia ejecutar el metodo para bajar la luz azul
                                    break;
                                    default:
                                    out.println("Unexpected command Lamp:" + comandoB);           
                                    System.exit(-1);
                                }
                            }
                        break;
                        default: out.println("Unexpected command:" + command);
                            System.exit(-1);
                        break;
                    }
                }
            }
        }
    }
    private double time=0;
    private Cloud cloud;
    private final double delta=0.1;
    private ArrayList<DomoticDeviceControl> arregloControles;
}
