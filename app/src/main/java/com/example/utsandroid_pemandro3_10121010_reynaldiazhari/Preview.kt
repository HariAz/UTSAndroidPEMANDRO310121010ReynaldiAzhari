package com.example.utsandroid_pemandro3_10121010_reynaldiazhari

//Tanggal Pengerjaan : 03/06/2024
//NIM : 10121010
//Nama : Reynaldi Azhari
//Kelas : Pemrograman Android 3


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Preview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preview)
        // Ambil data dari intent
        val jenisTes = intent.getStringExtra("jenisTes")
        val tanggalTerkonfirmasi = intent.getStringExtra("tanggalTerkonfirmasi")
        val nik = intent.getStringExtra("nik")
        val nama = intent.getStringExtra("nama")
        val tanggalLahir = intent.getStringExtra("tanggalLahir")
        val jenisKelamin = intent.getStringExtra("jenisKelamin")
        val hubungan = intent.getStringExtra("hubungan")

        // Set data ke TextView
        findViewById<TextView>(R.id.tvJenisTes).text = jenisTes
        findViewById<TextView>(R.id.tvTanggalTerkonfirmasi).text = tanggalTerkonfirmasi
        findViewById<TextView>(R.id.tvNik).text = nik
        findViewById<TextView>(R.id.tvNama).text = nama
        findViewById<TextView>(R.id.tvTanggalLahir).text = tanggalLahir
        findViewById<TextView>(R.id.tvJenisKelamin).text = jenisKelamin
        findViewById<TextView>(R.id.tvHubungan).text = hubungan

        // Tombol untuk konfirmasi
        findViewById<Button>(R.id.btnKonfirmasi).setOnClickListener {
            val bottomSheetDialog = KonfirmasiBottomSheetDialog()
            bottomSheetDialog.show(supportFragmentManager, "KonfirmasiBottomSheetDialog")
        }

        // Tombol untuk kembali
        findViewById<Button>(R.id.btnKembali).setOnClickListener {
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}