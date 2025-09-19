package com.codegym.demo1.bt.ungdungnghenhac.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SongRequest {
    private Integer id;
    private String name;
    private String artist;
    private String genre;
    private MultipartFile link;
}
