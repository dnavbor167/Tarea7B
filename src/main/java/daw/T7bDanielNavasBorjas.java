/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package daw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author daniel
 */
public class T7bDanielNavasBorjas {

    public static void main(String[] args) {
        //método para autopista para saber si contiene el AP-77
        System.out.println(patronAP1("AP-77 hola "));
        //método para autopista para saber si estrictamente  es toda el AP-77
        System.out.println(patronAP2("AP-77 hola"));

        //método para ver si coincide una matricula con la cadena pasada
        System.out.println(patronMatricula("1234 HLO"));
        
        //método para ver si coincide letraNumero
        System.out.println("El patrón se repite: " + contieneLetraNumero("a3,a4a5 a555"));
        
        //método para ver si es un código postal
        System.out.println(codigoPostal("01213"));
        
        //método para ver si es una cádena es un usuario ipasen
        System.out.println(usuIpasen("dnobvar345"));
        
        //método para ver si es una cádena tiene 5 caracteres sin incluir FRK
        System.out.println(tamaño5("hlaFy"));
        
        //método para ver si es una cádena tiene o hardware o software
        System.out.println(hardSoft("Software"));
    }

    //Saber si una cadena contiene el patrón AP-Nº (nombre de las autopistas), 
    //siendo Nº cualquier número de uno o dos dígitos. Ejemplos que cumplen el patrón: AP-7, AP-77...
    public static boolean patronAP1(String nombreAutopista) {
        String regex = "AP-\\d{1,2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher buscador = pattern.matcher(nombreAutopista);
        return buscador.find();
    }

    //Saber si una cadena coincide exactamente con el patrón anterior.
    public static boolean patronAP2(String nombreAutopista) {
        String regex = "^AP-\\d{1,2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher buscador = pattern.matcher(nombreAutopista);
        return buscador.find();
    }

    //Saber si una cadena coincide exactamente con el patrón de la matrícula de un coche.
    public static boolean patronMatricula(String matricula) {
        //matrícula española, VIVA ESPAÑA
        String regex = "^\\d{4}\\s+[A-Z]{3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher buscador = pattern.matcher(matricula);
        return buscador.find();
    }

    //Saber si una cadena contiene el patrón letraNumero, tantas veces como se repita. Ejemplos que cumplen el patrón: e3, e3r4, q1w2d4, ...
    public static int contieneLetraNumero(String letraNumero) {
        //hacemos un contador para ir contando cuantas veces se repite el patrón
        int contador = 0;
        String regex = "[a-zA-Z]{1}\\d{1}";
        Pattern pattern = Pattern.compile(regex);
        Matcher buscador = pattern.matcher(letraNumero);

        while (buscador.find()) {
            contador++;
        }

        return contador;
    }
    
    //Saber si una cadena es un código postal (5 dígitos)
    public static boolean codigoPostal(String codigoPostal) {
        String regex = "^\\d{5}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher buscador = pattern.matcher(codigoPostal);
        return buscador.find();
    }
    
    //Saber si una cadena es un usuario de IPasen, sabiendo que tiene entre 7 y 8 caracteres seguidos de 3 o 4 dígitos numéricos.
    public static boolean usuIpasen(String usuarioIpasen) {
        String regex = "^[^0-9]{7,8}\\d{3,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher buscador = pattern.matcher(usuarioIpasen);
        return buscador.find();
    }
    
    //Saber si una cadena tiene tamaño 5 y no contiene ni F, ni R, ni K.
    public static boolean tamaño5(String tamaño) {
        String regex = "^[^FRK]{5}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher buscador = pattern.matcher(tamaño);
        return buscador.find();
    }
    
    //Saber si una cadena contiene las palabras "Hardware" o "Software".
    public static boolean hardSoft(String palabras) {
        String regex = "\\b(Hardware|Software)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher buscador = pattern.matcher(palabras);
        return buscador.find();
    }
}
