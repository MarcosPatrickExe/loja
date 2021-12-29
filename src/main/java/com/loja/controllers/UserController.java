package com.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import com.loja.model.User;
import com.loja.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    /* 
        PARA UTILIZAR O A INTERFACE "USER REPOSITORY" DENTRO DESSA CLASSE É NECESSÁRIO INJETÁ-LO NELA
        ATRAVÉS DE UMA ANOTAÇÃO CHAMADA "@Autowired", UMA VEZ QUE ATRAVÉS DA CRIAÇÃO DE UMA INSTÂNCIA COMO NO
        EXEMPLO ABAIXO, SERIA IMPOSSÍVEL JÁ QUE O "USER REPOSITORY" É UMA INTERFACE.

        private UserRepository useRepo = new UserRepository();
    */

     @Autowired 
     // Essa anotação torna disponível o uso da variável - que tem como tipo a interface "UserRepository" - dentro dessa classe
     private UserRepository userRepository;
     // Essa variável irá permitir a conexão com o banco de dados

     private List<User> usuarios = new ArrayList<>();// Lista provisória que funciona como um "database"


     @GetMapping("/")
     public String helloWorld(){
          return "Hello World Patricksonn";
     }

     @GetMapping("/{id}")
     public User cadastrarUsuarioID(@PathVariable Long id){ 
          // "PathVariable" é uma annotation que indica o valor da variável "id" que foi passada via URL

          Optional<User> objetoUsuario = this
                                            .usuarios
                                               .stream()
                                                   .filter( user -> user.getId() == id)
                                                       .findFirst();

          if( objetoUsuario.isPresent() )
               return objetoUsuario.get();// Retorna o usuário encontrado na lista

          return null;
     }

     @GetMapping("/new_user")
     public User novoUsuario (){
          User usuario = new User();
          usuario.setId(1L);
          usuario.setName("patrickson");
          usuario.setLogin("patrickson123");
          usuario.setPassword("12345678");
          this.usuarios.add(usuario);
        //  return "usuário cadastrado com sucesso!!!";
          System.out.println("usuário cadastrado com sucesso!!!");
          return usuario;
     }

     @GetMapping("/see_user")
     public List<User> verUsuario (){
          return this.usuarios;
     }

     @PostMapping("/send_user")
     public User receberDadosUsuario(@RequestBody User usu){
          // A Anotação "RequestBody" define que o método receberá os dados da requisição do tipo JSON
          
          this.usuarios.add(usu);
          System.out.println("usuário cadastrado com sucesso!!!");

          this.userRepository.save(usu);
          
          return usu;
     }


     @GetMapping("/list_length")
     public int tamanhoLista(){
          return this.usuarios.size();
     }
}
