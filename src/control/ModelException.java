package control;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Marco A. Fernández Heras on 27/03/16.
 */
public class ModelException extends Exception {
    private final Throwable cause;

    public ModelException(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        String message = "Error desconocido: " + cause.getMessage();
        if (cause.getClass().equals(com.mysql.jdbc.exceptions.jdbc4.CommunicationsException.class))
            message = "Problemas en la conexión de la base de datos";

        if (cause.getClass().equals(ArithmeticException.class))
            message = "Excepción de operacion aritmetica";

        if (cause.getClass().equals(NullPointerException.class))
            message = "Excepción de variable u objeto nulo/no inicializado";

        if (cause.getClass().equals(FileNotFoundException.class))
            message = "Excepción de archivo no encontrado";

        if (cause.getClass().equals(IOException.class))
            message = "Excepción de entrada/salida";

        if (cause.getClass().equals(NumberFormatException.class))
            message = "Excepción de formato incorrecto";

        if (cause.getClass().equals(ClassNotFoundException.class))
            message = "Excepción de clase no encontrada";
        return message;
    }
}
