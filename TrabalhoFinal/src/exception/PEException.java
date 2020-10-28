package exception;

import contas.Perfil;


public class PEException extends Exception {
    private Perfil usuario;
    public PEException (Perfil usuario){
        super("Perfil já existente!");
        this.usuario = usuario;
    }
    
}
