package com.edu.audit.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: InstallationStep
 * @Description: 施工步骤
 * @Author: Vince
 * @Date: 2020/5/6 17:29
 * @Version: v1.0
 */
@Data
@NoArgsConstructor
public class InstallationStep {
    private String title;
    @JsonFormat(timezone = "GMT-5",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date description;
    private Integer installationId;
}
