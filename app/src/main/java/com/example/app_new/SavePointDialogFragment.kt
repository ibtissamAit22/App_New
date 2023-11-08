package com.example.app_new
import android.app.Activity

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.app_new.databinding.FragmentSavePointBinding


class SavePointDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = FragmentSavePointBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireContext()) // Declare and initialize builder
        val view = binding.root

        // Access views using the generated binding
        val latitude = binding.latitudeEditText.text.toString()
        val longitude = binding.longitudeEditText.text.toString()

        builder.setView(view)
            .setPositiveButton("Save") { _, _ ->
                if (latitude.isNotEmpty() && longitude.isNotEmpty()) {
                    // Handle saving the point here
                    // Example: DatabaseHandler.insertLocation(latitude.toDouble(), longitude.toDouble())
                }
            }
            .setNegativeButton("Cancel") { _, _ -> }

        return builder.create()
    }
}
