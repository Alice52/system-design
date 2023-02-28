package io.github.design.system.ratelimiter;

import io.github.design.system.ratelimiter.alg.RateLimitAlg;
import io.github.design.system.ratelimiter.rule.AbstractRateLimitRule;
import io.github.design.system.ratelimiter.rule.ApiLimit;
import io.github.design.system.ratelimiter.rule.RuleConfig;
import io.github.design.system.ratelimiter.rule.TrieRateLimitRule;
import io.github.design.system.ratelimiter.rule.datasource.FileRuleConfigSource;
import io.github.design.system.ratelimiter.rule.datasource.RuleConfigSource;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author T04856 <br>
 * @create 2023-02-28 10:56 AM <br>
 * @project system-design <br>
 */
@Slf4j
public class Ratelimiter {

    // 为每个api在内存中存储限流计数器
    private Map<String, RateLimitAlg> counters = new ConcurrentHashMap<>();
    private AbstractRateLimitRule rule;

    public Ratelimiter() {
        // 改动主要在这里：调用RuleConfigSource类来实现配置加载
        RuleConfigSource configSource = new FileRuleConfigSource();
        RuleConfig ruleConfig = configSource.load();
        this.rule = new TrieRateLimitRule(ruleConfig);
    }

    public boolean limit(String appId, String url) {
        ApiLimit apiLimit = rule.getLimit(appId, url);
        if (apiLimit == null) {
            return true;
        }

        // 获取api对应在内存中的限流计数器(rateLimitCounter)
        String counterKey = appId + ":" + apiLimit.getApi();
        RateLimitAlg rateLimitAlg = counters.get(counterKey);
        if (rateLimitAlg == null) {
            rateLimitAlg =
                    counters.computeIfAbsent(
                            counterKey, a -> new RateLimitAlg(apiLimit.getLimit()));
        }
        // 判断是否限流
        return rateLimitAlg.tryAcquire();
    }
}
