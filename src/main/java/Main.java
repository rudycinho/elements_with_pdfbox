import additional.Pair;
import basic.Style;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import table.Column;
import table.RecursiveTable;
import table.Table;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static String DESTINO = "/home/rudy";
    private static String ARCHIVO = "index.pdf";

    public static void main(String [] args) throws IOException {

        int maxX = (int) PDRectangle.LETTER.getHeight();
        int maxY = (int) PDRectangle.LETTER.getWidth();

        PDDocument document = new PDDocument();
        PDPage page = new PDPage(new PDRectangle(maxX,maxY));
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        /*CellText cellText =
                new CellText(200,200,100,30)
                .setText("Rudy Walter Martinez Melgarejo")
                .setColorCell(Color.YELLOW)
                .setMarginColor(Color.RED)
                .disableMargin();

        cellText.build(contentStream);*/

        /*List<Pair<String,Integer>> list = new ArrayList<>();
        list.add(new Pair<>("Rudy1",30));
        list.add(new Pair<>("Rudy2",40));
        list.add(new Pair<>("Rudy3",310));
        list.add(new Pair<>("Rudy4",130));
        list.add(new Pair<>("Rudy5",3));

        Column column = new Column(30,200, 30, list)
                .setColorCell(Color.BLUE)
                .disableMargin()
                .setForeground(Color.WHITE);
        column.build(contentStream);*/

        List<Integer> widths = new ArrayList<>();
        widths.add(140);
        widths.add(120);
        widths.add(150);
        widths.add(220);

        List wi = new ArrayList<>();
        wi.add(400);

        List<String> lString = Arrays.asList(new String[]{"Rudy HEADER"});
        //List<String> lString = Arrays.asList(new String[]{"Rudy HEADER","Martinez HEADER","Wolter HEADER","Melgarejo HEADER"});

        List<List<String>> llString = new ArrayList<>();
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        /*llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));
        llString.add(Arrays.asList(new String[]{"Rudy","Martinez","Wolter","Melgarejo"}));*/


        Table table = new Table(30,200, 30,lString,wi ,llString,widths);
        table.build(contentStream);

        /*List<PDPageContentStream> contentsStream = new ArrayList<>();

        RecursiveTable table = new RecursiveTable(30,200, 30,650,maxX,maxY,lString,llString,widths);
        table.setColorCellHeader(Color.ORANGE);
        table.setFontSizeHeader(12);
        table.setTextFontHeader(PDType1Font.HELVETICA_BOLD);

        table.setTextFontBody(PDType1Font.HELVETICA_OBLIQUE);
        table.build(contentStream,document,contentsStream);
*/

        contentStream.close();
        //for(PDPageContentStream c : contentsStream)
        //    c.close();

        document.save(new File(String.format("%s%s%s",DESTINO,"/",ARCHIVO)));
        document.close();
    }
}
