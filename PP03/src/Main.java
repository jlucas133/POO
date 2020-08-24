import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Escolha a opção desejada:\n 1) Testa BancoVector\n 2) Testa BancoArray");
    int opcao = scanner.nextInt();
    switch(opcao) {
      case 1: testaBancoVector();
              break;
              
      case 2: testaBancoArray();
              break;
              
      default: System.out.println("Opção inexistente!");
              break;
    }
  }


  public static void testaBancoVector() {
    BancoVector banco = new BancoVector();
      String numero = "455";
      int valor = 500;
      Conta conta = new Conta(numero);
      banco.cadastrar(conta);
      banco.creditar(numero, valor);
      
      String numeroTransferencia = "777";
      ContaPoupanca contaTransferencia = new ContaPoupanca(numeroTransferencia);
      banco.cadastrar(contaTransferencia);
      if(banco.saldo(numero)==valor){
          System.out.println("As funcionalidades cadastrar, procurar, creditar e saldo estão funcionando");
      }
      
      banco.debitar(numero, valor);
      if(banco.saldo(numero)==0){
          System.out.println("A funcionalidade de debitar está funcionando");
      }
      banco.creditar(numero, valor);     
      banco.creditar(numeroTransferencia, valor);   
      banco.renderJuros(numeroTransferencia);
      if(banco.saldo(numeroTransferencia)==(valor+valor*(0.01))){
         System.out.println("A funcionalidade de render juros está funcionando");
      
      }
      banco.debitar(numeroTransferencia,(valor+valor*(0.01)));
      banco.transferir(numero, numeroTransferencia, valor);
      if(banco.saldo(numeroTransferencia)==valor && banco.saldo(numero)==0){
          System.out.println("A funcionalidade de transferencia está funcionando");
      }
      banco.setTaxa(valor);
      if(banco.getTaxa()==valor){
          System.out.println("As funcionalidades de setTaxa e getTaxa estão funcionando");
      }
  }
  
  public static void testaBancoArray(){
      BancoArray banco = new BancoArray();
      String numero = "455";
      int valor = 500;
      Conta conta = new Conta(numero);
      banco.cadastrar(conta);
      banco.creditar(numero, valor);
      
      String numeroTransferencia = "777";
      ContaPoupanca contaTransferencia = new ContaPoupanca(numeroTransferencia);
      banco.cadastrar(contaTransferencia);
      if(banco.saldo(numero)==valor){
          System.out.println("As funcionalidades cadastrar, procurar, creditar e saldo estão funcionando");
      }
      
      banco.debitar(numero, valor);
      if(banco.saldo(numero)==0){
          System.out.println("A funcionalidade de debitar está funcionando");
      }
      banco.creditar(numero, valor);     
      banco.creditar(numeroTransferencia, valor);   
      banco.renderJuros(numeroTransferencia);
      if(banco.saldo(numeroTransferencia)==(valor+valor*(0.01))){
         System.out.println("A funcionalidade de render juros está funcionando");
      
      }
      banco.debitar(numeroTransferencia,(valor+valor*(0.01)));
      banco.transferir(numero, numeroTransferencia, valor);
      if(banco.saldo(numeroTransferencia)==valor && banco.saldo(numero)==0){
          System.out.println("A funcionalidade de transferencia está funcionando");
      }
      banco.setTaxa(valor);
      if(banco.getTaxa()==valor){
          System.out.println("As funcionalidades de setTaxa e getTaxa estão funcionando");
      }
  }
  
}