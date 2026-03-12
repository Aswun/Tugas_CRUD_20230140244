# Dokumentasi API Manajemen KTP - Praktikum CRUD

Repository ini berisi implementasi API untuk mengelola data Kartu Tanda Penduduk (KTP) menggunakan Spring Boot dan MySQL, beserta frontend client-side menggunakan HTML, CSS, JavaScript, dan Ajax JQuery.

## Konfigurasi Akses

Akses ke seluruh layanan API dilakukan melalui alamat dasar (Base URL) berikut:
`http://localhost:8080/ktp`

---

## Fitur dan Endpoint

### 1. Registrasi KTP Baru (Create)
Menambahkan data KTP baru ke sistem dengan validasi nomor KTP unik.
* **Metode:** `POST`
* **Alamat:** `/ktp`
* **Format Data:** `application/json`

**Contoh Request Body:**
```json
{
  "nomorKtp": "3404000011112222",
  "namaLengkap": "John Doe",
  "alamat": "Jl. Merdeka No. 1",
  "tanggalLahir": "1990-01-01",
  "jenisKelamin": "Laki-laki"
}