package co.edu.udea.pruebas.PracticaFacturaDeVenta.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity(name="Factura")
public class FacturaEntity {

	@Id
	@NotNull
	private int numeroFactura;
	private double valorTotal;
	private String nombreCajero;
	private Date fechaVenta;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
	private Collection<VentaEntity> ventaEntityCollection;

	
	public int getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getNombreCajero() {
		return nombreCajero;
	}

	public void setNombreCajero(String nombreCajero) {
		this.nombreCajero = nombreCajero;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Collection<VentaEntity> getVentaEntityCollection() {
		return ventaEntityCollection;
	}

	public void setVentaEntityCollection(Collection<VentaEntity> ventaEntityCollection) {
		this.ventaEntityCollection = ventaEntityCollection;
	}
		
}
