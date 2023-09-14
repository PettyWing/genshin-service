package com.example.uumemory.mappers;

import com.example.uumemory.entity.Relics;
import com.example.uumemory.entity.RelicsParam;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RelicsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relics
     *
     * @mbg.generated Thu Sep 14 10:24:21 CST 2023
     */
    long countByExample(RelicsParam example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relics
     *
     * @mbg.generated Thu Sep 14 10:24:21 CST 2023
     */
    int deleteByExample(RelicsParam example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relics
     *
     * @mbg.generated Thu Sep 14 10:24:21 CST 2023
     */
    int insert(Relics record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relics
     *
     * @mbg.generated Thu Sep 14 10:24:21 CST 2023
     */
    int insertSelective(Relics record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relics
     *
     * @mbg.generated Thu Sep 14 10:24:21 CST 2023
     */
    List<Relics> selectByExample(RelicsParam example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relics
     *
     * @mbg.generated Thu Sep 14 10:24:21 CST 2023
     */
    int updateByExampleSelective(@Param("record") Relics record, @Param("example") RelicsParam example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relics
     *
     * @mbg.generated Thu Sep 14 10:24:21 CST 2023
     */
    int updateByExample(@Param("record") Relics record, @Param("example") RelicsParam example);
}