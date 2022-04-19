import model.Statistics;
import service.*;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

//        XlsWriter xlsWriter = new XlsWriter();
//        xlsWriter.writeStatistics(StatisticsProcessUtil.collectStatistics(Reader.readStudent(),Reader.readUniversity()),"statistics.xlsx");
        XmlSerializer xmlSerializer = new XmlSerializer();
        String xml = xmlSerializer.createXml(Reader.readStudent(), Reader.readUniversity(), new ArrayList<>(StatisticsProcessUtil.collectStatistics(Reader.readStudent(), Reader.readUniversity())));
        System.out.println(xml);
        JsonSerializer jsonSerializer = new JsonSerializer();
        jsonSerializer.createJson(xml);



    }
}
