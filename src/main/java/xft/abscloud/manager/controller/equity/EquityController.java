package xft.abscloud.manager.controller.equity;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import xft.abscloud.manager.dto.JsonResult;
import xft.abscloud.manager.exception.BusinessException;
import xft.abscloud.manager.pojo.Equity;
import xft.abscloud.manager.service.equity.EquityService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/equity")
public class EquityController {

    @Resource
    private EquityService equityService;

    @RequestMapping("/add")
    public JsonResult add(@RequestBody Equity equity) throws IOException {
        try {
            equityService.add(equity);
            return JsonResult.okMsg("新增成功");
        } catch (BusinessException e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/update")
    public JsonResult update(@RequestBody Equity equity) throws IOException {
        try {
            int result = equityService.update(equity);
            return JsonResult.okWithMsg(result, "更新成功");
        } catch (BusinessException e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/query")
    public JsonResult query(@RequestParam(value = "equityId", required = true) Integer equityId) throws IOException {
        try {
            Equity result = equityService.query(equityId);
            return JsonResult.ok(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/delete")
    public JsonResult delete(@RequestParam(value = "equityId", required = true) Integer equityId) throws IOException {
        try {
            int result = equityService.delete(equityId);
            return JsonResult.ok(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    /**
     * 查询所有
     * @return
     * @throws IOException
     */
    @RequestMapping("/list")
    public JsonResult list() throws IOException {
        try {
            List<Equity> result = equityService.queryAll();
            return JsonResult.ok(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    /***
     *  分页查询
     *
     * @param params
     * @return
     */
    @PostMapping(value = "/page")
    public JsonResult queryPage(@RequestBody Map<String, Object> params) {
        int pageNum = 1;
        int pageSize = 10;
        try {
            if (params != null) {
                if (params.get("pageSize") != null) {
                    pageSize = (int) params.get("pageSize");
                }
                if (params.get("pageNum") != null) {
                    pageNum = (int) params.get("pageNum");
                }
            }
            Equity equity = BeanUtil.mapToBean(params, Equity.class, true);
            // equity.setState("1");
            PageInfo<Equity> result = equityService.queryPage(equity, pageNum, pageSize);
            return JsonResult.build(200, "查询成功", result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("查询异常");
        }
    }

}
