package io.github.design.system.ratelimiter.rule.parser;

import io.github.design.system.ratelimiter.rule.RuleConfig;

import java.io.InputStream;

/**
 * @author T04856 <br>
 * @create 2023-02-28 10:57 AM <br>
 * @project system-design <br>
 */
public interface RuleConfigParser {
    RuleConfig parse(String condigText);

    RuleConfig parse(InputStream in);
}
