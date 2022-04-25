import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Stage2 {
    public static void main(String [] args) throws IOException {

        // Condicional que pregunta si se utiliza un archivo txt
        if (args.length != 1) {
            System.out.println("Usage: java Stage2 <configurationFile.txt>");
            System.exit(-1);
        }
        
        // Clase scanner utilizada para crear el objeto in
        Scanner in = new Scanner(new File(args[0]));
        //System.out.println("File: " + args[0]);               // Imprime el nombre del archivo que se esta leyendo
        //System.out.println(in.locale().getDisplayCountry());  // Imprime el pais de configuracion del scanner
        in.useLocale(Locale.ENGLISH);                           // Necesario cambiar a English para que reconozca puntos en ves de comas para decimales

        // reading <#_de_cortinas> <#_de_lámparas> <#_controles_cortinas> <#_controles_lámparas>
        int numRollerShades = in.nextInt();     // Se lee el numero de cortinas y se guarda en numRollerShades
        int numLamps = in.nextInt();            // Se lee el numero de lamparas y se guarda en numLamps
        int numShadeControls = in.nextInt();    // Se lee el numero de controles de cortina y se guarda en numShadeControls
        int numLampsControls = in.nextInt();    // Se lee el numero de controles de lamparas y se guarda en numLampsControls

        // Clase cloud utilizada para crear un objeto cloud
        Cloud cloud = new Cloud(numLamps, numRollerShades);        

        // read <alfa0> <length0> <canal0> … <alfaN_1> <lengthN_1> <canalN_1>
        // Importante entender que se crea solo un objeto en este proceso el cual se le soobrescribe
        // los atributos presentes en este, pero al guardarlo en el array de cloud estos quedan en este array
        // juntos bajo el nombre del array
        for(int i =0; i<numRollerShades; i++){
            Double alpha = in.nextDouble();         // Se guarda el valor de velocidad de la primera cortina, segunda, etc.
            Double maxLength = in.nextDouble();     // Se guarda el largo de la primera cortina, segunda , etc.
            int channel = in.nextInt();             // Se guarda el canal de la primera cortina, segunda , etc.
            // Clase RollerShade utilizada para crear un objeto rollerShade y luego se agrega a la nube
            DomoticDevice rollerShade = new RollerShade(channel, alpha, maxLength);
            //System.out.println(rollerShade.getId());    // Se imprimen los id de cada objeto creado
            cloud.addRollerShade(rollerShade);
        }

        // read <canal0>…..<canalL_L> de las lamparas
        // Lo mismo que con las cortinas, se soobrescribe solo un objeto que se guarda en la nuve como array
        for(int i =0; i < numLamps; i++){
            int channel = in.nextInt();             // Se guarda el canal de la primera lampara, segunda, etc.
            // Clase Lamp utilizada para crear un objeto Lamp y luego se agrega a la nube
            DomoticDevice lampara = new Lamp(channel);
            //System.out.println(lampara.getId());        // Se imprimen los id de cada objeto creado
            cloud.addLamp(lampara);
        }



        // Clase Operator utilizada para crear un objeto operator
        Operator operator = new Operator(cloud);

        // creating roller shade's control at <canal0>...<canalN>
        // Se soobrescribe el mismo objeto control con diferentes canales multiples veces
        for(int i=0; i<numShadeControls; i++){
            int channel = in.nextInt();
            // Clase ShaceControl utilizada para crear un objeto shadeControl
            DomoticDeviceControl shadeControl = new ShadeControl(channel, cloud);
            operator.addControls(shadeControl);         // Con esto se agrega el control al arreglo de controles
        }

        // creating lamp's control at <canal0>...<canalN>
        // Se soobrescribe el mismo objeto control con diferentes canales multiples veces
        for(int i=0; i<numLampsControls; i++){
            int channel = in.nextInt();
            // Clase ShaceControl utilizada para crear un objeto shadeControl
            DomoticDeviceControl lampControl = new LampControl(channel, cloud);
            operator.addControls(lampControl);          // Con esto se agrega el control al arreglo de controles
        }

        
        // Se ejecuta un metodo de operador encargado de llevar a cabo los comandos del txt
        operator.executeCommands(in, System.out); //Listo
    }
}
