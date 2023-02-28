package io.github.design.system.ratelimiter.rule;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author T04856 <br>
 * @create 2023-02-28 10:57 AM <br>
 * @project system-design <br>
 */
@Data
@NoArgsConstructor
public abstract class AbstractRateLimitRule {

    public abstract ApiLimit getLimit(String appId, String url);
}
