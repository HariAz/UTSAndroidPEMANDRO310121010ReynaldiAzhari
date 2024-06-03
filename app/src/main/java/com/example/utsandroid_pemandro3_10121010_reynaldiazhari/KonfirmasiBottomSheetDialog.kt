package com.example.utsandroid_pemandro3_10121010_reynaldiazhari

//Tanggal Pengerjaan : 03/06/2024
//NIM : 10121010
//Nama : Reynaldi Azhari
//Kelas : Pemrograman Android 3


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class KonfirmasiBottomSheetDialog : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_confirm, container, false)

        // Tambahkan listener untuk tombol "Ok"
        view.findViewById<Button>(R.id.btn_ok)?.setOnClickListener {
            dismiss()

            val intent = Intent(requireContext(), MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

        return view
    }
}