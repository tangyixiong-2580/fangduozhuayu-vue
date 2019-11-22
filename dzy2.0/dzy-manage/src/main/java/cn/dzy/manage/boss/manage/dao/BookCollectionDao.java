package cn.dzy.manage.boss.manage.dao;

import cn.dzy.manage.boss.manage.bean.book.BookCollection;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface BookCollectionDao {
    //获取前5条书单
    @Select("SELECT GROUP_CONCAT(bcd.user_id) as userId,priority,bc.id, bc.name, bc.image,bc.bg_color as bgColor ,bc.intro, bc.create_time as createTime, bc.update_time,bc.expired_time as expiredTime,COUNT(DISTINCT bcd.user_id) AS recommendCount, COUNT(bcd.book_id) AS bookCount\n" +
            "FROM book_collection bc\n" +
            "LEFT JOIN book_collection_detailed bcd ON bcd.book_collection_id = bc.id\n" +
            "GROUP BY bc.id\n" +
            "ORDER BY priority DESC, bc.update_time DESC, bc.create_time DESC LIMIT 5")
    List<BookCollection> getBookCollectionLimit(long now);

    //获取所有书单
    @Select("SELECT GROUP_CONCAT(bcd.user_id) as userId,priority,bc.id, bc.name, bc.image,bc.bg_color as bgColor ,bc.intro, bc.create_time as createTime, bc.update_time,bc.expired_time as expiredTime,COUNT(DISTINCT bcd.user_id) AS recommendCount, COUNT(bcd.book_id) AS bookCount \n" +
            "FROM book_collection bc \n" +
            "LEFT JOIN book_collection_detailed bcd ON bcd.book_collection_id = bc.id AND bc.expired_time - #{now} > 0\n" +
            "GROUP BY bc.id\n" +
            "ORDER BY priority DESC, bc.update_time DESC, bc.create_time DESC ")
    List<BookCollection> getAllBookCollection(long now);

    //根据书单id获取书单信息
    @Select("SELECT GROUP_CONCAT(bcd.user_id) as userId,priority,bc.id, bc.name, bc.image,bc.bg_color as bgColor,bc.intro, bc.create_time, bc.update_time,bc.expired_time,COUNT(DISTINCT bcd.user_id) AS recommendCount, COUNT(bcd.book_id) AS bookCount \n" +
            "FROM book_collection bc \n" +
            "INNER JOIN book_collection_detailed bcd ON bcd.book_collection_id = bc.id AND bc.id = #{id}\n" +
            "GROUP BY bc.id\n" +
            "ORDER BY update_time DESC")
    BookCollection getBookCollectionById(String id);

    //创建书单
    @Insert("INSERT INTO book_collection\n" +
            "\t(id, name, intro, image, expired_time)\n" +
            "\tVALUES (#{id}, #{name}, #{intro}, #{image}, #{expiredTime}")
    void add(BookCollection bookCollection);

    //编辑书单修改时间
    @Update("UPDATE book_collection\n" +
            "\tSET\n" +
            "\t\tupdate_time=#{time}\n" +
            "\tWHERE id=#{id}")
    void update(Date time, String id);

    //拿到最新推荐书籍的用户头像
    @Select("SELECT user.header_img\n" +
            "FROM book_collection_detailed bcd\n" +
            "LEFT JOIN user ON bcd.user_id = user.user_id\n" +
            "WHERE bcd.book_collection_id = #{cId}\n" +
            "ORDER BY bcd.update_time\n" +
            "LIMIT #{count}")
    List<String> getHeaderImgByDetailed(int count, String cId);
}
