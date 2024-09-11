package cn.piao888.application.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MusicBean {
    private String musicName;
    private String singerName;
    private Boolean isLike;
}
