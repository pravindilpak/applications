package com.pravin.clock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pravin.clock.Clock;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Controller for providing clock service
 * 
 * @author pravin.dilpak
 * @since 05-07-2023
 *
 */
@EnableSwagger2
@RestController
@RequestMapping("/ws")
@Api(value = "Clock", tags = "Operations pertaining to Speaking Clock")
public class ClockController {

	
	@ApiOperation(value = "Display time in letters for speaking clock")
	  @ApiResponses(value = { @ApiResponse(code = 200, message = "Convert and display input time in letters"),
	      @ApiResponse(code = 400, message = "Invalid input"),
	      @ApiResponse(code = 401, message = "Unauthorized"),
	      @ApiResponse(code = 403, message = "Access Forbidden"),
	      @ApiResponse(code = 404, message = "Resource not found") })
	@RequestMapping(value = "/display", method = RequestMethod.GET, produces = {"application/json"})
	public String getDisplay(@RequestParam String timeFormat)
	{
		String result = "";
		try
		{
			Clock clock = new Clock(timeFormat);
			clock.displayTime();
			result = clock.getResult();

		}
		catch( Exception e )
		{
			result = "Invalid input :"+timeFormat;
		}
		return result;
	}
	
}
