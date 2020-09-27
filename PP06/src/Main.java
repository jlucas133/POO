import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Escolha a opção desejada:\n 1) Testa BancoIndependente\n 2) Testa AuditorBancoGenerico\n 3) Testa Auditoria");
    int opcao = scanner.nextInt();
    switch(opcao) {
      case 1: testaBancoIndependente();
              break;
              
      case 2: testaAuditorBancoGenerico();
              break;
              
      case 3: testaAuditoria();
              break;
              
      default: System.out.println("Opção inexistente!");
              break;
    }
  }


    public static void testaBancoIndependente() {
      BancoIndependente banco = new BancoIndependente(new VectorConta());
      String numero = "455";
      String numeroesp = "222";
      int valor = 500;
      ContaImposto conta = new ContaImposto(numero);
      banco.cadastrar(conta);
      ContaEspecial contaesp = new ContaEspecial(numeroesp);
      banco.cadastrar(contaesp);
      banco.creditar(numero, valor);
      
      String numeroTransferencia = "777";
      ContaPoupanca contaTransferencia = new ContaPoupanca(numeroTransferencia);
      banco.cadastrar(contaTransferencia);
      if(banco.saldo(numero)==valor){
          System.out.println("As funcionalidades cadastrar, procurar, creditar e saldo estão funcionando");
      }
      banco.creditar(numero, 100);
      banco.debitar(numero, valor);
      if(banco.saldo(numero)==99.5){
          System.out.println("A funcionalidade de debitar da ContaImpostor está funcionando");
      }
      banco.creditar(numero, 400.5);     
      banco.creditar(numeroTransferencia, valor);   
      banco.renderJuros(numeroTransferencia);
      if(banco.saldo(numeroTransferencia)==(valor+valor*(1))){
         System.out.println("A funcionalidade de render juros está funcionando");
      
      }
      banco.creditar(numero, 100);
      banco.debitar(numeroTransferencia,(valor+valor*(1)));
      banco.transferir(numero, numeroTransferencia, valor);
      if(banco.saldo(numeroTransferencia)==valor && banco.saldo(numero)==99.5){
          System.out.println("A funcionalidade de transferencia está funcionando");
      }
      banco.setTaxa(valor);
      if(banco.getTaxa()==valor){
          System.out.println("As funcionalidades de setTaxa e getTaxa estão funcionando");
      }
      for(int i=0;i<2;i++){
          banco.creditar(numeroesp,valor);
      }
      banco.renderBonus(numeroesp);
      if(banco.saldo(numeroesp)==1010){
          System.out.println("A funcionalidade de Render Bonus está funcionando");
      }
    }
  
    public static void testaAuditorBancoGenerico() {
      double valor = 550;
      String numero = "234";
      ContaAbstrata conta = new ContaPoupanca(numero);
      BancoVector vetor = new BancoVector(new VectorConta());
      vetor.cadastrar(conta);
      vetor.creditar(numero, valor);
      AuditorBancoGenerico auditor = new AuditorBancoGenerico();
      System.out.println("Saída esperada: Aprovada!");
      System.out.print("Saída real: ");
      auditor.auditar(vetor);
      
    }
    
    public static void testaAuditoria() {
      Auditoria auditor = new Auditoria();
      auditor.IniciarAuditoria();
    }
  
}