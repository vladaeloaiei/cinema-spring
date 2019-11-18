package com.ltw.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "BOOKINGS")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    @Column(name = "bookingRow")
    private Short row;
    @Column(name = "bookingColumn")
    private Short column;
    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;
}
