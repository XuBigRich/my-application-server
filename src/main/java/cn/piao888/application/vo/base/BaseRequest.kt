package cn.piao888.application.vo.base

/**
 * @Author： hongzhi.xu
 * @Date: 2024/9/10 14:17
 * @Version 1.0
 */
abstract class BaseRequest(
    var pageNumber: Int? = 1,
    var pageSize: Int? = 10
)