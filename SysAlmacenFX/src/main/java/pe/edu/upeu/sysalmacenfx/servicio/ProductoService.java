package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.Producto;
import pe.edu.upeu.sysalmacenfx.repositorio.ProductoRepository;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository repo;

    //C
    public Producto save(Producto to) {
        return repo.save(to);
    }

    //R
    public List<Producto> list() {
        return repo.findAll();
    }
    //U
    public Producto update(Producto to, Long id) {
        try {
            Producto toe = repo.findById(id).get();
            if (toe != null) {
                toe.setNombre(to.getNombre());
            }
            return repo.save(toe);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
    //D
    public void delete(Long id){
        repo.deleteById(id);
    }
    //B
    public Producto buscarid(long id) {
        return  repo.findById(id).get();
    }
}
