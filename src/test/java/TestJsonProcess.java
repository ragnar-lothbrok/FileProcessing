import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.home.common.enums.ParseEnum;
import com.home.common.model.IPToCountryBean;
import com.home.common.parser.CSVFileReader;
import com.home.common.parser.JSONFileReader;
import com.home.common.parser.XMLFileReader;
import com.home.common.service.JDBCDao;
import com.home.common.utility.FileUtility;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class TestJsonProcess {

    @Autowired
    CSVFileReader CSVFileReader;

    @Autowired
    XMLFileReader XMLFileReader;

    @Autowired
    JSONFileReader JSONFileReader;

    @Autowired
    JDBCDao jdbcDaoImpl;

    static List<IPToCountryBean> ipToCountryBeanList = null;

//    @Test
    public void readDataFromDatabase() throws IOException {
        ipToCountryBeanList = jdbcDaoImpl.fetch();
        System.out.println("Total Record fetched from DB : "
                + (ipToCountryBeanList == null ? 0 : ipToCountryBeanList.size()));
        convertJavaToJsonAndWriteInFile();
        convertJsonDataFromFileToJava();
        convertJavaToCSVAndWriteInFile();
        convertJavaToXMLAndWriteInFile();
    }

    public void convertJavaToJsonAndWriteInFile() throws IOException {
        Object jsonData = JSONFileReader.parseFromJavaObject(ipToCountryBeanList);
        System.out.println(FileUtility.writeToFile(jsonData, ParseEnum.JSON));
    }

    public void convertJsonDataFromFileToJava() throws IOException {
        File file = new File(ParseEnum.JSON + "."+ParseEnum.JSON.getFormat());
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Object jsonData = bufferedReader.readLine();
        jsonData = JSONFileReader.parsetoJavaObject(jsonData);
        if (jsonData != null) {
            System.out.println("Total Records fetched from JSON File : " + ((List<IPToCountryBean>) jsonData).size());
        }
    }

    public void convertJavaToCSVAndWriteInFile() throws IOException {
        Object csvData = CSVFileReader.parseFromJavaObject(ipToCountryBeanList);
        System.out.println(FileUtility.writeToFile(csvData, ParseEnum.CSV));
    }

    public void convertJavaToXMLAndWriteInFile() throws IOException {
        Object xmlData = XMLFileReader.parseFromJavaObject(ipToCountryBeanList);
        System.out.println(FileUtility.writeToFile(xmlData, ParseEnum.XML));
    }

    @Test
    public void convertXMLDataFromFileToJava() throws IOException {
        File file = new File(ParseEnum.XML + "."+ParseEnum.XML.getFormat());
        Object xmlData = XMLFileReader.parsetoJavaObject(file);
        if(xmlData != null){
            System.out.println("Total Records fetched from XML File : " + ((List<IPToCountryBean>) xmlData).size());
        }
    }

    public void convertCSVDataFromFileToJava() throws IOException {
        File file = new File(ParseEnum.CSV + "."+ParseEnum.CSV.getFormat());
        FileReader fileReader = new FileReader(file);
        Object jsonData = CSVFileReader.parsetoJavaObject(fileReader);
        if (jsonData != null) {
            System.out.println("Total Records fetched from CSV File : " + ((List<IPToCountryBean>) jsonData).size());
        }
    }
}
