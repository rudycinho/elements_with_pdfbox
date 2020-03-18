package table;

import additional.Pair;
import basic.Style;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Column {
    private int startingPointMarginX;
    private int startingPointMarginY;
    private int height;
    private List<CellText> cellTextList;


    public Column(int x0, int y0, int height,List<Pair<String,Integer>> list){
        this.startingPointMarginX = x0;
        this.startingPointMarginY = y0;
        this.height = height;
        cellTextList = new ArrayList<>();

        Iterator<Pair<String,Integer>> it = list.iterator();

        int auxX = startingPointMarginX;
        Pair<String,Integer> el;
        while(it.hasNext()){
            el = it.next();
            cellTextList.add(new CellText(
                    auxX, startingPointMarginY, el.getValue1(), height)
                    .setText(el.getValue0()));
            auxX += el.getValue1();
        }
    }

    public Column setForeground(Color foreground){
        cellTextList.forEach(e -> e.setForeground(foreground));
        return this;
    }

    public Column setTextFont(PDFont textFont){
        cellTextList.forEach(e -> e.setTextFont(textFont));
        return this;
    }

    public Column setFontSize(int fontSize){
        cellTextList.forEach(e -> e.setFontSize(fontSize));
        return this;
    }

    public Column setColorCell(Color colorCell){
        cellTextList.forEach(e -> e.setColorCell(colorCell));
        return this;
    }

    public Column setStartingPointRelative(int x, int y){
        cellTextList.forEach(e -> e.setStartingPointRelative(x,y));
        return this;
    }

    public Column setMarginColor(Color marginColor){
        cellTextList.forEach(e -> e.setMarginColor(marginColor));
        return this;
    }

    public Column enableMargin(){
        cellTextList.forEach(e -> e.enableMargin());
        return this;
    }

    public Column disableMargin(){
        cellTextList.forEach(e -> e.disableMargin());
        return this;
    }

    public void build(PDPageContentStream contentStream) throws IOException {
        for (CellText e : cellTextList) {
            e.build(contentStream);
        }
    }
}
