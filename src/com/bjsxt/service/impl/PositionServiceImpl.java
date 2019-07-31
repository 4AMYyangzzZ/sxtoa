package com.bjsxt.service.impl;

import com.bjsxt.dao.PositionDao;
import com.bjsxt.dao.impl.PositionDaoImpl;
import com.bjsxt.entity.Position;
import com.bjsxt.service.PositionService;

import java.util.List;

public class PositionServiceImpl implements PositionService {
    private PositionDao positionDao=new PositionDaoImpl();
    @Override
    public boolean posAdd(Position pos) {
        return positionDao.posAdd(pos)>0;
    }

    @Override
    public List<Position> posFindAll() {
        return positionDao.posFindAll();
    }

    @Override
    public boolean updatePos(Position pos) {
        return positionDao.updatePos(pos)>0;
    }

    @Override
    public Position findPosById(int posId) {
        return positionDao.findPosById(posId);
    }
}
