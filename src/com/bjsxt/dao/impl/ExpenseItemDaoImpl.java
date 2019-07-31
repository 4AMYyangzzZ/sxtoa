package com.bjsxt.dao.impl;

import com.bjsxt.dao.ExpenseItemDao;
import com.bjsxt.entity.ExpenseItem;
import com.bjsxt.util.DBUtil1;
import com.bjsxt.util.DBUtil2;

public class ExpenseItemDaoImpl implements ExpenseItemDao {
    @Override
    public void addExpenseItem(ExpenseItem item) {
        DBUtil2.executeUpdate("insert into expenseitem values(null,?,?,?,?)",item.getExpId(),item.getType(),item.getAmount(),item.getItemDesc());
    }
}
