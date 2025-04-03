package pedro.com.app;

import pedro.com.app.mvc.model.SlotMachine;
import pedro.com.app.mvc.view.SlotMachineView;
import pedro.com.app.mvc.controller.SlotMachineController;

/**
 * Clase principal que inicializa la aplicación de la máquina tragamonedas.
 */
public class Main {
    
    /**
     * Método principal que inicia la ejecución del programa.
     *
     * @param args Argumentos de línea de comandos (no utilizados en esta aplicación).
     */
    public static void main(String[] args) {
        // Creación del modelo con un saldo inicial de 100
        SlotMachine model = new SlotMachine(100);
        
        // Creación de la vista
        SlotMachineView view = new SlotMachineView();
        
        // Creación del controlador que gestiona la interacción entre el modelo y la vista
        new SlotMachineController(model, view);

        // Hacer visible la vista
        view.setVisible(true);
    }
}