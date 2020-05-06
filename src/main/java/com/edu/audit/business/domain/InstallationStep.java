package com.edu.audit.business.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String description;
    private Integer installationId;
}
