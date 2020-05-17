package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.TbGroup;
import com.company.project.service.TbGroupService;
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
@RequestMapping("/tb/group")
public class TbGroupController {
    @Resource
    private TbGroupService tbGroupService;

    @PostMapping("/add")
    public Result add(@RequestBody TbGroup tbGroup) {
          String id = UUID.randomUUID().toString().replaceAll("-", "");
          //String rfid = "xxx" + UUID.randomUUID().toString().replaceAll("-", "");
          tbGroup.setGroupId(id);
          //tbGroup.setRfid(rfid);
          Date createTime = DateUtil.currentDate();
          tbGroup.setCreateTime(createTime);
          tbGroupService.save(tbGroup);
          return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        tbGroupService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody TbGroup tbGroup) {
         tbGroupService.update(tbGroup);
         return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        TbGroup tbGroup = tbGroupService.findById(id);
        return ResultGenerator.genSuccessResult(tbGroup);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        //PageHelper.startPage(page, size);
        List<TbGroup> list = tbGroupService.findAll();
        // PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(list);
    }
}
