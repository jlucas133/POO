package exception;


public class MFPException extends Exception {
    private String usuario;
    public MFPException (String usuario){
        super("Mensagem com mais de 140 caracteres!");
        this.usuario = usuario;
    }
    
}
