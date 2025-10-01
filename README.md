# JGraphics
Ini adalah sebuah perpustakaan JGraphics yang di bina menggunakan bahasa Java. Ia adalah perpustakaan untuk grafik dan kawalan sederhana.

# **Ciri-ciri Konstanta dan Fungsi**
* Warna(ARGB)
  ```java
  - RED
  - GREEN
  - BLUE
  - BLACK
  - WHITE
  - TRANSPARENT
  - YELLOW
  - CYAN
  - MAGENTA
  - GRAY
  - SILVER
  - MAROON
  - OLIVE
  - LIME
  - TEAL
  - NAVY
  - PURPLE
  - ORANGE
  ```

* Papan Kekunci
  ```java
  - KEY_ESCAPE, KEY_HOME, KEY_END, KEY_INSERT, KEY_DELETE, KEY_SPACE
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
  - CreateWindow(String title)
  - CreateWindow(String title, int width, int height)
  - CreateWindow(String title, int x, int y, int width, int height)
  - ClearWindow()
  - RefreshWindow()
  - CloseWindow()
  - GetWindowTitle()
  - GetX()
  - GetY()
  - GetWindowWidth()
  - GetWindowHeight()
  - SetBackgroundWindow(int color), GetBackgroundWindow()
  ```

* Fungsi Kawalan Masa
  ```java
  - SetFrameRate(int fps)
  - Delay(long ms)
  ```

* Fungsi Warna dan Lukisan
  ```java
  - SetColor(int color), SetColor(int color, int alpha)
  - SetFillColor(int color), SetColor(int color, int alpha)
  - SetCurrentColor(int color), SetCurrentColor(int color, int fill)
  - SetAntialias(boolean antialias)
  - SetStroke(int size)
  - SetFilled(boolean fill)
  ```

* Fungsi Teks
  ```java
  - SetFontName(String name)
  - SetFontStyle(int style)
  - SetFontSize(int size)
  - SetTextGravity(TextGravity gravity)
  - GetTextWidth(String text)
  - GetTextHeight(String text)
  - Text(String text, int x, int y)
  - Text(String text)
  ```

* Fungsi Bentuk
  ```java
  - Point(int x, int y)
  - Line(int x1, int y1, int x2, int y2)
  - Rectangle(int x1, int y1, int x2, int y2)
  - Square(int x, int y, int size)
  - Circle(int x, int y, int radius)
  - Ellipse(int x, int y, int w, int h)
  - Polygon(int x[], int y[], int num)
  - Polygon(int x[], int y[])
  - Triangle(int x1, int y1, int x2, int y2, int x3, int y3)
  - Arc(int x, int y, int w, int h, int start, int sweep)
  - Arc(int x, int y, int radius, int start, int sweep)
  ```

* Fungsi Path
  ```java
  - BeginPath()
  - MoveTo(float x, float y)
  - LineTo(float x, float y)
  - QuadTo(int cx, int cy, int x, int y)
  - CurveTo(int cx1, int cy1, int cx2, int cy2, int x, int y)
  - ClosePath()
  - DrawPath()
  ```

* Fungsi Imej
  ```java
  - DrawImage(String path, int x, int y)
  - DrawImage(Image img, int x, int y)
  - DrawImage(Image img, int x, int y, int w, int h)
  ```

* Fungsi Papan Kekunci
  ```java
  - IsKeyDown(int key)
  - IsKB()
  - Getch()
  ```

* Fungsi Tetikus
  ```java
  - GetMouseX(), GetMouseY()
  - IsMouseDown(int button)
  - GetMouseScrollWheel()
  ```

* Transformasi dan Skala
  ```java
  - ResetTransform()
  - Translate(double tx, double ty)
  - Scale(double sx, double sy)
  - Rotate(double theta)
  - SaveTransform()
  - RestoreTransform()
  - SetScale(double sx, double sy)
  - GetScaleX()
  - GetScaleY()
  ```



