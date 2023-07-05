package com.pravin.clock.vo;
import java.io.Serializable;

public class BaseVO implements Serializable
{
	private static final long	serialVersionUID	= 1L;
	private Integer						code;
	private String						message;
	private Integer						customerId;
	private Integer						departmentId;
	
	public BaseVO()
	{
		
	}
	
	public BaseVO(Integer code)
	{
		this.code = code;
	}
	
	public BaseVO(String message)
	{
		this.message = message;
	}
	
	public BaseVO(Integer code, String message)
	{
		this.code = code;
		this.message = message;
	}
	
	public Integer getCode()
	{
		return code;
	}
	
	public void setCode(Integer code)
	{
		this.code = code;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public Integer getCustomerId()
	{
		return customerId;
	}
	
	public void setCustomerId(Integer customerId)
	{
		this.customerId = customerId;
	}
	
	public Integer getDepartmentId()
	{
		return departmentId;
	}
	
	public void setDepartmentId(Integer departmentId)
	{
		this.departmentId = departmentId;
	}
	
	@Override
	public String toString()
	{
		return "BaseVO [code=" + code + ", message=" + message + ", customerId=" + customerId
				+ ", departmentId=" + departmentId + "]";
	}
	
}