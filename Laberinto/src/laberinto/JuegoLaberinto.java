package laberinto;

import java.util.Random;
import java.util.Scanner;
import utilidades.Metodos;

public class JuegoLaberinto {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random generador = new Random();
        String nombre;
        final char jugador = 'Δ';
        final char enemigo = '▲';
        final char bomba = 'ʘ';
        final char llave = 'ȸ';
        final char salida = 'ῼ';
        final char sorpresa = '§';
        final char llave_secreto = 'φ';
        final int bombas_lab1 = 15;
        final int num_bombas_sec = 10;
        final String fibonacci = "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW\n" +
"WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW\n" +
"WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWNK0kkxdolcc:::::ccloxk0XNWWWWWWWWWWWWWWWWWWWWWWWW\n" +
"WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWX0koc;'..                   ..,cdOXWWWWWWWWWWWWWWWWWWWW\n" +
"WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWNKko:'.         ..',;:cccllcc:;'..    .'cxKWWWWWWWWWWWWWWWWW\n" +
"WWWWWWWWWWWWWWWWWWWWWWWWWWWXOo;.       .,:oxOO0XNNWWWWWWWWWWWNX0kdc,.   .:kXWWWWWWWWWWWWWW\n" +
"WWWWWWWWWWWWWWWWWWWWWWWWXkc'       ':dOKNWWWWWWWWWWWWWWWWWWWWWWWWWWNKxc.   'dKWWWWWWWWWWWW\n" +
"WWWWWWWWWWWWWWWWWWWWWN0l'      .;oOXWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWXx:.  'dXWWWWWWWWWW\n" +
"WWWWWWWWWWWWWWWWWWWXk:.     .;dKNWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWN0c.  ;OWWWWWWWWW\n" +
"WWWWWWWWWWWWWWWWWXx,      'o0NWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWNO:  .dNWWWWWWW\n" +
"WWWWWWWWWWWWWWWNk;      ,xXWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWXd. .oXWWWWWW\n" +
"WWWWWWWWWWWWWW0c.     ,xXWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWk' .oNWWWWW\n" +
"WWWWWWWWWWWWNd.     .dXWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWk. .xWWWWW\n" +
"WWWWWWWWWWWKc.     :0WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWx. '0WWWW\n" +
"WWWWWWWWWW0;     .dXWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWXc  lNWWW\n" +
"WWWWWWWWWO'     'kWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWk. ,KWWW\n" +
"WWWWWWWWO'     ,OWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWX; .OWWW\n" +
"WWWWWWW0,     'OWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWNXXXWWWWWWWWWWWWWWWWWWNl .kWWW\n" +
"WWWWWWK:     .kWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWKOO0KKKKKNWWWWWWWWWWWWWWWNl .kWWW\n" +
"WWWWWNo     .oNWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWNkxKNWWWWWXKNWWWWWWWWWWWWWWX: '0WWW\n" +
"WWWWWO.     ;KWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWNkdXWWWWWWWNXNWWWWWWWWWWWWWWO. lNWWW\n" +
"WWWWXc     .xWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWMXokWWWWWWWNNNWWWWWWWWWWWWWWK: ,0WWWW\n" +
"WWWWO.     ;XWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWMXoxWWWWWWWWWWWWWWWWWWWWWWWK: ,OWWWWW\n" +
"WWWNo      oWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWxl0WWWWWWWWWWWWWWWWWWWWNk'.:0WWWWWW\n" +
"WWWX;     .kWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWXdcOWWWWWWWWWWWWWWWWWNk:.'xXWWWWWWW\n" +
"WWW0'     '0MWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWNkclONWWWWWWWWWWWXOo,';xXWWWWWWWWW\n" +
"WWWO.     ;KWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWXxllodxkOOOkdl:;;:d0NWWWWWWWWWWW\n" +
"WWWXOxxxxxONWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWXOdoolllllox0XWWWWWWWWWWWWWWW\n" +
"WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW\n" +
"WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW";

        boolean fin = false;
        boolean muerto = false;
        boolean tiene_llave = false;
        boolean inmortal = false;
        boolean laberinto_secreto = false;
        boolean llave_lab_secreto = false;
        boolean fin2 = false;
        boolean correcto = false;

