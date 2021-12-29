package com.loja.model;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //definindo os métodos Getter's das propridades desssa classe
@Setter //definindo os métodos Setter's das propridades desssa classe
@AllArgsConstructor //Cria um construtor onde podemos passar todos os nossos atributos para dentro do nosso construtor
@NoArgsConstructor

/*
     We can explicitly define access type for our entity beans. There are two types of access types:

    Field: Hibernate will look for annotations on variables in this case, like we have defined for Address 
    class above as @Access(value=AccessType.FIELD).
    
    Property: Hibernate will look for annotations on getter-setter methods in this case, syntax for this 
    is @Access(value=AccessType.PROPERTY)
*/
@Table(name = "users") // A classe "User" irá corresponder à tabela "users" do banco
@Entity
@Access(value=AccessType.FIELD)
//@org.springframework.data.annotation.AccessType(name= "field")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
  //  @Column(name="id", unique=true, nullable=false)

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
