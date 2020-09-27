public class ArrayConta implements IRepositorioConta{

    private ContaAbstrata[] contas;
    private int indice = 0;
    
    public ArrayConta() {
        contas = new ContaAbstrata[100];
    }

    @Override
    public void inserir(ContaAbstrata conta) {
        if(procurar(conta.getNumero()) == null) {
            contas[indice++] = conta;
        }
    }

    @Override
    public void remover(String numero) {
        for(int i = 0; i < indice; i++) {
           if(contas[i].getNumero().equals(numero)) {
               contas[i]= null;
           }
        }
    }

    @Override
    public ContaAbstrata procurar(String numero) {
        for(int i = 0; i < indice; i++) {
           if(contas[i].getNumero().equals(numero)) {
               return contas[i];
           }
        }
        return null;
    }

    @Override
    public ContaAbstrata[] listar() {
        return contas;
    }

    @Override
    public int tamanho() {
        return indice;
    }

}