package models;

/* 
 * POJO for an Message object
 *
 *   {
    "sequence": "-",
    "timestamp": "_",
    "fromid": "xt0fer",
    "toid": "kristofer",
    "message": "Hello, Kristofer!"
  },

*
 */
public class Message implements Comparable {

    private String message = "";
    private String toid = "";
    private String fromid = "";
    private String timestamp = "_";
    private String sequence = "_";

    public Message(String sequence, String timestamp, String fromid, String toid, String message) {
        this.message = message;
        this.toid = toid;
        this.fromid = fromid;
        this.timestamp = timestamp;
        this.sequence = sequence;

    }

    public Message (String message, String fromid, String toid) {
        this.message = message;
        this.fromid = fromid;
        this.toid = toid;
        this.sequence = "_";
        this.timestamp = "_";
    }

    public Message (String message, String fromid) {
        this.message = message;
        this.fromid = fromid;
        this.toid = "";
        this.sequence = "_";
        this.timestamp = "_";
    }

    @Override
    public String toString() {
        return "to: " + this.toid + "\nfrom: "+ this.fromid + "\n" + this.message + "\n----\n";
    }

    public int compareTo(Object o) {
        return this.sequence.compareTo(((Message) o).getSequence());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToid() {
        return toid;
    }

    public void setToid(String toid) {
        this.toid = toid;
    }

    public String getFromid() {
        return fromid;
    }

    public void setFromid(String fromid) {
        this.fromid = fromid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getSequence() {
        return sequence;
    }
}