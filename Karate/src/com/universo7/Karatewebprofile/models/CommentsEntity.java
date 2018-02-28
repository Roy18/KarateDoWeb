package com.universo7.Karatewebprofile.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentsEntity extends BaseEntity {

    @Override
    public String getBaseStatement() {
        return "SELECT post_id,id,description,date_format(date,'%d-%m-%Y') as date,user_id FROM "
                .concat(super.getTableName()).concat(" ");
    }

    public CommentsEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public CommentsEntity() {
        super();
        setTableName("comments");
    }

    public List<Comment> findByCriteria (String criteria, PostsEntity postsEntity,UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(getBaseStatement().concat(criteria));
            List<Comment> comments = new ArrayList<>();
            while (rs.next()) {
                comments.add(Comment.from(rs,postsEntity,usersEntity,userTypesEntity));
            }
            return comments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Comment> findByPost(int postId, PostsEntity postsEntity, UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        return findByCriteria(String.format("WHERE post_id=%d ORDER BY id DESC,date DESC",postId),postsEntity,usersEntity,userTypesEntity);
    }

    public boolean create(Comment comment) {
        return executeUpdate(String.format("INSERT INTO %s(post_id,description,date,user_id) VALUES (%d,'%s','%s',%d)",
                getTableName(),comment.getPost().getId(),comment.getDescription(),comment.getDate(),comment.getUser().getId()));
    }

    public boolean create(int postId,String description, String date,int userId,PostsEntity postsEntity,UsersEntity usersEntity,UserTypesEntity userTypesEntity) {
        Comment comment=new Comment();
        comment.setPost(postsEntity.findById(postId,usersEntity,userTypesEntity));
        comment.setDescription(description);
        comment.setDate(date);
        comment.setUser(usersEntity.findById(userId,userTypesEntity));
        return create(comment);
    }

    public boolean deleteByPost(int postId) {
        return executeUpdate(String.format("DELETE FROM %s WHERE post_id=%d",getTableName(),postId));
    }
}
