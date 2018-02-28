package com.glitched.Karatewebprofile.models;

import java.sql.Connection;
import java.util.List;

public class KarateDataStore {
    private Connection connection;
    private UserTypesEntity userTypesEntity;
    private UsersEntity usersEntity;
    private InformationsEntity informationsEntity;
    private EventsEntity eventsEntity;
    private PostulantsEntity postulantsEntity;
    private PostsEntity postsEntity;
    private CommentsEntity commentsEntity;
    private PointsEntity pointsEntity;

    public KarateDataStore(Connection connection) {
        this.connection = connection;
    }

    public KarateDataStore() {}

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    //Private getters for entities

    private UserTypesEntity getUserTypesEntity() {
        if(userTypesEntity==null) {
            userTypesEntity=new UserTypesEntity();
            userTypesEntity.setConnection(connection);
        }
        return userTypesEntity;
    }

    private UsersEntity getUsersEntity() {
        if(usersEntity==null) {
            usersEntity=new UsersEntity();
            usersEntity.setConnection(connection);
        }
        return usersEntity;
    }

    private InformationsEntity getInformationsEntity(){
        if(informationsEntity==null) {
            informationsEntity=new InformationsEntity();
            informationsEntity.setConnection(connection);
        }
        return informationsEntity;
    }

    private EventsEntity getEventsEntity() {
        if(eventsEntity==null) {
            eventsEntity = new EventsEntity();
            eventsEntity.setConnection(connection);
        }
        return eventsEntity;
    }

    private PostulantsEntity getPostulantsEntity(){
        if(postulantsEntity==null) {
            postulantsEntity=new PostulantsEntity();
            postulantsEntity.setConnection(connection);
        }
        return postulantsEntity;
    }

    private PostsEntity getPostsEntity() {
        if (pointsEntity == null) {
            postsEntity = new PostsEntity();
            postsEntity.setConnection(connection);
        }
        return postsEntity;
    }

    private CommentsEntity getCommentsEntity() {
        if (commentsEntity==null) {
            commentsEntity=new CommentsEntity();
            commentsEntity.setConnection(connection);
        }
        return commentsEntity;
    }

    private PointsEntity getPointsEntity() {
        if(pointsEntity==null) {
            pointsEntity=new PointsEntity();
            pointsEntity.setConnection(connection);
        }
        return  pointsEntity;
    }

    //Public data store methods
    //UserType methods
    public List<UserType> findAllUserTypes() {
        if(connection==null) return null;
        return getUserTypesEntity().findAll();
    }

    //Information methods
    public List<Information> findAllInformations() {
        if(connection==null) return null;
        return getInformationsEntity().findAll(getUsersEntity(),getUserTypesEntity());
    }

    //User methods
    public List<User> findAllUsers() {
        if(connection==null) return null;
        return getUsersEntity().findAll(getUserTypesEntity());
    }

    public User findUserById(int id) {
        if(connection==null) return null;
        return getUsersEntity().findById(id,getUserTypesEntity());
    }

    public User findUserByUsername(String username) {
        if(connection==null) return null;
        return getUsersEntity().findByUsername(username,getUserTypesEntity());
    }

    public boolean findUserByLogin(String username,String password) {
        if(connection==null) return false;
        return getUsersEntity().findByLogin(username,password,getUserTypesEntity());
    }

    public boolean createUser(User user) {
        if(connection==null) return false;
        return getUsersEntity().create(user);
    }

    public boolean createUser(String username,String password,String name,String lastName,String email,String birthDate,char genre,int id) {
        if(connection==null) return false;
        return getUsersEntity().create(username,password,name,lastName,email,birthDate,genre,getUserTypesEntity().findById(id));
    }

    public boolean updateUser(int id, String name,String lastname,String phone) {
        if(connection==null) return false;
        return getUsersEntity().update(id,name,lastname,phone);
    }

    //Information methods
    public Information findInformationByUserId(int userId) {
        if(connection==null) return null;
        return getInformationsEntity().findByUserId(userId,getUsersEntity(),getUserTypesEntity());
    }

    public Information findInformationByUserUsername(String username) {
        if(connection==null) return null;
        return getInformationsEntity().findByUserUsername(username,getUsersEntity(),getUserTypesEntity());
    }

    public boolean createInformation(String description,double averagePoints, int voteQuantity, String username) {
        if(connection==null) return false;
        return getInformationsEntity().create(description,averagePoints,voteQuantity,getUsersEntity().findByUsername(username,getUserTypesEntity()));
    }

