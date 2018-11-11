package org.rocktrot.race.billboard;

import org.rocktrot.race.billboard.data.CategoryResults;
import org.rocktrot.race.billboard.data.LeaderBoardData;
import org.rocktrot.race.billboard.data.Result;
import org.rocktrot.race.billboard.storage.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@RestController
public class ResultsService {
    DataService data;
    private final StorageService storageService;

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    public ResultsService(StorageService storageService) {
        this.storageService = storageService;
        data = new DataService();
    }


    @RequestMapping("/api/results")
    public LeaderBoardData retrieveResults(){
        LeaderBoardData resultData = new LeaderBoardData(data.results.getAllResults(),data.latestTimestamp);
        return resultData;
    }


    @RequestMapping("/api/reset")
    public String resetResults(){
        log.info("Resetting Data");
        data.reset();
        return "reset";
    }

    @PostMapping("/api/result")
    public void postResult(@RequestBody Result res){
        data.addResult(res);

    }

    @PostMapping("/api/upload")
    public String handleFileUpload(@RequestParam("key") String key, @RequestParam("file") MultipartFile file) {
        String result;
        log.info("Received uploaded file");
        if(key!= null && key.equals("rockleaders")) {
            storageService.store(file);
            result = "complete";
            try {
                dataImporter.importData(file, data);
            } catch (IOException ioe) {
                log.error("Could not read uploaded file", ioe.getLocalizedMessage());
                result = "error uploading";
            }
        } else {
            log.error("invalid key!!");
            result = "invalid key";
        }

        return result;
    }
}
