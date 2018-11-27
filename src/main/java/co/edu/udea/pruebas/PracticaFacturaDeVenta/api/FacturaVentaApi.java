package co.edu.udea.pruebas.PracticaFacturaDeVenta.api;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.pruebas.PracticaFacturaDeVenta.entity.FacturaEntity;
import co.edu.udea.pruebas.PracticaFacturaDeVenta.entity.ProductoEntity;
import co.edu.udea.pruebas.PracticaFacturaDeVenta.entity.VentaEntity;
import co.edu.udea.pruebas.PracticaFacturaDeVenta.repositorio.FacturaRepository;
import co.edu.udea.pruebas.PracticaFacturaDeVenta.repositorio.ProductoRepository;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value = "/", headers = {
	"accept=application/json",
    "content-type=application/json"
})
public class FacturaVentaApi {

	@Autowired
	ProductoRepository productoRepository; 
		
	@Autowired
	FacturaRepository facturaRepository;
	
	@PostMapping(value="/productos")
	public String insertarProducto(@RequestBody List<Map<String, Object>> payload) {
		for (Map<String, Object> producto : payload) {
			ProductoEntity productoEntity = new ProductoEntity();
			productoEntity.setCodigo(Long.valueOf((Integer) producto.get("codigo")));
			productoEntity.setIva((Double) producto.get("iva"));
			productoEntity.setProducto((String) producto.get("producto"));
			productoEntity.setValorUnitario((Double) producto.get("valor_unitario"));
			productoRepository.save(productoEntity);
		}
		return "ok";
	}
	
	@PostMapping(value="/factura")
	public String guardarFactura(@RequestBody Map<String,Object> payload) {
		FacturaEntity facturaEntity=new FacturaEntity();
		facturaEntity.setNumeroFactura((Integer)(payload.get("numero-factura")));
		facturaEntity.setValorTotal((Double) payload.get("valor-total"));
		facturaEntity.setNombreCajero((String) payload.get("nombre-cajero"));
		facturaEntity.setFechaVenta(Date.valueOf((String)payload.get("fecha-venta")));
		facturaEntity.setNombreEstablecimiento((String) payload.get("nombre-establecimiento"));
		facturaEntity.setNit((String) payload.get("nit"));
		facturaEntity.setAhorro((Double)(payload.get("ahorro")));
		facturaEntity.setValorPagado((Double)payload.get("valor-pagado"));
		
		List<VentaEntity> listVentaEntity=new ArrayList<>();
		List<Map<String,Object>> listProductos=(List<Map<String, Object>>) payload.get("productos");
		
		for(Map<String,Object> producto:listProductos) {
			Integer codigo=(Integer)producto.get("codigo");
			Optional<ProductoEntity> productoEntity=productoRepository.findById(Long.valueOf(codigo));
			if(productoEntity.isPresent()) {
				VentaEntity ventaEntity=new VentaEntity();
				ventaEntity.setProducto(productoEntity.get());
				ventaEntity.setCantidad((Integer)producto.get("cantidad"));
				ventaEntity.setIvaCalculado((Double)producto.get("iva-calculado"));
				ventaEntity.setValorTotal((Double)producto.get("valor-total"));
				ventaEntity.setFactura(facturaEntity);
				listVentaEntity.add(ventaEntity);
			}
		}		
		facturaEntity.setVentaEntityCollection(listVentaEntity);
		facturaRepository.save(facturaEntity);
		return "Factura guardado";
	}
	
}
