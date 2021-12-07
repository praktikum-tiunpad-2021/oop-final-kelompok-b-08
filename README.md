# Sudoku

This repository is a final project (Java GUI) from Object-Oriented Programming Class, Teknik Informatika Universitas Padjadjaran. 

[Challenge Guidelines](challenge-guideline.md)

**Projek ini merupakan project membuat game Sudoku dengan mengimplementasikan konsep Objeck-Oriented Programming dan Java GUI. Sudoku merupakan teka-teki logika, yang tujuannya adalah mengisikan angka-angka dari 1 sampai 9 ke dalam jaring-jaring 9×9 yang terdiri dari 9 kotak 3×3 tanpa ada angka yang berulang di satu baris, kolom atau kotak.**

## Credits
| NPM           | Name                    |
| ------------- |-------------------------|
| 140810200008  | Anggie Forestry         |
| 140810200028  | Ananda Shaquille Farell |
| 140810200044  | Ade Dwi Fatwa Sembiring |

## Change log
- **[Sprint Planning](changelog/sprint-planning.md) - (17/11/2021)** 
   - Grid ubin 9x9 dan 3x3
   - Menu
   - Interface
   - level kesulitan
   - reset dan restart
   - cek input
   - fungsi highlight
   - cek akhir

- **[Sprint 1](changelog/sprint-1.md) - (17/11/2021 - 23/11/2021)** 
   - Grid ubin 9x9 dan 3x3
   - Menu level (easy, medium, high)

- **[Sprint 2](changelog/sprint-2.md) - (25/11/2021 - 30/02/2021)** 
   - Interface
   - level kesulitan
   - reset dan restart   
   
- **[Sprint 3](changelog/sprint-3.md) - (02/12/2021 - 07/12/2021)** 
   - cek input
   - fungsi highlight
   - cek akhir

## Running The App

1. Klik tombol "Run Java"
2. Tombol keyboard yang digunakan pada aplikasi :
   Tombol 1 - 9

## Classes Used

1. **Sudoku (program utama)** - 'Sudoku.java'
   - Program utama yang berisi method main
   - 6 Method
     - **newGame()** -> Untuk mereset game
     - **getFreeCellList()** -> Untuk membuat grid yang di masking
     - **search()** -> Untuk mencari angka di kotak kosong 
     - **isAvailable()** -> Untuk memeriksa inputan yang nilainya sama dalam satu kolom/satu baris/satu box 
     - **getRandomNum()** -> Untuk mendapatkan nilai Random
     - **setLevel()** -> Untuk mengatur level
2. **Tampilan** = 'Tampilan.java'
   - **initComponents()** 
   - **setTextLable()** -> Untuk pengaturan Label Text   
   - **setarray()** -> Untuk membuat array
   - **resetgame()** -> Untuk mereset game
3. **Listener** = 'Listener.java'
   - **newtextfield()** -> mengatur tampilan Field

## Notable Assumption and Design App Details
- Grid ubin dengan besar 9 x 9 yang terdiri dari 3 x 3 sub-grids dimana ubin adalah komponen drawing board dengan ukuran 650x650 
- Navbar berisi About dan Help    
   - Help berisi Instructions untuk menampilkan cara bermain pada sudoku ini    
   - About berisi Data Pembuat Game       
- Subgrid yang sudah berisi angka memiliki warna putih
- Subgrid yang belum berisi angka memiliki warna Putih
- Acak angka di dalam ubin (tidak ada angka yang sama pada 1 baris, 1 kolom, dan 1 sub-grids). 
- Masking terhadap ubin tertentu (angka disembunyikan dan dijadikan text field) 
- Ubin yang tidak dimasking bersifat read-only (angka didalamnya tidak bisa diubah) 
- Setiap angka yang didahului oleh angka yang lebih besar dianggap sebagai inversi, jumlah inversi dari puzzle harus genap.
- Buat listener untuk memproses input. Setiap inputan user akan dicek:
   - Koordinat i dan j dimana inputan tersebut berada
   - Apakah nilai yang dimasukan pada ubin sesuai dengan jawaban, jika sesuai maka ubah warna Field menjadi hijau, jika tidak sesuai maka Field menjadi warna merah
   - Highlight ubin yang sudah berisi angka menjadi hijau

![alt text](https://github.com/praktikum-tiunpad-2021/oop-final-kelompok-b-08/blob/master/app/src/main/resources/UML_Sudokuu.jpeg)