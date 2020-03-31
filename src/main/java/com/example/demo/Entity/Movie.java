package com.example.demo.Entity;


public class  Movie {

  private String movieName;
  private long movieId;
  private String movieActor;
  private String movieIntroduce;
  private String movieDirect;
  private long siteId;
  private String movieArea;
  private String movieTime;
  private String movieImgsrc;
  private String movieSite;
  private String moviePrice;

  public String getMoviePrice() {
    return moviePrice;
  }

  public void setMoviePrice(String moviePrice) {
    this.moviePrice = moviePrice;
  }

  @Override
  public String toString() {
    return "Movie{" +
            "movieName='" + movieName + '\'' +
            ", movieId=" + movieId +
            ", movieActor='" + movieActor + '\'' +
            ", movieIntroduce='" + movieIntroduce + '\'' +
            ", movieDirect='" + movieDirect + '\'' +
            ", siteId=" + siteId +
            ", movieArea='" + movieArea + '\'' +
            ", movieTime='" + movieTime + '\'' +
            ", movieImgsrc='" + movieImgsrc + '\'' +
            ", movieSite='" + movieSite + '\'' +
            '}';
  }

  public String getMovieName() {
    return movieName;
  }

  public void setMovieName(String movieName) {
    this.movieName = movieName;
  }

  public long getMovieId() {
    return movieId;
  }

  public void setMovieId(long movieId) {
    this.movieId = movieId;
  }

  public String getMovieActor() {
    return movieActor;
  }

  public void setMovieActor(String movieActor) {
    this.movieActor = movieActor;
  }

  public String getMovieIntroduce() {
    return movieIntroduce;
  }

  public void setMovieIntroduce(String movieIntroduce) {
    this.movieIntroduce = movieIntroduce;
  }

  public String getMovieDirect() {
    return movieDirect;
  }

  public void setMovieDirect(String movieDirect) {
    this.movieDirect = movieDirect;
  }

  public long getSiteId() {
    return siteId;
  }

  public void setSiteId(long siteId) {
    this.siteId = siteId;
  }

  public String getMovieArea() {
    return movieArea;
  }

  public void setMovieArea(String movieArea) {
    this.movieArea = movieArea;
  }

  public String getMovieTime() {
    return movieTime;
  }

  public void setMovieTime(String movieTime) {
    this.movieTime = movieTime;
  }

  public String getMovieImgsrc() {
    return movieImgsrc;
  }

  public void setMovieImgsrc(String movieImgsrc) {
    this.movieImgsrc = movieImgsrc;
  }

  public String getMovieSite() {
    return movieSite;
  }

  public void setMovieSite(String movieSite) {
    this.movieSite = movieSite;
  }
}
