package com.siven.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
    private Long deptNo;
    private String dname;
    private String db_source;
}
