package com.example.chopeebiz.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
public class ProductInsertDto implements Serializable{


    private String productNum;

    @NotBlank(message = "商品编号不能为空！")
    private String productName;

    @NotBlank(message = "主图片不能为空！")
    private String coverPhotoUrl;
    private String[] detailPhotoUrl;

    @NotBlank(message = "商品价格不能为空！")
    private String productPrice;

    @NotBlank(message = "快递价格不能为空！")
    private String expressPrice;

    @NotBlank(message = "商品类型不能为空！")
    private String productCategoryId;
    private String productCategoryName;

    @Size(min=1,message = "size不能为空！")
    private String[] sizeList;

    @Size(min=1,message = "颜色不能为空！")
    private String[] colorList;
}
