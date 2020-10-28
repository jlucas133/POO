package interfaces;

import contas.Perfil;
import exception.UJCException;
import exception.UNCException;


public interface IRepositorioUsuario {
    public void cadastrar(Perfil usuario) throws UJCException;
    public Perfil buscar(String usuario);
    public void atualizar(Perfil usuario)throws UNCException;
    
}
