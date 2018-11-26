package co.edu.udea.pruebas.PracticaFacturaDeVenta.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.udea.pruebas.PracticaFacturaDeVenta.entity.VentaEntity;

@Repository
public interface VentaRepository extends CrudRepository<VentaEntity, Long>{

}
