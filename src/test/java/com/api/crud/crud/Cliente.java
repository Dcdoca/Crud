package com.api.crud.crud;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Cliente {
    private Long id;
    private String nome;
    private String cpf;
    private String endereco; // Supondo que endereco seja uma string por simplicidade
    private String telefone;
    private String email;
    private String dataNascimento;

    // Construtores, Getters e Setters
}
//public class Cliente {
   // public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

   // private String nome;
    //private String cpf;
   // private Endereco endereco;
   // private String telefone;
   // private String email;
   // private String dataNascimento;

//}