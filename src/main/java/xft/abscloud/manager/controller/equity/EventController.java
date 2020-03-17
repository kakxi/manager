package xft.abscloud.manager.controller.equity;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import cn.hutool.core.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import xft.abscloud.manager.dto.JsonResult;
import xft.abscloud.manager.exception.BusinessException;
import xft.abscloud.manager.pojo.EquitySpend;
import xft.abscloud.manager.pojo.Event;
import xft.abscloud.manager.pojo.EventSignin;
import xft.abscloud.manager.service.equity.EquitySpendService;
import xft.abscloud.manager.service.equity.EventService;
import xft.abscloud.manager.service.equity.EventSigninService;

@RestController
@Slf4j
@RequestMapping("/event")
public class EventController {

    @Resource
    private EventService eventService;

    @Resource
    private EquitySpendService equitySpendService;

    @Resource
    private EventSigninService eventSigninService;

    @RequestMapping("/add")
    public JsonResult add(@RequestBody Event event) throws IOException {
        try {
            eventService.add(event);
            return JsonResult.okMsg("保存成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/update")
    public JsonResult update(@RequestBody Event event) throws IOException {
        try {
            int result = eventService.update(event);
            return JsonResult.okWithMsg(result, "更新成功");
        }catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/query")
    public JsonResult query(@RequestParam(value = "eventId", required = true) Integer eventId) throws IOException {
        try {
            Event result = eventService.query(eventId);
            return JsonResult.ok(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    /**
     * 活动发布
     * @param eventId
     * @return
     * @throws IOException
     */
    @RequestMapping("/issue")
    public JsonResult issue(@RequestParam(value = "eventId", required = true) Integer eventId) throws IOException {
        try {
            int result = eventService.issueEvent(eventId);
            return JsonResult.ok(result);
        } catch (BusinessException e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg(e.getMessage());
        }catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    /**
     * 活动取消
     * @param eventId
     * @return
     * @throws IOException
     */
    @RequestMapping("/cancel")
    public JsonResult cancel(@RequestParam(value = "eventId", required = true) Integer eventId) throws IOException {
        try {
            int result = eventService.cancelEvent(eventId);
            return JsonResult.ok(result);
        }catch (BusinessException e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/delete")
    public JsonResult delete(@RequestParam(value = "eventId", required = true) Integer eventId) throws IOException {
        try {
            int result = eventService.delete(eventId);
            return JsonResult.ok(result);
        }catch (BusinessException e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg(e.getMessage());
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
            Event event = BeanUtil.mapToBean(params, Event.class, true);
            // equity.setState("1");
            PageInfo<Event> result = eventService.queryPage(event, pageNum, pageSize);
            return JsonResult.ok(result.getList());
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("查询异常");
        }
    }

    /**
     * 活动预约
     * @param equitySpend
     * @return
     * @throws IOException
     */
    @RequestMapping("/reserve/save")
    public JsonResult saveReserve(@RequestBody EquitySpend equitySpend) throws IOException {
        try {
            int result = equitySpendService.saveReserve(equitySpend.getMemberId(),equitySpend.getEventId());
            return JsonResult.ok(result);
        }catch (BusinessException e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg(e.getMessage());
        }  catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    /**
     * 取消预约：传入消费记录id
     * @param spendId
     * @return
     * @throws IOException
     */
    @RequestMapping("/reserve/cancel")
    public JsonResult cancelReserve(@RequestParam(value = "spendId", required = true) Integer spendId) throws IOException {
        try {
            int result = equitySpendService.cancelReserve(spendId);
            return JsonResult.ok(result);
        }catch (BusinessException e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg(e.getMessage());
        }  catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    /**
     * 查看活动的预约人员列表：传入活动id
     * @param eventId
     * @return
     * @throws IOException
     */
    @RequestMapping("/reserve/userList")
    public JsonResult userList(@RequestParam(value = "eventId", required = true) Integer eventId) throws IOException {
        try {
            List<Map<String,Object>> result = equitySpendService.queryListByEventId(eventId);
            return JsonResult.ok(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    /**
     * 查看会员的消费记录：传入会员id
     * @param memberId
     * @return
     * @throws IOException
     */
    @RequestMapping("/reserve/spendList")
    public JsonResult userList(@RequestParam(value = "memberId", required = true) String memberId) throws IOException {
        try {
            List<Map<String,Object>> result = equitySpendService.queryListByMemberId(memberId);
            return JsonResult.ok(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    /**
     * 活动签到
     * @param eventSignin
     * @return
     * @throws IOException
     */
    @RequestMapping("/signin/save")
    public JsonResult signin(@RequestBody EventSignin eventSignin) throws IOException {
        try {
            int result = eventSigninService.add(eventSignin);
            return JsonResult.ok(result);
        }catch (BusinessException e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg(e.getMessage());
        }  catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    /**
     * 活动签到: 扫描二维码
     * @param spendId
     * @return
     * @throws IOException
     */
    @RequestMapping("/signin/qrcode")
    public JsonResult signin(@RequestParam(value = "spendId", required = true) Integer spendId) throws IOException {
        try {
            int result = eventSigninService.signinByQrcode(spendId);
            return JsonResult.ok(result);
        }catch (BusinessException e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg(e.getMessage());
        }  catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    /**
     * 查看活动的签到人员列表：传入活动id
     * @param eventId
     * @return
     * @throws IOException
     */
    @RequestMapping("/signin/list")
    public JsonResult signinList(@RequestParam(value = "eventId", required = true) Integer eventId) throws IOException {
        try {
            List<Map<String,Object>> result = eventSigninService.queryListByEventId(eventId);
            return JsonResult.ok(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

}
