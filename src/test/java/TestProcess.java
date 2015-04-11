import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.MappedByteBuffer;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.home.common.enums.ParseEnum;
import com.home.common.filereading.approach2.FileChunk;
import com.home.common.filereading.approach2.FileReadService;
import com.home.common.model.IPToCountryBean;
import com.home.common.parser.CSVFileReader;
import com.home.common.parser.JSONFileReader;
import com.home.common.parser.XMLFileReader;
import com.home.common.service.JDBCDao;
import com.home.common.utility.FileUtility;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class TestProcess {

    @Autowired
    CSVFileReader CSVFileReader;

    @Autowired
    XMLFileReader XMLFileReader;

    @Autowired
    JSONFileReader JSONFileReader;

    @Autowired
    JDBCDao jdbcDaoImpl;

    @Autowired
    FileReadService fileReadService;

    static List<IPToCountryBean> ipToCountryBeanList = null;

//    @Test
    public void readDataFromDatabase() throws IOException {
        ipToCountryBeanList = jdbcDaoImpl.fetch();
        System.out.println("Total Record fetched from DB : "
                + (ipToCountryBeanList == null ? 0 : ipToCountryBeanList.size()));
        convertJavaToCSVAndWriteInFile();
    }

    public void convertJavaToJsonAndWriteInFile() throws IOException {
        Object jsonData = JSONFileReader.parseFromJavaObject(ipToCountryBeanList);
        System.out.println(jsonData);
        System.out.println(FileUtility.writeToFile(jsonData, ParseEnum.JSON));
    }

    public void convertJsonDataFromFileToJava() throws IOException {
        File file = new File(ParseEnum.JSON + "." + ParseEnum.JSON.getFormat());
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Object jsonData = bufferedReader.readLine();
        jsonData = JSONFileReader.parsetoJavaObject(jsonData);
        if (jsonData != null) {
            System.out.println("Total Records fetched from JSON File : " + ((List<IPToCountryBean>) jsonData).size());
        }
    }

    public void convertJavaToCSVAndWriteInFile() {
        try {
            Object csvData = CSVFileReader.parseFromJavaObject(ipToCountryBeanList);
            int count = 1;
            StringBuffer sb = new StringBuffer(csvData.toString());
            while (count > 0) {
                sb.append("\n" + csvData.toString());
                count--;
            }
            System.out.println(FileUtility.writeToFile(sb, ParseEnum.CSV));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void convertJavaToXMLAndWriteInFile() throws IOException {
        Object xmlData = XMLFileReader.parseFromJavaObject(ipToCountryBeanList);
        System.out.println(FileUtility.writeToFile(xmlData, ParseEnum.XML));
    }

    // @Test
    public void convertXMLDataFromFileToJava() throws IOException {
        File file = new File(ParseEnum.XML + "." + ParseEnum.XML.getFormat());
        Object xmlData = XMLFileReader.parsetoJavaObject(file);
        if (xmlData != null) {
            System.out.println("Total Records fetched from XML File : " + ((List<IPToCountryBean>) xmlData).size());
        }
    }

    public void convertCSVDataFromFileToJava() throws IOException {
        File file = new File(ParseEnum.CSV + "." + ParseEnum.CSV.getFormat());
        FileReader fileReader = new FileReader(file);
        Object jsonData = CSVFileReader.parsetoJavaObject(fileReader);
        if (jsonData != null) {
            System.out.println("Total Records fetched from CSV File : " + ((List<IPToCountryBean>) jsonData).size());
        }
    }

    // @Test
    public void readFile() {
        // List<FileChunk> fileContent = fileReadService.readFile(ParseEnum.CSV
        // + "." + ParseEnum.CSV.getFormat(), null);
        List<FileChunk> fileContent = fileReadService.readFile(ParseEnum.JSON + "." + ParseEnum.JSON.getFormat(), null);
        Collections.sort(fileContent);
        System.out.println("Size : " + fileContent.size() + " Content : " + fileContent);

        if (fileContent.size() > 0) {
            for (FileChunk fileChunk : fileContent) {
                ((MappedByteBuffer) fileChunk.getBuffer()).load();
                for (int i = 0; i < ((MappedByteBuffer) fileChunk.getBuffer()).limit(); i++) {
                    System.out.print((char) ((MappedByteBuffer) fileChunk.getBuffer()).get());
                }
                break;
            }
        }

    }

     @Test
    public void testMongo() {
        try {
            MongoClient mongo = new MongoClient("localhost", 27017);
            DB db = mongo.getDB("users");
            DBCollection table = db.getCollection("links");
            fetchFromMongo(table);
            insertIntoMongo(table);
            removeFromMongo(table);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * Insert into mongo DB.
     * 
     * @param table
     */
    public void insertIntoMongo(DBCollection table) {
        BasicDBObject newObject = new BasicDBObject();
        BasicDBObject subObject = new BasicDBObject();
        subObject.put("first", "Major");
        subObject.put("last", "general");
        newObject.put("name", subObject);
        newObject.put("age", 30);
        WriteResult writeResult = table.insert(newObject);
        System.out.println(writeResult.getError());
    }

    public void fetchFromMongo(DBCollection table) {

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name.first", "Jacky");

        DBCursor cursor = table.find(searchQuery);

        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

    public void removeFromMongo(DBCollection table) {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("age", 30);
        WriteResult writeResult = table.remove(searchQuery);
        System.out.println(writeResult.getError());
    }
}
