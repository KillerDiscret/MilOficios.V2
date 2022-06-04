package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Rol;

public interface IRolService {

	public void insert(Rol role);

	public List<Rol> list();

	public void delete(int idRole);

	Optional<Rol> listId(int idRole);

	public void update(Rol role);

}
