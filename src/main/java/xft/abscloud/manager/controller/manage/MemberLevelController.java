package xft.abscloud.manager.controller.manage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xft.abscloud.manager.dto.JsonResult;
import xft.abscloud.manager.pojo.AbsMemberLevel;
import xft.abscloud.manager.pojo.Event;
import xft.abscloud.manager.service.manage.MemberAdderService;
import xft.abscloud.manager.service.manage.MemberLevelService;
import xft.abscloud.manager.service.manage.UserManageService;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author zhangkan
 * @date 2020-3-25 16:41
 */
@RestController
@Slf4j
@RequestMapping("/level")
public class MemberLevelController {

    @Resource
    private MemberLevelService memberLevelService;

    @RequestMapping("/queryLevel")
    public JsonResult queryLevel(@RequestBody Object key) throws IOException {
        try {
            memberLevelService.queryByKey(key);
            return JsonResult.okMsg("查询成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/addLevel")
    public JsonResult addLevel(@RequestBody AbsMemberLevel record) throws IOException {
        try {
            memberLevelService.insert(record);
            return JsonResult.okMsg("新增成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/deleteLevel")
    public JsonResult deleteLevel(@RequestBody AbsMemberLevel record) throws IOException {
        try {
            memberLevelService.delete(record);
            return JsonResult.okMsg("删除成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/updateLevel")
    public JsonResult updateLevel(@RequestBody AbsMemberLevel record) throws IOException {
        try {
            memberLevelService.update(record);
            return JsonResult.okMsg("更新成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }
}
