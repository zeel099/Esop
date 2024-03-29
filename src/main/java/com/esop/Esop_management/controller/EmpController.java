package com.esop.Esop_management.controller;

import com.esop.Esop_management.payload.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.esop.Esop_management.response.ResponseHandler;
import com.esop.Esop_management.services.EmpService;
import com.razorpay.*;

import lombok.val;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.esop.Esop_management.response.ResponseHandler.responseBuilder;

@RestController
@RequestMapping("/api")
public class EmpController {
	
	@Autowired
	private EmpService empService;

	//@CrossOrigin(origins = "https://turbo-space-umbrella-5prwv9q494rfvvq4-3001.app.github.dev")
	@CrossOrigin(origins = "*")
	@PostMapping("/company/{cId}/plan/{pId}/register")
	public ResponseEntity<Object> createEmp( EmpDto empDto,@PathVariable Integer pId,@PathVariable Integer cId){

		EmpDto createEmployee = this.empService.createEmp(empDto,pId,cId);
		//EmpDto createdEmp = this.empService.createEmp(empDto);
		return ResponseHandler.responseBuilder("Account created successfully", HttpStatus.OK,createEmployee);
		//return new ResponseEntity<>( createdEmp, HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/{empId}")
    public ResponseEntity<Object> updateEmp(@val @RequestBody EmpDto empDto, @PathVariable("empId") Integer empId){
        EmpDto updateEmp = this.empService.updateEmp(empDto, empId);
		return ResponseHandler.responseBuilder("Plan updated successfully", HttpStatus.OK,updateEmp);

		//return ResponseEntity.ok(updateEmp);
    }
//	@CrossOrigin(origins = "*")
//	@PutMapping("/{eId}")
//	public ResponseEntity<EmpDto> updateGrantedEsop(@val @RequestBody EmpDto empDto, @PathVariable("eId") Integer eId){
//		EmpDto updateEmp = this.empService.updateGrantedEsop(empDto, eId);
//		return ResponseEntity.ok(updateEmp);
//	}
	//@CrossOrigin(origins = "http://localhost:3000")
	@CrossOrigin(origins = "*")
	@DeleteMapping("/{empId}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("empId") Integer empId){
		EmpDto deleteEmp = this.empService.deleteEmployee(empId);
		//return new ApiResponse("Deleted Successfully",true);
		return ResponseHandler.responseBuilder("Deleted Successfully",HttpStatus.OK,deleteEmp);
	}

	//GET - user get
	@CrossOrigin(origins = "*")
	@GetMapping("/employee")
	public ResponseEntity<List<EmpDto>> getAllEmployee(){

		return ResponseEntity.ok(this.empService.getAllEmployee());
	}

	//GET - user get
	@CrossOrigin(origins = "*")
	@GetMapping("/{empId}")
	public ResponseEntity<EmpDto> getEmpById(@PathVariable Integer empId){

		return ResponseEntity.ok(this.empService.getEmpById(empId));
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/company/{cId}/employee")
	public ResponseEntity<List<EmpDto>> getEmpByCompany(@PathVariable Integer cId){

		List<EmpDto>emp = this.empService.getEmpByCompany(cId);
		ResponseEntity<List<EmpDto>> listResponseEntity = new ResponseEntity<>(emp, HttpStatus.OK);
		return listResponseEntity;
		//return new ResponseEntity<>(plans, HttpStatus.OK);
		//return new ResponseEntity<List<VestingPlanDto>>(plans,HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/plan/{pId}/employee")
	public ResponseEntity<List<EmpDto>> getEmpByPlan(@PathVariable Integer pId){

		List<EmpDto>emp = this.empService.getEmpByPlan(pId);
		ResponseEntity<List<EmpDto>> listResponseEntity = new ResponseEntity<>(emp, HttpStatus.OK);
		//return listResponseEntity;
        return new ResponseEntity<>(emp, HttpStatus.OK);
		//return new ResponseEntity<List<VestingPlanDto>>(plans,HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/employee/search/{keyword}")
	public ResponseEntity<List<EmpDto>> searchEmp(@PathVariable("keyword") String keyword){
		List<EmpDto>result = this.empService.searchEmp(keyword);
		return new ResponseEntity<List<EmpDto>>(result,HttpStatus.OK);
	}

//	@PostMapping("/buy")
//	@ResponseBody
//	public String createOrder(@RequestBody Map<String,Object>data) throws RazorpayException {
//		int amt = Integer.parseInt(data.get("amount").toString());
//		var razorpayClient = new RazorpayClient("rzp_test_DWlfrPAoNNsfIf","PNTFVBO3X4gTma3m2d7wLUzE");
//		JSONObject options = new JSONObject();
//		options.put("amt", amt*1000);
//		options.put("currency", "INR");
//		options.put("receipt", "txn_123456");
//		Order order = razorpayClient.Orders.create(options);
//
//		System.out.println(order);
//		return "abs";
//	}
}
