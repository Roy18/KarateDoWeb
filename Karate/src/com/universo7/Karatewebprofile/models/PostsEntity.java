package com.universo7.Karatewebprofile.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostsEntity extends BaseEntity{

    public PostsEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    @Override
    public String getBaseStatement() {
        return "SELECT id,user_id,title,date_format(date,'%d-%m-%Y') as date,description,url FROM "
                .concat(super.getTableName()).concat(" ");
    }

    public PostsEntity() {
        super();
        setTableName("posts");
    }

    public List<Post> findByCriteria (String criteria, UsersEntity usersEntity,UserTypesEntity userTypesEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(getBaseStatement().concat(criteria));
            List<Post> posts = new ArrayList<>();
            while (rs.next()) {
                posts.add(Post.from(rs,usersEntity,userTypesEntity));
            }
            return posts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Post> findByUser(User user, UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        return findByCriteria(String.format("WHERE user_id=%d",user.getId()),usersEntity,userTypesEntity);
    }

    public Post findById (int id, UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        return findByCriteria(String.format("WHERE id=%d",id),usersEntity,userTypesEntity).get(0);
    }

    public boolean deleteByID (int id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id=%d",getTableName(),id));
    }

    public Post findByName (String title, UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        return findByCriteria(String.format("WHERE title=%d",title),usersEntity,userTypesEntity).get(0);
    }

    public List<Post> findLastest(UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        return findByCriteria("ORDER BY id DESC,date DESC",usersEntity,userTypesEntity);
    }

    public List<Post> showSearch(String title,UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        return findByCriteria(String.format("WHERE title LIKE '%%%s%%' ORDER BY id DESC, date DESC",title),usersEntity,userTypesEntity);
    }

    public boolean create(Post post) {
        return executeUpdate(String.format(
                "INSERT INTO %s(user_id,title,date,description,url)"
                        .concat("VALUES(%d,'%s','%s','%s','%s')"),
                getTableName(),post.getUser().getId(),post.getTitle(),post.getDate(),post.getDescription(),post.getUrl()));
    }

    public boolean create(User user, String title, String date,String description, String url) {
        Post post = new Post();
        post.setUser(user);
        post.setTitle(title);
        post.setDate(date);
        post.setDescription(description);
        post.setUrl(url);
        return create(post);
    }
}
