package org.rocktrot.race.billboard;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.rocktrot.race.billboard.data.Result;
import org.springframework.web.client.RestTemplate;

import java.io.*;

public class dataImporter {


    public static void main(String[] args) {

        try {
            readFile(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readFile(String path) throws IOException {
        RestTemplate ds = new RestTemplate();
        String url = "http://localhost:8080/api/result";
        Result result;
        Reader in = new FileReader(path);
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
        for (CSVRecord csvRecord : records) {
            result = new Result(csvRecord.get("firstname") + " " + csvRecord.get("lastname"),
                    csvRecord.get("BIB"),
                    Integer.parseInt(csvRecord.get("AGE")),
                    csvRecord.get("gender"),
                    csvRecord.get("chiptime"));
            ds.postForLocation(url,result);
        }

    }
}
