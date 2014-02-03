package chat;

import javax.persistence.*;

/**
 * @author Klaus Bayrhammer
 */
@Entity
public class ChatMessage {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String user;
    private String message;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
