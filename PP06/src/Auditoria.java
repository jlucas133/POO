public class Auditoria {
    public void IniciarAuditoria(){
        double valor = 600;
        String numero1 = "123";
        String numero2 = "456";
        BancoArray bancoArray = new BancoArray(new ArrayConta());
        BancoVector bancoVector = new BancoVector(new VectorConta());
        ContaAbstrata conta1 = new ContaPoupanca(numero1);
        bancoArray.cadastrar(conta1);
        bancoArray.creditar(numero1, valor);
        
        ContaAbstrata conta2 = new ContaPoupanca(numero2);
        bancoVector.cadastrar(conta2);
        bancoVector.creditar(numero2, valor);
     
        AuditorBancoGenerico auditor = new AuditorBancoGenerico();
        System.out.println("Saída esperada do Auditor : Aprovada!");
        System.out.print("Saída real: ");
        auditor.auditar(bancoVector);
        auditor.auditar(bancoArray);
       
        
    }
}
