package system.domain;

public class Order {
    public String order_id;
    public String user_id;
    public String train_id;
    public String order_time;
    public int order_number;
    public int summoney;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTrain_id() {
        return train_id;
    }

    public void setTrain_id(String train_id) {
        this.train_id = train_id;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public int getSummoney() {
        return summoney;
    }

    public void setSummoney(int summoney) {
        this.summoney = summoney;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", train_id='" + train_id + '\'' +
                ", order_time='" + order_time + '\'' +
                ", order_number=" + order_number +
                ", summoney=" + summoney +
                '}';
    }
}
