package controlador;

public class DineroInferiorException extends Exception{
    public DineroInferiorException(){
        System.out.println("El saldo de la cuenta es inferior al saldo mínimo.");
    }

    
}
