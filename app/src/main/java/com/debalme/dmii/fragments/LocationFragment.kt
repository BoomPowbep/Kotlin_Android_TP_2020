package com.debalme.dmii.fragments

import android.Manifest
import android.content.Context.LOCATION_SERVICE
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.location_fragment.*

class LocationFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestPermission()
    }

    private fun requestPermission() {
        val activity = activity ?: return
        val context = context ?: return

        if (ContextCompat.checkSelfPermission(
                activity,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Permission denied
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    activity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            ) {
                // L'utilisateur avait déjà dit non donc il faut lui expliquer
                Toast.makeText(context,"Asking for permission for second time",Toast.LENGTH_SHORT).show()


                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    PERMISSION_CODE
                )
            }
            else {
                // Demander la permission (pour la première fois)
                Toast.makeText(context,"Asking for permission for first time",Toast.LENGTH_LONG).show()

                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    PERMISSION_CODE
                )
            }
        }
        else {
            // Permission granted
            Toast.makeText(context,"Permission granted",Toast.LENGTH_LONG).show()

//            val location = LocationManager()

            coordinates_text.text = ""
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_CODE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // Permission accordée
                    Toast.makeText(context,"Permission granted",Toast.LENGTH_LONG).show()

                } else {
                    // Permission refusée
                    // Message d'erreur
                    Toast.makeText(context,"Permission denied",Toast.LENGTH_LONG).show()

                }
            }
            else -> {
                Toast.makeText(context,"Wrong permission code",Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object {
        private const val PERMISSION_CODE = 0
    }
}
