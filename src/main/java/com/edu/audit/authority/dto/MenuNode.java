package com.edu.audit.authority.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @ClassName: MenuNode
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/5/10 13:43
 * @Version: v1.0
 */
@ApiModel("子节点")
@Data
public class MenuNode {
    private String id;
    private String label;
}
