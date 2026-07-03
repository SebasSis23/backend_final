package com.example.demo.service;

import com.example.demo.entity.LoginEntity;
import com.example.demo.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public List<LoginEntity> obtenerTodos() {
        return loginRepository.findAll();
    }

    public Optional<LoginEntity> obtenerPorId(int id) {
        return loginRepository.findById(id);
    }

    public LoginEntity guardar(LoginEntity login) {
        return loginRepository.save(login);
    }

    public LoginEntity actualizar(int id, LoginEntity nuevo) {
        return loginRepository.findById(id).map(l -> {
            l.setUsuar(nuevo.getUsuar());
            l.setPsw(nuevo.getPsw());
            l.setRol(nuevo.getRol());
            l.setApiEstado(nuevo.getApiEstado());
            return loginRepository.save(l);
        }).orElse(null);
    }

    public boolean eliminar(int id) {
        if (loginRepository.existsById(id)) {
            loginRepository.deleteById(id);
            return true;
        }
        return false;
    }
}