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
	private int numeroFactura;		
	private double ivaCalculado;
	
	@ManyToOne
	@JoinColumn(name="PRODUCTO",referencedColumnName="codigo")
	private ProductoEntity producto;	
	
	@ManyToOne
	@JoinColumn(name="FACTURA",referencedColumnName="numeroFactura")
	private FacturaEntity factura;

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
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
	
}
