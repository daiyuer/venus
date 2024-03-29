package com.max.venus.common.service.hibernate;

import com.max.venus.common.dto.DataGridReturnData;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * hibernate基础业务逻辑接口 仅供框架内部使用！！！ 外部使用请使用BaseService！！！
 * 
 * @author
 * 
 * @param <T>
 *            实体类
 */
public interface HibernateBaseService<T> {

	/**
	 * 得到spring提供的HibernateTemplate
	 * 
	 * @return
	 */
	 HibernateTemplate getHibernateTemplate();

	/**
	 * 获取序列的下一个值
	 * 
	 * @param seqName
	 *            序列名称
	 * @return 序列下一个值
	 */
	 Long getSeqNextvalByHibernate(String seqName);

	/**
	 * 通过sql获取单个数据
	 * 
	 * @param sql 语句
	 * @return
	 */
	 Object getObjectBySqlByHibernate(String sql);

	/**
	 * 从sql语句中获取String
	 * 
	 * @param sql
	 *            sql语句
	 * @return
	 */
	 String getStringBySqlByHibernate(String sql);

	/**
	 * 从sql语句中获取String
	 * 
	 * @param sql
	 *            sql语句
	 * @return
	 */
	 long getLongBySqlByHibernate(String sql);

	/**
	 * 保存一个对象
	 * 
	 * @param o
	 *            对象
	 * @return 对象的ID
	 */
	 Serializable saveByHibernate(T o);

	/**
	 * 保存对象列表
	 * 
	 * @param o
	 *            对象
	 * @return 对象的ID
	 */
	 Serializable saveListByHibernate(List<T> o);

	/**
	 * 删除一个对象
	 * 
	 * @param o
	 *            对象
	 */
	 void deleteByHibernate(T o);

	/**
	 * 更新一个对象
	 * 
	 * @param o
	 *            对象
	 */
	 void updateByHibernate(T o);

	/**
	 * 保存或更新一个对象
	 * 
	 * @param o
	 *            对象
	 */
	 void saveOrUpdateByHibernate(T o);

	/**
	 * 通过主键获得对象
	 * 
	 * @param id
	 *            主键
	 * @return 对象
	 */
	 T getByIdByHibernate(Serializable id);

	/**
	 * 通过HQL语句获取一个对象
	 * 
	 * @param hql
	 *            HQL语句
	 * @return 对象
	 */
	 T getByHql(String hql);

	/**
	 * 通过HQL语句获取一个对象
	 * 
	 * @param hql
	 *            HQL语句
	 * @param params
	 *            参数
	 * @return 对象
	 */
	 T getByHql(String hql, Map<String, Object> params);

	/**
	 * 获得对象列表
	 * 
	 * @return
	 */
	 List<T> findListByHibernate();

	/**
	 * 获得对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @return List
	 */
	 List<T> findListByHibernate(String hql);

	/**
	 * 获得对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @param params
	 *            参数
	 * @return List
	 */
	 List<T> findListByHibernate(String hql, Map<String, Object> params);

	/**
	 * 获得分页后的对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @param page
	 *            要显示第几页
	 * @param size
	 *            每页显示多少条
	 * @return List
	 */
	 List<T> findListByHibernate(String hql, int page, int size);

	/**
	 * 获得分页后的对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @param params
	 *            参数
	 * @param page
	 *            要显示第几页
	 * @param size
	 *            每页显示多少条
	 * @return List
	 */
	 List<T> findListByHibernate(String hql, Map<String, Object> params, int page, int size);

	/**
	 * 获得对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @param resultTransformerCalss
	 *            结果集需要转化为另个POJO的类
	 * @return List 里实际是resultTransformerCalss类型的 需要时自行转型
	 */
	 List findByHql(String hql, Class resultTransformerCalss);

	/**
	 * 获得对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @param params
	 *            参数
	 * @param resultTransformerCalss
	 *            结果集需要转化为另个POJO的类
	 * @return List 里实际是resultTransformerCalss类型的 需要时自行转型
	 */
	 List findByHql(String hql, Map<String, Object> params, Class resultTransformerCalss);

	/**
	 * 获得分页后的对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @param page
	 *            要显示第几页
	 * @param size
	 *            每页显示多少条
	 * @param resultTransformerCalss
	 *            结果集需要转化为另个POJO的类
	 * @return List 里实际是resultTransformerCalss类型的 需要时自行转型
	 */
	 List findByHql(String hql, int page, int size, Class resultTransformerCalss);

	/**
	 * 获得分页后的对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @param params
	 *            参数
	 * @param page
	 *            要显示第几页
	 * @param size
	 *            每页显示多少条
	 * @param resultTransformerCalss
	 *            结果集需要转化为另个POJO的类
	 * @return List 里实际是resultTransformerCalss类型的 需要时自行转型
	 */
	 List findByHql(String hql, Map<String, Object> params, int page, int size, Class resultTransformerCalss);

	/**
	 * 获得分页后的对象列表
	 * 
	 * @param page int
	 * @param size int
	 * @return
	 */
	 List<T> findListByHibernate(int page, int size);

	/**
	 * 获得分页后的对象列表
	 * 
	 * @param page  int
	 * @param size int
	 * @return
	 */
	 DataGridReturnData<T> findGridDataByHibernate(int page, int size);

