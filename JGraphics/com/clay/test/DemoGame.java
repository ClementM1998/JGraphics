package com.clay.test;

import static com.clay.graphics.JGraphics.*;

public class GameDemo {
    public static void main(String[] args) {

        // Buka window
        CreateWindow("Mini Game - JGraphics", 800, 600);

        // Posisi player
        int x = 400, y = 300;
        int speed = 1;

        int cx = 200, cy = 300;
        int radius = 50;

        SetBackgroundWindow(WHITE);
        // Game loop
        while (true) {
            // Clear background
            ClearWindow();

            // Kawalan player
            if (IsKeyDown(KEY_UP)) y -= speed;
            if (IsKeyDown(KEY_DOWN)) y += speed;
            if (IsKeyDown(KEY_LEFT)) x -= speed;
            if (IsKeyDown(KEY_RIGHT)) x += speed;

            if (IsKeyDown(KEY_W)) cy -= speed;
            if (IsKeyDown(KEY_S)) cy += speed;
            if (IsKeyDown(KEY_A)) cx -= speed;
            if (IsKeyDown(KEY_D)) cx += speed;

            if (x < 0) x = 0;
            if (x > GetWindowWidth() - 50) x = GetWindowWidth() - 50;
            if (y < 0) y = 0;
            if (y > GetWindowHeight() - 50) y = GetWindowHeight() - 50;

            if (cx < radius) cx = radius;
            if (cx > GetWindowWidth() - radius) cx = GetWindowWidth() - radius;
            if (cy < radius) cy = radius;
            if (cy > GetWindowHeight() - radius) cy = GetWindowHeight() - radius;

            // Jika tekan ESC keluar
            if (IsKeyDown(KEY_ESCAPE)) CloseWindow();

            // Lukis player (kotak biru)
            SetFillColor(BLUE, 100);
            Rectangle(x, y, 50, 50);

            SetFillColor(GREEN, 100);
            Circle(cx, cy, radius);

            // Jika klik mouse kiri, lukis bulatan merah
            if (IsMouseDown(MOUSE_BUTTON_LEFT)) {
                SetFillColor(RED, 100);
                Circle(GetMouseX(), GetMouseY(), 30);
            }

            // Teks arahan
            SetColor(BLACK);
            SetFontSize(18);
            SetTextGravity(TEXT_GRAVITY_CENTER_BOTTOM);
            Text("Gunakan Arrow key untuk gerakkan bulatan\nGunakan W,S,A,D untuk gerakkan kotak\nESC untuk keluar, klik mouse kiri untuk bulatan");

            RefreshWindow();
        }
    }
}
