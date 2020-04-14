package com.example.demo.Entity;


public class Discuss {

  private long userId;
  private long movieId;
  private String discusss;
  private String userImgsrc;
  private String discussTime;

  public String getDiscusss() {
    return discusss;
  }

  public void setDiscusss(String discusss) {
    this.discusss = discusss;
  }

  public String getDiscussTime() {
    return discussTime;
  }

  public void setDiscussTime(String discussTime) {
    this.discussTime = discussTime;
  }

  @Override
  public String toString() {
    return "Discuss{" +
            "userId=" + userId +
            ", movieId=" + movieId +
            ", discuss='" + discusss + '\'' +
            '}';
  }

  public String getUserImgsrc() {
    return userImgsrc;
  }

  public void setUserImgsrc(String userImgsrc) {
    this.userImgsrc = userImgsrc;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public long getMovieId() {
    return movieId;
  }

  public void setMovieId(long movieId) {
    this.movieId = movieId;
  }

  public String getDiscuss() {
    return discusss;
  }

  public void setDiscuss(String discuss) {
    this.discusss = discuss;
  }
}
