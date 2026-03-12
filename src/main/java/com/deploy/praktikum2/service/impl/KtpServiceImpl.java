package com.deploy.praktikum2.service.impl;

import com.deploy.praktikum2.mapper.KtpMapper;
import com.deploy.praktikum2.model.dto.KtpAddRequest;
import com.deploy.praktikum2.model.dto.KtpDto;
import com.deploy.praktikum2.model.entity.Ktp;
import com.deploy.praktikum2.repository.KtpRepository;
import com.deploy.praktikum2.service.KtpService;
import com.deploy.praktikum2.util.validationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    @Autowired
    private validationUtil validationUtil;

    @Override
    public KtpDto AddKtp(KtpAddRequest request) {
        validationUtil.validate(request);

        if (ktpRepository.existsByNomorKtp(request.getNomorKtp())) {
            throw new RuntimeException("Nomor KTP sudah terdaftar");
        }

        Ktp ktp = Ktp.builder()
                .nomorKtp(request.getNomorKtp())
                .namaLengkap(request.getNamaLengkap())
                .alamat(request.getAlamat())
                .tanggalLahir(request.getTanggalLahir())
                .jenisKelamin(request.getJenisKelamin())
                .build();

        ktpRepository.save(ktp);
        return KtpMapper.MAPPER.toKtpDtoData(ktp);
    }

    @Override
    public List<KtpDto> getAllKtp() {
        return ktpRepository.findAll().stream()
                .map(KtpMapper.MAPPER::toKtpDtoData)
                .collect(Collectors.toList());
    }

    @Override
    public KtpDto getKtpById(Integer id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KTP tidak ditemukan"));
        return KtpMapper.MAPPER.toKtpDtoData(ktp);
    }

    @Override
    public KtpDto UpdateKtp(Integer id, KtpAddRequest request) {
        validationUtil.validate(request);

        Ktp existingKtp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KTP tidak ditemukan"));

        if (!existingKtp.getNomorKtp().equals(request.getNomorKtp()) && ktpRepository.existsByNomorKtp(request.getNomorKtp())) {
            throw new RuntimeException("Nomor KTP sudah terdaftar");
        }

        existingKtp.setNomorKtp(request.getNomorKtp());
        existingKtp.setNamaLengkap(request.getNamaLengkap());
        existingKtp.setAlamat(request.getAlamat());
        existingKtp.setTanggalLahir(request.getTanggalLahir());
        existingKtp.setJenisKelamin(request.getJenisKelamin());

        ktpRepository.save(existingKtp);
        return KtpMapper.MAPPER.toKtpDtoData(existingKtp);
    }

    @Override
    public void DeleteKtp(Integer id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KTP tidak ditemukan"));
        ktpRepository.delete(ktp);
    }
}