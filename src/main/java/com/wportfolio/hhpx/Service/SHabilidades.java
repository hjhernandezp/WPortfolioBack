package com.wportfolio.hhpx.Service;

import com.wportfolio.hhpx.Entity.Habilidades;
import com.wportfolio.hhpx.Repository.RHabilidades;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHabilidades {
    @Autowired
    RHabilidades RepHabilidades;
    
    public List<Habilidades> list() {
        return RepHabilidades.findAll();
    }
    
    public Optional<Habilidades> getOne(int id) {
        return RepHabilidades.findById(id);
    }
    
    public Optional<Habilidades> getByNombre(String nombre) {
        return RepHabilidades.findByNombre(nombre);
    }
    
    public void save(Habilidades habilidades) {
        RepHabilidades.save(habilidades);
    }
    
    public void delete(int id) {
        RepHabilidades.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return RepHabilidades.existsById(id);
    }
    
    public boolean existsByNombre(String nombre) {
        return RepHabilidades.existsByNombre(nombre);
    }
}
