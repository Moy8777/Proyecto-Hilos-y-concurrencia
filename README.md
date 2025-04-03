Programa del Proyecto Hilos y concurrencia Realizado para la clase de TÓPICOS AVANZADOS DE PROGRAMACIÓN 04A 
Hecho Por Guillermo Moises Rodriguez Palomino, Pedro Francisco García Molina

🎰 Maquina Tragamonedas
¡Bienvenido a nuestra maquina Tragamonedas! Este es un simulador de máquina tragamonedas desarrollado en Java con el patrón de diseño MVC (Modelo-Vista-Controlador) y una interfaz gráfica basada en Swing.

📌 Características
✅ Simulación de una máquina tragamonedas con tres rodillos.
✅ Interfaz gráfica interactiva y animaciones.
✅ Sistema de apuestas y balance del jugador.
✅ Efecto visual RGB dinámico en el borde de la ventana.
✅ Implementación del patrón MVC para una mejor organización del código.

📂 Estructura del Proyecto
css
Copiar
Editar
📦 pedro.com.app
 ┣ 📂 mvc
 ┃ ┣ 📂 controller
 ┃ ┃ ┗ 📜 SlotMachineController.java
 ┃ ┣ 📂 model
 ┃ ┃ ┣ 📜 SlotMachine.java
 ┃ ┃ ┣ 📜 Reel.java
 ┃ ┃ ┣ 📜 Symbol.java
 ┃ ┃ ┣ 📜 Player.java
 ┃ ┃ ┗ 📜 Bet.java
 ┃ ┣ 📂 view
 ┃ ┃ ┗ 📜 SlotMachineView.java
 ┃ ┗ 📜 Main.java
 ┗ 📂 img
   ┣ 📜 simbolo1.png
   ┣ 📜 simbolo2.png
   ┣ 📜 simbolo3.png
   ┣ 📜 simbolo4.png
   ┗ 📜 Supremevictory.png
🚀 Instalación y Ejecución
Clona este repositorio:

sh
Copiar
Editar
git clone https://github.com/Moy8777/Proyecto-Hilos-y-concurrencia.git
Abre el proyecto en tu IDE favorito (IntelliJ IDEA, Eclipse, NetBeans).

Compila y ejecuta el archivo Main.java.

¡Disfruta del juego! 🎉

🛠️ Tecnologías Utilizadas
Java 8+

Swing (Interfaz gráfica)

Manejo de imágenes con ImageIcon

MVC (Modelo-Vista-Controlador)

📖 Documentación del Código
Este proyecto cuenta con documentación en formato Javadoc. Para generarla, ejecuta el siguiente comando en la terminal:

sh
Copiar
Editar
javadoc -d docs -sourcepath src -subpackages pedro.com.app
Esto creará una carpeta docs/ con la documentación en HTML accesible desde cualquier navegador.

📌 Contribuciones
¡Las contribuciones son bienvenidas! Si encuentras un error o quieres mejorar el proyecto, siéntete libre de hacer un fork y enviar un pull request.

📜 Licencia
Este proyecto está bajo la licencia MIT, lo que significa que puedes usarlo, modificarlo y distribuirlo libremente.
