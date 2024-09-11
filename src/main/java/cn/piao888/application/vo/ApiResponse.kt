package cn.piao888.application.vo


class ApiResponse<T> @JvmOverloads constructor(
    val datas: T,
    val respCode: Int? = 200,
    val respMsg: String? = "成功",
    val sno: String ?= "",
)