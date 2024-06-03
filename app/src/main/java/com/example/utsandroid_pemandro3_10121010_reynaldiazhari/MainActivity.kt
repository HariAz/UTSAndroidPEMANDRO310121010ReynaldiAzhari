package com.example.utsandroid_pemandro3_10121010_reynaldiazhari

//Tanggal Pengerjaan : 03/06/2024
//NIM : 10121010
//Nama : Reynaldi Azhari
//Kelas : Pemrograman Android 3


import android.app.DatePickerDialog;
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Set default values for TextViews

        lateinit var tgl_terkonfirmasi: TextView
        lateinit var tgl_lahir: TextView

        tgl_terkonfirmasi = findViewById(R.id.tgl_terkonfirmasi)
        tgl_lahir = findViewById(R.id.tgl_lahir)

        tgl_lahir.setOnClickListener{ showDatePickerDialog(tgl_lahir) }
        tgl_terkonfirmasi.setOnClickListener{ showDatePickerDialog(tgl_terkonfirmasi) }


        // Mengakses elemen UI
        val rapid = findViewById<RadioButton>(R.id.rapid)
        val pcr = findViewById<RadioButton>(R.id.pcr)
        val tglTerkonfirmasi = findViewById<EditText>(R.id.tgl_terkonfirmasi)
        val nik = findViewById<EditText>(R.id.nik)
        val nama = findViewById<EditText>(R.id.nama)
        val tglLahir = findViewById<EditText>(R.id.tgl_lahir)
        val cowo = findViewById<RadioButton>(R.id.cowo)
        val cewe = findViewById<RadioButton>(R.id.cewe)
        val ortu = findViewById<RadioButton>(R.id.ortu)
        val nikah = findViewById<RadioButton>(R.id.nikah)
        val anak = findViewById<RadioButton>(R.id.anak)
        val lainnya = findViewById<RadioButton>(R.id.lainnya)

        rapid.isChecked = false
        pcr.isChecked = false
        cowo.isChecked = false
        cewe.isChecked = false
        ortu.isChecked = false
        nikah.isChecked = false
        anak.isChecked = false
        lainnya.isChecked = false

        tglTerkonfirmasi.setText("")
        nik.setText("")
        nama.setText("")
        tglLahir.setText("")

        findViewById<Button>(R.id.simpan).setOnClickListener {
            val intent = Intent(this, Preview::class.java)
            intent.putExtra("jenisTes", when {
                rapid.isChecked -> getString(R.string.rapid_antigen)
                pcr.isChecked -> getString(R.string.pcr_test)
                else -> ""
            })
            intent.putExtra("tanggalTerkonfirmasi", tglTerkonfirmasi.text.toString())
            intent.putExtra("nik", nik.text.toString())
            intent.putExtra("nama", nama.text.toString())
            intent.putExtra("tanggalLahir", tglLahir.text.toString())
            intent.putExtra("jenisKelamin", when {
                cowo.isChecked -> getString(R.string.male)
                cewe.isChecked -> getString(R.string.female)
                else -> ""
            })
            intent.putExtra("hubungan", when {
                ortu.isChecked -> getString(R.string.relation_parent)
                nikah.isChecked -> getString(R.string.relation_spouse)
                anak.isChecked -> getString(R.string.relation_child)
                lainnya.isChecked -> getString(R.string.relation_other)
                else -> ""
            })
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showDatePickerDialog(textView: TextView) {
        // Mengambil tanggal sekarang sebagai nilai default
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        // Membuat date picker dialog
        val datePickerDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { _: DatePicker, selectedYear: Int, monthOfYear: Int, dayOfMonth: Int ->
                // Setelah pengguna memilih tanggal, atur nilai TextView sesuai
                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$selectedYear"
                textView.text = selectedDate
            }, year, month, dayOfMonth)

        // Menampilkan dialog
        datePickerDialog.show()
    }
}