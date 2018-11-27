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
	private Long codigo;	
	private String producto;
	private Double valorUnitario;
	private Double iva;
		
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
	private Collection<VentaEntity> ventaEntityCollection;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Collection<VentaEntity> getVentaEntityCollection() {
		return ventaEntityCollection;
	}

	public void setVentaEntityCollection(Collection<VentaEntity> ventaEntityCollection) {
		this.ventaEntityCollection = ventaEntityCollection;
	}	
	
}
