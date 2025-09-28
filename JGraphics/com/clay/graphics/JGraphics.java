package com.clay.graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public final class JGraphics {
    private static String launchApp;

    static {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        launchApp = "Unknown";
        for (StackTraceElement element : stackTrace) {
            if (!element.getClassName().startsWith("com.clay.graphics.JGraphics") && !element.getClassName().startsWith("java.lang")) {
                launchApp = element.getClassName();
                break;
            }
        }
        System.out.println("JGraphics v1.0");
        System.out.println("launch : " + launchApp);
    }

    public static final int RED = 0xFFFF0000;
    public static final int GREEN = 0xFF00FF00;
    public static final int BLUE = 0xFF0000FF;
    public static final int BLACK = 0xFF000000;
    public static final int WHITE = 0xFFFFFFFF;
    public static final int TRANSPARENT = 0x00000000;
    public static final int YELLOW = 0xFFFFFF00;
    public static final int CYAN = 0xFF00FFFF;
    public static final int MAGENTA = 0xFFFF00FF;
    public static final int GRAY = 0xFF808080;
    public static final int SILVER = 0xFFC0C0C0;
    public static final int MAROON = 0xFF800000;
    public static final int OLIVE = 0xFF808000;
    public static final int LIME = 0xFF00FF00;
    public static final int TEAL = 0xFF008080;
    public static final int NAVY = 0xFF000080;
    public static final int PURPLE = 0xFF800080;
    public static final int ORANGE = 0xFFFFA500;

    public static final int KEY_ESCAPE = KeyEvent.VK_ESCAPE;
    public static final int KEY_HOME = KeyEvent.VK_HOME;
    public static final int KEY_UP = KeyEvent.VK_UP;
    public static final int KEY_PAGE_UP = KeyEvent.VK_PAGE_UP;
    public static final int KEY_LEFT = KeyEvent.VK_LEFT;
    public static final int KEY_RIGHT = KeyEvent.VK_RIGHT;
    public static final int KEY_END = KeyEvent.VK_END;
    public static final int KEY_DOWN = KeyEvent.VK_DOWN;
    public static final int KEY_PAGE_DOWN = KeyEvent.VK_PAGE_DOWN;
    public static final int KEY_INSERT = KeyEvent.VK_INSERT;
    public static final int KEY_DELETE = KeyEvent.VK_DELETE;
    public static final int KEY_F1 = KeyEvent.VK_F1;
    public static final int KEY_F2 = KeyEvent.VK_F2;
    public static final int KEY_F3 = KeyEvent.VK_F3;
    public static final int KEY_F4 = KeyEvent.VK_F4;
    public static final int KEY_F5 = KeyEvent.VK_F5;
    public static final int KEY_F6 = KeyEvent.VK_F6;
    public static final int KEY_F7 = KeyEvent.VK_F7;
    public static final int KEY_F8 = KeyEvent.VK_F8;
    public static final int KEY_F9 = KeyEvent.VK_F9;

    public static final int KEY_A = KeyEvent.VK_A;
    public static final int KEY_B = KeyEvent.VK_B;
    public static final int KEY_C = KeyEvent.VK_C;
    public static final int KEY_D = KeyEvent.VK_D;
    public static final int KEY_E = KeyEvent.VK_E;
    public static final int KEY_F = KeyEvent.VK_F;
    public static final int KEY_G = KeyEvent.VK_G;
    public static final int KEY_H = KeyEvent.VK_H;
    public static final int KEY_I = KeyEvent.VK_I;
    public static final int KEY_J = KeyEvent.VK_J;
    public static final int KEY_K = KeyEvent.VK_K;
    public static final int KEY_L = KeyEvent.VK_L;
    public static final int KEY_M = KeyEvent.VK_M;
    public static final int KEY_N = KeyEvent.VK_N;
    public static final int KEY_O = KeyEvent.VK_O;
    public static final int KEY_P = KeyEvent.VK_P;
    public static final int KEY_Q = KeyEvent.VK_Q;
    public static final int KEY_R = KeyEvent.VK_R;
    public static final int KEY_S = KeyEvent.VK_S;
    public static final int KEY_T = KeyEvent.VK_T;
    public static final int KEY_U = KeyEvent.VK_U;
    public static final int KEY_V = KeyEvent.VK_V;
    public static final int KEY_W = KeyEvent.VK_W;
    public static final int KEY_X = KeyEvent.VK_X;
    public static final int KEY_Y = KeyEvent.VK_Y;
    public static final int KEY_Z = KeyEvent.VK_Z;

    public static final int KEY_0 = KeyEvent.VK_0;
    public static final int KEY_1 = KeyEvent.VK_1;
    public static final int KEY_2 = KeyEvent.VK_2;
    public static final int KEY_3 = KeyEvent.VK_3;
    public static final int KEY_4 = KeyEvent.VK_4;
    public static final int KEY_5 = KeyEvent.VK_5;
    public static final int KEY_6 = KeyEvent.VK_6;
    public static final int KEY_7 = KeyEvent.VK_7;
    public static final int KEY_8 = KeyEvent.VK_8;
    public static final int KEY_9 = KeyEvent.VK_9;

    public static final int MOUSE_BUTTON_LEFT = MouseEvent.BUTTON1;
    public static final int MOUSE_BUTTON_MIDDLE = MouseEvent.BUTTON2;
    public static final int MOUSE_BUTTON_RIGHT = MouseEvent.BUTTON3;

    private static JFrame window;
    private static Canvas canvas;
    private static BufferStrategy bufferStrategy;
    private static Graphics2D g2d;

    private static String TitleWin = "Untitled";
    private static int XWin = 0;
    private static int YWin = 0;
    private static int WidthWin = 640;
    private static int HeightWin = 480;

    private static int targetFps = 0;
    private static long frameNanos = 0L;
    private static boolean initialized = false;

    private static final boolean[] keyDown = new boolean[512];
    private static final Set<Integer> keyPressed = new HashSet<>();
    private static final Set<Integer> keyReleased = new HashSet<>();
    private static volatile char lastchar = '\0';

    private static volatile int mousex = 0;
    private static volatile int mousey = 0;
    private static final boolean[] mouseDown = new boolean[8];
    private static final Set<Integer> mousePressed = new HashSet<>();
    private static final Set<Integer> mouseReleased = new HashSet<>();
    private static int mouseWheelRotation = 0;
    private static int mouseScrollWheelRotation = 0;

    private static Color backgroundColor = Color.BLACK;
    private static Color currentColor = Color.WHITE;
    private static Color fillColor = Color.WHITE;
    private static boolean filled = false;

    private static String fontName = "Arial";
    private static int fontStyle = Font.PLAIN;
    private static int fontSize = 12;
    private static Font fontText = new Font(fontName, fontStyle, fontSize);
    private static int currentTextX = 0;
    private static int currentTextY = 0;

    private enum TextGravity {
        LEFT_TOP,
        CENTER_TOP,
        RIGHT_TOP,
        LEFT_CENTER,
        CENTER,
        RIGHT_CENTER,
        LEFT_BOTTOM,
        CENTER_BOTTOM,
        RIGHT_BOTTOM
    }

    public static final TextGravity TEXT_GRAVITY_LEFT_TOP = TextGravity.LEFT_TOP;
    public static final TextGravity TEXT_GRAVITY_CENTER_TOP = TextGravity.CENTER_TOP;
    public static final TextGravity TEXT_GRAVITY_RIGHT_TOP = TextGravity.RIGHT_TOP;
    public static final TextGravity TEXT_GRAVITY_LEFT_CENTER = TextGravity.LEFT_CENTER;
    public static final TextGravity TEXT_GRAVITY_CENTER = TextGravity.CENTER;
    public static final TextGravity TEXT_GRAVITY_RIGHT_CENTER = TextGravity.RIGHT_CENTER;
    public static final TextGravity TEXT_GRAVITY_LEFT_BOTTOM = TextGravity.LEFT_BOTTOM;
    public static final TextGravity TEXT_GRAVITY_CENTER_BOTTOM = TextGravity.CENTER_BOTTOM;
    public static final TextGravity TEXT_GRAVITY_RIGHT_BOTTOM = TextGravity.RIGHT_BOTTOM;

    private static TextGravity textGravity = TEXT_GRAVITY_LEFT_TOP;

    private static Path2D currentPath = null;

    private static AffineTransform savedTransform;
    private static AffineTransform currentTransform = new AffineTransform();

    public static void CreateWindow(String title) {
        CreateWindow(title, WidthWin, HeightWin);
    }

    public static void CreateWindow(String title, int width, int height) {
        CreateWindow(title, XWin, YWin, width, height);
    }

    public static void CreateWindow(String title, int x, int y, int width, int height) {
        if (initialized) return;

        TitleWin = title;
        XWin = x;
        YWin = y;
        WidthWin = width;
        HeightWin = height;

        WidthWin = Math.max(1, width);
        HeightWin = Math.max(1, height);

        Runnable ui = () -> {
            window = new JFrame(title);
            canvas = new Canvas();

            canvas.setPreferredSize(new Dimension(width, height));

            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setResizable(false);
            window.setLayout(new BorderLayout());

            JMenuBar menuBar = new JMenuBar();

            JMenu menuFile = new JMenu("File");
            JMenuItem launchItem = new JMenuItem("Launch");
            JMenuItem aboutItem = new JMenuItem("About");
            JMenuItem exitItem = new JMenuItem("Exit");

            menuFile.add(launchItem);
            menuFile.add(aboutItem);
            menuFile.add(exitItem);
            menuBar.add(menuFile);

            launchItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(window, "launch: " + launchApp, "Launch", JOptionPane.INFORMATION_MESSAGE);
                }
            });

            aboutItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(window, "JGraphics v1.0 by Clay\n\n    Name : JGraphics\n    Package : com.clay.graphics\n    Library : jgraphics-1.0.jar\n    Version : 1.0\n    Author : Clay", "About", JOptionPane.INFORMATION_MESSAGE);
                }
            });

            exitItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CloseWindow();
                }
            });

            window.setJMenuBar(menuBar);

            canvas.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {}

                @Override
                public void keyPressed(KeyEvent e) {
                    lastchar = e.getKeyChar();
                    int code = e.getKeyCode();
                    if (code >= 0 && code < keyDown.length) {
                        if (!keyDown[code]) keyPressed.add(code);
                        keyDown[code] = true;
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    lastchar = '\0';
                    int code = e.getKeyCode();
                    if (code >= 0 && code < keyDown.length) {
                        keyDown[code] = false;
                        keyReleased.add(code);
                    }
                }
            });

            canvas.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {}

                @Override
                public void mousePressed(MouseEvent e) {
                    int b = e.getButton();
                    if (b >= 0 && b < mouseDown.length) {
                        if (!mouseDown[b]) mousePressed.add(b);
                        mouseDown[b] = true;
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    int b = e.getButton();
                    if (b >= 0 && b < mouseDown.length) {
                        mouseDown[b] = false;
                        mouseReleased.add(b);
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    mousex = e.getX();
                    mousey = e.getY();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    mousex = e.getX();
                    mousey = e.getY();
                }
            });

            canvas.addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    mousex = e.getX();
                    mousey = e.getY();
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    mousex = e.getX();
                    mousey = e.getY();
                }
            });

            canvas.addMouseWheelListener(new MouseWheelListener() {
                @Override
                public void mouseWheelMoved(MouseWheelEvent e) {
                    mouseWheelRotation = e.getWheelRotation();
                    mouseScrollWheelRotation += mouseWheelRotation;
                }
            });

            canvas.setFocusable(true);

            window.add(canvas, BorderLayout.CENTER);
            window.pack();
            window.setLocation(x, y);
            window.setVisible(true);

            canvas.requestFocusInWindow();

            canvas.createBufferStrategy(3);
            bufferStrategy = canvas.getBufferStrategy();

            initialized = true;
        };

        if (SwingUtilities.isEventDispatchThread()) ui.run();
        else try { SwingUtilities.invokeAndWait(ui); } catch (Exception e) {}

        SetFrameRate(targetFps);
        ClearWindow();
    }

    public static void ClearWindow() {
        beginFrame();
        if (g2d != null) {
            g2d.setColor(backgroundColor);
            g2d.fillRect(0, 0, GetWindowWidth(), GetWindowHeight());
        }
    }

    public static void RefreshWindow() {
        if (g2d != null) {
            g2d.dispose();
            g2d = null;
        }
        if (bufferStrategy != null) {
            if (!bufferStrategy.contentsLost()) bufferStrategy.show();
            Toolkit.getDefaultToolkit().sync();
        }
        if (frameNanos > 0L) {
            final long start = System.nanoTime();
            final long end = start + frameNanos;
            long now = start;
            while (now < end) {
                long sleepMs = (end - now) / 1000000L;
                if (sleepMs > 0) try { Thread.sleep(Math.min(sleepMs, 2)); } catch (InterruptedException e) {}
                else Thread.onSpinWait();
                now = System.nanoTime();
            }
        }
        keyPressed.clear();
        keyReleased.clear();
        mousePressed.clear();
        mouseReleased.clear();
    }

    public static void CloseWindow() {
        if (!initialized) return;
        try {
            if (window != null) {
                window.setVisible(false);
                window.dispose();
                System.exit(0);
            }
        } finally {
            window = null;
            canvas = null;
            bufferStrategy = null;
            g2d = null;
            initialized = false;
        }
    }

    public static String GetWindowTitle() {
        return TitleWin;
    }

    public static int GetX() {
        return XWin;
    }

    public static int GetY() {
        return YWin;
    }

    public static int GetWindowWidth() {
        return WidthWin;
    }

    public static int GetWindowHeight() {
        return HeightWin;
    }

    private static void beginFrame() {
        ensureBuffer();
        if (g2d != null) return; // already begin
        if (bufferStrategy == null) return;
        g2d = (Graphics2D) bufferStrategy.getDrawGraphics();
        SetAntialias(true);
    }

    private static void ensureBuffer() {
        if (canvas == null) return;
        if (bufferStrategy == null) {
            canvas.createBufferStrategy(3);
            bufferStrategy = canvas.getBufferStrategy();
        }
    }

    private static Graphics2D g() {
        if (g2d == null) beginFrame();
        return g2d;
    }

    public static void SetFrameRate(int fps) {
        targetFps = Math.max(0, fps);
        frameNanos = (targetFps <= 0) ? 0L : (1000000000L / targetFps);
    }

    public static void Delay(long msec) {
        if (msec < 0) msec = 0;
        try { Thread.sleep(msec); } catch (InterruptedException e) {}
    }

    public static void SetBackgroundWindow(int color) {
        backgroundColor = new Color(color, true);
        if (canvas != null) canvas.setBackground(backgroundColor);
    }

    public static int GetBackgroundWindow() {
        return backgroundColor.getRGB();
    }

    public static void SetColor(int color) {
        int alpha = (color >> 24) & 0xFF;
        int red = (color >> 16) & 0xFF;
        int green = (color >> 8) & 0xFF;
        int blue = color & 0xFF;

        // Bezakan AARRGGBB vs RRGGBB
        if (alpha == 0x00) {
            // Input asal mungkin RRGGBB (tiada alpha -> default 0xFF)
            alpha = 0xFF;
        }

        currentColor = new Color(red, green, blue, alpha);
    }

    public static void SetColor(int color, int newAlpha) {
        int alpha = (color >> 24) & 0xFF;
        int red = (color >> 16) & 0xFF;
        int green = (color >> 8) & 0xFF;
        int blue = color & 0xFF;
        currentColor = new Color(red, green, blue, newAlpha);
    }

    public static void SetFillColor(int color) {
        int alpha = (color >> 24) & 0xFF;
        int red = (color >> 16) & 0xFF;
        int green = (color >> 8) & 0xFF;
        int blue = color & 0xFF;

        if (alpha == 0x00) {
            alpha = 0xFF;
        }

        fillColor = new Color(red, green, blue, alpha);
        filled = true;
    }

    public static void SetFillColor(int color, int newAlpha) {
        int alpha = (color >> 24) & 0xFF;
        int red = (color >> 16) & 0xFF;
        int green = (color >> 8) & 0xFF;
        int blue = color & 0xFF;
        fillColor = new Color(red, green, blue, newAlpha);
        filled = true;
    }

    public static void SetCurrentColor(int color) {
        SetCurrentColor(color, color);
    }

    public static void SetCurrentColor(int color, int fill) {
        SetColor(color);
        SetFillColor(fill);
    }

    public static void SetAntialias(boolean antialis) {
        if (g2d == null) return; // safe-guard
        if (antialis) {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        } else {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        }
    }

    public static void SetStroke(float s) {
        g().setStroke(new BasicStroke(s));
    }

    public static void SetFilled(boolean fill) {
        filled = fill;
    }

    public static void SetFontName(String name) {
        fontName = name;
        fontText = new Font(fontName, fontStyle, fontSize);
    }

    public static void SetFontStyle(int style) {
        fontStyle = style;
        fontText = new Font(fontName, fontStyle, fontSize);
    }

    public static void SetFontSize(int size) {
        fontSize = size;
        fontText = new Font(fontName, fontStyle, fontSize);
    }

    public static void  SetTextGravity(TextGravity gravity) {
        textGravity = gravity;
    }

    public static int GetTextWidth(String text) {
        if (g() == null || text == null) return 0;
        FontMetrics fm = g().getFontMetrics();
        return fm.stringWidth(text);
    }

    public static int GetTextHeight(String text) {
        if (g() == null || text == null) return 0;
        FontMetrics fm = g().getFontMetrics();
        return fm.getHeight();
    }

    public static void Point(int x, int y) {
        g().setColor(currentColor);
        g().drawLine(x, y, x, y);
    }

    public static void Line(int x1, int y1, int x2, int y2) {
        g().setColor(currentColor);
        g().drawLine(x1, y1, x2, y2);
    }

    public static void Rectangle(int x1, int y1, int x2, int y2) {
        int l = x1;
        int t = y1;
        int r = x2;
        int b = y2;
        if (filled) {
            g().setColor(fillColor);
            g().fillRect(l, t, r, b);
        }
        g().setColor(currentColor);
        g().drawRect(l, t, r, b);
    }

    public static void Square(int x1, int y1, int size) {
        int l = x1;
        int t = y1;
        int r = size;
        int b = size;
        if (filled) {
            g().setColor(fillColor);
            g().fillRect(l, t, r, b);
        }
        g().setColor(currentColor);
        g().drawRect(l, t, r, b);
    }

    public static void Circle(int x, int y, int radius) {
        int l = x - radius;
        int t = y - radius;
        int r = radius * 2;
        int b = radius * 2;
        if (filled) {
            g().setColor(fillColor);
            g().fillOval(l, t, r, b);
        }
        g().setColor(currentColor);
        g().drawOval(l, t, r, b);
    }

    public static void Ellipse(int x, int y, int w, int h) {
        int l = x - w;
        int t = y - h;
        int r = w * 2;
        int b = h * 2;
        if (filled) {
            g().setColor(fillColor);
            g().fillOval(l, t, r, b);
        }
        g().setColor(currentColor);
        g().drawOval(l, t, r, b);
    }

    public static void Polygon(int[] x, int[] y, int num) {
        int xlength = x.length;
        int ylength = y.length;
        if (xlength != num || ylength != num) return;
        if (filled) {
            g().setColor(fillColor);
            g().fillPolygon(x, y, num);
        }
        g().setColor(currentColor);
        g().drawPolygon(x, y, num);
    }

    public static void Polygon(int[] x, int[] y) {
        int xlength = x.length;
        int ylength = y.length;
        if (xlength != ylength) return;
        int num = xlength;
        if (filled) {
            g().setColor(fillColor);
            g().fillPolygon(x, y, num);
        }
        g().setColor(currentColor);
        g().drawPolygon(x, y, num);
    }

    public static void Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        int[] xpoint = { x1, x2, x3 };
        int[] ypoint = { y1, y2, y3 };
        int num = xpoint.length;
        if (filled) {
            g().setColor(fillColor);
            g().fillPolygon(xpoint, ypoint, num);
        }
        g().setColor(currentColor);
        g().drawPolygon(xpoint, ypoint, num);
    }

    public static void Arc(int x, int y, int w, int h, int start, int sweep) {
        int l = x - w;
        int t = y - h;
        int r = w * 2;
        int b = h * 2;
        if (filled) {
            g().setColor(fillColor);
            g().fillArc(l, t, r, b, start, sweep);
        }
        g().setColor(currentColor);
        g().drawArc(l, t, r, b, start, sweep);
    }

    public static void Arc(int x, int y, int radius, int start, int sweep) {
        int l = x - radius;
        int t = y - radius;
        int r = radius * 2;
        int b = radius * 2;
        if (filled) {
            g().setColor(fillColor);
            g().fillArc(l, t, r, b, start, sweep);
        }
        g().setColor(currentColor);
        g().drawArc(l, t, r, b, start, sweep);
    }

    private static void drawTextWithGravity(String text, int offsetX, int offsetY) {
        g().setFont(fontText);
        FontMetrics fm = g().getFontMetrics();
        int lineHeight = fm.getHeight();

        String[] lines = text.split("\\n", -1);
        int totalHeight = lines.length * lineHeight;
        int maxWidth = 0;
        for (String ln : lines) {
            maxWidth = Math.max(maxWidth, fm.stringWidth(ln));
        }

        int baseX = 0;
        int baseY = 0;

        // vertical
        switch (textGravity) {
            case LEFT_TOP:
            case CENTER_TOP:
            case RIGHT_TOP:
                baseY = 0;
                break;
            case LEFT_CENTER:
            case CENTER:
            case RIGHT_CENTER:
                baseY = (GetWindowHeight() / 2) - (totalHeight / 2);
                break;
            case LEFT_BOTTOM:
            case CENTER_BOTTOM:
            case RIGHT_BOTTOM:
                baseY = GetWindowHeight() - totalHeight;
                break;
        }

        switch (textGravity) {
            case LEFT_TOP:
            case LEFT_CENTER:
            case LEFT_BOTTOM:
                baseX = 0;
                break;
            case CENTER_TOP:
            case CENTER:
            case CENTER_BOTTOM:
                baseX = (GetWindowWidth() / 2) - (maxWidth / 2);
                break;
            case RIGHT_TOP:
            case RIGHT_CENTER:
            case RIGHT_BOTTOM:
                baseX = GetWindowWidth() - maxWidth;
                break;
        }

        g().setColor(currentColor);
        for (int i = 0;i < lines.length;i++) {
            String ln = lines[i];
            int lineWidth = fm.stringWidth(ln);
            int drawX = baseX;
            // adjust per-line horizontal alignment inside the block
            switch (textGravity) {
                case CENTER_TOP:
                case CENTER:
                case CENTER_BOTTOM:
                    drawX += (maxWidth - lineWidth) / 2;
                    break;
                case RIGHT_TOP:
                case RIGHT_CENTER:
                case RIGHT_BOTTOM:
                    drawX += (maxWidth - lineWidth);
                    break;
                default:
                    // LEFT_* no extra offset
            }
            int drawY = baseY + (i * lineHeight) + fm.getAscent();
            g().drawString(ln, drawX + offsetX, drawY + offsetY);
        }
    }

    public static void Text(String text, int x, int y) {
        drawTextWithGravity(text, x, y);
    }

    public static void Text(String text) {
        drawTextWithGravity(text, 0, 0);
    }

    public static void BeginPath() {
        currentPath = new Path2D.Float();
    }

    public static void MoveTo(float x, float y) {
        if (currentPath != null) currentPath.moveTo(x, y);
    }

    public static void LineTo(float x, float y) {
        if (currentPath != null) currentPath.lineTo(x, y);
    }

    public static void QuadTo(int cx, int cy, int x, int y) {
        if (currentPath != null) currentPath.quadTo(cx, cy, x, y);
    }

    public static void CurveTo(int cx1, int cy1, int cx2, int cy2, int x, int y) {
        if (currentPath != null) currentPath.curveTo(cx1, cy1, cx2, cy2, x, y);
    }

    public static void ClosePath() {
        currentPath.closePath();
    }

    public static void DrawPath() {
        if (currentPath != null) {
            if (filled) {
                g().setColor(fillColor);
                g().fill(currentPath);
            }
            g().setColor(currentColor);
            g().draw(currentPath);
        }
        currentPath = null;
    }

    public static void DrawImage(String path, int x, int y) {
        try {
            BufferedImage img = ImageIO.read(new File(path));
            if (img != null) g().drawImage(img, x, y, null);
        } catch (Exception e) {}
    }

    public static void DrawImage(Image img, int x, int y) {
        g().drawImage(img, x, y, null);
    }

    public static void DrawImage(Image img, int x, int y, int w, int h) {
        g().drawImage(img, x, y, w, h, null);
    }

    public static boolean IsKeyDown(int key) {
        if (key < 0 || key >= keyDown.length) return false;
        return keyDown[key];
    }

    public static boolean IsKB() {
        for (boolean kd : keyDown) if (kd) return true;
        return !keyPressed.isEmpty() || !keyReleased.isEmpty();
    }

    public static char Getch() {
        return lastchar;
    }

    public static int GetMouseX() {
        return mousex;
    }

    public static int GetMouseY() {
        return mousey;
    }

    public static boolean IsMouseDown(int button) {
        return (button >= 0 && button < mouseDown.length) && mouseDown[button];
    }

    public static int GetMouseScrollWheel() {
        return mouseScrollWheelRotation;
    }

    public static void ResetTransform() {
        g().setTransform(new AffineTransform());
        currentTransform = new AffineTransform();
    }

    public static void Translate(double tx, double ty) {
        currentTransform.translate(tx, ty);
        g().setTransform(currentTransform);
    }

    public static void Scale(double sx, double sy) {
        currentTransform.scale(sx, sy);
        g().setTransform(currentTransform);
    }

    public static void Rotate(double theta) {
        currentTransform.rotate(theta);
        g().setTransform(currentTransform);
    }

    public static void SaveTransform() {
        savedTransform = g().getTransform();
    }

    public static void RestoreTransform() {
        if (savedTransform != null) {
            g().setTransform(savedTransform);
            currentTransform = new AffineTransform(savedTransform);
        }
    }

    private static double scaleX = 1.0;
    private static double scaleY = 1.0;

    public static void SetScale(double sx, double sy) {
        scaleX = sx;
        scaleY = sy;
        currentTransform = new AffineTransform();
        currentTransform.scale(scaleX, scaleY);
        g().setTransform(currentTransform);
    }

    public static double GetScaleX() {
        return scaleX;
    }

    public static double GetScaleY() {
        return scaleY;
    }

}
