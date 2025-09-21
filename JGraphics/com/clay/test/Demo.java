package com.clay.test;

import static com.clay.graphics.JGraphics.*;

public class Demo {
    public static void main(String[] args) {

        CreateWindow("Demo");

        while (!IsKB()) {
            ClearWindow();

            RefreshWindow();
        }

        CloseWindow();
        
    }
}
