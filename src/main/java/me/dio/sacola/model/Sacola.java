package me.dio.sacola.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.sacola.enumeration.FormaPagamento;

import javax.persistence.*;
import java.util.List;

/*Lonbock */
@AllArgsConstructor /* construtor com todos os atributos */
@Builder /* ajudar criar objeto */
@Data /* todos os get e set */
@Entity /* uma entidade para banco de dados */
@JsonIgnoreProperties /* para evitar erros */
@NoArgsConstructor /* construtor sem nenhum argumento */
public class Sacola {
    @Id                   /*chave primária */
    @GeneratedValue(strategy = GenerationType.AUTO) /*  forma que vai gerar id, e a estratégia de auto incremento*/
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) /* um cliente pode ter várias sacolas, fetch é a aprensentação */
    @JsonIgnore /* */
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL)  /* */
    private List<Item> itens;
    private Double valorTotal;

    @Enumerated
    private FormaPagamento FormaPagamento;
    private boolean fechada;

}
