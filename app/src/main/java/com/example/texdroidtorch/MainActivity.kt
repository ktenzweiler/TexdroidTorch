package com.example.texdroidtorch

import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var powerBtn: Button
    lateinit var cameraManager: CameraManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cameraManager = getSystemService(CAMERA_SERVICE) as CameraManager

        val cameraId = cameraManager.cameraIdList[0]

        powerBtn = findViewById(R.id.power_btn)

        var isPowerOn = false

        powerBtn.setOnClickListener {
            if (isPowerOn) {
                toggleLight(cameraId, false)
                isPowerOn = false
            } else {
                toggleLight(cameraId, true)
                isPowerOn = true
            }
        }

    }

    private fun toggleLight(cameraId: String, turnOn: Boolean) {
        cameraManager.setTorchMode(cameraId, turnOn)
    }

}