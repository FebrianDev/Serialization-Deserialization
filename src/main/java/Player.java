import java.io.Serializable;

public class Player implements Serializable {
    private String nickname;
    private Integer length;
    private Integer rank;
    private boolean isAlive;

    public Player() {
        this.nickname = "";
        length = 0;
        rank = 0;
        isAlive = false;
    }

    public Player(String nickname, Integer length, Integer rank, boolean isAlive) {
        this.nickname = nickname;
        this.length = length;
        this.rank = rank;
        this.isAlive = isAlive;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
