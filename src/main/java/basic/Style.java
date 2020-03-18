package basic;

import org.apache.pdfbox.pdmodel.font.PDFont;

import java.awt.*;

public class Style {
    private int fontSize;
    private PDFont textFont;
    private Color textColor;

    public Style(PDFont textFont,int fontSize){
        this.fontSize = fontSize;
        this.textFont = textFont;
        this.textColor = Color.BLACK;
    }

    public Style(PDFont textFont,int fontSize, Color textColor){
        this.fontSize = fontSize;
        this.textFont = textFont;
        this.textColor = textColor;
    }

    public int getFontSize() {
        return fontSize;
    }

    public PDFont getTextFont() {
        return textFont;
    }

    public Color getTextColor() {
        return textColor;
    }
}
