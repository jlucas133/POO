import java.util.Vector;

public class VectorConta implements IRepositorioConta{

    private Vector<ContaAbstrata> contas;

    public VectorConta(){
        contas = new Vector<ContaAbstrata>();
    }

    @Override
    public void inserir(ContaAbstrata conta) {
        contas.add(conta);
    }

    @Override
    public void remover(String numero) {
        for(ContaAbstrata conta : contas) {
            if(conta.getNumero().equals(numero)) {
                contas.remove(conta);
                break;
            }
        }
    }

    @Override
    public ContaAbstrata procurar(String numero) {
        for(ContaAbstrata conta : contas) {
            if(conta.getNumero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    @Override
    public ContaAbstrata[] listar() {
        ContaAbstrata[] listagem = new ContaAbstrata[contas.size()];
        int cont = 0;
        for(ContaAbstrata c : contas) listagem[cont++] = c;
        return listagem;
    }
    @Override
    public int tamanho() {
        return contas.size();
    }

}