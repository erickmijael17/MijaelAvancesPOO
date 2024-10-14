package pe.edu.upeu.sysalmacenfx.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysalmacenfx.modelo.VentaCarrito;

@Repository
public interface VentaCarritoRepository extends JpaRepository<VentaCarrito, Long> {

}
