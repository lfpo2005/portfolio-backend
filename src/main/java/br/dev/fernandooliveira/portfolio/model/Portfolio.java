package br.dev.fernandooliveira.portfolio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "portfolio")
public class Portfolio implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String projectName;

    private String resume;

    @Lob
    private String description;

    private String imgUrl;

    @Lob
    private String url;

    private String github;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate data;

    @OneToMany(mappedBy = "portfolio_technology", orphanRemoval = true, cascade = CascadeType.ALL )
    private List<Technology> tech;

}
