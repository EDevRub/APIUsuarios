package cl.eduru.usuariosSpring.services;

import cl.eduru.usuariosSpring.entity.Usuario;
import cl.eduru.usuariosSpring.exceptions.EmailException;
import cl.eduru.usuariosSpring.exceptions.PassException;
import cl.eduru.usuariosSpring.repository.IRepositorioUsuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class ServicioUsuario implements IServicioUsuario{

    private final IRepositorioUsuario repoUsu;
    public static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,16}$";

    @Override
    public Usuario guardarUsuario(Usuario u) throws EmailException, PassException {
        boolean emailValido = validarEmail(u.getEmail());
        boolean passValida = validarPass(u.getPassword());

        if(emailValido){
            if(passValida){
                return repoUsu.save(u);
            }else{
                throw new PassException();
            }
        }else{
            throw new EmailException();
        }

    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return repoUsu.findAll();
    }

    @Override
    public Usuario modificarUsuario(Long id,Usuario uModificado) throws EmailException, PassException {
        Usuario usu = repoUsu.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el id: " + id));

        boolean emailValido = validarEmail(uModificado.getEmail());
        boolean passValida = validarPass(uModificado.getPassword());

        if(emailValido){
            if (passValida){
                usu.setNombre(uModificado.getNombre());
                usu.setEmail(uModificado.getEmail());
                usu.setPassword(uModificado.getPassword());
                usu.setFechaModificacion(new Date());

                return repoUsu.save(usu);
            }else{
                throw new PassException();
            }
        }else{
            throw new EmailException();
        }
    }

    @Override
    public boolean eliminarUsuario(Long id) {
        try {
            repoUsu.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Usuario usuActivo(Long id) {
        Usuario cambiarEstadoUsu = repoUsu.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el id: " + id));

        if(cambiarEstadoUsu.getActivo().equals(true)){
            cambiarEstadoUsu.setActivo(false);
        }else {
            cambiarEstadoUsu.setActivo(true);
        }
        return repoUsu.save(cambiarEstadoUsu);
    }

    public boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validarPass(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        return pattern.matcher(password).matches();
    }
}