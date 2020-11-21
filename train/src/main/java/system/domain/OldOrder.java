package system.domain;

public class OldOrder {

    String order_id;
    train train;
    User user;
    int order_number;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public system.domain.train getTrain() {
        return train;
    }

    public void setTrain(system.domain.train train) {
        this.train = train;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    @Override
    public String toString() {
        return "OldOrder{" +
                "order_id='" + order_id + '\'' +
                ", train=" + train +
                ", user=" + user +
                ", order_number=" + order_number +
                '}';
    }
}
