package io.github.design.system.ratelimiter.rule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author T04856 <br>
 * @create 2023-02-28 10:56 AM <br>
 * @project system-design <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RuleConfig {
    private String appId;
    private List<ApiLimit> limitList;
}
