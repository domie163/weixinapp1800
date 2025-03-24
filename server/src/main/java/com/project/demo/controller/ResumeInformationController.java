package com.project.demo.controller;

import com.project.demo.entity.ResumeInformation;
import com.project.demo.service.ResumeInformationService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 简历信息：(ResumeInformation)表控制层
 *
 */
@RestController
@RequestMapping("/resume_information")
public class ResumeInformationController extends BaseController<ResumeInformation, ResumeInformationService> {

    /**
     * 简历信息对象
     */
    @Autowired
    public ResumeInformationController(ResumeInformationService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
