package pe.edu.upeu.sysalmacenfx.servicio;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.VentaCarrito;
import pe.edu.upeu.sysalmacenfx.repositorio.VentaCarritoRepository;

import java.util.List;
@Service
public class VentaCarritoService {
    @Autowired
    VentaCarritoRepository repo;

    public VentaCarrito save(VentaCarrito to) {
        return repo.save(to);
    }

    public List<VentaCarrito> list() {
        return repo.findAll();
    }

    public VentaCarrito update(VentaCarrito to, Long id) {
        try {
            VentaCarrito toe = repo.findById(id).orElse(null);
            if (toe != null) {
                toe.setEstado(to.getEstado());
                return repo.save(toe);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public VentaCarrito searchById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<VentaCarrito> listaCarritoCliente(String dni) {
        return repo.listaCarritoCliente(dni);
    }
    @Transactional
    public void deleteCarAll(String dniruc) {
        this.repo.deleteByDniruc(dniruc);
    }

}
