package implementações;

import java.util.Scanner;
import contas.Perfil;
import exception.*;
import interfaces.IRepositorioUsuario;
import java.util.Vector;

public class VectorConta implements IRepositorioUsuario{

    private Vector<Perfil> contas;

    public VectorConta(){
        contas = new Vector<Perfil>();
    }

    @Override
    public void cadastrar(Perfil usuario) throws UJCException {
        if(buscar(usuario.getUsuario())!=null){
            throw new UJCException(usuario);
        }else{
            System.out.println("Usuário cadastrado!");
            contas.add(usuario);
        }
    }

    @Override
    public Perfil buscar(String usuario) {
        for(Perfil conta : contas) {
            if(conta.getUsuario().equals(usuario)) {
                return conta;
            }
        }
        return null;
    }
    
    @Override
    public void atualizar(Perfil usuario)throws UNCException {
        if(contas.contains(usuario)){
            int verificador;
            do{
                Scanner scanner = new Scanner(System.in);
                System.out.println("O que deseja fazer?");
                System.out.println("1-Atualizar nome de usuário");
                System.out.println("2-Deseja ativar perfil?");
                System.out.println("3-Deseja desativar perfil?");
                System.out.println("4-Sair");
                verificador = scanner.nextInt();
                                
                switch(verificador){
                    case 1: System.out.println("Escreva o nome de usuário desejado.");
                            String nome = scanner.next();
                            int digitoVerificador = 0;
                            for(Perfil conta : contas) {
                                if(conta.getUsuario().equals(nome)) {
                                    System.out.println("Nome de usuário já cadastrado.");
                                    digitoVerificador=1;
                                }
                            }
                            if(digitoVerificador==1){
                                break;
                            }else{
                                usuario.setUsuario(nome);
                                break;
                            }
                    case 2: usuario.setAtivo(true);
                            break;
                            
                    case 3: usuario.setAtivo(false);
                            break;
                            
                    case 4: break;
                    
                    default: System.out.println("Opção inválida!");
                            break;
  
                }
            }while(verificador!=3);
        }else{
            throw new UNCException(usuario);
        }
    }
    

}