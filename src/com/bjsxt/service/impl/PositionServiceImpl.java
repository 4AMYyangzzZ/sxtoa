package com.bjsxt.service.impl;

import com.bjsxt.mapper.PositionMapper;
import com.bjsxt.pojo.Position;
import com.bjsxt.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionMapper positionMapper;

    public PositionMapper getPositionMapper() {
        return positionMapper;
    }

    public void setPositionMapper(PositionMapper positionMapper) {
        this.positionMapper = positionMapper;
    }

    @Override
    public int addPosition(Position position) {
        return positionMapper.addPosition(position);
    }

    @Override
    public List<Position> selectAllPos() {
        return positionMapper.selectAllPos();
    }

    @Override
    public int updatePos(Position position) {
        return positionMapper.updatePos(position);
    }

    @Override
    public Position selectPosById(String posid) {
        return positionMapper.selectPosById(posid);
    }

    @Override
    public int deletePosById(String posid) {
        return positionMapper.deletePosById(posid);
    }
}
