package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.trainDao;
import system.domain.PageBean;
import system.domain.train;
import system.service.trainService;

import java.util.List;

@Service("trainService")
public class trainServiceImpl  implements trainService {
    @Autowired
    trainDao traindao;
    @Override
    public List<train> select() {
        return traindao.select();
    }

    @Override
    public List<train> selectOther(String train_time, String train_start, String train_end, String train_type) {
        return traindao.selectOther(train_time,train_start,train_end,train_type);
    }

    @Override
    public int selectCount(String train_time, String train_start, String train_end, String train_type) {
        return traindao.selectCount(train_time,train_start,train_end,train_type);
    }

    @Override
    public PageBean<train> selectPB(String train_time, String train_start, String train_end, String train_type, int currentPage, int row) {
        int totalCount = traindao.selectCount(train_time,train_start,train_end,train_type);
        PageBean<train> pb = new PageBean<>();
        pb.setTotalCount(totalCount);
        int totalPage = (totalCount%row ==0)?(totalCount/row):(totalCount/row+1);
        pb.setTotalPage(totalPage);
        int start= (currentPage-1)*row;
        List<train> list = traindao.selectPB(train_time,train_start,train_end,train_type,start,row);
        pb.setList(list);
        pb.setRows(row);
        pb.setCurrentPage(currentPage);
        return  pb;
     }

    @Override
    public train selectByTrain_id(String train_id) {
        return traindao.selectByTrain_id(train_id);
    }




}
