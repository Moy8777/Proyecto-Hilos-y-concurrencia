package pedro.com.app.mvc.view;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Representa la interfaz gráfica de la máquina tragamonedas.
 */
public class SlotMachineView extends JFrame {
    private JButton spinButton;
    private JLabel[] reels;
    private JLabel balanceLabel, betLabel, resultLabel;
    private ImageIcon[] symbols;
    private ImageIcon winningSymbol;
    private JPanel panel;

    /**
     * Constructor que inicializa la interfaz gráfica de la máquina tragamonedas.
     */
    public SlotMachineView() {
        setTitle("Tragamonedas");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);
        
        loadImages(); // Cargar imágenes de los símbolos

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.BLACK); 
       
        // Panel de los rodillos
        JPanel reelPanel = new JPanel(new GridLayout(1, 3));
        reelPanel.setBackground(Color.BLACK);
        reels = new JLabel[3];
        for (int i = 0; i < 3; i++) {
            reels[i] = new JLabel(scaleImage(symbols[0]), SwingConstants.CENTER);
            reelPanel.add(reels[i]);
        }

        // Panel de información
        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
        JPanel infoPanel = new JPanel(new GridLayout(1, 3));
        balanceLabel = new JLabel("Saldo: 150", SwingConstants.CENTER);
        betLabel = new JLabel("Apuesta: 10", SwingConstants.CENTER);
        resultLabel = new JLabel("", SwingConstants.CENTER);
        infoPanel.add(balanceLabel);
        infoPanel.add(betLabel);
        infoPanel.add(resultLabel);

        // Panel de botón
        JPanel buttonPanel = new JPanel();
        spinButton = new JButton("Girar");
        buttonPanel.add(spinButton);

        bottomPanel.add(infoPanel);
        bottomPanel.add(buttonPanel);

        panel.add(reelPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        add(panel);

        // Iniciar el efecto RGB para los bordes
        startRGBBorderEffect();
    }

    /**
     * Carga las imágenes de los símbolos utilizados en la máquina tragamonedas.
     */
    private void loadImages() {
        symbols = new ImageIcon[] {
            new ImageIcon("img/simbolo1.png"),
            new ImageIcon("img/simbolo2.png"),
            new ImageIcon("img/simbolo3.png"),
            new ImageIcon("img/simbolo4.png"),
            new ImageIcon("img/Supremevictory.png")
        };
        winningSymbol = new ImageIcon("img/Supremevictory.png");
    }

    /**
     * Escala una imagen a un tamaño adecuado para los rodillos.
     *
     * @param icon La imagen original.
     * @return La imagen escalada.
     */
    private ImageIcon scaleImage(ImageIcon icon) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(100, 200, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    /**
     * Inicia un efecto RGB en el borde de la ventana.
     */
    private void startRGBBorderEffect() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            private int red = 0;
            private int green = 0;
            private int blue = 0;

            @Override
            public void run() {
                red = (red + 1) % 256;
                green = (green + 2) % 256;
                blue = (blue + 3) % 256;
                panel.setBorder(BorderFactory.createLineBorder(new Color(red, green, blue), 25));
            }
        }, 0, 50);
    }

    /**
     * Anima los rodillos de la máquina tragamonedas.
     *
     * @param finalSymbols Los símbolos finales después del giro.
     * @param isWinner Indica si la jugada resultó ganadora.
     */
    public void animateReels(String[] finalSymbols, boolean isWinner) {
        Thread animationThread = new Thread(() -> {
            Random rand = new Random();
            int totalSpinTime = 1000 + rand.nextInt(2000);

            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < totalSpinTime) {
                for (int i = 0; i < reels.length; i++) {
                    reels[i].setIcon(scaleImage(symbols[rand.nextInt(symbols.length)]));
                }
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            SwingUtilities.invokeLater(() -> {
                for (int i = 0; i < reels.length; i++) {
                    reels[i].setIcon(scaleImage(getSymbolImage(finalSymbols[i])));
                }
                JOptionPane.showMessageDialog(null, isWinner ? "¡Ganaste! 🎉" : "Vuelve a intentarlo", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            });
        });
        animationThread.start();
    }

    /**
     * Obtiene la imagen de un símbolo a partir de su ruta.
     *
     * @param symbolIconPath La ruta del símbolo.
     * @return La imagen correspondiente o una predeterminada si no se encuentra.
     */
    private ImageIcon getSymbolImage(String symbolIconPath) {
        for (ImageIcon symbol : symbols) {
            if (symbol.getDescription().equals(symbolIconPath)) {
                return symbol;
            }
        }
        return new ImageIcon("img/DefaultSymbol.jpg");
    }

    /**
     * Agrega un listener para el botón de girar.
     *
     * @param listener Acción a ejecutar cuando se presiona el botón.
     */
    public void addSpinListener(Runnable listener) {
        spinButton.addActionListener(e -> listener.run());
    }

    /**
     * Actualiza la etiqueta del saldo.
     *
     * @param balance El nuevo saldo a mostrar.
     */
    public void setBalance(String balance) {
        balanceLabel.setText("Saldo: " + balance);
    }

    /**
     * Actualiza la etiqueta de la apuesta.
     *
     * @param bet La nueva apuesta a mostrar.
     */
    public void setBet(String bet) {
        betLabel.setText("Apuesta: " + bet);
    }

    /**
     * Establece un mensaje de resultado.
     *
     * @param message El mensaje a mostrar.
     */
    public void setResultMessage(String message) {
        resultLabel.setText(message);
    }
}