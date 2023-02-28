package io.github.design.system.ratelimiter.rule;

/**
 * 支持按照 URL 快速查询的数据结构
 *
 * <pre>
 *    1. 考虑到 URL 的重复度比较高, 且需要按照前缀来匹配,  选择使用 Trie 树这种数据结构
 *    2. 不能使用正则进行匹配: 效率低下且性能不高
 * </pre>
 *
 * @author T04856 <br>
 * @create 2023-02-28 10:57 AM <br>
 * @project system-design <br>
 */
public class TrieRateLimitRule extends AbstractRateLimitRule {

    private RuleConfig ruleConfig;

    public TrieRateLimitRule(RuleConfig ruleConfig) {
        this.ruleConfig = ruleConfig;
    }

    @Override
    public ApiLimit getLimit(String appId, String url) {
        return null;
    }
}
