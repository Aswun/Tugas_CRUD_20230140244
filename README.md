# Dokumentasi API dan Aplikasi Manajemen KTP

Repository ini (`Tugas_CRUD_NIM`) berisi implementasi aplikasi Client-Server untuk mengelola data Kartu Tanda Penduduk (KTP). Backend dibangun menggunakan **Spring Boot** dan **MySQL**, sedangkan Frontend dibangun menggunakan **HTML, CSS, Bootstrap, dan jQuery Ajax**.

---

## Teknologi yang Digunakan
- **Backend:** Java 17+, Spring Boot (Web, Data JPA, Validation), MapStruct, Lombok
- **Frontend:** HTML5, Bootstrap 5, jQuery (AJAX)
- **Database:** MySQL

---

## Struktur Database (MySQL)
Sistem menggunakan database bernama `spring` dengan tabel `KTP`.

| Kolom | Tipe Data | Keterangan |
| :--- | :--- | :--- |
| `id` | INT | Primary Key, Auto Increment |
| `nomorKtp` | VARCHAR | Unique, Not Null |
| `namaLengkap` | VARCHAR | Not Null |
| `alamat` | VARCHAR | Not Null |
| `tanggalLahir` | DATE | Not Null |
| `jenisKelamin` | VARCHAR | Not Null |

---

## Konfigurasi Akses API

Akses ke seluruh layanan API dilakukan melalui alamat dasar (Base URL) berikut:
**`http://localhost:8080/ktp`**

---

## Dokumentasi Endpoint API

### 1. Menambah Data KTP Baru (Create)
- **Endpoint:** `POST /ktp`
- **Content-Type:** `application/json`

**Request Body:**
```json
{
  "nomorKtp": "3404000011112222",
  "namaLengkap": "John Doe",
  "alamat": "Jl. Merdeka No. 1, Yogyakarta",
  "tanggalLahir": "1990-01-01",
  "jenisKelamin": "Laki-laki"
}

```

**Response Sukses (201 Created):**

```json
{
    "status": "success",
    "data": {
        "id": 1,
        "nomorKtp": "3404000011112222",
        "namaLengkap": "John Doe",
        "alamat": "Jl. Merdeka No. 1, Yogyakarta",
        "tanggalLahir": "1990-01-01",
        "jenisKelamin": "Laki-laki"
    }
}

```

**Response Error (400 Bad Request - KTP Sudah Ada):**

```json
{
    "status": "error",
    "message": "Nomor KTP sudah terdaftar"
}

```

### 2. Mengambil Seluruh Data KTP (Read All)

* **Endpoint:** `GET /ktp`

**Response Sukses (200 OK):**

```json
{
    "status": "success",
    "data": [
        {
            "id": 1,
            "nomorKtp": "3404000011112222",
            "namaLengkap": "John Doe",
            "alamat": "Jl. Merdeka No. 1, Yogyakarta",
            "tanggalLahir": "1990-01-01",
            "jenisKelamin": "Laki-laki"
        }
    ]
}

```

### 3. Mengambil Data KTP Berdasarkan ID (Read By ID)

* **Endpoint:** `GET /ktp/{id}`

**Response Sukses (200 OK):**

```json
{
    "status": "success",
    "data": {
        "id": 1,
        "nomorKtp": "3404000011112222",
        "namaLengkap": "John Doe",
        "alamat": "Jl. Merdeka No. 1, Yogyakarta",
        "tanggalLahir": "1990-01-01",
        "jenisKelamin": "Laki-laki"
    }
}

```

### 4. Memperbarui Data KTP (Update)

* **Endpoint:** `PUT /ktp/{id}`
* **Content-Type:** `application/json`

**Request Body:**

```json
{
  "nomorKtp": "3404000011112222",
  "namaLengkap": "John Doe Update",
  "alamat": "Jl. Kemerdekaan No. 2",
  "tanggalLahir": "1990-01-01",
  "jenisKelamin": "Laki-laki"
}

```

**Response Sukses (200 OK):**

```json
{
    "status": "success",
    "data": {
        "id": 1,
        "nomorKtp": "3404000011112222",
        "namaLengkap": "John Doe Update",
        "alamat": "Jl. Kemerdekaan No. 2",
        "tanggalLahir": "1990-01-01",
        "jenisKelamin": "Laki-laki"
    }
}

```

### 5. Menghapus Data KTP (Delete)

* **Endpoint:** `DELETE /ktp/{id}`

**Response Sukses (200 OK):**

```json
{
    "status": "success",
    "message": "Data KTP berhasil dihapus"
}

```

---

## Dokumentasi Client-Side (Frontend)

Frontend diimplementasikan pada file `index.html` dan beroperasi sepenuhnya menggunakan Ajax JQuery tanpa perlu memuat ulang halaman (Single Page Application).

**Fitur Frontend:**

1. Form input data KTP baru dengan input khusus (`<input type="date">` untuk Tanggal Lahir, `<select>` dropdown untuk Jenis Kelamin).
2. Tabel dinamis yang menampilkan data KTP dari API.
3. Notifikasi Alert interaktif berbasis Bootstrap untuk memberi *feedback* kepada pengguna (Sukses/Gagal).
4. Tombol **Edit** yang akan memuat data ke dalam form untuk diperbarui menggunakan `PUT`.
5. Tombol **Hapus** dengan dialog konfirmasi bawaan browser sebelum mengeksekusi API `DELETE`.

---

## Lampiran Tampilan Sistem

### 1. Antarmuka Web (Frontend - Form & Tabel)

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/82f44114-6a0d-482c-9aec-c6d59e4ddcb3" />

### 2. Antarmuka Web (Frontend - Notifikasi Ajax Sukses/Error)

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/3471204a-ae33-40fc-82c9-6c5d329b5ad3" />

### 3. Struktur Database (MySQL)

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/3d7e48e4-1339-4d35-8451-d3df086a1a8b" />

```

```
