package co.edu.udea.pruebas.PracticaFacturaDeVenta.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.pruebas.PracticaFacturaDeVenta.entity.ProductoEntity;
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
	
	@PostMapping(value="/productos")
	public String insertarProducto(@RequestBody Map<String, String> payload) {
		ProductoEntity productoEntity=new ProductoEntity();
		productoEntity.setCodigo(Integer.parseInt(payload.get("codigo")));
		productoEntity.setIva(Double.parseDouble(payload.get("iva")));
		productoEntity.setProducto(payload.get("producto"));
		productoEntity.setValorUnitario(Double.parseDouble(payload.get("valor_unitario")));
		productoRepository.save(productoEntity);
		return "ok";
	}
	
	@GetMapping(value="/productos")
	public String insertarProducto() {
		return "GET";
	}
	
}
