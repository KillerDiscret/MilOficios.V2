package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.repositories.IUsuarioRepository;
import pe.edu.upc.demo.serviceinterface.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Override
	public void insert(Usuario usua) {
		// TODO Auto-generated method stub
		usuarioRepository.save(usua);
	}

	@Override
	public List<Usuario> list() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public void delete(int idUsua) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(idUsua);
	}

	@Override
	public Optional<Usuario> listId(int idUsua) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(idUsua);
	}

	@Override
	public void update(Usuario usua) {
		// TODO Auto-generated method stub
		usuarioRepository.save(usua);
	}

}
