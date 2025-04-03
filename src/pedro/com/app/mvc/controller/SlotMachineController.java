package pedro.com.app.mvc.controller;

import pedro.com.app.mvc.model.SlotMachine;
import pedro.com.app.mvc.view.SlotMachineView;

import javax.swing.*;

/**
 * Controlador de la máquina tragamonedas que gestiona la interacción entre el modelo y la vista.
 */
public class SlotMachineController {
    private SlotMachine model;
    private SlotMachineView view;

    /**
     * Constructor que inicializa el controlador con el modelo y la vista.
     *
     * @param model El modelo de la máquina tragamonedas.
     * @param view  La vista de la máquina tragamonedas.
     */
    public SlotMachineController(SlotMachine model, SlotMachineView view) {
        this.model = model;
        this.view = view;

        // Agrega un listener para el evento de girar la máquina
        this.view.addSpinListener(this::handleSpin);
        updateView();
    }

    /**
     * Maneja el evento de giro de la máquina tragamonedas.
     * Verifica si el saldo es suficiente para realizar la apuesta antes de jugar.
     * Si el saldo es insuficiente, muestra un mensaje de advertencia.
     */
    private void handleSpin() {
        if (model.getBalance() >= model.getBetAmount()) {
            model.play();
            updateView();
            view.animateReels(model.getCurrentSymbols(), model.checkWin());
        } else {
            JOptionPane.showMessageDialog(view, "Saldo insuficiente. Ajusta tu apuesta o recarga saldo.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Actualiza la vista con el saldo actual y la apuesta.
     */
    private void updateView() {
        view.setBalance("$" + model.getBalance());
        view.setBet("$" + model.getBetAmount());
    }
}
