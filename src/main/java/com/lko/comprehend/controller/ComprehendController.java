package com.lko.comprehend.controller;

import com.lko.comprehend.model.ComprehendDto;
import com.lko.comprehend.model.TranslateDto;
import com.lko.comprehend.service.ComprehendService;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class ComprehendController {

    private final ComprehendService comprehendService;

    public ComprehendController(ComprehendService comprehendService) {
        this.comprehendService = comprehendService;
    }

    @PostMapping(value = "comprehend")
    @ResponseBody
    public Map<String, Object> comprehend(@RequestBody Map<String, String> param) {
        return comprehendService.comprehend(param);
    }

    @PostMapping(value = "translate")
    @ResponseBody
    public Map<String, Object> translate(@RequestBody Map<String, String> param) {
        return comprehendService.translate(param);
    }

    @PostMapping(value = "translateWithModel")
    @ResponseBody
    @ApiImplicitParam(name = "param", value = "{\"message\":\"안녕하세요\", \"from\":\"KOREAN\", \"to\":\"ENGLISH\"}")
    public TranslateDto.Response translateWithModel(@RequestBody TranslateDto.Request param) {
        return comprehendService.translate(param);
    }

    @PostMapping(value = "comprehendWithModel")
    @ResponseBody
    @ApiImplicitParam(name = "param", value = "{\"message\":\"안녕하세요\", \"from\":\"KOREAN\", \"to\":\"ENGLISH\"}")
    public ComprehendDto.Response comprehendWithModel(@RequestBody ComprehendDto.Request param) {
        return comprehendService.comprehend(param);
    }
}
