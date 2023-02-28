package io.github.design.system.ratelimiter.rule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author T04856 <br>
 * @create 2023-02-28 10:56 AM <br>
 * @project system-design <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiLimit {
    private static final int DEFAULT_TIME_UNIT = 1; // 1 second
    private String api;
    private int limit;
    private int unit = DEFAULT_TIME_UNIT;
}
