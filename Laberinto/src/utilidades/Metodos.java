
package utilidades;


public class Metodos {
    public static String pergaminoHeroe(String nombre){
        final String azul = "\u001B[34m";
        String mensaje = azul+"                                             _______________________\n"
+azul+"   _______________________-------------------                       `\\\n "
+azul+" /:--__                                                              |\n"
+azul+"||< > |                                   ___________________________/\n"
+azul+"| \\__/_________________-------------------                        |\n"
+azul+"|                                                                  |\n"
 +azul+"|                                                                 \n"
 +azul+"|                                                                  |\n"
 +azul+"|      \"¡Has salido victorioso de esta encrucijada! Sin            |\n"
  +azul+"|         embargo, ten cuidado, pues este no será el último        |\n"
  +azul+"|       peligro al que debas enfrentarte.                          |\n"
  +azul+"|                                                                  |\n"
  +azul+"|         La fortuna y la valentía son tus tesoros                 |\n"
   +azul+"|       más preciados, "+nombre+", mas no te           |\n"
   +azul+"|        confíes. Nunca sabemos lo que puede aguardarnos el       |\n"
   +azul+"|                 siguiente camino.                               |\n"
  +azul+"|                                              ____________________|_\n"
  +azul+"|  ___________________-------------------------                      `\\\n"
  +azul+"|/`--_                                                                 |\n"
  +azul+"||[ ]||                                            ___________________/\n"
   +azul+"\\===/___________________--------------------------";
        return mensaje;        
    }
    public static String pergaminoVictima(String nombre){
        String mensaje = "                                             _______________________\n"
+"   _______________________-------------------                       `\\\n "
+" /:--__                                                              |\n"
+"||< > |                                   ___________________________/\n"
+"| \\__/_________________-------------------                        |\n"
+"|                                                                  |\n"
 +"|                                                                 \n"
 +"|                                                                  |\n"
 +"|      \"Derrotado has sido, "+nombre+", al igual que muchos         |\n"
  +"|        antes que tú. Extraños son los laberintos de la vida,     |\n"
  +"|           y muchas las formas de perderse para siempre...        |\n"
  +"|                                                                  |\n"
  +"|                                                                 |\n"
   +"|                      No te rindas.                              |\n"
    +"|                                                               |\n"
   +"|                                                                 |\n"
  +"|                                              ____________________|_\n"
  +"|  ___________________-------------------------                      `\\\n"
  +"|/`--_                                                                 |\n"
  +"||[ ]||                                            ___________________/\n"
   +"\\===/___________________--------------------------";
        return mensaje;        
    }
    
    public static String pergaminoNoPremio(String nombre){
        String mensaje = "                                             _______________________\n"
+"   _______________________-------------------                       `\\\n "
+" /:--__                                                              |\n"
+"||< > |                                   ___________________________/\n"
+"| \\__/_________________-------------------                        |\n"
+"|                                                                  |\n"
 +"|                                                                 \n"
 +"|                                                                  |\n"
 +"|      \"Ha salido del laberinto, "+nombre+", pero no has           |\n"
  +"|        descubierto el gran secreto que éste escondía.           |\n"
  +"|           Mas no desesperes, la vida siempre reserva más        |\n"
  +"|             oportunidades para aquellos que las merecen...      |\n"
  +"|                                                                 |\n"
   +"|                      No bajes la guardia.                      |\n"
    +"|                                                               |\n"
   +"|                                                                 |\n"
  +"|                                              ____________________|_\n"
  +"|  ___________________-------------------------                      `\\\n"
  +"|/`--_                                                                 |\n"
  +"||[ ]||                                            ___________________/\n"
   +"\\===/___________________--------------------------";
        return mensaje;        
    }
   
}
