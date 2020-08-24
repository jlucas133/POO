public class ContaPoupanca extends Conta{
    
    public ContaPoupanca(String numero){
        super(numero);
    }
    public void juros(double taxa){
        creditar((taxa/100)*getSaldo());
    }
    
}