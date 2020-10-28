package exception;

import contas.Perfil;


public class UJCException extends Exception{
    private Perfil usuario;
    public UJCException (Perfil usuario){
        super("Usuário já cadastrado!");
        this.usuario = usuario;
    }
    
}
