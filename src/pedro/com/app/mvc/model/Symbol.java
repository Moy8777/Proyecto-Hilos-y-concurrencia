package pedro.com.app.mvc.model;

import javax.swing.*;

/**
 * Representa un símbolo en la máquina tragamonedas con una imagen y un valor asociado.
 */
public class Symbol {
    private ImageIcon icon;
    private String imagePath; // Ruta de la imagen del símbolo
    private int value;

    /**
     * Constructor que inicializa el símbolo con una imagen y un valor.
     *
     * @param imagePath La ruta de la imagen del símbolo.
     * @param value     El valor asociado al símbolo.
     */
    public Symbol(String imagePath, int value) {
        this.imagePath = imagePath;
        this.icon = new ImageIcon(imagePath);
        this.value = value;
    }

    /**
     * Obtiene el icono del símbolo.
     *
     * @return El objeto ImageIcon del símbolo.
     */
    public ImageIcon getIcon() {
        return icon;
    }

    /**
     * Obtiene la ruta de la imagen del símbolo.
     *
     * @return La ruta de la imagen como una cadena de texto.
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Obtiene el valor del símbolo.
     *
     * @return El valor asociado al símbolo.
     */
    public int getValue() {
        return value;
    }
}
