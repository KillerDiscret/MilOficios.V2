package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Rol;
import pe.edu.upc.demo.repositories.IRolRepository;
import pe.edu.upc.demo.serviceinterface.IRolService;

@Service
public class RolServiceImpl implements IRolService{

	@Autowired
	private IRolRepository rolRepository;
	
	@Override
	public void insert(Rol role) {
		// TODO Auto-generated method stub
		rolRepository.save(role);
	}

	@Override
	public List<Rol> list() {
		// TODO Auto-generated method stub
		return rolRepository.findAll();
	}

	@Override
	public void delete(int idRole) {
		// TODO Auto-generated method stub
		rolRepository.deleteById(idRole);
	}

	@Override
	public Optional<Rol> listId(int idRole) {
		// TODO Auto-generated method stub
		return rolRepository.findById(idRole);
	}

	@Override
	public void update(Rol role) {
		// TODO Auto-generated method stub
		rolRepository.save(role);
	}

}
