package xft.abscloud.manager.controller.equity;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xft.abscloud.manager.dto.JsonResult;
import xft.abscloud.manager.pojo.DataDict;
import xft.abscloud.manager.service.equity.DataDictService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author peipei hu 下拉列表的数据保存在数据字典，用于查询数据字典信息
 */
@RestController
@Slf4j
@RequestMapping("/dataDict")
public class DataDictController {

	@Resource
	private DataDictService dataDictService;

	@RequestMapping({ "/query", "/noss/query" })
	public JsonResult queryDict(@RequestParam(value = "dictId", required = true) String dictId) {

		try {
			List<Map<String, String>> data = dataDictService.queryByKey(dictId);
			return JsonResult.ok(data);
		} catch (Exception e) {
			log.error(e.getMessage());
			return JsonResult.errorMsg("查询报错");
		}
	}

	/**
	 * 查询数据字典（批量）:传入多个dictId
	 * 
	 * @author ligaopeng
	 * @date 2019年7月1日
	 * @param
	 * @return
	 */
	@RequestMapping({ "/batchQuery", "/noss/batchQuery" })
	public JsonResult batchQueryDict(@RequestBody HashMap<String, Object> param) {

		try {
			@SuppressWarnings("unchecked")
			List<String> dictIdList = (List<String>) param.get("dictIdList");
			if (dictIdList != null && dictIdList.size() > 0) {
				List<Map<String, String>> data = dataDictService.queryDictByKeys(dictIdList);
				return JsonResult.ok(data);
			}
			return JsonResult.errorMsg("参数异常");
		} catch (Exception e) {
			log.error(e.getMessage());
			return JsonResult.errorMsg("查询报错");
		}
	}

	@RequestMapping("/add")
	public JsonResult addDict(@RequestBody DataDict dataDict) throws IOException {
		try {
			dataDictService.addDict(dataDict);
			return JsonResult.okMsg("新增成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return JsonResult.errorMsg("系统错误");
		}
	}

	@RequestMapping("/update")
	public JsonResult updateDict(@RequestBody DataDict dataDict) throws IOException {
		try {
			int result = dataDictService.updateDict(dataDict);
			return JsonResult.okWithMsg(result, "更新成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return JsonResult.errorMsg("系统错误");
		}
	}

	@RequestMapping("/delete")
	public JsonResult deleteDict(@RequestBody DataDict dataDict) throws IOException {
		try {
			int result = dataDictService.deleteDict(dataDict);
			return JsonResult.okWithMsg(result, "删除成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return JsonResult.errorMsg("系统错误");
		}
	}

	@RequestMapping("/list")
	public JsonResult queryPage(@RequestBody HashMap<String, Object> param) throws IOException {
		try {
			int pageNum = 1;
			int pageSize = 10;
			String pageNumStr = (String) param.get("pageNum");
			if (pageNumStr != null) {
				pageNum = Integer.parseInt(pageNumStr);
			}
			String pageSizeStr = (String) param.get("pageSize");
			if (pageSizeStr != null) {
				pageSize = Integer.parseInt(pageSizeStr);
			}
			if (pageNum <= 0) {
				pageNum = 1;
			}
			if (pageSize <= 0) {
				pageSize = 10;
			}
			DataDict dataDict = new DataDict();
			BeanUtilsBean.getInstance().copyProperties(dataDict, param.get("dataDict"));
			
			PageInfo<DataDict> result = dataDictService.queryPage(dataDict, pageNum, pageSize);
			return JsonResult.ok(result);
		} catch (Exception e) {
			log.error(e.getMessage());
			return JsonResult.errorMsg("系统错误");
		}
	}
}
