package cn.dzy.manage.boss.manage.bean;

import lombok.Data;

@Data
public class Pager {
    //分页数据
    private  Integer index;//当前所在页数
    private  Integer size;//每页数据多少
    private  Integer total;//总数据
    private  Integer totalPage;//总页数
}
