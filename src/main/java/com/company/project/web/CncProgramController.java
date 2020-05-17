package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.CncProgram;
import com.company.project.service.CncProgramService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import com.company.project.helper.DateUtil;
/**
* Created by CodeGenerator on 2020/05/15.
*/
@RestController
@RequestMapping("/cnc/program")
public class CncProgramController {
    @Resource
    private CncProgramService cncProgramService;

    @PostMapping("/add")
    public Result add(@RequestBody CncProgram cncProgram) {
          String id = UUID.randomUUID().toString().replaceAll("-", "");
          //String rfid = "xxx" + UUID.randomUUID().toString().replaceAll("-", "");
          cncProgram.setProgramId(id);
          //cncProgram.setRfid(rfid);
          Date createTime = DateUtil.currentDate();
          cncProgram.setCreateTime(createTime);
          cncProgramService.save(cncProgram);
          return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        cncProgramService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody CncProgram cncProgram) {
         cncProgramService.update(cncProgram);
         return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        CncProgram cncProgram = cncProgramService.findById(id);
        return ResultGenerator.genSuccessResult(cncProgram);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        //PageHelper.startPage(page, size);
        List<CncProgram> list = cncProgramService.findAll();
        // PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(list);
    }
}
