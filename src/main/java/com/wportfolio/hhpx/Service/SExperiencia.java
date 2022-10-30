package com.wportfolio.hhpx.Service;

import com.wportfolio.hhpx.Entity.Experiencia;
import com.wportfolio.hhpx.Repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
    @Autowired
    RExperiencia RepExperiencia;
    
    public List<Experiencia> list() {
        return RepExperiencia.findAll();
    }
    
    public Optional<Experiencia> getOne(int id) {
        return RepExperiencia.findById(id);
    }

    public Optional<Experiencia> getByEmpresa(String empresa) {
        return RepExperiencia.findByEmpresa(empresa);
    }

    public void save(Experiencia experiencia) {
        RepExperiencia.save(experiencia);
    }
    
    public void delete(int id) {
        RepExperiencia.deleteById(id);
    }

    public boolean existsById(int id) {
        return RepExperiencia.existsById(id);
    }

    public boolean existsByEmpresa(String empresa) {
        return RepExperiencia.existsByEmpresa(empresa);
    }
}
