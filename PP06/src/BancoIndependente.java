
public class BancoIndependente implements IBanco {
    private IRepositorioConta contas;
    private double taxa = 1.0;
    public BancoIndependente (IRepositorioConta contas){
        this.contas = contas;
    }
    public int numeroContas(){
        return contas.tamanho();
    }
    public void cadastrar(ContaAbstrata conta){
        contas.inserir(conta);
    }
    public ContaAbstrata procurar(String numero){
        return contas.procurar(numero);
    }
    public void debitar(String numero, double valor){
        ContaAbstrata conta = contas.procurar(numero);
        if(conta!=null){
            conta.debitar(valor);
        }else{
            System.out.println("Conta inexistente!");
        }
    }
    public void creditar(String numero, double valor){
        ContaAbstrata conta = contas.procurar(numero);
        if (conta != null) { 
          conta.creditar(valor); 
        } else { 
          System.out.println("Conta Inexistente!");
        }
    }
    
    public double saldoTotal(){
        double saldoTotal=0;
        ContaAbstrata[] lista;
        int indice = contas.tamanho();
        lista = contas.listar();
        for(int i = 0; i < indice; i++) {
            saldoTotal += lista[i].getSaldo();
        }
        return saldoTotal;
    }
    
    public double saldo(String numero) {
        ContaAbstrata conta = contas.procurar(numero);
        if (conta != null) {
          return conta.getSaldo();
        } else { 
          System.out.println("Conta Inexistente!");
        }
        return 0;
    }
    public void transferir(String origem, String destino, double valor){
        ContaAbstrata contaOrigem = contas.procurar(origem);
        if(contaOrigem != null) {
          ContaAbstrata contaDestino = contas.procurar(destino);
          if(contaDestino != null) {
            if(contaOrigem.getSaldo() > valor) {
              contaOrigem.debitar(valor);
              contaDestino.creditar(valor);
            } else {
              System.out.println("Saldo Insuficiente!");
            }
          } else {
            System.out.println("Conta Destino nº " + destino + " Inexistente!");        
          }
        } else {
          System.out.println("Conta Origem nº " + origem + " Inexistente!");
        }
    }
    public void renderJuros(String numero) {
        ContaAbstrata conta = contas.procurar(numero);
        if(conta != null) {
          if(conta instanceof ContaPoupanca) {
            ((ContaPoupanca) conta).renderJuros(this.taxa);
          } else {
            System.out.println("Ésta não é uma Conta Poupança!");
          }
        } else {
          System.out.println("Conta Inexistente!");
        }
    }
    public void renderBonus(String numero) {
        ContaAbstrata conta = procurar(numero);
        if(conta != null) {
          if(conta instanceof ContaEspecial) {
            ((ContaEspecial) conta).renderBonus();
          } else {
            System.out.println("Ésta não é uma Conta Especial!");
          }
        } else {
          System.out.println("Conta Inexistente!");
        }    
    }
    public void setTaxa(double valor){
        this.taxa = valor;
    }
    public double getTaxa() {
        return this.taxa;
    }
}
