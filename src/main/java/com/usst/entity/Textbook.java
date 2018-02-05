package com.usst.entity;


public class Textbook {

  private String textBookId;
  private String textBookName;
  private String publisher;
  private String pubDate;


  public String getTextBookId() {
    return textBookId;
  }

  public void setTextBookId(String textBookId) {
    this.textBookId = textBookId;
  }


  public String getTextBookName() {
    return textBookName;
  }

  public void setTextBookName(String textBookName) {
    this.textBookName = textBookName;
  }


  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }


  public String getPubDate() {
    return pubDate;
  }

  public void setPubDate(String pubDate) {
    this.pubDate = pubDate;
  }

}
