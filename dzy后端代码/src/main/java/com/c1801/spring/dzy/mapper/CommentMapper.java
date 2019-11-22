package com.c1801.spring.dzy.mapper;

import com.c1801.spring.dzy.model.BookComment;
import com.c1801.spring.dzy.model.BookMessage;
import com.c1801.spring.dzy.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    //删除二级评论
    public void delMessage(@Param("messageId") Integer messageId, @Param("userId") Integer userId);

    //删除一级评论底下的二级评论
    public void delMessageByCommentId(@Param("commentId") Integer commentId);

    //删除一级评论
    public void delComment(@Param("commentId") Integer commentId,@Param("userId") Integer userId);

    //获取一级评论第一条
    public BookComment queryCommentFirst(@Param("bookId") Integer bookId);

    //获取一级评论除了第一条
    public List<BookComment> queryComment(@Param("bookId") Integer bookId);

    //根据id获取一级评论内容
    public BookComment queryCommentById(@Param("id") Integer id);

    //根据id获取一级评论底下的所有回复内容
    public  List<BookMessage> queryMessageById(@Param("id") Integer id,@Param("index") Integer index);

    //用户是否回复过此评论
    public Integer isReplied(@Param("commentId") Integer commentId,@Param("userId") Integer userId);

   //添加用户回复的评论
    public void addReplyOfComments(@Param("commentId") Integer commentId,@Param("userId") Integer userId,@Param("message") String message);

    // 查询用户是否买过这本书
    public Integer userIsBought(@Param("bookId") Integer bookId,@Param("userId") Integer userId);

    // 查询用户是否评价过这本书
    public Integer userIsEvaluation(@Param("userId") Integer userId,@Param("bookId") Integer bookId);

    //添加用户评论
    public void addComments(@Param("bookId") Integer bookId,@Param("userId") Integer userId,@Param("comment") String comment);

    //  判断当前评论是不是当前用户评论的
    public Integer commentIsCurUser(@Param("commentId") Integer commentId,@Param("userId") Integer userId);

    public Comment getCommentById(Integer id);
}
