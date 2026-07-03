package com.example.demo.controller;

import com.example.demo.entity.ContactoEntity;
import com.example.demo.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacto")
@CrossOrigin(origins = "*")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @GetMapping
    public List<ContactoEntity> listar() {
        return contactoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactoEntity> buscarPorId(@PathVariable int id) {
        return contactoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ContactoEntity crear(@RequestBody ContactoEntity contacto) {
        return contactoService.guardar(contacto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactoEntity> modificar(@PathVariable int id, @RequestBody ContactoEntity contacto) {
        ContactoEntity actualizado = contactoService.actualizar(id, contacto);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable int id) {
        if (contactoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}