package xft.abscloud.manager.controller.manage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xft.abscloud.manager.dto.JsonResult;
import xft.abscloud.manager.pojo.AbsMemberUser;
import xft.abscloud.manager.service.manage.MemberManageService;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author zhangkan
 * @date 2020-3-25 16:41
 */
@RestController
@Slf4j
@RequestMapping("/manage")
public class MemberManageController {
    
    @Resource
    private MemberManageService memberManageService;

    @RequestMapping("/queryMember")
    public JsonResult queryMember(@RequestBody Object key) throws IOException {
        try {
            memberManageService.queryByKey(key);
            return JsonResult.okMsg("查询成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/addMenber")
    public JsonResult addMenber(@RequestBody AbsMemberUser record) throws IOException {
        try {
            memberManageService.insert(record);
            return JsonResult.okMsg("新增成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/deleteMenber")
    public JsonResult deleteMenber(@RequestBody AbsMemberUser record) throws IOException {
        try {
            memberManageService.delete(record);
            return JsonResult.okMsg("删除成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/updateMember")
    public JsonResult updateMember(@RequestBody AbsMemberUser record) throws IOException {
        try {
            memberManageService.update(record);
            return JsonResult.okMsg("更新成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }
}
