package contas;

import implementações.tweet.Tweet;
import java.util.Vector;

public abstract class Perfil {
    protected String usuario;
    protected Vector<Perfil> seguidos;
    protected Vector<Perfil> seguidores;
    protected Vector<Tweet> timeline;
    protected boolean ativo;

    public Perfil(String usuario) {
        this.usuario = usuario;
        seguidos = new Vector<Perfil>();
        seguidores = new Vector<Perfil>();
        timeline = new Vector<Tweet>();
        ativo = true;
    }

    public String getUsuario() {
        return usuario;
    }
    
    public void addSeguidor(Perfil usuario){
        if(usuario !=null){
            seguidores.add(usuario);
        }
    }
    public void addSeguido(Perfil usuario){
        if(usuario !=null){
            seguidos.add(usuario);
        }
    }
    
    public void addTweet(Tweet tweet){
        if(tweet !=null){
            timeline.add(tweet);
        }
    }
    
    public Vector<Perfil> getSeguidos() {
        return seguidos;
    }

    public Vector<Perfil> getSeguidores() {
        return seguidores;
    }

    public Vector<Tweet> getTimeline() {
        return timeline;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public boolean isAtivo() {
        return ativo;
    }
    
}
