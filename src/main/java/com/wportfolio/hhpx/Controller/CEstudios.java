package com.wportfolio.hhpx.Controller;

import com.wportfolio.hhpx.Dto.DEstudios;
import com.wportfolio.hhpx.Entity.Estudios;
import com.wportfolio.hhpx.Security.Controller.Mensaje;
import com.wportfolio.hhpx.Service.SEstudios;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudios")
@CrossOrigin(origins = {"http://localhost:4200", "https://webportfolio-nl1014.web.app"})
public class CEstudios {
    @Autowired
    SEstudios SerEstudios;
    
    //LISTA
    @GetMapping("/lista")
    public ResponseEntity<List<Estudios>> list() {
        List<Estudios> list = SerEstudios.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //DETALLES
    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudios> getById(@PathVariable("id") int id){
        
        //VERIFICACIONES
        if(!SerEstudios.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        //OBTENCION
        Estudios estudios = SerEstudios.getOne(id).get();
        return new ResponseEntity(estudios, HttpStatus.OK);
    }
    
    //CREACION (NUEVO)
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DEstudios DtoEstudios) {
        
        //VERIFICACIONES
         if(SerEstudios.existsByCarrera(DtoEstudios.getCarrera())) {
            return new ResponseEntity(new Mensaje("Registro ya existe en: Estudios"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(DtoEstudios.getCarrera())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Carrera"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(DtoEstudios.getMencion())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Mención"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(DtoEstudios.getEstado())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Estado"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(DtoEstudios.getInstituto())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Instituto"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(DtoEstudios.getLugar())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Lugar"), HttpStatus.BAD_REQUEST);
        }
        
        //ASIGNACIONES
        Estudios estudios = new Estudios(
                DtoEstudios.getCarrera(), 
                DtoEstudios.getMencion(), 
                DtoEstudios.getEstado(),
                DtoEstudios.getInstituto(),
                DtoEstudios.getLugar()
        );
        
        //INCORPORACION
        SerEstudios.save(estudios);
        return new ResponseEntity(new Mensaje("Registro incorporado a: Estudios"), HttpStatus.OK);
    }
    
    //EDICION
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DEstudios DtoEstudios) {
        
        //VERIFICACIONES
        if(!SerEstudios.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        if(SerEstudios.existsByCarrera(DtoEstudios.getCarrera()) && SerEstudios.getByCarrera(DtoEstudios.getCarrera()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Registro ya existe en: Estudios"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(DtoEstudios.getCarrera())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Carrera"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(DtoEstudios.getMencion())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Mención"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(DtoEstudios.getEstado())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Estado"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(DtoEstudios.getInstituto())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Instituto"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(DtoEstudios.getLugar())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Lugar"), HttpStatus.BAD_REQUEST);
        }
        
        //ASIGNACIONES
        Estudios estudios = SerEstudios.getOne(id).get();
        estudios.setCarrera(DtoEstudios.getCarrera());
        estudios.setMencion(DtoEstudios.getMencion());
        estudios.setEstado(DtoEstudios.getEstado());
        estudios.setInstituto(DtoEstudios.getInstituto());
        estudios.setLugar(DtoEstudios.getLugar());
        
        //ACTUALIZACION
        SerEstudios.save(estudios);
        return new ResponseEntity(new Mensaje("Registro actualizado en: Estudios"), HttpStatus.OK);
    }
    
    //BORRADO
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        
        //VERIFICACIONES
        if(!SerEstudios.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        //ELIMINACION
        SerEstudios.delete(id);
        return new ResponseEntity(new Mensaje("Registro eliminado en: Estudios"), HttpStatus.OK);
    }
}
