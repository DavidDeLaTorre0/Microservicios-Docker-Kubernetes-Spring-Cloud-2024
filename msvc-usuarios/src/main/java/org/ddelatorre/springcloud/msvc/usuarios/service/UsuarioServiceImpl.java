package org.ddelatorre.springcloud.msvc.usuarios.service;

import org.ddelatorre.springcloud.msvc.usuarios.clients.CursoClientRest;
import org.ddelatorre.springcloud.msvc.usuarios.entities.Usuario;

import org.ddelatorre.springcloud.msvc.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoClientRest clientHttp;

    /*
    *   @Transactional, no lo ha explicado mucho
    *   Se utiliza en transaciones, en las llamadas que devuelven datos solo para leer les añade readdOnly
    */
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listar() { return (List<Usuario>) usuarioRepository.findAll(); }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> porId(Long id) { return usuarioRepository.findById(id); }

    @Override
    @Transactional
    public Usuario guardar(Usuario usuario) { return usuarioRepository.save(usuario); }

    @Override
    @Transactional
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
        clientHttp.eliminarCursoUsuario(id);

    }

    @Override
    @Transactional
    public List<Usuario> listarPorIds(Iterable<Long> ids) {
        return (List<Usuario>) usuarioRepository.findAllById(ids);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
