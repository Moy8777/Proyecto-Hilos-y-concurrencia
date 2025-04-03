package pedro.com.app.mvc.model;

import javax.swing.*;
import java.util.Random;

/**
 * Representa un carrete de la máquina tragamonedas que gira y selecciona un símbolo aleatorio.
 */
public class Reel {
    private static final Symbol[] SYMBOLS = {
        new Symbol("img/simbolo1.png", 5),
        new Symbol("img/simbolo2.png", 10),
        new Symbol("img/simbolo3.png", 15),
        new Symbol("img/simbolo4.png", 20),
        new Symbol("img/Supremevictory.png", 25)
    };

    private Symbol currentSymbol;
    private Random random;

    /**
     * Constructor que inicializa el carrete y lo hace girar para seleccionar un símbolo inicial.
     */
    public Reel() {
        random = new Random();
        spin();
    }

    /**
     * Gira el carrete y selecciona un símbolo aleatorio de la lista de símbolos disponibles.
     */
    public void spin() {
        currentSymbol = SYMBOLS[random.nextInt(SYMBOLS.length)];
    }

    /**
     * Obtiene el símbolo actual del carrete.
     *
     * @return El símbolo actual.
     */
    public Symbol getCurrentSymbol() {
        return currentSymbol;
    }
}