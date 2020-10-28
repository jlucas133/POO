package exception;

import contas.Perfil;


public class UNCException extends Exception {
    private Perfil usuario;
    public UNCException (Perfil usuario){
        super("Usuário inexistente!");
        this.usuario = usuario;
    }
    
}
