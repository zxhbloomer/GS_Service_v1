package com.perfect.core.service.sys.config.config;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.perfect.bean.entity.sys.config.config.SConfigEntity;
import com.perfect.bean.entity.sys.config.dict.SDictDataEntity;
import com.perfect.bean.pojo.result.InsertResult;
import com.perfect.bean.pojo.result.UpdateResult;
import com.perfect.bean.vo.sys.config.config.SConfigVo;
import com.perfect.bean.vo.sys.config.dict.SDictDataVo;

/**
 * <p>
 * 字典数据表 服务类
 * </p>
 *
 * @author zxh
 * @since 2019-08-23
 */
public interface ISConfigService extends IService<SConfigEntity> {
    /**
     * 获取列表，页面查询
     */
    IPage<SConfigVo> selectPage(SConfigVo searchCondition) throws InstantiationException, IllegalAccessException;

    /**
     * 获取所有数据
     */
    List<SConfigVo> select(SConfigVo searchCondition) throws InstantiationException, IllegalAccessException;

    /**
     * 获取所选id的数据
     */
    List<SConfigVo> selectIdsIn(List<SConfigVo> searchCondition) throws InstantiationException, IllegalAccessException;

    /**
     * 查询by id，返回结果
     *
     * @param id
     * @return
     */
    SConfigVo selectByid(Long id);

    /**
     * 批量导入
     */
    boolean saveBatches(List<SConfigEntity> entityList);

    /**
     * 批量删除复原
     * @param searchCondition
     * @return
     */
    void enableByIdsIn(List<SConfigVo> searchCondition);

    /**
     * 插入一条记录（选择字段，策略插入）
     * @param entity 实体对象
     * @return
     */
    InsertResult<Integer> insert(SConfigEntity entity);

    /**
     * 更新一条记录（选择字段，策略更新）
     * @param entity 实体对象
     * @return
     */
    UpdateResult<Integer> update(SConfigEntity entity);

    /**
     * 通过name查询
     *
     */
    List<SConfigEntity> selectByName(String name);

    /**
     * 通过key查询
     *
     */
    List<SConfigEntity> selectByKey(String key);

    /**
     * 通过value查询:参数键值
     *
     */
    List<SConfigEntity> selectByValue(String value);

}
