package com.usst.entity.question;

public class Textbook {
    private String textBookId;

    private String textBookName;

    private String publisher;

    private String pubDate;

    public String getTextBookId() {
        return textBookId;
    }

    public void setTextBookId(String textBookId) {
        this.textBookId = textBookId == null ? null : textBookId.trim();
    }

    public String getTextBookName() {
        return textBookName;
    }

    public void setTextBookName(String textBookName) {
        this.textBookName = textBookName == null ? null : textBookName.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate == null ? null : pubDate.trim();
    }
}