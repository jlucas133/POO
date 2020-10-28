package exception;

import contas.Perfil;


public class PDException extends Exception {
    private Perfil usuario;
    public PDException (Perfil usuario){
        super("Perfil inativo existente!");
        this.usuario = usuario;
    }
    
}
