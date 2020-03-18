package table;

import additional.Pair;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecursiveTable {
    private RecursiveTable anotherTable;
    private int startingPointMarginX;
    private int startingPointMarginY;
    private int height;

    private int maxX;
    private int maxY;

    private int limY;

    private Column headerTable;
    private List<Column> bodyTable;

    public RecursiveTable(
            int x0, int y0, int height,
            int limY,
            int maxX, int maxY,
            List<String> contentHeaderTable,
            List<List<String>> contentBodyTable,
            List<Integer> widths) {

        this.startingPointMarginX = x0;
        this.startingPointMarginY = y0;
        this.height = height;
        bodyTable = new ArrayList<>();

        this.maxX = maxX;
        this.maxY = maxY;
        this.limY = limY;

        headerTable = createColumn(startingPointMarginX,startingPointMarginY,height,contentHeaderTable,widths);
        Iterator<List<String>> it = contentBodyTable.iterator();

        boolean flag = false;

        int auxY = startingPointMarginY;
        while (it.hasNext() && !flag){
            auxY -= height;
            bodyTable.add(createColumn(startingPointMarginX,auxY,height,it.next(),widths));
            if(auxY <= (maxX-this.limY))
                flag = true;
        }

        if(it.hasNext())
            anotherTable = new RecursiveTable(30,maxY-50, this.height,limY,maxX,maxY, contentHeaderTable, it,widths);
    }

    public RecursiveTable(
            int x0, int y0, int height,
            int limY,
            int maxX, int maxY,
            List<String> contentHeaderTable,
            Iterator<List<String>> contentBodyTableIt,
            List<Integer> widths) {

        this.startingPointMarginX = x0;
        this.startingPointMarginY = y0;
        this.height = height;
        bodyTable = new ArrayList<>();

        this.maxX = maxX;
        this.maxY = maxY;
        this.limY = limY;

        headerTable = createColumn(startingPointMarginX,startingPointMarginY,height,contentHeaderTable,widths);

        boolean flag = false;

        int auxY = startingPointMarginY;
        while (contentBodyTableIt.hasNext() && !flag){
            auxY -= height;
            bodyTable.add(createColumn(startingPointMarginX,auxY,height,contentBodyTableIt.next(),widths));
            if(auxY <= (maxX-limY))
                flag = true;
        }

        if(contentBodyTableIt.hasNext())
            anotherTable = new RecursiveTable(30,maxY-50, height,limY,maxX,maxY, contentHeaderTable, contentBodyTableIt,widths);
    }

    private Column createColumn(int x0, int y0, int height,List<String> stringList, List<Integer> integerList) {
        List<Pair<String,Integer>> list = new ArrayList<>();
        for(int i=0;i<integerList.size();i++){
            list.add(new Pair(stringList.get(i),integerList.get(i)));
        }
        return new Column(x0,y0,height,list);
    }

    public void build(PDPageContentStream contentStream,
                      PDDocument document,
                      List<PDPageContentStream> contentsStream) throws IOException {

        headerTable.build(contentStream);
        for(Column column : bodyTable)
            column.build(contentStream);

        contentsStream.add(contentStream);
        if(anotherTable!=null){
            PDPage page= new PDPage(new PDRectangle(maxX, maxY));
            document.addPage(page);
            PDPageContentStream otherContentStream = new PDPageContentStream(document, page);
            anotherTable.build(otherContentStream,document,contentsStream);
        }
    }


    public RecursiveTable setForegroundBody(Color foreground){
        bodyTable.forEach(e -> e.setForeground(foreground));
        if(anotherTable!=null) anotherTable.setForegroundBody(foreground);
        return this;
    }

    public RecursiveTable setTextFontBody(PDFont textFont){
        bodyTable.forEach(e -> e.setTextFont(textFont));
        if(anotherTable!=null) anotherTable.setTextFontBody(textFont);
        return this;
    }

    public RecursiveTable setFontSizeBody(int fontSize){
        bodyTable.forEach(e -> e.setFontSize(fontSize));
        if(anotherTable!=null) anotherTable.setFontSizeBody(fontSize);
        return this;
    }

    public RecursiveTable setColorCellBody(Color colorCell){
        bodyTable.forEach(e -> e.setColorCell(colorCell));
        if(anotherTable!=null) anotherTable.setColorCellBody(colorCell);
        return this;
    }

    public RecursiveTable setStartingPointRelativeBody(int x, int y){
        bodyTable.forEach(e -> e.setStartingPointRelative(x,y));
        if(anotherTable!=null) anotherTable.setStartingPointRelativeBody(x,y);
        return this;
    }

    public RecursiveTable setMarginColorBody(Color marginColor){
        bodyTable.forEach(e -> e.setMarginColor(marginColor));
        if(anotherTable!=null) anotherTable.setMarginColorBody(marginColor);
        return this;
    }

    public RecursiveTable enableMarginBody(){
        bodyTable.forEach(e -> e.enableMargin());
        if(anotherTable!=null) anotherTable.enableMarginBody();
        return this;
    }

    public RecursiveTable disableMarginBody(){
        bodyTable.forEach(e -> e.disableMargin());
        if(anotherTable!=null) anotherTable.disableMarginBody();
        return this;
    }







    public RecursiveTable setForegroundHeader(Color foreground){
        headerTable.setForeground(foreground);
        if(anotherTable!=null) anotherTable.setForegroundHeader(foreground);
        return this;
    }

    public RecursiveTable setTextFontHeader(PDFont textFont){
        headerTable.setTextFont(textFont);
        if(anotherTable!=null) anotherTable.setTextFontHeader(textFont);
        return this;
    }

    public RecursiveTable setFontSizeHeader(int fontSize){
        headerTable.setFontSize(fontSize);
        if(anotherTable!=null) anotherTable.setFontSizeHeader(fontSize);
        return this;
    }

    public RecursiveTable setColorCellHeader(Color colorCell){
        headerTable.setColorCell(colorCell);
        if(anotherTable!=null) anotherTable.setColorCellHeader(colorCell);
        return this;
    }

    public RecursiveTable setStartingPointRelativeHeader(int x, int y){
        headerTable.setStartingPointRelative(x,y);
        if(anotherTable!=null) anotherTable.setStartingPointRelativeHeader(x,y);
        return this;
    }

    public RecursiveTable setMarginColorHeader(Color marginColor){
        headerTable.setMarginColor(marginColor);
        if(anotherTable!=null) anotherTable.setMarginColorHeader(marginColor);
        return this;
    }

    public RecursiveTable enableMarginHeader(){
        headerTable.enableMargin();
        if(anotherTable!=null) anotherTable.enableMarginHeader();
        return this;
    }

    public RecursiveTable disableMarginHeader(){
        headerTable.disableMargin();
        if(anotherTable!=null) anotherTable.disableMarginHeader();
        return this;
    }

}
