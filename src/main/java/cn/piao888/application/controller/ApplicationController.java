package cn.piao888.application.controller;

import cn.piao888.application.bean.MusicBean;
import cn.piao888.application.bean.MusicCollectionBean;
import cn.piao888.application.vo.ApiResponse;
import cn.piao888.application.vo.MusicCollectionRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author： hongzhi.xu
 * @Date: 2024/9/8 22:30
 * @Version 1.0
 */
@RestController
@RequestMapping("/application")
public class ApplicationController {

    @GetMapping("/getMusicBean")
    public ApiResponse<List<MusicBean>> getMusicBean(int pageNumber, int pageSize) {
        int startNum = pageSize * (pageNumber - 1);
        int endNum = startNum + pageSize;

        List<MusicBean> musicBeansResult = new ArrayList<>();
        // 假设 pictures 是一个类成员变量，并且已经正确初始化
        for (int i = startNum; i < endNum; i++) {
            int point =  (int) (Math.random() * 100) % 2;
            MusicBean musicBean = new MusicBean("晴天", "周杰伦"+i, point == 1);
            musicBeansResult.add(musicBean);
        }
        return new ApiResponse(musicBeansResult);
    }

    private String[] pictures = new String[]{"https://ns-strategy.cdn.bcebos.com/ns-strategy/upload/fc_big_pic/part-00255-1149.jpg", "https://img0.baidu.com/it/u=1626006458,3105647236&fm=253&fmt=auto&app=120&f=JPEG?w=667&h=500"
            , "https://img2.baidu.com/it/u=3233674257,3277114296&fm=253&fmt=auto&app=120&f=JPEG?w=667&h=500"};

    @PostMapping("/getMusicCollectionBean")
    public ApiResponse<List<MusicCollectionBean>> getMusicCollectionBean(@RequestBody MusicCollectionRequest musicCollectionRequest) {
        List<MusicCollectionBean> musicCollectionResult = new ArrayList<>();
        int pageNumber = musicCollectionRequest.getPageNumber().intValue();
        int pageSize = musicCollectionRequest.getPageSize().intValue();

        if (pageNumber <= 0 || pageSize <= 0) {
            return new ApiResponse<>(Collections.emptyList(), 400, "false");
        }

        int startNum = pageSize * (pageNumber - 1);
        int endNum = startNum + pageSize;

        // 假设 pictures 是一个类成员变量，并且已经正确初始化
        for (int i = startNum; i < endNum; i++) {
            int point = i % pictures.length;
            MusicCollectionBean musicCollectionBean = new MusicCollectionBean(
                    pictures[point],
                    "晴天" + (i + 1),
                    "周杰伦" + (i + 1)
            );
            musicCollectionResult.add(musicCollectionBean);
        }

        return new ApiResponse<>(musicCollectionResult);
    }

}
