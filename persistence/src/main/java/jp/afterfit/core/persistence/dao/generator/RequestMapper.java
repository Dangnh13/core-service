package jp.afterfit.core.persistence.dao.generator;

import java.util.List;
import jp.afterfit.core.domain.entity.generator.Request;
import jp.afterfit.core.domain.entity.generator.RequestCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface RequestMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request
     *
     * @mbg.generated
     */
    long countByExample(RequestCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request
     *
     * @mbg.generated
     */
    int deleteByExample(RequestCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request
     *
     * @mbg.generated
     */
    int insert(Request record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request
     *
     * @mbg.generated
     */
    int insertSelective(Request record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request
     *
     * @mbg.generated
     */
    List<Request> selectByExampleWithRowbounds(RequestCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request
     *
     * @mbg.generated
     */
    List<Request> selectByExample(RequestCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request
     *
     * @mbg.generated
     */
    Request selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Request record, @Param("example") RequestCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Request record, @Param("example") RequestCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Request record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Request record);
}