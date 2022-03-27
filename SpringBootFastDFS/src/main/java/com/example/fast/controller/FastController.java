package com.example.fast.controller;

import com.example.fast.entity.Fast;
import com.example.fast.service.IFastService;
import com.example.util.FastDFSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shyheng
 * @since 2022-03-27
 */
@Controller
public class FastController {

    @Autowired
    IFastService iFastService;

    @RequestMapping("/")
    public String index(Model model){
        List<Fast> list = iFastService.list();
        model.addAttribute("list",list);
        return "index";
    }

    @RequestMapping("/upload/{id}")
    public String toUpload(@PathVariable Integer id,Model model){
        Map map = new HashMap();
        map.put("id",id);
        List<Fast> fasts = iFastService.listByMap(map);
        model.addAttribute("info",fasts.get(0));
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(Integer id, MultipartFile myf,Model model) throws IOException {
//        获取字节
        byte[] buff = myf.getBytes();
//        获取文件名
        String fileName = myf.getOriginalFilename();
//        拓展名
        String fileEx = fileName.substring(fileName.lastIndexOf(".")+1);
//        获取文件字节
        Long size = myf.getSize();
//        上传
        String[] update = FastDFSUtil.update(buff, fileEx);
//        上传数据库
        Fast fast = new Fast(id,update[0],update[1],fileName,size);
        iFastService.saveOrUpdate(fast);
        model.addAttribute("msg","上传成功,点击确定返回列表");
        model.addAttribute("url","/");
        return "success";
    }

    @RequestMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Integer id){
        Map map = new HashMap();
        map.put("id",id);
        List<Fast> fasts = iFastService.listByMap(map);
        Fast fast = fasts.get(0);
        byte[] download = FastDFSUtil.download(fast.getGroupName(), fast.getRemoteFile());

//        响应头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);//设置响应头类型
        httpHeaders.setContentLength(fast.getFileSize());//自动提供下载速度
//        下载时的文件名
        httpHeaders.setContentDispositionFormData("attachment",fast.getOldFile());

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(download,httpHeaders, HttpStatus.OK);

        return responseEntity;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        iFastService.delete(id);
        return "redirect:/";
    }
}
