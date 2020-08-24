  public class Conta {
    private String numero;
    private double saldo;
    
    public Conta (String numero){
      this.numero = numero;
      saldo = 0.0;
    } 
    
    public void creditar(double valor){
      this.saldo = this.saldo + valor;
    }
    
    public void debitar(double valor){
      this.saldo = this.saldo - valor;
    }
    
    public String getNumero(){
      return numero;
    }
    
    public double getSaldo(){
      return saldo;
    }
    
    
  }