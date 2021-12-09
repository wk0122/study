package com.wk.poi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author wangkang
 * @Date 2021/11/16 15:18
 */
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/api/file/onlinePreview")
    public void onlinePreview(@RequestParam("url") String url, HttpServletResponse response) throws Exception{
        fileService.onlinePreview(url,response);
    }
}
