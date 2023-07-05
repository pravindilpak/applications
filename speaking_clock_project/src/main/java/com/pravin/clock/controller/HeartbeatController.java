package com.pravin.clock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.pravin.clock.vo.BaseVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Controller for providing healthCheck
 * 
 * @author pravin.dilpak
 * @since 05-07-2023
 *
 */
@EnableSwagger2
@RestController
@RequestMapping("/ws")
@Api(value = "HeartBeat", tags = "Operations pertaining to HeartBeat")
public class HeartbeatController {
	
	@ApiOperation(value = "Check HeartBeat")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Running"),
	@ApiResponse(code = 401, message = "Unauthorized"),
	@ApiResponse(code = 403, message = "Access Forbidden"),
	@ApiResponse(code = 404, message = "Resource not found") })
	@RequestMapping(value = "/isAlive", method = RequestMethod.GET, produces = {"application/json"})
	public String getIsAlive()
	{
		BaseVO baseVO = new BaseVO();
		baseVO.setCode(0);
		baseVO.setMessage("Alive");
		JsonObject jsonObject = new JsonObject();
		Gson gson = new GsonBuilder().create();
		String baseVOJson = gson.toJson(baseVO);
		jsonObject.addProperty("isAlive", baseVOJson);
		return jsonObject.toString();
	}
}
