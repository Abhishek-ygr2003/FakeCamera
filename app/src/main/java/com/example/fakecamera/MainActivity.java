package com.example.fakecamera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnTakePicture;
    private ImageButton btnSwitchCamera;
    private ImageButton btnGallery;
    private boolean permissionGranted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        btnTakePicture = findViewById(R.id.btn_take_picture);
        btnSwitchCamera = findViewById(R.id.btn_switch_camera);
        btnGallery = findViewById(R.id.btn_gallery);

        // Set up click listeners
        btnTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!permissionGranted) {
                    requestCameraPermission();
                } else {
                    takePicture();
                }
            }
        });

        btnSwitchCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Switching camera (front/back)", Toast.LENGTH_SHORT).show();
            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Opening gallery...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void requestCameraPermission() {
        // Simulate permission request with Toast message
        Toast.makeText(this, "Camera permission requested!", Toast.LENGTH_LONG).show();

        // After 2 seconds, show "permission granted" toast
        btnTakePicture.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Camera permission granted!", Toast.LENGTH_SHORT).show();
                permissionGranted = true;
            }
        }, 2000);
    }

    private void takePicture() {
        // Simulate taking a picture
        Toast.makeText(this, "Photo captured!", Toast.LENGTH_SHORT).show();
    }
}