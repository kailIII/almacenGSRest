package es.home.rsgae.bean;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long ident;
	@Persistent
	private String nombre;
	@Persistent
	private String autor;
	@Persistent
	private String argumento;
	@Persistent
	private String paginas;

	public Libro() {
		super();
		// TODO Auto-generated constructor stubd
	}

	public Libro(final Long ident, final String nombre, final String autor, final String argumento,
			final String paginas) {
		super();
		this.ident = ident;
		this.nombre = nombre;
		this.autor = autor;
		this.argumento = argumento;
		this.paginas = paginas;
	}

	public String getArgumento() {
		return argumento;
	}

	public String getAutor() {
		return autor;
	}

	public Long getIdent() {
		return ident;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPaginas() {
		return paginas;
	}

	public void setArgumento(final String argumento) {
		this.argumento = argumento;
	}

	public void setAutor(final String autor) {
		this.autor = autor;
	}

	public void setIdent(final Long ident) {
		this.ident = ident;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public void setPaginas(final String paginas) {
		this.paginas = paginas;
	}

}
