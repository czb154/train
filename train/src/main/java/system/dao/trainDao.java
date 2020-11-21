package system.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import system.domain.PageBean;
import system.domain.train;

import java.util.List;

@Repository
public interface trainDao {


    @Select("select * from train")
    public List<train> select();



    /**
     * 查询票，根据日期（字符串），起点，终点，类型
     * @param date1
     * @param train_start
     * @param train_end
     * @param train_type
     * @return
     */
    @Select("<script> SELECT * from train" +
            "<where>"+
            "<if test='date1!= null'>and train_time like concat('%',#{date1},'%')</if> "+
            " <if test='train_start != null and train_start!=\"\" '>and train_start like concat('%',#{train_start},'%')</if> "+
            " <if test='train_end != null and train_end!=\"\"'>and train_end like concat('%',#{train_end},'%')</if> " +
            " <if test='train_type != null and train_type!=\"\" '>and train_type like concat('%',#{train_type},'%')</if> " +
            "</where>"+
            "</script>")
    public List<train> selectOther( @Param("date1") String date1,@Param("train_start") String train_start,@Param("train_end")String train_end,
                                    @Param("train_type")String train_type);

    /**
     * 根据条件查询总车次
     * @param date1
     * @param train_start
     * @param train_end
     * @param train_type
     * @return
     */
    @Select("<script> SELECT count(train_id) from train" +
            "<where>"+
            "<if test='date1!= null'>and train_time like concat('%',#{date1},'%')</if> "+
            " <if test='train_start != null and train_start!=\"\" '>and train_start like concat('%',#{train_start},'%')</if> "+
            " <if test='train_end != null and train_end!=\"\"'>and train_end like concat('%',#{train_end},'%')</if> " +
            " <if test='train_type != null and train_type!=\"\" '>and train_type like concat('%',#{train_type},'%')</if> " +
            "</where>"+
            "</script>")
    public int selectCount(@Param("date1") String date1, @Param("train_start") String train_start, @Param("train_end")String train_end,
                                @Param("train_type")String train_type);

    /**
     * 根据条件查询各车次
     * @param date1
     * @param train_start
     * @param train_end
     * @param train_type
     * @param start
     * @param row
     * @return
     */
    @Select("<script> SELECT * from train" +
            "<where>"+
            "<if test='date1!= null'>and train_time like concat('%',#{date1},'%')</if> "+
            " <if test='train_start != null and train_start!=\"\" '>and train_start like concat('%',#{train_start},'%')</if> "+
            " <if test='train_end != null and train_end!=\"\"'>and train_end like concat('%',#{train_end},'%')</if> " +
            " <if test='train_type != null and train_type!=\"\" '>and train_type like concat('%',#{train_type},'%')</if> " +
            "</where>"+"limit #{start},#{row}"+
            "</script>")
    public List<train> selectPB( @Param("date1") String date1,@Param("train_start") String train_start,@Param("train_end")String train_end,
                            @Param("train_type")String train_type,@Param("start")int start ,@Param("row")int row);

    /**
     * 根据trian_id查询车次
     * @param train_id
     * @return
     */
    @Select("select * from train where train_id=#{train_id}")
    train selectByTrain_id(String train_id);


}
