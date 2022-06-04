package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.UsuarioRol;
import pe.edu.upc.demo.repositories.IUsuarioRolRepository;
import pe.edu.upc.demo.serviceinterface.IUsuarioRolService;

@Service
public class UsuarioRolServiceImpl implements IUsuarioRolService{

	@Autowired
	private IUsuarioRolRepository usuariorolRepository;

	@Override
	public void insert(UsuarioRol usur) {
		// TODO Auto-generated method stub
		usuariorolRepository.save(usur);
	}

	@Override
	public List<UsuarioRol> list() {
		// TODO Auto-generated method stub
		return usuariorolRepository.findAll();
	}

	@Override
	public void delete(int idUsur) {
		// TODO Auto-generated method stub
		usuariorolRepository.deleteById(idUsur);
	}

	@Override
	public Optional<UsuarioRol> listId(int idUsur) {
		// TODO Auto-generated method stub
		return usuariorolRepository.findById(idUsur);
	}

	@Override
	public void update(UsuarioRol usur) {
		// TODO Auto-generated method stub
		usuariorolRepository.save(usur);
	}
	
	
	
}
