package co.edu.udea.pruebas.PracticaFacturaDeVenta.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.udea.pruebas.PracticaFacturaDeVenta.entity.FacturaEntity;

@Repository
public interface FacturaRepository extends CrudRepository<FacturaEntity, Long>{

}
