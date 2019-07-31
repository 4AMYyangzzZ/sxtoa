package com.bjsxt.service;

import com.bjsxt.entity.Position;

import java.util.List;

public interface PositionService {

    public boolean posAdd(Position pos);

    public List<Position> posFindAll();

    public boolean updatePos(Position pos);

    public Position findPosById(int posId);
}
