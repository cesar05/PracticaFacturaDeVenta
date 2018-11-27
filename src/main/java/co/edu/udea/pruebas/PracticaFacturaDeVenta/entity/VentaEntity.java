package co.edu.udea.pruebas.PracticaFacturaDeVenta.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity(name="Venta")
public class VentaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double ivaCalculado;
	private double valorTotal;
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name="PRODUCTO",referencedColumnName="codigo")
	private ProductoEntity producto;	
	
	@ManyToOne
	@JoinColumn(name="FACTURA",referencedColumnName="numeroFactura")
	private FacturaEntity factura;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getIvaCalculado() {
		return ivaCalculado;
	}

	public void setIvaCalculado(double ivaCalculado) {
		this.ivaCalculado = ivaCalculado;
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}

	public FacturaEntity getFactura() {
		return factura;
	}

	public void setFactura(FacturaEntity factura) {
		this.factura = factura;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
