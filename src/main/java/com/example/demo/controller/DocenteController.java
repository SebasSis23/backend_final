package com.example.demo.controller;

import com.example.demo.entity.DocenteEntity;
import com.example.demo.service.DocenteService; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docente")
@CrossOrigin(origins = "*")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping
    public List<DocenteEntity> listar() {
        return docenteService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocenteEntity> buscarPorId(@PathVariable int id) {
        return docenteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DocenteEntity crear(@RequestBody DocenteEntity docente) {
        return docenteService.guardar(docente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocenteEntity> modificar(@PathVariable int id, @RequestBody DocenteEntity docente) {
        DocenteEntity actualizado = docenteService.actualizar(id, docente);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable int id) {
        if (docenteService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}