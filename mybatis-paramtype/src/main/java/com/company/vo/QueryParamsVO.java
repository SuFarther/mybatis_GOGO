package com.company.vo;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName QueryParamsVO
 * @company 公司
 * @Description 对象传参
 * @createTime 2021年10月06日 22:50:50
 */
public class QueryParamsVO {

    private String paramName;
    private Integer paramAge;

    public QueryParamsVO(){

    }
    public QueryParamsVO(String paramName, Integer paramAge) {
        this.paramName = paramName;
        this.paramAge = paramAge;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Integer getParamAge() {
        return paramAge;
    }

    public void setParamAge(Integer paramAge) {
        this.paramAge = paramAge;
    }

    @Override
    public String toString() {
        return "QueryParamsVO{" +
                "paramName='" + paramName + '\'' +
                ", paramAge=" + paramAge +
                '}';
    }
}
