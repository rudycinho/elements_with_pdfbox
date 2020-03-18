package table;

import basic.Style;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.Color;
import java.io.IOException;

public class CellText {
    private String text;
    private PDFont textFont;
    private float  fontSize;
    private int startingPointTextRelativeX;
    private int startingPointTextRelativeY;

    private int startingPointMarginX;
    private int startingPointMarginY;
    private int widthCell;
    private int heightCell;

    private boolean hasMargin;

    private Color foreground;
    private Color background;
    private Color marginColor;

    public CellText(int x0, int y0, int widthCell, int heightCell){
        this.startingPointMarginX = x0;
        this.startingPointMarginY = y0;
        this.widthCell  = widthCell;
        this.heightCell = heightCell;

        this.foreground  = Color.BLACK;
        this.background  = Color.WHITE;
        this.marginColor = Color.BLACK;

        this.text = "";
        this.textFont = PDType1Font.HELVETICA;
        this.fontSize = 9;

        this.startingPointTextRelativeX = 5;
        this.startingPointTextRelativeY = 5;

        this.hasMargin = true;
    }

    public CellText setText(String text) {
        this.text = text;
        return this;
    }

    public CellText setForeground(Color foreground){
        this.foreground = foreground;
        return this;
    }

    public CellText setTextFont(PDFont textFont){
        this.textFont = textFont;
        return this;
    }

    public CellText setFontSize(int fontSize){
        this.fontSize = fontSize;
        return this;
    }

    public CellText setColorCell(Color colorCell){
        this.background = colorCell;
        return this;
    }

    public CellText setStartingPointRelative(int x, int y){
        this.startingPointTextRelativeX = x;
        this.startingPointTextRelativeY = y;
        return this;
    }

    public CellText setMarginColor(Color marginColor){
        this.marginColor = marginColor;
        return this;
    }

    public CellText enableMargin(){
        this.hasMargin = true;
        return this;
    }

    public CellText disableMargin(){
        this.hasMargin = false;
        return this;
    }

    public void build(PDPageContentStream contentStream) throws IOException {
        contentStream.setNonStrokingColor(background);
        contentStream.addRect(startingPointMarginX,startingPointMarginY,widthCell,heightCell);
        contentStream.fill();

        if(hasMargin) {
            contentStream.setStrokingColor(marginColor);
            contentStream.addRect(startingPointMarginX, startingPointMarginY, widthCell, heightCell);
            contentStream.stroke();
        }

        contentStream.setNonStrokingColor(foreground);
        contentStream.beginText();
        contentStream.setFont(textFont , fontSize);
        contentStream.newLineAtOffset(
                startingPointMarginX + startingPointTextRelativeX,
                startingPointMarginY + startingPointTextRelativeY);
        contentStream.showText(text);
        contentStream.endText();
    }


}
