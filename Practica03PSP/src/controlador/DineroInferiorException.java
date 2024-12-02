package controlador;

public class DineroInferiorException extends Exception{
    public String mensaje = "El sueldo no puede ser inferior al sueldo mínimo.";

    public String getMensaje() {
        return mensaje;
    }
    public DineroInferiorException(){
        System.out.println("El saldo de la cuenta es inferior al saldo mínimo.");
    }
    
}
