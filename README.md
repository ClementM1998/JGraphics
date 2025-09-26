# JGraphics
Ini adalah sebuah perpustakaan JGraphics yang di bina menggunakan bahasa Java. Ia adalah perpustakaan untuk grafik dan kawalan sederhana.

# **Ciri-ciri Konstanta dan Fungsi**
* Warna(ARGB)
  ```java
  - RED, GREEN, BLUE, BLACK, WHITE, TRANSPARENT, YELLOW, CYAN, MAGENTA, GRAY, SILVER, MAROON, OLIVE, LIME, TEAL, NAVY, PURPLE, ORANGE
  ```

* Papan Kekunci
  ```java
  - KEY_ESCAPE, KEY_HOME, KEY_END, KEY_INSERT, KEY_DELETE
  - KEY_PAGE_UP, KEY_PAGE_DOWN
  - KEY_UP, KEY_DOWN, KEY_LEFT, KEY_RIGHT
  - KEY_F1 -> KEY_F9
  - KEY_A -> KEY_Z
  - KEY_0 -> KEY_9
  ```
 
* Tetikus
  ```java
  - MOUSE_BUTTON_LEFT
  - MOUSE_BUTTON_MIDDLE
  - MOUSE_BUTTON_RIGHT
  ```

* Graviti Teks
  ```java
  - TEXT_GRAVITY_LEFT_TOP
  - TEXT_GRAVITY_CENTER_TOP
  - TEXT_GRAVITY_RIGHT_TOP
  - TEXT_GRAVITY_LEFT_CENTER
  - TEXT_GRAVITY_CENTER
  - TEXT_GRAVITY_RIGHT_CENTER
  - TEXT_GRAVITY_LEFT_BOTTOM
  - TEXT_GRAVITY_CENTER_BOTTOM
  - TEXT_GRAVITY_RIGHT_BOTTOM
  ```

* Fungsi Window
  ```java
  - CreateWindow(title)
  - CreateWindow(title, width, height)
  - CreateWindow(title, x, y, width, height)
  - ClearWindow()
  - RefreshWindow()
  - CloseWindow()
  - GetWindowTitle()
  - GetX()
  - GetY()
  - GetWindowWidth()
  - GetWindowHeight()
  ```

* Fungsi Kawalan Masa
  ```java
  - SetFrameRate(fps)
  - Delay(ms)
  ```

* Fungsi Warna dan Lukisan
  ```java
  - SetBackgroundWindow(color), GetBackgroundWindow()
  - SetColor(color), SetColor(color, alpha)
  - SetFillColor(color), SetColor(color, alpha)
  - SetCurrentColor(color), SetCurrentColor(color, fill)
  - SetAntialias(antialias)
  - SetStroke(size)
  - SetFilled(fill)
  ```

* Fungsi Teks
  ```java
  - SetFontName(name)
  - SetFontStyle(style)
  - SetFontSize(size)
  - SetTextGravity(gravity)
  - GetTextWidth(text)
  - GetTextHeight(text)
  - Text(text, x, y)
  - Text(text)
  ```

* Fungsi Bentuk
  ```java
  - Point(x, y)
  - Line(x1, y1, x2, y2)
  - Rectangle(x1, y1, x2, y2)
  - Square(x, y, size)
  - Circle(x, y, radius)
  - Ellipse(x, y, w, h)
  - Polygon(x[], y[], num)
  - Polygon(x[], y[])
  - Triangle(x1, y1, x2, y2, x3, y3)
  - Arc(x, y, w, h, start, sweep)
  - Arc(x, y, radius, start, sweep)
  ```

* Fungsi Path
  ```java
  - BeginPath()
  - MoveTo(x, y)
  - LineTo(x, y)
  - QuadTo(cx, cy, x, y)
  - CurveTo(cx1, cy1, cx2, cy2, x, y)
  - ClosePath()
  - DrawPath()
  ```

* Fungsi Imej
  ```java
  - DrawImage(path, x, y)
  - DrawImage(img, x, y)
  - DrawImage(img, x, y, w, h)
  ```

* Fungsi Papan Kekunci
  ```java
  - IsKeyDown(key)
  - IsKB()
  - Getch()
  ```

* Fungsi Tetikus
  ```java
  - GetMouseX(), GetMouseY()
  - IsMouseDown(button)
  ```



  - GetMouseScrollWheel()

