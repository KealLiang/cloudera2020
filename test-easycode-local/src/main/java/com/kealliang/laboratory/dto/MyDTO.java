package com.kealliang.laboratory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lsr
 * @ClassName MyDTO
 * @Date 2020-04-11
 * @Vertion 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MyDTO {
    private String name;
    private Integer size;
    private Date birthday;
    private String comment;
}
