package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.CncProduct;
import com.company.project.service.CncProductService;
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
@RequestMapping("/cnc/product")
public class CncProductController {
    @Resource
    private CncProductService cncProductService;

    @PostMapping("/add")
    public Result add(@RequestBody CncProduct cncProduct) {
          String id = UUID.randomUUID().toString().replaceAll("-", "");
          String rfid = "product_" + UUID.randomUUID().toString().replaceAll("-", "");
          cncProduct.setProductId(id);
          cncProduct.setRfid(rfid);
          Date createTime = DateUtil.currentDate();
          cncProduct.setCreateTime(createTime);
          cncProductService.save(cncProduct);
          return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        cncProductService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody CncProduct cncProduct) {
         cncProductService.update(cncProduct);
         return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        CncProduct cncProduct = cncProductService.findById(id);
        return ResultGenerator.genSuccessResult(cncProduct);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        //PageHelper.startPage(page, size);
        List<CncProduct> list = cncProductService.findAll();
        // PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(list);
    }
}
