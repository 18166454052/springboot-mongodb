package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Cnc;
import com.company.project.service.CncService;
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
* Created by CodeGenerator on 2020/05/14.
*/
@RestController
@RequestMapping("/cnc")
public class CncController {
    @Resource
    private CncService cncService;

    @PostMapping("/add")
    public Result add(@RequestBody Cnc cnc) {
        String cncId = UUID.randomUUID().toString().replaceAll("-", "");
        String rfid = "xxx" + UUID.randomUUID().toString().replaceAll("-", "");
        cnc.setCncId(cncId);
        //cnc.setRfid(rfid);
        Date createTime = DateUtil.currentDate();
        cnc.setCreateTime(createTime);
        cncService.save(cnc);

        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        cncService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
    @PostMapping("/update")
    public Result update(@RequestBody Cnc cnc) {
         cncService.update(cnc);
         return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String  id) {
        Cnc cnc = cncService.findById(id);
        return ResultGenerator.genSuccessResult(cnc);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        //PageHelper.startPage(page, size);
        List<Cnc> list = cncService.findAll();
        // PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(list);
    }
}
