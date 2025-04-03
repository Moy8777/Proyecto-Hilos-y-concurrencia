package pedro.com.app.mvc.model;

/**
 * Representa una máquina tragamonedas con carretes, saldo y apuestas.
 */
public class SlotMachine {
    private Reel[] reels;
    private int balance;
    private Bet bet;

    /**
     * Constructor que inicializa la máquina tragamonedas con un saldo inicial y tres carretes.
     *
     * @param initialBalance El saldo inicial de la máquina tragamonedas.
     */
    public SlotMachine(int initialBalance) {
        reels = new Reel[3];
        for (int i = 0; i < 3; i++) {
            reels[i] = new Reel();
        }
        balance = initialBalance;
        bet = new Bet(10); // Apuesta inicial por defecto
    }

    /**
     * Gira los carretes de la máquina tragamonedas.
     */
    public void spin() {
        for (Reel reel : reels) {
            reel.spin();
        }
    }

    /**
     * Verifica si los símbolos obtenidos en los carretes son iguales.
     *
     * @return true si todos los símbolos son iguales, false en caso contrario.
     */
    public boolean checkWin() {
        String firstSymbol = reels[0].getCurrentSymbol().getImagePath(); // Obtener la ruta de la imagen
        for (Reel reel : reels) {
            if (!reel.getCurrentSymbol().getImagePath().equals(firstSymbol)) { // Comparar rutas
                return false;
            }
        }
        return true;
    }

    /**
     * Calcula las ganancias en caso de victoria.
     *
     * @return El monto ganado basado en la apuesta y el valor del símbolo.
     */
    public int calculateWinnings() {
        if (checkWin()) {
            return bet.getAmount() * reels[0].getCurrentSymbol().getValue();
        }
        return 0;
    }

    /**
     * Ejecuta una jugada restando la apuesta del saldo, girando los carretes y sumando las ganancias.
     */
    public void play() {
        if (balance >= bet.getAmount()) {
            balance -= bet.getAmount();
            spin();
            int winnings = calculateWinnings();
            balance += winnings;
        }
    }

    /**
     * Establece la cantidad de la apuesta.
     *
     * @param amount La nueva cantidad de la apuesta.
     */
    public void setBetAmount(int amount) {
        bet.setAmount(amount);
    }

    /**
     * Obtiene el monto de la apuesta actual.
     *
     * @return La cantidad de la apuesta.
     */
    public int getBetAmount() {
        return bet.getAmount();
    }

    /**
     * Obtiene los símbolos actuales en los carretes.
     *
     * @return Un arreglo con las rutas de las imágenes de los símbolos.
     */
    public String[] getCurrentSymbols() {
        String[] symbols = new String[3];
        for (int i = 0; i < reels.length; i++) {
            symbols[i] = reels[i].getCurrentSymbol().getImagePath(); // Obtener la ruta de la imagen
        }
        return symbols;
    }

    /**
     * Obtiene el saldo actual de la máquina tragamonedas.
     *
     * @return El saldo disponible.
     */
    public int getBalance() {
        return balance;
    }
}
