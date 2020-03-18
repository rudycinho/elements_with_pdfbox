package basic;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.awt.*;
import java.io.IOException;

public class Grid {
    private final int maxX;
    private final int maxY;

    public Grid(int maxX, int maxY){
        this.maxX = maxX;
        this.maxY = maxY;
    }

    private void draw(PDPageContentStream contenido) throws IOException {
        for ( int i = 0 ; i < maxY; i+=5) {
            contenido.setStrokingColor(new Color(250, 250, 30));
            contenido.moveTo(0, maxY-i);
            contenido.lineTo(maxX, maxY-i);
            contenido.stroke();
        }

        for ( int i = 0 ; i < maxX; i+=5) {
            contenido.setStrokingColor(new Color(250, 250, 30));
            contenido.moveTo(i, 0);
            contenido.lineTo(i, maxY);
            contenido.stroke();
        }

        for ( int i = 0 ; i < maxY; i+=25) {
            contenido.setStrokingColor(new Color(250, 200, 30));
            contenido.moveTo(0, maxY-i);
            contenido.lineTo(maxX, maxY-i);
            contenido.stroke();
        }

        for ( int i = 0 ; i < maxX; i+=25) {
            contenido.setStrokingColor(new Color(250, 200, 30));
            contenido.moveTo(i, 0);
            contenido.lineTo(i, maxY);
            contenido.stroke();
        }

        for ( int i = 0 ; i < maxY; i+=100) {
            contenido.setStrokingColor(new Color(250, 150, 30));
            contenido.moveTo(0, maxY-i);
            contenido.lineTo(maxX, maxY-i);
            contenido.stroke();
        }

        for ( int i = 0 ; i < maxX; i+=100) {
            contenido.setStrokingColor(new Color(250, 150, 30));
            contenido.moveTo(i, 0);
            contenido.lineTo(i, maxY);
            contenido.stroke();
        }
    }
}
