package com.wportfolio.hhpx.Controller;

import com.wportfolio.hhpx.Dto.DProyectos;
import com.wportfolio.hhpx.Entity.Proyectos;
import com.wportfolio.hhpx.Security.Controller.Mensaje;
import com.wportfolio.hhpx.Service.SProyectos;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = {"http://localhost:4200", "https://webportfolio-nl1014.web.app"})
public class CProyectos {
    @Autowired
    SProyectos SerProyectos;
    
    //LISTA
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = SerProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //DETALLES
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        
        //VERIFICACIONES
        if(!SerProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        //OBTENCION
        Proyectos proyectos = SerProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    //CREACION (NUEVO)
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DProyectos DtoProyectos) {
        
        //VERIFICACIONES
         if(SerProyectos.existsByNombre(DtoProyectos.getNombre())) {
            return new ResponseEntity(new Mensaje("Registro ya existe en: Proyectos"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(DtoProyectos.getNombre())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Nombre"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(DtoProyectos.getDescripcion())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Descripcion"), HttpStatus.BAD_REQUEST);
        }
        
        //ASIGNACIONES
        Proyectos proyectos = new Proyectos(
                DtoProyectos.getNombre(),
                DtoProyectos.getDescripcion(),
                DtoProyectos.getEnlace(),
                DtoProyectos.getImagen()
        );
        
        //INCORPORACION
        SerProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Registro incorporado a: Proyectos"), HttpStatus.OK);
    }
    
    //EDICION
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DProyectos DtoProyectos) {
        
        //VERIFICACIONES
        if(!SerProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        if(SerProyectos.existsByNombre(DtoProyectos.getNombre()) && SerProyectos.getByNombre(DtoProyectos.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Registro ya existe en: Proyectos"), HttpStatus.BAD_REQUEST);            
        }

        if(StringUtils.isBlank(DtoProyectos.getNombre())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Nombre"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(DtoProyectos.getDescripcion())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Descripción"), HttpStatus.BAD_REQUEST);
        }
        
        //ASIGNACIONES
        Proyectos proyectos = SerProyectos.getOne(id).get();
        proyectos.setNombre(DtoProyectos.getNombre());
        proyectos.setDescripcion(DtoProyectos.getDescripcion());
        proyectos.setEnlace(DtoProyectos.getEnlace());
        proyectos.setImagen(DtoProyectos.getImagen());
        
        //ACTUALIZACION
        SerProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Registro actualizado en: Proyectos"), HttpStatus.OK);
    }
    
    //BORRADO
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        
        //VERIFICACIONES
        if(!SerProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        //ELIMINACION
        SerProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Registro eliminado en: Proyectos"), HttpStatus.OK);
    }
}
