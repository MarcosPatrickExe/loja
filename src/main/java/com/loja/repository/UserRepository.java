package com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.loja.model.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{

    /* O Spring Data JPA oferece diferente maneiras de se 
       fazer consultas ao banco de dados, dentre elas está o uso 
       da annotation @query logo abaixo:
    */

    //@Query("SELECT u from User u where u.id > :id")

    @Query(
        value = "SELECT * from users where id > :id", // ou "SELECT * from users u where u.id > :id"
        nativeQuery = true
    )
    public abstract List<User> findAllMoreThan(@Param("id") Long id);

    /*
        A segunda forma de se fazer Queries ao banco é utilizando algumas 
        palavras-chave no nome do método, como abaixo:
    */

    public abstract List<User> findByIdGreaterThan(Long id);
/* Método que retornará todos os usuários com o ID maior do que o ID 
   que foi passado como parâmetro. Esse método serve de alternativa para
   não precisar uma Query annotation como no método acima */

    public abstract List<User> findByName(String name); 
// Encontrar nome passado no banco de dados, considerando letras maiúsculas e minúsculas

    public abstract List<User> findByNameIgnoreCase(String name);
// Encontrar nome passado no banco de dados, desconsiderando letras maiúsculas e minúsculas
}