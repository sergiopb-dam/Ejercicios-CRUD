package crud4;

import java.util.Objects;

public class Disco {
	private String codigo;
	private String autor;
	private String titulo;
	private int duracion;
	private String genero;

	public Disco(String codigo, String autor, String titulo, int duracion, String genero) {
		this.codigo = codigo;
		this.autor = autor;
		this.titulo = titulo;
		this.duracion = duracion;
		this.genero = genero;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Disco [" + codigo + "] - Titulo: " + titulo + " | Autor: " + autor + " | Duracion: " + duracion
				+ " min | Genero: " + genero;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Disco disco = (Disco) obj;
		return Objects.equals(codigo, disco.codigo);
	}
}