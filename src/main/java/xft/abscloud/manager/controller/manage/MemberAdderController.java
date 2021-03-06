package xft.abscloud.manager.controller.manage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xft.abscloud.manager.dto.JsonResult;
import xft.abscloud.manager.pojo.AbsMemberAdder;
import xft.abscloud.manager.service.manage.MemberAdderService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author zhangkan
 * @date 2020-3-25 16:44
 */
@RestController
@Slf4j
@RequestMapping("/personal")
public class MemberAdderController {
    @Resource
    private MemberAdderService memberAdderService;

    @RequestMapping("/queryAddress")
    public JsonResult queryAddress(@RequestBody AbsMemberAdder record) throws IOException {
        try {
            AbsMemberAdder asMemberAdder=memberAdderService.queryByKey(record.getId());
            return JsonResult.ok(asMemberAdder);
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/queryAddressList")
    public JsonResult queryAddressList(@RequestBody AbsMemberAdder record) throws IOException {
        try {
            List<AbsMemberAdder> list=memberAdderService.queryList(record);
            return JsonResult.ok(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/addAddress")
    public JsonResult addAddress(@RequestBody AbsMemberAdder record) throws IOException {
        try {
            memberAdderService.insert(record);
            return JsonResult.okMsg("新增成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/deleteAddress")
    public JsonResult deleteAddress(@RequestBody AbsMemberAdder record) throws IOException {
        try {
            memberAdderService.delete(record);
            return JsonResult.okMsg("删除成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/updateAddress")
    public JsonResult updateAddress(@RequestBody AbsMemberAdder record) throws IOException {
        try {
            memberAdderService.update(record);
            return JsonResult.okMsg("更新成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }
}
