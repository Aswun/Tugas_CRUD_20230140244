package com.deploy.praktikum2.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class KtpAddRequest {
    @NotBlank(message = "Nomor KTP tidak boleh kosong")
    private String nomorKtp;

    @NotBlank(message = "Nama Lengkap tidak boleh kosong")
    private String namaLengkap;

    @NotBlank(message = "Alamat tidak boleh kosong")
    private String alamat;

    @NotNull(message = "Tanggal Lahir tidak boleh kosong")
    private LocalDate tanggalLahir;

    @NotBlank(message = "Jenis Kelamin tidak boleh kosong")
    private String jenisKelamin;
}