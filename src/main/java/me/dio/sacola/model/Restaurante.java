package me.dio.sacola.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@AllArgsConstructor /* construtor com todos os atributos */
@Builder /* ajudar criar objeto */
@Data /* todos os get e set */
@Entity /* converter para uma tabela de banco de dados */
@JsonIgnoreProperties /* para evitar erros */
@NoArgsConstructor /* construtor sem nenhum argumento */
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @OneToMany(cascade = CascadeType.ALL) /* restaurante tem varios produtos , cascate all se excluir um restaurante , ecxlui todos os produtos*/
    private List<Produto> cardapio;
    @Embedded
    private Endereco endereco;
}

