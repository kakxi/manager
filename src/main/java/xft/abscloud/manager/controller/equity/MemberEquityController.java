package xft.abscloud.manager.controller.equity;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import xft.abscloud.manager.dto.JsonResult;
import xft.abscloud.manager.dto.MemberEquityDto;
import xft.abscloud.manager.pojo.MemberEquity;
import xft.abscloud.manager.service.equity.MemberEquityService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/memberEquity")
public class MemberEquityController {

    @Resource
    private MemberEquityService memberEquityService;

    @RequestMapping("/add")
    public JsonResult add(@RequestBody MemberEquity memberEquity) throws IOException {
        try {
            memberEquityService.add(memberEquity);
            return JsonResult.okMsg("新增成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/update")
    public JsonResult update(@RequestBody MemberEquity memberEquity) throws IOException {
        try {
            int result = memberEquityService.update(memberEquity);
            return JsonResult.okWithMsg(result, "更新成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/query")
    public JsonResult query(@RequestParam(value = "id", required = true) Integer id) throws IOException {
        try {
            MemberEquity result = memberEquityService.query(id);
            return JsonResult.ok(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/delete")
    public JsonResult delete(@RequestParam(value = "id", required = true) Integer id) throws IOException {
        try {
            int result = memberEquityService.delete(id);
            return JsonResult.ok(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    @RequestMapping("/list")
    public JsonResult queryList(@RequestParam(value = "memberId", required = true) String memberId) throws IOException {
        try {
            List<MemberEquity> result = memberEquityService.queryListByMemberId(memberId);
            return JsonResult.ok(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }

    /**
     * 初始化会员权益
     * @param memberId
     * @param levelId
     * @return
     * @throws IOException
     */
    @RequestMapping("/initMember")
    public JsonResult initMember(@RequestParam(value = "memberId", required = true) String memberId, @RequestParam(value = "levelId", required = true) String levelId) throws IOException {
        try {
            memberEquityService.initMemberEquity(memberId, levelId);
            return JsonResult.ok();
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }


    /**
     * 查询会员权益
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/queryMemberEquityPage")
    public @ResponseBody
    JsonResult queryMemberEquityPage(Integer pageNum, Integer pageSize){

        PageInfo<MemberEquityDto> pageInfo = memberEquityService.queryMemberEquityPage(pageNum, pageSize);

        return JsonResult.build(200, "查询会员权益成功", pageInfo);
    }


    /**
     * 修改会员权益
     * @param memberEquityDto
     * @return
     */
    @RequestMapping("/updateMemberEquity")
    public @ResponseBody JsonResult updateMemberEquity(MemberEquityDto memberEquityDto){

        try {
            memberEquityService.updateMemberEquity(memberEquityDto);
            return JsonResult.ok("更新成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            return JsonResult.errorMsg("系统错误");
        }
    }
}
