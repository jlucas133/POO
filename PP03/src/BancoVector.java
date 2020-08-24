import java.util.*;

public class BancoVector {
    private Vector<Conta> vetor;
    private double taxa = 1.0;
    public BancoVector(){
        vetor = new Vector<>();
    }
    
    public void cadastrar(Conta conta){
        vetor.add(conta);
    }
    private Conta procurar(String numero){
        for(Conta conta:vetor) {
            if(conta.getNumero().equals(numero)) {
                return conta;
        }
    }
        return null;
    } 
    public void creditar(String numero, double valor){
        Conta conta = procurar(numero);
        if (conta != null) { 
            conta.creditar(valor); 
        } else { 
            System.out.println("Conta Inexistente!");
        }
    }
    
    public void debitar(String numero, double valor){
        Conta conta = procurar(numero);
        if (conta != null) { 
            conta.debitar(valor); 
        }else { 
            System.out.println("Conta Inexistente!");
        }    
    }
    
    public double saldo(String numero) {
        Conta conta = procurar(numero);
        if (conta != null) {
            return conta.getSaldo();
        }else { 
            System.out.println("Conta Inexistente!");
        }
        return 0;
    }
    
    public void transferir(String origem, String destino, double valor){
        Conta contaOrigem = procurar(origem);
        if(contaOrigem != null) {
            Conta contaDestino = procurar(destino);
            if(contaDestino != null) {
                if(contaOrigem.getSaldo() >= valor) {
                    contaOrigem.debitar(valor);
                    contaDestino.creditar(valor);
                }else{
                    System.out.println("Saldo Insuficiente!");
                }
            }else{
                System.out.println("Conta Destino nº " + destino + " Inexistente!");        
            }
        }else{
            System.out.println("Conta Origem nº " + origem + " Inexistente!");
        }
    }
    
    public void renderJuros(String numero) {
		  for(Conta conta:vetor) {
		      if(conta.getNumero().equals(numero)) {
		        ((ContaPoupanca)conta).juros(taxa);
		      }
    }}
    public void setTaxa(double valor){
        taxa = valor;
    }
  
    public double getTaxa() {
        return taxa;
    }
    
    
}
