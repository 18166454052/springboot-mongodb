package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.CncHilt;
import com.company.project.service.CncHiltService;
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
@RequestMapping("/cnc/hilt")
public class CncHiltController {
    @Resource
    private CncHiltService cncHiltService;

    @PostMapping("/add")
    public Result add(@RequestBody CncHilt cncHilt) {
          String id = UUID.randomUUID().toString().replaceAll("-", "");
          String rfid = "hilt_" + UUID.randomUUID().toString().replaceAll("-", "");
          cncHilt.setHiltId(id);
          cncHilt.setRfid(rfid);
          Date createTime = DateUtil.currentDate();
          cncHilt.setCreateTime(createTime);
          cncHiltService.save(cncHilt);
          return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        cncHiltService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody CncHilt cncHilt) {
         cncHiltService.update(cncHilt);
         return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        CncHilt cncHilt = cncHiltService.findById(id);
        return ResultGenerator.genSuccessResult(cncHilt);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        //PageHelper.startPage(page, size);
        List<CncHilt> list = cncHiltService.findAll();
        // PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(list);
    }
}
