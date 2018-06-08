package com.kenfo.controller;

import com.kenfo.domain.vo.Result;
import com.kenfo.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.controller
 * @Description: demo
 * @date 2018/5/12 上午2:08
 */
@RestController
@RequestMapping("/t")
@Api(value = "/t", description = "测试接口")
public class TestController {

    @GetMapping("/test")
    public Result test(){
        return ResultUtil.success("test");
    }

    @ApiOperation(value="接口名称", notes="接口详细信息")
    @ApiImplicitParam(name = "id", value = "接口id", required = true, dataType = "int", paramType = "path")
    @GetMapping(value = "/test/{id}")
    public String testPath(@PathVariable(value = "id") Integer id){
        return "";
    }

    @ApiOperation(value="接口名称", notes="接口详细信息")
    @ApiImplicitParam(name = "id", value = "接口id", required = true, dataType = "int", paramType = "query")
    @GetMapping(value = "/test1")
    public String testQuery(@RequestParam(value = "id") Integer id){
        return "";
    }


}
