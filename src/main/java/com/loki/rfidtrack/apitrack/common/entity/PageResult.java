package com.loki.rfidtrack.apitrack.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: Loki.C
 * @date:Created in 2019/2/8 16:01
 * @description: 分页实体
 * @modified by:
 * @version:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult <T>{
    private long total;
    private List<T> rows;
}
