package com.example.demo.Entity;


public class Discuss {

  private long userId;
  private long movieId;
  private String discuss;

  @Override
  public String toString() {
    return "Discuss{" +
            "userId=" + userId +
            ", movieId=" + movieId +
            ", discuss='" + discuss + '\'' +
            '}';
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
    return discuss;
  }

  public void setDiscuss(String discuss) {
    this.discuss = discuss;
  }
}
