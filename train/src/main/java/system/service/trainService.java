package system.service;

import system.domain.PageBean;
import system.domain.train;

import java.util.List;

public interface trainService {

    List<train> select();

    List<train>  selectOther(String train_time,String train_start,String train_end,String train_type);

    int selectCount(String train_time,String train_start,String train_end,String train_type);

    PageBean<train> selectPB(String train_time, String train_start, String train_end, String train_type, int currentPage , int row);

    train selectByTrain_id(String train_id);

}
