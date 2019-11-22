package cn.dzy.manage.boss.manage.dao;

import cn.dzy.manage.boss.manage.bean.Fabulous;
import cn.dzy.manage.boss.manage.bean.book.BookCollectionDetailed;
import cn.dzy.manage.boss.manage.bean.user.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FabulousDao {
    //新增一条点赞数据
    @Insert("INSERT INTO fabulous\n" +
            "\t(book_collection_detailed_id, user_id)\n" +
            "\tVALUES (#{bookCollectionDetailedId}, #{userId})")
    void add(int bookCollectionDetailedId, int userId);

    //根据点赞di获取点赞信息
    @Select("SELECT id, book_collection_detailed_id, user_id, create_time, update_time\n" +
            "\tFROM fabulous WHERE id = #{id}")
    Fabulous getInfoById(int id);

    //获取最新一条点赞信息
    @Select("SELECT id, book_collection_detailed_id, user_id, create_time, update_time\n" +
            "\tFROM fabulous order BY id DESC LIMIT 1")
    Fabulous getLastInfo();

    //根据点赞id取消点赞
    @Delete("DELETE FROM fabulous WHERE id = #{id}")
    void delete(int id);

    //根据用户id和书单详情id获取点赞信息(如果没有信息的话就说明该用户没有点赞过这个书单详情，反之则有)
    @Select("SELECT  f.book_collection_detailed_id,bcd.book_id\tFROM fabulous f INNER JOIN book_collection_detailed bcd ON\n" +
            "bcd.id = f.book_collection_detailed_id AND f.book_collection_detailed_id = #{detailedId} AND f.user_id = #{userId}\n")
    BookCollectionDetailed getFabulousByUserIdAndDetailedId(int userId, int detailedId);


    @Select("SELECT  f.id,f.book_collection_detailed_id,bcd.book_id\tFROM fabulous f INNER JOIN book_collection_detailed bcd ON\n" +
            "bcd.id = f.book_collection_detailed_id AND f.book_collection_detailed_id = #{detailedId} AND f.user_id = #{userId}\n")
    Fabulous get(int userId, int detailedId);

    @Select("SELECT u.user_id,u.name,u.sex,u.open_id,u.phone,u.sell_fee,u.login_status,u.disabled_status,u.header_img FROM fabulous INNER JOIN user u ON u.user_id = fabulous.user_id AND  fabulous.book_collection_detailed_id = #{id}")
    List<User> getUp(int id);

}
