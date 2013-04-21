package es.home.rsgae.json;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement(name = "libro")
public class LibroJson implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "id")
	private Long id;
	@JsonProperty(value = "nombre")
	private String nombre;
	@JsonProperty(value = "autor")
	private String autor;
	@JsonProperty(value = "argumento")
	private String argumento;
	@JsonProperty(value = "paginas")
	private String paginas;

	public LibroJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LibroJson(final Long id, final String nombre, final String autor,
			final String argumento, final String paginas) {
		super();
		this.id = id;
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

	public Long getId() {
		return id;
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

	public void setId(final Long id) {
		this.id = id;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public void setPaginas(final String paginas) {
		this.paginas = paginas;
	}

}
