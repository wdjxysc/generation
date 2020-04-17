<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packagename}.dao.${formatClassName?cap_first}DAO">
		<resultMap type="${packagename}.vo.${formatClassName?cap_first}VO" id="${formatClassName?cap_first}Map">
			<#list attributes as attr>
				<#if attr.dbtype?upper_case == 'DATETIME'>
			<result column="${attr.dbname}" property="${attr.name}" jdbcType="DATE" />
				<#elseif attr.dbtype?upper_case == 'INT'>
			<result column="${attr.dbname}" property="${attr.name}" jdbcType="INTEGER" />
				<#elseif attr.dbtype?upper_case == 'TEXT'>
			<result column="${attr.dbname}" property="${attr.name}" jdbcType="VARCHAR" />
				<#else>
			<result column="${attr.dbname}" property="${attr.name}" jdbcType="${attr.dbtype?upper_case}" />
				</#if>
			</#list>
		</resultMap>
		<!-- 新增 -->
    	<insert id="insert${formatClassName?cap_first}" parameterType="${packagename}.vo.${formatClassName?cap_first}VO">
    		insert into ${tableName}(
    		<#if attributes?exists>
    			<#list attributes as attr>
    				<#if attr_index == attributes?size - 1>
    			${attr.dbname}
    				</#if>
    				<#if attr_index < attributes?size - 1>
    			${attr.dbname},
    				</#if>
    			</#list>
    		</#if>
    		)values(
    			<#list attributes as attr>
    				<#if attr_index == attributes?size - 1>
    			${r'#{'}${attr.name}}
    				</#if>
    				<#if attr_index < attributes?size - 1>
    			${r'#{'}${attr.name}},
    				</#if>
    			</#list>
    		)
    	</insert>
    	<!-- 删除 -->
    	<delete id="delete${formatClassName?cap_first}" parameterType="${packagename}.vo.${formatClassName?cap_first}VO">
    		delete from ${tableName}
    		<where>
    			<#list attributes as attr>
	    			<if test="${attr.name} != null" >
	    		and ${attr.dbname} = ${r'#{'}${attr.name}}
	    			</if>
    			</#list>
    		</where>
    	</delete>
    	<!-- 更新 -->
    	<update id="update${formatClassName?cap_first}" parameterType="${packagename}.vo.${formatClassName?cap_first}VO">
    		update ${tableName}
    		<set>
    			<#list attributes as attr>
	    			<if test="${attr.name} != null" >
	    		${attr.dbname} = ${r'#{'}${attr.name}},
	    			</if>
    			</#list>
    		</set>
    		<where>
    			<#list attributes as attr>
	    			<if test="${attr.name} != null" >
	    		and ${attr.dbname} = ${r'#{'}${attr.name}}
	    			</if>
    			</#list>
    		</where>
    	</update>
    	<!-- 查询列表 -->
    	<select id="list${formatClassName?cap_first}" parameterType="${packagename}.vo.${formatClassName?cap_first}VO" resultMap="${formatClassName?cap_first}Map">
    		select * from ${tableName}
    		<where>
    			<#list attributes as attr>
	    			<if test="${attr.name} != null" >
	    		and ${attr.dbname} = ${r'#{'}${attr.name}}
	    			</if>
    			</#list>
    		</where>
    	</select>
</mapper>