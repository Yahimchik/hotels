package org.example.hotelstask.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "arrival_times")
public class ArrivalTime {
        @Id
        private UUID id;

        @Column(nullable = false)
        private String checkIn;

        @Column(nullable = false)
        private String checkOut;

}