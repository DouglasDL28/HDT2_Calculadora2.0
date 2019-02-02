import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

     public static String menu = "MENÚ: \n" +
             "\t 1. Usar calculadora. \n" +
            "\t 2. Salir del programa.";

    public static void main (String []args){

        boolean wantsToContinue = true;

        Scanner input = new Scanner(System.in);
        iCalculadora calculadora = new Calculadora();
        iPila<String> myPila = new Pila<>();

        do {
            System.out.println(menu);
            int option = input.nextInt();
            switch (option){
                case 1: {
                    System.out.print("Ingrese el archivo de texto que desea procesar: ");
                    Scanner in = new Scanner(System.in);
                    String userFile = in.nextLine();

                    try {
                        Stream<String> lines = Files.lines(
                                Paths.get(userFile),
                                StandardCharsets.UTF_8
                        );
                        lines.forEach(line -> {
                           String[] parts = line.split(" ");
                           for(String i: parts){
                               System.out.println(i.toString());
                               switch (i){
                                   case "/": {
                                       Double a = Double.parseDouble(myPila.pop());
                                       Double b = Double.parseDouble(myPila.pop());
                                       Double resultado = calculadora.dividir(a, b);
                                       myPila.push(resultado.toString());
                                       break;
                                   }

                                   case "*": {
                                       Double a = Double.parseDouble(myPila.pop());
                                       Double b = Double.parseDouble(myPila.pop());
                                       Double resultado = calculadora.multiplicar(a, b);
                                       myPila.push(resultado.toString());
                                       break;
                                   }

                                   case "+": {
                                       Double a = Double.parseDouble(myPila.pop());
                                       Double b = Double.parseDouble(myPila.pop());
                                       Double resultado = calculadora.sumar(a, b);
                                       myPila.push(resultado.toString());
                                       break;
                                   }

                                   case "-": {
                                       Double a = Double.parseDouble(myPila.pop());
                                       Double b = Double.parseDouble(myPila.pop());
                                       Double resultado = calculadora.restar(a, b);
                                       myPila.push(resultado.toString());
                                       break;
                                   }

                                   default: myPila.push(i);
                                   break;
                               }
                           }
                        });
                    } catch (IOException exception) {
                        System.out.println("Error!");
                    }

                    System.out.println(myPila.toString());
                    break;
                }

                case 2: {
                    wantsToContinue = false;
                    break;
                }
            }

        } while (wantsToContinue);

    }
}
