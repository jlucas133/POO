package exception;

import contas.Perfil;


public class SIException extends Exception {
    private Perfil usuario;
    public SIException (Perfil usuario){
        super("Seguidor inválido!");
        this.usuario = usuario;
    }
    
}
