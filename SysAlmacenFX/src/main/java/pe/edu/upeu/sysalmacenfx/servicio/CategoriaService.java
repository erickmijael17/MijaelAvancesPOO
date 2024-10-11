package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.repositorio.CategoriaRepositoriy;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepositoriy repo;

    //C
    public Categoria save(Categoria to) {
        return repo.save(to);
    }

    //R
    public List<Categoria> list() {
        return repo.findAll();
    }
    //U
    public Categoria update(Categoria to, Long id) {
        try {
            Categoria toe = repo.findById(id).get();
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
    public Categoria buscarid(long id) {
        return  repo.findById(id).get();
    }

    public List<ComboBoxOption> listarCombobox(){
        List<ComboBoxOption> listar =new ArrayList<>();

        for (Categoria cate : repo.findAll()) {
            listar.add(new ComboBoxOption(
                    String.valueOf(cate.getIdCategoria()),
                    cate.getNombre()
            ));

        }
        return listar;

    }

}
