package com.example.demo.service;

import com.example.demo.entity.ContactoEntity;
import com.example.demo.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    public List<ContactoEntity> obtenerTodos() {
        return contactoRepository.findAll();
    }

    public Optional<ContactoEntity> obtenerPorId(int id) {
        return contactoRepository.findById(id);
    }

    public ContactoEntity guardar(ContactoEntity contacto) {
        return contactoRepository.save(contacto);
    }

    public ContactoEntity actualizar(int id, ContactoEntity nuevo) {
        return contactoRepository.findById(id).map(c -> {
            c.setNombre(nuevo.getNombre());
            c.setTelefono(nuevo.getTelefono());
            c.setEmail(nuevo.getEmail());
            c.setAsunto(nuevo.getAsunto());
            c.setMensaje(nuevo.getMensaje());
            c.setApiEstado(nuevo.getApiEstado());
            return contactoRepository.save(c);
        }).orElse(null);
    }

    public boolean eliminar(int id) {
        if (contactoRepository.existsById(id)) {
            contactoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}