package com.bjsxt.mapper;

import com.bjsxt.pojo.Position;

import java.util.List;

public interface PositionMapper {
    int addPosition(Position position);

    List<Position> selectAllPos();

    int updatePos(Position position);

    Position selectPosById(String posid);

    int deletePosById(String posid);
}
