package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.CncFixture;
import com.company.project.service.CncFixtureService;
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
@RequestMapping("/cnc/fixture")
public class CncFixtureController {
    @Resource
    private CncFixtureService cncFixtureService;

    @PostMapping("/add")
    public Result add(@RequestBody CncFixture cncFixture) {
          String id = UUID.randomUUID().toString().replaceAll("-", "");
          String rfid = "fixture_" + UUID.randomUUID().toString().replaceAll("-", "");
          cncFixture.setFixtureId(id);
          cncFixture.setRfid(rfid);
          Date createTime = DateUtil.currentDate();
          cncFixture.setCreateTime(createTime);
          cncFixtureService.save(cncFixture);
          return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        cncFixtureService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody CncFixture cncFixture) {
         cncFixtureService.update(cncFixture);
         return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        CncFixture cncFixture = cncFixtureService.findById(id);
        return ResultGenerator.genSuccessResult(cncFixture);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        //PageHelper.startPage(page, size);
        List<CncFixture> list = cncFixtureService.findAll();
        // PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(list);
    }
}
