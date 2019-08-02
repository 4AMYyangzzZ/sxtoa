package com.bjsxt.service;

import com.bjsxt.pojo.Position;

import java.util.List;

public interface PositionService {
    int addPosition(Position position);

    List<Position> selectAllPos();

    int updatePos(Position position);

    Position selectPosById(String posid);

    int deletePosById(String posid);
}
