package br.dev.fernandooliveira.portfolio.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "technology")
public class Technology  implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String technology;

    @ManyToOne
    @JoinColumn(name ="technology_id")
    private Portfolio portfolio_technology;

}
