package com.wportfolio.hhpx.Service;

import com.wportfolio.hhpx.Entity.Estudios;
import com.wportfolio.hhpx.Repository.REstudios;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEstudios {
    @Autowired
    REstudios RepEstudios;
    
    public List<Estudios> list() {
        return RepEstudios.findAll();
        
    }
    
    public Optional<Estudios> getOne(int id) {
        return RepEstudios.findById(id);
    }
    
    public Optional<Estudios> getByCarrera(String carrera) {
        return RepEstudios.findByCarrera(carrera);
    }
    
    public void save(Estudios estudios) {
        RepEstudios.save(estudios);
    }
    
    public void delete(int id) {
        RepEstudios.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return RepEstudios.existsById(id);
    }
    
    public boolean existsByCarrera(String carrera) {
        return RepEstudios.existsByCarrera(carrera);
    }
}
