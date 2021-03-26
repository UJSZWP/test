package com.example.chopeeweb.controller;

import com.example.chopeebiz.dto.DictDto;
import com.example.chopeebiz.dto.QueryUserListDto;
import com.example.chopeebiz.dto.UserListDto;
import com.example.chopeebiz.enums.UserTypeEnum;
import com.example.chopeedao.po.User;
import com.example.chopeeservice.EnumService;
import com.example.chopeeservice.UserService;
import com.example.chopeeservice.dto.UserRoleDto;
import com.example.chopeeweb.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 枚举
 */
@RestController
@RequestMapping("/api/enum")
public class EnumController {
    @Autowired
    private EnumService enumService;

    private static final String PRODUCT_CATEGORY = "productCategory";

    private static final String ORDER_STATUS = "orderStatus";

    private static final String USER_ROLE = "userRole";

    /**
     * 商品分类
     * @param
     * @return
     */
    @RequestMapping(value ="/productCategory",method = RequestMethod.POST)
    public Result<DictDto> getProductCategoryEnum() {
        List<DictDto> dictDtoList = enumService.getDictData(PRODUCT_CATEGORY);
        return Result.builder().data(dictDtoList,Result.SUCCESS,"").build();
    }

    /**
     * 订单状态
     * @param
     * @return
     */
    @RequestMapping(value ="/orderStatus",method = RequestMethod.POST)
    public Result<DictDto> getOrderStatusEnum() {
        List<DictDto> dictDtoList = enumService.getDictData(ORDER_STATUS);
        return Result.builder().data(dictDtoList,Result.SUCCESS,"").build();
    }

    /**
     * 用户分类
     * @param
     * @return
     */
    @RequestMapping(value ="/userRole",method = RequestMethod.POST)
    public Result<DictDto> getUserRoleEnum() {
        List<DictDto> dictDtoList = enumService.getDictData(USER_ROLE);
        return Result.builder().data(dictDtoList,Result.SUCCESS,"").build();
    }

}
