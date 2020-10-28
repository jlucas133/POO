package main;
import java.util.Scanner;
import java.util.Vector;
import contas.*;
import exception.*;
import implementações.*;
import implementações.tweet.Tweet;


class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        VectorConta vectorConta = new VectorConta();
        MyTwitter myTwitter = new MyTwitter(vectorConta);
        
        int verificadorUm;
        int verificadorDois;
        int numeroSeguidores;
        String usuario;
        String usuarioSeguido;
        String mensagem;
        
        do{
            System.out.println("----------TESTE DE FUNCIONALIDADE----------");
            System.out.println("1-Criar um perfil");
            System.out.println("2-Desativar perfil");
            System.out.println("3-Tweetar");
            System.out.println("4-Ver a timeline");
            System.out.println("5-Ver tweets de um usuário");
            System.out.println("6-Seguir algum perfil");
            System.out.println("7-Obter número de seguidores");
            System.out.println("8-Obter todos seguidores de um usuário");
            System.out.println("9-Obter todos seguidos de um usuário");
            System.out.println("10-Sair");
            verificadorUm = scanner.nextInt();
            
            switch(verificadorUm){
                case 1:                                  
                        do{
                            System.out.println("Deseja cadastrar como qual das duas opções abaixo?");
                            System.out.println("1-Pessoa Física");
                            System.out.println("2-Pessoa Jurídica");
                            System.out.println("3-Sair");
                            verificadorDois = scanner.nextInt();
                            switch(verificadorDois){
                                case 1: System.out.println("Escreva o nome de usuário desejado.");
                                        usuario = scanner.next();
                                        PessoaFisica contaCpf = new PessoaFisica(usuario);
                                        System.out.println("Digite seu CPF");
                                        long cpf = scanner.nextLong();
                                        contaCpf.setCpf(cpf);                                     
                                        try{    
                                            myTwitter.criarPerfil(contaCpf);
                                        }catch(PEException e){
                                            System.out.println("Perfil com nome de usuário já cadastrado!");
                                        }
                                        verificadorDois=3;
                                        break;
                                case 2: System.out.println("Escreva o nome de usuário desejado.");
                                        usuario = scanner.next();
                                        PessoaJuridica contaCnpj = new PessoaJuridica(usuario);
                                        System.out.println("Digite seu CNPJ");
                                        long cnpj = scanner.nextLong();
                                        contaCnpj.setCnpj(cnpj);
                                        try{    
                                            myTwitter.criarPerfil(contaCnpj);
                                        }catch(PEException e){
                                            System.out.println("Perfil com nome de usuário já cadastrado!");
                                        }
                                        verificadorDois=3;
                                        break;
                                default: System.out.println("Opção inválida");
                                        break;
                            }

                        }while(verificadorDois!=3);
                        break;
                        
                case 2: System.out.println("Digite o seu nome de usuário.");
                        usuario = scanner.next();
                        try{
                            myTwitter.cancelarPerfil(usuario);
                            System.out.println("Perfil desativado com sucesso!");
                        }catch(PIException e){
                            System.out.println("Perfil inexistente!");
                        }catch(PDException e){
                            System.out.println("Perfil já está desativado!");     
                        }
                        
                       
                        break;
                case 3: System.out.println("Digite o seu nome de usuário.");
                        usuario = scanner.next();
                        System.out.println("Digite a mensagem que deseja tweetar.");
                        scanner.nextLine();// esvazia o buffer do teclado
                        mensagem = scanner.nextLine();
                        
                        
                        try{
                            myTwitter.tweetar(usuario, mensagem);
                        }catch(MFPException e){
                            System.out.println("Mensagem com número de caracteres inválido!");
                        }catch(PIException e){
                            System.out.println("Perfil inexistente!");
                        }                            
                        break;
                case 4: System.out.println("Digite o seu nome de usuário.");
                        usuario = scanner.next();
                        Vector<Tweet> timeline = new Vector<Tweet>();
                        try{    
                            timeline = myTwitter.timeline(usuario);
                            System.out.println("Timeline:");
                            for(int i = 0 ; i < timeline.size() ; i++){
                                System.out.println(timeline.elementAt(i).getUsuario()+"-"+ timeline.elementAt(i).getMensagem());
                            }
                        }catch(PIException e){
                            System.out.println("Perfil inexistente!");
                        }catch(PDException e){
                            System.out.println("Perfil existente desativado!");
                        }
                        break;
                
                
                case 5: System.out.println("Digite o seu nome de usuário.");
                        usuario = scanner.next();
                        Vector<Tweet> tweets = new Vector<Tweet>();
                        try{
                            tweets = myTwitter.tweets(usuario);
                            System.out.println("Tweets:");
                            for(int i = 0 ; i < tweets.size() ; i++){
                                System.out.println(tweets.elementAt(i).getUsuario()+"-"+ tweets.elementAt(i).getMensagem());
                            }
                        }catch(PIException e){
                            System.out.println("Perfil inexistente!");
                        }catch(PDException e){
                            System.out.println("Perfil existente desativado!");
                        }
                        break;
                        
                case 6: System.out.println("Digite o seu nome de usuário.");
                        usuario = scanner.next();
                        System.out.println("Digite o nome de usuário que deseja seguir.");
                        usuarioSeguido = scanner.next();
                        try{
                            myTwitter.seguir(usuario, usuarioSeguido);
                            System.out.println("Usuário seguido com sucesso!");
                        }catch(PIException e){
                            System.out.println("Perfil inexistente!");
                        }catch(PDException e){
                            System.out.println("Perfil existente desativado!");
                        }catch(SIException e){
                            System.out.println("Nome de usuário seguidor inválido!");
                        }
                        break;
                case 7: System.out.println("Digite o seu nome de usuário.");
                        usuario = scanner.next();
                        
                        try{
                            numeroSeguidores = myTwitter.numeroSeguidores(usuario);
                            System.out.println("Número de seguidores: "+numeroSeguidores);
                        }catch(PIException e){
                            System.out.println("Perfil inexistente!");
                        }catch(PDException e){
                            System.out.println("Perfil existente desativado!");
                        }
                        break;
                case 8: System.out.println("Digite o nome de usuário.");
                        usuario = scanner.next();
                        Vector<Perfil> seguidores = new Vector<Perfil>();
                        try{
                            seguidores = myTwitter.seguidores(usuario);
                            System.out.println("Seguidores:");
                            for(int i = 0 ; i < seguidores.size() ; i++){
                                System.out.println(seguidores.elementAt(i).getUsuario());
                            }
                        }catch(PIException e){
                            System.out.println("Perfil inexistente!");
                        }catch(PDException e){
                            System.out.println("Perfil existente desativado!");
                        }
                        break;
                case 9: System.out.println("Digite o nome de usuário.");
                        usuario = scanner.next();
                        Vector<Perfil> seguidos = new Vector<Perfil>();
                        try{
                            seguidos = myTwitter.seguidos(usuario);
                            System.out.println("Seguidos:");
                            for(int i = 0 ; i < seguidos.size() ; i++){
                                System.out.println(seguidos.elementAt(i).getUsuario());
                            }
                        }catch(PIException e){
                            System.out.println("Perfil inexistente!");
                        }catch(PDException e){
                            System.out.println("Perfil existente desativado!");
                        }
                        break;
                default: System.out.println("Opção inválida, tente novamente.");
                         break;
            }
        }while(verificadorUm!=10);
    }
}
