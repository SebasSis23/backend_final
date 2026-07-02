package com.example.demo.controller;

import com.example.demo.entity.LoginEntity;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public List<LoginEntity> listar() {
        return loginService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoginEntity> buscarPorId(@PathVariable int id) {
        return loginService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public LoginEntity crear(@RequestBody LoginEntity login) {
        return loginService.guardar(login);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoginEntity> modificar(@PathVariable int id, @RequestBody LoginEntity login) {
        LoginEntity actualizado = loginService.actualizar(id, login);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable int id) {
        if (loginService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}