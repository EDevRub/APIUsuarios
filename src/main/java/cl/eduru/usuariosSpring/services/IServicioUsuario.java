package cl.eduru.usuariosSpring.services;

import cl.eduru.usuariosSpring.entity.Usuario;
import cl.eduru.usuariosSpring.exceptions.EmailException;
import cl.eduru.usuariosSpring.exceptions.PassException;

import java.util.List;

public interface IServicioUsuario {
    Usuario guardarUsuario(Usuario u) throws EmailException, PassException;

    List<Usuario> obtenerUsuarios();

    Usuario modificarUsuario(Long id,Usuario uModificado) throws EmailException, PassException;

    boolean eliminarUsuario(Long id);

    Usuario usuActivo(Long id);
}
