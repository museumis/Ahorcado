package ejer21_t8_ahorcado;

import java.util.Arrays;
import java.util.Scanner;
import sun.awt.windows.ThemeReader;

/**
 *
 * @author Ismael Martín Ramírez
 * [imartinr01@informatica.iesvalledeljerteplasencia.es]
 */
public class Ejer21_t8_Ahorcado {

    public static void incertidumbre() {

        try {
            System.out.println("¡Atención!");
            System.out.print("  . ");
            Thread.sleep(800);
            System.out.print(". ");
            Thread.sleep(800);
            System.out.print(". ");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("");
    }

    public static void mostrarPalabraSecreta(char palabraFormada[]) {

        int i;

        System.out.print("Palabra secreta: ");

        for (i = 0; i < palabraFormada.length; i++) {
            if (palabraFormada[i] == ' ') {
                System.out.println(" _ ");
            } else {
                System.out.print(" " + palabraFormada[i] + " ");
            }
        }

        System.out.println("");
        System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    public static void juego(String palabra) {

        int comprobadorLetraPosicion = -1, fallos = 0;
        char letra;
        char[] palabraFormada = new char[palabra.length()];
        //Cada vez que se encuentre una letra, restará 1, cuando sea 0 habrá ganado
        int validadorGanador = palabra.length();

        Arrays.fill(palabraFormada, '_');
        mostrarPalabraSecreta(palabraFormada);
        
        do {

            letra = pedirletra();
            incertidumbre();

            comprobadorLetraPosicion = palabra.indexOf(letra);
            //Si obtenemos un valor, la letra estará en la palabra. ComprobarL cambiará de valor.
            if (comprobadorLetraPosicion != -1) {

                System.out.println("¡La letra esta en la palabra!");

                for (int i = 0; i < palabra.length(); i++) {

                    if (palabra.charAt(i) == letra) {
                        palabraFormada[i] = letra;
                        validadorGanador--;
                    }
                }

                mostrarPalabraSecreta(palabraFormada);
                comprobadorLetraPosicion = -1;

            } else {
                System.out.println("La letra no esta en la palabra...");
                dibujarHorca(fallos);
                fallos++;
                mostrarPalabraSecreta(palabraFormada);
            }

            if (validadorGanador == 0) {
                System.out.println("¡ESA ERA LA PALABRA,LE SALVASTE!");

            }
            if (fallos == 6) {
                System.out.println("No pudiste salvarle... la palabra era " + palabra.toUpperCase() + ".");
            }
        } while ((fallos < 6) && (validadorGanador != 0));

    }

    public static char pedirletra() {

        String letra = "";
        Scanner entrada = new Scanner(System.in);

        System.out.print("Introduce una letra: ");
        letra = entrada.nextLine();

        return letra.charAt(0);
    }

    public static void dibujarHorca(int fallos) {

        switch (fallos) {

            case 0: {

                System.out.println("\n             |           ");
                System.out.println("             |              ");
                System.out.println("    ¡1ª      |             ");
                System.out.println("   FALLO!    |              ");
                System.out.println("             |             ");
                System.out.println("             |         ");
                System.out.println("             |            ");
                System.out.println("           --^--           \n");
                break;

            }
            case 1: {

                System.out.println("\n             |---¬|¬           ");
                System.out.println("             |              ");
                System.out.println("    ¡2ª      |             ");
                System.out.println("   FALLO!    |              ");
                System.out.println("             |              ");
                System.out.println("             |             ");
                System.out.println("             |            ");
                System.out.println("           --^--           \n");
                break;
            }
            case 2: {

                System.out.println("\n             |---¬|¬           ");
                System.out.println("             |    |          ");
                System.out.println("    ¡3ª      |    |          ");
                System.out.println("   FALLO!    |               ");
                System.out.println("             |              ");
                System.out.println("             |             ");
                System.out.println("             |            ");
                System.out.println("           --^--           \n");
                break;
            }
            case 3: {

                System.out.println("\n             |---¬|¬           ");
                System.out.println("             |    |          ");
                System.out.println("    ¡4ª      |    |          ");
                System.out.println("   FALLO!    |    @           ");
                System.out.println("             |              ");
                System.out.println("             |            ");
                System.out.println("             |            ");
                System.out.println("           --^--           \n");
                break;
            }
            case 4: {

                System.out.println("\n             |---¬|¬           ");
                System.out.println("             |    |          ");
                System.out.println("    ¡5ª      |    |          ");
                System.out.println("   FALLO!    |    @           ");
                System.out.println("             |   -|-           ");
                System.out.println("             |             ");
                System.out.println("             |            ");
                System.out.println("           --^--           \n");
                break;
            }
            case 5: {

                System.out.println("\n             |---¬|¬           ");
                System.out.println("             |    |          ");
                System.out.println("    ¡6ª      |    |          ");
                System.out.println("   FALLO!    |    @           ");
                System.out.println("     NO      |   -|-           ");
                System.out.println("    PUDO     |   / \\          ");
                System.out.println(" SALVARSE... |            ");
                System.out.println("           --^--           \n");
                break;
            }

        }

    }

    public static void main(String[] args) {

        String[] palabras = {"melocoton", "sandia", "manzana", "platano", "frambuesa", "nectarina", "granada", "cereza"};
        String palabra = palabras[(int) Math.floor((Math.random()) * 8)];

        System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("             |---¬|¬           ");
        System.out.println("             |    |          ");
        System.out.println("    ¡EL      |    |          ");
        System.out.println("  AHORCADO!  |    @           ");
        System.out.println("             |   -|-           ");
        System.out.println("             |   / \\          ");
        System.out.println("             |            ");
        System.out.println("           --^--           ");
        System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Intenta adivinar la fruta que se esconde tras la palabra secreta.");
        System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        juego(palabra);

    }

}
