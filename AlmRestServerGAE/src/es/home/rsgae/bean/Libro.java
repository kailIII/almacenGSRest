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
	private String serie;
	@Persistent
	private String volumen;
	@Persistent
	private String paginas;

	public Libro() {
		super();
		// TODO Auto-generated constructor stubd
	}

	public Libro(Long ident, String nombre, String autor, String argumento,
			String serie, String volumen, String paginas) {
		super();
		this.ident = ident;
		this.nombre = nombre;
		this.autor = autor;
		this.argumento = argumento;
		this.serie = serie;
		this.volumen = volumen;
		this.paginas = paginas;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getVolumen() {
		return volumen;
	}

	public void setVolumen(String volumen) {
		this.volumen = volumen;
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
