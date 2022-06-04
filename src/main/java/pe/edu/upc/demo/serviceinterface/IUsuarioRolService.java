package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.UsuarioRol;

public interface IUsuarioRolService {

	public void insert(UsuarioRol usur);

	public List<UsuarioRol> list();

	public void delete(int idUsur);

	Optional<UsuarioRol> listId(int idUsur);

	public void update(UsuarioRol usur);

}