        //POSICION DEL JUGADOR
        int jugador_i, jugador_j, jugador_i_sec, jugador_j_sec, enemigo_i, enemigo_j, enemigo_i2, enemigo_j2;
        //OPCION QUE ELIGE PARA MOVERSE
        int opcion;
        //VARIABLES PARA LAS POSICIONES ALEATORIAS DE LOS OBJETOS A COLOCAR INICIALMENTE
        int ale_i, ale_j;
        //Variable para seleccionar aleatoriamente el comodín del objeto secreto
        int opcion_comodin;
        //Contador para actualizar la duración de la inmortalidad y límite de esta
        int cont_inmortalidad = 0;
        int limite_inmortalidad = 2;

        char eleccion = ' ';

        String[] direcciones = {"Arriba", "Abajo", "Derecha", "Izquierda"};
        int[] mov_i = {-1, 1, 0, 0};
        int[] mov_j = {0, 0, 1, -1};
        String[] comodin_sorpresa = {"Reposicionamiento de la llave", "Inmortalidad y destrucción de bombas durante "
            + limite_inmortalidad + " turnos", "Salto al laberinto secreto"};
        boolean[] permitidos = new boolean[mov_i.length];

        //DIBUJAR EL LABERINTO
        char[][] lab = {{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                        {'8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', ' ', ' ', '8'},
                        {'8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'a', 'a', 'a', 'a', 'a', '8', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', ' ', ' ', '8'},
                        {'8', 'a', 'a', 'a', 'a', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'a', 'a', '8', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', ' ', ' ', '8'},
                        {'8', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '8', 'a', ' ', ' ', ' ', ' ', ' ', '8'},
                        {'8', ' ', ' ', ' ', '8', 'a', 'a', 'a', 'a', 'a', ' ', ' ', 'a', 'a', '8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '8', ' ', ' ', '8', ' ', ' ', '8'},
                        {'8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '8', ' ', ' ', '8', ' ', ' ', '8'},
                        {'8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', 'a', 'a', '8', ' ', ' ', ' ', 'a', 'a', 'a', 'a', '8', ' ', ' ', '8', ' ', ' ', '8'},
                        {'8', 'a', 'a', 'a', 'a', 'a', ' ', ' ', ' ', '8', 'a', 'a', 'a', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '8', ' ', ' ', '8'},
                        {'8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'a', 'a', 'a', '8'},
                        {'8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '8'},
                        {'8', 'a', 'a', 'a', 'a', ' ', ' ', ' ', '8', ' ', ' ', ' ', '8', ' ', ' ', ' ', 'a', 'a', 'a', '8', ' ', ' ', ' ', 'a', 'a', '8', ' ', ' ', ' ', ' ', '8'},
                        {'8', ' ', ' ', ' ', '8', 'a', ' ', ' ', '8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', '8'},
                        {'8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '8', ' ', '8', ' ', ' ', '8'},
                        {'8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'a', '8', ' ', ' ', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'a', 'a', 'a', '8'},
                        {'8', 'a', 'a', 'a', 'a', ' ', ' ', ' ', ' ', '8', ' ', ' ', 'a', '8', ' ', ' ', 'a', 'a', 'a', '8', ' ', ' ', ' ', 'a', 'a', '8', ' ', ' ', ' ', ' ', '8'},
                        {'8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', 'a', '8', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', '8'},
                        {'8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', ' ', '8', ' ', ' ', ' ', ' ', '8'},
                        {'8', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', '8'}};

        char[][] labSec = {{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
        {'8', ' ', ' ', ' ', '|', ' ', 'x', ' ', ' ', '|', ' ', 'x', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', 'x', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '8'},
        {'8', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', 'x', ' ', ' ', '8'},
        {'8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', '8'},
        {'8', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', '8'},
        {'8', ' ', ' ', ' ', '|', ' ', 'x', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', '8'},
        {'8', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', 'x', ' ', ' ', '|', ' ', ' ', 'x', ' ', ' ', '8'},
        {'8', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', 'x', ' ', ' ', '|', ' ', ' ', ' ', 'x', ' ', '8'},
        {'8', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', '|', ' ', ' ', 'x', ' ', ' ', '8'},
        {'8', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', '|', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', '|', ' ', ' ', ' ', 'x', ' ', '8'},
        {'8', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', '|', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', '|', ' ', ' ', 'x', ' ', ' ', '8'},
        {'8', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', '|', ' ', 'x', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', '8'},
        {'8', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', '8'},
        {'8', ' ', ' ', ' ', '|', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', '8'},
        {'8', ' ', ' ', ' ', '|', ' ', 'x', ' ', ' ', '|', ' ', 'x', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '8'},
        {'8', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', '8', '8', '8', '8', '8'}};

        //Creación del laberinto de dificultad 1
        //COLOCAMOS LA LLAVE
        do {
            ale_i = generador.nextInt(lab.length);
            ale_j = generador.nextInt(lab[0].length);
        } while (lab[ale_i][ale_j] != ' ');
        lab[ale_i][ale_j] = llave;
        //COLOCAMOS LA SALIDA
        do {
            ale_i = generador.nextInt(lab.length);
            ale_j = generador.nextInt(lab[0].length);
        } while (lab[ale_i][ale_j] != ' ');
        lab[ale_i][ale_j] = salida;

        //Coloco la sorpresa
        do {
            ale_i = generador.nextInt(lab.length);
            ale_j = generador.nextInt(lab[0].length);
        } while (lab[ale_i][ale_j] != ' ');
        lab[ale_i][ale_j] = sorpresa;
        opcion_comodin = generador.nextInt(comodin_sorpresa.length);

        //Coloco el item para acceder al laberinto secreto
        do {
            ale_i = generador.nextInt(lab.length);
            ale_j = generador.nextInt(lab[0].length);
        } while (lab[ale_i][ale_j] != ' ');
        lab[ale_i][ale_j] = llave_secreto;

        //COLOCAMOS AL JUGADOR
        do {
            jugador_i = generador.nextInt(lab.length);
            jugador_j = generador.nextInt(lab[0].length);
        } while (lab[jugador_i][jugador_j] != ' ');
        lab[jugador_i][jugador_j] = jugador;
        //GENERAMOS LAS BOMBAS
        for (int i = 0; i < bombas_lab1; i++) {
            do {
                ale_i = generador.nextInt(lab.length);
                ale_j = generador.nextInt(lab[0].length);
            } while (lab[ale_i][ale_j] != ' ');
            lab[ale_i][ale_j] = bomba;
        }

        //Creación del laberinto secreto. En este laberinto, jugador y salida estarán en extremos opuestos.
        //Coloco la llave justo en el centro del laberinto        
        labSec[labSec.length / 2][labSec[0].length / 2] = llave;

        //Colocación de los dos enemigos vigilando la salida
        do {
            enemigo_i = labSec.length/2;
            enemigo_j = 2;
        } while (labSec[enemigo_i][enemigo_j] != ' ');
        labSec[enemigo_i][enemigo_j] = enemigo;
        do {
            enemigo_i2 = labSec.length/2-2;
            enemigo_j2 = 3;
        } while (labSec[enemigo_i2][enemigo_j2] != ' ');
        labSec[enemigo_i2][enemigo_j2] = enemigo;

        //Coloco la salida en la parte izquierda del laberinto
        do {
            ale_i = labSec.length / 2;
            ale_j = generador.nextInt(1) + 1;
        } while (labSec[ale_i][ale_j] != ' ');
        labSec[ale_i][ale_j] = salida;

        //Coloco al jugador en la parte derecha del laberinto
        jugador_i_sec = labSec.length / 2;
        jugador_j_sec = labSec[0].length - 2;
        labSec[jugador_i_sec][jugador_j_sec] = jugador;

        //Genero las bombas. Divido la matriz para intentar generarlas de forma más uniforme
        int zonas_bombas = 2;
        int k = 1;
        int[] matriz_j = {labSec[0].length / 2 - 2, labSec[0].length / 2 + 9};
        for (int i = 0; i < zonas_bombas; i++) {
            for (int j = 0; j < num_bombas_sec; j++) {
                do {
                    ale_i = generador.nextInt(labSec.length);
                    ale_j = k + generador.nextInt((matriz_j[i] - k) + 1);
                } while (labSec[ale_i][ale_j] != ' ');
                labSec[ale_i][ale_j] = bomba;
                k++;
            }

        }

        //BUCLE DEL JUEGO
//      
        System.out.println(fibonacci);
        System.out.println("¡Vaya! Al parecer, tu destino y el del laberinto de Fibonacci se han cruzado."
                + " ¿Serás capaz de atravesarlo? \nOjo, puede que no todo sea lo que parece... En cuanto "
                + "cruces esta puerta, ya no habrá \nmarcha atrás, y sólo los números serán tus amigos. A continuación, escribe tu nombre. "
                + "¿Pasarás a la historia como un héroe?\n¿O como una víctima más del laberinto? \nVeamos "
                + "dónde acaba plasmada tu historia... ");
        nombre = teclado.nextLine();
        System.out.println("");
        System.out.println("La puerta para salir es "+salida+", pero sólo podrás atravesarla si tienes la llave "+llave+". Además, hay un objeto "
                +sorpresa+ " que te generará una sorpresa de forma aleatoria. Pero, ¡cuidado con las bombas "+bomba+"! ¿Podrán dejarte encerrado?"
                        + " \nAh, pero ves otro objeto, ¿verdad? ¿Qué hará "+llave_secreto+"? Tendrás que descubrirlo por ti mismo, "+jugador+"...");
        do {
            //Dibujamos el laberinto inicial
            for (int i = 0; i < lab.length; i++) {
                for (int j = 0; j < lab[i].length; j++) {
                    System.out.print(lab[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("");
            //Cálculo y almacenamiento de los movimientos que se pueden y no realizar
            for (int i = 0; i < direcciones.length; i++) {
                if (lab[jugador_i + mov_i[i]][jugador_j + mov_j[i]] != 'a'
                        && lab[jugador_i + mov_i[i]][jugador_j + mov_j[i]] != '8') {
                    permitidos[i] = true;

                } else {
                    permitidos[i] = false;
                }
            }

            //Se pide un movimiento al usuario, comprobando que sea correcto
            for (int i = 0; i < permitidos.length; i++) {
                if (permitidos[i]) {
                    System.out.println(i + ": " + direcciones[i]);
                }
            }
            do {
                System.out.print("Movimiento a realizar: ");
                opcion = teclado.nextInt();
                if (opcion >= 0 && opcion <= 3 && permitidos[opcion]) {
                    correcto = true;
                } else {
                    System.out.println("Opción no válida.");
                    correcto = false;
                }

            } while (!correcto);

            //Comprobación de la posición y actualización en caso de que fuera necesario
            if (lab[jugador_i + mov_i[opcion]][jugador_j + mov_j[opcion]] == sorpresa) {
                //Si el usuario coge el comodín, se comprueba cual de las tres posibles sorpresas aleatorias tiene, y si se pueden llevar a cabo
                if (opcion_comodin == 0) {
                    System.out.println(comodin_sorpresa[opcion_comodin]);
                    if(!tiene_llave){
                        for (int i = 0; i < lab.length; i++) {
                            for (int j = 0; j < lab[i].length; j++) {
                                if (lab[i][j] == llave) {
                                    do {
                                        ale_i = generador.nextInt(lab.length);
                                        ale_j = generador.nextInt(lab[0].length);
                                    } while (lab[ale_i][ale_j] != ' ');
                                    lab[ale_i][ale_j] = llave;
                                    lab[i][j] = ' ';
                                }
                            }

                        }
                    }else{
                        System.out.println("Teletransporte de llave, pero ya tienes la llave contigo. ¡Sigue adelante!");
                    }
                } else if (opcion_comodin == 1) {
                    System.out.println(comodin_sorpresa[opcion_comodin]);
                    inmortal = true;
                } else {
                    System.out.println(comodin_sorpresa[opcion_comodin]);
                    fin = true;
                    laberinto_secreto = true;
                    System.out.println("Teletransportación al laberinto secreto...");
                }
                //Uns vez llevada a cabo la opción del comodín, se actualiza la posición del jugador, eliminando la posición previa
                //y el item de sorpresa
                lab[jugador_i + mov_i[opcion]][jugador_j + mov_j[opcion]] = jugador;
                lab[jugador_i][jugador_j] = ' ';
                jugador_i += mov_i[opcion];
                jugador_j += mov_j[opcion];
            } //Comprobación si el jugador pisa una bomba
            else if (lab[jugador_i + mov_i[opcion]][jugador_j + mov_j[opcion]] == bomba) {
                //Si ha obtenido la sorpresa de inmortalidad no muere
                if (inmortal && cont_inmortalidad < limite_inmortalidad) {
                    lab[jugador_i + mov_i[opcion]][jugador_j + mov_j[opcion]] = jugador;
                    lab[jugador_i][jugador_j] = ' ';
                    jugador_i += mov_i[opcion];
                    jugador_j += mov_j[opcion];
                    cont_inmortalidad++;
                    //Si no la ha obtenido, muere y termina el juego
                } else {
                    fin = true;
                    muerto = true;
                    lab[jugador_i][jugador_j] = ' ';
                    System.out.println("Has caído en una bomba. Tu aventura termina aquí.");
                }

                //Comprobación si el jugador coge la llave para acceder al laberinto secreto
            } else if (lab[jugador_i + mov_i[opcion]][jugador_j + mov_j[opcion]] == llave_secreto) {
                llave_lab_secreto = true;
                lab[jugador_i][jugador_j] = ' ';
                lab[jugador_i + mov_i[opcion]][jugador_j + mov_j[opcion]] = jugador;
                jugador_i += mov_i[opcion];
                jugador_j += mov_j[opcion];
                System.out.println("Curioso objeto. Me pregunto qué hará...");
                //Commprobación si el jugador consigue la llave para salir
            } else if (lab[jugador_i + mov_i[opcion]][jugador_j + mov_j[opcion]] == llave) {
                tiene_llave = true;
                lab[jugador_i][jugador_j] = ' ';
                lab[jugador_i + mov_i[opcion]][jugador_j + mov_j[opcion]] = jugador;
                jugador_i += mov_i[opcion];
                jugador_j += mov_j[opcion];
                System.out.println("¡Has conseguido la llave!");
                //Comprobación si el jugador está en la salida y si tiene la llave para salir
            } else if (lab[jugador_i + mov_i[opcion]][jugador_j + mov_j[opcion]] == salida) {
                if (tiene_llave) {
                    fin = true;
                    lab[jugador_i][jugador_j] = ' ';
                    //En caso de no tenerla, el jugador se mantendrá en la misma posición
                } else {
                    System.out.println("No tienes la llave, por lo que no puedes atravesar la puerta del destino.");
                }
                //Movimiento hacia una casilla vacía
            } else {
                lab[jugador_i + mov_i[opcion]][jugador_j + mov_j[opcion]] = jugador;
                lab[jugador_i][jugador_j] = ' ';
                jugador_i += mov_i[opcion];
                jugador_j += mov_j[opcion];
            }
            System.out.println("");

        } while (!fin && !laberinto_secreto);

        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[i].length; j++) {
                System.out.print(lab[i][j] + " ");
            }
            System.out.println();
            
        }
        //Se comprueba si el usuario puede acceder al laberinto secreto
        if ((!muerto && llave_lab_secreto) || laberinto_secreto) {
            do{
                System.out.println("¡Superaste el primer laberinto! Pero para obtener el premio final, "
                        + "deberás superar el laberinto secreto, al cual puedes \nacceder gracias al item "
                        + "especial que recogiste. ¿Te atreves a adentrarte en él? (S/N): ");
                eleccion = teclado.next().charAt(0);
            }while(eleccion != 's' && eleccion != 'S' && eleccion != 'n' && eleccion != 'N');

            //Pregunta al usuario si quiere entrar al laberinto secreto o no
            if (eleccion == 's' || eleccion == 'S') {
                System.out.println("La fortuna sonríe a los valientes. Entra y descubre el laberinto secreto. Pero, ¡cuidado! \nUn guardián"
                        + " protege la salida, y su recorrido es irregular, por lo que puede interponerse en tu \ncamino en cualquier momento!"
                        + " Intenta que no te cace o tu aventura terminará.");
                opcion_comodin = generador.nextInt(comodin_sorpresa.length - 1);
                tiene_llave = false;
                muerto = false;
                correcto = false;
                do {
                    //Dibujamos el laberinto secreto
                    for (int i = 0; i < labSec.length; i++) {
                        for (int j = 0; j < labSec[i].length; j++) {
                            System.out.print(labSec[i][j] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println("");
                    //Cálculo y almacenamiento de los movimientos que se pueden y no realizar
                    for (int i = 0; i < direcciones.length; i++) {
                        if (labSec[jugador_i_sec + mov_i[i]][jugador_j_sec + mov_j[i]] != 'a'
                                && labSec[jugador_i_sec + mov_i[i]][jugador_j_sec + mov_j[i]] != '8'
                                && labSec[jugador_i_sec + mov_i[i]][jugador_j_sec + mov_j[i]] != '|'
                                && labSec[jugador_i_sec + mov_i[i]][jugador_j_sec + mov_j[i]] != 'x') {
                            permitidos[i] = true;

                        } else {
                            permitidos[i] = false;
                        }
                    }
                    //Movimiento de los enemigos de forma aleatoria en la misma columna pero cambiando de fila
                    labSec[enemigo_i][enemigo_j] = ' ';
                    labSec[enemigo_i2][enemigo_j2] = ' ';
                    do{
                        enemigo_i = generador.nextInt(7)+5; 
                        enemigo_i2 = generador.nextInt(7)+5;
                    }while(labSec[enemigo_i][enemigo_j] != ' ' && labSec[enemigo_i2][enemigo_j2] != ' ');
                    
                    labSec[enemigo_i][enemigo_j] = enemigo;
                    labSec[enemigo_i2][enemigo_j2] = enemigo;

                        //Se pide un movimiento al usuario, comprobando que sea correcto
                        for (int i = 0; i < permitidos.length; i++) {
                            if (permitidos[i]) {
                                System.out.println(i + ": " + direcciones[i]);
                            }
                        }
                        do {
                            System.out.print("Movimiento a realizar: ");
                            opcion = teclado.nextInt();
                            if (opcion >= 0 && opcion <= 3 && permitidos[opcion]) {
                                correcto = true;
                            } else {
                                System.out.println("Opción no válida.");
                                correcto = false;
                            }

                        } while (!correcto);

                        //Comprobación de la posición y actualización en caso de que fuera necesario  
                        if (labSec[jugador_i_sec + mov_i[opcion]][jugador_j_sec + mov_j[opcion]] == bomba) {
                            fin2 = true;
                            muerto = true;
                            labSec[jugador_i_sec][jugador_j_sec] = ' ';
                            System.out.println("Has caído en una bomba. Tu aventura termina aquí.");

                        } else if (labSec[jugador_i_sec + mov_i[opcion]][jugador_j_sec + mov_j[opcion]] == llave) {
                            tiene_llave = true;
                            labSec[jugador_i_sec][jugador_j_sec] = ' ';
                            labSec[jugador_i_sec + mov_i[opcion]][jugador_j_sec + mov_j[opcion]] = jugador;
                            jugador_i_sec += mov_i[opcion];
                            jugador_j_sec += mov_j[opcion];
                            System.out.println("¡Has conseguido la llave!");
                        } else if (labSec[jugador_i_sec + mov_i[opcion]][jugador_j_sec + mov_j[opcion]] == salida) {
                            if (tiene_llave) {
                                fin2 = true;
                                labSec[jugador_i_sec][jugador_j_sec] = ' ';
                            } else {
                                System.out.println("No tienes la llave para abrir la puerta del destino.");
                            }
                        } else {
                            labSec[jugador_i_sec + mov_i[opcion]][jugador_j_sec + mov_j[opcion]] = jugador;
                            labSec[jugador_i_sec][jugador_j_sec] = ' ';
                            jugador_i_sec += mov_i[opcion];
                            jugador_j_sec += mov_j[opcion];
                        }
                        System.out.println("");
                        
                    //Si el enemigo se cruza con el jugador
                    if(labSec[enemigo_i][enemigo_j] == labSec[jugador_i_sec][jugador_j_sec] ||
                        labSec[enemigo_i2][enemigo_j2] == labSec[jugador_i_sec][jugador_j_sec]){
                        System.out.println("¡El guardián te ha cazado!");
                        fin2 = true;
                        muerto = true;
                        labSec[jugador_i_sec][jugador_j_sec] = enemigo;
                    }
                    
                }while (!fin2);
                    //Esto sucede si el jugador no quiere entrar al laberinto
            }else{
                System.out.println("La valentía no es apta para todos.");
            }
        
            //Si el jugador ha entrado al laberinto secreto, se muestra su estado final
            if (eleccion == 'S' || eleccion == 's') {
                for (int i = 0; i < labSec.length; i++) {
                    for (int j = 0; j < labSec[i].length; j++) {
                        System.out.print(labSec[i][j] + " ");
                    }
                    System.out.println("");
                }
            }
            

        }
    //Selección del premio en función del resultado
        if (fin2 && !muerto) {
            System.out.println(Metodos.pergaminoHeroe(nombre));
        } else if (fin && !muerto) {
            System.out.println(Metodos.pergaminoNoPremio(nombre));
        } else {
            System.out.println(Metodos.pergaminoVictima(nombre));
        }
    }
}
