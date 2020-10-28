package contas;

public class PessoaJuridica extends Perfil{
    private long cnpj;
    
    public PessoaJuridica(String usuario){
        super(usuario);
    } 
    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cpnj) {
        this.cnpj = cnpj;
    }
}
