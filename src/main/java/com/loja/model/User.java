package com.loja.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //definindo os métodos Getter's das propridades desssa classe
@Setter //definindo os métodos Setter's das propridades desssa classe
@AllArgsConstructor //Cria um construtor onde podemos passar todos os nossos atributos para dentro do nosso construtor
@NoArgsConstructor


@Table(name = "users") // A classe "User" irá corresponder à tabela "users" do banco
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String login;

    private String password;

    @Column(name = "data_cadastro")
    private Date dataCadastro = new Date(1427964000773L);

    /*
    public Long getId() {
        return this.id;
    }*/
}