    public boolean updateInformation(int userId) {
        if(connection==null) return false;
        return getInformationsEntity().update(userId);
    }

    //Posts methods

    public List<Post> findLastest() {
        if(connection==null) return null;
        return getPostsEntity().findLastest(getUsersEntity(),getUserTypesEntity());
    }

    public List<Post> findByUser(int user_id) {
        if(connection==null) return null;
        return getPostsEntity().findByUser(getUsersEntity().findById(user_id,getUserTypesEntity()),getUsersEntity(),getUserTypesEntity());
    }

    public Post findPostById(int id) {
        if(connection==null) return null;
        return getPostsEntity().findById(id,getUsersEntity(),getUserTypesEntity());
    }

    public List<Post> showSearch(String title) {
        if(connection==null) return null;
        return getPostsEntity().showSearch(title, getUsersEntity(), getUserTypesEntity());
    }

    public boolean createPost(Post post) {
        if(connection==null) return false;
        return getPostsEntity().create(post);
    }

    public boolean createPost(int id,String title,String date,String description,String url) {
        if(connection==null) return false;
        return getPostsEntity().create(getUsersEntity().findById(id,getUserTypesEntity()),title,date,description,url);
    }

    public boolean deletePostById(int id) {
        if(connection==null) return false;
        return getPostsEntity().deleteByID(id);
    }
    //Comment methods
    public List<Comment> findCommentByPost(int postId) {
        if(connection==null) return null;
        return getCommentsEntity().findByPost(postId,getPostsEntity(),getUsersEntity(),getUserTypesEntity());
    }

    public boolean createComment(int postId,String description,String date,int userId) {
        if(connection==null) return false;
        return getCommentsEntity().create(postId,description,date,userId,getPostsEntity(),getUsersEntity(),getUserTypesEntity());
    }

    public boolean deleteCommentByPost(int postId) {
        if(connection==null) return false;
       return getCommentsEntity().deleteByPost(postId);
    }

    //Event methods
    public List<Event> showEvents() {
        if(connection==null) return null;
        return getEventsEntity().showEvents(getUsersEntity(),getUserTypesEntity());
    }

    public Event findEventById(int eventId) {
        if(connection==null) return null;
        return getEventsEntity().findById(eventId,getUsersEntity(),getUserTypesEntity());
    }

    public List<Event> findEventByUser(int userId) {
        if(connection==null) return null;
        return getEventsEntity().findByUser(userId,getUsersEntity(),getUserTypesEntity());
    }

    public List<Event> findEventByPostulant(int userId) {
        if(connection==null) return null;
        return getEventsEntity().findByPostulant(userId,getUsersEntity(),getUserTypesEntity());
    }

    public boolean createEvent(Event event) {
        if(connection==null) return false;
        return getEventsEntity().create(event);
    }

    public List<Event> findAllEvents() {
        if(connection==null) return null;
        return getEventsEntity().findAll(getUsersEntity(),getUserTypesEntity());
    }

    public boolean createEvent(int id,String picture_url,String title,String ubication, String tags, String websites,String date, String dateLimit, String description, double salary) {
        if(connection==null) return false;
        return getEventsEntity().create(getUsersEntity().findById(id,getUserTypesEntity()),title,picture_url,ubication,tags,websites,date,dateLimit,description,salary);
    }

    //Postulant methods
    public List<Postulant> findPostulantByEvent(int eventId) {
        if(connection==null) return null;
        return getPostulantsEntity().findByEvent(eventId,getEventsEntity(),getUsersEntity(),getUserTypesEntity());
    }

    public boolean createPostulant(int eventId,int userId,String date) {
        if(connection==null) return false;
        return getPostulantsEntity().create(eventId,userId,date);
    }

    public boolean checkPostulant(int eventId, int userId) {
        if(connection==null) return false;
        return getPostulantsEntity().check(eventId,userId);
    }

    //Point methods
    public boolean createPoint(int origin, int target, int quantity) {
        if(connection==null) return false;
        return getPointsEntity().create(origin,target,quantity,getUsersEntity(),getUserTypesEntity());
    }

    public boolean createPoint(Point point) {
        if(connection==null) return false;
        return getPointsEntity().create(point);
    }

    public boolean updatePoint(int origin, int target, int quantity) {
        if(connection==null) return false;
        return getPointsEntity().update(origin,target,quantity);
    }

    public boolean checkPoint(int origin, int target) {
        if(connection==null) return false;
        return getPointsEntity().check(origin,target);
    }

    public int getQuantity(int origin, int target) {
        if(connection==null) return 0;
        return getPointsEntity().getQuantity(origin,target);
    }
}
