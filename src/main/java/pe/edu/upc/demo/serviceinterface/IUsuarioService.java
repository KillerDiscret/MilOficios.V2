package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Usuario;

public interface IUsuarioService {
	
	public void insert(Usuario usua);
	
	public List<Usuario> list();
	
	public void delete(int idUsua);
	
	Optional<Usuario> listId(int idUsua);
	
	public void update(Usuario usua);
	
}
