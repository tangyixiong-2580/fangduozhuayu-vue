package cn.dzy.manage.boss.manage.dao;

import cn.dzy.manage.boss.manage.bean.book.BookCollectionDetailed;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface BookCollectionDetailedDao {

    @Insert("INSERT INTO book_collection_detailed\n" +
            "\t(book_collection_id, book_id, reason, user_id)\n" +
            "\tVALUES (#{bookCollectionId}, #{bookId}, #{reason}, #{userId})")
    void add(BookCollectionDetailed detailed);

    //获取除了第一本的书单详情
   @Select("SELECT bcd.id,bcd.book_collection_id,bcd.book_id,bcd.reason,bcd.user_id,k.count,bcd.create_time,bcd.update_time\n" +
           "FROM (\n" +
           "SELECT id, book_collection_id, book_id, reason, user_id, create_time, update_time\n" +
           "FROM book_collection_detailed WHERE book_collection_id = #{cId} AND id != #{id}\n" +
           "ORDER BY update_time DESC) bcd\n" +
           "LEFT JOIN (\n" +
           "SELECT book_collection_detailed_id, COUNT(user_id) AS COUNT\n" +
           "FROM fabulous\n" +
           "GROUP BY book_collection_detailed_id) k ON bcd.id = k.book_collection_detailed_id order BY k.count DESC,bcd.update_time DESC")
   List<BookCollectionDetailed> getDetailedByCId(String cId,int id);


    //根据点赞id获取点赞所属的书籍详情id以及书单id
    @Select("SELECT f.id,f.book_collection_detailed_id,bc.id\n" +
            "FROM fabulous f\n" +
            "INNER JOIN book_collection_detailed bcd ON\n" +
            "bcd.id = f.book_collection_detailed_id AND f.id = #{id}\n" +
            "INNER JOIN book_collection bc ON bcd.book_collection_id = bc.id")
    BookCollectionDetailed getDetailedByFabulous(int id);

    //编辑书单详情的修改时间
    @Update("UPDATE book_collection_detailed\n" +
            "\tSET\n" +
            "\t\tupdate_time=#{time}\n" +
            "\tWHERE id=#{id}")
    void editUpdate(String id, Date time);
    //根据书单id和书籍id获取书单详情
    @Select("SELECT id, book_collection_id, book_id, reason, user_id, create_time, update_time\n" +
            "\tFROM book_collection_detailed WHERE book_id = #{bookId} AND book_collection_id = #{bookCollectionId} ")
    BookCollectionDetailed getDetailedByBookIdAndCId(String bookId,String bookCollectionId);

    //根据书单详情id获取书单详情
    @Select("SELECT bcd.id,bcd.book_collection_id,bcd.book_id,bcd.reason,bcd.user_id,k.count,bcd.create_time,bcd.update_time\n" +
            "FROM (\n" +
            "SELECT id, book_collection_id, book_id, reason, user_id, create_time, update_time\n" +
            "FROM book_collection_detailed where id = #{id}\n" +
            "ORDER BY update_time DESC) bcd\n" +
            "LEFT JOIN (\n" +
            "SELECT book_collection_detailed_id, COUNT(user_id) AS COUNT\n" +
            "FROM fabulous\n" +
            "GROUP BY book_collection_detailed_id) k ON bcd.id = k.book_collection_detailed_id")
    BookCollectionDetailed getDetailedByDetailedId(int id);
    //获取指定书单id的第一本书
    @Select("SELECT bcd.id,bcd.book_collection_id,bcd.book_id,bcd.reason,bcd.user_id,k.count,bcd.create_time,bcd.update_time\n" +
            "FROM (\n" +
            "SELECT id, book_collection_id, book_id, reason, user_id, create_time, update_time\n" +
            "FROM book_collection_detailed WHERE book_collection_id = #{cId} \n" +
            "ORDER BY create_time DESC LIMIT 1 ) bcd\n" +
            "LEFT JOIN (\n" +
            "SELECT book_collection_detailed_id, COUNT(user_id) AS COUNT\n" +
            "FROM fabulous\n" +
            "GROUP BY book_collection_detailed_id) k ON bcd.id = k.book_collection_detailed_id")
    BookCollectionDetailed getFirstInfo(String cId);

}