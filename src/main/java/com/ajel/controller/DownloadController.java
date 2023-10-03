package com.ajel.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class DownloadController {
    

    @GetMapping(path = "/download")
    public void download(@RequestParam("filePath") String filePath, HttpServletResponse response) throws IOException {

        System.out.println(filePath);
        String[] split = filePath.split("\\\\");
        response.setHeader("Content-Disposition", "inline;filename=" + split[split.length -1]);
        response.setContentType(MimeTypeUtils.IMAGE_JPEG_VALUE);

       String pathReplace = filePath.replaceAll("\\\\", "//");
        Path path = Paths.get(File.separator +"mnt"+File.separator+"winthor"+  pathReplace);       
        
        try (InputStream is = new FileInputStream(path.toFile())) {
            OutputStream os = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        
    }

}
