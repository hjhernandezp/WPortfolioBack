package com.wportfolio.hhpx.Service;

import com.wportfolio.hhpx.Entity.Persona;
import com.wportfolio.hhpx.Repository.RPersona;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SPersona {
    @Autowired
    RPersona repPersona;
    
    public List<Persona> list() {
        return repPersona.findAll();
    }
    
    public Optional<Persona> getOne(int id) {
        return repPersona.findById(id);
    }

    public Optional<Persona> getByNombre(String nombre) {
        return repPersona.findByNombre(nombre);
    }

    public void save(Persona persona) {
        repPersona.save(persona);
    }
    
    public void delete(int id) {
        repPersona.deleteById(id);
    }

    public boolean existsById(int id) {
        return repPersona.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return repPersona.existsByNombre(nombre);
    }
}
