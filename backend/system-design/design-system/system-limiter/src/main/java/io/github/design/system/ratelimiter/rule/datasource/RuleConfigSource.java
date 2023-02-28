package io.github.design.system.ratelimiter.rule.datasource;

import io.github.design.system.ratelimiter.rule.RuleConfig;

/**
 * @author T04856 <br>
 * @create 2023-02-28 10:58 AM <br>
 * @project system-design <br>
 */
public interface RuleConfigSource {
    RuleConfig load();
}
