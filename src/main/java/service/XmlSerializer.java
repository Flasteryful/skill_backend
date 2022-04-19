package service;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import model.Statistics;
import model.Student;
import model.University;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

public class XmlSerializer {
    private static final Logger log = (Logger) LoggerFactory.getLogger(XmlSerializer.class);

    @EqualsAndHashCode
    @Getter
    @Setter
    @XStreamAlias("root")
    static
    class XmlStructure {

        @XStreamAlias("studentsInfo")
        private List<Student> studentsInfo;

        @XStreamAlias("universitiesInfo")
        private List<University> universitiesInfo;

        @XStreamAlias("statisticalInfo")
        private List<Statistics> statisticalInfo;

        @XStreamAlias("processedAt")
        private LocalDateTime processedAt;
    }

    public String createXml(List<Student> studentsInfo, List<University> universitiesInfo, List<Statistics> statisticalInfo) {
        XmlStructure xmlStructure = new XmlStructure();
        Path path = Paths.get("xml_files");
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String filePath = "xml_files/xmlReq_" + LocalDateTime.now().toString().substring(0, 19).replace(":","_") + ".xml";
        xmlStructure.setStudentsInfo(studentsInfo);
        xmlStructure.setUniversitiesInfo(universitiesInfo);
        xmlStructure.setStatisticalInfo(statisticalInfo);
        xmlStructure.setProcessedAt(LocalDateTime.now());
        XStream xstream = new XStream();
        xstream.processAnnotations(XmlStructure.class);
        String result = xstream.toXML(xmlStructure);
        try {
            FileWriter writer = new FileWriter(filePath, false);
            writer.write(result);
            writer.flush();
            log.info("Xml writed in file " + filePath);
        } catch (IOException e) {
            log.error("Xml not writed in file - " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
