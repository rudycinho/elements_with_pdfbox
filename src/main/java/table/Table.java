package table;

import additional.Pair;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table {
    private int startingPointMarginX;
    private int startingPointMarginY;
    private int height;
    private Column headerTable;
    private List<Column> bodyTable;

    public Table(
            int x0, int y0, int height,
            List<String> contentHeaderTable,List<Integer> widthsHeader, List<List<String>> contentBodyTable, List<Integer> widthsBody) {
        this.startingPointMarginX = x0;
        this.startingPointMarginY = y0;
        this.height = height;
        bodyTable = new ArrayList<>();

        headerTable = createColumn(x0,y0,height,contentHeaderTable,widthsHeader);
        Iterator<List<String>> it = contentBodyTable.iterator();

        int auxY = y0;
        while (it.hasNext()){
            auxY -= height;
            bodyTable.add(createColumn(x0,auxY,height,it.next(),widthsBody));
        }
    }



    private Column createColumn(int x0, int y0, int height,List<String> stringList, List<Integer> integerList) {
        List<Pair<String,Integer>> list = new ArrayList<>();
        for(int i=0;i<integerList.size();i++){
            list.add(new Pair(stringList.get(i),integerList.get(i)));
        }
        return new Column(x0,y0,height,list);
    }

    public void build(PDPageContentStream contentStream) throws IOException {
        headerTable.build(contentStream);
        for(Column column : bodyTable)
            column.build(contentStream);
    }


    public Table setForegroundBody(Color foreground){
        bodyTable.forEach(e -> e.setForeground(foreground));
        return this;
    }

    public Table setTextFontBody(PDFont textFont){
        bodyTable.forEach(e -> e.setTextFont(textFont));
        return this;
    }

    public Table setFontSizeBody(int fontSize){
        bodyTable.forEach(e -> e.setFontSize(fontSize));
        return this;
    }

    public Table setColorCellBody(Color colorCell){
        bodyTable.forEach(e -> e.setColorCell(colorCell));
        return this;
    }

    public Table setStartingPointRelativeBody(int x, int y){
        bodyTable.forEach(e -> e.setStartingPointRelative(x,y));
        return this;
    }

    public Table setMarginColorBody(Color marginColor){
        bodyTable.forEach(e -> e.setMarginColor(marginColor));
        return this;
    }

    public Table enableMarginBody(){
        bodyTable.forEach(e -> e.enableMargin());
        return this;
    }

    public Table disableMarginBody(){
        bodyTable.forEach(e -> e.disableMargin());
        return this;
    }







    public Table setForegroundHeader(Color foreground){
        headerTable.setForeground(foreground);
        return this;
    }

    public Table setTextFontHeader(PDFont textFont){
        headerTable.setTextFont(textFont);
        return this;
    }

    public Table setFontSizeHeader(int fontSize){
        headerTable.setFontSize(fontSize);
        return this;
    }

    public Table setColorCellHeader(Color colorCell){
        headerTable.setColorCell(colorCell);
        return this;
    }

    public Table setStartingPointRelativeHeader(int x, int y){
        headerTable.setStartingPointRelative(x,y);
        return this;
    }

    public Table setMarginColorHeader(Color marginColor){
        headerTable.setMarginColor(marginColor);
        return this;
    }

    public Table enableMarginHeader(){
        headerTable.enableMargin();
        return this;
    }

    public Table disableMarginHeader(){
        headerTable.disableMargin();
        return this;
    }

}

