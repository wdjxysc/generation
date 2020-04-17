package ${packagename}.vo;
 
<#list imports as import>
import ${import};
</#list>
 
public class ${formatClassName?cap_first}VO {
 
<#list attributes as attr>
	/**
	 * ${attr.desc}
	 */
 	private ${attr.type} ${attr.name};
 	
</#list>
<#list attributes as attr>
 	public ${attr.type} get${attr.name?cap_first}() {
 		return ${attr.name};
 	}
 	
 	public void set${attr.name?cap_first}(${attr.type} ${attr.name}) {
 		this.${attr.name} = ${attr.name};
 	}
 	
</#list>
	@Override
	public String toString() {
		return "${formatClassName}VO :"<#list attributes as attr> + "，${attr.name}=" + ${attr.name} </#list>;
	}

}