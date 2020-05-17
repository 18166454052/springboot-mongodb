package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.CncTool;
import com.company.project.service.CncToolService;
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
@RequestMapping("/cnc/tool")
public class CncToolController {
    @Resource
    private CncToolService cncToolService;

    @PostMapping("/add")
    public Result add(@RequestBody CncTool cncTool) {
          String id = UUID.randomUUID().toString().replaceAll("-", "");
          String rfid = "tool_" + UUID.randomUUID().toString().replaceAll("-", "");
          cncTool.setToolId(id);
          cncTool.setRfid(rfid);
          Date createTime = DateUtil.currentDate();
          cncTool.setCreateTime(createTime);
          cncToolService.save(cncTool);
          return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        cncToolService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody CncTool cncTool) {
         cncToolService.update(cncTool);
         return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        CncTool cncTool = cncToolService.findById(id);
        return ResultGenerator.genSuccessResult(cncTool);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        //PageHelper.startPage(page, size);
        List<CncTool> list = cncToolService.findAll();
        // PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(list);
    }
}
