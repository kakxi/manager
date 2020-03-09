package xft.abscloud.manager.controller.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import xft.abscloud.manager.dto.JsonResult;
import xft.abscloud.manager.pojo.AbsExpense;
import xft.abscloud.manager.service.order.IExpenseService;

/**
 * 消费
 * @author lenovo
 *
 */
@RestController
@RequestMapping("/expense")
public class ExpenseController {

	@Autowired
	private IExpenseService expenseService;
	
	/**
	 * 查询线上消费记录
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@PostMapping("/queryCurrentUserConsumption")
	public @ResponseBody JsonResult queryCurrentUserConsumption(Integer pageNum, Integer pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		//获取当前用户
		//如果是管理员 查询所有用户的消费记录，否则查询当前用户的消费记录
		String userId = "1";
		List<AbsExpense> expenseList = null;
		//如果是管理员 TODO
		if("".equals(userId)) {
			expenseList = expenseService.queryExpenseList(null);
		}else {//如果不是管理员
			expenseList = expenseService.queryExpenseList(userId);
		}
        
        PageInfo<AbsExpense> pageInfo = new PageInfo<AbsExpense>(expenseList);
        
        return JsonResult.build(200, "操作成功", pageInfo);
	}
	
	
}
