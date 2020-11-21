package system.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class train {
    String train_id;
    String train_type;
    String train_start;
    String train_end;
    Date train_time;
    int train_price;
    int train_number;

    public String getTrain_id() {
        return train_id;
    }

    public void setTrain_id(String train_id) {
        this.train_id = train_id;
    }

    public String getTrain_type() {
        return train_type;
    }

    public void setTrain_type(String train_type) {
        this.train_type = train_type;
    }

    public String getTrain_start() {
        return train_start;
    }

    public void setTrain_start(String train_start) {
        this.train_start = train_start;
    }

    public String getTrain_end() {
        return train_end;
    }

    public void setTrain_end(String train_end) {
        this.train_end = train_end;
    }

    public Date getTrain_time() {
        return train_time;
    }

    public void setTrain_time(Date train_time) {
        this.train_time = train_time;
    }

    public int getTrain_price() {
        return train_price;
    }

    public void setTrain_price(int train_price) {
        this.train_price = train_price;
    }

    public int getTrain_number() {
        return train_number;
    }

    public void setTrain_number(int train_number) {
        this.train_number = train_number;
    }

    public String printtime(){

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String s = format.format(this.train_time);
        return  s;
    }
    @Override
    public String toString() {
        return "train{" +
                "train_id='" + train_id + '\'' +
                ", train_type='" + train_type + '\'' +
                ", train_start='" + train_start + '\'' +
                ", train_end='" + train_end + '\'' +
                ", train_time=" + train_time +
                ", train_price=" + train_price +
                ", train_number=" + train_number +
                '}';
    }
}
