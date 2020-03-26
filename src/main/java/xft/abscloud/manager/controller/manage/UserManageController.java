package xft.abscloud.manager.controller.manage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xft.abscloud.manager.dto.JsonResult;
import xft.abscloud.manager.pojo.EnterprRegUser;
import xft.abscloud.manager.service.manage.UserManageService;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author zhangkan
 * @date 2020-3-25 16:41
 */
@RestController
@Slf4j
@RequestMapping("/usermanage")
public class UserManageController {

    @Resource
    private UserManageService userManageService;

    @RequestMapping("/queryUser")
    public JsonResult queryUser(@RequestBody Object key) throws IOException {
        try {
            userManageService.queryByKey(key);
            return JsonResult.okMsg("查询成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/addUser")
    public JsonResult addUser(@RequestBody EnterprRegUser record) throws IOException {
        try {
            userManageService.insert(record);
            return JsonResult.okMsg("新增成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/deleteUser")
    public JsonResult deleteUser(@RequestBody EnterprRegUser record) throws IOException {
        try {
            userManageService.delete(record);
            return JsonResult.okMsg("删除成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/updateUser")
    public JsonResult updateUser(@RequestBody EnterprRegUser record) throws IOException {
        try {
            userManageService.update(record);
            return JsonResult.okMsg("更新成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }
}
