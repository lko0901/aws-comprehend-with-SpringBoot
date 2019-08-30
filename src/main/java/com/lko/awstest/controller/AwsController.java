package com.lko.awstest.controller;

import com.lko.awstest.model.ComprehendDto;
import com.lko.awstest.model.TranslateDto;
import com.lko.awstest.service.TranslateService;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class AwsController {

    private final TranslateService translateService;

    public AwsController(TranslateService translateService) {
        this.translateService = translateService;
    }

    @PostMapping(value = "comprehend")
    @ResponseBody
    public Map<String, Object> comprehend(@RequestBody Map<String, String> param) {
        return translateService.comprehend(param);
    }

    @PostMapping(value = "translate")
    @ResponseBody
    public Map<String, Object> translate(@RequestBody Map<String, String> param) {
        return translateService.translate(param);
    }

    @PostMapping(value = "translateWithModel")
    @ResponseBody
    @ApiImplicitParam(name = "param", value = "{\"message\":\"안녕하세요\", \"from\":\"KOREAN\", \"to\":\"ENGLISH\"}")
    public TranslateDto.Response translateWithModel(@RequestBody TranslateDto.Request param) {
        return translateService.translate(param);
    }

    @PostMapping(value = "comprehendWithModel")
    @ResponseBody
    @ApiImplicitParam(name = "param", value = "{\"message\":\"안녕하세요\", \"from\":\"KOREAN\", \"to\":\"ENGLISH\"}")
    public ComprehendDto.Response comprehendWithModel(@RequestBody ComprehendDto.Request param) {
        return translateService.comprehend(param);
    }
}
