package cl.eduru.usuariosSpring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "telefono")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Telefono {
    @Id
    @Column(name = "number")
    private Integer number;
    @Column(name = "citycode")
    private Integer citycode;
    @Column(name = "contrycode")
    private Integer contrycode;
}
