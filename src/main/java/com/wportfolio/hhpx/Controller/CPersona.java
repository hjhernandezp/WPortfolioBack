package com.wportfolio.hhpx.Controller;

import com.wportfolio.hhpx.Dto.DPersona;
import com.wportfolio.hhpx.Entity.Persona;
import com.wportfolio.hhpx.Security.Controller.Mensaje;
import com.wportfolio.hhpx.Service.SPersona;
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
@RequestMapping("/persona")
@CrossOrigin(origins = {"http://localhost:4200", "https://webportfolio-nl1014.web.app"})
public class CPersona {
    @Autowired
    SPersona serPersona;
    
    //LISTA
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = serPersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //DETALLES
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        
        //VERIFICACIONES
        if(!serPersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        //OBTENCION
        Persona persona = serPersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    //CREACION (NUEVO)
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DPersona dtoPersona) {
        
        //VERIFICACIONES
         if(serPersona.existsByNombre(dtoPersona.getNombre())) {
            return new ResponseEntity(new Mensaje("Registro ya existe en: Persona"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoPersona.getNombre())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Nombre"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoPersona.getApellido())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Apellido"), HttpStatus.BAD_REQUEST);
        }
        
        /*
        if(StringUtils.isBlank(dtoPersona.getDescripcion())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Descripcion"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoPersona.getImagen())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Imagen"), HttpStatus.BAD_REQUEST);
        }
        */

        //ASIGNACIONES
        Persona persona = new Persona(
                dtoPersona.getNombre(), 
                dtoPersona.getApellido(),
                dtoPersona.getDescripcion(),
                dtoPersona.getImagen()
        );
        
        //INCORPORACION
        serPersona.save(persona);
        return new ResponseEntity(new Mensaje("Registro incorporado a: Persona"), HttpStatus.OK);
    }
    
    //EDICION
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DPersona dtoPersona) {
        
        //VERIFICACIONES
        if(!serPersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        if(serPersona.existsByNombre(dtoPersona.getNombre()) && serPersona.getByNombre(dtoPersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Registro ya existe en: Persona"), HttpStatus.BAD_REQUEST);            
        }

        if(StringUtils.isBlank(dtoPersona.getNombre())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Nombre"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoPersona.getApellido())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Apellido"), HttpStatus.BAD_REQUEST);
        }
        
        /*
        if(StringUtils.isBlank(dtoPersona.getDescripcion())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Descripcion"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoPersona.getImagen())) {
            return new ResponseEntity(new Mensaje("Dato requerido: Imagen"), HttpStatus.BAD_REQUEST);
        }
        */
        
        //ASIGNACIONES
        Persona persona = serPersona.getOne(id).get();
        persona.setNombre(dtoPersona.getNombre());
        persona.setApellido(dtoPersona.getApellido());
        persona.setDescripcion(dtoPersona.getDescripcion());
        persona.setImagen(dtoPersona.getImagen());
        
        //ACTUALIZACION
        serPersona.save(persona);
        return new ResponseEntity(new Mensaje("Registro actualizado en: Persona"), HttpStatus.OK);
    }
    
    //BORRADO
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        
        //VERIFICACIONES
        if(!serPersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID no encontrado"), HttpStatus.NOT_FOUND);
        }
        
        //ELIMINACION
        serPersona.delete(id);
        return new ResponseEntity(new Mensaje("Registro eliminado en: Persona"), HttpStatus.OK);
    }
}
