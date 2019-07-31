package com.bjsxt.dao;

import com.bjsxt.entity.Position;

import java.util.List;

public interface PositionDao {
    public int posAdd(Position pos);

    public List<Position> posFindAll();

    public int updatePos(Position pos);

    public Position findPosById(int posId);
}
