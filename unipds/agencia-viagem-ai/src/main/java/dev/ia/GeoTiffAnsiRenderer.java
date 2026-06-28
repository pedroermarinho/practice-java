package dev.ia;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;

public class GeoTiffAnsiRenderer {

    private static final String ESC = "\u001B";

    // Mapa de blocos quarteados (quad blocks)
    // Cada caractere representa 4 sub-pixels: TL, TR, BL, BR (bitmask 0–15)
    private static final char[] QUAD = {
            ' ',  '▘', '▝', '▀',
            '▖', '▌', '▞', '▛',
            '▗', '▚', '▐', '▜',
            '▄', '▙', '▟', '█'
    };

    public static void main(String[] args) {
        System.out.println(processar("sample.tif"));
    }

    public static String processar(String path) {
        File file = new File(path);

        if (!file.exists()) {
            return "Arquivo não encontrado.";
        }

        try {
            BufferedImage img = ImageIO.read(file);
            if (img == null) {
                return "GeoTIFF inválido.";
            }

            Raster raster = img.getRaster();
            int W = raster.getWidth();
            int H = raster.getHeight();
            int B = raster.getNumBands();

            double[] min = new double[B];
            double[] max = new double[B];
            double[] px = new double[B];

            for (int b = 0; b < B; b++) {
                min[b] = Double.MAX_VALUE;
                max[b] = -Double.MAX_VALUE;
            }

            // Min/Max real
            for (int y = 0; y < H; y++) {
                for (int x = 0; x < W; x++) {
                    raster.getPixel(x, y, px);
                    for (int b = 0; b < B; b++) {
                        if (px[b] < min[b]) min[b] = px[b];
                        if (px[b] > max[b]) max[b] = px[b];
                    }
                }
            }

            // Normalização com contraste avançado
            java.util.function.BiFunction<Double, Integer, Integer> norm = (v, b) -> {
                double range = max[b] - min[b];
                if (range == 0) return 0;
                double z = (v - min[b]) / range;
                z = Math.pow(z, 0.8); // contraste fino
                return (int) (z * 255);
            };

            // FULL resolution: 2x2 subpixels por char
            int step = 1;

            StringBuilder out = new StringBuilder();

            for (int y = 0; y < H - 1; y += step * 2) {
                for (int x = 0; x < W - 1; x += step * 2) {

                    double[][] block = new double[4][B];

                    raster.getPixel(x,         y,         block[0]); // TL
                    raster.getPixel(x + step,  y,         block[1]); // TR
                    raster.getPixel(x,         y + step,  block[2]); // BL
                    raster.getPixel(x + step,  y + step,  block[3]); // BR

                    // Luminância média para cor do bloco
                    int r = 0, g = 0, b = 0;
                    for (int i = 0; i < 4; i++) {
                        int R = norm.apply(block[i][0], 0);
                        int G = B > 1 ? norm.apply(block[i][1], 1) : R;
                        int Bc = B > 2 ? norm.apply(block[i][2], 2) : R;

                        r += R;
                        g += G;
                        b += Bc;
                    }
                    r /= 4;
                    g /= 4;
                    b /= 4;

                    // Determina quais subpixels estão "acesos"
                    int mask = 0;
                    mask |= (lumi(block[0]) > 0.30 ? 1 << 0 : 0);
                    mask |= (lumi(block[1]) > 0.30 ? 1 << 1 : 0);
                    mask |= (lumi(block[2]) > 0.30 ? 1 << 2 : 0);
                    mask |= (lumi(block[3]) > 0.30 ? 1 << 3 : 0);

                    char quad = QUAD[mask];

                    out.append(String.format(
                            ESC + "[38;2;%d;%d;%dm" + quad + ESC + "[0m",
                            r, g, b
                    ));
                }
                out.append("\n");
            }

            return out.toString();

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    // Luminância simples para decidir encaixe do subpixel
    private static double lumi(double[] px) {
        double r = px[0];
        double g = px.length > 1 ? px[1] : r;
        double b = px.length > 2 ? px[2] : r;
        return (0.299 * r + 0.587 * g + 0.114 * b) / 255.0;
    }
}