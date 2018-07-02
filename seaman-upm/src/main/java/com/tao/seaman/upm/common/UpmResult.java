package com.tao.seaman.upm.common;

import com.tao.seaman.common.base.BaseResult;
import com.tao.seaman.upm.common.enums.UpmResultEnum;

/**
 * upm系统通用结果类
 *
 * @author taojie6 2018/6/29 11:02
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2018/6/29 11:02
 * @modify by reason:{方法名}:{原因}
 */
public class UpmResult<T> extends BaseResult<T> {

    /**
     * 构造函数
     *
     * @param upmResultEnum 状态信息
     * @param data          返回的数据
     */
    public UpmResult(UpmResultEnum upmResultEnum, T data) {
        super(upmResultEnum.getCode(), upmResultEnum.getMessage(), data);
    }
}