	/**
	 * 获得分页后的对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @param page
	 *            要显示第几页
	 * @param size
	 *            每页显示多少条
	 * @return List
	 */
	 DataGridReturnData<T> findGridDataByHibernate(String hql, int page, int size);

	/**
	 * 获得分页后的对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @param params
	 *            参数
	 * @param page
	 *            要显示第几页
	 * @param size
	 *            每页显示多少条
	 * @return List
	 */
	 DataGridReturnData<T> findGridDataByHibernate(String hql, Map<String, Object> params, int page, int size);

	/**
	 * 获得分页后的对象列表
	 * 
	 * @param data DataGridReturnData
	 * @return
	 */
	 DataGridReturnData<T> findGridDataByHibernate(DataGridReturnData<T> data);

	/**
	 * 获得分页后的对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @return List
	 */
	 DataGridReturnData<T> findGridDataByHibernate(DataGridReturnData<T> data, String hql);

	/**
	 * 获得分页后的对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @param params
	 *            参数
	 * @return List
	 */
	 DataGridReturnData<T> findGridDataByHibernate(DataGridReturnData<T> data, String hql, Map<String, Object> params);

	/**
	 * 统计数目
	 * 
	 * @param hql
	 *            HQL语句(select count(*) from T)
	 * @return long
	 */
	 Long countByHibernate(String hql);

	/**
	 * 统计数目
	 * 
	 * @param hql
	 *            HQL语句(select count(*) from T where xx = :xx)
	 * @param params
	 *            参数
	 * @return long
	 */
	 Long countByHibernate(String hql, Map<String, Object> params);

	/**
	 * 统计数目
	 * 
	 * @return long
	 */
	 Long countByHibernate();

	/**
	 * 执行一条HQL语句
	 * 
	 * @param hql
	 *            HQL语句
	 * @return 响应结果数目
	 */
	 int executeHql(String hql);

	/**
	 * 执行一条HQL语句
	 * 
	 * @param hql
	 *            HQL语句
	 * @param params
	 *            参数
	 * @return 响应结果数目
	 */
	 int executeHql(String hql, Map<String, Object> params);

	/**
	 * 获得结果集
	 * 
	 * @param sql
	 *            SQL语句
	 * @return 结果集
	 */
	 List<?> findBySqlByHibernate(String sql);

	/**
	 * 获得结果集
	 * 
	 * @param sql
	 *            SQL语句
	 * @param page
	 *            要显示第几页
	 * @param size
	 *            每页显示多少条
	 * @return 结果集
	 */
	 List<?> findBySqlByHibernate(String sql, int page, int size);

	/**
	 * 获得结果集
	 * 
	 * @param sql
	 *            SQL语句
	 * @param params
	 *            参数
	 * @return 结果集
	 */
	 List<?> findBySqlByHibernate(String sql, Map<String, Object> params);

	/**
	 * 获得结果集
	 * 
	 * @param sql
	 *            SQL语句
	 * @param params
	 *            参数
	 * @param page
	 *            要显示第几页
	 * @param size
	 *            每页显示多少条
	 * @return 结果集
	 */
	 List<?> findBySqlByHibernate(String sql, Map<String, Object> params, int page, int size);

	/**
	 * 执行SQL语句
	 * 
	 * @param sql
	 *            SQL语句
	 * @return 响应行数
	 */
	 int executeSqlByHibernate(String sql);

	/**
	 * 执行SQL语句
	 * 
	 * @param sql
	 *            SQL语句
	 * @param params
	 *            参数
	 * @return 响应行数
	 */
	 int executeSqlByHibernate(String sql, Map<String, Object> params);

	/**
	 * 统计
	 * 
	 * @param sql
	 *            SQL语句
	 * @return 数目
	 */
	 BigInteger countBySqlByHibernate(String sql);

	/**
	 * 统计
	 * 
	 * @param sql
	 *            SQL语句
	 * @param params
	 *            参数
	 * @return 数目
	 */
	 BigInteger countBySqlByHibernate(String sql, Map<String, Object> params);

	/**
	 * 获得对象列表
	 * 
	 * @return List
	 */
	 List<T> findByCriteriaByHibernate(List<Criterion> criterions, List<Order> orders);

	/**
	 * 获得对象列表
	 * @return List
	 */
	 DataGridReturnData<T> findByCriteriaByHibernate(DataGridReturnData<T> data, List<Criterion> criterions,
			List<Order> orders);

	 DataGridReturnData<T> sumByCriteriaByHibernate(DataGridReturnData<T> data, List<Criterion> criterions,
			List<Order> orders, Projection projection, Map<Object, Object> titles);

	/**
	 * 
	 * 扩展 加入了多表关联时返回数据集 可能是多个表的组合的情况resultTransformerCalss是包括这些字段的dto
	 * 可以是某entity的子类或者包括所需字段的pojo
	 * 
	 * @param data DataGridReturnData
	 * @param resultTransformerCalss Class
	 * @param hql  String
	 * @param params Map
	 * @return DataGridReturnData
	 */
	DataGridReturnData findGridDataTransformerByHibernate(DataGridReturnData data, Class resultTransformerCalss, String hql,
			Map<String, Object> params);
}
