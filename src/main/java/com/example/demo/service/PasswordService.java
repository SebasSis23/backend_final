package com.example.demo.service;

import com.example.demo.entity.DocenteEntity;
import com.example.demo.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasswordService { 

    @Autowired
    private DocenteRepository docenteRepository;

    public List<DocenteEntity> obtenerTodos() {
        return docenteRepository.findAll();
    }

    public Optional<DocenteEntity> obtenerPorId(int id) {
        return docenteRepository.findById(id);
    }

    public DocenteEntity guardar(DocenteEntity docente) {
        return docenteRepository.save(docente);
    }

    public DocenteEntity actualizar(int id, DocenteEntity nuevo) {
        return docenteRepository.findById(id).map(p -> {
            p.setNomdoc(nuevo.getNomdoc());
            p.setItemdoc(nuevo.getItemdoc());
            p.setHonesty(nuevo.getHonesty());
            p.setApiEstado(nuevo.getApiEstado());
            return docenteRepository.save(p);
        }).orElse(null);
    }

    public boolean eliminar(int id) {
        if (docenteRepository.existsById(id)) {
            docenteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}