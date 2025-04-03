package pedro.com.app.mvc.model;

/**
 * Representa una apuesta en la máquina tragamonedas.
 */
public class Bet {
    private int amount;

    /**
     * Constructor que inicializa la apuesta con un monto específico.
     *
     * @param amount El monto de la apuesta.
     */
    public Bet(int amount) {
        this.amount = amount;
    }

    /**
     * Obtiene el monto de la apuesta.
     *
     * @return El monto de la apuesta.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Establece un nuevo monto para la apuesta si es mayor que cero.
     *
     * @param amount El nuevo monto de la apuesta.
     */
    public void setAmount(int amount) {
        if (amount > 0) {
            this.amount = amount;
        }
    }
}

