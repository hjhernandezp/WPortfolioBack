package com.wportfolio.hhpx.Controller;

import com.wportfolio.hhpx.Dto.DCursos;
import com.wportfolio.hhpx.Entity.Cursos;
import com.wportfolio.hhpx.Security.Controller.Mensaje;
import com.wportfolio.hhpx.Service.SCursos;
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
@RequestMapping("/cursos")
@CrossOrigin(origins = {"http://localhost:4200", "https://webportfolio-nl1014.web.app"})
public class CCursos {
    @Autowired
    SCursos SerCursos;
    
    //LISTA
    @GetMapping("/lista")
    public ResponseEntity<List<Cursos>> list() {
        List<Cursos> list = SerCursos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //DETALLES
    @GetMapping("/detail/{id}")
    public ResponseEntity<Cursos> getById(@PathVariable("id") int id){
        
        //VERIFICACIONES
        if(!SerCursos.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        //OBTENCION
        Cursos cursos = SerCursos.getOne(id).get();
        return new ResponseEntity(cursos, HttpStatus.OK);
    }
    
    //CREACION (NUEVO)
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DCursos DtoCursos) {
        
        //VERIFICACIONES
         if(SerCursos.existsByNombre(DtoCursos.getNombre())) {
            return new ResponseEntity(new Mensaje("Registro ya existe en: Cursos"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(DtoCursos.getNombre())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Nombre"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(DtoCursos.getInstituto())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Instituto"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(DtoCursos.getLugar())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Lugar"), HttpStatus.BAD_REQUEST);
        }
        
        if(DtoCursos.getHoras() <= 0) {
            return new ResponseEntity(new Mensaje("Dato requerido: Horas"), HttpStatus.BAD_REQUEST);
        }
        
        //ASIGNACIONES
        Cursos cursos = new Cursos(
                DtoCursos.getNombre(), 
                DtoCursos.getInstituto(), 
                DtoCursos.getLugar(),
                DtoCursos.getHoras()
        );
        
        //INCORPORACION
        SerCursos.save(cursos);
        return new ResponseEntity(new Mensaje("Registro incorporado a: Cursos"), HttpStatus.OK);
    }
    
    //EDICION
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DCursos DtoCursos) {
        
        //VERIFICACIONES
        if(!SerCursos.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        if(SerCursos.existsByNombre(DtoCursos.getNombre()) && SerCursos.getByNombre(DtoCursos.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Registro ya existe en: Cursos"), HttpStatus.BAD_REQUEST);            
        }

        if(StringUtils.isBlank(DtoCursos.getNombre())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Nombre"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(DtoCursos.getInstituto())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Instituto"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(DtoCursos.getLugar())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Lugar"), HttpStatus.BAD_REQUEST);
        }
        
        if(DtoCursos.getHoras() <= 0) {
            return new ResponseEntity(new Mensaje("Dato requerido: Horas"), HttpStatus.BAD_REQUEST);
        }
        
        //ASIGNACIONES
        Cursos cursos = SerCursos.getOne(id).get();
        cursos.setNombre(DtoCursos.getNombre());
        cursos.setInstituto(DtoCursos.getInstituto());
        cursos.setLugar(DtoCursos.getLugar());
        cursos.setHoras(DtoCursos.getHoras());
        
        //ACTUALIZACION
        SerCursos.save(cursos);
        return new ResponseEntity(new Mensaje("Registro actualizado en: Cursos"), HttpStatus.OK);
    }
    
    //BORRADO
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        
        //VERIFICACIONES
        if(!SerCursos.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        //ELIMINACION
        SerCursos.delete(id);
        return new ResponseEntity(new Mensaje("Registro eliminado en: Cursos"), HttpStatus.OK);
    }
}
