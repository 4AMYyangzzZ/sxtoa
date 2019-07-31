package com.bjsxt.dao.impl;

import com.bjsxt.dao.BaseDao;
import com.bjsxt.dao.PositionDao;
import com.bjsxt.entity.Position;

import java.util.List;

public class PositionDaoImpl extends BaseDao implements PositionDao {
    @Override
    public int posAdd(Position pos) {
        return baseUpdate("insert into position values(?,?,?)",pos.getPosId(),pos.getpName(),pos.getpDesc());
    }

    @Override
    public List<Position> posFindAll() {
        return baseQuery(Position.class,"select * from position");
    }

    @Override
    public int updatePos(Position pos) {
        return baseUpdate("update position set pName=?,pDesc=? where posId=?",pos.getpName(),pos.getpDesc(),pos.getPosId());
    }

    @Override
    public Position findPosById(int posId) {
        return (Position)baseQuery(Position.class,"select * from position where posId=?",posId).get(0);
    }
}
