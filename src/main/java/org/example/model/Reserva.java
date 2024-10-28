package org.example.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    @NotNull(message = "El nombre no puede ser nulo")
    String nombre;
    @Getter
    @Setter
    @NotNull(message = "El tiempo y hora no puede ser nulo")
    LocalDateTime tiempoYHora;
    @Getter
    @Setter
    @NotNull(message = "El numero de personas no puede ser nulo")
    Integer numeroDePersonas;
    @Getter
    @Setter
    @NotNull(message = "El campo para saber si la reserva se encuentra activa, 'activa' no puede ser nulo")
    Boolean activa;
    @ManyToOne
    @JoinColumn(name = "mesa_id")
    private Mesa mesa;

}

