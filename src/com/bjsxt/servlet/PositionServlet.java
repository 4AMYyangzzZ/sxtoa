package com.bjsxt.servlet;

import com.bjsxt.entity.Department;
import com.bjsxt.entity.Position;
import com.bjsxt.service.DepartmentService;
import com.bjsxt.service.PositionService;
import com.bjsxt.service.impl.DepartmentServiceImpl;
import com.bjsxt.service.impl.PositionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PositionServlet extends BaseServlet {
    public void posAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int posId=Integer.parseInt(request.getParameter("posId"));
        String pName=request.getParameter("pName");
        String pDesc=request.getParameter("pDesc");

        Position pos=new Position(posId,pName,pDesc);
        PositionService positionService=new PositionServiceImpl();
        boolean flag=positionService.posAdd(pos);
        if (flag){
            response.sendRedirect(request.getContextPath()+"/servlet/PositionServlet?method=posFindAll");
        }else {
            request.setAttribute("error","岗位添加失败");
            request.getRequestDispatcher("/system/positionAdd.jsp").forward(request,response);
        }
    }

    public void posFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PositionService positionService=new PositionServiceImpl();
        List<Position> posList=positionService.posFindAll();
        request.setAttribute("posList",posList);
        request.getRequestDispatcher("/system/positionList.jsp").forward(request,response);
    }
    public void findPosById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int posId=Integer.parseInt(request.getParameter("posId"));
        PositionService positionService=new PositionServiceImpl();
        Position pos=positionService.findPosById(posId);
        request.setAttribute("pos",pos);
        request.getRequestDispatcher("/system/positionUpdate.jsp").forward(request,response);
    }


    public void updatePos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int posId=Integer.parseInt(request.getParameter("posId"));
        String pName=request.getParameter("pName");
        String pDesc=request.getParameter("pDesc");

        Position pos=new Position(posId,pName,pDesc);
        PositionService positionService=new PositionServiceImpl();
        boolean flag=positionService.updatePos(pos);
        if (flag){
            response.sendRedirect(request.getContextPath()+"/servlet/PositionServlet?method=posFindAll");
        }else {
            request.setAttribute("error","岗位修改失败");
            request.getRequestDispatcher("/servlet/PositionServlet?method=findPosById&posId="+posId).forward(request,response);
        }
    }

}
