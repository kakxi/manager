package xft.abscloud.manager.controller.equity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xft.abscloud.manager.dto.JsonResult;
import xft.abscloud.manager.dto.PackDto;
import xft.abscloud.manager.exception.BusinessException;
import xft.abscloud.manager.service.equity.LevelEquityService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/pack")
public class LevelEquityController {

    @Resource
    private LevelEquityService levelEquityService;

    @RequestMapping("/save")
    public JsonResult add(@RequestBody PackDto packDto) throws IOException {
        try {
            levelEquityService.save(packDto.getLevelId(), packDto.getEquityList());
            return JsonResult.okMsg("新增成功");
        } catch (BusinessException e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/query")
    public JsonResult query(@RequestParam(value = "levelId", required = true) Integer levelId) throws IOException {
        try {
            List<Map<String, Object>> result = levelEquityService.query(levelId);
            return JsonResult.ok(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/delete")
    public JsonResult delete(@RequestParam(value = "levelId", required = true) Integer levelId) throws IOException {
        try {
            int result = levelEquityService.delete(levelId);
            return JsonResult.ok(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

}
