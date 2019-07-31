import com.bjsxt.dao.*;
import com.bjsxt.dao.impl.*;
import com.bjsxt.entity.*;
import com.bjsxt.service.InoutService;
import com.bjsxt.service.impl.InoutServiceImpl;
import org.junit.Ignore;

import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Test {
//    public static void main(String[] args) {
//        EmployeeDao employeeDao=new EmployeeDaoImpl();
//        List<CombineDeptAndEmpAndPos> combineDeptAndEmpAndPos = employeeDao.empFindAll();
//        for (CombineDeptAndEmpAndPos c:combineDeptAndEmpAndPos
//             ) {
//            System.out.println(c);
//        }
//    }

    @org.junit.Test
    public void add(){
        System.out.println("hello");
    }

    @Ignore
    @org.junit.Test
    public void select(){
        System.out.println("world");
    }

    @org.junit.Test
    public void testDate(){
        System.out.println(new Date());
    }

    @org.junit.Test
    public void findEmpById(){
        DutyDao dutyDao=new DutyDaoImpl();
        Duty godV = dutyDao.findByEmpId("godV");
        System.out.println(godV);
    }
    @org.junit.Test
    public void testSel(){
        DutyDao dutyDao=new DutyDaoImpl();
        List<CombineEmpAndDutyAndDept> g = dutyDao.findDuty("g", 0, null);
        System.out.println(g);
    }
    @org.junit.Test
    public void testDate2(){
        System.out.println(java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
    }

    @org.junit.Test
    public void testJson(){
        InoutService inoutService=new InoutServiceImpl();
        String incomeData = inoutService.getIncomeData();
        System.out.println(incomeData);
    }
    @org.junit.Test
    public void testPay(){
        PaymentDao paymentDao=new PaymentDaoImpl();
        List<Object[]> paymentData = paymentDao.getPaymentData();
        System.out.println(paymentData);
    }
    @org.junit.Test
    public void testDept(){
        DepartmentDao departmentDao=new DepartmentDaoImpl();
        Department mifeng = departmentDao.findDeptByEmpId("lifuying");
        System.out.println(mifeng);
    }
    @org.junit.Test
    public void testInsert(){
        IncomeDao incomeDao=new IncomeDaoImpl();

        int save = incomeDao.save(new Income("mifeng", 500, new Date(), "其他", "testData"));
        System.out.println(save);
    }

    @org.junit.Test
    public void test1(){
        String str=null;
        try {
            new SimpleDateFormat().parse("");
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
