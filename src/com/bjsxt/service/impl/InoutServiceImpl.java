package com.bjsxt.service.impl;

import com.bjsxt.dao.IncomeDao;
import com.bjsxt.dao.PaymentDao;
import com.bjsxt.dao.impl.IncomeDaoImpl;
import com.bjsxt.dao.impl.PaymentDaoImpl;
import com.bjsxt.entity.Income;
import com.bjsxt.service.InoutService;

import java.util.List;

public class InoutServiceImpl implements InoutService {
    IncomeDao incomeDao=new IncomeDaoImpl();
    PaymentDao paymentDao=new PaymentDaoImpl();

    @Override
    public boolean incomeAdd(Income income) {
        return incomeDao.save(income)>0;
    }

    @Override
    public List<Income> getAllIncome() {
        return incomeDao.getAllIncome();
    }

    @Override
    public String getIncomeData() {
        List<Object[]> list=incomeDao.getIncomeData();
        StringBuffer str1=new StringBuffer("[");
        StringBuffer str2=new StringBuffer("[");
        for (int i = 0; i <list.size() ; i++) {
            Object[] obj=list.get(i);
            if (i!=list.size()-1){
                str1.append("\""+obj[0]+"\""+",");
                str2.append(obj[1]+",");
            }else {
                str1.append("\""+obj[0]+"\"");
                str2.append(obj[1]);
            }
        }
        str1.append("]");
        str2.append("]");
        return "["+str1.toString()+","+str2.toString()+"]";
    }

    @Override
    public String getPaymentData() {
        List<Object[]> list=paymentDao.getPaymentData();
        //[['直接访问','邮件营销','联盟广告','视频广告','搜索引擎'],[\n" +
//                "                                   {value:335, name:'直接访问'},\n" +
//                "                                   {value:310, name:'邮件营销'},\n" +
//                "                                   {value:234, name:'联盟广告'},\n" +
//                "                                   {value:135, name:'视频广告'},\n" +
//                "                                   {value:1548, name:'搜索引擎'}\n" +
//                "                               ]]
        StringBuffer str1=new StringBuffer("[");
        StringBuffer str2=new StringBuffer("[");
        for (int i = 0; i <list.size() ; i++) {
            Object[] obj=list.get(i);
            if (i!=list.size()-1){
                str1.append("\""+obj[0]+"\""+",");
                str2.append("{\"value\":"+obj[1]+", \"name\":"+"\""+obj[0]+"\"},");
            }else {
                str1.append("\""+obj[0]+"\"");
                str2.append("{\"value\":"+obj[1]+", \"name\":"+"\""+obj[0]+"\"}");
            }
        }
        str1.append("]");
        str2.append("]");
        return "["+str1.toString()+","+str2.toString()+"]";
    }
}
