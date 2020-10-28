package implementações;

import implementações.tweet.Tweet;
import contas.Perfil;
import exception.*;
import interfaces.*;
import java.util.Vector;


public class MyTwitter implements ITwitter {
    private IRepositorioUsuario repositorio;

    public MyTwitter(IRepositorioUsuario repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void criarPerfil(Perfil usuario) throws PEException {
        if(repositorio.buscar(usuario.getUsuario())==null){
            try{
                repositorio.cadastrar(usuario);
            }catch(UJCException e){
                System.out.println("Nome de usuário já cadastrado!");
                //throw new PEException(usuario);
            }  
        }else{
            throw new PEException(usuario);
        }
    }

    @Override
    public void cancelarPerfil(String usuario) throws PIException, PDException{
        Perfil perfil = repositorio.buscar(usuario);
        if(perfil!=null ){
            if(perfil.isAtivo()){
                perfil.setAtivo(false);
            }else{
                throw new PDException(perfil);
            }
        }else{
            throw new PIException(usuario);
        }
    }

    @Override
    public void tweetar(String usuario, String mensagem) throws MFPException, PIException{
        if(mensagem.length()>140||mensagem.length()<1){
            throw new MFPException(usuario);
        }else{
            Tweet tweet = new Tweet();
            tweet.setMensagem(mensagem);
            tweet.setUsuario(usuario);
            
            Perfil perfil;
            perfil = repositorio.buscar(usuario);
            if(perfil!=null){
            
                if(perfil.isAtivo()){
                    perfil.addTweet(tweet);
                    System.out.println("Tweet feito com sucesso");
                    Vector<Perfil> seguidores;
                    seguidores = perfil.getSeguidores();

                    for(Perfil conta : seguidores) {
                        if(conta.isAtivo()){    
                            conta.addTweet(tweet);
                        }
                    }
                }else{
                    System.out.println("Perfil desativado!");
                }
            }else{
                throw new PIException(usuario);
            }
        }
        
    }

    @Override
    public Vector<Tweet> timeline(String usuario) throws PIException, PDException{
        Perfil perfil = repositorio.buscar(usuario);
        if(perfil!=null){
            if(perfil.isAtivo()){
                return perfil.getTimeline();
            }else{
                throw new PDException(perfil);
            }
        }else{
            throw new PIException(usuario);
        }
    }

    @Override
    public Vector<Tweet> tweets(String usuario) throws PIException,PDException{
        Perfil perfil = repositorio.buscar(usuario);
        if(perfil!=null){
            if(perfil.isAtivo()){
                Vector<Tweet> tweets = new Vector<Tweet>();
                Vector<Tweet> timeline = perfil.getTimeline();
                for(Tweet tweet : timeline){
                    if(tweet.getUsuario().equals(usuario)){
                        tweets.add(tweet);
                    }
                }
                return tweets;
                
            }else{
                throw new PDException(perfil);
            }
            
        }else{
            throw new PIException(usuario);
        }
    }

    @Override
    public void seguir(String seguidor, String seguido) throws PIException,PDException, SIException{
        Perfil perfilSeguidor = repositorio.buscar(seguidor);
        Perfil perfilSeguido = repositorio.buscar(seguido);
        if(!seguidor.equals(seguido)){   
            if(perfilSeguidor!=null){
                if(perfilSeguidor.isAtivo()){
                    if(perfilSeguido!=null){
                        if(perfilSeguido.isAtivo()){
                            perfilSeguido.addSeguidor(perfilSeguidor);
                            perfilSeguidor.addSeguido(perfilSeguido);   

                        }else{
                            throw new PDException(perfilSeguido);
                        }
                    }else{
                        throw new PIException(seguido);
                    }
                }else{
                    throw new PDException(perfilSeguidor);
                }

            }else{
                throw new PIException(seguidor);
            }
        }else{
            throw new SIException(perfilSeguidor);
        }
    }

    @Override
    public int numeroSeguidores(String usuario) throws PIException, PDException {
        Perfil perfil = repositorio.buscar(usuario);
        if(perfil!=null){
            if(perfil.isAtivo()){
                return perfil.getSeguidores().size();
            }else{
                throw new PDException(perfil);
            }
        }else{
            throw new PIException(usuario);
        }
    }

    @Override
    public Vector<Perfil> seguidores(String usuario) throws PIException, PDException {
        Perfil perfil = repositorio.buscar(usuario);
        if(perfil!=null){
            if(perfil.isAtivo()){
                return perfil.getSeguidores();
            }else{
                throw new PDException(perfil);
            }
        }else{
            throw new PIException(usuario);
        }
    }

    @Override
    public Vector<Perfil> seguidos(String usuario) throws PIException, PDException {
        Perfil perfil = repositorio.buscar(usuario);
        if(perfil!=null){
            if(perfil.isAtivo()){
                return perfil.getSeguidos();
            }else{
                throw new PDException(perfil);
            }
        }else{
            throw new PIException(usuario);
        }
    }
    
}
