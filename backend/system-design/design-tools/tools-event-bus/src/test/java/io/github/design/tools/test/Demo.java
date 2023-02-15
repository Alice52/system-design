package io.github.design.tools.test;

import com.google.common.collect.Lists;
import lombok.val;

/**
 * @author T04856 <br>
 * @create 2023-02-15 8:52 AM <br>
 * @project system-design <br>
 */
public class Demo {
    public static void main(String[] args) {
        UserService userService = new UserService();

        val observer = new Observer();
        userService.setRegObservers(Lists.newArrayList(observer));
        userService.action("手机号", "姓名");
    }
}
