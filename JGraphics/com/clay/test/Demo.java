package com.clay.test;

import static com.clay.graphics.JGraphics.*;

public class Demo {
    public static void main(String[] args) {

        CreateWindow("Demo");

        while (!IsKeyDown(KEY_ESCAPE)) {
            ClearWindow();

            RefreshWindow();
        }

        CloseWindow();
        
    }
}
