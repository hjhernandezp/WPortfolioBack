package com.wportfolio.hhpx.Service;

import com.wportfolio.hhpx.Entity.Cursos;
import com.wportfolio.hhpx.Repository.RCursos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SCursos {
    @Autowired
    RCursos RepCursos;
    
    public List<Cursos> list() {
        return RepCursos.findAll();
    }
    
    public Optional<Cursos> getOne(int id) {
        return RepCursos.findById(id);
    }

    public Optional<Cursos> getByNombre(String nombre) {
        return RepCursos.findByNombre(nombre);
    }

    public void save(Cursos cursos) {
        RepCursos.save(cursos);
    }
    
    public void delete(int id) {
        RepCursos.deleteById(id);
    }

    public boolean existsById(int id) {
        return RepCursos.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return RepCursos.existsByNombre(nombre);
    }
}
