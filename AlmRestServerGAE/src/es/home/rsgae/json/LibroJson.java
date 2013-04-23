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
	@JsonProperty(value = "serie")
	private String serie;
	@JsonProperty(value = "volumen")
	private String volumen;

	public LibroJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LibroJson(Long id, String nombre, String autor, String argumento,
			String paginas, String serie, String volumen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.argumento = argumento;
		this.paginas = paginas;
		this.serie = serie;
		this.volumen = volumen;
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
