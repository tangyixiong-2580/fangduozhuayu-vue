package cn.dzy.manage.boss.manage.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BizResult {
    //状态码 0：成功 其他说明业务有问题
    private Integer code;
    //状态码
    private String desc;
    //数据
    private Object data;
}
