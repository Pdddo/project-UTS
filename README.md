<h1 align="center"> 🌱 Terrabotanica 🌱 </h1> <p align="center"> <b>A Virtual World of Living Plants </b> </p>

### Konsep Umum

**Terrabotanica** sebuah simulasi taman virtual di mana pemain dapat menanam, merawat, dan mengembangkan tanaman dalam dunia digital yang hidup dan dinamis. Nama Terrabotanica berasal dari gabungan kata “Terra”  (bumi) dan “Botanica” (ilmu tumbuhan), menciptakan suasana dunia botani yang utuh dan imersif — seolah-olah taman ini berada di sebuah planet yang khusus diciptakan untuk kehidupan tanaman.

## 🧩 Fitur Utama
### 🌿 Tanam & Rawat 
Pemain dapat memilih jenis tanaman, menanamnya, dan merawatnya dengan air, cahaya, atau pupuk digital. 
### 🕒 Waktu & Perkembangan
Tanaman tumbuh secara bertahap tergantung perawatan dan waktu — bisa disinkronkan dengan waktu nyata. 
### 🧪 Karakteristik Tanaman
Tiap tanaman memiliki atribut: 
o Nama 
o Level pertumbuhan (Bibit – Tunas – Mekar) 
o Status (Sehat, Layu, Overwatered) 
o Kebutuhan khusus (air, cahaya, tanah) 
### 📖 Encyclopedia Botani
Fitur edukatif berisi info singkat tentang tiap tanaman. 

## 📦 Struktur Proyek

### 🔹 Kelas Utama

- **Main.java**  
  Menjalankan program, menerima input nama player dan taman, serta menampilkan menu utama.

- **Player.java**  
  Mewakili pemain dalam permainan. Player memiliki `Garden`, serta dapat mengakses berbagai fitur seperti menambahkan tanaman, melakukan aksi, dan membuka ensiklopedia.

- **Garden.java**  
  Mewakili taman milik pemain, menyimpan daftar tanaman (`Plant`), dan menyediakan method untuk:
  - Menambahkan tanaman
  - Menampilkan semua tanaman
  - Memberi aksi (grow, water, weather)
  - Update pertumbuhan tanaman secara serentak

---

### 🌱 Kelas Tanaman

- **Plant.java** *(abstract)*  
  Kelas dasar untuk semua tanaman. Atribut umum:
  - `plantName`, `scientificName`, `age`, `status`, `hydration`, `nutrition`, `sunlight`  
  Method penting:
  - `grow()`, `water()`, `weather()`, `updateStatus()`, `updateAge()`, `checkHealth()`

- **DecorativePlants.java**  
  Turunan dari `Plant`. Untuk tanaman hias.

- **MedicinalPlants.java**  
  Turunan dari `Plant`. Untuk tanaman obat.

- **VegetablePlants.java**  
  Turunan dari `Plant`. Untuk tanaman sayur.

---

### 📚 Ensiklopedia Tanaman

- **BotanyEncyclopedia.java**  
  Menyediakan fitur menambah dan melihat koleksi tanaman hias (`TanamanHias`).

- **TanamanHias.java**  
  Kelas representasi tanaman hias dalam ensiklopedia dengan atribut:
  - `plantName`, `scientificName`, `category`, `isIndoor`, `lightPreference`

---

### 💡 Interface

- **ICategorizable**  
  ```java
  String getCategoryName();
  ```

- **IDescribable**  
  ```java
  void describe();
  ```

- **Indoorable**  
  ```java
  boolean isSuitableForIndoor();
  ```

> Ketiga interface ini diimplementasikan oleh `Player` dan `TanamanHias` untuk mendukung modularitas dan fleksibilitas.

---

## 🧠 Konsep OOP yang Diimplementasikan

| Konsep        | Implementasi                                                                 |
|---------------|------------------------------------------------------------------------------|
| Inheritance   | `DecorativePlants`, `MedicinalPlants`, dan `VegetablePlants` mewarisi `Plant`. |
| Abstraction   | `Plant` adalah kelas abstrak.                                                |
| Encapsulation | Atribut kelas bersifat `private/protected` dan diakses lewat getter/setter. |
| Polymorphism  | Method seperti `grow()`, `checkHealth()` dapat di-override oleh subclass.   |
| Interface     | `Player` mengimplementasikan `ICategorizable`, `IDescribable`, dan `Indoorable`. |

---

## ▶️ Cara Menjalankan Program

### 1. Versi CLI (Terrabotanica)

```bash
javac *.java
java Main
```

### 2. Versi GUI JavaFX (Terrabotanica GUI)

```bash
javac --module-path ${workspaceFolder}/lib --add-modules javafx.controls,javafx.fxml -d bin src/**/*.java
java --module-path ${workspaceFolder}/lib --add-modules javafx.controls,javafx.fxml -cp bin view.MainGUI
```

### 3. Konfigurasi VS Code (`launch.json`)

Jika kamu menggunakan **VS Code**, kamu bisa menambahkan konfigurasi berikut di file `.vscode/launch.json`:

```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "type": "java",
      "name": "Launch Terrabotanica GUI 🌿",
      "request": "launch",
      "mainClass": "view.MainGUI",
      "vmArgs": "--module-path ${workspaceFolder}/lib --add-modules javafx.controls,javafx.fxml",
      "projectName": "myapp_69db43e0"
    }
  ]
}
```

> **Catatan:**
> - Versi GUI memerlukan **JavaFX SDK versi 21**.  
> - Letakkan library JavaFX di folder: `${workspaceFolder}/lib`
> - Versi CLI hanya memerlukan JDK standar (versi 8+).


---

## 📌 Catatan

- Program ini interaktif via console (terminal).
- Menekankan manajemen taman berdasarkan status hidrasi, nutrisi, dan paparan cahaya matahari.
- Cocok digunakan sebagai studi kasus pembelajaran OOP Java tingkat menengah.

## Author
<a href="https://github.com/Pdddo/project-UTS/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Pdddo/project-UTS" />
</a>
