package pe.com.modelo;

public class Producto {
	private int id;
	private String nproducto;
	private String descripcion;
	private int categoria_id;
	private float precio;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNproducto() {
		return nproducto;
	}
	public void setNproducto(String nproducto) {
		this.nproducto = nproducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCategoria_id() {
		return categoria_id;
	}
	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	
}
