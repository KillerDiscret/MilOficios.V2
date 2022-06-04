package pe.edu.upc.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="UsuarioRol")
public class UsuarioRol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;
	
	@ManyToOne
    @JoinColumn(name = "idRol", nullable = false)
    private Rol rol;

	public UsuarioRol() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioRol(int id, Usuario usuario, Rol rol) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.rol = rol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
}
