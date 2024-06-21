package com.busanit501.boot501.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MemberJoinDTO {
    private String mid;
    private String mpw;
    private String email;
    private boolean del;
    private boolean social;
    //프로필 이미지
    private MultipartFile file;
}
