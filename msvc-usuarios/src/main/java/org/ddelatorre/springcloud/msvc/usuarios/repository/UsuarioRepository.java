package org.ddelatorre.springcloud.msvc.usuarios.repository;

import org.ddelatorre.springcloud.msvc.usuarios.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    /* Otra manera
        @Query("select u from Usuario u where u.email=?1")
        Optional<Usuario> porEmail(String email);
    */


    /*
        boolean existsByEmail(String email);
    */




}
