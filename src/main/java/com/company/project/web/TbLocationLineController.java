package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.TbLocationLine;
import com.company.project.service.TbLocationLineService;
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
@RequestMapping("/tb/location/line")
public class TbLocationLineController {
    @Resource
    private TbLocationLineService tbLocationLineService;

    @PostMapping("/add")
    public Result add(@RequestBody TbLocationLine tbLocationLine) {
          String id = UUID.randomUUID().toString().replaceAll("-", "");
          //String rfid = "xxx" + UUID.randomUUID().toString().replaceAll("-", "");
          tbLocationLine.setLineId(id);
          //tbLocationLine.setRfid(rfid);
          Date createTime = DateUtil.currentDate();
          tbLocationLine.setCreateTime(createTime);
          tbLocationLineService.save(tbLocationLine);
          return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        tbLocationLineService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody TbLocationLine tbLocationLine) {
         tbLocationLineService.update(tbLocationLine);
         return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        TbLocationLine tbLocationLine = tbLocationLineService.findById(id);
        return ResultGenerator.genSuccessResult(tbLocationLine);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        //PageHelper.startPage(page, size);
        List<TbLocationLine> list = tbLocationLineService.findAll();
        // PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(list);
    }
}
