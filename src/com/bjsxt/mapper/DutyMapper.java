package com.bjsxt.mapper;

import com.bjsxt.pojo.Duty;
import com.bjsxt.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DutyMapper {
    Duty selectDutyByIdAndDate(@Param("empId") String empId,@Param("dtDate") String dtDate);
    int sigin(Duty duty);
    int sigout(Duty duty);

   List<Employee> selectDutyByCondition(@Param("empId") String empId, @Param("deptNo") Integer deptNo, @Param("dtDate") String dtDate);

    List<Duty> selectDutyByMyself(String empid);
}
