package br.com.unicarioca.unimail.rmi;

import java.io.Serializable;

/**
 * Created by alessandro.santos on 11/15/16.
 */


public class MessageDTO implements Serializable {

    private String from;

    private String to;

    private String title;

    private String body;

    public MessageDTO(String from, String to, String title, String body) {
        this.from = from;
        this.to = to;
        this.title = title;
        this.body = body;
    }

    public MessageDTO() {}

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MessageDTO{");
        sb.append("from='").append(from).append('\'');
        sb.append(", to='").append(to).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
