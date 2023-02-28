package io.github.design.system.ratelimiter.rule.datasource;

import io.github.design.system.ratelimiter.rule.RuleConfig;
import io.github.design.system.ratelimiter.rule.parser.JsonRuleConfigParser;
import io.github.design.system.ratelimiter.rule.parser.RuleConfigParser;
import io.github.design.system.ratelimiter.rule.parser.YamlRuleConfigParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author T04856 <br>
 * @create 2023-02-28 10:58 AM <br>
 * @project system-design <br>
 */
public class FileRuleConfigSource implements RuleConfigSource {
    private static final String API_LIMIT_CONFIG_GAME = "ratelimiter-rule";

    private static final String YAML_EXTENSION = "yaml";
    private static final String JSON_EXTENSION = "json";

    private static final String[] SUPPORT_EXTENSION = new String[] {YAML_EXTENSION, JSON_EXTENSION};
    private static final Map<String, RuleConfigParser> PARSER_MAP = new HashMap<>();

    static {
        PARSER_MAP.put(YAML_EXTENSION, new YamlRuleConfigParser());
        PARSER_MAP.put(JSON_EXTENSION, new JsonRuleConfigParser());
    }

    @Override
    public RuleConfig load() {
        for (String extension : SUPPORT_EXTENSION) {
            InputStream in = null;
            try {
                in = this.getClass().getResourceAsStream("/" + getFileNameByExt(extension));
                if (in != null) {
                    RuleConfigParser parser = PARSER_MAP.get(extension);
                    return parser.parse(in);
                }
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    private String getFileNameByExt(String extension) {
        return API_LIMIT_CONFIG_GAME + "." + extension;
    }
}
