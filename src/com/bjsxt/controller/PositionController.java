package com.bjsxt.controller;

import com.bjsxt.pojo.Position;
import com.bjsxt.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class PositionController {
    @Autowired
    private PositionService positionService;

    public PositionService getPositionService() {
        return positionService;
    }

    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }

    @RequestMapping("/addPosition.do")
    public void addPosition(Position position, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int i=positionService.addPosition(position);
        if (i>0){
            response.sendRedirect("/selectAllPos.do");
        }else {
            model.addAttribute("error","添加部门失败" );
            request.getRequestDispatcher("/system/positionAdd.jsp").forward(request,response );
        }
    }

    @RequestMapping("/selectAllPos.do")
    public ModelAndView selectAllPos(){
        ModelAndView modelAndView = new ModelAndView();
        List<Position> list=positionService.selectAllPos();
        modelAndView.addObject("posList", list);
        modelAndView.setViewName("/system/positionList.jsp");
        return modelAndView;
    }

    @RequestMapping("/updatePos.do")
    public void updatePos(Position position,Model model,HttpServletRequest request,HttpServletResponse response) throws IOException {
        int i=positionService.updatePos(position);
        if(i>0){
            response.sendRedirect("/selectAllPos.do");
        }else {
            model.addAttribute("error", "修改岗位失败");
            request.getRequestDispatcher("/system/positionUpdate.jsp");
        }
   }

    @RequestMapping("/selectPosById.do")
    public String selectPosById(String posid,Model model){
        Position position=positionService.selectPosById(posid);
        model.addAttribute("pos",position );
        return "/system/positionUpdate.jsp";
    }

    @RequestMapping("/deletePosById.do")
    public void deletePosById(String posid,Model model,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        int i=positionService.deletePosById(posid);
        if (i>0){
            response.sendRedirect("/selectAllPos.do");
        }else {
            model.addAttribute("error","删除岗位失败" );
            request.getRequestDispatcher("/system/positionList.jsp").forward(request,response );
        }
    }
}
