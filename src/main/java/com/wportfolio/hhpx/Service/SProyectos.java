package com.wportfolio.hhpx.Service;

import com.wportfolio.hhpx.Entity.Proyectos;
import com.wportfolio.hhpx.Repository.RProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyectos {
    @Autowired
    RProyectos RepProyectos;
    
     public List<Proyectos> list() {
        return RepProyectos.findAll();
    }
    
    public Optional<Proyectos> getOne(int id) {
        return RepProyectos.findById(id);
    }

    public Optional<Proyectos> getByNombre(String nombre) {
        return RepProyectos.findByNombre(nombre);
    }

    public void save(Proyectos proyectos) {
        RepProyectos.save(proyectos);
    }
    
    public void delete(int id) {
        RepProyectos.deleteById(id);
    }

    public boolean existsById(int id) {
        return RepProyectos.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return RepProyectos.existsByNombre(nombre);
    }
}
