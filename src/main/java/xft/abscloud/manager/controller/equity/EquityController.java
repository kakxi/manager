package xft.abscloud.manager.controller.equity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xft.abscloud.manager.service.equity.EquityService;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/equity")
public class EquityController {

    @Resource
    private EquityService equityService;



}
