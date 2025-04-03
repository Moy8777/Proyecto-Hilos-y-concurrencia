package pedro.com.app.mvc.model;

/**
 * Representa a un jugador en la máquina tragamonedas con un saldo disponible.
 */
public class Player {
    private int balance;

    /**
     * Constructor que inicializa el jugador con un saldo inicial.
     *
     * @param initialBalance El saldo inicial del jugador.
     */
    public Player(int initialBalance) {
        this.balance = initialBalance;
    }

    /**
     * Agrega un monto al saldo del jugador.
     *
     * @param amount La cantidad a agregar al saldo.
     */
    public void addBalance(int amount) {
        balance += amount;
    }

    /**
     * Realiza una apuesta si el saldo es suficiente.
     *
     * @param amount La cantidad a apostar.
     * @return true si la apuesta fue realizada con éxito, false si el saldo es insuficiente.
     */
    public boolean placeBet(int amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    /**
     * Obtiene el saldo actual del jugador.
     *
     * @return El saldo disponible del jugador.
     */
    public int getBalance() {
        return balance;
    }
}
