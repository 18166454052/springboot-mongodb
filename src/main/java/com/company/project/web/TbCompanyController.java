package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.TbCompany;
import com.company.project.service.TbCompanyService;
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
@RequestMapping("/tb/company")
public class TbCompanyController {
    @Resource
    private TbCompanyService tbCompanyService;

    @PostMapping("/add")
    public Result add(@RequestBody TbCompany tbCompany) {
          String id = UUID.randomUUID().toString().replaceAll("-", "");
          //String rfid = "xxx" + UUID.randomUUID().toString().replaceAll("-", "");
          tbCompany.setCompanyId(id);
          //tbCompany.setRfid(rfid);
          Date createTime = DateUtil.currentDate();
          tbCompany.setCreateTime(createTime);
          tbCompanyService.save(tbCompany);
          return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        tbCompanyService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody TbCompany tbCompany) {
         tbCompanyService.update(tbCompany);
         return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        TbCompany tbCompany = tbCompanyService.findById(id);
        return ResultGenerator.genSuccessResult(tbCompany);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        //PageHelper.startPage(page, size);
        List<TbCompany> list = tbCompanyService.findAll();
        // PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(list);
    }
}
