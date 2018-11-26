package co.edu.udea.pruebas.PracticaFacturaDeVenta.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity(name="Producto")
public class ProductoEntity {
	
	@Id
	@NotNull
	private int codigo;	
	private String producto;
	private double valorUnitario;
	private double iva;	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
	private Collection<VentaEntity> ventaEntityCollection;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public Collection<VentaEntity> getVentaEntityCollection() {
		return ventaEntityCollection;
	}

	public void setVentaEntityCollection(Collection<VentaEntity> ventaEntityCollection) {
		this.ventaEntityCollection = ventaEntityCollection;
	}
	
}
