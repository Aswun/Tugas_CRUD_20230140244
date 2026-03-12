package com.deploy.praktikum2.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "KTP")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ktp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nomorKtp", nullable = false, unique = true)
    private String nomorKtp;

    @Column(name = "namaLengkap", nullable = false)
    private String namaLengkap;

    @Column(name = "alamat", nullable = false)
    private String alamat;

    @Column(name = "tanggalLahir", nullable = false)
    private LocalDate tanggalLahir;

    @Column(name = "jenisKelamin", nullable = false)
    private String jenisKelamin;
}