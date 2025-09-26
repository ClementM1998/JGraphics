package com.clay.test;

import static com.clay.graphics.JGraphics.*;

public class DemoShapes {
    public static void main(String[] args) {
        CreateWindow("Demo Shapes", 800, 600);
        SetFrameRate(60);

        while (!IsKB()) {
            // Clear screen
            ClearWindow();

            // Garisan
            SetColor(WHITE);
            Line(50, 50, 200, 50);

            // Titik
            SetColor(YELLOW);
            Point(60, 80);

            // Rectangle (berisi)
            SetColor(RED);
            SetFillColor(MAGENTA);
            Rectangle(100, 100, 200, 100);

            // Square (outline sahaja)
            SetColor(GREEN);
            SetFilled(false);
            Square(350, 100, 100);

            // Circle (berisi)
            SetColor(BLACK);
            SetFillColor(CYAN);
            Circle(200, 300, 50);

            // Ellipse (outline sahaja)
            SetColor(ORANGE);
            SetFilled(false);
            Ellipse(400, 300, 80, 40);

            // Triangle (berisi)
            SetColor(WHITE);
            SetFillColor(BLUE);
            Triangle(550, 200, 650, 300, 450, 300);

            // Polygon (bintang)
            int[] px = { 700, 720, 760, 730, 740, 700, 660, 670, 640, 680};
            int[] py = { 100, 140, 140, 160, 200, 175, 200, 160, 140, 140};
            SetColor(WHITE);
            SetFillColor(PURPLE);
            Polygon(px, py);

            // Arc
            SetColor(LIME);
            SetFilled(false);
            Arc(600, 400, 80, 40, 0, 270);

            RefreshWindow();
        }

        CloseWindow();
    }
}
